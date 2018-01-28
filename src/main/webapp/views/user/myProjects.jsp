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
		<h2>Here is detailed list of projects You are involved in:</h2>
	</div>
	<a href=<c:url value="/project/add"></c:url>> Add new project </a>
	<c:if test="${not empty myProjects}">
	
	<h2>Projects You are involved in:</h2>
	<c:forEach items="${myProjects}" var="mypro">
	<div>
	Project name: ${mypro.name}
	Project identifier: ${mypro.identifier}
	Website: ${mypro.websiteUrl}
	Creation date: ${mypro.niceDate}
	Description: ${mypro.niceDate}
	<a href=<c:url value="/project/edit/${mypro.id}"></c:url>> Edit project </a>
	<a href=<c:url value="/project/addTask/${mypro.id}"></c:url>> Add task to the project </a>
	</div>
	</c:forEach>
	</c:if>
	
	<c:if test="${empty myProjects}">
	<h2>You are currently not involved in any project</h2>
	</c:if>
	
	<%@ include file="../fragments/relBody.jsp" %>
</body>
</html>