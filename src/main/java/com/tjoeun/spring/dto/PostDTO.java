package com.tjoeun.spring.dto;

import javax.validation.constraints.NotBlank;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class PostDTO {
	
	private int post_idx; //게시�? ?��?��번호
	
	@NotBlank
	private String post_subject; //게시�? ?���?
	
	@NotBlank
	private String post_text; //게시�? ?��?��
	
	
	private int post_writer_idx; //게시�? ?��?��?��?�� ?��?��번호 
	
	private String post_writer_name; // SQL문에?�� alias(별칭)?���? �??��?�� 컬럼명을 PostDTO?�� 멤버�??���? ?��?��?��?�� 값을 받아?�� ?�� ?��?��
	
	private int post_board_idx; //?�� �??�� ?��?��?�� 게시?��번호. 1?���? 공�??��?��, 2?���? 고객?��?��   
	
	private String post_date; //게시?��(?��?��?���?)
	
	private String post_file; // ?��?��?��베이?��?�� ???��?��?��?��?�� ?��?��?��름을 ???��?��?�� �??��
	private MultipartFile upload_file; // browser�? 보내?�� file data�? ???��?��?�� �??��
	
	
	private int post_read_count; //조회?��
	private int reply_cnt;    // **게시�? ?���??�� ?�� 추�?(2021?�� 06?�� 01?��)
	
	
	private String keyword;//?��?��?�� 
	private String type; //�??��종류
	

	
	
	 
}




