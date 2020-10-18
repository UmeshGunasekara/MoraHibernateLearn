<%--
* This index.jsp created for MoraServletJSPLearn012 Project
*
* @Author: SLMORA
* @DateTime: 9/4/2020 10:09 PM
* <p>
* Version       Date            Editor              Note
* =====================================================================================================================
* 1.0           9/4/2020       	SLMORA              Initial Code
*
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<c:set var="context" value="${pageContext.request.contextPath}"/>

<link rel="canonical" href="https://getbootstrap.com/docs/4.5/examples/carousel/">
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
<link href="${context}/resources/css/carousel.css" rel="stylesheet">
