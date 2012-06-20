<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<meta name="layout" content="main" />
<title>Superuser page</title>
</head>
<body>
	<div class="body">
		<div class="nav" role="navigation">
			<ul>
				<li><g:link action="createStandardLicense">Create standard license</g:link></li>
				<li><g:link action="showLicenses">Show licences</g:link></li>
				<li><g:link action="showApplicationStatus">Show application status</g:link></li>
			</ul>
		</div>

		<table>
			<thead>
				<tr>
					<g:sortableColumn property="key"
						title="${message(code: 'license.key.label', default: 'Key')}" />
					<g:sortableColumn property="demoMode"
						title="${message(code: 'license.demoMode.label', default: 'Demo Mode')}" />
					<g:sortableColumn property="expires"
						title="${message(code: 'license.expires.label', default: 'Expires')}" />
				</tr>
			</thead>
			<tbody>
				<g:each in="${licenseInstanceList}" status="i" var="licenseInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
						<td><g:link action="show" id="${licenseInstance.id}">
								${fieldValue(bean: licenseInstance, field: "key")}
							</g:link></td>
						<td><g:formatBoolean boolean="${licenseInstance.demoMode}" /></td>
						<td><g:formatDate date="${licenseInstance.expires}" /></td>
					</tr>
				</g:each>
			</tbody>
		</table>
	</div>
</body>
</html>