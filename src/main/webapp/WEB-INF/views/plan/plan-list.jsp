<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>□□□ 나의 JSP 페이지 □□□</title>
</head>
<script>
	$(function() {

		$("input:checkbox").on("click", function(e) {
			var p_seq = $(this).data("seq")
			var p_complete = $(this).data("com")

			$.ajax({
				url : "${rootPath}/plan/checkBox",
				data : {
					p_seq : p_seq,
					p_complete : p_complete
				},
				type : 'POST',
				success : function() {
					if (p_complete == 0) {
						alert("완료하시겠습니까?")
					} else {
						alert("취소하시겠습니까?")
					}

					location.reload()
				},
				error : function() {
					alert("체크박스 오류")
				}
			})
			return false
		})
	})
</script>
<style>
.plan-title {
	border-top: 1px solid #B45F04;
	border-bottom: 1px solid #B45F04;
}
.body {
	font-size : 20px;
}
</style>
<body>
	<div class="row p-2 plan-title">
		<div class="col-3">번호</div>
		<div class="col-7">공부계획</div>
		<div class="col-2">성공체크</div>
	</div>
	<c:forEach items="${PLAN_LIST}" var="plan">
		<div class="list d-flex" data-id="${plan.p_s_id}"
			data-seq="${plan.p_seq}">
			<div class="col-3">${plan.p_seq}</div>
			<div class="col-7 check-div">
				<c:choose>
					<c:when test="${plan.p_complete == 1 }">
						<span style="text-decoration: line-through">${plan.p_plan}</span>
					</c:when>
					<c:otherwise>
						<span style="text-decoration: none">${plan.p_plan}</span>
					</c:otherwise>
				</c:choose>
			</div>
			<div class="col-2">
				<input type="checkbox" class="check-box" name="p_complete"
					data-seq="${plan.p_seq}" id="c_complete_${index.index}"
					data-com="${plan.p_complete}">
			</div>
		</div>
	</c:forEach>
</body>
