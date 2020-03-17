<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:forEach items="${CMT_LIST}" var="cmt">
	<div class="row p-2 cmt-item" data-id="${cmt.c_s_id}" data-c_seq="${cmt.c_seq}">
	 	<div class="col-8">${cmt.c_content}</div>
	 	<div class="col-3">${cmt.c_date}</div>
	 	<div class="col-1 cmt-item-del">&times;</div>
	</div>
</c:forEach>