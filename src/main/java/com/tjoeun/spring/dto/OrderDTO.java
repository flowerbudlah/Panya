package com.tjoeun.spring.dto;

import java.util.Date;

import lombok.Data;

@Data
public class OrderDTO {

	private String order_idx;
	
	private String member_id; //주문결제?��?�� ?��?��?�� 
	private int paymentprice; //배송�?+물품총�?�? = 결제금액
	
	private String sender_name; //발송?��?�� ?���?
	private String sender_address; //발송?��?�� 주소
	private int sender_postcode; //발송?�� ?��?��번호
	private String sender_tel; //발송?��?�� ?��?��번호 
	
	private String recipient_name; //?��?��?��?�� ?���?
	private String recipient_address; //?��?��?��?�� 주소 
	private int recipient_postcode; 	
	private String recipient_tel; 
	
	private Date order_date; //결제?�� 
	private String memo; 
	private String payment_method; 
	
	private String circumstance; 
	//?��?�� ?��?�� ?��?��(1. 결제?���?(?��경우�? 100?���? ?��불�??��), 2. 배송�?비중, 3. 배송�?, 4. 배송?���?) ?��것�? 처음 결제�? ?��?��?��?��?�� 무조�? 결제?���?

}
