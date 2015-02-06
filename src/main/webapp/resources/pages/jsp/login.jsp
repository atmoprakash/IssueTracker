<%--<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>--%>

<%--&lt;%&ndash;--%>
  <%--Created by IntelliJ IDEA.--%>
  <%--User: acer--%>
  <%--Date: 1/21/2015--%>
  <%--Time: 11:01 AM--%>
  <%--To change this template use File | Settings | File Templates.--%>
<%--&ndash;%&gt;--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%--<html>--%>
<%--<head>--%>
    <%--<title>Spring MVC Form Handling </title>--%>
  <%--<link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet" >--%>
  <%--<link href="${pageContext.request.contextPath}/resources/css/login.css" rel="stylesheet" >--%>
  <%--<link href="${pageContext.request.contextPath}/resources/css/bootstrap.css" rel="stylesheet" >--%>

<%--</head>--%>
<%--&lt;%&ndash;<body bg bgcolor="#bdb76b">&ndash;%&gt;--%>
<%--&lt;%&ndash;<h1>Hi there. WE ARE ISSUETRACKER.</h1>&ndash;%&gt;--%>
<%--&lt;%&ndash;<h2>Login Page</h2>&ndash;%&gt;--%>
<%--&lt;%&ndash;<h3>Signup Details</h3>&ndash;%&gt;--%>
<%--&lt;%&ndash;<table border="1" cellpadding="5" width="500">&ndash;%&gt;--%>
  <%--&lt;%&ndash;<tr>&ndash;%&gt;--%>
    <%--&lt;%&ndash;<td>&ndash;%&gt;--%>
      <%--&lt;%&ndash;<img src="/resources/images/35.jpg" width="500" height="400" />&ndash;%&gt;--%>
    <%--&lt;%&ndash;</td>&ndash;%&gt;--%>
  <%--&lt;%&ndash;</tr>&ndash;%&gt;--%>
<%--&lt;%&ndash;<form action="/login" method="POST">&ndash;%&gt;--%>
  <%--&lt;%&ndash;<br/>Username:<input type="text" name="username">&ndash;%&gt;--%>
  <%--&lt;%&ndash;<br/>Password:<input type="password" name="password">&ndash;%&gt;--%>
  <%--&lt;%&ndash;<br/><input type="submit" value="Submit">&ndash;%&gt;--%>

<%--&lt;%&ndash;</form>&ndash;%&gt;--%>
<%--&lt;%&ndash;</table>&ndash;%&gt;--%>


<%--<body>--%>
<%--<div class="container">--%>
  <%--<div class="row">--%>
    <%--<div class="col-sm-6 col-md-4 col-md-offset-4">--%>
      <%--<h1 class="text-center login-title">Sign in to Continue</h1>--%>
      <%--<div class="account-wall">--%>
        <%--<img class="profile-img" src="/resources/images/photo.png"--%>
             <%--alt="">--%>
        <%--<form class="form-signin" action="/login" method="POST">--%>
          <%--<input type="text" class="form-control" name="username" placeholder="FirstName or Email" required autofocus>--%>
          <%--<input type="password" class="form-control" name="password" placeholder="Password" required>--%>
          <%--<label class="checkbox pull-left">--%>
            <%--&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp; &nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;<input name="rememberme" type="checkbox">--%>
            <%--Remember me--%>
          <%--</label>--%>
          <%--<button class="btn btn-lg btn-primary btn-block" type="submit">--%>
            <%--Sign in</button>--%>

          <%--&lt;%&ndash;<a href="#" class="pull-right need-help">Need help? </a><span class="clearfix"></span> &ndash;%&gt;--%>
        <%--</form>--%>
      <%--</div>--%>
      <%--<a href="signup" class="text-center new-account">Not an Member <br>Create an account(SignUp) </a>--%>
    <%--</div>--%>
  <%--</div>--%>
<%--</div>--%>
<%--</body>--%>
<%--</html>--%>



<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>


  <!--META-->
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <title>Login Form</title>

  <!--STYLESHEETS-->
  <link href="/resources/css/style.css" rel="stylesheet" type="text/css" />

  <!--SCRIPTS-->
  <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.2.6/jquery.min.js"></script>
  <!--Slider-in icons-->
  <script type="text/javascript">
    $(document).ready(function() {
      $(".username").focus(function() {
        $(".user-icon").css("left","-48px");
      });
      $(".username").blur(function() {
        $(".user-icon").css("left","0px");
      });

      $(".password").focus(function() {
        $(".pass-icon").css("left","-48px");
      });
      $(".password").blur(function() {
        $(".pass-icon").css("left","0px");
      });
    });
  </script>

</head>
<body>

<!--WRAPPER-->
<div id="wrapper">

  <!--SLIDE-IN ICONS-->
  <div class="user-icon"></div>
  <div class="pass-icon"></div>
  <!--END SLIDE-IN ICONS-->

  <!--LOGIN FORM-->
  <form name="login-form" class="login-form" action="/login" method="post">

    <!--HEADER-->
    <div class="header">
      <!--TITLE--><h1>Login Form</h1><!--END TITLE-->
      <!--DESCRIPTION--><span>Fill out the form below to login to my super awesome imaginary control panel.</span><!--END DESCRIPTION-->
    </div>
    <!--END HEADER-->

    <!--CONTENT-->
    <div class="content">
      <!--USERNAME--><input name="username" type="text" class="input username" value="Username" onfocus="this.value=''" /><!--END USERNAME-->
      <!--PASSWORD--><input name="password" type="password" class="input password" value="Password" onfocus="this.value=''" /><!--END PASSWORD-->
    </div>
    <!--END CONTENT-->

    <!--FOOTER-->
    <div class="footer">
      <!--LOGIN BUTTON--><input type="submit" name="submit" value="Login" class="button" /><!--END LOGIN BUTTON-->
      <!--REGISTER BUTTON--><input type="submit" name="submit" value="Register" class="register" /><!--END REGISTER BUTTON-->
    </div>
    <!--END FOOTER-->

  </form>
  <!--END LOGIN FORM-->

</div>
<!--END WRAPPER-->

<!--GRADIENT--><div class="gradient"></div><!--END GRADIENT-->

</body>
</html>