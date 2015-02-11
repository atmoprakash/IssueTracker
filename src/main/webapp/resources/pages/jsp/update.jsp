<%--
  Created by IntelliJ IDEA.
  User: acer
  Date: 1/26/2015
  Time: 5:33 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
  th {
    background-color: orange;
    color: white;
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
        <li><a href="issueTrackList">View Event Record</a></li>
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
  <h3> update the user</h3>
<form action="/update" method="post">
  <table border="1">
<thead>

      <th >Id</th>
      <th > name</th>
      <th>Username</th>
      <th >password</th>

</thead>
    <tbody>

    <tr>
    <td><input value="${updateUserValue.user_id}" readonly="value" name="user_id"></td></br>
    <td><input type="text" value="${updateUserValue.name}" name="name"></td></br>
    <td><input type="text" value="${updateUserValue.username}" name="username"></td></br>
    <td><input type="text" value="${updateUserValue.password}" name="password"></td></br>
  </tr>
    </tbody>
  </table>
  <br/>
  <input type="submit" value="Update">

</form>
  </center>
</body>
</html>
