package com.biz.study.service;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.biz.study.dao.UserDao;
import com.biz.study.domain.UserVO;

@Service
public class UserService {

	// 비밀번호 암호화를 위한 객체 선언
	BCryptPasswordEncoder passwordEncoder;
	
	// 회원 정보를 담을 Dao선언
	UserDao uDao;
	
	// 선언한 객체 생성자로 초기화
	@Autowired
	public UserService(SqlSession sqlssion, BCryptPasswordEncoder passwordEncoder, UserDao uDao) {
		super();
		this.passwordEncoder = passwordEncoder;
		this.uDao = uDao;
	}

	// 사용자가 비밀번호란에 적는 text를 암호화 하여 VO에 set후에 Dao로 반환
	public int userJoin(UserVO userVO) {
		String cryptext = passwordEncoder.encode(userVO.getU_pw());
		userVO.setU_pw(cryptext);
		
		return uDao.userInsert(userVO);
	}
	
	public boolean userIdCheck(String u_id) {
		
		// dao에서 id를 찾아서 vo에 담아준다.
		UserVO userVO = uDao.findById(u_id);
		
		// vo가 비어있지 않고 vo에 담겨져잇는 id와 같다면 false반환
		if(userVO != null && userVO.getU_id().equalsIgnoreCase(u_id)) {
			return false;
		}
		return true;
	}
	
	public boolean userLoginCheck(UserVO userVO) {
		
		// 로그인시 입력한 id와 pw를 가져와 객체 선언
		String inU_id = userVO.getU_id();
		String inU_pw = userVO.getU_pw();
		
		// 입력한 id값을 Dao에서 찾아서 VO에 넣어준다.
		UserVO uVO = uDao.findById(inU_id);
		
		// 입력한 id값을 받은 vo가 비어 있다면 false를 반환
		if(uVO == null) {
			return false;
		}
		
		// 입력한 id값을 담은 vo에서 id와, pw를 객체생성
		String sU_id = uVO.getU_id();
		String sU_pw = uVO.getU_pw();
		
		// 입력한 id가 VO에서 받아온 id가 똑같고 사용자가 입력한 pw와 db(vo)에 담겨져 있는 pw와 똑같다면
		if(sU_id.equalsIgnoreCase(inU_id) && passwordEncoder.matches(inU_pw, sU_pw)) {
			return true;
		}else {
			return false;
		}
	}
	
	public UserVO getUser(String u_id) {
		
		return uDao.findById(u_id);
	}
}









