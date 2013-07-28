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
<g:form action="addReservation">
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
            <g:submitToRemote class="btn btn-info btn-block" action="checkReservation"
            onSuccess="alert(data.status)" name="submitCheck" value="Check!"/>
            <div id="checkReservationStatus"></div>
        </div>

        <div class="control-group">
            <g:submitButton class="btn btn-success btn-block" name="submit" value="Make!"/>
        </div>
    </div>
</g:form>
</div>
<div class="span4">
    <legend>Check-in</legend>
    <table class="table table-striped table-condensed">
    <tbody>
        <g:each in="${todayCheckinList}" status="i" var="checkinInstance">
        <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
        <td>
            <span class="label">${i+1}</span>&nbsp;
            <span>${checkinInstance.id}</span><br>
            <span>${checkinInstance.fromDate}-${checkinInstance.toDate}</span><br>
            <span>${checkinInstance.roomCategory.name} ${checkinInstance.adults} bed(s)</span>
        </td>
        </tr>
        </g:each>
    </tbody>
    </table>
</div>
<div class="span4">
    <legend>Check-out</legend>
</div>
</div>

<div class="row-fluid show-grid">
<div class="span4">
    <legend>Booking plan</legend>
    <g:link action="showCurrentPlan">Show plan...</g:link>
</div>
<div class="span4">
    <legend>Statistics</legend>
</div>
<div class="span4">
    <legend>Additional</legend>
</div>
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
