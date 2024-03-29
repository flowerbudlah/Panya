package com.tjoeun.spring.dto;

import java.util.Date;

import lombok.Data;

@Data
public class OrderListDTO {

	private String order_idx;
	
	private String member_id; //μ£Όλ¬Έκ²°μ ?? ??΄? 
	private int paymentprice; //λ°°μ‘λΉ?+λ¬Όνμ΄κ?κ²? = κ²°μ κΈμ‘
	
	private String sender_name; //λ°μ‘?Έ? ?΄λ¦?
	private String sender_address; //λ°μ‘?Έ? μ£Όμ
	private int sender_postcode; //λ°μ‘?Έ ?°?Έλ²νΈ
	private String sender_tel; //λ°μ‘?Έ? ? ?λ²νΈ 
	
	private String recipient_name; //?? ?Έ? ?΄λ¦?
	private String recipient_address; //?? ?Έ? μ£Όμ 
	private int recipient_postcode; 	
	private String recipient_tel; 
	
	private Date order_date; //κ²°μ ?Ό 
	private String memo; 
	private String payment_method; 
	
	private int order_detail_idx; 
	private int product_idx; //?΄?Ή λ¬Όκ±΄? ?Έ?±?€
	private int amount; //κ΅¬λ§€??
	
	private String product_name; //??λͺ?
	private int product_price; //?¨κ°?
	private String product_img; //?¬μ§μ΄λ¦? .png
	
	
	
	
	
	
	
	
}
