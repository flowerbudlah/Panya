package com.tjoeun.spring.dto;

import javax.validation.constraints.NotBlank;


import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class ProductDTO {

	private int category_idx; //소속번호 빵1, 케잌2, 기타나머지3  
	private int product_idx; //상품번호  
	
	
	@NotBlank
	private String product_name; //상품명

	private int product_price; //단가
	
	@NotBlank
	private String storage_method; //보관방법
	
	@NotBlank
	private String expiration_date; //유통기한 
	

	private String product_img; //사진이름 .png
	private MultipartFile product_image_file; //상품이미지 파일 
	
	private int likeButton; //좋아요(상품추천)
	
}
