<%@include file="/WEB-INF/views/template/header.jsp" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<spring:message code='admin.allGroup.label' var="allGroupsLabel"/>
<spring:message code='Group.name.label' var="groupNameLabel"/>
<spring:message code='Group.description.label' var="groupDescriptionLabel"/>
<spring:message code='Tables.operation.Label' var="operationLabel"/>
<spring:message code='Tables.Delete.Label' var="DeleteLabel"/>
<spring:message code='Tables.Update.Label' var="UpdateLabel"/>
<div class="row">
    <div class="col-md-6 col-md-offset-3">
        <div class="panel panel-default">
            <c:if test="${not empty msg}">
                <div class="alert alert-success" role="alert">${msg}</div>
            </c:if>
            <c:if test="${not empty error}">
                <div class="alert alert-danger" role="alert">${error}</div>
            </c:if>
            <div class="panel-heading">${allGroupsLabel}</div>
            <table class="table">
                <thead>
                <tr>
                    <th>${groupNameLabel}</th>
                    <th>${groupDescriptionLabel}</th>
                    <th>${operationLabel}</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${groups}" var="group">
                    <tr>
                        <td>${group.name}</td>
                        <td>${group.description}</td>
                        <td>
                            <spring:url value="/admin/delete_group/${group.id}" var="deleteUrl"/>
                            <spring:url value="/admin/update_group/${group.id}" var="#"/>

                            <button class="btn btn-primary"
                                    onclick="location.href='${updateUrl}'">${UpdateLabel}</button>
                            <button class="btn btn-danger"
                                    onclick="this.disabled=true;post('${deleteUrl}')">${DeleteLabel}
                            </button>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
<script src="<spring:url value="/resources/js/script.js" />" ></script>
<%@include file="/WEB-INF/views/template/footer.jsp" %>
