package com.tjoeun.spring.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tjoeun.spring.dto.ReplyDTO;

@Repository
public class ReplyDAO {
    
	@Autowired
    SqlSessionTemplate sqlSessionTemplate;
    
	//?Œ“ê¸? ì¡°íšŒ
	public List<ReplyDTO> list(int post_idx){
	    return sqlSessionTemplate.selectList("reply.replyList", post_idx);
	}

	// ?Œ“ê¸? ?ž‘?„±
	public void write(ReplyDTO writeReplyDTO){
	    sqlSessionTemplate.insert("reply.replyWrite", writeReplyDTO);
	}

	// ?Œ“ê¸? ?ˆ˜? •
	public void modify(ReplyDTO modifyReplyDTO){
		sqlSessionTemplate.update("reply.replyModify", modifyReplyDTO);
	}

	// ?Œ“ê¸? ?‚­? œ
	public void delete(int reply_idx){
		sqlSessionTemplate.delete("reply.replyDelete", reply_idx);
	}

        
    
    
}

