<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<meta name="layout" content="main" />
<title>Application status</title>
<style type="text/css" media="screen">
#status {
	background-color: #eee;
	border: .2em solid #fff;
	margin: 2em 2em 1em;
	padding: 1em;
	width: 12em;
	float: left;
	-moz-box-shadow: 0px 0px 1.25em #ccc;
	-webkit-box-shadow: 0px 0px 1.25em #ccc;
	box-shadow: 0px 0px 1.25em #ccc;
	-moz-border-radius: 0.6em;
	-webkit-border-radius: 0.6em;
	border-radius: 0.6em;
}

.ie6 #status {
	display: inline;
	/* float double margin fix http://www.positioniseverything.net/explorer/doubled-margin.html */
}

#status ul {
	font-size: 0.9em;
	list-style-type: none;
	margin-bottom: 0.6em;
	padding: 0;
}

#status li {
	line-height: 1.3;
}

#status h1 {
	text-transform: uppercase;
	font-size: 1.1em;
	margin: 0 0 0.3em;
}

#page-body {
	margin: 2em 1em 1.25em 18em;
}

#domain-list ul {
	list-style-position: inside;
}

#domain-list li {
	line-height: 1.3;
	list-style-position: inside;
	margin: 0.25em 0;
}
</style>
</head>
<body>
	<div class="body">
		<div id="status" role="complementary">
			<h1>Application Status</h1>
			<ul>
				<li>App version: <g:meta name="app.version" /></li>
				<li>Grails version: <g:meta name="app.grails.version" /></li>
				<li>Groovy version: ${org.codehaus.groovy.runtime.InvokerHelper.getVersion()}</li>
				<li>JVM version: ${System.getProperty('java.version')}</li>
				<li>Reloading active: ${grails.util.Environment.reloadingAgentEnabled}</li>
				<li>Controllers: ${grailsApplication.controllerClasses.size()}</li>
				<li>Domains: ${grailsApplication.domainClasses.size()}</li>
				<li>Services: ${grailsApplication.serviceClasses.size()}</li>
				<li>Tag Libraries: ${grailsApplication.tagLibClasses.size()}</li>
			</ul>
			<h1>Installed Plugins</h1>
			<ul>
				<g:each var="plugin"
					in="${applicationContext.getBean('pluginManager').allPlugins}">
					<li>
						${plugin.name} - ${plugin.version}
					</li>
				</g:each>
			</ul>
		</div>
		<div id="page-body" role="main">
			<div id="domain-list" role="navigation">
				<h2>Objects:</h2>
				<ul>
					<li>Licenses: ${License.findAll().size()}</li>
					<g:each var="o"
						in="${grailsApplication.domainClasses.sort { it.fullName } }">
						<li class="domain">${o.logicalPropertyName}:</li>
					</g:each>
				</ul>
			</div>

		</div>
	</div>
</body>
</html>