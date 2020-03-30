<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<style>
.cmt-title{
border-top:1px solid #B45F04;
border-bottom:1px solid #B45F04;

}
.cmt-item{
	border-bottom:1px solid #B45F04;
}
</style>


<div class="row p-2 cmt-title">
	<div class="col-2">작성자</div>
	<div class="col-6">댓글</div>
	<div class="col-3">작성일</div>
</div>
<c:forEach items="${CMT_LIST}" var="cmt">
	<div class="row p-2 cmt-item" data-id="${cmt.c_s_id}"
		data-c_seq="${cmt.c_seq}">
		<div class="col-2">${cmt.c_auth} 님</div>
		<div class="col-6">${cmt.c_content}</div>
		<div class="col-3">${cmt.c_date}</div>
		<div class="col-1 cmt-item-del">&times;</div>
	</div>
</c:forEach>
