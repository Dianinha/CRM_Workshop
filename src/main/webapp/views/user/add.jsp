<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@	taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add a new user here:</title>
<%@ include file="../fragments/relHead.jsp" %>
</head>
<body>
<%@ include file="../fragments/menu.jsp" %>
<h1>Add new user</h1>
<h2>Please register:</h2>
<br>
<div>
<form:form action="add" method="post" modelAttribute="user">
		<div>
			Login:
			<form:input path="login" />
		</div>
		<div>
			Password:
			<form:password path="password" />
		</div>
		<div>
			Name:
			<form:input path="name" />
		</div>
		<div>
			Surname:
			<form:input path="surname" />
		</div>
		<div>
			<input type="submit" value="Add new user" />
		</div>
	</form:form>
</div>
<%@ include file="../fragments/relBody.jsp" %>
</body>
</html>