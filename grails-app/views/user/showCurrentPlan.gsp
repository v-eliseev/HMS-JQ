<%@ page import="roomplanner.PlanHelper" %>
<%@ page import="hms.ReservationStatus" %>
<%@ page import="org.joda.time.DateTime" %>

<g:applyLayout name="threeblocks">
<head>
<title><g:message code="title.superuser.index" /></title>
<r:require module="daterangepicker"/>
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
	<table class="table table-bordered table-condensed">
	<thead>
		<tr>
			<td>Room</td>
			<g:each var="day" in="${planningWindow}">
				<td colspan="1"><small><g:formatDate format="dd.MM" date="${day.toDate()}"/></small></td>
			</g:each>
		</tr>
	</thead>
	<tbody>
		<%
			def roomAssignments = PlanHelper.getRoomAssignments(rooms, planningWindow.first(), planningWindow.last(), plan.roomAssignments.asList())
		%>
	<g:each var="room" in="${rooms}" status="i">
	<tr>
		<td>
			<span id="po_room${room.id}">
				${room.name} [${room.id}]
			</span>
		</td>
		<g:each var="roomAssignment" in="${roomAssignments[room]}">
		<% 
			def colspan = 1
			def color = "btn-success"
			def constraints = []
			if (roomAssignment != null) {
				colspan = roomAssignment.toDate - roomAssignment.fromDate
				// select color
				switch(roomAssignment.status.code) {
					case ReservationStatus.StatusCode.CHECKED_OUT:
						color = "btn-default"
						break
					case ReservationStatus.StatusCode.CHECKED_IN:
						color = "btn-primary"
						break
					case ReservationStatus.StatusCode.PLANNED:
						
						break
				}
				constraints = plan.constraintMatches.findAll { it.roomAssignment.reservationId == roomAssignment.id }
			}


		%>
			<g:if test="${roomAssignment != null}">
				<td colspan="${colspan}">
					<g:link id="po_ra${roomAssignment.id}" elementId="po_ra${roomAssignment.id}" style="button" class="btn btn-block $color">
						${roomAssignment.id} 
						<g:if test="${constraints.size()>0}">
						<span class="label label-warning pull-right">${constraints.size()}</span>
						</g:if>
					</g:link>
				</td>
			</g:if>
			<g:else>
				<td></td>
			</g:else>
		</g:each>
	</tr>
	</g:each>
	
	</tbody>
	</table>


</div>
</div>

<script type='text/javascript'>
$(document).ready(function() {
	$('#planningrange').daterangepicker(
	{
    	ranges: {
	        'Today': [moment(), moment()],
	        'Yesterday': [moment().subtract('days', 1), moment().subtract('days', 1)],
	        'Last 7 Days': [moment().subtract('days', 6), moment()],
	        'Last 30 Days': [moment().subtract('days', 29), moment()],
	        'This Month': [moment().startOf('month'), moment().endOf('month')],
	        'Last Month': [moment().subtract('month', 1).startOf('month'), moment().subtract('month', 1).endOf('month')]
    	}	
    },
    function(start, end) {
      $('#planningrange span').html(start.format('MMMM D, YYYY') + ' - ' + end.format('MMMM D, YYYY'));
    });
	
	$('#planningrange span').html(moment().subtract('days', 29).format('MMMM D, YYYY') + ' - ' + moment().format('MMMM D, YYYY'));

	<g:each var="room" in="${rooms}">
	$('#po_room${room.getId()}').popover({
		trigger: 'hover',
		html: true,
		delay: { show: 500, hide: 100 },
		content: '<ul class="list-unstyled"><li>${room.roomCategory.name} [${room.roomCategory.id}]</li><li>Bed count: ${room.adults}</li></ul>'
 	});
	</g:each>	

 	<g:each var="roomAssignmentList" in="${roomAssignments}">
 	<g:each var="roomAssignment" in="${roomAssignmentList.value}">
 		<g:if test="${roomAssignment != null}">
			$('#po_ra${roomAssignment.getId()}').popover({
				trigger: 'hover',
				html: true,
				delay: { show: 500, hide: 100 },
				content: '<ul class="list-unstyled"><li>Guests: ${roomAssignment.adults}</li><li>Room type: ${roomAssignment.roomCategory.name} [${roomAssignment.roomCategory.id}]</li></ul>'
			});
		</g:if>
	</g:each>
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
