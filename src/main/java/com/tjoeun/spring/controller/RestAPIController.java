package com.tjoeun.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.tjoeun.spring.service.MemberService;


@RestController
public class RestAPIController {
  
	@Autowired
	private MemberService memberService;
	
	//1. ?•„?´?”” ì¤‘ë³µì²´í¬ (?šŒ?›ê°??…?‹œ)
	@GetMapping("/member/checkID/{member_id}")
	public String checkID(@PathVariable String member_id) {
		boolean chck = memberService.checkID(member_id);
		return chck+"";
	}
	
	//2. ?´ë©”ì¼ ì¤‘ë³µì²´í¬(?šŒ?›ê°??…?‹œ, ?šŒ?›? •ë³´ìˆ˜? •?‹œ)
	@GetMapping("/member/checkEmail/{member_email}")
	public String checkEmail(@PathVariable String member_email) {
		boolean chck = memberService.checkEmail(member_email);
		return chck+"";
	}
		

	//3.?´ë©”ì¼ ì¤‘ë³µì²´í¬(?šŒ?›ê°??…?‹œ)
	@GetMapping("/member/checkEmailInModify/{member_email}")
	public String checkEmailInModify(@PathVariable String member_email) {
		boolean chck = memberService.checkEmailInModify(member_email);
		return chck+"";
	}
	
	
	
	
	
	
	
	
}