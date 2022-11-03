package com.tjoeun.spring.dto;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public class CartDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	private int cart_idx;    //장바구니 인덱스 
	private String member_id; //장바구니 주인의 아이디
	private String member_name; //장바구니 주인의 이름     
	private int product_idx;    //장바구니 안에 있는 상품의 인덱스 
	private String product_name; //장바구니안에있는 상품의 이름     
	private int price; //상품단가
	private int amount;//수량
	private int totalPrice;//총액 = 단가 x 수량
	private String product_img; 
	
	private Date regdate; //카트에 넣은 날짜 

	
	public CartDTO() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + cart_idx;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CartDTO other = (CartDTO) obj;
		if (cart_idx != other.cart_idx)
			return false;
		return true;
	}



	public CartDTO(int cart_idx, String member_id, String member_name, int product_idx, String product_name, int price,
			int amount, int totalPrice, Date regdate, String product_img) {
		super();
		this.cart_idx = cart_idx;
		this.member_id = member_id;
		this.member_name = member_name;
		this.product_idx = product_idx;
		this.product_name = product_name;
		this.price = price;
		this.amount = amount;
		this.totalPrice = totalPrice;
		this.regdate = regdate;
		this.product_img = product_img; 
	}





	
	
	
	
}