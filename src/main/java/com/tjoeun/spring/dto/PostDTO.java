package com.tjoeun.spring.dto;

import javax.validation.constraints.NotBlank;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class PostDTO {
	
	private int post_idx; //κ²μκΈ? ?Ό? ¨λ²νΈ
	
	@NotBlank
	private String post_subject; //κ²μκΈ? ? λͺ?
	
	@NotBlank
	private String post_text; //κ²μκΈ? ?΄?©
	
	
	private int post_writer_idx; //κ²μκΈ? ??±?? ?Ό? ¨λ²νΈ 
	
	private String post_writer_name; // SQLλ¬Έμ? alias(λ³μΉ­)?Όλ‘? μ§?? ? μ»¬λΌλͺμ PostDTO? λ©€λ²λ³??λ‘? ? ?Έ?΄?Ό κ°μ λ°μ?¬ ? ??
	
	private int post_board_idx; //?΄ κΈ??΄ ??? κ²μ?λ²νΈ. 1?΄λ©? κ³΅μ??¬?­, 2?΄λ©? κ³ κ°?Ό?°   
	
	private String post_date; //κ²μ?Ό(??±? μ§?)
	
	private String post_file; // ?°?΄?°λ² μ΄?€? ???₯??΄?? ??Ό?΄λ¦μ ???₯?? λ³??
	private MultipartFile upload_file; // browserκ°? λ³΄λ΄? file dataλ₯? ???₯?? λ³??
	
	
	private int post_read_count; //μ‘°ν?
	private int reply_cnt;    // **κ²μκΈ? ?κΈ?? ? μΆκ?(2021? 06? 01?Ό)
	
	
	private String keyword;//?€?? 
	private String type; //κ²??μ’λ₯
	

	
	
	 
}




