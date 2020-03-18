package com.biz.study.controller;

import java.text.ParseException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.biz.study.domain.CommentVO;
import com.biz.study.domain.StudyVO;
import com.biz.study.domain.UserVO;
import com.biz.study.service.CommentService;
import com.biz.study.service.StudyService;
import com.biz.study.service.UserService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequiredArgsConstructor
public class StudyController {
	
	private final StudyService studyService;
	private final UserService userService;
	private final CommentService cmtService;
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(Model model) {
		
		List<StudyVO> studyList = studyService.selectAll();
		log.debug("스터디 리스트 : " + studyList);
		model.addAttribute("STUDY_LIST", studyList);
		
		return "study-list";
	}
	
	@RequestMapping(value="/insert", method=RequestMethod.GET)
	public String insert() {
		
		return "study-insert";
	}
	
	@RequestMapping(value="/insert", method=RequestMethod.POST, produces = "text/html;charset=UTF-8")
	public String insert(StudyVO studyVO) {
		
		log.debug("여기는 insert 전 기록 : " + studyVO);
		
		studyService.insert(studyVO);
		
		log.debug("여기는 인서트 기록 : " + studyVO);
		
		return "redirect:/list";
	}
	
	@RequestMapping(value="/update",method=RequestMethod.GET)
	public String update(@RequestParam("s_seq")long s_seq, Model model) {
		
		StudyVO studyVO = studyService.findBySeq(s_seq);
		
		model.addAttribute("STUDY", studyVO);
		log.debug("여기는 update1" + studyVO);
		
		return "study-insert";
	}
	
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public String update(@RequestParam("s_seq")long s_seq, StudyVO studyVO) {
		
		log.debug("여기는 update2" + studyVO);
		
		studyVO = studyService.findBySeq(s_seq);
		
		studyService.update(studyVO);
		
		return "redirect:/list";
	}
	
	
	@RequestMapping(value="/delete",method=RequestMethod.GET)
	public String delete(long s_seq) {
		
		log.debug("딜리트가 되니마니 ");
		studyService.delete(s_seq);
		
		return "redirect:/list";
	}
	 
	@RequestMapping(value="/detail",method=RequestMethod.GET, produces = "text/html;charset=UTF-8")
	public String detail(@RequestParam(value="seq", required = false)String s_seq, Model model) {
		
		log.debug("컨트롤러 : " + s_seq);
	
		StudyVO studyVO = studyService.findBySeq(Long.valueOf(s_seq));
		List<CommentVO> cmtList = cmtService.findBySId(studyVO.getS_seq());
		
		log.debug("디테일 : " +cmtList.toString());
		log.debug("detail VO : " + studyVO);
		
		model.addAttribute("studyVO", studyVO);
		model.addAttribute("CMT_LIST",cmtList);
		
		return "study-detail";
	}
	
	
	
//	@RequestMapping(value="/fTime", method=RequestMethod.GET)
//	public String fTime(@RequestParam(value="s_seq",required=false)String s_seq, Model model) {
//		
//		StudyVO studyVO = studyService.findBySeq(Long.valueOf(s_seq));
//		
//		log.debug("여기는 fTime 1이에용" + studyVO.toString());
//		
//		model.addAttribute("fVO",studyVO);
//		
//		return "study-detail";
//		
//	}
	
	@RequestMapping(value="/fTime",method=RequestMethod.POST)
	public String fTime(@RequestParam(value="s_seq",required=false)long s_seq, Model model) throws ParseException {
		
		StudyVO studyVO = studyService.findBySeq(s_seq);
		studyService.fTime(studyVO);
		
		log.debug("여기는 fTime 2 에용" + studyVO.toString());
		
		model.addAttribute("studyVO", studyVO);
		
		return "study-update";
		
	}
}
