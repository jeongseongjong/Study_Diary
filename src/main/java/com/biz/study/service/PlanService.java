package com.biz.study.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.biz.study.dao.PlanDao;
import com.biz.study.dao.UserDao;
import com.biz.study.domain.PlanVO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PlanService {

	private final PlanDao planDao;
	
	public List<PlanVO> selectAll(){
		
		return planDao.selectAll();
	}
	
	public List<PlanVO> findByPId(long p_s_id) {
		
		return planDao.findByPId(p_s_id);
	}

	public int insert(PlanVO planVO) {

		
		return planDao.insert(planVO);
	}
	
	public int checkBox(PlanVO planVO) {
		if(planVO.getP_complete() == 1) {
			planVO.setP_complete(0);
		}else {
			planVO.setP_complete(1);
		}
		return planDao.checkBox(planVO);
	}
	
}
