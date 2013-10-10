<g:applyLayout name="twoblocks">
<head>
<title><g:message code="title.superuser.index" /></title>
</head>

<content tag="top"> 
</content>

<content tag="main">

<div class="row show-grid">
<div class="col-lg-4">
    <legend><i class="icon-building"></i> Hotel</legend>
    <ul class="list-unstyled">
        <li>${fieldValue(bean: hotelInstance, field: "name")}</li> 
        <li><i class="icon-phone"> </i>${fieldValue(bean: hotelInstance, field: "phone")}</li> 
        <li><i class="icon-print"> </i>${fieldValue(bean: hotelInstance, field: "fax")}</li> 
        <li><i class="icon-envelope"> </i>${fieldValue(bean: hotelInstance, field: "eMail")}</li> 
        <li><i class="icon-globe"> </i>${fieldValue(bean: hotelInstance, field: "webSite")}</li> 
    </ul>
    <g:link controller="admin" action="hotelInfo">More &hellip;</g:link>

</div>
<div class="col-lg-8">
    <legend><i class="icon-dashboard"></i> Dashboard</legend>

</div>
</div>

<div class="row show-grid">
<div class="col-lg-4">
    <legend><i class="icon-key"></i> License</legend>
    <ul class="list-unstyled">
        <li>${fieldValue(bean: licenseInstance, field: "key")}</li> 
        <li><g:formatDate date="${licenseInstance.issued}" /></li> 
        <li><g:formatDate date="${licenseInstance.expires}" /></li> 
        <li>(${licenseInstance.expires-licenseInstance.issued} day(s) left)</li>
    </ul>
</div>
<div class="col-lg-8">
    <legend>Users</legend>
%{--     <div class="list-group">
        <g:each in="${userInstanceList}" status="i" var="userInstance">
            <g:link class="list-group-item" id="${userInstance.id}">
                <h5 class="list-group-item-heading"><span class="label label-default">${i+1}</span>&nbsp;User: ${userInstance.username}</h5>
                <ul class="list-unstyled list-group-item-text">
                    <li>
                        <g:formatDate format="dd-MM-yy" date="${checkinInstance.fromDate}"/>&nbsp;-&nbsp;<g:formatDate format="dd-MM-yy" date="${checkinInstance.toDate}"/>
                    </li>
                    <li>${checkinInstance.roomCategory.name} ${checkinInstance.adults} bed(s)</li>
                </ul>
            </g:link>
        </g:each>        
    </div>
 --}%
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
	<tr>
    	<td>
    		<g:link controller="admin" action="showUser" id="${userInstance.id}">
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
<g:link controller="admin" action="addUser" class="btn btn-primary"><i class="icon-plus-sign-alt"> </i>Add user</g:link>
</div>
</div>

</content>

<content tag="sidemenu">
<g:render template="/templates/adminNavigation"/>
</content>

</g:applyLayout>
