<%@ page import="org.apache.logging.log4j.Logger" %>
<%@ page import="org.apache.logging.log4j.LogManager" %>
<%--
* This index.jsp created for MoraServletJSPLearn012 Project
*
* @Author: SLMORA
* @DateTime: 9/3/2020 10:09 PM
* <p>
* Version       Date            Editor              Note
* =====================================================================================================================
* 1.0           9/3/2020       	SLMORA              Initial Code
* 1.1           9/4/2020       	SLMORA              Seperated header, footer, links and script and used include directive to combine
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
        <title>Hello JSP</title>

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
                <h1>Hello JSP</h1>
                <p>declare a java method getSum and LOGGER object inside declarative tag</p>
                <%!
                    static final Logger LOGGER = LogManager.getLogger("hello.jsp");
//                    int a = 20;//Only one declaration tag use same variable name
                    private int getSum(int val1, int val2){
                        return  val1+val2;
                    }
                %>
                <p>do calculation java code using scriptlet tag</p>
                <%
                    LOGGER.info("Test doPost Method in hello.jsp");
                    int a = 10;
                    int b = 25;
                %>
                <p>all scriptlet tags will be generate as one method body</p>
                <%
                    int sum = getSum(a,b);
                    LOGGER.info("Test getSum method execution 10 + 25 = "+sum);
                    System.out.println("Console Log - Test getSum method execution 10 + 25 = "+sum);

                    out.println("print Using JSPWriter - Test getSum method execution 10 + 25 = "+sum);
                %>
                <p>using Expresion tag - Test getSum method execution 10 + 25 = <%=sum %></p>
                <%
                    for(int i=0; i<sum; i=i+5){
                %>
                <p>using Expresion tag - Print loop i = <%=i %></p>
                <%
                        System.out.println("Console Log - print loop i = "+i);
                    }
                %>
                <%!
                    int a = 20;
                    private int getSub(int val1, int val2){
                        return  val1-val2;
                    }
                %>

            </div>
            <!-- ================================================== -->

            <!-- FOOTER -->
            <%@include file="../common/footer.jsp" %>

        </main>
        <%@include file="../common/script_inc.jsp" %>
    </body>
</html>
