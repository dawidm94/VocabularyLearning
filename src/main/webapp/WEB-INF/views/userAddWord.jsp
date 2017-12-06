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
<title>Insert title here</title>
</head>
<body>
<h1 align="center"><strong>Add word</strong></h1>
<hr>
<div align="center">
<form:form method="post" modelAttribute="word">
	PL: <form:input autofocus="autofocus" path="pl"/>
	ENG: <form:input path="eng"/>
	<input type="submit">
</form:form>
<hr>
</div>
	<br/>
		<table id="random" align="center">
		<tr>
			<th>No.</th>
			<th>PL</th>
			<th>ENG</th>
		</tr>
		<c:forEach items="${group}" var="word"  varStatus="theCount">
			<tr>
				<td>${theCount.index+1}</td>
				<td>${word.pl}</td>
				<td>${word.eng}</td>
			</tr>
		</c:forEach>
		</table>
</body>
</html>