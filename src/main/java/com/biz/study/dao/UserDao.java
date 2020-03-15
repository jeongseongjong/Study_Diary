package com.biz.study.dao;

import org.apache.ibatis.annotations.Select;

import com.biz.study.domain.UserVO;

public interface UserDao {

	public int userInsert(UserVO userVO);
	
	@Select("select * from tbl_user where u_id = #{u_id}")
	public UserVO findById(String u_id);
}
