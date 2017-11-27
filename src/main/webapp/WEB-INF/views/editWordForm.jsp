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
		PL: <input type="text" name="pl" value="${word.pl}">
		ENG: <input type="text" name="eng" value="${word.eng}">
		Word Group (actually: ${word.wordGroup.name}):
		<select name="wordGroupId">
			<c:forEach items="${groups}" var="group">
				<option value="${group.id}">${group.name}</option>
			</c:forEach>
		</select>
		<input type="hidden" name="id" value="${word.id}">
		<input type="submit" value="edit">	
	</form>
</body>
</html>