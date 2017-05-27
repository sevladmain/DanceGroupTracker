<%@include file="/WEB-INF/views/template/header.jsp" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<div class="row">
    <div class="col-md-6 col-md-offset-3">
        <spring:url value="/updatedetails" var="updateUrl"/>
        <spring:message code='UserDetails.FirstName.label' var="firstNameMessage"/>
        <spring:message code='UserDetails.LastName.label' var="lastNameMessage"/>
        <spring:message code='UserDetails.DateOfBirth.label' var="dateOfBirthMessage"/>
        <spring:message code='UserDetails.ChangeButton.label' var="changeButtonMessage"/>
        <c:if test="${not empty msg}">
            <div class="alert alert-success" role="alert">${msg}</div>
        </c:if>
        <c:if test="${not empty error}">
            <div class="alert alert-danger" role="alert">${error}</div>
        </c:if>
        <form:form id="userdetails-from" action="${updateUrl}" modelAttribute="userdetails" method="post">
            <form:input type="hidden" path="username" id="username" tabindex="1"
                        class="form-control" value="${userdetails.username}"/><br/>
            <div class="form-group">
                <form:input type="text" path="firstName" id="firstName" tabindex="1"
                            class="form-control" placeholder="${firstNameMessage}" value=""/><br/>
                <div class="alert-danger">
                    <form:errors path="firstName"></form:errors>
                </div>
            </div>
            <div class="form-group">
                <form:input type="text" path="lastName" id="lastName" tabindex="2"
                            class="form-control" placeholder="${lastNameMessage}" value=""/><br/>
                <div class="alert-danger">
                    <form:errors path="lastName"></form:errors>
                </div>
            </div>
            <div class="form-group">
                <form:input type="date" path="dateOfBirth" id="dateOfBirth" tabindex="3"
                            class="form-control" placeholder="${dateOfBirthMessage}" value=""/><br/>
                <div class="alert-danger">
                    <form:errors path="dateOfBirth"></form:errors>
                </div>
            </div>
            <div class="form-group">
                <div class="row">
                    <div class="col-sm-6 col-sm-offset-3">
                        <input type="submit" name="submit-userdetails" id="submit-userdetails"
                               tabindex="4" class="form-control btn btn-register"
                               value="${changeButtonMessage}"/>
                    </div>
                </div>
            </div>
        </form:form>
    </div>
</div>
<%@include file="/WEB-INF/views/template/footer.jsp" %>