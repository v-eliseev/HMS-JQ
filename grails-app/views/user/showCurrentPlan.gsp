<%@ page import="roomplanner.PlanHelper" %>
<g:applyLayout name="threeblocks">
<head>
<title><g:message code="title.superuser.index" /></title>
<r:require module="daterangepicker"/>
</head>

<content tag="top">
</content>

<content tag="main">
<div class="row-fluid show-grid">
<div class="span12">
	<ul class="breadcrumb">
	  <li><a href="index">Home</a></li>
	  <li class="active">Hotel plan</li>
	</ul>	
    <legend>Hotel plan 
     	<small>
    		[Feasible: ${plan.getScore().getFeasible()} 
    		Score: ${plan.getScore().getHard()}/${plan.getScore().getSoft()}]
    		<g:link action="newConfiguration">New configuration</g:link>
    	</small>
		<small id="planningrange" class="pull-right">
			<i class="icon-calendar icon-large"></i>
    		<span></span>
		</small>
    </legend>
	<table class="table table-bordered table-condensed">
	<thead>
		<tr>
			<td>Room</td>
			<td>Type</td>
			<td>Size</td>
			<g:each var="day" in="${planningWindow}">
				<td>${day.getDayOfMonth()}.${day.getMonthOfYear()}</td>
			</g:each>
		</tr>
	</thead>
	<tbody>
	<g:each var="room" in="${rooms}" status="i">
	<tr>
		<td>${room.getName()} [${room.getId()}]</td>
		<td>${room.getRoomCategory().getName()} [${room.getRoomCategory().getId()}]</td>
		<td>${room.getAdults()}
		<g:each var="day" in="${planningWindow}">
			<td>
			<g:each in="${PlanHelper.getReservation(day, room, plan.roomAssignments.asList())}">
			${it.getId()}&nbsp;
			</g:each>
			</td>
		</g:each>
	</tr>
	</g:each>
	
	</tbody>
	</table>


</div>
</div>

<r:script>
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
});
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
