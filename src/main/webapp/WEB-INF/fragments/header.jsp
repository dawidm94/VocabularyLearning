<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<style> <%@ include file="/WEB-INF/css/style.css"%> </style>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css"
	integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb"
	crossorigin="anonymous">
<header>
	<nav class="navbar navbar-expand-lg navbar-dark bg-primary navbar-fixed-top">
		<span class="navbar-brand mb-0 h1"><a style="color:white; text-decoration: none;" href="<c:url value="/"/>"><strong>Vocabulary
				Learning</strong></a></span>
		<div class="collapse navbar-collapse" id="navbarNavDropdown" >
			<ul class="navbar-nav mr-auto"> 
				<li class="nav-item"><a class="nav-link" href="<c:url value="/categories"/>"><strong>Categories</strong></a>
				</li>
				<li class="nav-item"><a class="nav-link" href="<c:url value="/random"/>"><strong>Random 20</strong></a>
				</li>
				<li class="nav-item dropdown">
		      	  <button class="dropbtn"><strong>Add</strong></button>
					  <div class="dropdown-content">
					    <a href="<c:url value="/add_category"/>">Add new category</a>
					    <a href="<c:url value="/add_word"/>">Add word to your category</a>
					  </div>
		      </li>
			</ul>
			<ul class="navbar-nav">
				<li class="nav-item"><a class="nav-link" href="<c:url value="/my_categories"/>"><strong>My categories</strong></a>
				</li>
				<li class="nav-item"><a class="nav-link" href="<c:url value="/profile"/>"><strong>Profile</strong></a>
				</li>

				<%-- Check if administrator --%>
				<c:if test="${sessionScope.user_permission == 'admin'}">
				<li class="nav-item"><a class="nav-link" href="<c:url value="/admin"/>"><strong>Admin</strong></a>
				</li>
				</c:if>
				
				<li class="nav-item"><a class="nav-link" href="<c:url value="/logout"/>"><strong>Logout</strong></a>
				</li>
			</ul>
		</div>
	</nav>
</header>

