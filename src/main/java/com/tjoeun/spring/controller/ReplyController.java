package com.tjoeun.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;

import com.tjoeun.spring.dto.ReplyDTO;
import com.tjoeun.spring.service.ReplyService;

@Controller
@RequestMapping("/board/reply")
public class ReplyController{
	
	@Autowired
	ReplyService replyService; 
	
	//댓글작성
	@PostMapping("/write")
	public String write(ReplyDTO writeReplyDTO,@RequestParam("board_idx") int board_idx, Model model) throws Exception {
		
		model.addAttribute("board_idx", board_idx);
		replyService.write(writeReplyDTO);
											//이자리에 숫자 아무거나 들어가도 상관없다. 
		return "redirect:/board/read?board_idx={board_idx}&post_idx="+writeReplyDTO.getPost_idx()+"&page=1";
	}
	
	
	//댓글삭제
	@RequestMapping("/delete")
	public void delete(int reply_idx, @RequestParam("board_idx") int board_idx, @RequestParam("post_idx") int post_idx, Model model) {
		model.addAttribute("board_idx", board_idx);
		model.addAttribute("post_idx", post_idx);
		
		replyService.delete(reply_idx);
	}
	

	
	
	
	
}


