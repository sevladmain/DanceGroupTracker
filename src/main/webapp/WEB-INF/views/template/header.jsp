<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Dance Group Tracker</title>
    <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/css/login-form.css" />" rel="stylesheet">
    <script>
        function formSubmit() {
            document.getElementById("logoutForm").submit();
        }
    </script>
</head>
<body>
<nav class="navbar navbar-default">
    <div class="container-fluid">
        <div class="collapse navbar-collapse">
            <ul class="nav navbar-nav navbar-left">
                <sec:authorize access="isAuthenticated()">
                    <li>
                        <a href="<c:url value='/userdetails' />"><sec:authentication property="principal.username"/></a>
                    </li>
                </sec:authorize>
                <li>
                    <sec:authorize access="!isAuthenticated()">
                        <a href="<c:url value='/login'/>">
                            <spring:message code="login.login.label"/>
                        </a>
                    </sec:authorize>
                    <sec:authorize access="isAuthenticated()">
                        <c:url value='/j_spring_security_logout' var="logoutUrl"/>
                        <a href="javascript:formSubmit()"> <spring:message code="login.logout.label"/></a>
                        <form action="${logoutUrl}" id="logoutForm" method="post">
                            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                        </form>
                    </sec:authorize>
                </li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="?locale=ua">UA</a></li>
                <li><a href="?locale=en">EN</a></li>
            </ul>
        </div>
    </div>
</nav>
