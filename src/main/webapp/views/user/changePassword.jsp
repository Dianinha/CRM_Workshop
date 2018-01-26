<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@	taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Change password</title>
<%@ include file="../fragments/relHead.jsp" %>
</head>
<body>
<%@ include file="../fragments/menu.jsp" %>
<div>
		<c:if test="${not empty message}">
${message}</c:if>
	</div>
	<h1>Change Your password</h1>
	<form method="post" action="/CRM/user/changePassword"> Old password:
	<br>
	<input type="password" name="oldPassword">
	<br> New password:
	<br>
	<input type="password" name="newPassword">
	
	<br> Repeat new password:
	<br>
	<input type="password" name="newPassword2">
	<br> 
	<input type="submit" value="Change password">
	</form>
	<%@ include file="../fragments/relBody.jsp" %>
</body>
</html>