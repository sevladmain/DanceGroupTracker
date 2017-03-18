<%@include file="/WEB-INF/views/template/header.jsp" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<spring:url value="/j_spring_security_check" var="loginURL"/>
<spring:url value="/register" var="registerURL"/>
<spring:url value="/recover" var="recoverPassURL"/>
<div class="container">
    <div class="row">
        <div class="col-md-6 col-md-offset-3">
            <div class="panel panel-login">
                <c:choose>
                    <c:when test="${not isRegister}">
                        <c:set var="displayLogin" value="display: block;"/>
                        <c:set var="displayRegister" value="display: none;"/>
                    </c:when>
                    <c:otherwise>
                        <c:set var="displayRegister" value="display: block;"/>
                        <c:set var="displayLogin" value="display: none;"/>
                    </c:otherwise>
                </c:choose>
                <c:if test="${not empty msg}">
                    <div class="alert alert-success" role="alert">${msg}</div>
                </c:if>
                <c:if test="${not empty error}">
                    <div class="alert alert-danger" role="alert">${error}</div>
                </c:if>
                <div class="panel-heading">
                    <div class="row">
                        <div class="col-xs-6">
                            <a href="#" class="active" id="login-form-link"><spring:message
                                    code="login.login.label"/></a>
                        </div>
                        <div class="col-xs-6">
                            <a href="#" id="register-form-link"><spring:message code="login.register.label"/></a>
                        </div>
                    </div>
                    <hr>
                </div>
                <div class="panel-body">
                    <div class="row">
                        <div class="col-lg-12">
                            <form id="login-form" action="${loginURL}" method="post" role="form"
                                    style="${displayLogin}">
                                <div class="form-group">
                                    <input type="text" name="username" id="username" tabindex="1" class="form-control"
                                           placeholder="Username" value="">
                                </div>
                                <div class="form-group">
                                    <input type="password" name="password" id="password" tabindex="2"
                                           class="form-control" placeholder="Password">
                                </div>
                                <div class="form-group text-center">
                                    <input type="checkbox" tabindex="3" class="" name='_spring_security_remember_me'
                                           id="remember">
                                    <label for="remember"><spring:message code="login.RememberMe.label"/></label>
                                </div>
                                <div class="form-group">
                                    <div class="row">
                                        <div class="col-sm-6 col-sm-offset-3">
                                            <input type="submit" name="login-submit" id="login-submit" tabindex="4"
                                                   class="form-control btn btn-login"
                                                   value="<spring:message code='login.login.label'/>"/>
                                        </div>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="row">
                                        <div class="col-lg-12">
                                            <div class="text-center">
                                                <a href="${recoverPassURL}" tabindex="5"
                                                   class="forgot-password"><spring:message
                                                        code="login.ForgotPassword.label"/></a>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                            </form>
                            <form:form id="register-form" action="${registerURL}" modelAttribute="user"
                                       method="post" role="form"  style="${displayRegister}">
                            <div class="form-group">
                                <form:input type="text" path="username" id="username" tabindex="1"
                                            class="form-control" placeholder="Username" value=""/><br/>
                                <div class="alert-danger">
                                    <form:errors path="username"></form:errors>
                                </div>
                            </div>
                            <div class="form-group">
                                <form:input type="email" path="email" id="email" tabindex="1" class="form-control"
                                            placeholder="Email Address" value=""/>
                                <div class="alert-danger">
                                    <form:errors path="email"></form:errors>
                                </div>
                            </div>
                            <div class="form-group">
                                <form:input type="password" path="password" id="password" tabindex="2"
                                            class="form-control" placeholder="Password"/>
                                <div class="alert-danger">
                                    <form:errors path="password"></form:errors>
                                </div>
                            </div>
                            <div class="form-group">
                                <input type="password" name="confirm-password" id="confirm-password" tabindex="2"
                                       class="form-control" placeholder="Confirm Password"/>
                            </div>
                            <div class="form-group">
                                <div class="row">
                                    <div class="col-sm-6 col-sm-offset-3">
                                        <input type="submit" name="register-submit" id="register-submit"
                                               tabindex="4" class="form-control btn btn-register"
                                               value="Register Now"/>
                                    </div>
                                </div>
                            </div>
                            </form:form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<%@include file="/WEB-INF/views/template/footer.jsp" %>