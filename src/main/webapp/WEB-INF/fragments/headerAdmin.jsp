<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    <style><%@include file="/WEB-INF/css/style.css"%></style> 
<header>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css" integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb" crossorigin="anonymous">
	<ul class="navbarAdmin">
		<li class="navbarAdmin"> <a href="<c:url value="/admin"/>">Admin Panel</a> </li>
		<li class="navbarAdmin" style="float:right"> <a href="<c:url value="/logout"/>">Logout</a> </li>
		<li class="navbarAdmin" style="float:right"> <a href="<c:url value="/"/>">Home</a> </li>
	</ul>
	<br/>
</header>

