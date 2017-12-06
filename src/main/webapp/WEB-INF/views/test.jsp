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
<br/>
	<h1 align="center">Test!!!! ${wordTestList[0].word.wordGroup.name}:</h1>
	<br/>
	<table id="random" align="center">
		<tr>
			<th>No.</th>
			<th>PL</th>
			<th>ENG</th>
			<th>Powinno byc NULL</th>
		</tr>
		<c:forEach items="${wordTestList}" var="wordTest" begin="0" varStatus="theCount">
		<tr>
			<td>${theCount.index+1}</td>
			<td>${wordTest.word.pl}</td>
			<td>${wordTest.word.eng}</td>
			<td>${wordTest.answer}</td>
		</tr>
		</c:forEach>	
	</table>
	<br/>
	<p align="center"><a href='.' class="btn btn-primary">Back</a></p>
</body>
</html>