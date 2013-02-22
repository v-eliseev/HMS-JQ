<g:applyLayout name="threeblocks">
<head>
<title><g:message code="title.admin.roomcategories" /></title>
</head>

<content tag="top"> 
</content>

<content tag="main"> 
    <legend>Room Categories</legend>
    <table class="table table-striped table-condensed">
    <thead>
        <tr>
            <g:sortableColumn property="name"
                title="${message(code: 'license.key.label', default: 'Name')}" />
        </tr>
    </thead>
    <tbody>
    <g:each in="${roomCategoryInstanceList}" status="i" var="roomCategoryInstance">
        <tr>
            <td>
                <g:link action="edit" id="${roomCategoryInstance.id}">
                    <code>${fieldValue(bean: roomCategoryInstance, field: "name")}</code>
                </g:link>
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