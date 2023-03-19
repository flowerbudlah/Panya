package com.tjoeun.spring.dto;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public class CartDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	private int cart_idx;    //?¥ë°”êµ¬?‹ˆ ?¸?±?Š¤ 
	private String member_id; //?¥ë°”êµ¬?‹ˆ ì£¼ì¸?˜ ?•„?´?””
	private String member_name; //?¥ë°”êµ¬?‹ˆ ì£¼ì¸?˜ ?´ë¦?     
	private int product_idx;    //?¥ë°”êµ¬?‹ˆ ?•ˆ?— ?ˆ?Š” ?ƒ?’ˆ?˜ ?¸?±?Š¤ 
	private String product_name; //?¥ë°”êµ¬?‹ˆ?•ˆ?—?ˆ?Š” ?ƒ?’ˆ?˜ ?´ë¦?     
	private int price; //?ƒ?’ˆ?‹¨ê°?
	private int amount;//?ˆ˜?Ÿ‰
	private int totalPrice;//ì´ì•¡ = ?‹¨ê°? x ?ˆ˜?Ÿ‰
	private String product_img; 
	
	private Date regdate; //ì¹´íŠ¸?— ?„£?? ?‚ ì§? 

	
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