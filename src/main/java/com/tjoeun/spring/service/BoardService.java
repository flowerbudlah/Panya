package com.tjoeun.spring.service;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.tjoeun.spring.dao.BoardDAO;
import com.tjoeun.spring.dto.PostDTO;
import com.tjoeun.spring.dto.PageDTO;
import com.tjoeun.spring.dto.MemberDTO;

@Service
@PropertySource("/WEB-INF/properties/option.properties")
public class BoardService {
	
	@Value("${path.load}")
	private String path_load;
	
	// ?•œ ?˜?´ì§??‹¹ ë³´ì—¬ì£¼ëŠ” ê¸??˜ ê°œìˆ˜
	@Value("${page.listcnt}")
	private int page_listcnt;	
	
	// ?•œ ?˜?´ì§??‹¹ ë³´ì—¬ì£¼ëŠ” ?˜?´ì§? ë²„íŠ¼ ê°œìˆ˜
	@Value("${page.paginationcnt}")
	private int page_paginationcnt;	
	
	@Autowired
	private BoardDAO boardDAO;
	
	@Resource(name="loginMemberDTO")
	@Lazy
	private MemberDTO loginMemberDTO;
	
	
	//ê²Œì‹œ?Œ ?´ë¯¸ì? ?ŒŒ?¼ ?—…ë¡œë“œ ê´?? ¨ 
	private String saveUploadFile(MultipartFile upload_file) {
		
		String file_name = System.currentTimeMillis() + "_" + upload_file.getOriginalFilename();
		
		try { 
			upload_file.transferTo(new File(path_load + "/" + file_name));
		} catch (IllegalStateException e) { 
			e.printStackTrace();
		} catch (IOException e) { 
			e.printStackTrace();
		}
		return file_name;
	}
	
	//ê¸??“°ê¸? 
	public void addPostInfo(PostDTO writePostDTO) {   // parameterë¡? ? „?‹¬?˜?–´?˜¤?Š” data ?™•?¸?•˜ê¸?
		
		MultipartFile upload_file = writePostDTO.getUpload_file();
		
		if(upload_file.getSize() > 0) {//?—…ë¡œë“œ?•œ ?ŒŒ?¼?´ ?ˆ?Š”ê²½ìš°
			String file_name = saveUploadFile(upload_file);
				writePostDTO.setPost_file(file_name);
		}
		
		writePostDTO.setPost_writer_idx(loginMemberDTO.getMember_idx());
		boardDAO.addPostInfo(writePostDTO);
		
	}
	
	
	
	
	//ê²Œì‹œ?Œ ?´ë¦? ê°?? ¸?˜¤ê¸? 
	public String getBoardName(int board_idx) {
		String board_name = boardDAO.getBoardName(board_idx);
			return board_name;
	}
	
	
	// ?˜?´ì§? ?‘?—…?„ ê±°ì¹œ ê²Œì‹œ?Œ ë©”ì¸?™”ë©? ê·? ë¦¬ìŠ¤?Š¸! 
	public List<PostDTO> getPostList(int board_idx, int page){
		                             // 10  
		int start = (page - 1) * page_listcnt;
		RowBounds rowBounds = new RowBounds(start, page_listcnt);
		
		List<PostDTO> postList = boardDAO.getPostList(board_idx, rowBounds);
			return postList;
	}
	
	//ê²Œì‹œ?Œ ë©”ì¸ ?˜?´ì§?
	public PageDTO getPostCnt(int post_board_idx, int currentPage) {
		
		int postCnt = boardDAO.getPostCnt(post_board_idx); //? „ì²´ê²Œ?‹œê¸? ?ˆ˜ 
		PageDTO pageDTO = new PageDTO(postCnt, currentPage, page_listcnt, page_paginationcnt);
		
		return pageDTO;
	}
	
	
	//ê²??ƒ‰?•œ ê²Œì‹œë¬¼ì˜ ?ˆ˜ 
	public int searchResultCount(PostDTO searchPostDTO) {
		int search_result_count = boardDAO.searchResultCount(searchPostDTO);
			return search_result_count; 
	}
	
	
	//?˜?´ì§? ?‘?—…?„ ì¶”ê??•œ ê²Œì‹œ?Œ ê²??ƒ‰ê´?? ¨ 
	public List<PostDTO> selectSearchList(PostDTO searchPostDTO, int page){
		
		int start = (page - 1) * page_listcnt;
		RowBounds rowBounds = new RowBounds(start, page_listcnt);
			
		List<PostDTO> searchList = boardDAO.selectSearchList(searchPostDTO, rowBounds);
		 
		return searchList; 
	}
	
	
	//ê²??ƒ‰ê²°ê³¼ê´?? ¨ ?˜?´ì§?
	public PageDTO searchListCount(PostDTO searchPostDTO, int currentPage) {
		
		int search_result_count = boardDAO.searchResultCount(searchPostDTO); //ê²??ƒ‰?•´?„œ ?‚˜?˜¨ ê²Œì‹œê¸??˜ ?ˆ˜ 
		PageDTO pageDTO = new PageDTO(search_result_count, currentPage, page_listcnt, page_paginationcnt);
			
		return pageDTO;
	}

		
	//ê¸? ?½ê¸?
	public PostDTO getPostInfo(int post_idx){
		PostDTO readPostDTO = boardDAO.getPostInfo(post_idx);
			return readPostDTO;
	}
	
	
	//ê¸??ˆ˜? •
	public void modifyPostInfo(PostDTO modifyPostDTO) {
		
		MultipartFile upload_file = modifyPostDTO.getUpload_file();
		if(upload_file.getSize() > 0) {
			String file_name = saveUploadFile(upload_file);
			modifyPostDTO.setPost_file(file_name);
		}
		boardDAO.modifyPostInfo(modifyPostDTO);
	}
	
	
	
	
	
	//ê¸??‚­? œ
	public void delete(int post_idx){
		boardDAO.delete(post_idx);
	}
	
	//ì¡°íšŒ?ˆ˜ ì¦ê?
	public void viewCount(int post_idx) {
		boardDAO.viewCount(post_idx);
	}
	
}