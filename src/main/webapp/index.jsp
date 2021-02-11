<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <title>Rewinding Works</title>
</head>
<style>
    * {
        padding: 0;
        margin: 0;
        font-family: sans-serif;
    }
    .banner {
        width: 100%;
        height: 100vh;
        background-image: url("Images/Home.jpg");
    }
    .banner {
        width: 100%;
        position: absolute;
        top: 50%;
        margin: auto;
        transform: translateY(-50%);
        text-align: center;
        color: rgb(8, 0, 0);
    }
    .banner h1 {
        font-size: 70px;
        margin-top: 0px;
        color: white;
    }
    .content p {
        margin: 20px auto;
        font-weight: 100;
        line-height: 25px;
    }
    .jumbotron{
        text-align: center;
        background: #E6E6E6;
    }
    .jumbotron p {
        font-weight: 100;
        line-height: 25px;
    }
    button {
        width: 200px;
        padding: 15px 0;
        text-align: center;
        margin: 20px 10px;
        border-radius: 25px;
        font-weight: bold;
        border: 2px solid #000000;
        background: transparent;
        color: white;
        cursor: pointer;
        position: relative;
        overflow: hidden;
    }
    span {
        background: #532E1C;
        height: 100%;
        width: 0;
        border-radius: 25px;
        position: absolute;
        left: 0;
        bottom: 0;
        z-index: -1;
        transition: 0.5s;
    }
    button:hover span {
        width: 100%;
    }
    button:hover {
        border: none;
    }

    section {
        height: 100vh;
        width: 100%;
        display: table;

    }
    section.ok{
        background-color: #555;
    }

    .jumbotron p{
        color: black;
        display: table-cell;
        text-align: center;
        vertical-align: middle;
    }

    .scroll-down {
        opacity: 1;
        -webkit-transition: all .5s ease-in 3s;
        transition: all .5s ease-in 3s;
    }

    .scroll-down {
        position: absolute;
        bottom: 30px;
        left: 50%;
        margin-left: -16px;
        display: block;
        width: 32px;
        height: 32px;
        border: 2px solid #FFF;
        background-size: 14px auto;
        border-radius: 50%;
        z-index: 2;
        -webkit-animation: bounce 2s infinite 2s;
        animation: bounce 2s infinite 2s;
        -webkit-transition: all .2s ease-in;
        transition: all .2s ease-in;
    }
    .jumbotron{
        background: #E6E6E6;
        height: 1080px;
    }
    .jumbotron h1{
        color: black;
        text-align: left;
    }
    .jumbotron p{
        color: white;
        text-align: justify;
    }

    .scroll-down:before {
        position: absolute;
        top: calc(50% - 8px);
        left: calc(50% - 6px);
        transform: rotate(-45deg);
        display: block;
        width: 12px;
        height: 12px;
        content: "";
        border: 2px solid white;
        border-width: 0px 0 2px 2px;
    }

    @keyframes bounce {
        0%,
        100%,
        20%,
        50%,
        80% {
            -webkit-transform: translateY(0);
            -ms-transform: translateY(0);
            transform: translateY(0);
        }
        40% {
            -webkit-transform: translateY(-10px);
            -ms-transform: translateY(-10px);
            transform: translateY(-10px);
        }
        60% {
            -webkit-transform: translateY(-5px);
            -ms-transform: translateY(-5px);
            transform: translateY(-5px);
        }
    }

