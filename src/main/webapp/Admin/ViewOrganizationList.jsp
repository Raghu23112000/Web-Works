<%--
  Created by IntelliJ IDEA.
  User: rahul
  Date: 08-02-2021
  Time: 11:22 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../AddOnServices/DBconnect.jsp"%>
<html>

<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
</head>

<body>
<sql:query var="rs" dataSource="${db}">select * from customerlogin where cusid<>999</sql:query>
<div class="container">
    <div class="jumbotron">
        <h1>Organization List...</h1>
        <form method="post" action="RemoveOrgServlet">
        <table class="table">
            <thead>
            <tr>
                <th>Organization Id</th>
                <th>Platform Code</th>
                <th>Owner Name</th>
                <th>Organization</th>
                <th>Date Of Birth</th>
                <th>Product Key</th>
                <th>Activation Date</th>
<%--                <th>Remove Organization</th>--%>
            </tr>
            </thead>
            <c:forEach items="${rs.rows}" var="cus">
            <tbody>
            <tr>
                <td>${cus.cusid}</td>
                <td>${cus.PlatformCode}</td>
                <td>${cus.Name}</td>
                <td>${cus.Organization}</td>
                <td>${cus.DOB}</td>
                <td>${cus.ProductKey}</td>
                <td>${cus.ActivationDate}</td>
<%--                <td><input type="submit" class="btn btn-primary" value="Remove" name="${cus.cusid}"></td>--%>
            </tr>
            </tbody>
            </c:forEach>
        </form>
        </table>
        <button type="button" class="btn btn-primary" onclick="location.href='admindashboard.jsp'">Dashboard</button>
    </div>
</div>
</body>

</html>