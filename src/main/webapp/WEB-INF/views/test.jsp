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
<title>Vocabulary learning by Dawid Marcinkow</title>
</head>
<body>
<div class="container-fluid">
	<div class="row">
		<div align="left" class="col-3">
		<h3>Answers:</h3>
		<ol>
		<c:forEach items="${sessionScope.testList}" var="wordTest" begin="0" varStatus="theCount">
		<li>
			<c:if test="${wordTest.word.eng==wordTest.userAnswer}">
				<span style="color: green;">&#10004;</span>
			</c:if>
			<c:if test="${(wordTest.word.eng!=wordTest.userAnswer) && not empty wordTest.userAnswer}">
				<span style="color: red;">&#10006;</span> 
			</c:if>
		</li>
		</c:forEach>
		</ol>
		</div>
		<div class="col-7" align="center">
		<br/><br/>
			<p align="center" style="font-size: 80px;padding-top: 10px ; border: 2px solid #428bca; border-radius: 5px; word-wrap: break-word;">${sessionScope.testList[sessionScope.actuallQuestion].word.pl}</p>
			<br/><br/>
			<form method="post">
			<input name="userAnswer" id="userAnswer" autocomplete="off" autofocus type="text" style="font-size:80px;text-align: center; width:738px;border: 2px solid #428bca; border-radius: 5px;">
			<br/><br/>
			<c:choose>
				<c:when test="${fn:length(sessionScope.testList) == (sessionScope.actuallQuestion+1)}">
			<input class="btn btn-success" type="submit" value="Zakończ">						
				</c:when>
				<c:otherwise>
			<input class="btn btn-primary" type="submit" value="Odpowiedz">				
				</c:otherwise>
			</c:choose>

			</form>
		</div>
		<div class="col-2">
		</div>
	</div>
</div>
</body>
</html>