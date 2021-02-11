<%--
  Created by IntelliJ IDEA.
  User: rahul
  Date: 08-02-2021
  Time: 11:19 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
</head>

<body>
<div class="container">
    <div class="jumbotron">
        <h1>Web Works Admin Dashboard...</h1>
        <button type="button" class="btn btn-primary" onclick="location.href='ViewOrganizationList.jsp'">View customer
            list</button>
        <button type="button" class="btn btn-primary" onclick="location.href='ViewProductList.jsp'">View purchase
            list</button>
        <button type="button" class="btn btn-primary" onclick="location.href='../index.jsp'">Log Out</button>
    </div>
</div>
</body>
</html>