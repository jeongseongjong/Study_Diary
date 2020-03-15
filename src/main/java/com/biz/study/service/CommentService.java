package com.biz.study.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.stereotype.Service;

import com.biz.study.dao.CommentDao;
import com.biz.study.domain.CommentVO;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class CommentService {

	private final CommentDao cmtDao;

	public List<CommentVO> findBySId(long c_s_id) {

		List<CommentVO> list = cmtDao.findBySId(c_s_id);
		
		log.debug("서비스 : " +list.toString());
		
		return list;
	}

	public int insert(CommentVO cmtVO) {
		LocalDateTime ldt = LocalDateTime.now();

		DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

		cmtVO.setC_date(ldt.format(df).toString());
		int ret = cmtDao.insert(cmtVO);
		
		return ret;
	}

	public int delete(long c_seq) {

		return cmtDao.delete(c_seq);
	}
}
