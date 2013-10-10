<g:applyLayout name="twoblocks">
<head>
<title><g:message code="title.admin.rooms" /></title>
%{-- <r:require modules="togglebuttons, datetimepicker"/> --}%
</head>

<content tag="top"> 
</content>

<content tag="main"> 
<legend>New User</legend>
<g:form class="form-horizontal" action="create" method="POST">
    <fieldset>
        <div class="control-group">
            <label class="control-label">
                <g:message code="user.name.label" default="Username" />:
            </label>
            <div class="controls">
                <input type="text" placeholder="Enter username">
            </div>
        </div>
        <div class="control-group">
            <label class="control-label">
                <g:message code="user.name.label" default="Password" />:
            </label>
            <div class="controls">
                <input type="password" placeholder="Enter password">
            </div>
        </div>
        <div class="control-group">
            <label class="control-label">
                <g:message code="user.name.label" default="Password (retype)" />:
            </label>
            <div class="controls">
                <input type="password" placeholder="Retype password">
            </div>
        </div>
        <g:render template="userform"/>
    </fieldset>
    <div class="control-group">
        <div class="controls">
            <button class="btn btn-primary" href="#">Create</button>
        </div>
    </div>
</g:form>
</content>

<content tag="sidemenu">
<g:render template="/templates/adminNavigation"/>
</content>

</g:applyLayout