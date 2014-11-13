<g:applyLayout name="twoblocks">
<head>
<title><g:message code="title.superuser.index" /></title>
<asset:stylesheet src="datatables.css"/>
<asset:javascript src="datatables.js"/>
</head>

<content tag="top"> 
</content>

<content tag="main">

<div class="row show-grid">
<div class="col-lg-4">
    <legend><i class="fa fa-building-o"></i> Hotel</legend>
    <ul class="fa-ul">
        <li><i class="fa fa-li fa-home"></i> ${hotelInstance.name}</li> 
        <li><i class="fa fa-li fa-phone"></i> ${hotelInstance.phone}</li> 
        <li><i class="fa fa-li fa-print"></i> ${hotelInstance.fax}</li> 
        <li><i class="fa fa-li fa-envelope"></i> ${hotelInstance.eMail}</li> 
        <li><i class="fa fa-li fa-globe"></i> ${hotelInstance.webSite}</li> 
    </ul>
    <div class="list-group">
        <g:link class="list-group-item">Room categories <span class="badge">${hotelRoomCategoriesCount}</span></g:link>
        <g:link class="list-group-item">Rooms <span class="badge">${hotelRoomsCount}</span></g:link>
    </div>
    <g:link controller="admin" action="editHotel">More &hellip;</g:link>

</div>
<div class="col-lg-8">
    <legend><i class="fa fa-dashboard"></i> Dashboard</legend>
    <div class="row">
    <div class="col-lg-6">
    <div class="col-lg-4">
        <span>Guests:</span>
    </div>
    <div class="col-lg-8">
    <div class="progress">
        <div class="progress-bar" role="progressbar" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100" style="width: 60%;">60%</div>
    </div>
    </div>
    </div>
    </div>
    <div class="row">
    <div class="col-lg-6">
    <div class="col-lg-4">
        <span>Rooms:</span>
    </div>
    <div class="col-lg-8">
    <div class="progress">
        <div class="progress-bar" role="progressbar" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100" style="width: 60%;">60%</div>
    </div>
    </div>
    </div>
    </div>
</div>
</div>

<div class="row show-grid">
<div class="col-lg-4">
    <legend><i class="fa fa-key"></i> License</legend>
    <ul class="list-unstyled">
        <li><strong>${licenseInstance.key}</strong></li> 
        <li>Issued: <g:formatDate date="${licenseInstance.issued}" /></li> 
        <li>Expires: <g:formatDate date="${licenseInstance.expires}" /></li> 
        <li>(${licenseInstance.expires-licenseInstance.issued} day(s) left)</li>
    </ul>
</div>
<div class="col-lg-8">
    <legend><i class="fa fa-user"></i> Users</legend>
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
<table id="users" class="table table-striped table-condensed">
<thead>
	<tr>
		<g:sortableColumn property="username"
			title="${message(code: 'license.key.label', default: 'Name')}" />
		<g:sortableColumn property="enabled"
			title="${message(code: 'license.demoMode.label', default: 'En')}" />
		<g:sortableColumn property="accountExpired"
			title="${message(code: 'license.expires.label', default: 'NEx')}" />
		<g:sortableColumn property="accountLocked"
			title="${message(code: 'license.demoMode.label', default: 'NLo')}" />
		<g:sortableColumn property="passwordExpired"
			title="${message(code: 'license.expires.label', default: 'PNEx')}" />
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
<g:link controller="admin" action="addUser" class="btn btn-primary"><i class="fa fa-plus-circle"></i> Add user</g:link>
</div>
</div>

<script type="text/javascript">
$(document).ready(function() {
    $('#users').dataTable(
    {
    })
});
</script>

</content>

</g:applyLayout>
