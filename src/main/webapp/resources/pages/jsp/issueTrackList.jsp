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
  <link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet" >
  <link href="${pageContext.request.contextPath}/resources/css/login.css" rel="stylesheet" >
  <link href="${pageContext.request.contextPath}/resources/css/bootstrap.css" rel="stylesheet" >
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
  <div class="navbar navbar-inverse">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-inverse-collapse">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="/home">Show Users</a>
    </div>
    <div class="navbar-collapse collapse navbar-inverse-collapse">
      <ul class="nav navbar-nav">
        <li class="active"><a href="getIssueListMenu">Show Issues List</a></li>
        <%--<li><a href="issueTrackList">View Event Record</a></li>--%>
        <%--<li class="dropdown">--%>
        <%--<a href="#" class="dropdown-toggle" data-toggle="dropdown">Dropdown <b class="caret"></b></a>--%>
        <%--<ul class="dropdown-menu">--%>
        <%--<li><a href="#">Action</a></li>--%>
        <%--<li><a href="#">Another action</a></li>--%>
        <%--<li><a href="#">Something else here</a></li>--%>
        <%--<li class="divider"></li>--%>
        <%--<li class="dropdown-header">Dropdown header</li>--%>
        <%--<li><a href="#">Separated link</a></li>--%>
        <%--<li><a href="#">One more separated link</a></li>--%>
        <%--</ul>--%>
        <%--</li>--%>
      </ul>
      <form class="navbar-form navbar-left">
        <input type="text" class="form-control col-lg-8" placeholder="Search">
      </form>
      <ul class="nav navbar-nav navbar-right">
        <li><a href="/eventHome">Home</a></li>
        <li><a href="/logout">Logout</a></li>

        </li>
      </ul>
    </div>
  </div>

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
</center>
</body>
</html>
