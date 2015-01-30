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



  <b>All Issues Registered </b>





  <table border="1">
    <tr>
      <td class="heading">Issue Registered Id</td>
      <td class="heading">Issue Name</td>
      <td class="heading">Service Name</td>
      <td class="heading">Issue Date</td>
      <td class="heading">Customer Name</td>
      <td class="heading">Created By</td>
      <td class="heading">Assign Issue to User</td>

    </tr>
    <c:forEach var="user" items="${issueList}">
      <tr>
        <td>${user.issue_tracker_id}</td>
        <td>${user.issuename}</td>
        <td>${user.servicename}</td>
        <td>${user.issuedate}</td>
        <td>${user.customername}</td>
        <td>${user.createdby}</td>
        <td><a href="/showUserToAssignIssue?issue_tracker_id=${user.issue_tracker_id}">Assign issue to User</a></td>

      </tr>
    </c:forEach>
    <tr><td colspan="7"><a href="registerIssue">Add New Issue</a></td></tr>
  </table>

</center>
</body>
</html>
