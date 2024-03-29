package com.tjoeun.spring.dto;

import java.util.Date;

import lombok.Data;

@Data
public class OrderDTO {

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
	
	private String circumstance; 
	//??¬ ?΄?Ή ??©(1. κ²°μ ?λ£?(?΄κ²½μ°λ§? 100?λ‘? ?λΆκ??₯), 2. λ°°μ‘μ€?λΉμ€, 3. λ°°μ‘μ€?, 4. λ°°μ‘?λ£?) ?΄κ²μ? μ²μ κ²°μ λ₯? ????? λ¬΄μ‘°κ±? κ²°μ ?λ£?

}
