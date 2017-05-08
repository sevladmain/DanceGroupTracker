<%@include file="/WEB-INF/views/template/header.jsp" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<div class="row">
    <div class="col-md-6 col-md-offset-3">
        <spring:url value="/admin/newgroup" var="newGroupUrl"/>
        <spring:message code='Group.name.label' var="groupName"/>
        <spring:message code='Group.description.label' var="groupDescription"/>
        <spring:message code='Group.SaveButton.label' var="saveButtonMessage"/>
        <c:if test="${not empty msg}">
            <div class="alert alert-success" role="alert">${msg}</div>
        </c:if>
        <c:if test="${not empty error}">
            <div class="alert alert-danger" role="alert">${error}</div>
        </c:if>
        <form:form id="newgroup-from" action="${newGroupUrl}" modelAttribute="newGroup" method="post">
            <div class="form-group">
                <form:input type="text" path="name" id="name" tabindex="1"
                            class="form-control" placeholder="${groupName}" value=""/><br/>
                <div class="alert-danger">
                    <form:errors path="name"></form:errors>
                </div>
            </div>
            <div class="form-group">
                <form:input type="text" path="description" id="description" tabindex="2"
                            class="form-control" placeholder="${groupDescription}" value=""/><br/>
                <div class="alert-danger">
                    <form:errors path="description"></form:errors>
                </div>
            </div>
            <div class="form-group">
                <div class="row">
                    <div class="col-sm-6 col-sm-offset-3">
                        <input type="submit" name="submit-userdetails" id="submit-userdetails"
                               tabindex="4" class="form-control btn btn-register"
                               value="${saveButtonMessage}"/>
                    </div>
                </div>
            </div>
        </form:form>
    </div>
</div>
<%@include file="/WEB-INF/views/template/footer.jsp" %>
