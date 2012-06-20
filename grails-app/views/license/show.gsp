
<%@ page import="hms.License" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'license.label', default: 'License')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-license" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-license" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list license">
			
				<g:if test="${licenseInstance?.key}">
				<li class="fieldcontain">
					<span id="code-label" class="property-label"><g:message code="license.key.label" default="Key" /></span>
					
						<span class="property-value" aria-labelledby="code-label"><g:fieldValue bean="${licenseInstance}" field="key"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${licenseInstance?.dateCreated}">
				<li class="fieldcontain">
					<span id="dateCreated-label" class="property-label"><g:message code="license.dateCreated.label" default="Date Created" /></span>
					
						<span class="property-value" aria-labelledby="dateCreated-label"><g:formatDate date="${licenseInstance?.dateCreated}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${licenseInstance?.demoMode}">
				<li class="fieldcontain">
					<span id="demoMode-label" class="property-label"><g:message code="license.demoMode.label" default="Demo Mode" /></span>
					
						<span class="property-value" aria-labelledby="demoMode-label"><g:formatBoolean boolean="${licenseInstance?.demoMode}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${licenseInstance?.expires}">
				<li class="fieldcontain">
					<span id="expires-label" class="property-label"><g:message code="license.expires.label" default="Expires" /></span>
					
						<span class="property-value" aria-labelledby="expires-label"><g:formatDate date="${licenseInstance?.expires}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${licenseInstance?.lastUpdated}">
				<li class="fieldcontain">
					<span id="lastUpdated-label" class="property-label"><g:message code="license.lastUpdated.label" default="Last Updated" /></span>
					
						<span class="property-value" aria-labelledby="lastUpdated-label"><g:formatDate date="${licenseInstance?.lastUpdated}" /></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${licenseInstance?.id}" />
					<g:link class="edit" action="edit" id="${licenseInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
