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
	border: none;
	width: 650%;
}

.comment-between {
	display: flex;
	justify-content: space-between;
}

.btn-cmt-save {
	float: right;
}

.cmt-item-del:hover {
	cursor: pointer;
}

.form-group {
	width: 70%;
	margin: 0%;
	float: right;
	margin-top: 30px;
}

.row {
	width: 100%;
}
</style>

<script>
	$(function() {

		$(document)
				.on(
						"click",
						"button",
						function() {
							let txt = $(this).text()
							if (txt == '수정') {
								document.location.href = "${rootPath}/update?s_seq="
										+ $
								{
									studyVO.s_seq
								}
							} else if (txt == '삭제') {
								if (confirm("삭제하실 ?")) {
									document.location.href = "${rootPath}/delete?s_seq=${studyVO.s_seq}"
								}
							} else if (txt == '저장') {
								/*
									form태그에 있는 댓글 입력 데이터를 controller로 보내는 ajax
								 */

								var c_s_id = $(".seq").attr("data-id")
								$("#c_s_id").val(c_s_id)

								var formData = $("form.main").serialize()

								$.ajax({
									url : "${rootPath}/comment/insert",
									data : formData,
									type : "POST",
									success : function(result) {
										$("div.cmt-list").html(result)
									},
									error : function() {
										alert("서버와 통신오류")
									}
								})
								return true;
							}
						})

		$(document).on("click", ".cmt-item-del", function(event) {
			event.stopPropagation()

			if (!confirm("댓글을 삭제 할까요")) {
				return false
			}

			let c_seq = $(this).parent("div").data("c_seq")
			$.ajax({
				url : "${rootPath}/comment/delete",
				data : {
					c_seq : c_seq,
					s_id : "${studyVO.s_seq}"
				},
				type : "POST",
				success : function(result) {
					$("div.cmt-list").html(result)
				},
				error : function() {
					alert("댓글 삭제 오류")
				}
			})
		})

		$(document).on("click", "button", function() {
			let text = $(this).text()
			if (text == '공부종료') {
				if (!confirm("공부를 종료하시겠습니까?")) {
					return false
				}

				// 원래있던 comment input의 data-id를 id로 바꿔서 
				// 위의 ajax에서 id에 val()을 넣어준다.
				// 그렇게 되면 button에 해당하는곳에 data-id는 study-update에 하나밖에없기 때문에 s_seq가 지정된다.
				var s_seq = $(this).data("id")

				$.ajax({
					// controller의 RequestParam으로 설정해둔 s_seq를 가져오고
					// data-id의값인 s_seq로 변수를 지정해준다.
					url : "${rootPath}/fTime?s_seq=" + s_seq,
					data : {
						s_seq : s_seq
					},
					type : "POST",
					success : function(result) {
						// include로 날아오지면 detail에서 보여줘야 하기때문에 result를 html로 날려준다.
						$(".study-detail").html(result)
						// alert(result.s_f_time)

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
	<%@ include file="/WEB-INF/views/include/include-header.jspf"%>

	<div class="container">

		<div class="study-detail">
			<%@ include file="/WEB-INF/views/study-update.jsp"%>
		</div>
		<div class="form-group d-flex justify-content-end">
			<a href="${rootPath}/update?s_seq=${studyVO.s_seq}"><button
					class="btn btn-secondary mr-3">수정</button></a> <a
				href="${rootPath}/delete?s_seq=${studyVO.s_seq}"><button
					class="btn btn-secondary mr-3">삭제</button></a> <a href="${rootPath}/"><button
					class="btn btn-secondary">목록으로</button></a>
			<c:if test="${empty studyVO.s_f_time}">
				<button type="button" data-id="${studyVO.s_seq }"
					class="btn btn-warning ml-3 finish">공부종료</button>
			</c:if>
		</div>
		<form class="main" method="POST">
			<div class="row p-2 comment-between">
				<input type="hidden" name="c_seq" id="c_seq" value="0"> <input
					type="hidden" id="c_s_id" name="c_s_id">
				<div class="col-2 comment">
					<input type="text" name="c_content"
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