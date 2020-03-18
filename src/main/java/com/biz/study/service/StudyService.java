package com.biz.study.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.biz.study.dao.StudyDao;
import com.biz.study.domain.StudyVO;

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

	public int insert(StudyVO studyVO) {

		LocalDateTime ldt = LocalDateTime.now();
		DateTimeFormatter dt = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

		studyVO.setS_s_time(ldt.format(dt).toString());

		return studyDao.insert(studyVO);

	}

	public int update(StudyVO studyVO) {

		LocalDateTime ldt = LocalDateTime.now();
		DateTimeFormatter dt = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

		studyVO.setS_s_time(ldt.format(dt).toString());

		return studyDao.update(studyVO);
	}

	public int fTime(StudyVO studyVO) throws ParseException {

		LocalDateTime ldt = LocalDateTime.now();
		DateTimeFormatter dt = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

		
		// 종료시간 VO에 넣어주는 코드
		studyVO.setS_f_time(ldt.format(dt).toString());

		// 시작시간을 가져왔다.
		String s_time = studyVO.getS_s_time();
		String f_time = studyVO.getS_f_time();
		
		SimpleDateFormat s_s_time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date sTime = s_s_time.parse(s_time);
		
		SimpleDateFormat s_f_time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date fTime = s_f_time.parse(f_time);
		
		long rTime = fTime.getTime() - sTime.getTime();
		long sec = rTime / 1000;
		
		long hour = sec / 3600;
		long minute = sec / 60;
		
		String time = String.format("%d:%d:%d", hour,minute,sec);
		
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
