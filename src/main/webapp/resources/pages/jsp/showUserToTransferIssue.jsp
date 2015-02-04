<%--
  Created by IntelliJ IDEA.
  User: acer
  Date: 1/27/2015
  Time: 2:33 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
  <title>IssueTracker</title>
  <style>
    body {
      font-size: 20px;
      color: teal;
      font-family: Calibri;
    }

    td {
      font-size: 15px;
      color: black;
      width: 100px;
      height: 22px;
      text-align: center;
    }
    .heading {
      font-size: 18px;
      color: white;
      font: bold;
      background-color: orange;
      border: thick;
    }
  </style>
</head>
<body>
<center>



  <b>Select User to Transfer Your Issue to Him/Her </b>
<table border="1">
    <tr>
      <td class="heading">User Id</td>
      <td class="heading">User Name</td>
      <td class="heading">Select User</td>
    </tr>
    <c:forEach var="user" items="${userList}">
      <tr>
        <td>${user.user_id}</td>
        <td>${user.username}</td>
        <td><a href="transferUserIssue?user_id=${user.user_id}&name=${user.name}&date=${asignDate}" onclick="return confirm('Are You sure you want to Transfer The Issue ')">Select</a></td>

      </tr>
    </c:forEach>
    <tr><td colspan="7"><a href="registerIssue">Add New Issue</a></td></tr>
  </table>

</center>
</body>
</html>
