<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
  <title>IssueTracker</title>
  <link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
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
      <a class="navbar-brand" href="/add">Add User</a>
      <a class="navbar-brand" href="/home">Show User</a>
    </div>
    <div class="navbar-collapse collapse navbar-inverse-collapse">
      <ul class="nav navbar-nav">
        <li class="active"><a href="getIssueList">Show Issues List</a></li>
        <li><a href="registerIssue">Resister Issues</a></li>
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown">Dropdown <b class="caret"></b></a>
          <ul class="dropdown-menu">
            <li><a href="#">Action</a></li>
            <li><a href="#">Another action</a></li>
            <li><a href="#">Something else here</a></li>
            <li class="divider"></li>
            <li class="dropdown-header">Dropdown header</li>
            <li><a href="#">Separated link</a></li>
            <li><a href="#">One more separated link</a></li>
          </ul>
        </li>
      </ul>
      <form class="navbar-form navbar-left">
        <input type="text" class="form-control col-lg-8" placeholder="Search">
      </form>
      <ul class="nav navbar-nav navbar-right">
        <li><a href="#">Link</a></li>
        <li><a href="/logout">Logout</a></li>

        </li>
      </ul>
    </div>
  </div>
<h2>IssueTracker</h2>
  <b> Register Issue  </b>
  <div>
    <form method="post" action="/insertIssue" >
      <table>
        <tr>
          <td class="heading">Issue Name</td>
          <td class="heading">Service Company</td>
          <td class="heading">Customer Name</td>
        </tr>
        <tr>
          <td><input type="text" placeholder="issuename" name="issuename" required="" /></td>
          <td><input type="text" placeholder="servicename" name="servicename" required=""/></td>
          <td><input type="text" placeholder="customername" name="customername" required=""/></td>
          <td><input type="submit" value="Submit"> </td>
        </tr>


      </table>
    </form>
  </div>
<br/><br/>
  <b>Issues To Solve By You</b>
  <table border="1">
    <tr>
      <td class="heading">SN</td>
      <td class="heading">Issue Name</td>
      <td class="heading">Company Related</td>
      <td class="heading">Issue-Date Registered</td>
      <td class="heading">Issue Assigned To You</td>
      <td colspan="2" class="heading">Action</td>
    </tr>


        <c:forEach var="event" items="${assigndetail}">
          <%! int sn=1; %>
      <tr>
        <td><%=sn%></td>
        <td>${event.issuename}</td>
        <td>${event.servicename}</td>
        <td>${event.issuedate}</td>
        <td>${event.assigned_date}</td>


        <td><h5><a href="/showUserToTransferIssue?event_id=${event.issue_event_id}">Transfer Issue to Other User</a></h5></td>
        <td><h5><a href="/showUserToTransferIssue?event_id=${event.issue_tracker_id}">Solve</a></h5></td>
      </tr>
          <% sn++; %>
    </c:forEach>

  </table>

</center>
</body>
</html>
