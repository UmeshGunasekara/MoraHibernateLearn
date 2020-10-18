<%@ page import="java.util.Date" %>
<%@ page import="com.slmora.learn.model.User" %>
<%--
* This index.jsp created for MoraServletJSPLearn020 Project
*
* @Author: SLMORA
* @DateTime: 9/11/2020 10:30 PM
* <p>
* Version       Date            Editor              Note
* =====================================================================================================================
* 1.0           9/11/2020       	SLMORA              Initial Code
*
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!doctype html>
<html lang="en">
<head>
    <c:set var="context" value="${pageContext.request.contextPath}"/>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Jekyll v4.1.1">
    <title>Sign Up Dashboard</title>

    <%@include file="../common/link_inc.jsp" %>

</head>
<body>

<%@include file="../common/header.jsp" %>

<main role="main">

    <div id="myCarousel" class="carousel slide" data-ride="carousel">
        <ol class="carousel-indicators">
            <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
            <li data-target="#myCarousel" data-slide-to="1"></li>
            <li data-target="#myCarousel" data-slide-to="2"></li>
        </ol>
        <div class="carousel-inner">
            <div class="carousel-item active">
                <svg class="bd-placeholder-img" width="100%" height="100%" xmlns="http://www.w3.org/2000/svg" preserveAspectRatio="xMidYMid slice" focusable="false" role="img"><rect width="100%" height="100%" fill="#777"/></svg>
                <div class="container">
                    <div class="carousel-caption text-left">
                        <h1>Example headline.</h1>
                        <p>Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.</p>
                        <p><a class="btn btn-lg btn-primary" href="#" role="button">Sign up today</a></p>
                    </div>
                </div>
            </div>
            <div class="carousel-item">
                <svg class="bd-placeholder-img" width="100%" height="100%" xmlns="http://www.w3.org/2000/svg" preserveAspectRatio="xMidYMid slice" focusable="false" role="img"><rect width="100%" height="100%" fill="#777"/></svg>
                <div class="container">
                    <div class="carousel-caption">
                        <h1>Another example headline.</h1>
                        <p>Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.</p>
                        <p><a class="btn btn-lg btn-primary" href="#" role="button">Learn more</a></p>
                    </div>
                </div>
            </div>
            <div class="carousel-item">
                <svg class="bd-placeholder-img" width="100%" height="100%" xmlns="http://www.w3.org/2000/svg" preserveAspectRatio="xMidYMid slice" focusable="false" role="img"><rect width="100%" height="100%" fill="#777"/></svg>
                <div class="container">
                    <div class="carousel-caption text-right">
                        <h1>One more for good measure.</h1>
                        <p>Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.</p>
                        <p><a class="btn btn-lg btn-primary" href="#" role="button">Browse gallery</a></p>
                    </div>
                </div>
            </div>
        </div>
        <a class="carousel-control-prev" href="#myCarousel" role="button" data-slide="prev">
            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
            <span class="sr-only">Previous</span>
        </a>
        <a class="carousel-control-next" href="#myCarousel" role="button" data-slide="next">
            <span class="carousel-control-next-icon" aria-hidden="true"></span>
            <span class="sr-only">Next</span>
        </a>
    </div>

    <!-- ================== SLMORA CHANGES ================================ -->
    <div class="container marketing">
        <jsp:useBean id="user" class="com.slmora.learn.model.User2" scope="request">
<%--            <jsp:setProperty name="user" property="firstName" param="firstName"></jsp:setProperty>--%>
<%--            <jsp:setProperty name="user" property="firstName"></jsp:setProperty>--%>
            <jsp:setProperty name="user" property="*"></jsp:setProperty>
        </jsp:useBean>

        <h1>Sign Up Dashboard</h1>
        <h2>The time is : <%=new Date()%></h2>
        <h3> User <%=user.getFirstName()%> <%=user.getLastName()%> Successfully Sign Up</h3>
        <h3> Hello! <jsp:getProperty name="user" property="firstName"/> <jsp:getProperty name="user" property="lastName"/> Your Details Bellow</h3>
        <h2> First Name : <jsp:getProperty name="user" property="firstName"/></h2>
        <h2> Last Name  : <jsp:getProperty name="user" property="lastName"/></h2>
        <h2> User Name  : <jsp:getProperty name="user" property="userName"/></h2>
        <h2> Password   : <jsp:getProperty name="user" property="password"/></h2>
        <h2> Email      : <jsp:getProperty name="user" property="email"/></h2>
        <h2> Address    : <jsp:getProperty name="user" property="address"/></h2>
        <h2> Country       : <jsp:getProperty name="user" property="country"/></h2>
        <h2> State      : <jsp:getProperty name="user" property="state"/></h2>
        <h2> Zip : <jsp:getProperty name="user" property="zip"/></h2>
        <h2> Billing Address is same : <jsp:getProperty name="user" property="sameAddress"/></h2>
        <h2> Can we save information : <jsp:getProperty name="user" property="saveInfo"/></h2>
        <h2> Payment Method : <jsp:getProperty name="user" property="paymentMethod"/></h2>
        <h2> Name on Card : <jsp:getProperty name="user" property="ccname"/></h2>
        <h2> Card Number : <jsp:getProperty name="user" property="ccnumber"/></h2>
        <h2> Expire Date : <jsp:getProperty name="user" property="ccexpiration"/></h2>
        <h2> CVV : <jsp:getProperty name="user" property="cccvv"/></h2>
    </div>
    <!-- ================================================== -->

    <!-- FOOTER -->
    <%@include file="../common/footer.jsp" %>

</main>
<%@include file="../common/script_inc.jsp" %>
</body>
</html>
