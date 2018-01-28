<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@	taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Log in</title>
<%@ include file="../fragments/relHead.jsp" %>
</head>
<body>
<%@ include file="../fragments/menu.jsp" %>
	<div>
		<c:if test="${not empty message}">
${message}</c:if>
	</div>
	Please put Your username and password:
	<form method="post">
	Username:
	<input type="text" name="username"> 
	<br>
	Password
	<input type="password" name="password">
	<br>
			<div>
				<input type="submit" value="Log in" />
			</div>
		</form>
	
	<%@ include file="../fragments/relBody.jsp" %>
</body>
</html>