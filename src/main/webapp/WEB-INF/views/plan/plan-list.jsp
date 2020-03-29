<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>□□□ 나의 JSP 페이지 □□□</title>
</head>
<body>
<body>
	<div>
		<c:forEach items="${PLAN_LIST}" var="plan" varStatus="index">
			<div class="list-content d-flex">
				<div class="col-2">&curren; &nbsp;</div>
				<div class="col-8 check-div">
					<c:choose>
						<c:when test="${plan.p_complete == 1 }">
							<span style="text-decoration: line-through">${plan.p_plan}</span>
						</c:when>
						<c:otherwise>
							<span style="text-decoration: none">${plan.p_plan}</span>
						</c:otherwise>
					</c:choose>
					<input type="checkbox" class="check-box" name="p_complete"
						data-id="${p_id}" id="c_complete_${index.index}"
						data-com="${p_complete}">
				</div>
			</div>
		</c:forEach>
		<hr />
	</div>
</body>
</body>
</html>