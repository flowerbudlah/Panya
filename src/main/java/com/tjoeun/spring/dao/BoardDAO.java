package com.tjoeun.spring.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tjoeun.spring.dto.PostDTO;

@Repository
public class BoardDAO {
  
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	//κΈ??°κΈ?
	public void addPostInfo(PostDTO writePostDTO) {
		sqlSessionTemplate.insert("board.addPostInfo", writePostDTO);
	}
	
	//κ²μ? ?΄λ¦? κ°?? Έ?€κΈ?
	public String getBoardName(int board_idx) {
		String board_name = sqlSessionTemplate.selectOne("board.getBoardName", board_idx);
			return board_name; 	
	}
	//κ²μκΈ? ? μ²΄μ
	public int getPostCnt(int post_board_idx) {
		int postCnt = sqlSessionTemplate.selectOne("board.getPostCnt", post_board_idx);
		return postCnt;
	}
	//? μ²΄κ²?λ¬? λ¦¬μ€?Έ 
	public List<PostDTO> getPostList(int board_idx, RowBounds rowBounds){
		List<PostDTO> postList = sqlSessionTemplate.selectList("board.getPostList", board_idx, rowBounds);
		return postList;
	}
	
	
	
	//κ²??? κ²μλ¬Όμ ? 
	public int searchResultCount(PostDTO searchPostDTO) {
		 int search_result_count = sqlSessionTemplate.selectOne("board.searchResultCount", searchPostDTO); 
		 return search_result_count; 
	}
	//κ²μλ¬? κ²?? κ²°κ³Ό λ¦¬μ€?Έ
	public List<PostDTO> selectSearchList(PostDTO searchPostDTO, RowBounds rowBounds){
		return sqlSessionTemplate.selectList("board.selectSearchList", searchPostDTO, rowBounds);
	}

	
	
	
	
	
	
	//κΈ? ?? ?½κΈ?
	public PostDTO getPostInfo(int post_idx){
		PostDTO readPostDTO = sqlSessionTemplate.selectOne("board.getPostInfo", post_idx);
		return readPostDTO;
	}
	
	//κΈ? ?? 
	public void modifyPostInfo(PostDTO modifyPostDTO) {
		sqlSessionTemplate.update("board.modifyPostInfo", modifyPostDTO);
	}
	
	//κΈ? ?­? 
	public void delete(int post_idx){
		sqlSessionTemplate.delete("board.replyDelete", post_idx); 
		sqlSessionTemplate.delete("board.delete", post_idx);
	}
	
	//μ‘°ν? μ¦κ?
	public void viewCount(int post_idx) {
		sqlSessionTemplate.update("board.viewCount", post_idx); 
	}


	

	
	
}













