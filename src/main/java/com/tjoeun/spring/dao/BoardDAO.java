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
	
	//�??���?
	public void addPostInfo(PostDTO writePostDTO) {
		sqlSessionTemplate.insert("board.addPostInfo", writePostDTO);
	}
	
	//게시?�� ?���? �??��?���?
	public String getBoardName(int board_idx) {
		String board_name = sqlSessionTemplate.selectOne("board.getBoardName", board_idx);
			return board_name; 	
	}
	//게시�? ?��체수
	public int getPostCnt(int post_board_idx) {
		int postCnt = sqlSessionTemplate.selectOne("board.getPostCnt", post_board_idx);
		return postCnt;
	}
	//?��체게?���? 리스?�� 
	public List<PostDTO> getPostList(int board_idx, RowBounds rowBounds){
		List<PostDTO> postList = sqlSessionTemplate.selectList("board.getPostList", board_idx, rowBounds);
		return postList;
	}
	
	
	
	//�??��?�� 게시물의 ?�� 
	public int searchResultCount(PostDTO searchPostDTO) {
		 int search_result_count = sqlSessionTemplate.selectOne("board.searchResultCount", searchPostDTO); 
		 return search_result_count; 
	}
	//게시�? �??�� 결과 리스?��
	public List<PostDTO> selectSearchList(PostDTO searchPostDTO, RowBounds rowBounds){
		return sqlSessionTemplate.selectList("board.selectSearchList", searchPostDTO, rowBounds);
	}

	
	
	
	
	
	
	//�? ?��?�� ?���?
	public PostDTO getPostInfo(int post_idx){
		PostDTO readPostDTO = sqlSessionTemplate.selectOne("board.getPostInfo", post_idx);
		return readPostDTO;
	}
	
	//�? ?��?��
	public void modifyPostInfo(PostDTO modifyPostDTO) {
		sqlSessionTemplate.update("board.modifyPostInfo", modifyPostDTO);
	}
	
	//�? ?��?��
	public void delete(int post_idx){
		sqlSessionTemplate.delete("board.replyDelete", post_idx); 
		sqlSessionTemplate.delete("board.delete", post_idx);
	}
	
	//조회?�� 증�?
	public void viewCount(int post_idx) {
		sqlSessionTemplate.update("board.viewCount", post_idx); 
	}


	

	
	
}













