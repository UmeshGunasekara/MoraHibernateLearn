<%--
* This index.jsp created for MoraServletJSPLearn020 Project
*
* @Author: SLMORA
* @DateTime: 8/1/2020 11:51 AM
* <p>
* Version       Date            Editor              Note
* =====================================================================================================================
* 1.0           8/1/2020       	SLMORA              Initial Code
* 2.0           8/9/2020        SLMORA              Added contect path and Bootstrap components
* 2.1           8/9/2020        SLMORA              remove the bootstrap example sections
* 2.2           8/9/2020        SLMORA              Add POST call for /servletlearn05
* 2.3           8/9/2020        SLMORA              Added POST call for /servletlearn06
* 2.4           8/16/2020       SLMORA              Added POST call for /servletlearn07
* 2.5           8/16/2020       SLMORA              Added POST call for /servletlearn08
* 2.6           8/16/2020       SLMORA              Added POST call for /servletlearn09
* 2.7           9/3/2020        SLMORA              Added POST call for /servletlearn10
* 2.8           9/3/2020        SLMORA              Added POST call for /servletlearn11
* 2.9           9/4/2020        SLMORA              Added POST call for /servletlearn12
* 2.10          9/5/2020        SLMORA              Added POST call for /servletlearn13
* 2.11          9/5/2020        SLMORA              Added POST call for /servletlearn14
* 2.12          9/5/2020        SLMORA              Added POST call for /servletlearn15
* 2.13          9/5/2020        SLMORA              Added POST call for /servletlearn16
* 2.14          9/5/2020        SLMORA              Added POST call for /servletlearn17
* 2.15          9/5/2020        SLMORA              Added POST call for /servletlearn18
* 2.16          9/6/2020        SLMORA              Added POST call for /servletlearn19
* 2.17          9/11/2020        SLMORA              Added POST call for /servletlearn20
* 2.18          9/12/2020        SLMORA              Added POST call for /servletlearn21
*
--%>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!doctype html>
<html lang="en">
    <head>
        <c:set var="context" value="${pageContext.request.contextPath}"/>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="${context}/resources/bootstrap/4.5.2/css/bootstrap.css">
        <style>
            .bd-placeholder-img {
                font-size: 1.125rem;
                text-anchor: middle;
                -webkit-user-select: none;
                -moz-user-select: none;
                -ms-user-select: none;
                user-select: none;
            }

            @media (min-width: 768px) {
                .bd-placeholder-img-lg {
                    font-size: 3.5rem;
                }
            }
        </style>
        <link rel="stylesheet" href="${context}/resources/css/offcanvas.css">

        <title>Mora Servlet JSP Learn 004</title>
    </head>
    <body>
        <main role="main" class="container">
            <div class="d-flex align-items-center p-3 my-3 text-white-50 bg-purple rounded shadow-sm">
                <img class="mr-3" src="${context}/resources/image/ClipartKey.png" alt="" width="38" height="60">
                <div class="lh-100">
                    <h6 class="mb-0 text-white lh-100">Mora Application</h6>
                    <small>Since 2020</small>
                </div>
            </div>
            <div class="my-3 p-3 bg-white rounded shadow-sm">
                <h6 class="border-bottom border-gray pb-2 mb-0">Recent updates</h6>
                <div class="media text-muted pt-3">
                    <svg class="bd-placeholder-img mr-2 rounded" width="32" height="32" xmlns="http://www.w3.org/2000/svg" preserveAspectRatio="xMidYMid slice" focusable="false" role="img" aria-label="Placeholder: 32x32"><title>/ServletJSPHome</title><rect width="100%" height="100%" fill="#007bff"/><text x="50%" y="50%" fill="#007bff" dy=".3em">32x32</text></svg>
                    <p class="media-body pb-3 mb-0 small lh-125 border-bottom border-gray">
                        <strong class="d-block text-gray-dark"><a href="${context}/views/servlet_jsp_home.jsp">/servlet_jsp_home.jsp</a></strong>
                        Servlet JSP Home.
                    </p>
                </div>
                <div class="media text-muted pt-3">
                    <svg class="bd-placeholder-img mr-2 rounded" width="32" height="32" xmlns="http://www.w3.org/2000/svg" preserveAspectRatio="xMidYMid slice" focusable="false" role="img" aria-label="Placeholder: 32x32"><title>/HibernateHome</title><rect width="100%" height="100%" fill="#6f42c1"/><text x="50%" y="50%" fill="#6f42c1" dy=".3em">32x32</text></svg>
                    <p class="media-body pb-3 mb-0 small lh-125 border-bottom border-gray">
                        <strong class="d-block text-gray-dark"><a href="${context}/views/hibernate_home.jsp">/hibernate_home</a></strong>
                        Hibernate Home.
                    </p>
                </div>
<%--                <div class="media text-muted pt-3">--%>
<%--                    <svg class="bd-placeholder-img mr-2 rounded" width="32" height="32" xmlns="http://www.w3.org/2000/svg" preserveAspectRatio="xMidYMid slice" focusable="false" role="img" aria-label="Placeholder: 32x32"><title>/servletlearn02</title><rect width="100%" height="100%" fill="#e83e8c"/><text x="50%" y="50%" fill="#e83e8c" dy=".3em">32x32</text></svg>--%>
<%--                    <p class="media-body pb-3 mb-0 small lh-125 border-bottom border-gray">--%>
<%--                        <strong class="d-block text-gray-dark"><a href="${context}/servletlearn02">/servletlearn02</a></strong>--%>
<%--                        Annotation base servlet with path /servletlearn02.--%>
<%--                    </p>--%>
<%--                </div>--%>
<%--                <div class="media text-muted pt-3">--%>
<%--                    <svg class="bd-placeholder-img mr-2 rounded" width="32" height="32" xmlns="http://www.w3.org/2000/svg" preserveAspectRatio="xMidYMid slice" focusable="false" role="img" aria-label="Placeholder: 32x32"><title>/servletlearn01</title><rect width="100%" height="100%" fill="#007bff"/><text x="50%" y="50%" fill="#007bff" dy=".3em">32x32</text></svg>--%>
<%--                    <p class="media-body pb-3 mb-0 small lh-125 border-bottom border-gray">--%>
<%--                        <strong class="d-block text-gray-dark"><a href="${context}/servletlearn01">/servletlearn01</a></strong>--%>
<%--                        Annotation base servlet with path /servletlearn01.--%>
<%--                    </p>--%>
<%--                </div>--%>
                <small class="d-block text-right mt-3">
                    <a href="#">All updates</a>
                </small>
            </div>
        </main>

        <!-- Optional JavaScript -->
        <!-- jQuery first, then Popper.js, then Bootstrap JS -->
        <script src="${context}/resources/jquery/3.5.1/jquery-3.5.1.slim.min.js"></script>
        <script src="${context}/resources/popper/1.16.1/umd/popper.min.js"></script>
        <script src="${context}/resources/bootstrap/4.5.2/js/bootstrap.min.js"></script>
        <script src="${context}/resources/js/offcanvas.js"></script>
    </body>
</html>
