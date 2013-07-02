<g:applyLayout name="threeblocks">
<head>
<title><g:message code="title.superuser.index" /></title>
<r:require module="daterangepicker"/>
</head>

<content tag="top">
</content>

<content tag="main">

<div class="row-fluid show-grid">
<div class="span4">
    <legend>New Reservation</legend>
    <div>
        <div class="control-group">
            <label class="control-label">
                <g:message code="user.name.label" default="From-To" />:
            </label>
            <div class="controls">
                <div class="input-prepend">
                    <span class="add-on"><i class="icon-calendar"></i></span>
                    <input type="text" name="daterange" id="daterange" />
                </div>                    
            </div>
%{--             <div class="control-group">
                <label class="control-label">
                    <g:message code="user.name.label" default="From" />:
                </label>
                <div class="controls">
                    <input name="fromDate" type="text" class="datepicker" placeholder="Enter from date" value="${reservationInstance?.fromDate}">
                </div>
            </div>
            <div class="control-group">
                <label class="control-label">
                    <g:message code="user.name.label" default="To" />:
                </label>
                <div class="controls">
                    <input id="toDate" name="toDate" type="text" class="datepicker" placeholder="Enter to date" value="${reservationInstance?.toDate}">
                </div>
            </div>
 --}% 
            <label class="control-label">
                <g:message code="user.name.label" default="Adults" />:
            </label>
            <div class="controls">
                <div class="input-prepend">
                    <span class="add-on"><i class="icon-user"></i></span>
                    <input name="adults" type="text" placeholder="Enter adults" />
                </div>
            </div>

            <label class="control-label">
                <g:message code="user.name.label" default="RoomCategory" />:
            </label>
            <div class="controls">
                <g:select name="roomCategory" from="${roomCategoryInstanceList}" optionKey="id" optionValue="name"/>
            </div>
        </div>

        <div class="control-group">
            <g:remoteLink action="checkReservation"
                params="[from: '2012-07-29', to: '2012-07-31', adults: 2]" onSuccess="alert(data.status)">Check!</g:remoteLink>
                <!-- \$('#checkReservationStatus').val(data.status) -->
            <div id="checkReservationStatus"></div>
        </div>

        <div class="control-group">
            <button class="btn btn-success btn-block">Make!</button>
        </div>
    </div>

</div>
<div class="span4">
    <legend>Check-in</legend>
</div>
<div class="span4">
    <legend>Check-out</legend>
</div>
</div>

<div class="row-fluid show-grid">
</div>

<r:script>
$('#daterange').daterangepicker();
</r:script>
</content>

<content tag="sidemenu">

    <li class="nav-header">License</li>
    <small>
    <ul>
        <li>${fieldValue(bean: licenseInstance, field: "key")}</li> 
        <li>Issued: <g:formatDate date="${licenseInstance.issued}" /></li> 
        <li>Expires: <g:formatDate date="${licenseInstance.expires}" /></li> 
        <li>Days left: ${licenseInstance.expires-licenseInstance.issued}</li>
    </ul> 
    </small>
    
    <li class="nav-header">Hotel</li>
    <small>
        <g:link controller="hotel" action="edit">${fieldValue(bean: hotelInstance, field: "name")}</g:link>
    </small>

    <li class="nav-header">Room categories <span class="badge">5</span></li>
    <li class="nav-header">Rooms <span class="badge">15</span></li>
    <li class="nav-header">Reservations <span class="badge">${reservationInstanceList.size()}</span></li>
    <li class="nav-header">Guests <span class="badge">7</span></li>

</content>

</g:applyLayout>


