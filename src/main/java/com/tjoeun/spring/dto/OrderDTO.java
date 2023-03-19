package com.tjoeun.spring.dto;

import java.util.Date;

import lombok.Data;

@Data
public class OrderDTO {

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
	
	private String circumstance; 
	//?˜„?¬ ?•´?‹¹ ?ƒ?™©(1. ê²°ì œ?™„ë£?(?´ê²½ìš°ë§? 100?”„ë¡? ?™˜ë¶ˆê??Š¥), 2. ë°°ì†¡ì¤?ë¹„ì¤‘, 3. ë°°ì†¡ì¤?, 4. ë°°ì†¡?™„ë£?) ?´ê²ƒì? ì²˜ìŒ ê²°ì œë¥? ?‹œ?‘?–ˆ?„?• ë¬´ì¡°ê±? ê²°ì œ?™„ë£?

}
