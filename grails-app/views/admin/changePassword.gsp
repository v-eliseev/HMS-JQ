<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<meta name="layout" content="main" />
<title>Change password</title>
</head>
<body>
	<div class="body">
		<div class="nav" role="navigation">
		<g:form action="doChangePassword" method="POST">
		<g:hiddenField name="username" value="${username}"/>
		Current Password: <g:textField name="currentPassword"/><br>
		New Password: <g:passwordField name="newPassword"/><br>
		New Password (retype): <g:passwordField name="newPassword_retype"/><br>
		<g:submitButton name="Change"/>
		</g:form>
		</div>
	</div>
</body>
</html>