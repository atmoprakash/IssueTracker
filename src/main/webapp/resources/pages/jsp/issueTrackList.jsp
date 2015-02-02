<%--
  Created by IntelliJ IDEA.
  User: sakshi
  Date: 2/2/2015
  Time: 10:17 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
  <title>IssueTrackerList</title>
  <style>
    #next {
      position: absolute;
      right: 17%;
    }
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
<form action="" method="post">

  <table border="1">
    <tr>
      <td class="heading">Issue Name</td>
      <td class="heading">Service Name</td>
      <td class="heading">Issue Assigned To</td>
      <td class="heading">Issue Transfer To</td>
      <td class="heading">Issue Created-Date</td>
      <td class="heading">Issue Solve Date</td>
      <td class="heading">Remarks</td>
    </tr>
<c:forEach var="issueTrack" items="${issueList}">
  <tr>
  <td>${issueTrack.issuename}</td>
  <td>${issueTrack.servicename}</td>
    <td>${issueTrack.issue_assigned_to}</td>
    <td>${issueTrack.issue_transfer_to}</td>
    <td>${issueTrack.event_created_date}</td>
    <td>${issueTrack.event_solve_date}</td>
    <td>${issueTrack.remarks}</td>
  </tr>
  </c:forEach>

  </table>
</form>

</body>
</html>
