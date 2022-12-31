package com.tjoeun.spring.service;

import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.tjoeun.spring.dao.MemberDAO;
import com.tjoeun.spring.dto.MemberDTO;

@Service
public class MemberService {
	
	@Autowired
	private MemberDAO memberDAO;
	
	@Resource(name = "loginMemberDTO")
	@Lazy
	private MemberDTO loginMemberDTO;	
	
	//1. 아이디 중복체크
	public boolean checkID(String member_id) {
		String checking_id = memberDAO.checkID(member_id); 

		if(checking_id == null) {	
			return true; //입력한 아이디가 존재하지 않기에 입력한 아이디 사용가능. 
		} else {	
			return false; //입력한 아이디 이미 존재하기에 사용불가
		}
	}
	
	
	//2. 이메일 중복체크 
	public boolean checkEmail(String member_email) {
		String checking_email = memberDAO.checkEmail(member_email); 
		if(checking_email == null) {	
			return true; //입력한 아이디가 존재하지 않기에 입력한 아이디 사용가능. 
		} else {	
			return false; //입력한 아이디 이미 존재하기에 사용불가
		}
	}
	
	
	//3. 회원가입
	public void addMemberInfo(MemberDTO joinMemberDTO) {
		memberDAO.addUserInfo(joinMemberDTO);
	}
 
	public void getLoginMemberDTO(MemberDTO tmpLoginMemberDTO) {
		MemberDTO fromDBMemberDTO = memberDAO.getLoginMemberDTO(tmpLoginMemberDTO);
		
		if(fromDBMemberDTO != null) {
			loginMemberDTO.setMember_idx(fromDBMemberDTO.getMember_idx());
			loginMemberDTO.setMember_name(fromDBMemberDTO.getMember_name());
			loginMemberDTO.setMember_id(fromDBMemberDTO.getMember_id());
			loginMemberDTO.setMember_pw(fromDBMemberDTO.getMember_pw());
	
			loginMemberDTO.setMemberLogin(true);
		}
	}
	
	public void getModifyMemberDTO(MemberDTO modifyMemberDTO) {
		MemberDTO fromDBModifyMemberDTO = memberDAO.getModifyMemberDTO(loginMemberDTO.getMember_idx());
  	
		modifyMemberDTO.setMember_id(fromDBModifyMemberDTO.getMember_id());
		modifyMemberDTO.setMember_name(fromDBModifyMemberDTO.getMember_name());
		modifyMemberDTO.setMember_pw(fromDBModifyMemberDTO.getMember_pw());
		modifyMemberDTO.setMember_pw2(fromDBModifyMemberDTO.getMember_pw2());
		modifyMemberDTO.setMember_tel(fromDBModifyMemberDTO.getMember_tel());
		modifyMemberDTO.setMember_address(fromDBModifyMemberDTO.getMember_address());
		modifyMemberDTO.setPostcode(fromDBModifyMemberDTO.getPostcode());
		modifyMemberDTO.setMember_email(fromDBModifyMemberDTO.getMember_email());
		modifyMemberDTO.setQuestion(fromDBModifyMemberDTO.getQuestion());
		modifyMemberDTO.setAnswer(fromDBModifyMemberDTO.getAnswer());
		
		modifyMemberDTO.setMember_idx(loginMemberDTO.getMember_idx());
	} 

	//회원정보 수정 버튼 누르기 
	public void modifyMemberInfo(MemberDTO modifyMemberDTO){
		modifyMemberDTO.setMember_idx(loginMemberDTO.getMember_idx());
		memberDAO.modifyMemberInfo(modifyMemberDTO);
	}
	
	//회원탈퇴
	public void delete(MemberDTO deleteMemberDTO) throws Exception{
		memberDAO.delete(deleteMemberDTO);
	}
	

	public String find_id(HttpServletResponse response, String member_email) throws Exception {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String id = memberDAO.find_id(member_email);
		
		if (id == null) {
			out.println("<script>");
			out.println("alert('媛��엯�맂 �븘�씠�뵒媛� �뾾�뒿�땲�떎.');");
			out.println("history.go(-1);");
			out.println("</script>");
			out.close();
			return null;
		} else {
			return id;
		}
	}
	
	public MemberDTO find_question(HttpServletResponse response, String member_id) throws Exception {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		MemberDTO memberDTO = memberDAO.find_question(member_id);
		
		if (memberDTO == null) {
			out.println("<script>");
			out.println("alert('�쉶�썝媛��엯�떆 鍮꾨쾲遺꾩떎�떆 吏덈Ц�쓣 �엯�젰�븯吏� �븡�쑝�뀲嫄곕굹 �샊�� 媛��엯�맂 �젙蹂닿� �뾾�뒿�땲�떎.');");
			out.println("history.go(-1);");
			out.println("</script>");
			out.close();
			return null;
		} else {
			return memberDTO;
		} 
	}
	
	public MemberDTO find_password(MemberDTO answerAndId) {
		return memberDAO.find_password(answerAndId);
		
	}
	

	
	
	}