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
<body>
	<div>
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
	</div>
</body>
</html>