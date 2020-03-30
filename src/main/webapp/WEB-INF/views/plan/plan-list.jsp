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
<body>
	<form:form ModelAttribute="PLAN_LIST">
		<c:forEach items="${PLAN_LIST}" var="plan">
			<div class="list" data-id="${plan.p_s_id}" data-seq="${plan.p_seq}">
				<div class="col-3">${plan.p_seq}</div>
				<div class="col-8 check-div">
					<c:choose>
						<c:when test="${plan.p_complete == 1 }">
							<span style="text-decoration: line-through">${plan.p_plan}</span>
						</c:when>
						<c:otherwise>
							<span style="text-decoration: none">${plan.p_plan}</span>
						</c:otherwise>
					</c:choose>
				</div>

				<input type="checkbox" class="check-box" name="p_complete"
					data-id="${plan.p_s_id}" id="c_complete_${index.index}"
					data-com="${plan.p_complete}">
			</div>
		</c:forEach>
	</form:form>
</body>
