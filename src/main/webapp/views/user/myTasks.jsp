<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@	taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>This is Your profile</title>
<%@ include file="../fragments/relHead.jsp" %>
</head>
<body>
<%@ include file="../fragments/userMenu.jsp" %>
	<div>
		<c:if test="${not empty message}">
${message}</c:if>
	</div>

	<div>
		<h1>Hello ${currentUser.name} ${currentUser.surname}</h1>
	</div>
	
	
	<c:if test="${not empty myTasks}">
	<h2>List of Your tasks:</h2>
	<c:forEach items="${myTasks}" var="task">
	<div>
	Task: ${task.subject}
	Project: ${task.project.name}
	Creation date: ${task.niceDate}
	Status: ${task.status.name} <a href=<c:url value="/task/changeStatus/${task.id}"></c:url>> Change status </a>
	Priority: ${task.priority.name} 
	<a href=<c:url value="/task/edit/${task.id}"></c:url>> Edit this task </a>
	<a href=<c:url value="/task/details/${task.id}"></c:url>> See task details </a>
	</div>
	</c:forEach>
	</c:if>
	<c:if test="${empty myTasks}">
	<h2>You have nothing to do. No tasks. Go home.</h2>
	</c:if>
	<%@ include file="../fragments/relBody.jsp" %>
</body>
</html>