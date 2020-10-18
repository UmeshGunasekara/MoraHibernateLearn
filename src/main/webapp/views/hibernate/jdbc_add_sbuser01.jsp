<%@ page import="java.util.Date" %>
<%@ page import="com.slmora.learn.model.User" %>
<%@ page import="com.slmora.learn.service.jdbc.SBUser01Service01" %>
<%@ page import="com.slmora.learn.service.jdbc.impl.SBUser01Service01Impl" %>
<%@ page import="com.slmora.learn.entity.jdbc.SBUser01" %>
<%@ page import="java.util.UUID" %>
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
        <%!
            SBUser01Service01 sbUser01Service01 =  new SBUser01Service01Impl();
        %>
        <%
            String sbUserId = (String) request.getAttribute("sbUserId");
            if(sbUserId!=null){
        %>
        <div class="alert alert-success alert-dismissible fade show" role="alert">
            <h4 class="alert-heading">Well done!</h4>
            <strong>Thank You! <%=sbUserId%> </strong> You Successfully Added.
            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                <span aria-hidden="true">&times;</span>
            </button>
            <hr>
            <p class="mb-0">Whenever you need to, be sure to use margin utilities to keep things nice and tidy.</p>
        </div>
        <%
            }

            SBUser01 sbUser01 = sbUser01Service01.getSBUser01ById(UUID.fromString(sbUserId));

        %>

        <h1>SB User 01 Add Dashboard</h1>
        <h2>The time is : <%=new Date()%></h2>
        <h3> User <%=sbUser01.getUser01FullName()%> Successfully Added Under <%=sbUser01.getUser01Id().toString()%></h3>
        <h3> Hello! <%=sbUser01.getUser01FullName()%> Your Details Bellow</h3>
        <h2> User ID    : <%=sbUser01.getUser01Id().toString()%></h2>
        <h2> First Name : <%=sbUser01.getUser01FirstName()%></h2>
        <h2> Last Name  : <%=sbUser01.getUser01LastName()%></h2>
        <h2> Full Name  : <%=sbUser01.getUser01FullName()%></h2>
        <h2> User Name  : <%=sbUser01.getUser01UserName()%></h2>
        <h2> Email      : <%=sbUser01.getUser01Email()%></h2>
        <h2> Address    : <%=sbUser01.getUser01Address()%></h2>
        <h2> Country    : <%=sbUser01.getUser01Country()%></h2>
        <h2> State      : <%=sbUser01.getUser01State()%></h2>
        <h2> Last Update Date And Time  : <%=sbUser01.getRawLastUpdateDateTime()%></h2>
        <h2> Last Update Log Id         : <%=sbUser01.getRawLastUpdateLogId()%></h2>
        <h2> Update User Account Id     : <%=sbUser01.getUpdateUserAccountId()%></h2>
        <h2> Show Status                : <%=sbUser01.getRawShowStatus()%></h2>
        <h2> Update Status              : <%=sbUser01.getRawUpdateStatus()%></h2>
        <h2> Delete Status              : <%=sbUser01.getRawDeleteStatus()%></h2>
        <h2> Active Status              : <%=sbUser01.getRawActiveStatus()%></h2>
        <h2> Extra 01                   : <%=sbUser01.getExtra01()%></h2>
        <h2> Extra 02                   : <%=sbUser01.getExtra02()%></h2>
        <h2> Extra 03                   : <%=sbUser01.getExtra03()%></h2>
    </div>
    <!-- ================================================== -->

    <!-- FOOTER -->
    <%@include file="../common/footer.jsp" %>

</main>
<%@include file="../common/script_inc.jsp" %>
</body>
</html>
