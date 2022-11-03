package com.tjoeun.spring.dto;

import java.util.Date;

import lombok.Data;

@Data
public class ProductReplyDTO { //상품 상세보기 페이지에서 해당 상품에 대한 소감을 남기는 페이지
	private int product_reply_idx; 
	private int product_idx; //상품 인덱스
	private String product_reply_content; //상품 소감 
	private String product_replyer_id; //해당 소감을 작성한 사람의 아이디
	private Date regdate; //댓글작성일
	
	private String product_replyer_name; //댓글 작성자 이름
	
	private String result; //상품 댓글 작성 작성 성공여부

	
}
