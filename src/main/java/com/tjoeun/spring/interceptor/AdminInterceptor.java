package com.tjoeun.spring.interceptor;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.annotation.Lazy;
import org.springframework.web.servlet.HandlerInterceptor;

import com.tjoeun.spring.dto.MemberDTO;

//ê´?ë¦¬ìë§? ê´?ë¦¬ì?˜?´ì§??— ?…?¥?• ?ˆ˜ ?ˆ?Š” ?¸?„°?…‰?„°
public class AdminInterceptor implements HandlerInterceptor{
	
	@Resource(name="loginMemberDTO")
	@Lazy
	private MemberDTO loginMemberDTO;
	
	@Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
      
	  HttpSession session = request.getSession();
      
	  MemberDTO loginMemberDTO = (MemberDTO) session.getAttribute("loginMemberDTO");
      
	  if(loginMemberDTO.getMember_idx() == 1  ){//ì¦?, ê´?ë¦¬ìê°? ?“¤?–´?˜¨ê²½ìš° 
		  return true;
	  }
	  
	  String contextPath = request.getContextPath();
	  response.sendRedirect(contextPath + "/etc/not_admin");
	  return false;
      
    }
  }