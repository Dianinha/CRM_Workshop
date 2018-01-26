<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@	taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@ include file="../fragments/relHead.jsp" %>
</head>
<body>
<%@ include file="../fragments/menu.jsp" %>
	<div>
		<c:if test="${not empty message}">
${message}</c:if>
	</div>

	<div>
		<h1>User options:</h1>
		<ul>
			<li><a href=<c:url value="/user/edit"></c:url>> Edit Your
					data.</a></li>
			<li><a href=<c:url value="/user/changePassword"></c:url>> Change password. </a></li>

		</ul>
	</div>
	<%@ include file="../fragments/relBody.jsp" %>
</body>
</html>