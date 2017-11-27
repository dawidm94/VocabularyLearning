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
	<form action="../edit2" method="post">
		Login: <input type="text" name="login" value="${users.login}">
		Password: <input type="password" name="password" value="${users.password}">
		Email: <input type="text" name="email" value="${users.email}">
		<input type="hidden" name="id" value="${users.id}">
		<input type="submit" value="edit">	
	</form>
</body>
</html>