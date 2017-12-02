<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    <%@ page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script><title>Insert title here</title>
<style><%@include file="/WEB-INF/css/login.css"%></style> 
</head>
<body>
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar"></button>                
      <a class="navbar-brand" href="./">Vocabulary Learning</a> 
   </div>
   <div class="collapse navbar-collapse" id="myNavbar">
     <ul class="nav navbar-nav navbar-right">
      <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
    	<span class="navbar-text">Log in</span>
    	<form id="signin" class="navbar-form navbar-right" role="form" method="post" action="./login">
          <div class="input-group">
          	<span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
             <input id="basic-addon2" type="text" class="form-control" name="login" value="" placeholder="Login">                                        
          </div>
          <div class="input-group">
           <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
             <input id="password" type="password" class="form-control" name="password" value="" placeholder="Password">   
          </div>
           <button type="submit" class="btn btn-primary">Login</button>
        </form>
       </div>
      </ul>
    </div>
  </div>
</nav>
<div>
<div class="container" >
    <div class="col-md-6" >
        <div id="logbox"  >
            <form:form id="signup" method="post" action="/signup" modelAttribute="user">
                <h1>Create an Account</h1>
				<form:input path="login" placeholder="Email address" class="input pass"/>
				<form:input path="email" placeholder="Login" class="input pass"/>
                <form:input path="password" type="password" placeholder="Choose a password" required="required" class="input pass"/>
                <input name="user[password2]" type="password" placeholder="Confirm password" required="required" class="input pass"/>
                <input type="submit" value="Sign me up!" class="inputButton"/>
            </form:form>
        </div>
    </div>
</div>
</div>
</body>
</html>