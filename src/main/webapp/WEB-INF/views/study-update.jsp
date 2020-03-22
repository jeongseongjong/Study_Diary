<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
.content {
	border: 1px solid #ccc;
	border-radius: 3px;
	
}
</style>
</head>
<body>
	<div>
		<input class="seq" type="hidden" name="${studyVO.s_seq}"
			data-id="${studyVO.s_seq}">
		<div class="study-title ">제목 : ${studyVO.s_subject}</div>
		<div class="study-title ">작성자 : ${studyVO.s_auth}</div>
		<div class="study-title ">카테고리 : ${studyVO.s_cate }</div>
		<br />

		<div class="study-title">시작시간 : ${studyVO.s_s_time}</div>
		
		<c:choose>
			<c:when test="${!empty studyVO.s_f_time}">

				<!-- 
				view에서 controller로 값을 보내줄때는 기본 String형이기때문에
				long또는 int형일 경우 value값을 0으로 지정해줘서 같이 보내줘야 한다.
			 -->
				<input type="hidden" name="s_seq" id="s_seq" value="0">
				<input type="hidden" name="s_f_time" id="s_f_time"
					value="${studyVO.s_f_time}">
				<div class="study-title" id="st_end">종료시간 :
					${studyVO.s_f_time}</div>
				<div class="study-title">공부시간 : ${studyVO.s_r_time}</div>
			</c:when>
		</c:choose>
		<div >
			<div class="study-title">내용</div>
			<div class="study-title  mt-1 mb-2 content">${studyVO.s_content}</div>
		</div>
		
	</div>
</body>
</html>

