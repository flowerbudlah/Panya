package com.tjoeun.spring.dto;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ReplyDTO {
	
	private int reply_idx; //ë¦¬í”Œ?˜ ê³ ìœ ë²ˆí˜¸(?‹œ???Š¤ ì²˜ë¦¬?  ê²?)
	
	private int post_idx; //?›ê¸??˜ ê³ ìœ ë²ˆí˜¸
	
	private String reply_content; //ë¦¬í”Œ?˜ ?‚´?š©
	
	private String replyer_id; //ë¦¬í”Œ?“´?‚¬?Œ?˜ ?•„?´?””
	
	private String replyer_name; //ë¦¬í”Œ?“´??˜ ?´ë¦? 
	
	private Date regdate; //ë¦¬í”Œ?“´?‚ ì§? 

	

}
