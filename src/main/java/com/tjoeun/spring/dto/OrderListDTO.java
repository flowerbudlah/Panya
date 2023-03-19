package com.tjoeun.spring.dto;

import java.util.Date;

import lombok.Data;

@Data
public class OrderListDTO {

	private String order_idx;
	
	private String member_id; //ì£¼ë¬¸ê²°ì œ??˜ ?•„?´?”” 
	private int paymentprice; //ë°°ì†¡ë¹?+ë¬¼í’ˆì´ê?ê²? = ê²°ì œê¸ˆì•¡
	
	private String sender_name; //ë°œì†¡?¸?˜ ?´ë¦?
	private String sender_address; //ë°œì†¡?¸?˜ ì£¼ì†Œ
	private int sender_postcode; //ë°œì†¡?¸ ?š°?¸ë²ˆí˜¸
	private String sender_tel; //ë°œì†¡?¸?˜ ? „?™”ë²ˆí˜¸ 
	
	private String recipient_name; //?ˆ˜?‹ ?¸?˜ ?´ë¦?
	private String recipient_address; //?ˆ˜?‹ ?¸?˜ ì£¼ì†Œ 
	private int recipient_postcode; 	
	private String recipient_tel; 
	
	private Date order_date; //ê²°ì œ?¼ 
	private String memo; 
	private String payment_method; 
	
	private int order_detail_idx; 
	private int product_idx; //?•´?‹¹ ë¬¼ê±´?˜ ?¸?±?Š¤
	private int amount; //êµ¬ë§¤?ˆ˜?Ÿ‰
	
	private String product_name; //?ƒ?’ˆëª?
	private int product_price; //?‹¨ê°?
	private String product_img; //?‚¬ì§„ì´ë¦? .png
	
	
	
	
	
	
	
	
}
