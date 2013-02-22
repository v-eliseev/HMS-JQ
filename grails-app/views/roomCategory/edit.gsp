<g:applyLayout name="threeblocks">
<head>
<title><g:message code="title.admin.rooms" /></title>
<r:require modules="togglebuttons, datepicker"/>
</head>

<content tag="top"> 
</content>

<content tag="main"> 
<legend>Room category data</legend>
<g:form class="form-horizontal" action="update" id="${roomCategoryInstance?.id}" method="POST">
    <fieldset>
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

</g:applyLayout>
