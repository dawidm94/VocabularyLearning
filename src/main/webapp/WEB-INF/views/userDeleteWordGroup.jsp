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
<div align="center">
  <br/><br/>	
    <h1 class="display-5" style="color:red; font-weight: bold;">Are you sure you want to delete "${wordGroup.name} " category?</h1>
    <br/>
    		<br/>
    		<form method="post">
    			<input class="btn btn-danger" type="submit" value="Yes, delete"/><span style="padding: 20px"><a href='<c:url value="/my_categories"/>' class="btn btn-primary"> No</a></span>
    		</form>
		
</div>
</body>
</html>