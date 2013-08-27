<g:applyLayout name="threeblocks">
<head>
<title><g:message code="title.admin.rooms" /></title>
<r:require modules="togglebuttons, datetimepicker"/>
</head>

<content tag="top"> 
</content>

<content tag="main"> 
<legend>User data</legend>
<g:form class="form-horizontal" action="update" method="POST">
    <fieldset>
        <div class="control-group">
            <label class="control-label">
                <g:message code="user.name.label" default="Username" />:
            </label>
            <div class="controls">
                <input type="text" placeholder="Enter username" readonly>
            </div>
        </div>
        <g:render template="form"/>
    </fieldset>
    <div class="control-group">
        <div class="controls">
            <button class="btn btn-primary" href="#">Update</button>
        </div>
    </div>
</g:form>
</content>

<content tag="sidemenu">
<g:render template="/templates/adminNavigation"/>
</content>

</g:applyLayout