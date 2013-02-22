<g:applyLayout name="threeblocks">

<head>
<title><g:message code="title.admin.users" /></title>
</head>

<content tag="top">
    <g:link class="btn btn-primary" action="createUser">Create user</g:link>
</content>

<content tag="main">
<legend>Users</legend>
<table class="table table-striped table-condensed">
<thead>
	<tr>
		<g:sortableColumn property="username"
			title="${message(code: 'license.key.label', default: 'Name')}" />
		<g:sortableColumn property="enabled"
			title="${message(code: 'license.demoMode.label', default: 'Enabled')}" />
		<g:sortableColumn property="accountExpired"
			title="${message(code: 'license.expires.label', default: 'Expired')}" />
		<g:sortableColumn property="accountLocked"
			title="${message(code: 'license.demoMode.label', default: 'Locked')}" />
		<g:sortableColumn property="passwordExpired"
			title="${message(code: 'license.expires.label', default: 'Password Expired')}" />
		<g:sortableColumn property="authorities"
			title="${message(code: 'license.expires.label', default: 'Authorities')}" />
	</tr>
</thead>
<tbody>
	<g:each in="${userInstanceList}" status="i" var="userInstance">
	<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
    	<td>
    		<g:link controller="secUser" action="edit" id="${userInstance.id}">
    			<code>${fieldValue(bean: userInstance, field: "username")}</code>
    		</g:link>
    	</td>
		<td><hms:booleanIcon value="${userInstance.enabled}"/></td>
		<td><hms:booleanIcon value="${userInstance.accountExpired}" inverse="true"/></td>
		<td><hms:booleanIcon value="${userInstance.accountLocked}" inverse="true"/></td>
		<td><hms:booleanIcon value="${userInstance.passwordExpired}" inverse="true"/></td>
		<td>
			<g:each in="${userInstance.getAuthorities()}" status="j" var="roleInstance">
				${roleInstance.authority}&nbsp;
            </g:each>
        </td>
	</tr>
	</g:each>
</tbody>
</table>

<div class="btn-group">
    <g:link controller="secUser" action="add" class="btn btn-primary">Create user</g:link>
%{--     <button class="btn btn-primary dropdown-toggle" data-toggle="dropdown"><span class="caret"></span></button>
    <ul class="dropdown-menu">
        <li><g:link action="createStandardLicense">Create standard license</g:link></li>
        <li><g:link action="createDemoLicense">Create demo license</g:link></li>
    </ul>
 --}%</div>

</content>

<content tag="sidemenu">
<g:render template="/templates/adminNavigation"/>
</content>

</g:applyLayout>