package com.tjoeun.spring.dto;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ReplyDTO {
	
	private int reply_idx; //리플의 고유번호(시퀀스 처리될 것)
	
	private int post_idx; //원글의 고유번호
	
	private String reply_content; //리플의 내용
	
	private String replyer_id; //리플쓴사람의 아이디
	
	private String replyer_name; //리플쓴자의 이름 
	
	private Date regdate; //리플쓴날짜 

	

}
