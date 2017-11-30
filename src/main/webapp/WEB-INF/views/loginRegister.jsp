<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    <%@ page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Welcome to vocabulary learning website.</title>
<style><%@include file="/WEB-INF/css/loginRegister.css"%></style> 
</head>
<body>

<button id="login" onclick="login()">Login</button>
<button id="register" onclick="register()">Register</button>
<br/>
<br/>


<!-- LOGIN -->
<div class="login" style="display:none;">

	<form method="post" action="./login">
		Login: <input type="text" name="login">
		Password: <input type="password" name="password">
		<input type="submit">
	</form>
</div>

<c:url var="addUrl" value="/admin/user/add"/>
<!-- REGISTER -->
<div class="register" style="display:none;">
	<form:form action="${addUrl}" method="post" modelAttribute="user">
		Login: <form:input path="login"/> <br/>
		E-mail: <form:input path="email"/> <br/>
		Password: <form:input path="password"/> <br/>
		Confirm password<input type="password" name="passwordVerify"/> <br/>
		<form:hidden path="permission" value="user"/>
		<input type="submit" value="add">
	</form:form>
</div>


</body>
<script
  src="https://code.jquery.com/jquery-3.2.1.min.js"
  integrity="sha256-hwg4gsxgFZhOsEEamdOYGBf13FyQuiTwlAQgxVSNgt4="
  crossorigin="anonymous"></script>
  
  <script>
	function login() {
	    if(($('.login').css('display')=='none')){
	    	$('.register').css('display','none')
		    $('.login').css('display','inline');    	
	    }else{
		    $('.login').css('display','none');    	
	    }

	}
	
	function register() {
		 if(($('.register').css('display')=='none')){
		    $('.login').css('display','none')
		    $('.register').css('display','inline');    	
	    }else{
		    $('.register').css('display','none');    	
	    }
	}
</script>
</html>