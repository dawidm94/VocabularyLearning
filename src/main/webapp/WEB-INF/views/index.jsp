<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    <%@ page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="/WEB-INF/fragments/header.jsp" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Vocabulary Learning - home</title>
</head>
<body>
<div class="jumbotron jumbotron-fluid">
  <div class="container">
    <h1 class="display-3">Vocabulary Learning</h1>
    <p class="lead">Welcome to Vocabulary Learning page. That project was created by Dawid Marcinków as a final project from Java Web Developer Course in Coderslab.</p>
  </div>
</div>
<div align="center" style="color:green;">
	<h3><strong>${message}</strong></h3>
</div>
</body>
</html>