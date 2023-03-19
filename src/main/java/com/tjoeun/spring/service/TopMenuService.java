package com.tjoeun.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tjoeun.spring.dao.TopMenuDAO;
import com.tjoeun.spring.dto.BoardDTO;

@Service
public class TopMenuService {
  // TopMenuDAO?— ?ˆ?Š” ë©”ì†Œ?“œë¥? ?˜¸ì¶œí•´?„œ ë°›ì•„?˜¨ ? •ë³´ë?? ?‚¬?š©?•´?„œ ?‘?—…?•˜?Š” ?´?˜?Š¤
	
	@Autowired
	private TopMenuDAO topMenuDAO;
  
	public List<BoardDTO> getTopMenuList() {
		List<BoardDTO> topMenuList = topMenuDAO.getTopMenuList();
			return topMenuList;
	}
	
}


