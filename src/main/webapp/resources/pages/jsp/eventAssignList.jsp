<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
  <title>IssueTracker</title>
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
<center>


  <div id="next">
    <a href="logout">Logout</a>
  </div>
  <b>Issues To Solve</b>





  <table border="1">
    <tr>
      <td class="heading">Issue Name</td>
      <td class="heading">service Name</td>
      <td class="heading">Issue-Date</td>
      <td class="heading">Assigned-Date</td>
      <td class="heading">Action</td>
    </tr>

    <c:forEach var="event" items="${assigndetail}">
      <tr>
        <td>${event.issuename}</td>
        <td>${event.servicename}</td>
        <td>${event.issuedate}</td>
        <td>${event.assigned_date}</td>


        <td><a href="/showUserToTransferIssue?event_id=${event.issue_event_id}">Assign Issue to Other User</a></td>
      </tr>
    </c:forEach>
    <tr>

    <td rowspan="2"><a href="registerIssue">Register Issue</a></td>
    <td rowspan="2"><a href="/getIssueList">See Issue List</a></td>
    </tr>
  </table>

</center>
</body>
</html>
