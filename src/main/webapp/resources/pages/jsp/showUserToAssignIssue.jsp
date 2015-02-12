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
  <link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet" >
  <link href="${pageContext.request.contextPath}/resources/css/bootstrap.css" rel="stylesheet" >
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
      <form class="navbar-form navbar-left" action="/assignEvent" method="get">
        <input type="text" class="form-control col-lg-8" placeholder="Search">

      <ul class="nav navbar-nav navbar-right">
        <li><a href="/eventHome">Home</a></li>
        <li><a href="/logout">Logout</a></li>

        </li>
      </ul>
    </div>
  </div>



  <b>Select User to Register Issue to Him/Her </b>





  <table border="1">
    <tr>
      <td class="heading">User Id</td>
      <td class="heading">UserName</td>
      <td class="heading">User UserName</td>
      <td class="heading">Select User</td>
    </tr>
    <c:forEach var="user" items="${userList}">
      <tr>
        <td>${user.user_id}</td>
        <td>${user.name}</td>
        <td>${user.username}</td>
      <%-- <td><a href="assignEvent?user_id=${user.user_id}&username=${user.name}">Select</a></td>--%>
        <td><input type="radio" name="id" value="${user.user_id}"></td>


      </tr>
    </c:forEach>
   <%-- <tr><td colspan="4"><a href="registerIssue">Add New Issue</a></td> --%>
    <td colspan="3"><input type="submit" value="Submit">

    </td>

    </tr>


  </table>
  </center>
  </form>


</body>
</html>
