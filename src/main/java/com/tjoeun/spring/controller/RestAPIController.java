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
	
	//1. ?��?��?�� 중복체크 (?��?���??��?��)
	@GetMapping("/member/checkID/{member_id}")
	public String checkID(@PathVariable String member_id) {
		boolean chck = memberService.checkID(member_id);
		return chck+"";
	}
	
	//2. ?��메일 중복체크(?��?���??��?��, ?��?��?��보수?��?��)
	@GetMapping("/member/checkEmail/{member_email}")
	public String checkEmail(@PathVariable String member_email) {
		boolean chck = memberService.checkEmail(member_email);
		return chck+"";
	}
		

	//3.?��메일 중복체크(?��?���??��?��)
	@GetMapping("/member/checkEmailInModify/{member_email}")
	public String checkEmailInModify(@PathVariable String member_email) {
		boolean chck = memberService.checkEmailInModify(member_email);
		return chck+"";
	}
	
	
	
	
	
	
	
	
}