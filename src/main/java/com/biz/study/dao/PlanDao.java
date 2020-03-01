package com.biz.study.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.biz.study.domain.PlanVO;

@Mapper
public interface PlanDao {

	@Select("select * from tbl_study_plan where p_seq = #{p_seq}")
	public List<PlanVO> findByPSeq(long p_seq);
	
	public int insert(PlanVO planVO);
	
	public int delete(long p_seq);
}
