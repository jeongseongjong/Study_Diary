<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>□□□ 나의 JSP 페이지 □□□</title>
<!-- 컨테이너 및 main-subject, sub-title 설정 요소 값들-->
<link rel="stylesheet" href="${rootPath}/css/main.css">

<!-- 로그인 페이지 요소 설정 값들-->
<link rel="stylesheet" href="${rootPath}/css/login.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.2/css/all.min.css" />
</head>
<body>
	<form method="POST" action="${rootPath}/user/login" class="container">
		<div class="login-box">
			<div class="main-subject">
				<a href="${rootPath}/">로그인</a>
			</div>
			<c:if test="${msg == 'FAIL'}">
				<h3>아이디 또는 패스워드가 잘못되었습니다.</h3>
			</c:if>
			<input type="text" name="u_id" id="u_id" placeholder="ID를 입력하세요"><br />
			<input type="password" name="u_pw" placeholder="Password"><br />
			<button id="key">
				<i class="fas fa-key fa-2x"></i>
			</button>
			<div class="login-util-box">
				<div class="join">
					<a href="${rootPath}/user/join">회원가입</a>
				</div>
			</div>
		</div>
	</form>

</body>
</html>