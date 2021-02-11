<%--
  Created by IntelliJ IDEA.
  User: rahul
  Date: 24-01-2021
  Time: 01:25 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" errorPage="../AddOnServices/errorpage.jsp"%>
<%@ include file="../AddOnServices/DBconnect.jsp"%>
<html>
<%@include file="employeedashboard.jsp"%>
<style>

    * {
        padding: 0;
        margin: 0;
        font-family: sans-serif;
    }

    body {
        font-family: "Poppins", sans-serif;
        overflow-x: hidden;
    }
    .banner {
        background: white;
    }
    .wave {
        position: fixed;
        bottom: 0;
        left: 0;
        height: 100%;
        z-index: -1;
        border: 1px solid #ddd;
        border-radius: 4px;
        padding: 5px;
        width: 150px;
    }

    .container {
        position: absolute;
        margin-top: 50px;
        width: 100vw;
        height: 75vh;
        left: 0px;
        margin-left: 400px;
        display: grid;
        grid-template-columns: repeat(2, 1fr);
        grid-gap: 7rem;
        padding: 0 2rem;
        background: white;

    }


    .login-content {
        display: block;
        justify-content: flex-start;
        align-items: center;
        text-align: center;
        background: white;

    }



    form {
        width: 360px;
        display: block;
    }

    .login-content img {
        height: 100px;
    }

    .login-content h2 {
        margin: 15px 0;
        color: black;
        text-transform: uppercase;
        font-size: 2.9rem;
    }

    .login-content .input-div {
        position: relative;
        display: grid;
        grid-template-columns: 7% 93%;
        margin: 25px 0;
        padding: 5px 0;
        border-bottom: 2px solid #C5A880;
    }

    .login-content .input-div.one {
        margin-top: 0;
    }

    .i {
        color: #C5A880;
        display: flex;
        justify-content: center;
        align-items: center;
    }

    .i i {
        transition: 0.3s;
    }

    .input-div > div {
        position: relative;
        height: 45px;
    }

    .input-div > div > h5 {
        position: absolute;
        left: 10px;
        top: 50%;
        transform: translateY(-50%);
        color: #999;
        font-size: 18px;
        transition: 0.3s;
    }

    .input-div:before,
    .input-div:after {
        content: "";
        position: absolute;
        bottom: -2px;
        width: 0%;
        height: 2px;
        background-color: #b3913e;
        transition: 0.4s;
    }

    .input-div:before {
        right: 50%;
    }

    .input-div:after {
        left: 50%;
    }

    .input-div.focus:before,
    .input-div.focus:after {
        width: 50%;
    }

    .input-div.focus > div > h5 {
        top: -5px;
        font-size: 15px;
    }

    .input-div.focus > .i > i {
        color: #b3913e;
    }

    .input-div > div > input {
        position: absolute;
        left: 0;
        top: 0;
        width: 100%;
        height: 100%;
        border: none;
        outline: none;
        background: none;
        padding: 0.5rem 0.7rem;
        font-size: 1.2rem;
        color: #555;
        font-family: "poppins", sans-serif;
    }

    .input-div.pass {
        margin-bottom: 4px;
    }

    a {
        display: block;
        text-align: right;
        text-decoration: none;
        color: #999;
        font-size: 0.9rem;
        transition: 0.3s;
    }

    a:hover {
        color: #38d39f;
    }

    .btn {
        display: block;
        margin-left: 80px;
        width: 50%;
        height: 50px;
        border-radius: 25px;
        outline: none;
        border: none;
        background-image: linear-gradient(to right, #532E1C, #493323, #5e422d);
        background-size: 200%;
        font-size: 1.2rem;
        color: #fff;
        font-family: "Poppins", sans-serif;
        text-transform: uppercase;
        cursor: pointer;
        transition: 0.5s;
    }
    .btn:hover {
        background-position: right;
    }

    @media screen and (max-width: 1050px) {
        .container {
            grid-gap: 5rem;
        }
    }

    @media screen and (max-width: 1000px) {
        form {
            width: 290px;
        }

        .login-content h2 {
            font-size: 2.4rem;
            margin: 8px 0;
        }

        .img img {
            width: 400px;
        }
    }

    @media screen and (max-width: 900px) {
        .container {
            grid-template-columns: 1fr;
        }

        .img {
            display: none;
        }

        .wave {
            display: none;
        }

        .login-content {
            justify-content: center;
        }
    }
</style>
<body style="background: white;">
<sql:query var="rs" dataSource="${db}">select empid from employeedetails where cusid=<%= session.getAttribute("cusid") %></sql:query>
<div class="banner">
    <div class="container">
        <div class="jumbotron">
            <h2>Edit Your Employee Details Here...</h2><br><br>
            <div class="login-content">
                <form method="post" action="EditEmployeeServlet">
                    <div class="input-div one">
                        <div class="i">
                            <i class="fa fa-hashtag"></i>
                        </div>
                        <div class="div">
                            <h5 style="top: -5px; font-size: 15px;">Employee ID</h5>
                            <select class="form-control" id="empid" name="empid" onclick="getEmpDetails(this.value)" style="border: none; position: absolute;
        left: 0;
        top: 0;
        width: 100%;
        height: 100%;
        outline: none;
        padding: 0.5rem 0.7rem;
        font-size: 1.2rem;
        color: #555;
        outline: 0px;
        background: none;
        font-family: "poppins", sans-serif;">
                                <c:forEach items="${rs.rows}" var="emp">
                                    <option><c:out value="${emp.empid}"></c:out></option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                    <div class="input-div one">
                        <div class="i">
                            <i class="fa fa-user"></i>
                        </div>
                        <div class="div">
                            <h5 style="top: -5px; font-size: 15px;">Employee Name</h5>
                            <input type="text" class="input" id="ename" name="ename" autocomplete="off" required>
                        </div>
                    </div>
                    <div class="input-div one">
                        <div class="i">
                            <i class="fa fa-home"></i>
                        </div>
                        <div class="div">
                            <h5 style="top: -5px; font-size: 15px;">City</h5>
                            <input class="input" rows="5" id="address" name="address" autocomplete="off" required>
                        </div>
                    </div>
                    <div class="input-div one">
                        <div class="i">
                            <i class="fa fa-birthday-cake"></i>
                        </div>
                        <div class="div">
                            <h5 style="top: -5px; font-size: 15px;">Date Of Birth</h5>
                            <input type="date" class="input" id="dob" name="dob" autocomplete="off" required>
                        </div>
                    </div>
                    <div class="input-div one">
                        <div class="i">
                            <i class="fa fa-mobile"></i>
                        </div>
                        <div class="div">
                            <h5 style="top: -5px; font-size: 15px;">Phone Number</h5>
                            <input type="tele" class="input" id="number" name="number" autocomplete="off" required>
                        </div>
                    </div>
                    <div class="input-div one">
                        <div class="i">
                            <i class="fa fa-money"></i>
                        </div>
                        <div class="div">
                            <h5 style="top: -5px; font-size: 15px;">Salary</h5>
                            <input type="text" class="input" id="salary" name="salary" autocomplete="off" required>
                        </div>
                    </div>
                    <input type="submit" class="btn btn-primary" value="Update" name="button"><br>
                    <input type="submit" class="btn btn-primary" value="Delete" name="button">
                </form>
            </div>
        </div>
    </div>
</div>

<script>
    const inputs = document.querySelectorAll(".input");


    function addcl() {
        let parent = this.parentNode.parentNode;
        parent.classList.add("focus");
    }

    function remcl() {
        let parent = this.parentNode.parentNode;
        if (this.value === "") {
            parent.classList.remove("focus");
        }
    }


    inputs.forEach(input => {
        input.addEventListener("focus", addcl);
        input.addEventListener("blur", remcl);
    });
    function getEmpDetails(str)
    {
        var ob=new XMLHttpRequest();
        ob.onreadystatechange=function ss()
        {
            if(ob.readyState==4)
            {
                var details=ob.responseText.split("||");
                document.getElementById("ename").value=details[0];
                document.getElementById("address").value=details[1];
                document.getElementById("dob").value=details[2];
                document.getElementById("number").value=details[3];
                document.getElementById("salary").value=details[4];
            }
        }
        var path="GetDetails?empid="+str;
        ob.open("GET",path,false);
        ob.send();
        return true;
    }
</script>

</body>

</html>
