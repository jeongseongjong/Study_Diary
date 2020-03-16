package com.biz.study.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.biz.study.domain.CommentVO;
import com.biz.study.domain.UserVO;
import com.biz.study.service.CommentService;

import lombok.extern.slf4j.Slf4j;

@RequestMapping(value="comment")
@Slf4j
@Controller
public class CommentController {

	@Autowired
	private CommentService cmtService;
	
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public String list(String s_id, Model model) {
		
		long c_s_id = Long.valueOf(s_id);
		
		List<CommentVO> cmtList = cmtService.findBySId(c_s_id);
		model.addAttribute("CMT_LIST", cmtList);
		log.debug("댓글 리스트에용" + cmtList);
		
		return "comment/comment-list";
	}
	
	@RequestMapping(value="/insert",method=RequestMethod.POST)
	public String insert(CommentVO cmtVO, Model model, HttpSession hSession) {
		
		
		log.debug("여기는 인서트 에용" + cmtVO.toString());
		
		int ret = cmtService.insert(cmtVO);
		
		log.debug("여기는 인서트 2 에용" + cmtVO.toString());
		
		// 로그인 된 id를 가져오기위해 session에서 userVO를 가져와
		// 재 cast를 해주어야 한다.
		UserVO userVO = (UserVO) hSession.getAttribute("userVO");
		
		model.addAttribute("writer", userVO.getU_id());
		
		log.debug(userVO.getU_id());
		model.addAttribute("id",cmtVO.getC_s_id());
		return "redirect:/comment/list";
		
	}
	
	@RequestMapping(value="/delete",method=RequestMethod.GET)
	public String delete(String c_seq, String s_id, Model model) {
	
		// c_seq를 받아 해당하는 댓글에 대한 delete 수행
		cmtService.delete(Long.valueOf(c_seq));
		
		// s_id를 model에 담아 list에 넘겨주고 삭제되면 리스트를 redirect해준다.
		model.addAttribute("s_id",s_id);
		
		return "redirect:/comment/comment-list";
	}
}
