<%--
* This index.jsp created for MoraServletJSPLearn012 Project
*
* @Author: SLMORA
* @DateTime: 9/5/2020 01:45 AM
* <p>
* Version       Date            Editor              Note
* =====================================================================================================================
* 1.0           9/5/2020       	SLMORA              Initial Code
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
    <title>Scope JSP</title>

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
        <h1>Scope JSP</h1>
        <hr>
        <%
            String firstName=request.getParameter("firstName");
            String lastName=request.getParameter("lastName");
            String userName=request.getParameter("username");

            if (!"".equals(userName) && null != userName){
                session.setAttribute("sessionUsername",userName);
                application.setAttribute("contextUsername",userName);
                pageContext.setAttribute("defaultPageContextUsername",userName);
                pageContext.setAttribute("requestPageContextUsername",userName,PageContext.REQUEST_SCOPE);
                pageContext.setAttribute("sessionPageContextUsername",userName,PageContext.SESSION_SCOPE);
                pageContext.setAttribute("applicationPageContextUsername",userName,PageContext.APPLICATION_SCOPE);
                pageContext.setAttribute("pagePageContextUsername",userName,PageContext.PAGE_SCOPE);
            }
        %>
        <h3> First Name : <%=firstName%></h3>
        <h3> Last Name : <%=lastName%></h3>
        <h3> User Name : <%=userName%></h3>
        <h3> Session User Name : <%=session.getAttribute("sessionUsername")%></h3>
        <h3> Context User Name : <%=application.getAttribute("contextUsername")%></h3>
        <h3> Default Page Context User Name : <%=pageContext.getAttribute("defaultPageContextUsername")%></h3>
        <h3> Request Page Context User Name : <%=pageContext.getAttribute("requestPageContextUsername",PageContext.REQUEST_SCOPE)%></h3>
        <h3> Session Page Context User Name : <%=pageContext.getAttribute("sessionPageContextUsername",PageContext.SESSION_SCOPE)%></h3>
        <h3> Application Page Context User Name : <%=pageContext.getAttribute("applicationPageContextUsername",PageContext.APPLICATION_SCOPE)%></h3>
        <h3> Page Page Context User Name : <%=pageContext.getAttribute("pagePageContextUsername",PageContext.PAGE_SCOPE)%></h3>
        <h2>Using findAttribute Option </h2>
        <h3> Find Default Page Context User Name : <%=pageContext.findAttribute("defaultPageContextUsername")%></h3>
        <h3> Find Request Page Context User Name : <%=pageContext.findAttribute("requestPageContextUsername")%></h3>
        <h3> Find Session Page Context User Name : <%=pageContext.findAttribute("sessionPageContextUsername")%></h3>
        <h3> Find Application Page Context User Name : <%=pageContext.findAttribute("applicationPageContextUsername")%></h3>
        <h3> Find Page Page Context User Name : <%=pageContext.findAttribute("pagePageContextUsername")%></h3>

    </div>
    <!-- ================================================== -->

    <!-- FOOTER -->
    <%@include file="../common/footer.jsp" %>

</main>
<%@include file="../common/script_inc.jsp" %>
</body>
</html>
