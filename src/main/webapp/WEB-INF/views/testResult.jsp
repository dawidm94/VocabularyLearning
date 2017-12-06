<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
    <%@ page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="/WEB-INF/fragments/header.jsp" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="container-fluid">
	<div class="row">
		<div align="center">
			<h1 style="color:green;">KONIEC TESTU</h1>
			<c:set var="count" value="0" scope="page" />
			<c:forEach items="${sessionScope.testList}" var="wordTest">
				<c:if test="${wordTest.answer==true}">
					<c:set var="count" value="${count + 1}" scope="page"/>
				</c:if>
			</c:forEach>
			<h3>Wynik testu: ${count} / ${fn:length(sessionScope.testList)}</h3>
		</div>
	</div>
</div>
</body>
</html>