<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
  <title>IssueTracker</title>
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
  <script>
    function validateIssueForm() {
      var issuename = document.getElementById('issuename');
      var servicename = document.getElementById('servicename');
      var customername = document.getElementById('customername');
      if (textAlphanumeric(issuename, "* For Issues please use numbers and letters *")) {
      if (textAlphanumeric(servicename, "* For Services please use numbers and letters *")) {
        if (textAlphanumeric(customername, "* For Name please use numbers and letters *")) {
          return true;
        }
      }}
        return false
    }
    function textAlphanumeric(inputtext,alert) {
      var alphaExp = /^[a-zA-Z]+$/;
      if (inputtext.value.match(alphaExp)) {
        return true;
      } else {
        document.getElementById('p1').innerText = alert; // This segment displays the validation rule for issuename.
        inputtext.focus();
        return false;
      }
    }</script>
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

      </ul>
      <form class="navbar-form navbar-left">
        <input type="text" class="form-control col-lg-8" placeholder="Search">
      </form>
      <ul class="nav navbar-nav navbar-right">
        <li><a href="/eventHome">Home[ Welcome ${name}]</a></li>
        <li><a href="/logout">Logout</a></li>

        </li>
      </ul>
    </div>
  </div>
<h3>IssueTracker</h3>
  <b> Register Issue</b>
    <div id="form">
      <p id="head"></p>
      <!-- Form starts from here -->
    <form  onsubmit='return validateIssueForm()' method="post" action="/insertIssue" >
      <table>
        <tr>
          <td class="heading">Issue Name</td>
          <td class="heading">Service Name</td>
          <td class="heading">Customer Name</td>
        </tr>
        <tr>
          <td><input id="issuename" type="text" placeholder="issuename" name="issuename"  /></td>
          <p id="p1"></p>
          <td><input id="servicename" type="text" placeholder="servicename" name="servicename" required=""/></td>

          <td><input id="customername" type="text" placeholder="customername" name="customername" required=""/></td>

          <td><input type="submit" value="Submit"> </td>
        </tr>


      </table>
    </form>
  </div>
<br/><br/>
  <b>New Issues Needed To Solve by You</b>
  <table border="1">
    <tr>
      <td class="heading">Sn</td>
      <td class="heading">Issue Name</td>
      <td class="heading">service Name</td>
      <td class="heading">Issue-Date</td>
      <td class="heading">Assigned-Date</td>
      <td colspan="2" class="heading">Action</td>

    </tr>
    <c:set var="count" value="1" scope="page"/>
    <c:forEach var="event" items="${assigndetail}">
      <tr>
        <td>${count}</td>
        <td>${event.issuename}</td>
        <td>${event.servicename}</td>
        <td>${event.issuedate}</td>
        <td>${event.assigned_date}</td>
  <td><a href="/showUserToTransferIssue?event_id=${event.issue_event_id}&issue_date=${event.issuedate}">Assign Issue to Other User</a></td>
        <td>
          <a href="/solve?event_id=${event.issue_event_id}">Solve</a>
        </td>
      </tr>
      <c:set var="count" value="${count+1}"/>
    </c:forEach>


  </table>

</center>
</body>
</html>
