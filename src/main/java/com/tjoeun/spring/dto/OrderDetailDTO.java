package com.tjoeun.spring.dto;

import lombok.Data;

@Data
public class OrderDetailDTO {

	private int order_detail_idx; 
	private String order_idx; //주문번호 
	private int product_idx; //?��?�� 물건?�� ?��?��?��
	private int amount; //구매?��?��
	private String member_id; 
	
}
