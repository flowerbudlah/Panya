package com.tjoeun.spring.dto;

import javax.validation.constraints.NotBlank;


import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class ProductDTO {

	private int category_idx; //?†Œ?†ë²ˆí˜¸ ë¹?1, ì¼??Œ2, ê¸°í??‚˜ë¨¸ì?3  
	private int product_idx; //?ƒ?’ˆë²ˆí˜¸  
	
	
	@NotBlank
	private String product_name; //?ƒ?’ˆëª?

	private int product_price; //?‹¨ê°?
	
	@NotBlank
	private String storage_method; //ë³´ê?ë°©ë²•
	
	@NotBlank
	private String expiration_date; //?œ ?†µê¸°í•œ 
	

	private String product_img; //?‚¬ì§„ì´ë¦? .png
	private MultipartFile product_image_file; //?ƒ?’ˆ?´ë¯¸ì? ?ŒŒ?¼ 
	
	private int likeButton; //ì¢‹ì•„?š”(?ƒ?’ˆì¶”ì²œ)
	
	private String result; //ê²°ê³¼ê°? susccess or fail
	
	
	
	
}