</style>
<body style="background: #E6E6E6;">
<div class="banner">
    <%@include file="navigation.jsp"%>
    <%--        <button type="button" class="btn btn-primary" onclick="location.href='login.jsp'">Login</button>--%>
    <%--        <button type="button" class="btn btn-primary" onclick="location.href='registration.jsp'">Register</button>--%>
    <section style="text-align: left;justify-content: center;margin-top: 350px;">
        <h1 style="color: black;margin-left: 50px;">Ready to create</h1>
        <h1 style="color: black; margin-left: 50px;">Your own website?</h1>
        <button type="button" onclick="location.href='registration.jsp'" style="margin-left: 100px;"><span></span>Sign Up</button>
        <button type="button" onclick="location.href='#down'" class="scroll-down" address="true" style="background-color: black;"><span></span></button>
    </section>
    <section class="ok" style="text-align: left;justify-content: center;">
        <div class="jumbotron" style="margin: auto;">
            <h1 style="color: black;margin-left: 1000px;margin-top: 350px;">We bring good things to life <br/> Buy an activation key now and Sign up!</h1>
            <button type="button" onclick="location.href='activation.jsp'" style="margin-right: -800px; margin-top: -350px;background: #532E1C;"><span></span>Buy an Activation
                Key</button>
            <img src="Images/Create.png" alt="" style="margin-top: -450px; margin-right: 50px;">
        </div>
    </section>


    <%--    <div class="homecontent">--%>
    <%--        <h1>Why  and what's special here?</h1>--%>
    <%--        <h4>Existing system</h4>--%>
    <%--        <p>In today’s scenario, most of the contractors/entrepreneurs are maintaining the rewinding details in books, where data retrieval is exhausting. Also, many a times, these contractors/entrepreneurs lose track of the security deposits that would have matured long back. Employee salary and leave tracking is also quite tiresome in these small-scale workshops. All these pain-points consume huge amount of time/work when manually maintained</p>--%>
    <%--        <h4>Proposed system</h4>--%>
    <%--        <p>With the proposed solution, we have figured out ways to streamline the employee leave and salary tracking. The proposed project will be featured with a sign up and login form through which the Admin will have a special key for his/her company and the employee would be identified using unique IDs. The admin could control the employee details. Primarily all the worker's days of work are calculated before generating their monthly salary. Interface to check the date of security deposit(amount paid after acquiring a tender for guarantee) maturing. Thus this software solves critical problems faced and helps maintain a constructive workplace and saves a lot of time and resources.</p>--%>
    <%--        <h4>Main focus</h4>--%>
    <%--        <p>Small-scale industries around us don’t have a digitized way of handling their data and accounts even today. This would be a stand-alone easy to use software that could come in handy for such small shops</p>--%>
    <%--        <h1>Future Here</h1>--%>
    <%--        <p>Digitalization is the current need of the society. Be it a small shop near our house, or a huge factory running business, if the data is digitalized, not only will it ease the effort involved periodically, to keep track of work performed, and employee benefits, but also help in co-ordination and faster delivery of products.--%>
    <%--            When we take in account the numerous small-scale industries in India today, most of them operate with data in papers and books which becomes unreliable over time.--%>
    <%--            As an example, in workshops which deal with motor rewinding, repairing, for a given motor spec, retrieving the turns and wire-gauge requirement written earlier in paper, is a tedious process. Not only that, in case of tenders, the work requires the owner to pay a security deposit, which would be paid back after commissioning of the repaired motor (max a year). Keeping track of this amount is another hectic job and often results in the owner losing track of this amount. Apart from this the employees working in the workshop should be tracked of their salary and leave status.--%>
    <%--            Combining the above-mentioned problems, we are coming up with a user-friendly Windows application, which solves the problems and is useful in co-ordinating various activities for the Owner as well as the employee when it comes to Workshops dealing with large scales electric motors/transformers re-winding.--%>
    <%--        </p>--%>
    <%--    </div>--%>
    <%--    <!-- about us  -->--%>
    <%--    <div class="homecontent">--%>
    <%--        --%>
    <%--        <h4>About us</h4>--%>
    <%--        <p>Tech i4 Pvt Ltd. is a renowned Indian multi-national corporation providing software solutions to clients world-wide, head-quartered at Coimbatore. We have been partnering with 50+ companies to provide solutions as well as we have our own catalogue of products launched in market. Apart from these we study problems faced by common people and try to incorporate and work on solutions that would help them thrive. One such is the prototype in this project. We keep striving our way to build a better future.</p>--%>
    <%--        <h4>Contact</h4>--%>
    <%--        <p>Rahul Glenn R--%>
    <%--            Mobile : 8667619406<br>Sai Karthik--%>
    <%--            Mobile : 7010073121 <br>Raghunandhan Mobile : 8248591622 <br>Sabareesh Mobile : 6383372976--%>
    <%--        </p>--%>

    <%--    </div>--%>
</div>
<script>
    $(function() {
        $('.scroll-down').click (function() {
            $('html, body').animate({scrollTop: $('section.ok').offset().top }, 'slow');
            return false;
        });
    });
</script>
</body>
</html>