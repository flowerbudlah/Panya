package com.tjoeun.spring.interceptor;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.servlet.HandlerInterceptor;

import com.tjoeun.spring.dto.PostDTO;
import com.tjoeun.spring.dto.MemberDTO;
import com.tjoeun.spring.service.BoardService;

public class CheckWriterInterceptor implements HandlerInterceptor{
	/*
	 1) ?��?�� 로그?��?�� ?��?��?�� index �??��?��
	  
	 2) BoardService?�� getContentInfo ?�� 게시�??�� �??��?���?�? ?��?��?�� ?��?��?�� index번호�? ?��?��. 
	  	?�� 메소?���? ?��출해?�� ?��?��?�� ?��?��?�� index번호 �??��?��
	  
	  XML 방식?��?��?�� ?��?��주입?�� ?���?�? ?��?��?���? ?��?��?���? ?��?��?�� ?��
	*/
	
	@Resource(name="loginMemberDTO")
	@Lazy
	private MemberDTO loginMemberDTO;
	
	@Autowired
	private BoardService boardService;
	
	//로그?��?�� ?��?���? ?��?��?�� ?��?��?�� 같�?�? �??��?���?--?���? Interceptor?�� ?��?��?�� ?��?? ?��?��?�� ?���? 반응?��?���? ?��
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
  	
		/*?��?��?���? 주입받�? ?��?��, Request 객체?�� ???��?�� 값을 getParameter�? �??��?��*/
		int post_idx = Integer.parseInt(request.getParameter("post_idx"));
  	
		/*Request 객체 ?��?�� ???��?�� content_idx(�?번호)?�� ?��?��?��?�� ContentDTO �??��?���?(content_wirter_idx �? ?��?��?��?��)*/ 
		PostDTO tmpPostDTO  = boardService.getPostInfo(post_idx);
  	
  	// 로그?��?�� ?��?���? �? ?�� ?��?��?�� ?��?��번호(idx)�? ?��치하�? ?��?���? BoardController?�� "/board/not_writer" �? ?��?��?���? ?��
  	if(tmpPostDTO.getPost_writer_idx() != loginMemberDTO.getMember_idx() ) {
  		String contextPath = request.getContextPath();
  			response.sendRedirect(contextPath + "/board/not_writer");
  				return false;
  	}
  		return true;
  }
  

}
