package com.tjoeun.spring.dto;

import java.util.Date;

import lombok.Data;

@Data
public class OrderDTO {

	private String order_idx;
	
	private String member_id; //주문결제자의 아이디 
	private int paymentprice; //배송비+물품총가격 = 결제금액
	
	private String sender_name; //발송인의 이름
	private String sender_address; //발송인의 주소
	private int sender_postcode; //발송인 우편번호
	private String sender_tel; //발송인의 전화번호 
	
	private String recipient_name; //수신인의 이름
	private String recipient_address; //수신인의 주소 
	private int recipient_postcode; 	
	private String recipient_tel; 
	
	private Date order_date; //결제일 
	private String memo; 
	private String payment_method; 
	
	private String circumstance; 
	//현재 해당 상황(1. 결제완료(이경우만 100프로 환불가능), 2. 배송준비중, 3. 배송중, 4. 배송완료) 이것은 처음 결제를 시작했을땐 무조건 결제완료

}
