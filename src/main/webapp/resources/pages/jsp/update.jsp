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
    <title></title>
</head>
<body>
<form action="/update" method="post">
  <table border="1">
    <thead>
    <tr>
      <th>name</th>
      <th>Username</th>
      <th>password</th>
    </tr>
    </thead>
    <tbody>
    <tr>
    <td><input type="text" value="${updateUserValue.name}" name="name"></td></br>
    <td><input type="text" value="${updateUserValue.username}" name="username"></td></br>
    <td><input type="text" value="${updateUserValue.password}" name="password"></td></br>
  </tr>
    </tbody>
  </table>
  <input type="submit" value="Update">

</form>
</body>
</html>
