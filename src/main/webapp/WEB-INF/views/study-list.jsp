<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>□□□ 나의 JSP 페이지 □□□</title>
<%@ include file="/WEB-INF/views/include/include-head.jspf"%>
</head>
<style>
.container {
	font-size: 20px;
	background-color: none;
}

.list-title {
	border-top: 3px solid #B45F04;
	border-bottom: 1px solid #ccc;
}

.foreach-list:hover {
	border: 1px solid gray;
	cursor: pointer;
}

.header {
	padding-bottom: 50px;
}
</style>
<script>
	$(function() {

		$(".std-insert").click(function() {

			document.location.href = "${rootPath}/insert"

		})

		$(".list-content").click(function() {

			let id = $(this).data('id')

			document.location.href = "${rootPath}/detail?seq=" + id
		})

	})
</script>

<body>
	<div class="header">
		<%@ include file="/WEB-INF/views/include/include-header.jspf"%>
	</div>
	<div class="container">
		<div class=" list-title d-flex">
			<div class="col-2">번호</div>
			<div class="col-2">작성자</div>
			<div class="col-5">제목</div>
			<div class="col-3">작성시각</div>
		</div>
		<c:forEach items="${STUDY_LIST}" var="study">
			<div class="foreach-list">
				<div class="list-content d-flex" data-id="${study.s_seq}">
					<div class="col-2">${study.s_seq}</div>
					<div class="col-2">${study.s_auth}</div>
					<div class="col-5">${study.s_subject}</div>
					<div class="col-3">${study.s_s_time }</div>
				</div>
				<hr />
			</div>
		</c:forEach>
		<div>
			<button class="btn float-right btn-secondary std-insert">다이어리
				작성</button>
		</div>
	</div>
	<div>
		<c:choose>
			<c:when test="${empty STUDY_LIST}">
				<div>데이터가 없습니다.</div>
			</c:when>
			<c:otherwise>
				<div class="pagination">
					<%@ include file="/WEB-INF/views/study-pagination.jsp"%>
				</div>
			</c:otherwise>
		</c:choose>
	</div>
</body>
</html>