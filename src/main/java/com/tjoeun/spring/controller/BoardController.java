package com.tjoeun.spring.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.tjoeun.spring.dto.PostDTO;
import com.tjoeun.spring.dto.ReplyDTO;
import com.tjoeun.spring.dto.PageDTO;
import com.tjoeun.spring.dto.MemberDTO;
import com.tjoeun.spring.service.BoardService;
import com.tjoeun.spring.service.ReplyService;


@Controller
@RequestMapping("/board")
public class BoardController {
	@Autowired
	private BoardService boardService;
	@Autowired
	private ReplyService replyService;
	
	@Resource(name="loginMemberDTO")
	@Lazy
	private MemberDTO loginMemberDTO;
	
	//Í≤åÏãú?åê Î©îÏù∏?ôîÎ©?
	@GetMapping("/main")
	public String main(@RequestParam("board_idx") int board_idx, @RequestParam(value="page", defaultValue="1") int page, Model model) {
		model.addAttribute("board_idx",board_idx);
		String board_name = boardService.getBoardName(board_idx);
		model.addAttribute("board_name", board_name);

		List<PostDTO> postList = boardService.getPostList(board_idx, page);
		model.addAttribute("postList", postList);
				
		//?éò?ù¥Ïß?
		PageDTO pageDTO = boardService.getPostCnt(board_idx, page); 
		model.addAttribute("pageDTO", pageDTO);
		model.addAttribute("page", page);
			
		return "board/main";
	}
		
	//Í∏??ùΩÍ∏?
	@GetMapping("/read")
	public String read(
	@RequestParam("board_idx") int board_idx,
	@RequestParam("post_idx") int post_idx, 
	@RequestParam("page") int page,
	@ModelAttribute("readPostDTO") PostDTO postDTO, Model model) {
		
		boardService.viewCount(postDTO.getPost_idx()); //Ï°∞Ìöå?àò Ï¶ùÍ? 
		PostDTO readPostDTO = boardService.getPostInfo(post_idx);
		
		model.addAttribute("readPostDTO", readPostDTO);
		model.addAttribute("board_idx", board_idx);
		model.addAttribute("post_idx", post_idx);

		model.addAttribute("loginMemberDTO", loginMemberDTO);
		model.addAttribute("page", page);
		
		//?åìÍ∏?Ï∂úÎ†• 
		List<ReplyDTO> reply = null;
		reply = replyService.list(post_idx);
		model.addAttribute("reply", reply); 
		//?ù¥ Î¶¨Ìîå?? board/read ?éò?ù¥Ïß??óê?Ñú Î∞òÎ≥µÎ¨∏Ïóê?Ñú?ùò Í∑∏Í≤É
			return "board/read";
	}
	
	//Í∏??ì∞Í∏?
	@GetMapping("/write")
	public String write(		// parameterÎ°? ?ì§?ñ¥?ò§?äî board_idx Í∞íÏùÑ writePostDTO ?óê ?Ñ£?ñ¥Ï§?
			@ModelAttribute("writePostDTO") PostDTO writePostDTO, 
			@RequestParam("board_idx") int board_idx) {
		
			writePostDTO.setPost_board_idx(board_idx);
			
			return "board/write";
	}
	
	@PostMapping("/write_proc")
	public String writeProc
	(@Valid @ModelAttribute("writePostDTO") PostDTO writePostDTO, 
	BindingResult result, MultipartFile file) {
		
		if(result.hasErrors()) { 
			return "board/write";
		}
		boardService.addPostInfo(writePostDTO);
			return "board/write_success";
	}
	
	//Í∏? ?àò?†ï?? Î≥∏Ïù∏Îß? ?ï†?àò ?ûà?èÑÎ°?
	@GetMapping("/not_writer")
	public String notWriter() {
		return "board/not_writer";
	}
	
	//?àò?†ï?ïòÍ∏?
	@GetMapping("/modify")
	public String modify(
		@RequestParam("board_idx") int board_idx,
		@RequestParam("post_idx") int post_idx, 
		@ModelAttribute("modifyPostDTO") PostDTO modifyPostDTO, //?àò?†ï???ÉÅ Í∑? Í∏?
		@RequestParam("page") int page, Model model) {
		
		model.addAttribute("board_idx", board_idx);
		model.addAttribute("post_idx", post_idx);
		model.addAttribute("page", page);
		
		PostDTO fromDBPostDTO = boardService.getPostInfo(post_idx); //?àò?†ï?ïòÍ≥†Ïûê ?ïò?äî Í∑? Í∏?! 
		
		//?àò?†ï?ïò?äî Í∑? Í≥ºÏ†ï
		modifyPostDTO.setPost_writer_name(fromDBPostDTO.getPost_writer_name()); 
		modifyPostDTO.setPost_date(fromDBPostDTO.getPost_date());
		modifyPostDTO.setPost_subject(fromDBPostDTO.getPost_subject());
		modifyPostDTO.setPost_text(fromDBPostDTO.getPost_text());
		modifyPostDTO.setPost_file(fromDBPostDTO.getPost_file());
		modifyPostDTO.setPost_writer_idx(fromDBPostDTO.getPost_writer_idx());
		modifyPostDTO.setPost_board_idx(board_idx);
		modifyPostDTO.setPost_idx(post_idx);
		
			return "board/modify";
	}
	
	@PostMapping("/modify_proc")
	public String modifyProc
	(@Valid @ModelAttribute("modifyPostDTO") PostDTO modifyPostDTO, 
	BindingResult result, @RequestParam("page") int page, Model model) {
		
		model.addAttribute("page", page);
		
		if(result.hasErrors()) {
			return "board/modify";
		}
		boardService.modifyPostInfo(modifyPostDTO);
			return "board/modify_success";
	}
	
	
	
	
	
	//Í∏??Ç≠?†ú
	@GetMapping("/delete")
	public String delete
	(PostDTO deletePostDTO, 
	@RequestParam("board_idx") int board_idx, 
	Model model){

		boardService.delete(deletePostDTO.getPost_idx());
		model.addAttribute("board_idx", board_idx);
			return "board/delete";
	}

	
	
	//Í≤åÏãúÎ¨? Í≤??Éâ
	@GetMapping("/search_result")
	private String getSearchList(
		@RequestParam("post_board_idx") int board_idx, 
		@RequestParam("type") String type, 
		@RequestParam("keyword") String keyword,
		@RequestParam(value="page", defaultValue="1") int page, 
		Model model) throws Exception{
			
		PostDTO searchPostDTO = new PostDTO();
		searchPostDTO.setPost_board_idx(board_idx); 
		searchPostDTO.setType(type); 
		searchPostDTO.setKeyword(keyword); 

		//Í≤??ÉâÍ≤∞Í≥º ?àò 
		int search_result_count = boardService.searchResultCount(searchPostDTO);
		model.addAttribute("search_result_count", search_result_count);
		
		//Í≤??ÉâÍ≤∞Í≥º Î¶¨Ïä§?ä∏ 
		List<PostDTO> searchList = boardService.selectSearchList(searchPostDTO, page);
		model.addAttribute("searchList", searchList);
		
		//?éò?ù¥Ïß?
		PageDTO pageDTO = boardService.searchListCount(searchPostDTO, page); 
		model.addAttribute("board_idx", board_idx);
		model.addAttribute("pageDTO", pageDTO);
		model.addAttribute("page", page);
		model.addAttribute("type", type);
		model.addAttribute("keyword", keyword);
		
			return "board/search_result";
	}
	
	
	

	

}
