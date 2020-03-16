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
.comment {
	border : none;
	margin: 5px;
}
</style>

<script>
	$(function(){
		$(document).on("click","button",function(){
			let txt = $(this).text()
			if(txt == '수정'){
				document.location.href = "${rootPath}/update?s_seq="+ ${studyVO.s_seq}
			}else if(txt == '삭제'){
				if(confirm("삭제하실 ?")){
					document.location.href="${rootPath}/delete?s_seq=${studyVO.s_seq}"
				}
			}else if(txt == '저장'){
				/*
					form태그에 있는 댓글 입력 데이터를 controller로 보내는 ajax
				*/
				var formData = $("form.main").serialize()
				
				$.ajax({
					url : "${rootPath}/comment/insert",
					data :  formData,
					type : "POST",
					success : function(result){
						$("div.cmt-list").html(result)
					},
					error: function(){
						alert("서버와 통신오류")
					}
				})
				return true;
			}
		})
	})
</script>

<body>
	<%@ include file="/WEB-INF/views/include/include-header.jspf"%>

	<div class="container">
		<input type="hidden" name="${studyVO.s_seq}" id="${studyVO.s_seq}">
		<div class="study-title col-9">제목 : ${studyVO.s_subject}</div>
		<div class="study-title col-2">작성자 : ${studyVO.s_auth}</div>
		<br />

		<div class="study-title col-4">시작시간 : ${studyVO.s_s_time}</div>
		<div class="study-title col-4">종료시간</div>
		<br />
		<div class="study-title col-4">공부시간</div>
		<div class="form-group d-flex justify-content-end">
			<button class="btn btn-secondary mr-3">수정</button>
			<button class="btn btn-secondary mr-3">삭제</button>
			<button class="btn btn-secondary mr-3">답글</button>
			<button class="btn btn-secondary">목록으로</button>
		</div>
		<form class="main" method="POST">
			<div class="row p-2">
				<input type="hidden" name="c_seq" id="c_seq" value="0"> 
				<input type="hidden" name="c_s_id" value="${studyVO.s_seq}">
				<div class="col-2">
					<input name="c_content"
						class="form-control comment border border-info" id="c_content"
						placeholder="댓글">
				</div>
				<button type="button" class="btn btn-success btn-cmt-save">저장</button>
			</div>
		</form>
		<div class="p-4 cmt-list">
			<%@ include file="/WEB-INF/views/comment/comment-list.jsp"%>
		</div>
	</div>
</body>
</html>