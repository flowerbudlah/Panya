package com.tjoeun.spring.dto;

import javax.validation.constraints.NotBlank;


import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class ProductDTO {

	private int category_idx; //?��?��번호 �?1, �??��2, 기�??��머�?3  
	private int product_idx; //?��?��번호  
	
	
	@NotBlank
	private String product_name; //?��?���?

	private int product_price; //?���?
	
	@NotBlank
	private String storage_method; //보�?방법
	
	@NotBlank
	private String expiration_date; //?��?��기한 
	

	private String product_img; //?��진이�? .png
	private MultipartFile product_image_file; //?��?��?��미�? ?��?�� 
	
	private int likeButton; //좋아?��(?��?��추천)
	
	private String result; //결과�? susccess or fail
	
	
	
	
}