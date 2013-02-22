<g:applyLayout name="threeblocks">

<head>
<title><g:message code="title.admin.users" /></title>
</head>

<content tag="top">
</content>

<content tag="main">
<legend>Reservations</legend>
<table class="table table-striped table-condensed">
<thead>
    <tr>
        <g:sortableColumn property="id"
            title="${message(code: 'license.key.label', default: '#')}" />
        <g:sortableColumn property="fromDate"
            title="${message(code: 'license.key.label', default: 'From')}" />
        <g:sortableColumn property="toDate"
            title="${message(code: 'license.key.label', default: 'To')}" />
    </tr>
</thead>
<tbody>
<g:each in="${reservationInstanceList}" status="i" var="reservationInstance">
    <tr>
        <td>
            <g:link action="edit" id="${reservationInstance.id}">
                <code>${fieldValue(bean: reservationInstance, field: 'id')}</code>
            </g:link>
        </td>
        <td>${fieldValue(bean: reservationInstance, field: "fromDate")}</td>
        <td>${fieldValue(bean: reservationInstance, field: "toDate")}</td>
    </tr>
</g:each>
</tbody>
</table>

<div class="btn-group">
    <g:link action="add" class="btn btn-primary">Create</g:link>
</div>

</content>

<content tag="sidemenu">
<g:render template="/templates/adminNavigation"/>
</content>

</g:applyLayout>