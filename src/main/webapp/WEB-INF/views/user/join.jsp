<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>
<!-- 컨테이너 및 main-subject, sub-title 설정 요소 값들-->

<!-- 로그인 페이지 요소 설정 값들-->
<!-- 로그인 요소를 일부 사용하고 아래에서 재설정했습니다. 순서대로 배치해주세요.-->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script type="text/javascript">
	$(function() {
		
		$("#btn-save").click(function(){
			
			let pw = $("#u_pw").val()
			let re_pw = $("#u_re_pw").val()
			if(pw != re_pw){
				alert("비밀번호가 맞지 않습니다.")
				return false
			}
			
			$(".user-form").submit()
		})
		
		$("#id_check").click(function() {
			let u_id = $("#u_id").val()
			let u_result = $(".overlap-check-result").val()
			$.ajax({
				type : "POST",
				url : '${rootPath}/user/idcheck',
				data : {
					'u_id' : u_id
				},
				success : function(result) {
	
					alert(result)
					if (result) {
						$(".overlap-check-result").text("사용가능한 ID")
					} else {
						$(".overlap-check-result").text("이미 사용중인 ID")
					}
				}
			})
		})
	})
</script>
<%@ include file="/WEB-INF/views/include/include-head.jspf"%>
</head>
<body>
	<%@ include file="/WEB-INF/views/include/include-header.jspf"%>
	<fieldset>
		<div class="container">
			<div class="login-box">
				<div class="main-subject">회원가입</div>
				<form:form modelAttribute="userVO" autocomplete="on"
					class="user-form">
					<div class="text-box">아이디</div>
					<form:input path="u_id" type="text" placeholder="사용할 ID를 입력하세요" />
					<br />
					<button id="id_check" class="check-btn" type="button">
						중복확인</button>
					<form:errors path="u_id" class="in-error" />
					<span id="msg"></span>
					<div class="overlap-check-result"></div>
					<div class="text-box">비밀번호</div>
					<div>
						<form:input path="u_pw" type="password"
							class="text-box-warning" placeholder="문자,숫자를 합하여 8자리 이상 입력하세요" />
						<form:errors path="u_pw" class="in-error" />	
					</div>
					<div>
						<input type="password" id="u_re_pw"
							placeholder="비밀번호를 다시한번 입력하세요">
						<form:errors path="u_re_pw" class="in-error" />
					</div>

					<button id="btn-save" type="button">회원가입</button>
				</form:form>
			</div>
		</div>
	</fieldset>
</body>
</html>