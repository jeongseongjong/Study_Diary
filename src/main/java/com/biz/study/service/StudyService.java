package com.biz.study.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.stereotype.Service;

import com.biz.study.dao.StudyDao;
import com.biz.study.domain.StudyVO;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class StudyService {

	private final StudyDao studyDao;
	
	public List<StudyVO> selectAll(){
		
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

	
	public int delete(long s_seq) {

		return studyDao.delete(s_seq);
	}

	public StudyVO detail(long s_seq) {
		
		return studyDao.findBySeq(s_seq);
	}
	
	
}
