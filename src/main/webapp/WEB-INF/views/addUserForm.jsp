<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@ page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="/WEB-INF/fragments/headerAdmin.jsp" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1 align="center"><strong>Add user</strong></h1>
<hr>
<div align="center">
<form:form method="post" modelAttribute="user">
	Login: <form:input path="login"/>
	Password: <form:input path="password"/>
	E-mail: <form:input path="email"/> 
	Permission: <form:select path="permission">
					<form:option value="user">user</form:option>
					<form:option value="admin">admin</form:option>
				</form:select>
	<input type="submit" value="add">
</form:form>
<hr>
</div>
	<c:if test="${ not empty addedUser.login}"> 
		<p style="color: green; font-weight:bold; text-indent: 610px">Added </p>
		<p style="color: green; text-indent: 540px">login: <font color="black"><b>${addedUser.login}</b></font></p> 
		<p style="color: green; text-indent: 540px">password: <font color="black"><b>*********</b></font> </p>
		<p style="color: green; text-indent: 540px">e-mail: <font color="black"><b>${addedUser.email}</b></font></p>
	</c:if>
</body>
</html>