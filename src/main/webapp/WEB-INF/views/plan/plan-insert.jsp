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
	<div>
		<form method="POST">
			<div class="form-group">
				<input type="hidden" name="p_s_id" value="0">
				<div>
					<input name="p_plan" placeholder="계획을 작성하세요">
					<input name="p_plan" placeholder="계획을 작성하세요">
					<input name="p_plan" placeholder="계획을 작성하세요">
					<input name="p_plan" placeholder="계획을 작성하세요">
				</div>
			</div>
		</form>
	</div>
</body>
</html>