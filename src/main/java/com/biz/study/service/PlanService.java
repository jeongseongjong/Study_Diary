package com.biz.study.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.biz.study.dao.PlanDao;
import com.biz.study.domain.PlanVO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PlanService {

	private final PlanDao planDao;
	
	public List<PlanVO> findByPSeq(long p_seq) {
		
		return planDao.findByPSeq(p_seq);
	}

	public int insert(PlanVO planVO) {

		return planDao.insert(planVO);
	}
}
