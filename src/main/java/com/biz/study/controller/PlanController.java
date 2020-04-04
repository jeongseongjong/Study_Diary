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
	public String list(@RequestParam(value="p_s_id",required = false, defaultValue = "0")long p_s_id,
						@RequestParam(value="p_seq",required = false, defaultValue = "0")long p_seq, Model model) {
		
		log.debug("p_s_id가 정녕 안오는것인가" + p_s_id);
		List<PlanVO> planList = planService.findByPId(p_s_id);
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
		log.debug("여기는 insert의 p_s_id" + planVO.getP_s_id());
		
		model.addAttribute("p_s_id",planVO.getP_s_id());
		
		return "redirect:/plan/list";
	}
	
	
	@RequestMapping(value="/selectData",method=RequestMethod.GET)
	public String selectData() {

		return "detail";
	}
	
	@RequestMapping(value="/selectData",method=RequestMethod.POST)
	public String selectData(@RequestParam(value="planVO", required = false)PlanVO planVO,Model model) {
		log.debug("여기는 플랜 셀렉트 1번"+ planVO) ;
		
		model.addAttribute("p_s_id",planVO.getP_s_id());
		
		return "redirect:/plan/list";
	}
	
	@RequestMapping(value="/checkBox",method=RequestMethod.GET)
	public String checkBox(@RequestParam("p_s_id")long p_s_id, Model model) {
		
		List<PlanVO> planVO = planService.findByPId(p_s_id);
		model.addAttribute("CHECK", planVO);
		
		return "plan/plan-list";
	}
	
	@RequestMapping(value="/checkBox",method=RequestMethod.POST)
	public String checkBox(@RequestParam("p_seq")long p_seq,PlanVO planVO) {
		planService.checkBox(planVO);
		log.debug("여기는 체크박스의 planVO " +planVO);
		log.debug("여기는 체크박스의 p_seq " +planVO.getP_seq());
		
		return "redirect:/plan/list";
	}
}
