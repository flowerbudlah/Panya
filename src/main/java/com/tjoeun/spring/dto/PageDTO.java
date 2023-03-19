package com.tjoeun.spring.dto;

import lombok.Getter;

@Getter
public class PageDTO {
  
	private int min; // ìµœì†Œ ?˜?´ì§? ë²ˆí˜¸
	private int max; // ìµœë? ?˜?´ì§? ë²ˆí˜¸
	
	private int prePage; // ?´? „ ë²„íŠ¼ ?ˆ„ë¥´ë©´ ?´?™?•˜?Š” ?˜?´ì§? ë²ˆí˜¸
	private int nextPage;   // ?‹¤?Œ ë²„íŠ¼ ?ˆ„ë¥´ë©´ ?´?™?•˜?Š” ?˜?´ì§? ë²ˆí˜¸
	
	private int pageCount; 	// ? „ì²? ?˜?´ì§? ê°œìˆ˜
	
	private int currentPage; // ?˜„?¬ ?˜?´ì§? ë²ˆí˜¸
	
	/*
	  ? „ì²? ê²Œì‹œê¸??˜ ê°œìˆ˜, ?˜?´ì§??‹¹ ê²Œì‹œê¸??˜ ê°œìˆ˜, ?˜„?¬ ?˜?´ì§? ë²ˆí˜¸ --> ?´ ê°’ë“¤?„ ê°?ì§?ê³? ?œ„?˜ ê°’ë“¤?„ ê³„ì‚°?•¨
	    
	  ?´ ?‘?—…?? ?ƒ?„±??—?„œ ?•¨
	  ?ƒ?„±??˜ ë§¤ê°œë³??ˆ˜ë¡?
	  int postCnt     : ? „ì²? ê²Œì‹œê¸??˜ ê°œìˆ˜
	  int currentPage    : ?˜„?¬ ?˜?´ì§? ë²ˆí˜¸
	  int postPageCnt : ?˜?´ì§??‹¹ ê²Œì‹œê¸??˜ ê°œìˆ˜
	  int paginationCnt  : ?˜?´ì§? ë²„íŠ¼?˜ ê°œìˆ˜
	  ë¥? ?„ ?–¸?•¨   
	*/
	// contentCnt    : database ?—?„œ ê°?? ¸?˜´ (BoardMapper)
	// currentPage   : page parameterë¡? ? „?‹¬?•¨
	// contentPageCnt, paginationCnt : option.properties ?— ?„¤? •?•¨
	public PageDTO(int contentCnt, int currentPage, int contentPageCnt, int paginationCnt) {
		
		this.currentPage = currentPage; // ?˜„?¬ ?˜?´ì§? ë²ˆí˜¸
		
		pageCount = contentCnt / contentPageCnt; //? „ì²? ?˜?´ì§? ê°œìˆ˜ = ? „ì²? ê¸?ê°œìˆ˜ / ?˜?´ì§??‹¹ ê¸?ê°œìˆ˜
		
		if(contentCnt % contentPageCnt > 0) { pageCount++; }
	  

		min = ((currentPage - 1) / contentPageCnt) * contentPageCnt + 1;
	  
		max = min + paginationCnt - 1;  //  ìµœë??˜?´ì§? ë²ˆí˜¸ = ìµœì†Œ?˜?´ì§? ë²ˆí˜¸ + ?˜?´ì§? ë²„íŠ¼?˜ ê°œìˆ˜ - 1
    
		if(max > pageCount) { max = pageCount;}
		prePage = min - 1;
		nextPage = max + 1;
    
		if(nextPage > pageCount) { nextPage = pageCount; } //?‹¤?Œ?˜?´ì§?ë²„íŠ¼ ë²ˆí˜¸ê°? ? „ì²´í˜?´ì§? ê°œìˆ˜ë¥? ?„˜?–´ê°?ì§? ?•Š?„ë¡? ?•¨
    
    
	}
	
	
}




