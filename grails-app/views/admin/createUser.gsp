<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<meta name="layout" content="main" />
<title>Create user</title>
</head>
<body>
	<div class="body">
		<g:form action="doCreateUser" method="POST">
		Username: <g:textField name="username"/><br>
		Password: <g:passwordField name="password"/><br>
		Password (retype): <g:passwordField name="password_retype"/><br>
		<g:submitButton name="Create"/>
		</g:form>
	</div>
</body>
</html>