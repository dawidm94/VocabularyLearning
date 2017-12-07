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
<h1 align="center"><strong>Category: ${wg.name}</strong></h1>
<hr>
<div align="center">
</div>
	<br/>
		<table id="wordedit" align="center">
		<tr>
			<th width="10%">No.</th>
			<th width="30%">PL</th>
			<th width="30%">ENG</th>
			<th width="15%"></th>
			<th width="15%"></th>
		</tr>
		<c:forEach items="${group}" var="word"  varStatus="theCount">
			<tr>
				<td>${theCount.index+1}</td>
				<td>${word.pl}</td>
				<td>${word.eng}</td>
				<td><a style="width: 120px;height: 20px;" href="<c:url value="/my_categories/${wg.id}/edit/${word.id}"/>" class="badge badge-primary">Edit </a></td>
				<td><a style="width: 120px;height: 20px;" href="<c:url value="/my_categories/${wg.id}/delete/${word.id}"/>" class="badge badge-danger">Delete </a></td>
			</tr>
		</c:forEach>
		</table>
		<br/><br/><div align="center">
		<span><a href='<c:url value="/my_categories"/>' class="btn btn-primary">Back </a></span>
		<span><a href='<c:url value="/add_word/${wg.id}"/>' class="btn btn-success"> Add words</a></span>
		</div>
</body>
</html>