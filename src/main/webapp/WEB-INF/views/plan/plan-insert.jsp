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
<body>
	<div>
		<form class="main" method="POST">
			<div class="row p-2 ">
				<input type="hidden" name="plan_seq" id="plan_seq"> <input
					type="hidden" id="p_s_id" name="p_s_id">
				<div class="col-2 plan">
					<input type="text" name="p_plan"
						class="form-control plan border border-info" id="p_plan"
						placeholder="계획을 작성하세요">
				</div>
				<button type="button" class="btn btn-success">계획작성</button>
			</div>
		</form>
	</div>
</body>
</html>