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
    <tr>

      <td>${1}</td>
      <td>${last.issuename}</td>
      <td>${last.servicename}</td>
      <td>${last.issuedate}</td>
      <td>${last.customername}</td>
      <td>${last.createdby}</td>
      <td><a href="/showUserToAssignIssue?issue_tracker_id=${last.issue_tracker_id}">Assign issue to User</a></td>
    </tr>
    <%--<%! int sn=2 ;%>--%>
    <c:set var="count" value="2" scope="page"/>
    <c:forEach var="user" items="${issueList}" begin="1">
      <tr>

        <td><c:out value="${count}"/></td>
        <td>${user.issuename}</td>
        <td>${user.servicename}</td>
        <td>${user.issuedate}</td>
        <td>${user.customername}</td>
        <td>${user.createdby}</td>
     <c:set var="count" value="${count+1}"/>
        </c:forEach>


      </tr>



  </table>

</center>
</body>
</html>
