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
	
	// ? ??΄μ§??Ή λ³΄μ¬μ£Όλ κΈ?? κ°μ
	@Value("${page.listcnt}")
	private int page_listcnt;	
	
	// ? ??΄μ§??Ή λ³΄μ¬μ£Όλ ??΄μ§? λ²νΌ κ°μ
	@Value("${page.paginationcnt}")
	private int page_paginationcnt;	
	
	@Autowired
	private BoardDAO boardDAO;
	
	@Resource(name="loginMemberDTO")
	@Lazy
	private MemberDTO loginMemberDTO;
	
	
	//κ²μ? ?΄λ―Έμ? ??Ό ?λ‘λ κ΄?? ¨ 
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
	
	//κΈ??°κΈ? 
	public void addPostInfo(PostDTO writePostDTO) {   // parameterλ‘? ? ?¬??΄?€? data ??Έ?κΈ?
		
		MultipartFile upload_file = writePostDTO.getUpload_file();
		
		if(upload_file.getSize() > 0) {//?λ‘λ? ??Ό?΄ ??κ²½μ°
			String file_name = saveUploadFile(upload_file);
				writePostDTO.setPost_file(file_name);
		}
		
		writePostDTO.setPost_writer_idx(loginMemberDTO.getMember_idx());
		boardDAO.addPostInfo(writePostDTO);
		
	}
	
	
	
	
	//κ²μ? ?΄λ¦? κ°?? Έ?€κΈ? 
	public String getBoardName(int board_idx) {
		String board_name = boardDAO.getBoardName(board_idx);
			return board_name;
	}
	
	
	// ??΄μ§? ??? κ±°μΉ κ²μ? λ©μΈ?λ©? κ·? λ¦¬μ€?Έ! 
	public List<PostDTO> getPostList(int board_idx, int page){
		                             // 10  
		int start = (page - 1) * page_listcnt;
		RowBounds rowBounds = new RowBounds(start, page_listcnt);
		
		List<PostDTO> postList = boardDAO.getPostList(board_idx, rowBounds);
			return postList;
	}
	
	//κ²μ? λ©μΈ ??΄μ§?
	public PageDTO getPostCnt(int post_board_idx, int currentPage) {
		
		int postCnt = boardDAO.getPostCnt(post_board_idx); //? μ²΄κ²?κΈ? ? 
		PageDTO pageDTO = new PageDTO(postCnt, currentPage, page_listcnt, page_paginationcnt);
		
		return pageDTO;
	}
	
	
	//κ²??? κ²μλ¬Όμ ? 
	public int searchResultCount(PostDTO searchPostDTO) {
		int search_result_count = boardDAO.searchResultCount(searchPostDTO);
			return search_result_count; 
	}
	
	
	//??΄μ§? ??? μΆκ?? κ²μ? κ²??κ΄?? ¨ 
	public List<PostDTO> selectSearchList(PostDTO searchPostDTO, int page){
		
		int start = (page - 1) * page_listcnt;
		RowBounds rowBounds = new RowBounds(start, page_listcnt);
			
		List<PostDTO> searchList = boardDAO.selectSearchList(searchPostDTO, rowBounds);
		 
		return searchList; 
	}
	
	
	//κ²??κ²°κ³Όκ΄?? ¨ ??΄μ§?
	public PageDTO searchListCount(PostDTO searchPostDTO, int currentPage) {
		
		int search_result_count = boardDAO.searchResultCount(searchPostDTO); //κ²???΄? ??¨ κ²μκΈ?? ? 
		PageDTO pageDTO = new PageDTO(search_result_count, currentPage, page_listcnt, page_paginationcnt);
			
		return pageDTO;
	}

		
	//κΈ? ?½κΈ?
	public PostDTO getPostInfo(int post_idx){
		PostDTO readPostDTO = boardDAO.getPostInfo(post_idx);
			return readPostDTO;
	}
	
	
	//κΈ??? 
	public void modifyPostInfo(PostDTO modifyPostDTO) {
		
		MultipartFile upload_file = modifyPostDTO.getUpload_file();
		if(upload_file.getSize() > 0) {
			String file_name = saveUploadFile(upload_file);
			modifyPostDTO.setPost_file(file_name);
		}
		boardDAO.modifyPostInfo(modifyPostDTO);
	}
	
	
	
	
	
	//κΈ??­? 
	public void delete(int post_idx){
		boardDAO.delete(post_idx);
	}
	
	//μ‘°ν? μ¦κ?
	public void viewCount(int post_idx) {
		boardDAO.viewCount(post_idx);
	}
	
}