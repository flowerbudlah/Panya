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
	
	// XML 방식?��?��?�� ?��?�� 주입?�� ?��루어�?
	// Annotation 방식?��?���? ?�� ?��
	// interceptor?��?��?�� ?��?��주입?���? Bean?�� 주입받�? 못하�?�? interceptor?��?�� ?��?��?��?�� 객체?��?? interceptor�? ?��록하?�� 곳에?�� <-- ServletAppContext.java
	// Bean?�� 주입받아?�� ?��?��?���? 받아?�� ?��?��?��?�� ?��
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		
		List<BoardDTO> topMenuList = topMenuService.getTopMenuList();
		
		request.setAttribute("topMenuList", topMenuList);
		
		return true;
	}

}
