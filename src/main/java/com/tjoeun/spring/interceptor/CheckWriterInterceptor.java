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
	 1) ?˜„?¬ ë¡œê·¸?¸?•œ ?‚¬?Œ?˜ index ê°?? ¸?˜´
	  
	 2) BoardService?— getContentInfo ?Š” ê²Œì‹œê¸??„ ê°?? ¸?˜¤ë¯?ë¡? ?‘?„±?•œ ?‚¬?Œ?˜ indexë²ˆí˜¸ê°? ?ˆ?Œ. 
	  	?´ ë©”ì†Œ?“œë¥? ?˜¸ì¶œí•´?„œ ?‘?„±?•œ ?‚¬?Œ?˜ indexë²ˆí˜¸ ê°?? ¸?˜´
	  
	  XML ë°©ì‹?—?„œ?Š” ??™ì£¼ì…?´ ?˜ë¯?ë¡? ?ƒ?„±?ë¥? ?‘?„±?•˜ì§? ?•Š?•„?„ ?¨
	*/
	
	@Resource(name="loginMemberDTO")
	@Lazy
	private MemberDTO loginMemberDTO;
	
	@Autowired
	private BoardService boardService;
	
	//ë¡œê·¸?¸?•œ ?‚¬?Œê³? ?‘?„±?•œ ?‚¬?Œ?´ ê°™ì?ì§? ê²??‚¬?•˜ê¸?--?´ë²? Interceptor?Š” ?ˆ˜? •?•  ?•Œ?? ?‚­? œ?•  ?•Œë§? ë°˜ì‘?•˜?„ë¡? ?•¨
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
  	
		/*??™?œ¼ë¡? ì£¼ì…ë°›ì? ?•Š?Œ, Request ê°ì²´?— ???¥?œ ê°’ì„ getParameterë¡? ê°?? ¸?˜´*/
		int post_idx = Integer.parseInt(request.getParameter("post_idx"));
  	
		/*Request ê°ì²´ ?†?— ???¥?œ content_idx(ê¸?ë²ˆí˜¸)?— ?•´?‹¹?•˜?Š” ContentDTO ê°?? ¸?˜¤ê¸?(content_wirter_idx ê°? ?•„?š”?•´?„œ)*/ 
		PostDTO tmpPostDTO  = boardService.getPostInfo(post_idx);
  	
  	// ë¡œê·¸?¸?•œ ?‚¬?Œê³? ê¸? ?“´ ?‚¬?Œ?˜ ?šŒ?›ë²ˆí˜¸(idx)ê°? ?¼ì¹˜í•˜ì§? ?•Š?œ¼ë©? BoardController?˜ "/board/not_writer" ë¡? ?´?™?•˜ê²? ?•¨
  	if(tmpPostDTO.getPost_writer_idx() != loginMemberDTO.getMember_idx() ) {
  		String contextPath = request.getContextPath();
  			response.sendRedirect(contextPath + "/board/not_writer");
  				return false;
  	}
  		return true;
  }
  

}
