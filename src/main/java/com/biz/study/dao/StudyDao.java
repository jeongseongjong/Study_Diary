package com.biz.study.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.biz.study.domain.StudyVO;

@Mapper
public interface StudyDao {

	@Select("select * from tbl_study")
	public List<StudyVO> selectAll();

	@Select("select * from tbl_study where s_id = #{s_id} ")
	public StudyVO findBySId(long s_id);
	
	@Select("select * from tbl_study where s_seq = #{s_seq} ")
	public StudyVO findBySeq(long s_seq);

	public int insert(StudyVO studyVO);

	public int update(StudyVO studyVO);

	@Delete("delete from tbl_study where s_seq = #{s_seq}")
	public int delete(long s_seq);


}
