package com.tjoeun.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tjoeun.spring.dao.ReplyDAO;
import com.tjoeun.spring.dto.ReplyDTO;

@Service
public class ReplyService {
	
	@Autowired
    ReplyDAO replyDAO;
	
	//?Œ“ê¸?ì¡°íšŒ
	public List<ReplyDTO> list(int post_idx){
	    return replyDAO.list(post_idx);
	}

	//?Œ“ê¸??“°ê¸?
	public void write(ReplyDTO writeReplyDTO) {
	    replyDAO.write(writeReplyDTO);
	}

	
	//?Œ“ê¸??‚­? œ
	public void delete(int reply_idx){
	    replyDAO.delete(reply_idx);
	}

     
	
}
 