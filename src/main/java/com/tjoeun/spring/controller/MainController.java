package com.tjoeun.spring.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.tjoeun.spring.dao.TopMenuDAO;
import com.tjoeun.spring.dto.BoardDTO;
import com.tjoeun.spring.dto.PostDTO;
import com.tjoeun.spring.service.MainService;

@Controller
public class MainController {
	
	
	@Autowired
	private MainService mainService;
	
	
	@Autowired
	private TopMenuDAO topMenuDAO;
	
	
	@GetMapping("/main")
	public String main(HttpServletRequest request, Model model) {
		System.out.println(request.getServletContext().getRealPath("/"));
		
		//Í≤åÏãú?åê Î©îÏù∏?ôîÎ©¥Ïóê ÎØ∏Î¶¨?Çò?ò§?äî Í∑∏Î?Î∂?
		List<List<PostDTO>> listAll = new ArrayList<List<PostDTO>>();
		
		
		for(int i = 1 ; i <= 2; i++ ) {
			
			List<PostDTO> mainList = mainService.getMainList(i);
  			
			listAll.add(mainList);
		
		}
		
		
		model.addAttribute("listAll", listAll);
		
		List<BoardDTO> boardNameList = topMenuDAO.getTopMenuList();
		
		model.addAttribute("boardNameList", boardNameList);
		
		return "main";
		
	}
	
	
	@GetMapping("etc/map")
	public String map() {
		return "etc/map";
	}

	@GetMapping("etc/not_admin")
	public String notAdmin() {
		return "etc/not_admin";
	}
	
	
	
	
	
	
	
}
















