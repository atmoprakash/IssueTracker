<%--
  Created by IntelliJ IDEA.
  User: acer
  Date: 1/21/2015
  Time: 11:01 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
  <title>Spring MVC Form Handling</title>
</head>
<body>
<h2>Submitted Student Information</h2>
<table>
  <tr>
    <td>Name</td>
    <td>${name}</td>
  </tr>
  <tr>
  <td>Age</td>
    <td>${age}</td>
  </tr>
  <tr>
  <td>ID</td>
    <td>${id}</td>
  </tr>
</table>
</body>
</html>