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
<style>
.area {
	margin-top:10px;
}

.subject {
	margin-top:10px;
}

.save {
	float : right;
}

.container{
	width:768px;
}

input.subject{
	width:100%;
}

</style>
<body>
	<%@ include file="/WEB-INF/views/include/include-header.jspf"%>
	<div class="container">
		<form method="POST">
			<div class="form-group">
				<div>
					<input type="hidden" name="s_auth" value="${STUDY.s_auth}">
					<input type="hidden" name="s_s_time" value="${STUDY.s_s_time}">
				</div>
				<div class="cate">
					<select name="s_cate" >
						<option>경찰 / 소방 공무원</option>
						<option>공무원</option>
						<option>사법고시</option>
						<option>행정고시</option>
						<option>임용고시</option>
						<option>학생</option>
						<option>기타</option>
					</select>
				</div>
				<div class="subject">
					<input class="subject" name="s_subject" value="${STUDY.s_subject}" placeholder="제목">
				</div>
				<div class="area">
					<textarea class="area" style="width:100%" rows="5" name="s_content" 
						placeholder="내용"></textarea>
				</div>
				<button class="btn btn-success save">저장</button>
			</div>
		</form>

	</div>
</body>
</html>