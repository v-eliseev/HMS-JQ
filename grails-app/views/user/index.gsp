<g:applyLayout name="threeblocks">
<head>
<title><g:message code="title.superuser.index" /></title>
</head>

<content tag="top">
</content>

<content tag="main">

<div class="row-fluid show-grid">
<div class="span2">
    <a href="#" class="btn btn-primary">
        <i class="icon-th-list icon-white"></i>
        <span><strong>Reservations</strong></span>            
    </a>
</div>
<div class="span1">
    <a href="#" class="btn btn-primary">
        <i class="icon-eye-open icon-white"></i>
        <span><strong>View</strong></span>          
    </a>
</div>
<div class="span1">
    <a href="#" class="btn btn-primary">
        <i class="icon-edit icon-white"></i>
        <span><strong>Edit</strong></span>       
    </a>    
</div>
<div class="span1">
    <a href="#" class="btn btn-primary">
        <i class="icon-trash icon-white"></i>
        <span><strong>Delete</strong></span>            
    </a>
</div>
</div>

<div class="row-fluid show-grid">
<div>
    <legend>License</legend>
    Key: ${fieldValue(bean: licenseInstance, field: "key")}<br> 
    Issued: <g:formatDate date="${licenseInstance.issued}" /><br> 
    Expires: <g:formatDate date="${licenseInstance.expires}" /><br> 
    Days left: ${licenseInstance.expires-licenseInstance.issued}
</div> 
<div>
    <legend>Hotel</legend>
    <g:link controller="hotel" action="edit">
    ${fieldValue(bean: hotelInstance, field: "name")}
    </g:link>
</div>
<div>
    <legend>Reservations</legend>
    <ul>
    <g:each in="${reservationInstanceList}" status="i"
        var="reservationInstance">
        <li><g:link controller="reservation" action="edit"
                id="${reservationInstance.id}">
                ${fieldValue(bean: reservationInstance, field: "id")}</g:link>
            (${reservationInstance.fromDate}--${reservationInstance.toDate}])
        </li>
    </g:each>
    </ul>
</div>
</div>
</content>

<content tag="sidemenu">
<g:render template="/templates/userNavigation"/>
</content>

</g:applyLayout>


