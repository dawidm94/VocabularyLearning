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
<h1 align="center"><strong>Categories manager</strong></h1>
<hr>
<div align="center">
<table class="table table-striped">
	<tr>
		<th width="15%"></th>
		<th width="10%">No.</th>
		<th width="15%">Name</th>
		<th width="40%"></th>
	</tr>
	<c:forEach items="${groups}" var="group" begin="0" varStatus="theCount">
	<tr>
		<td></td>
		<td>${theCount.index+1}</td>
		<td><a style="blue" href="<c:url value="/categories/user/${group.id}"/>">${group.name}</a></td>
		<td><a style="width: 120px;height: 20px;" href="<c:url value="/my_categories/${group.id}"/>" class="badge badge-warning">Edit/Delete word	</a>
			<a style="width: 120px;height: 20px;" href="<c:url value="/my_categories/edit/${group.id}"/>" class="badge badge-primary">Edit name	</a>
			<a style="width: 120px;height: 20px;" href="<c:url value="/my_categories/delete/${group.id}"/>" class="badge badge-danger">Delete </a>
		
		</td>
	</tr>
	</c:forEach>
</table>
<hr>
</div>
</body>
</html>