<g:applyLayout name="threeblocks">
<head>
<title><g:message code="title.admin.rooms" /></title>
<r:require modules="togglebuttons, datepicker"/>
</head>

<content tag="top"> 
</content>

<content tag="main"> 
<legend>New Room</legend>
<g:form class="form-horizontal" action="create" method="POST">
    <fieldset>
        <g:render template="form"/>
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
