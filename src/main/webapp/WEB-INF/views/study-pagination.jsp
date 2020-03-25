<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />

	<div class="ml-auto mr-auto mt-30">
		<ul class="pagination">
			<c:if test="${pageVO.startPageNo > 1}">
				<li class="page-item"><a
					href="${rootPath}/list?currentPageNo=1" class="page-link">1</a></li>
				<li class="page-item"><a
					href="${rootPath}/list?currentPageNo=${pageVO.prePageNo}"
					class="page-link">&lt;</a>
			</c:if>
			<c:forEach begin="${pageVO.startPageNo}" end="${pageVO.endPageNo}"
				var="pageNo">
				<li
					class="page-item <c:if test="${pageNo == pageVO.currentPageNo}"> active</c:if>">
					<a href="${rootPath}/list?currentPageNo=${pageNo}"
					class="page-link">${pageNo}</a>
				</li>
			</c:forEach>
			<c:if test="${pageVO.endPageNo != pageVO.finalPageNo}">
				<li class="page-item"><a
					href="${rootPath}/list?currentPageNo=${pageVO.nextPageNo}"
					class="page-link">&gt;</a></li>
				<li class="page=item"><a
					href="${rootPath}/list?currentPageNo=${pageVO.finalPageNo}"
					class="page-link">${pageVO.finalPageNo}</a></li>
			</c:if>
		</ul>
	</div>

