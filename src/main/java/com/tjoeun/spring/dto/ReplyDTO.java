package com.tjoeun.spring.dto;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ReplyDTO {
	
	private int reply_idx; //리플?�� 고유번호(?��???�� 처리?�� �?)
	
	private int post_idx; //?���??�� 고유번호
	
	private String reply_content; //리플?�� ?��?��
	
	private String replyer_id; //리플?��?��?��?�� ?��?��?��
	
	private String replyer_name; //리플?��?��?�� ?���? 
	
	private Date regdate; //리플?��?���? 

	

}
