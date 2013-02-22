<g:applyLayout name="threeblocks">
<head>
<title><g:message code="title.admin.rooms" /></title>
</head>

<content tag="top"> 
</content>

<content tag="main"> 
    <legend>Rooms</legend>
    <table class="table table-striped table-condensed">
    <thead>
        <tr>
            <g:sortableColumn property="name"
                title="${message(code: 'license.key.label', default: 'Name')}" />
            <g:sortableColumn property="demoMode"
                title="${message(code: 'license.demoMode.label', default: 'Category')}" />
            <g:sortableColumn property="expires"
                title="${message(code: 'license.expires.label', default: 'Adults')}" />
        </tr>
    </thead>
    <tbody>
    <g:each in="${roomInstanceList}" status="i" var="roomInstance">
        <tr>
            <td>
                <g:link action="edit" id="${roomInstance.id}">
                    <code>${fieldValue(bean: roomInstance, field: "name")}</code>
                </g:link>
            </td>
            <td>
				<span class="label">${roomInstance.roomCategory.name}</span>
            </td>
            <td>
				<span class="label">${roomInstance.adults}</span>
            </td>
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