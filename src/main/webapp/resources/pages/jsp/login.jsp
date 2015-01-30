<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%--
  Created by IntelliJ IDEA.
  User: acer
  Date: 1/21/2015
  Time: 11:01 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Spring MVC Form Handling </title>
  <link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet" >
  <link href="${pageContext.request.contextPath}/resources/css/login.css" rel="stylesheet" >
  <link href="${pageContext.request.contextPath}/resources/css/bootstrap.css" rel="stylesheet" >

</head>
<%--<body bg bgcolor="#bdb76b">--%>
<%--<h1>Hi there. WE ARE ISSUETRACKER.</h1>--%>
<%--<h2>Login Page</h2>--%>
<%--<h3>Signup Details</h3>--%>
<%--<table border="1" cellpadding="5" width="500">--%>
  <%--<tr>--%>
    <%--<td>--%>
      <%--<img src="/resources/images/35.jpg" width="500" height="400" />--%>
    <%--</td>--%>
  <%--</tr>--%>
<%--<form action="/login" method="POST">--%>
  <%--<br/>Username:<input type="text" name="username">--%>
  <%--<br/>Password:<input type="password" name="password">--%>
  <%--<br/><input type="submit" value="Submit">--%>

<%--</form>--%>
<%--</table>--%>


<body>
<div class="container">
  <div class="row">
    <div class="col-sm-6 col-md-4 col-md-offset-4">
      <h1 class="text-center login-title">Sign in to Continue</h1>
      <div class="account-wall">
        <img class="profile-img" src="/resources/images/photo.png"
             alt="">
        <form class="form-signin" action="/login" method="POST">
          <input type="text" class="form-control" name="username" placeholder="FirstName or Email" required autofocus>
          <input type="password" class="form-control" name="password" placeholder="Password" required>
          <label class="checkbox pull-left">
            &nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp; &nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;<input name="rememberme" type="checkbox">
            Remember me
          </label>
          <button class="btn btn-lg btn-primary btn-block" type="submit">
            Sign in</button>

          <%--<a href="#" class="pull-right need-help">Need help? </a><span class="clearfix"></span> --%>
        </form>
      </div>
      <a href="signup" class="text-center new-account">Not an Member <br>Create an account(SignUp) </a>
    </div>
  </div>
</div>
</body>
</html>
