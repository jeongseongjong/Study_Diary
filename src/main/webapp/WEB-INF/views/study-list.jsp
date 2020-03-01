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
<script>
	$(function() {

		$(".std-insert").click(function() {

			document.location.href = "${rootPath}/insert"

		})

	})
</script>

<body>
	<%@ include file="/WEB-INF/views/include/include-header.jspf"%>
	<div class="container">
		<div class="bg-secondary list-title d-flex text-white">
			<div class="col-2">카테고리</div>
			<div class="col-3">제목</div>
			<div class="col-5">내용</div>
		</div>
		<c:forEach items="${STUDY_LIST}" var="study">
			<div class="list-content d-flex ">
				<div class="col-2">${study.s_cate}</div>
				<div class="col-3">${study.s_subject}</div>
				<div class="col-5">${study.s_content}</div>
			</div>
		</c:forEach>
		<hr/>
		<button class="btn float-right btn-secondary std-insert">다이어리
			작성</button>
	</div>
</body>
</html>