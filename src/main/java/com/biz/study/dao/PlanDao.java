package com.biz.study.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.biz.study.domain.PlanVO;

@Mapper
public interface PlanDao {

	@Select("select * from tbl_plan")
	public List<PlanVO> selectAll();
	
	@Select("select * from tbl_plan where p_s_id = #{p_s_id}")
	public List<PlanVO> findByPId(@Param(value = "p_s_id") long p_s_id);
	
	public int insert(PlanVO planVO);
	
	public int delete(long p_seq);
	
	public int checkBox(PlanVO planVO);
}
