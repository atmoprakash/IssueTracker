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
<body>
<h2>Student Information</h2>
<form:form method="post" action="/addStudent">
  <table>
    <tr>
      <td><form:label path="name">Name</form:label></td>
      <td><form:input path="name"/></td>
    </tr>
    <tr>
      <td><form:label path="age">Age</form:label></td>
      <td><form:input path="age"/></td>
    </tr>
    <tr>
      <td><form:label path="id">Id</form:label></td>
      <td><form:input path="id"/></td>
    </tr>
    <tr>
      <td colspan="2">
        <input type="submit" value="submit">
      </td>
    </tr>
  </table>
</form:form>
</body>
</html>
