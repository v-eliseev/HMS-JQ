<sec:ifLoggedIn>
<sec:ifAllGranted roles="ROLE_USER">
	<g:render template="/templates/userNavigation"></g:render>
</sec:ifAllGranted>	
<sec:ifAllGranted roles="ROLE_ADMIN">
	<g:render template="/templates/adminNavigation"></g:render>
</sec:ifAllGranted>
</sec:ifLoggedIn>
<sec:ifNotLoggedIn>
	<g:render template="/templates/superuserNavigation"></g:render>
</sec:ifNotLoggedIn>
