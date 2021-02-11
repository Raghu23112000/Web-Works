<html>
<%@include file="maincss.jsp"%>
<head>
    <title>Rewinding Works</title>
    <link href="https://fonts.googleapis.com/css?family=Poppins:600&display=swap" rel="stylesheet">
    <script src="https://kit.fontawesome.com/a81368914c.js"></script>
    <script src="https://code.jquery.com/jquery-1.10.2.js"></script>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="CSS/navigation.css">
    <link rel="stylesheet" href="CSS/navigation.css">
</head>


<body style="background: linear-gradient(to left, #ad5389, #3c1053);">
<div class="navbar" id="navbar">
    <img src="" class="logo" alt="">
    <ul>
        <li><a href="index.jsp" style="color: white">Home</a></li>
        <li><a href="aboutus.jsp" style="color: white">About Us</a></li>
        <li><a href="contactus.jsp" style="color: white">Contact</a></li>
        <li><a href="login.jsp" style="color: white">Login</a></li>
        <li><a href="registration.jsp" style="color: white">Sign Up</a></li>
    </ul>
</div>
</body>
<script>
    var prevScrollpos = window.pageYOffset;
    window.onscroll = function() {
        var currentScrollPos = window.pageYOffset;
        if (prevScrollpos > currentScrollPos) {
            document.getElementById("navbar").style.top = "0";
        } else {
            document.getElementById("navbar").style.top = "-50px";
        }
        prevScrollpos = currentScrollPos;
    }
</script>
</html>
