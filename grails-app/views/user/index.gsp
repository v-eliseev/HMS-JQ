<g:applyLayout name="threeblocks">
<head>
<title><g:message code="title.superuser.index" /></title>
<r:require module="daterangepicker"/>
</head>

<content tag="top">
</content>

<content tag="main">

<div class="row show-grid">
<div class="col-lg-4">
<g:form action="addReservation">
    <legend><i class="icon-plus-sign"></i> New Reservation</legend>
    <div>
        <div class="form-group">
            <label><g:message code="user.name.label" default="From-To" />:</label>
            <div class="input-group">
                <span class="input-group-addon"><i class="icon-calendar"></i></span>
                <input class="form-control" type="text" name="daterange" id="daterange" placeholder="Enter dates from-to"/>
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
        <div class="form-group">
            <label><g:message code="user.name.label" default="Adults" />:</label>
            <div class="input-group">
                <span class="input-group-addon"><i class="icon-user"></i></span>
                <input class="form-control" name="adults" type="text" placeholder="Enter adults" />
            </div>
        </div>
        <div class="form-group">
            <label><g:message code="user.name.label" default="RoomCategory" />:</label>
            <div class="input-group">
                <span class="input-group-addon"><i class="icon-sort-by-alphabet"></i></span>
                <g:select class="form-control" name="roomCategory" from="${roomCategoryInstanceList}" optionKey="id" optionValue="name"/>
            </div>
        </div>

        <div class="form-group">
            <g:submitToRemote class="btn btn-info btn-block" action="checkReservation"
            onSuccess="alert(data.status)" name="submitCheck" value="Check!"/>
            <div id="checkReservationStatus"></div>
        </div>

        <div class="form-group">
            <g:submitButton class="btn btn-success btn-block" name="submit" value="Make!"/>
        </div>
    </div>
</g:form>
</div>
<div class="col-lg-4">
    <legend><i class="icon-signin"></i> Check-in</legend>
    <table class="table table-striped table-condensed">
    <tbody>
        <g:each in="${todayCheckinList}" status="i" var="checkinInstance">
        <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
        <td>
            <ul class="list-unstyled">
                <li><span class="label">${i+1}</span>&nbsp;
                    <span>Code: ${checkinInstance.id}</span>
                <li>
                    <g:formatDate format="dd-MM-yy" date="${checkinInstance.fromDate}"/>&nbsp;-&nbsp;<g:formatDate format="dd-MM-yy" date="${checkinInstance.toDate}"/>
                </li>
                <li>${checkinInstance.roomCategory.name} ${checkinInstance.adults} bed(s)</li>
            </ul>
        </td>
        </tr>
        </g:each>
    </tbody>
    </table>
</div>
<div class="col-lg-4">
    <legend><i class="icon-signout"></i> Check-out</legend>
</div>
</div>

<div class="row show-grid">
<div class="col-lg-4">
    <legend><i class="icon-calendar"></i> Booking plan</legend>
        <ul class="list-unstyled">
            <li>Feasible: ${score.getFeasible()}</li>
            <li>Score: ${score.getHard()}/${score.getSoft()}</li>
        </ul>
    <g:link action="showCurrentPlan">Show plan...</g:link>
</div>
<div class="col-lg-4">
    <legend><i class="icon-bar-chart"></i> Statistics</legend>
    <g:link action="showCharts">Show charts...</g:link>
</div>
<div class="col-lg-4">
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
