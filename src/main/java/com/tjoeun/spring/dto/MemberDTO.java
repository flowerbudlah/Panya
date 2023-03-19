package com.tjoeun.spring.dto;

import java.util.Date;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Data;


@Data
public class MemberDTO {
	private int member_idx; 
	
	@Size(min=2, max=4)
	@Pattern(regexp = "[ê°?-?£]*")
	private String member_name; 	
	
	@Size(min=2, max=20)
	@Pattern(regexp = "[a-zA-Z0-9]*")
	private String member_id; 	
	
	@Size(min=2, max=20)
	@Pattern(regexp = "[a-zA-Z0-9]*")
	private String member_pw; 	
	
	@Size(min=2, max=20)
	@Pattern(regexp = "[a-zA-Z0-9]*")
	private String member_pw2; 
	
	private String member_email; 
	
	private String member_tel; 	
	private String member_address; 	
	private int postcode; //?š°?¸ë²ˆí˜¸
	
	private String question; 
	private String answer; 
	
	private Date registerDate; //ê°??…?¼
	
	private boolean inputMemberID;
	private boolean inputMemberEmail;
	
	private boolean memberLogin;
	
	public MemberDTO() {
		this.inputMemberID = false;
		this.inputMemberEmail = false; 
	}
	
	private String keyword; //ê´?ë¦¬ì? „?š© ?˜?´ì§??—?„œ ?šŒ?›ê²??ƒ‰?‹œ ?•„?š”?•œ ê²? 
	private String type; //ê´?ë¦¬ì? „?š© ?˜?´ì§??—?„œ ?šŒ?›ê²??ƒ‰?‹œ ?•„?š”?•œ ê²? 
	
}


