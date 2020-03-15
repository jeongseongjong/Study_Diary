package com.biz.study.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.biz.study.domain.PlanVO;
import com.biz.study.service.PlanService;

import lombok.RequiredArgsConstructor;

@RequestMapping(value="plan")
@Controller
@RequiredArgsConstructor
public class PlanController {

	private final PlanService planService;
	
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public String list(String s_seq, Model model) {
		
		long s_p_seq = Long.valueOf(s_seq);
		
		List<PlanVO> planList = planService.findByPSeq(s_p_seq);
		model.addAttribute("PLAN_LIST", planList);
		
		return "plan/plan-list";
	}
	
	@RequestMapping(value="/insert",method=RequestMethod.POST)
	public String insert(PlanVO planVO) {
		
		planService.insert(planVO);
		
		return "redirect:/plan/list";
	}
}
