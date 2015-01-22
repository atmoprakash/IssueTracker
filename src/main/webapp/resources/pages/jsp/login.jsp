<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: acer
  Date: 1/21/2015
  Time: 11:01 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Spring MVC Form Handling </title>
</head>
<body bg bgcolor="#bdb76b">
<h1>Hi there. WE ARE ISSUETRACKER.</h1>
<h2>Login Page</h2>
<h3>Signup Details</h3>
<table border="1" cellpadding="5" width="500">
  <tr>
    <td>
      <img src="/resources/images/35.jpg" width="500" height="400" />
    </td>
  </tr>
<form action="/login" method="POST">
  <br/>Username:<input type="text" name="username">
  <br/>Password:<input type="password" name="password">
  <br/><input type="submit" value="Submit">

</form>
</table>
</body>
</html>
