<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:forEach items="${CMT_LIST}" var="cmt">
	<div class="row p-2 cmt-item" data-id="${cmt.c_s_id}">
	 	<div class="col-9">${cmt.c_content}</div>
	 	<div class="col-3">${cmt.c_date}</div>
	</div>
</c:forEach>