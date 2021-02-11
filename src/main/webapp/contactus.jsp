<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>

<head>
    <title></title>
</head>

<%@include file="maincss.jsp"%>
<body style="background: #E6E6E6;">
<div class="banner">
    <%@include file="navigation.jsp"%>
    <div class="container">
        <div class="img">
            <img src="Images/Contact.png" alt="" style="border: none;
    margin-left: 30px;
    border-radius: 0%;
    padding: 5px;
    height: 600px;
    width: 600px;">
        </div>
        <div class="login-content" style="margin-top: 100px;">
            <form>
                <img src="Images/avatar.png" alt="">
                <h2 class="title">Contact Us here</h2>
                <h5 class="title">Bring us your queries</h5>
                <div class="input-div one">
                    <div class="i">
                        <i class="fas fa-envelope"></i>
                    </div>
                    <div class="div">
                        <h5>Email</h5>
                        <input type="text" class="input" id="uname" name="uname" autocomplete="off" onfocus="if(this.value===this.defaultValue)this.value=''" onblur="if(this.value==='')this.value=this.defaultValue" >
                    </div>
                </div>
                <div class="input-div one">
                    <div class="i">
                        <i class="fas fa-user"></i>
                    </div>
                    <div class="div">
                        <h5>Name</h5>
                        <input type="text" class="input" id="name" name="name" autocomplete="off">
                    </div>
                </div>
                <div class="input-div one">
                    <div class="i">
                        <i class="fas fa-mobile"></i>
                    </div>
                    <div class="div">
                        <h5>Phone Number</h5>
                        <input type="tel" class="input" id="number" name="phone" autocomplete="off">
                    </div>
                </div>
                <div class="input-div one">
                    <div class="i">
                        <i class="fa fa-comment"></i>
                    </div>
                    <div class="div">
                        <h5>Subject</h5>
                        <input type="text" class="input" id="sub" name="sub" autocomplete="off">
                    </div>
                </div>
                <br>
                <input type="submit" value="Submit" class="btn"><br>
            </form>
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
</script>
</body>

</html>