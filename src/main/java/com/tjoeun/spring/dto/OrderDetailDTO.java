package com.tjoeun.spring.dto;

import lombok.Data;

@Data
public class OrderDetailDTO {

	private int order_detail_idx; 
	private String order_idx; //ì£¼ë¬¸ë²ˆí˜¸ 
	private int product_idx; //?•´?‹¹ ë¬¼ê±´?˜ ?¸?±?Š¤
	private int amount; //êµ¬ë§¤?ˆ˜?Ÿ‰
	private String member_id; 
	
}
