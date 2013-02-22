<g:applyLayout name="threeblocks">

<head>
<title><g:message code="title.admin.users" /></title>
</head>

<content tag="top">
<ul>
    <li><g:link action="resetPassword" id="${userInstance.id}">Reset password</g:link></li>
    <li><g:link action="deleteUser" id="${userInstance.id}">Delete user</g:link></li>
</ul>
</content>

<content tag="main">
<form class="form-horizontal">
    <fieldset>
        <legend>User data</legend>
        <g:if test="${userInstance?.username}">
            <div class="control-group">
                <label class="control-label">
                    <g:message code="user.name.label" default="Username" />:
                </label>
                <div class="controls">
                    <span class="input-xlarge uneditable-input">
                        <g:fieldValue bean="${userInstance}" field="username"/>
                    </span>
                </div>
            </div>
        </g:if>
        <g:if test="${userInstance?.enabled}">
            <div class="control-group">
                <label class="control-label">
                    <g:message code="user.enabled.label" default="Enabled" />:
                </label>
                <div class="controls">
                    <span class="input-xlarge uneditable-input">
                        <g:fieldValue bean="${userInstance}" field="enabled"/>
                    </span>
                    <g:link class="btn btn-primary btn-small" 
                        action="changeEmail" id="${userInstance.id}">
                        Change
                    </g:link>
                </div>
            </div>
        </g:if>

    </fieldset>
</form>
</content>

<content tag="sidemenu">
<g:render template="/templates/adminNavigation"/>
</content>

</g:applyLayout>
