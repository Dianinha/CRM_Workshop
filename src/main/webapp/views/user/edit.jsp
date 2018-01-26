<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@	taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Edit</title>
<%@ include file="../fragments/relHead.jsp" %>
</head>
<body>
<%@ include file="../fragments/menu.jsp" %>
<h1>Edit user:</h1>
<form:form method="post" modelAttribute="user">
		<div>
			Login:
			<form:input path="login" value="${user.login}" />
		</div>
		<div>
			Name:
			<form:input path="name" value="${user.name}"/>
		</div>
		<div>
			Surname:
			<form:input path="surname" value="${user.surname}"/>
		</div>
		<div>
			<input type="submit" value="Save changes" />
		</div>
	</form:form>
	<%@ include file="../fragments/relBody.jsp" %>
</body>
</html>