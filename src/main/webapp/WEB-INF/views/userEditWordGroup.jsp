<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>    
    <%@ page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="/WEB-INF/fragments/header.jsp" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Vocabulary learning by Dawid Marcinkow</title>
</head>
<body>
<br/>
<h1 align="center"><strong>Edit category name</strong></h1>
<hr>
<div align="center">
<form:form method="post" modelAttribute="wordGroup">
	Name: <form:input path="name"/>
	<form:hidden path="id"/>
	<input type="submit" value="edit">
</form:form>
<hr>
		<br/>
		<p align="center"><a href='<c:url value="/my_categories"/>' class="btn btn-primary">Back</a></p>
</div>
</body>
</html>