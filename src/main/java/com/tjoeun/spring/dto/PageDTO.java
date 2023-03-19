package com.tjoeun.spring.dto;

import lombok.Getter;

@Getter
public class PageDTO {
  
	private int min; // 최소 ?��?���? 번호
	private int max; // 최�? ?��?���? 번호
	
	private int prePage; // ?��?�� 버튼 ?��르면 ?��?��?��?�� ?��?���? 번호
	private int nextPage;   // ?��?�� 버튼 ?��르면 ?��?��?��?�� ?��?���? 번호
	
	private int pageCount; 	// ?���? ?��?���? 개수
	
	private int currentPage; // ?��?�� ?��?���? 번호
	
	/*
	  ?���? 게시�??�� 개수, ?��?���??�� 게시�??�� 개수, ?��?�� ?��?���? 번호 --> ?�� 값들?�� �?�?�? ?��?�� 값들?�� 계산?��
	    
	  ?�� ?��?��?? ?��?��?��?��?�� ?��
	  ?��?��?��?�� 매개�??���?
	  int postCnt     : ?���? 게시�??�� 개수
	  int currentPage    : ?��?�� ?��?���? 번호
	  int postPageCnt : ?��?���??�� 게시�??�� 개수
	  int paginationCnt  : ?��?���? 버튼?�� 개수
	  �? ?��?��?��   
	*/
	// contentCnt    : database ?��?�� �??��?�� (BoardMapper)
	// currentPage   : page parameter�? ?��?��?��
	// contentPageCnt, paginationCnt : option.properties ?�� ?��?��?��
	public PageDTO(int contentCnt, int currentPage, int contentPageCnt, int paginationCnt) {
		
		this.currentPage = currentPage; // ?��?�� ?��?���? 번호
		
		pageCount = contentCnt / contentPageCnt; //?���? ?��?���? 개수 = ?���? �?개수 / ?��?���??�� �?개수
		
		if(contentCnt % contentPageCnt > 0) { pageCount++; }
	  

		min = ((currentPage - 1) / contentPageCnt) * contentPageCnt + 1;
	  
		max = min + paginationCnt - 1;  //  최�??��?���? 번호 = 최소?��?���? 번호 + ?��?���? 버튼?�� 개수 - 1
    
		if(max > pageCount) { max = pageCount;}
		prePage = min - 1;
		nextPage = max + 1;
    
		if(nextPage > pageCount) { nextPage = pageCount; } //?��?��?��?���?버튼 번호�? ?��체페?���? 개수�? ?��?���?�? ?��?���? ?��
    
    
	}
	
	
}




