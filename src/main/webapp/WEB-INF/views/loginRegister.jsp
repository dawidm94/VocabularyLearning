<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
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


<!-- REGISTER -->
<div class="register" style="display:none;">
	<form method="post" action="./users/save">
		Login: <input type="text" name="login"><br/>
		E-mail: <input type="email" name="email"><br/>
		Password: <input type="password" name="password"><br/>
		Confirm password: <input type="password" name="password2"><br/>
		<input type="submit">
	</form>
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