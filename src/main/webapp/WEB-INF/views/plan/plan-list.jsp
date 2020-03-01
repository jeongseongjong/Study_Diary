<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>□□□ 나의 JSP 페이지 □□□</title>
</head>
<body>
<body>
	<c:forEach items="${PLAN_LIST}" var="plan">
		<div class="list-content d-flex " data-id="${plan.p_seq}">
			<div class="col-1">${plan.p_name}</div>
			<div class="col-7">${plan.p_plan}</div>
		</div>
	</c:forEach>
	<hr />
</body>
</body>
</html>