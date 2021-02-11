<%--
  Created by IntelliJ IDEA.
  User: rahul
  Date: 24-01-2021
  Time: 01:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="AddOnServices/DBconnect.jsp"%>
<html>
<head>
    <title></title>
    <link rel="stylesheet" type="text/css" href="CSS/sidebar.css">
    <link href="https://fonts.googleapis.com/css?family=Poppins:600&display=swap" rel="stylesheet">
    <script src="https://kit.fontawesome.com/a81368914c.js"></script>
    <script src="https://code.jquery.com/jquery-1.10.2.js"></script>
    <meta name="viewport" content="width=device-width, initial-scale=1">
</head>

<style>
    * {
        font-family: sans-serif;
    }
    .navbar {
        overflow: hidden;
        position: sticky;
        top:0;
        width: 100%;
        height: 10%;
        background: black;
        display: flex;
        align-items: center;
        justify-content: space-between;
    }
    .navbar ul li {
        list-style: none;
        display: inline-block;
        margin: 0 20px;
        position: relative;
    }
    .navbar ul li a {
        text-decoration: none;
        color: white;
        text-transform: uppercase;
    }
    .navbar ul li::after {
        content: "";
        height: 3px;
        width: 0;
        background: white;
        position: absolute;
        left: 0;
        bottom: -10px;
        transition: 0.5s;
    }
    .navbar ul li:hover::after {
        width: 100%;
    }
</style>
<body style="background: white;">

<div class="banner">
    <div class="navbar">
        <a class="navbar-brand" href="#"><img src="" width="30" height="30" class="d-inline-block align-top" alt=""></a>
        <ul>
            <li><label style="color: white;">Welcome,<span id="rockers"></span></label></li>
            <li><a href="#">Contact</a></li>
            <li><a href="index.jsp">Logout</a></li>
        </ul>
        <c:set var="p1" scope="session" value='<%= (int)session.getAttribute("p1") %>'/>
        <c:set var="p2" scope="session" value='<%= (int)session.getAttribute("p2") %>'/>
        <c:set var="p3" scope="session" value='<%= (int)session.getAttribute("p3") %>'/>
        <c:set var="plat" scope="session" value='<%= (int)session.getAttribute("plat") %>'/>
    </div>
</div>
<script>

    <sql:query var="rs" dataSource="${db}">select * from customerlogin where cusid=<%= session.getAttribute("cusid") %></sql:query>
    <c:forEach var="row" items="${rs.rows}">
    var x = '${row.Name}';
    </c:forEach>
    document.getElementById("rockers").innerHTML=x;
</script>
<%@include file="mainsidebar.jsp"%>
</body>

</html>
