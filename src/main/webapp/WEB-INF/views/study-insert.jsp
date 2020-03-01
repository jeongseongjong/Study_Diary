<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<%@ include file="/WEB-INF/views/include/include-head.jspf"%>
<title>□□□ 나의 JSP 페이지 □□□</title>
</head>
<body>
	<%@ include file="/WEB-INF/views/include/include-header.jspf"%>
	<div class="container">
		<form method="POST">
			<div class="form-group">
				<div>
					<input name="s_id" value="${STUDY.s_id}" placeholder="아이디">
				</div>
				<div>
					<input name="s_subject" value="${STUDY.s_subject}" placeholder="제목">
				</div>
				<div>
					<input name="s_content" value="${STUDY.s_content}" placeholder="내용">
				</div>
				<div>
					<input name="s_content" value="${STUDY.s_cate}" placeholder="카테고리">
				</div>
				<%@ include file="/WEB-INF/views/plan/plan-insert.jsp" %>
				<button>저장</button>
			</div>
		</form>
		
	</div>
</body>
</html>