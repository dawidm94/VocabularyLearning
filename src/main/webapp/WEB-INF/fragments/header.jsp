<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<style> <%@ include file="/WEB-INF/css/style.css"%> </style>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css"
	integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb"
	crossorigin="anonymous">
<header>
	<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
		<span class="navbar-brand mb-0 h1"><strong>Vocabulary
				Learning</strong></span>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item"><a class="nav-link" href="<c:url value="."/>"><strong>Home</strong></a>
				</li>
				<li class="nav-item"><a class="nav-link" href="<c:url value="/categories"/>"><strong>Categories</strong></a>
				</li>
				<li class="nav-item"><a class="nav-link" href="<c:url value="/random"/>"><strong>Random 10</strong></a>
				</li>
				<li class="nav-item"><a class="nav-link" href="<c:url value="."/>"><strong>Link</strong></a>
				</li>
			</ul>
			<ul class="navbar-nav">
				<li class="nav-item"><a class="nav-link" href="<c:url value="."/>"><strong>Profile</strong></a>
				</li>
				<li class="nav-item"><a class="nav-link" href="<c:url value="/admin"/>"><strong>Admin</strong></a>
				</li>
				<li class="nav-item"><a class="nav-link" href="<c:url value="logout"/>"><strong>Logout</strong></a>
				</li>
			</ul>
		</div>
	</nav>
</header>

