package com.tjoeun.spring.interceptor;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;

import com.tjoeun.spring.dto.BoardDTO;
import com.tjoeun.spring.service.TopMenuService;

public class TopMenuInterceptor implements HandlerInterceptor{

	@Autowired
	private TopMenuService topMenuService;
	
	// XML ë°©ì‹?—?„œ?Š” ??™ ì£¼ì…?´ ?´ë£¨ì–´ì§?
	// Annotation ë°©ì‹?—?„œë§? ?•ˆ ?¨
	// interceptor?—?„œ?Š” ??™ì£¼ì…?œ¼ë¡? Bean?„ ì£¼ì…ë°›ì? ëª»í•˜ë¯?ë¡? interceptor?—?„œ ?‚¬?š©?•˜?Š” ê°ì²´?“¤?? interceptorë¥? ?“±ë¡í•˜?Š” ê³³ì—?„œ <-- ServletAppContext.java
	// Bean?„ ì£¼ì…ë°›ì•„?„œ ?ƒ?„±?ë¡? ë°›ì•„?„œ ?‚¬?š©?•´?•¼ ?•¨
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		
		List<BoardDTO> topMenuList = topMenuService.getTopMenuList();
		
		request.setAttribute("topMenuList", topMenuList);
		
		return true;
	}

}
