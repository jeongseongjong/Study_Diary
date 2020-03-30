package com.biz.study.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.biz.study.domain.PlanVO;
import com.biz.study.service.PlanService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequestMapping(value="plan")
@Controller
@Slf4j
@RequiredArgsConstructor
public class PlanController {

	private final PlanService planService;
	
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public String list(@RequestParam(value="p_s_id", required = false)long p_s_id, Model model) {
		
		long p_id = Long.valueOf(p_s_id);
		log.debug("여기는 p_s_id" + p_id);
		
		List<PlanVO> planList = planService.findByPId(p_id);
		model.addAttribute("PLAN_LIST", planList);
		log.debug("여기는 검색 " + planList);
		return "plan/plan-list";
	}
	
	@RequestMapping(value="/insert",method=RequestMethod.GET)
	public String insert() {

		return "detail";
	}
	
	@RequestMapping(value="/insert",method=RequestMethod.POST)
	public String insert(PlanVO planVO,Model model) {
		log.debug("여기는 플랜 인서트 1번"+ planVO) ;
		planService.insert(planVO);
		log.debug("여기는 플랜 인서트 2번"+ planVO) ;
		
		return "redirect:/plan/list";
	}
	
	@RequestMapping(value="/checkBox",method=RequestMethod.GET)
	public String checkBox(@RequestParam("p_s_id")long p_s_id, Model model) {
		
		List<PlanVO> planVO = planService.findByPId(p_s_id);
		model.addAttribute("CHECK", planVO);
		
		return "plan/plan-list";
	}
	
	@RequestMapping(value="/checkBox",method=RequestMethod.POST)
	public String checkBox(PlanVO planVO) {
		planService.checkBox(planVO);
		
		return "redirect:/plan/list";
	}
}
