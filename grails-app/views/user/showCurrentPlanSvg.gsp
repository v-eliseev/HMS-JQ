<%@ page import="roomplanner.PlanHelper" %>
<%@ page import="hms.ReservationStatus" %>
<%@ page import="org.joda.time.DateTime" %>

<g:applyLayout name="threeblocks">
<head>
<title><g:message code="title.superuser.index" /></title>
<asset:stylesheet src="daterangepicker/daterangepicker-bs3.css"/>
<asset:javascript src="daterangepicker.js"/>
</head>

<content tag="top">
</content>

<content tag="main">
<div class="row show-grid">
<div class="col-lg-12">
	<ul class="breadcrumb">
	  <li><a href="index">Home</a></li>
	  <li class="active">Hotel plan</li>
	</ul>	
    <h2>Hotel plan 
     	<small>
    		[Feasible: ${score.feasible} 
    		Score: ${score.hard}/${score.soft}]
    	</small>
		<small id="planningrange" class="pull-right">
			<i class="icon-calendar icon-large"></i>
    		<span></span>
		</small>
    </h2>
    <div id="canvas_container"></div>

</div>
</div>

<asset:javascript src="planningboard/planningboard.js"/>

<script type='text/javascript'>
$(document).ready(function() {
	$('#planningrange').daterangepicker(
	{
    	ranges: {
	        'Today': [moment(), moment()],
	        'Yesterday': [moment().subtract(1, 'days'), moment().subtract(1, 'days')],
	        'Last 7 Days': [moment().subtract(6, 'days'), moment()],
	        'Last 30 Days': [moment().subtract(29, 'days'), moment()],
	        'This Month': [moment().startOf('month'), moment().endOf('month')],
	        'Last Month': [moment().subtract(1, 'month').startOf('month'), moment().subtract(1, 'month').endOf('month')]
    	}	
    },
    function(start, end) {
      $('#planningrange span').html(start.format('MMMM D, YYYY') + ' - ' + end.format('MMMM D, YYYY'));
    });
	
	$('#planningrange span').html(moment('${firstDate}').format('MMMM D, YYYY') + ' - ' + moment('${lastDate}').format('MMMM D, YYYY'));

    $('#canvas_container').planningboard({
        rooms: '${raw(allRoomsJSON)}',
        reservations: '${raw(displayReservationsJSON)}',
        roomAssignments: '${raw(displayRoomAssignmentsJSON)}',
        reservationStatusList: '${raw(reservationStatusListJSON)}',
        constraintMatches: '${raw(constraintMatchesJSON)}',
        firstDate: moment('${firstDate}'),
        lastDate: moment('${lastDate}')
    });

    <g:each var="room" in="${allRooms}">
    $('#po_room_${room.id}').popover({
        container: 'body',
        trigger: 'hover',
        html: true,
        delay: { show: 500, hide: 100 },
        content: '<ul class="list-unstyled"><li>${room.roomCategory.name} [${room.roomCategory.id}]</li><li>Bed count: ${room.adults}</li></ul>'
    });
    </g:each>   

    <g:each var="roomAssignment" in="${displayRoomAssignments}">
    <%
        def reservation = displayReservations.find { it.id == roomAssignment.reservationId }
        def constraints = constraintMatches.findAll { it.roomAssignment.id == roomAssignment.id }
    %>
    $('#po_ra_${roomAssignment.id}').popover({
        container: 'body',
        trigger: 'hover',
        html: true,
        delay: { show: 500, hide: 100 },
        content: '<ul class="list-unstyled"><li>${reservation.roomCategory.name} [${reservation.roomCategory.id}]</li><li>Adults: ${reservation.adults}</li></ul>'
    });
    $('#po_cm_${roomAssignment.id}').popover({
        container: 'body',
        trigger: 'hover',
        html: true,
        delay: { show: 500, hide: 100 },
        content: '<ul class="list-unstyled"><g:each var="cm" in="${constraints}"><li>${cm.rule} [${cm.weight}]</li></g:each></ul>'
    });
    </g:each>
});
</script>
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
