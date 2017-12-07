<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="/WEB-INF/fragments/headerAdmin.jsp" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Vocabulary learning by Dawid Marcinkow</title>
</head>
<body>
	<table class="table">
  <thead class="thead-light">
    <tr>
      <th width="10%"></th>
      <th width="30%">Words</th>
      <th width="30%">Word Groups</th>
      <th width="30%">User</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th scope="row"></th>
      <td><a href="<c:url value="/admin/word/add"/>" class="btn btn-outline-success">Add word</a></td>
      <td><a href="<c:url value="/admin/wordGroup/add"/>" class="btn btn-outline-success">Add word group</a></td>
      <td><a href="<c:url value="/admin/user/add"/>" class="btn btn-outline-success">Add user</a></td>
    </tr>
    <tr>
      <th scope="row"></th>
      <td><a href="./admin/word/editlist" class="btn btn-outline-primary">Edit word</a></td>
      <td><a href="./admin/wordGroup/editlist" class="btn btn-outline-primary">Edit word group</a></td>
      <td><a href="./admin/user/editlist" class="btn btn-outline-primary">Edit user</a></td>
    </tr>
    <tr>
      <th scope="row"></th>
      <td><a href="./admin/word/delete" class="btn btn-outline-danger">Delete word</a></td>
      <td><a href="./admin/wordGroup/delete" class="btn btn-outline-danger">Delete word group</a></td>
      <td><a href="./admin/user/delete" class="btn btn-outline-danger">Delete user</a></td>
    </tr>
  </tbody>
</table>
</body>
</html>