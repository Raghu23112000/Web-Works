<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>

<head>
    <title></title>
</head>
<style>
    *{
        margin: 0;
        padding: 0;
        box-sizing: border-box;
    }
    body{
        min-height: 100vh;
        display: flex;
        align-items: center;
        justify-content: center;
        background-color: #f1f1f1;
    }
    .about{
        background: url(image1.jpg) no-repeat left;
        background-size: 55%;
        height: 1010px;
        overflow: hidden;
        padding: 100px 0;
    }
    .inner-section{
        width: 55%;
        margin: auto;
        background-color: #fdfdfd;
        padding: 140px;
        box-shadow: 10px 10px 8px rgba(0,0,0,0.3);
    }
    .inner-section h1{
        margin-bottom: 30px;
        font-size: 30px;
        font-weight: 900;
    }
    .text{
        font-size: 20px;
        color: #545454;
        line-height: 30px;
        text-align: justify;
        margin-bottom: 40px;
    }
    .skills button{
        font-size: 22px;
        text-align: center;
        letter-spacing: 2px;
        border: none;
        border-radius: 20px;
        padding: 8px;
        width: 200px;
        background-color: #00999c;
        color: white;
        cursor: pointer;
    }
    .skills button:hover{
        transition: 1s;
        background-color: #ecf5f5;
        color: #00999c;
    }
    @media screen and (max-width:1200px){
        .inner-section{
            padding: 80px;
        }
    }
    @media screen and (max-width:1000px){
        .about{
            background-size: 100%;
            padding: 100px 40px;
        }
        .inner-section{
            width: 100%;
        }
    }

    @media screen and (max-width:600px){
        .about{
            padding: 0;
        }
        .inner-section{
            padding: 60px;
        }
        .skills button{
            font-size: 19px;
            padding: 5px;
            width: 160px;
        }
    }
</style>
<body style="background: #E6E6E6;">
<div class="banner">
<%@include file="navigation.jsp"%>
    <div class="about" style="background: #E6E6E6;">
        <div class="inner-section">
            <h1>About Us</h1>
            <h2 class="text">
                WebWorks Pvt Ltd. is a renowned Indian multi-national corporation providing software solutions to clients world-wide, head-quartered at Coimbatore. We have been partnering with 50+ companies to provide solutions as well as we have our own catalogue of products launched in market. Apart from these we study problems faced by common people and try to incorporate and work on solutions that would help them thrive. We keep striving our way to build a better future.
            </h2>
            <div class="skills">
                <button class="btn" onclick="location.href='contactus.jsp'" style="display: block;
                        width: 30%;
                        height: 40px;
                        border-radius: 25px;
                        outline: none;
                        border: none;
                        background-image: linear-gradient(to right, #532E1C, #493323, #5e422d);
                        background-size: 200%;
                        font-size: 1.2rem;
                        color: #fff;
                        text-transform: uppercase;
                        margin-left: 0px;
                        margin-top:12px;
                        cursor: pointer;
                        transition: 0.5s;
                        font-family: "Poppins", sans-serif;">Contact Us</button>
            </div>
        </div>
    </div>
</div>
</body>
</html>