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
<h1> You have successfuly signed in</h1>
<h2>Submitted Student Information</h2>
<table border="1" cellpadding="5" width="500">
  <tr>
    <td>Name</td>
    <td>${username}</td>
  </tr>
  <tr>
    <td>
      <img src="/resources/images/logo1.gif" width="500" height="400" />
    </td>
  </tr>
</table>
</body>
</html>