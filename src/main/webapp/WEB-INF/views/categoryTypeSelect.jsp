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
<br/><br/><br/>
<h1 align="center">Choose one of type categories</h1>
<br/>
<div class="row">
  <div class="col-md-6">
	<div class="card border-primary mb-3 text-center" style="width: 100%;">
  		<div class="card-body">
   			<h4 class="card-title">Basic Categories</h4>
    		<p class="card-text">Basic categories added by admin.</p>
    		<a href="<c:url value="/categories/basic"/>" class="btn btn-primary">Go to basic categories</a>
 		 </div>
	</div>
</div>
<div class="col-md-6">
	<div class="card border-primary mb-3 text-center" style="width: 100%;">
  		<div class="card-body">
   			<h4 class="card-title">Users categories</h4>
    		<p class="card-text">Categories added by users.</p>
    		<a href="<c:url value="/categories/user"/>" class="btn btn-primary">Go to users categories</a>
 		 </div>
	</div>
</div>
</div>
</body>
</html>