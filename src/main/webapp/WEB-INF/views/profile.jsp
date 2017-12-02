<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    <%@ page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="/WEB-INF/fragments/header.jsp" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div align="center">
<br/>
<h2>Profile details:</h2>
<table class="profile">
	<tr>
		<td></td>
	</tr>
	<tr>
		<td align="right"><strong>Login:</strong></td>
		<td>${user.login}</td>
	</tr>
	<tr>
		<td align="right"><strong>E-mail:</strong></td>
		<td>${user.email}</td>
		<td><a href="#" class="badge badge-primary">Change e-mail</a></td>
	</tr>
	<tr>
		<td align="right"><strong>Password:</strong></td>
		<td>********</td>
		<td><a href="#" class="badge badge-primary">Change password</a></td>
	</tr>
</table>
</div>
<br/><br/>
<div align="center">
<h2 align="center">Your categories:</h2>
<table style="padding: 15px;" border="1">
	<tr>
		<th>Name</th>
		<th>Created</th>
	</tr>
	<c:forEach items="${wordGroups}" var="group">
		<tr>
			<td>${group.name}</td>
			<td>${group.created}</td>
		</tr>
	</c:forEach>
</table>
</div>

</body>
</html>