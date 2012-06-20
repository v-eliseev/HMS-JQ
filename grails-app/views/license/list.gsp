
<%@ page import="hms.License" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'license.label', default: 'License')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-license" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-license" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="key" title="${message(code: 'license.key.label', default: 'Key')}" />
					
						<g:sortableColumn property="dateCreated" title="${message(code: 'license.dateCreated.label', default: 'Date Created')}" />
					
						<g:sortableColumn property="demoMode" title="${message(code: 'license.demoMode.label', default: 'Demo Mode')}" />
					
						<g:sortableColumn property="expires" title="${message(code: 'license.expires.label', default: 'Expires')}" />
					
						<g:sortableColumn property="lastUpdated" title="${message(code: 'license.lastUpdated.label', default: 'Last Updated')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${licenseInstanceList}" status="i" var="licenseInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${licenseInstance.id}">${fieldValue(bean: licenseInstance, field: "key")}</g:link></td>
					
						<td><g:formatDate date="${licenseInstance.dateCreated}" /></td>
					
						<td><g:formatBoolean boolean="${licenseInstance.demoMode}" /></td>
					
						<td><g:formatDate date="${licenseInstance.expires}" /></td>
					
						<td><g:formatDate date="${licenseInstance.lastUpdated}" /></td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${licenseInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
