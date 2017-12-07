<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
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
	<div align="center">
		<h1 style="color:green;"><strong>KONIEC TESTU</strong></h1>
		<c:set var="count" value="0" scope="page" />
		<c:forEach items="${sessionScope.testList}" var="wordTest">
			<c:if test="${wordTest.word.eng==wordTest.userAnswer}">
				<c:set var="count" value="${count + 1}" scope="page"/>
			</c:if>
		</c:forEach>
		<h3>Wynik testu: ${count} / ${fn:length(sessionScope.testList)}</h3>
		<h3>Poprawnych odpowiedzi: <span style="font-weight: bold;color:purple;"><fmt:formatNumber type = "percent" maxIntegerDigits="3" value = "${count/fn:length(sessionScope.testList)}" /></span></h3>
	</div>
	<br/><br/>
	<div align="center">
		<h3>Słówka w teście:</h3>
		<table id="result" align="center">
  <thead>
    <tr>
      <th scope="col" width="10%">#</th>
      <th scope="col" width="30%">eng</th>
      <th scope="col" width="30%">your answer</th>
      <th scope="col" width="30%"></th>
    </tr>
  </thead>
  <tbody>
  <c:forEach items="${sessionScope.testList}" var="word" varStatus="theCount">
  	<tr>
  		<td><p>${theCount.index+1}</p></td>
  		<td><p>${word.word.pl}</p></td>
  		<c:choose>
  			<c:when test="${word.word.eng==word.userAnswer}">
  				<td><p style="color:green;">${word.word.eng}</p></td>
  			</c:when>
  			<c:otherwise>
  				<td><p style="color:red;">${word.userAnswer}</p></td>
  				<td><p style="color:green;">${word.word.eng}</p></td>
  			</c:otherwise>
  		</c:choose>
  		<td></td>
  	</tr>
  </c:forEach>
  </tbody>
</table>
	</div>
		<br/>
	<p align="center"><a href='<c:url value="/"/>' class="btn btn-primary">Back to homepage</a> 
</body>
</html>