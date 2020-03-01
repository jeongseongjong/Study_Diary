<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<%@ include file="/WEB-INF/views/include/include-head.jspf"%>
<title>□□□ 나의 JSP 페이지 □□□</title>
</head>
<style>

</style>
<body>
	<%@ include file="/WEB-INF/views/include/include-header.jspf"%>
	<div class="container">
		<div class="study-title col-9">제목</div>
		<div class="study-title col-2">작성자</div><br/>
		<div class="study-title col-4">시작시간</div>
		<div class="study-title col-4">종료시간</div><br/>
		<div class="study-title col-4">공부시간</div>
		<%@ include file="/WEB-INF/views/plan/plan-list.jsp" %>
	</div>
</body>
</html>