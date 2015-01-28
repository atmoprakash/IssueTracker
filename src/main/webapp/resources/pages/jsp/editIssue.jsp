<%--
  Created by IntelliJ IDEA.
  User: acer
  Date: 1/27/2015
  Time: 9:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<html>
<head>
  <title>Being Java Guys | Spring DI Hello World</title>
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



  <b>Edit Issue Details </b>


  <div>
    <form  action="/updateIssue" method="post">
      <table>
        <tr>
          <td>Issue Id :</td>
          <td>
            <input  value="${editIssue.id}" readonly="value" name="id" />
          </td>
        </tr>
        <tr>
          <td>Issue Name :</td>
          <td>
                <input type="text" value="${editIssue.issuename}" name="issuename" />
          </td>
        </tr>
        <tr>
          <td>Service Name :</td>
          <td><input type="text" value="${editIssue.servicename}" name="servicename" />
          </td>
        </tr>

        <tr>
          <td>Issue Date :</td>
          <td><input type="text" placeholder="${editIssue.issuedate}" readonly="readonly" name="issuedate"/>
          </td>
        </tr>

        <tr>
          <td>Customer Name :</td>
          <td><input type="text" value="${editIssue.customername}" name="customername" />
          </td>
        </tr>

        <tr>
          <td>Created By :</td>
          <td><input type="text" value="${editIssue.createdby}" name="createdby"/>
          </td>
        </tr>


        <td><input type="submit" value="Update Issue" />
          </td>
        </tr>
      </table>

    </form>
  </div>
</center>
</body>
</html>