package com.tjoeun.spring.dto;

import java.util.Date;

import lombok.Data;

@Data
public class ProductReplyDTO {
		
	private int product_reply_idx; //해당 상품리플 인덱스번호
	private int product_idx; //상품번호
	private String product_reply_content;//리플내용 
	private String product_replyer_id; //그 리플을 쓴사람의 아이디 
	private String product_replyer_name; //리플쓴자의 이름 
	

	private Date regdate; //등록일
	
	private String result; //상품 상세 페이지 댓글 삭제 결과

}
