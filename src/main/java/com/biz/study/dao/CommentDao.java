package com.biz.study.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;

import com.biz.study.domain.CommentVO;

public interface CommentDao {

	public CommentVO findById(long c_seq);
	
	public List<CommentVO> findBySId(long c_s_id); 
	
	public int insert(CommentVO cmtVO);
	
	@Delete("delete from tbl_comment where c_seq = #{c_seq}")
	public int delete(long c_seq);
}
