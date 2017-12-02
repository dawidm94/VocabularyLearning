<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="/WEB-INF/fragments/header.jsp" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Users categories</title>
</head>
<body>
	<table class="table table-sm table-bordered">
 	 <thead style="font-style: italic;">
   		 <tr>
    	 	 <th>#</th>
     		 <th>Name</th>
    		 <th>Added by</th>
    		 <th>Created</th>
    		 <th>Last Update</th>
    		 <th></th>
 		</tr>
  	</thead>
  	<tbody>
   		 <c:forEach items="${userCategories}" var="category" begin="0" varStatus="theCount">
    	<tr>
    		<td>${theCount.index+1}</td>
    		<td><strong><a href="<c:url value="/categories/user/${category.id}"/>" style="color:#0000EE;">${category.name}</a></strong></td>
    		<td>${category.user.login}</td>
    		<td>${category.created}</td>
    		<td><fmt:formatDate pattern="yyyy-MM-dd hh:mm:ss" value = "${category.lastUpdate}" /></td>
    		<td><a href="<c:url value="/categories/user/${category.id}"/>"><span class="badge badge-primary">Show details</span></a>
 	   </tr>
   		 </c:forEach>
  	</tbody>
 </table>
</body>
</html>