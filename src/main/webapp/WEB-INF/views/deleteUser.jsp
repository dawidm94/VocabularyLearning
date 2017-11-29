<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    <%@ page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="/WEB-INF/fragments/headerAdmin.jsp" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1 align="center"><strong>Delete User</strong></h1>
<hr>
<div align="center">
<table class="table table-striped">
	<tr>
		<th width="22%"></th>
		<th width="10%">No.</th>
		<th width="20%">Login</th>
		<th width="20%">E-mail</th>
		<th width="28%"></th>
	</tr>
	<c:forEach items="${users}" var="user" begin="1" varStatus="theCount">
	<tr>
		<td></td>
		<td>${theCount.index}</td>
		<td>${user.login}</td>
		<td>${user.email}</td>
		<td><a style="width: 180px;height: 20px;" href="./delete/${user.id}" class="badge badge-danger">Delete</a></td>
	</tr>
	</c:forEach>
</table>
<hr>
</div>
</body>
</html>