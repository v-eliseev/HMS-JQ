<g:applyLayout name="threeblocks">
<head>
<title><g:message code="title.superuser.index" /></title>
<r:require module="daterangepicker"/>
</head>

<content tag="top">
</content>

<content tag="main">

<div class="row-fluid show-grid">
<div class="span2">
    <g:link fragment="addReservation" class="btn btn-primary" data-toggle="modal">
        <i class="icon-th-list icon-white"></i>
        <span><strong>New Reservation</strong></span>            
    </g:link>
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

<!-- Modal Add Reservation -->
<div id="addReservation" class="modal hide fade" tabindex="-1" role="dialog" style="display: none;">
    <g:form id="modal-form" action="doAddReservation" method="POST">
    <div class="modal-header">
        <h3>Add reservation...</h3>
    </div>
    <div class="modal-body">
        <div>
            <div class="control-group">
                <label class="control-label">
                    <g:message code="user.name.label" default="From" />:
                </label>
                <div class="controls">
                    <div class="input-prepend">
                        <span class="add-on"><i class="icon-calendar"></i></span>
                        <input type="text" name="daterange" id="daterange" />
                    </div>                    
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
 --}%            <div class="control-group">
                <label class="control-label">
                    <g:message code="user.name.label" default="Adults" />:
                </label>
                <div class="controls">
                    <div class="input-prepend">
                        <span class="add-on"><i class="icon-user"></i></span>
                        <input name="adults" type="text" placeholder="Enter adults" />
                    </div>
                </div>
            </div>
            <div class="control-group">
                <label class="control-label">
                    <g:message code="user.name.label" default="RoomCategory" />:
                </label>
                <div class="controls">
                    <g:select name="roomCategory" from="${roomCategoryInstanceList}" optionKey="id" optionValue="name"/>
                </div>
            </div>
            <g:remoteLink action="checkReservation"
                params="[from: '2012-07-29', to: '2012-07-31', adults: 2]" onSuccess="alert(data.status)">Check!</g:remoteLink>
                <!-- \$('#checkReservationStatus').val(data.status) -->
            <div id="checkReservationStatus"></div>
        </div>
    </div>
    <div class="modal-footer">
        <button class="btn" data-dismiss="modal">Close</button>
        <button type="submit" class="btn btn-primary">Create</button>
    </div>
    </g:form>
</div>
<r:script>
$('#daterange').daterangepicker();
</r:script>
<!-- End Add Reservation -->

</content>

<content tag="sidemenu">
<g:render template="/templates/userNavigation"/>
</content>

</g:applyLayout>


