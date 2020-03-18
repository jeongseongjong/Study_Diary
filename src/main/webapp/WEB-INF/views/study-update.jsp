<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script>
	$(function() {
		$(document).on("click", "button", function() {
			let text = $(this).text()
			if (text == '공부종료') {
				if (!confirm("공부를 종료하시겠습니까?")) {
					return false
				}

				var s_seq = (this).data("id")

				alert(s_seq)
				$.ajax({
					url : "${rootPath}/fTime?s_seq=" + s_seq,
					data : {
						s_seq : s_seq
					},
					type : "POST",
					success : function(result) {
						$("#fTime").html(result)
						//result.
					},
					error : function() {
						alert("공부 종료 오류")
					}

				})

			}
		})
	})
</script>
<body>
	<div>
		<input class="seq" type="hidden" name="${studyVO.s_seq}"
			data-id="${studyVO.s_seq}">
		<div class="study-title col-9">제목 : ${studyVO.s_subject}</div>
		<div class="study-title col-2">작성자 : ${studyVO.s_auth}</div>
		<br />

		<div class="study-title col-4">시작시간 : ${studyVO.s_s_time}</div>
		<c:choose>
			<c:when test="${!empty studyVO.s_f_time}">
				<input type="hidden" name="s_seq" id="s_seq" value="0">
				<input type="hidden" name="s_f_time" id="s_f_time"
					value="${studyVO.s_f_time}">
				<div class="study-title col-4" id="st_end">종료시간 :
					${studyVO.s_f_time}</div>
				<div class="study-title col-4">공부시간 : ${studyVO.s_s_time} -
					${studyVO.s_f_time}</div>
			</c:when>
			<c:otherwise>
				<br />
				<br />
				<button type="button" data-id="${studyVO.s_seq }"
					class="btn btn-warning ml-3 finish">공부종료</button>
			</c:otherwise>
		</c:choose>
	</div>
</body>
</html>

