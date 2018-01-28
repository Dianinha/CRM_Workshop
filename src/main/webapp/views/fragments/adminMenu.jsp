<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@	taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<nav class="navbar navbar-expand-lg navbar-light whitebg">
   <a class="navbar-brand" href="#">
	<img src="<c:url value="/resources/CRMlogo.png" />" width="114" height="30" alt="">
	</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarNavDropdown">
    <ul class="navbar-nav">
      <li class="nav-item">
        <a class="nav-link" href="<c:url value="/"></c:url>">Homepage<span class="sr-only">(current)</span></a>
      </li>
       <li class="nav-item">
        <a class="nav-link" href="<c:url value="/login"></c:url>">Login<span class="sr-only">(current)</span></a>
      </li>
      <!-- <li class="nav-item">
        <a class="nav-link" href="#">Złóż zamówienie</a>
      </li> -->
      
      <li class="nav-item dropdown active">
        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          CRM
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
          <a class="dropdown-item" href=<c:url value="/user/add"></c:url>>Users</a>
          <a class="dropdown-item" href=<c:url value="/project/"></c:url>>Projects</a>
          <a class="dropdown-item" href=<c:url value="/task"></c:url>>Tasks</a>
		  <a class="dropdown-item" href=<c:url value="/priority"></c:url>>Priorities</a>
		  <a class="dropdown-item" href=<c:url value="/status"></c:url>>Statuses</a>
        </div>
      </li>
    </ul>
  </div>
</nav>


