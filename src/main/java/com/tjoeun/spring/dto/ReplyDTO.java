package com.tjoeun.spring.dto;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ReplyDTO {
	
	private int reply_idx; //λ¦¬ν? κ³ μ λ²νΈ(????€ μ²λ¦¬?  κ²?)
	
	private int post_idx; //?κΈ?? κ³ μ λ²νΈ
	
	private String reply_content; //λ¦¬ν? ?΄?©
	
	private String replyer_id; //λ¦¬ν?΄?¬?? ??΄?
	
	private String replyer_name; //λ¦¬ν?΄?? ?΄λ¦? 
	
	private Date regdate; //λ¦¬ν?΄? μ§? 

	

}
