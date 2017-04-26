<%@include file="/WEB-INF/views/template/header.jsp" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<div class="container">
    <%--TODO: Add localities--%>
    <spring:url value="/updatedetails" var="updateUrl"/>
    <c:if test="${not empty msg}">
        <div class="alert alert-success" role="alert">${msg}</div>
    </c:if>
    <c:if test="${not empty error}">
        <div class="alert alert-danger" role="alert">${error}</div>
    </c:if>
    <form:form id="userdetails-from" action="${updateUrl}" modelAttribute="userdetails" method="post">
        <div class="form-group">
            <form:input type="text" path="firstName" id="firstName" tabindex="1"
                        class="form-control" placeholder="First Name" value=""/><br/>
            <div class="alert-danger">
                <form:errors path="firstName"></form:errors>
            </div>
        </div>
        <div class="form-group">
            <form:input type="text" path="lastName" id="lastName" tabindex="2"
                        class="form-control" placeholder="Last Name" value=""/><br/>
            <div class="alert-danger">
                <form:errors path="lastName"></form:errors>
            </div>
        </div>
        <div class="form-group">
            <form:input type="date" path="dateOfBirth" id="dateOfBirth" tabindex="3"
                        class="form-control" placeholder="Date of Birth" value=""/><br/>
        </div>
        <div class="form-group">
            <div class="row">
                <div class="col-sm-6 col-sm-offset-3">
                    <input type="submit" name="submit-userdetails" id="submit-userdetails"
                           tabindex="4" class="form-control btn btn-register"
                           value="Change"/>
                </div>
            </div>
        </div>
    </form:form>
</div>
<%@include file="/WEB-INF/views/template/footer.jsp" %>