<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
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
	<h1 align="center">Words by ${words[0].wordGroup.name}:</h1>
	<br/>
	<table id="random" align="center">
		<tr>
			<th>No.</th>
			<th>PL</th>
			<th>ENG</th>
		</tr>
		<c:forEach items="${words}" var="word" begin="0" varStatus="theCount">
		<tr>
			<td>${theCount.index+1}</td>
			<td>${word.pl}</td>
			<td>${word.eng}</td>
		</tr>
		</c:forEach>	
	</table>
	<br/>
	<p align="center"><a href='<c:url value="/categories/basic"/>' class="btn btn-primary">Back</a> <a href="./${group.id}/test" class="btn btn-primary">Start test!</a></p>
</body>
</html>