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
<%@ include file="../fragments/userMenu.jsp" %>

<div class="container">
		<div class="row">
			<div class="col-1"></div>
			
			<div class="col-10">
			
			<c:if test="${not empty message}">
			<div class="alert alert-danger">
				${message}</div></c:if>

		<div class="row">
				<div class="col">
					<h1>Change Your password:</h1>
				</div>
		</div>
		
		<form method="post" action="/CRM/user/changePassword">
	<div class="container confade mt-4 mb-5">
			<div class="row">
				<div class="col form-group mt-4">
	<label for="Old password:">Old password:</label>
	<input type="password" name="oldPassword" class="form-control" >
				</div>
			</div>
	<div class="row">
	<div class="col form-group">
	<label for="newPassword">New Password:</label>
<input type="password" name="newPassword" class="form-control" >
				</div>
			</div>
			<div class="row">
			<div class="col form-group">
	<label for="Repeat new password:">Repeat new password:</label>
	<input type="password" name="newPassword2" class="form-control" >
				</div>
			</div>
		
			<div class="row">
				<div class="col mb-4">
					<input type="submit" value="Change password" class="btn btncol"/>
				</div>
			</div>
		</div>
		</form>
	</div>
	<div class="col-10"></div>
		</div>
	</div>

	<%@ include file="../fragments/footer.jsp"%>
	<%@ include file="../fragments/relBody.jsp"%>
</body>
</html>
