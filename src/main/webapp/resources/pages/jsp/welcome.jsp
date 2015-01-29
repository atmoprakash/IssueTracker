<%--
  Created by IntelliJ IDEA.
  User: acer
  Date: 1/21/2015
  Time: 11:01 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <style>
    #next {
      position: absolute;
      right: 17%;
    }

  </style>
  <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  <title>Insert title here</title>
  <link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet" >
  <link href="${pageContext.request.contextPath}/resources/css/login.css" rel="stylesheet" >
  <link href="${pageContext.request.contextPath}/resources/css/bootstrap.css" rel="stylesheet" >
</head>
<body>
<div id="next">
  <a href="logout">Logout</a>
</div>
<h2>esewa new Members</h2>
<table border="1">
  <thead>
  <tr>
    <th>ID</th>
    <th>name</th>
    <th>Username</th>
    <th>password</th>
    <th>created_date</th>
    <th>status</th>
    <th colspan=2>Action</th>
  </tr>
  </thead>

  <tbody>

  <c:forEach items="${username}" var="user">
    <tr>
      <td><c:out value="${user.user_id}" /></td>
      <td><c:out value="${user.name}" /></td>
      <td><c:out value="${user.username}" /></td>
      <td><c:out value="${user.password}" /></td>
      <td><c:out value="${user.created_date}" /></td>
      <td><c:out value="${user.status}" /></td>
      <td><a href="/update?id=${user.user_id}">Update</a></td>
      <td><a href="/delete?id=${user.user_id }">Delete</a></td>

    </tr>
  </c:forEach>

  </tbody>
</table>
<br>
<a href="/add"><button>Register New Users</button></a>
</body>
</html>