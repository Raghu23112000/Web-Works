<%@ page contentType="text/html;charset=UTF-8" language="java" errorPage="../AddOnServices/errorpage.jsp"%>
<%@ include file="../AddOnServices/DBconnect.jsp"%>
<html>
<head>

</head>
<%@include file="employeedashboard.jsp"%>
<style>
    .styled-table {
        border-collapse: collapse;
        margin-top: 30px;
        margin-left: 270px;
        font-size: 0.9em;
        font-family: sans-serif;
        min-width: 400px;
        box-shadow: 0 0 20px rgba(0, 0, 0, 0.15);
    }
    .styled-table thead tr {
        background-color: #532E1C;
        color: #ffffff;
        text-align: center;
    }
    .styled-table th,
    .styled-table td {
        padding: 12px 15px;
    }
    .styled-table tbody tr {
        border-bottom: 1px solid #dddddd;
    }

    .styled-table tbody tr:nth-of-type(even) {
        background-color: #f3f3f3;
    }

    .styled-table tbody tr:last-of-type {
        border-bottom: 2px solid #009879;
    }
    .styled-table tbody tr.active-row {
        font-weight: bold;
        color: #009879;
    }
</style>
<body style="background: white;">
<sql:query var="rs" dataSource="${db}">select * from employeedetails where cusid=<%= session.getAttribute("cusid") %></sql:query>
<table class="styled-table">
    <thead>
    <th>
        Employee ID
    </th>
    <th>
        Employee Name
    </th>
    <th>
        Address
    </th>
    <th>
        Date Of Birth
    </th>
    <th>
        Phone Number
    </th>
    <th>
        Salary
    </th>
    <th>
        Current Salary
    </th>
    </thead>
<c:forEach items="${rs.rows}" var="emp">
    <tr class="active-row">
        <td>${emp.empid}</td>
        <td>${emp.Name}</td>
        <td>${emp.Address}</td>
        <td>${emp.DOB}</td>
        <td>${emp.Phone}</td>
        <td>${emp.Salary}</td>
        <td>${emp.CurSalary}</td>
    </tr>
</c:forEach>
</table>
<button type="button" class="btn btn-primary" onclick="location.href='employeedashboard.jsp'">Back</button>
</body>
</html>
