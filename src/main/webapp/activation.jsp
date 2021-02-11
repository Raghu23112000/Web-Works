<%--
  Created by IntelliJ IDEA.
  User: rahul
  Date: 24-01-2021
  Time: 01:12 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <link href="https://fonts.googleapis.com/css?family=Poppins:600&display=swap" rel="stylesheet">
    <script src="https://kit.fontawesome.com/a81368914c.js"></script>
    <script src="https://code.jquery.com/jquery-1.10.2.js"></script>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title></title>
</head>

<body style="background: #E6E6E6;">
<div class="banner">
    <%@include file="navigation.jsp"%>
    <div class="container">
        <div class="img">
            <img src="Images/20945597.png" alt="" style="border: none;
            margin-left: 250px;
            margin-top: 30px;
            border-radius: 0%;
            padding: 5px;
            height: 600px;
            width: 600px;">
        </div>
        <div class="login-content" style="margin-top: 50px">
            <form method="post" action="ActivationValidation">
                <img src="Images/avatar.png" alt="">
                <h2 class="title">Welcome</h2><br>
                <div class="input-div one">
                    <div class="i">
                        <i class="fas fa-envelope"></i>
                    </div>
                    <div class="div">
                        <h5>Enter your Email ID</h5>
                        <input type="email" class="input" id="email" name="email" autocomplete="off">
                    </div>
                </div>
                <div class="input-div one">
                    <div class="i">
                        <i class="fas fa-users"></i>
                    </div>
                    <div class="div">
                        <h5>Company Name</h5>
                        <input type="text" class="input" id="cname" name="cname" autocomplete="off">
                    </div>
                </div>
                <div class="input-div one">
                    <div class="i">
                        <i class="fa fa-window-maximize"></i>
                    </div>
                    <div class="div">
                        <h5 style="top: -5px; font-size: 15px;">Platform Needed</h5>
                        <select class="form-control" id="platform" name="platform" onclick="serviceadder()" style="border: none; position: absolute;
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
                        <option value="Rewinding" style="
        background-image: linear-gradient(to right, #32be8f, #38d39f, #32be8f);border: none">Rewinding</option>
                        <option value="Other" style="border: none;">Others</option>
                        </select>
                    </div>
                </div>
                <div id="service"></div>
                <br><br><br><br>
                <input type="submit" class="btn btn-primary" style="width: 100%;margin-left: 0px" value="Buy an activation Key"><br><br>
            </form>
        </div>
    </div>
</div>
<script>
    function serviceadder(){
        var service = document.getElementById("service");
        if(document.getElementById("platform").value==='Other'){
            service.innerHTML="";
            service.innerHTML ="<div class='input-div one'>" +
                "<div class='i'>"+
                "<i class='fas fa-info'></i>"+
                "</div>"+
                "<div class='div'>"+
                "<h5 style='top: -5px; font-size: 15px;'>Enter Platform Name</h5>"+
                "<input type='text' id='platname' name='platname' class='input' autocomplete='off'>" +
                "</div>"+
                "</div>"+
                "<div class='input-div one'>" +
                "<div class='i'>"+
                "<i class='fas fa-wrench'></i>"+
                "</div>"+
                "<div class='div'>"+
                "<h5>Services Needed</h5><br><br>"+
                "<form> " +
                "<div class='checkbox' style='background-color: white;width:100%;margin-top: 10px'>" +
                "<label style='margin-right:70px '><input type='checkbox' value='1' name='record' style='margin-left: -210px;' <h5> Record Management</h5</label><br><br>" +
                "</div> " +
                "<div class='checkbox'> " +
                "<label style='margin-right:50px' ><input type='checkbox' value='1' name='employee' style='margin-left: -190px;'<h5> Employee Management</h5</label><br><br>" +
                "</div> " +
                "<div class='checkbox disabled'>" +
                " <label style='margin-right:50px '><input type='checkbox' value='1' name='stock' style='margin-left: -220px;'<h5> Stock Management</h5</label><br><br>" +
                "</div> " +
                "</form>"+
                "</div> " +
                "</div> " +
                "</form>";
        }
        else{
            service.innerHTML="";
        }

    }

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
</script>
</body>

</html>
