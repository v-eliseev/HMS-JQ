<g:applyLayout name="threeblocks">
<head>
<title><g:message code="title.superuser.index" /></title>
</head>

<content tag="top"> 
</content>

<content tag="main"> 
	<div class="row-fluid">
		<div class="span4">
			<h4>Application Status</h4>
			<ul>
				<li>App version: <g:meta name="app.version" /></li>
				<li>Grails version: <g:meta name="app.grails.version" /></li>
				<li>Groovy version: ${GroovySystem.getVersion()}</li>
				<li>JVM version: ${System.getProperty('java.version')}</li>
				<li>Reloading active: ${grails.util.Environment.reloadingAgentEnabled}</li>
				<li>Controllers: ${grailsApplication.controllerClasses.size()}</li>
				<li>Domains: ${grailsApplication.domainClasses.size()}</li>
				<li>Services: ${grailsApplication.serviceClasses.size()}</li>
				<li>Tag Libraries: ${grailsApplication.tagLibClasses.size()}</li>
			</ul>
		</div>
	<div class="span4">
		<h4>Installed Plugins</h4>
		<ul>
			<g:each var="plugin"
				in="${applicationContext.getBean('pluginManager').allPlugins}">
				<li>
					${plugin.name} - ${plugin.version}
				</li>
			</g:each>
		</ul>
	</div>
	<div class="span4">
		<h4>Objects:</h4>
		<ul>
			<g:each var="o"
				in="${grailsApplication.domainClasses.sort { it.fullName } }">
				<li class="domain">${o.logicalPropertyName}: </li>
			</g:each>
		</ul>
	</div>
	</div>
</content>

<content tag="sidemenu">
	<li><g:link action="showLicenses">Show licences</g:link></li>
	<li><g:link action="showApplicationStatus">Show application status</g:link></li>
	<li><g:link action="showStatistics">Show statistics</g:link></li>
	<li><g:link action="cleanup">Cleanup</g:link></li>
</content>

</g:applyLayout>