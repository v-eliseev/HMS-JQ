<g:applyLayout name="threeblocks">

<head>
<title><g:message code="title.admin.users" /></title>
</head>

<content tag="top">
</content>

<content tag="main">
	<g:form action="doCreateUser" method="POST">
		Username: <g:textField name="username"/><br>
		Password: <g:passwordField name="password"/><br>
		Password (retype): <g:passwordField name="password_retype"/><br>
%{-- 	
		Roles:
		<g:each in="${roleInstanceList}" var="role">
			${role.authority}<br>
		</g:each>
 --}%		
 		<g:submitButton name="Create"/>
	</g:form>
</content>

<content tag="sidemenu">
<g:render template="/templates/adminNavigation"/>
</content>

</g:applyLayout>
