<%--
  Created by IntelliJ IDEA.
  User: rahul
  Date: 08-02-2021
  Time: 11:36 PM
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
<sql:query var="rs" dataSource="${db}">select * from productinfo</sql:query>
<div class="container">
    <div class="jumbotron">
        <h1>Purchase List...</h1>
        <table class="table">
            <thead>
            <tr>
                <th>Product Id</th>
                <th>Platform Code</th>
                <th>Platform</th>
                <th>Organization</th>
                <th>Product Key</th>
                <th>Activation Status</th>
                <th>Email</th>
<%--                <th>Remove</th>--%>
            </tr>
            </thead>
            <c:forEach items="${rs.rows}" var="pr">
            <tbody>
            <tr>
                <td>${pr.prid}</td>
                <td>${pr.PlatformCode}</td>
                <td>${pr.Platform}</td>
                <td>${pr.Organization}</td>
                <td>${pr.ProductKey}</td>
                <c:if test="${pr.ActivationStatus==0}" >
                    <c:set var="act" value="Not Active"/>
                </c:if>
                <c:if test="${pr.ActivationStatus==1}" >
                    <c:set var="act" value="Active"/>
                </c:if>
                <td>${act}</td>
                <td>${pr.Email}</td>
<%--                <td><button type="button" class="btn btn-primary">Remove</button></td>--%>
            </tr>
            </tbody>
            </c:forEach>
        </table>
        <button type="button" class="btn btn-primary"
                onclick="location.href='admindashboard.jsp'">Dashboard</button>
    </div>
</div>
</body>

</html>