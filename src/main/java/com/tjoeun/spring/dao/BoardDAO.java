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
	
	//Í∏??ì∞Í∏?
	public void addPostInfo(PostDTO writePostDTO) {
		sqlSessionTemplate.insert("board.addPostInfo", writePostDTO);
	}
	
	//Í≤åÏãú?åê ?ù¥Î¶? Í∞??†∏?ò§Í∏?
	public String getBoardName(int board_idx) {
		String board_name = sqlSessionTemplate.selectOne("board.getBoardName", board_idx);
			return board_name; 	
	}
	//Í≤åÏãúÍ∏? ?†ÑÏ≤¥Ïàò
	public int getPostCnt(int post_board_idx) {
		int postCnt = sqlSessionTemplate.selectOne("board.getPostCnt", post_board_idx);
		return postCnt;
	}
	//?†ÑÏ≤¥Í≤å?ãúÎ¨? Î¶¨Ïä§?ä∏ 
	public List<PostDTO> getPostList(int board_idx, RowBounds rowBounds){
		List<PostDTO> postList = sqlSessionTemplate.selectList("board.getPostList", board_idx, rowBounds);
		return postList;
	}
	
	
	
	//Í≤??Éâ?ïú Í≤åÏãúÎ¨ºÏùò ?àò 
	public int searchResultCount(PostDTO searchPostDTO) {
		 int search_result_count = sqlSessionTemplate.selectOne("board.searchResultCount", searchPostDTO); 
		 return search_result_count; 
	}
	//Í≤åÏãúÎ¨? Í≤??Éâ Í≤∞Í≥º Î¶¨Ïä§?ä∏
	public List<PostDTO> selectSearchList(PostDTO searchPostDTO, RowBounds rowBounds){
		return sqlSessionTemplate.selectList("board.selectSearchList", searchPostDTO, rowBounds);
	}

	
	
	
	
	
	
	//Í∏? ?ïò?Çò ?ùΩÍ∏?
	public PostDTO getPostInfo(int post_idx){
		PostDTO readPostDTO = sqlSessionTemplate.selectOne("board.getPostInfo", post_idx);
		return readPostDTO;
	}
	
	//Í∏? ?àò?†ï
	public void modifyPostInfo(PostDTO modifyPostDTO) {
		sqlSessionTemplate.update("board.modifyPostInfo", modifyPostDTO);
	}
	
	//Í∏? ?Ç≠?†ú
	public void delete(int post_idx){
		sqlSessionTemplate.delete("board.replyDelete", post_idx); 
		sqlSessionTemplate.delete("board.delete", post_idx);
	}
	
	//Ï°∞Ìöå?àò Ï¶ùÍ?
	public void viewCount(int post_idx) {
		sqlSessionTemplate.update("board.viewCount", post_idx); 
	}


	

	
	
}













