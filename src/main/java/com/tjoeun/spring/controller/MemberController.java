package com.tjoeun.spring.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.tjoeun.spring.dto.MemberDTO;
import com.tjoeun.spring.service.MemberService;
import com.tjoeun.spring.validator.MemberValidator;


@Controller
@RequestMapping("/member")
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	@Resource(name = "loginMemberDTO")
	@Lazy
	private MemberDTO loginMemberDTO;

	//ë¡œê·¸?¸
	@GetMapping("/login")
	public String login
	(@ModelAttribute("tmpLoginMemberDTO") MemberDTO loginMemberDTO,
	 @RequestParam(value="failure", defaultValue="false") boolean failure,
	 Model model) {
		model.addAttribute("failure", failure);
			return "member/login";
	}
	
	//ë¡œê·¸?¸ ë²„íŠ¼ ?ˆ„ë¥´ê¸°
	@PostMapping("/login_proc")
	public String login_pro
	(@Valid @ModelAttribute("tmpLoginMemberDTO") MemberDTO tmpLoginMemberDTO,  BindingResult result) {
		
		if(result.hasErrors()) {
			return "member/login"; 
		}
		memberService.getLoginMemberDTO(tmpLoginMemberDTO);
		
		if(loginMemberDTO.isMemberLogin() == true) { 
			return "member/login_success"; //ë¡œê·¸?¸ ?„±ê³µì‹œ
		} else { 
			return "member/login_failure"; //ë¡œê·¸?¸ ?‹¤?Œ¨?‹œ 
		}
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		loginMemberDTO.setMemberLogin(false);
			session.invalidate();
				return "member/logout";
	}
	
	//?šŒ?›ê°??…
	@GetMapping("/join")
	public String join(@ModelAttribute("joinMemberDTO") MemberDTO joinMemberDTO) {
		return "member/join";
	}
	
	//?šŒ?›ê°??… ë²„íŠ¼ ?ˆ„ë¥´ê¸°
	@PostMapping("/join_proc")
	public String joinProc
	(@Valid @ModelAttribute("joinMemberDTO") MemberDTO joinMemberDTO, BindingResult result) {
		
		if(result.hasErrors()) { 
			return "member/join"; 
		}
		memberService.addMemberInfo(joinMemberDTO);
			return "member/join_success";
	}

	
	//?šŒ?›? •ë³´ìˆ˜? •
	@GetMapping("/modify")
	public String modify(@ModelAttribute("modifyMemberDTO") MemberDTO modifyMemberDTO) {
		memberService.getModifyMemberDTO(modifyMemberDTO);
		return "member/modify";
	}
	
	//?šŒ?›? •ë³´ìˆ˜? • ?™„ë£? ë²„íŠ¼ ?ˆ„ë¥´ê³  ?‚˜?„œ
	@PostMapping("/modify_proc")
	public String modifyProc(@Valid @ModelAttribute("modifyMemberDTO") MemberDTO modifyMemberDTO, BindingResult result){
		
		if(result.hasErrors()) { 
			return "member/modify";
		}
			memberService.modifyMemberInfo(modifyMemberDTO);
			return "member/modify_success";
		
	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		MemberValidator validator1 = new MemberValidator();
		binder.addValidators(validator1);
	}
	
	
  	//?šŒ?› ?ƒˆ?‡´ get
	@RequestMapping(value="/delete", method = RequestMethod.GET)
	public String delete() throws Exception{
		return "member/delete";
	}
	// ?šŒ?› ?ƒˆ?‡´ post
	@RequestMapping(value="/delete_proc", method = RequestMethod.POST)
	public String delete_proc(MemberDTO deleteMemberDTO, HttpSession session, RedirectAttributes rttr) throws Exception{
		MemberDTO loginMemberDTO = (MemberDTO)session.getAttribute("loginMemberDTO");
		// ë¡œê·¸?¸?„ ?•œ ?„¸?…˜?— ì¡´ì¬?•˜?Š” ë¹„ë?ë²ˆí˜¸ 
		String session_pw = loginMemberDTO.getMember_pw(); 
		// ?…? ¥?•œ deleteMemberDTOë¡? ?ƒˆ?‡´ ? „ ?…? ¥?•˜?Š” ê·? ë¹„ë?ë²ˆí˜¸ 
		String deleteMemberDTO_pw =deleteMemberDTO.getMember_pw(); 
		
		if(!(session_pw.equals(deleteMemberDTO_pw))) {
			rttr.addFlashAttribute("msg", false);
				return "redirect:/member/delete";
		}
		memberService.delete(deleteMemberDTO);
			session.invalidate();
				return "redirect:/main";
		}
	
	//?•„?´?”” ì°¾ê¸°
	@RequestMapping(value ="/find_id_form")
	public String find_id_form(){
		return "/member/find_id_form";
	}
	@RequestMapping(value="/find_id", method = RequestMethod.POST)
	public String find_id
	(HttpServletResponse response,
	@RequestParam("member_email") String member_email,
	Model model) throws Exception{//?´ë©”ì¼?„ ?…? ¥?•´?„œ ?•„?´?””ë¥? ì°¾ëŠ” 
		
		model.addAttribute("id", memberService.find_id(response, member_email));
		return "/member/find_id";
	}
	
	//ë¹„ë²ˆì°¾ê¸° ì²«ë‹¨ê³? ì§ˆë¬¸(question)ê³? member_id ê°?? ¸?˜¤ê¸?
	@RequestMapping(value ="/find_password_question")
	public String find_password_question(){
		return "/member/find_password_question";
	}
	
	@RequestMapping(value="/find_password_answer", method = RequestMethod.POST)
	public String find_password_answer
	(HttpServletResponse response,
	@RequestParam("member_id") String member_id, 
	Model model) throws Exception{//?•„?´?””ë¥? ?…? ¥?•´?„œ ì§ˆë¬¸?„ ì°¾ëŠ” êµ¬ì¡° 
		
		model.addAttribute("memberDTO", memberService.find_question(response, member_id));
		return "/member/find_password_answer";
	}
	

	//ë¹„ë²ˆì°¾ê¸° ?œ„?•´?„œ ì§ˆë¬¸?— ???•œ ?‹µ?„ ?•˜ê³? ë³¸ì¸?˜ ?•„?´?””ë¥? ë³´ë‚´ê¸? 
	@RequestMapping(value="/find_password", method=RequestMethod.POST)
	public String find_password(MemberDTO answerAndId, Model model) {
		
		MemberDTO password = memberService.find_password(answerAndId);
			
		if(password == null) {  //?‹µê³? ?•„?•„?””ë¥? ?„£?—ˆì§?ë§? ?‚˜?˜¨ê²°ê³¼ê°? ?—†?‹¤. 
				model.addAttribute("check", 1);
		} else { 
				model.addAttribute("check", 0);
				model.addAttribute("password", password.getMember_pw());
		}
			return "/member/find_password_answer";
		}
	
  
  
 
}