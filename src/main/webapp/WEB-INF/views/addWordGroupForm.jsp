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
<h1 align="center"><strong>Add word group</strong></h1>
<hr>
<div align="center">
<form:form method="post" modelAttribute="wordGroup">
	Name: <form:input path="name"/> &nbsp; &nbsp; &nbsp;
	 Basic Group: <form:checkbox path="ifBasicGroup"/>&nbsp; &nbsp;
	<input type="submit" value="add">
</form:form>
<hr>
</div>
	<c:if test="${ not empty addedWordGroup.name}"> 
		<p style="color: green; font-weight:bold; text-indent: 610px">Added </p>
		<p style="color: green; text-indent: 580px">Name: <font color="black"><b>${addedWordGroup.name}</b></font></p> 
	</c:if>	
</body>
</html>