<%--
  Created by IntelliJ IDEA.
  User: acer
  Date: 1/27/2015
  Time: 2:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
  <title>IssueTracker</title>
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
      text-align: left;
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


  <b>IssueTracker | Registration Form </b>
<div>
    <form method="post" action="/insertIssue" >
      <table>
        <tr>
          <td class="heading">Issue Name</td>
          <td class="heading">Service Name</td>
          <td class="heading">Customer Name</td>
        </tr>
        <tr>
          <td><input type="text" name="issuename" required="" /></td>
          <td><input type="text" name="servicename" required=""/></td>
          <td><input type="text" name="customername" required=""/></td>
          <td><input type="submit" value="Submit"> </td>
        </tr>


      </table>
    </form>
  </div>
</center>
</body>
</html>