package com.biz.study.service;

import org.springframework.stereotype.Service;

import com.biz.study.domain.PageVO;

@Service
public class PageService {

	private int listPerPage = 10; // 한 페이지에 보여질 데이터 개수
	private int pageCount =10; // 화면하단에 페이지 버튼 개수
	
//	public PageService(int listPerPage, int pageCount) {
//		this.listPerPage = listPerPage;
//		this.pageCount = pageCount;
//	}
	
	// totalCount : 총 데이터 개수
	// currentPageNo : 현재 페이지 번호
	public PageVO getPagination(long totalCount, int currentPageNo) {
		
		if(totalCount < 1) {
			return null;
		}
		
		// 전체 대이터의 마지막 페이지는
		// 데이터 총 개수 + (한페이지에 보여질 데이터 개수 - 1) / 한 페이지에 보여질 데이터 개수
		// ex) n = (100 + (10 - 1) ) / 10
		// n = 10.9가 되지만 int형이기때문에 소수점 자리가 잘려나간다.
		// 즉 finalPageNo = 10이 된다.
		int finalPageNo = ((int)totalCount + (listPerPage - 1)) / listPerPage;
		
		// 현재 페이지 번호가 마지막 페이지 번호보다 클 경우 
		// 현재 페이지 번호가 마지막 페이지 번호이다.
		if(currentPageNo > finalPageNo) {
			currentPageNo = finalPageNo;
		}
		
		if(currentPageNo < 1) {
			currentPageNo = 1;
		}
		
		// startPageNo : 화면에 보여질 첫페이지 번호 버튼
		// ex) ( (7-1) / 10 ) * 10 + 1
		int startPageNo = ((currentPageNo - 1) / pageCount) * pageCount + 1;
		
		// endPageNo : 화면에 보여질 마지막 페이지 번호 버튼
		int endPageNo = startPageNo + pageCount - 1;
		
		if(endPageNo > finalPageNo) {
			endPageNo = finalPageNo;
		}
		
		// prePageNo : 이전 페이지로 이동
		int prePageNo = 1;
		
		// 현재페이지가 1페이지 보다 크다면
		// 이전페이지는 현재페이지 - 1이다.
		if( currentPageNo > 1) {
			prePageNo = currentPageNo -1;
		}
		
		int nextPageNo = finalPageNo;
		if(currentPageNo < finalPageNo) {
			nextPageNo = currentPageNo + 1;
		}
	
		// offset: 1, 2, 3 등 페이지를 선택햇을 경우 
		// 시작번호를 1, 11 21 로 설정
		int offset = (currentPageNo - 1) * listPerPage + 1;
		
		// 화면에 보여지는 끝번호를 10, 20, 30으로 설정하기
		int limit = offset + listPerPage -1 ;
		
		PageVO pageVO = PageVO.builder()
				.totalCount(totalCount)
				.pageCount(pageCount)
				
				.listPerPage(listPerPage)
				.offset(offset)
				.limit(limit)
				
				.firstPageNo(1)
				.finalPageNo(finalPageNo)
				
				.startPageNo(startPageNo)
				.endPageNo(endPageNo)
				
				.prePageNo(prePageNo)
				.nextPageNo(nextPageNo)
				
				.currentPageNo(currentPageNo)
				.build();
		
		return pageVO;
	}
	
}
