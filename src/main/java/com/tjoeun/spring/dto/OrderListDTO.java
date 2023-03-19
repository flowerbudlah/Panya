package com.tjoeun.spring.dto;

import java.util.Date;

import lombok.Data;

@Data
public class OrderListDTO {

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
	
	private int order_detail_idx; 
	private int product_idx; //?��?�� 물건?�� ?��?��?��
	private int amount; //구매?��?��
	
	private String product_name; //?��?���?
	private int product_price; //?���?
	private String product_img; //?��진이�? .png
	
	
	
	
	
	
	
	
}
