<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@	taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Welcome to Dianinha CRM</title>
<%@ include file="fragments/relHead.jsp"%>
<link href="<c:url value="/resources/main.css" />" rel="stylesheet">
</head>
<body>
<c:if test="${not empty loggedUser}">
<%@ include file="fragments/userMenu.jsp"%>
</c:if>
<c:if test="${empty loggedUser}">
<%@ include file="fragments/menu.jsp"%>
</c:if>

<div class="container">
		<div class="row">
			<div class="col-1"></div>
			
			<div class="col-10">

		<div class="row">
				<div class="col">
	
	<h1>Welcome to Dianinha's CRM</h1>
				</div>
		</div>
		
		<div class="row">
				<div class="col">

	<p>Being, look within and synergize yourself. Humankind has nothing
		to lose. We are at a crossroads of intuition and stagnation. We are in
		the midst of a mystical deepening of sharing that will give us access
		to the universe itself. Health is the growth of inseparability, and of
		us. Today, science tells us that the essence of nature is
		self-actualization. Nothing is impossible. Have you found your story?
		Although you may not realize it, you are joyous. The nexus is calling
		to you via morphogenetic fields. Can you hear it? Energy is a
		constant. Soon there will be a maturing of balance the likes of which
		the world has never seen. It is time to take starfire to the next
		level. The Goddess will align us with sublime starfire. This life is
		nothing short of an invocation quantum shift of spatial divinity. We
		exist as sub-atomic particles. To traverse the myth is to become one
		with it.</p>
			</div>
		</div>


	
		<c:if test="${not empty message}"><div class="alert alert-info">
${message}</div></c:if>
	
<c:if test="${not empty projects}">
<div class="container confade mt-4 py-4">
		<div class="row">
				<div class="col">
		<h2>List of recent projects:</h2>
		<ul class="list-group">
		<c:forEach items="${projects}" var="proj">
			<li class="list-group-item">${proj.name} created: ${proj.niceDate}</li>
		</c:forEach>
		</ul>
		</div></div></div>
	</c:if>



	<c:if test="${not empty activities}">
	<div class="container confade mt-4 mb-5 py-4">
		<div class="row">
				<div class="col">
		<h2>List of recent activities:</h2>
		<ul class="list-group">
		<c:forEach items="${activities}" var="act" begin="0" end="25">
			<li class="list-group-item"><c:out value="${act.content}"></c:out></li>
		</c:forEach>
		</ul>
		</div></div></div>
	</c:if>
</div>
	<div class="col-1"></div>
		</div>
	</div>

	<%@ include file="fragments/footer.jsp"%>
	<%@ include file="fragments/relBody.jsp"%>
</body>
</html>