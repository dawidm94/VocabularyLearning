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
<h1 align="center"><strong>Add word</strong></h1>
<hr>
<div align="center">
<form action="<c:url value = "/words/save"/>">
	 PL: <input type="text" name="pl">
	 ENG: <input type="text" name="eng">
	 Word group: <select name="wordGroupId">
		<c:forEach items="${groups}" var="group">
			<option value="${group.id}">${group.name}</option>
		</c:forEach>
	</select>
	<input type="submit" value="add">
</form>
<hr>
</div>
</body>
</html>