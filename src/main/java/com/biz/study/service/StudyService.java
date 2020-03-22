package com.biz.study.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.biz.study.dao.StudyDao;
import com.biz.study.domain.StudyVO;
import com.biz.study.domain.UserVO;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class StudyService {

	private final StudyDao studyDao;

	public List<StudyVO> selectAll() {

		return studyDao.selectAll();
	}

	public StudyVO findBySeq(long s_seq) {

		return studyDao.findBySeq(s_seq);
	}

	public int insert(StudyVO studyVO, HttpSession session) {

		LocalDateTime ldt = LocalDateTime.now();
		DateTimeFormatter dt = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

		studyVO.setS_s_time(ldt.format(dt).toString());
		
		studyVO.setS_auth(((UserVO) session.getAttribute("userVO")).getU_id());

		return studyDao.insert(studyVO);

	}

	public int update(StudyVO studyVO) {

		return studyDao.update(studyVO);
	}

	public int fTime(StudyVO studyVO) throws ParseException {

		LocalDateTime ldt = LocalDateTime.now();
		DateTimeFormatter dt = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

		
		// 종료시간 VO에 넣어주는 코드
		studyVO.setS_f_time(ldt.format(dt).toString());

		// 시작시간을 가져온다.
		String s_time = studyVO.getS_s_time();
		
		// Date화 시켜줄 종료시간을 가져온다.
		String f_time = studyVO.getS_f_time();
		
		// Date화를 위한 SimpleDateformat객체 생성
		// Date 객체에 parse한다.
		SimpleDateFormat s_s_time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date sTime = s_s_time.parse(s_time);
		
		SimpleDateFormat s_f_time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date fTime = s_f_time.parse(f_time);
		
		// 숫자형으로 객체를 선언하고 그 객체에 Date화 된 시간에서 getTime()을 불러와 연산
		long rTime = fTime.getTime() - sTime.getTime();
		
		// 시간 계산은 밀리언 세컨드로 되기때문에 초단위로 세려면 1000을 나눠주어야 한다.
		long sec = rTime / 1000;
		
		// 시간 = 초 / 3600
		long hour = sec / 3600;
		long minute = sec / 60;
		
		// long to String 하기위해 format해준다.
		String time = String.format("0%d:0%d:0%d", hour,minute,sec);
		
		// 연산된 시간을 VO에 넣어준다.
		studyVO.setS_r_time(time);

		return studyDao.update(studyVO);
	}

	public int delete(long s_seq) {

		return studyDao.delete(s_seq);
	}

	public StudyVO detail(long s_seq) {

		return studyDao.findBySeq(s_seq);
	}

}
