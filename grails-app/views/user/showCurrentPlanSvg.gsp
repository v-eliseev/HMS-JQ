<%@ page import="roomplanner.PlanHelper" %>
<%@ page import="hms.ReservationStatus" %>
<%@ page import="org.joda.time.DateTime" %>

<g:applyLayout name="threeblocks">
<head>
<title><g:message code="title.superuser.index" /></title>
<r:require modules="raphael, daterangepicker, planningboard"/>
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

    $('#canvas_container').planningboard({
        planningWindow: ${planningWindow},
        rooms: ${rooms},
        plan: ${plan}
    });

%{-- 	// define base dimensions
    var headerHeight = 30;
    rowHeight = 24
	var width = $('#canvas_container').width();
	var height = ${rooms.size()}*rowHeight + headerHeight;
    var cellWidth = Math.floor((width - 140)/30);
    var firstColWidth = width - 30*cellWidth;
	var paper = new Raphael(document.getElementById('canvas_container'), width, height); 
	paper.rect(0,0,width,height,5).attr(
	{
        "fill":"#f5f5f5",
        "stroke":"#999999"
	});


    paper.text(10, Math.floor(headerHeight/2), "Rooms").attr(
    {
        "font-family":"arial", 
        "font-size":"14",
        "text-anchor":"start"
    });
    <g:each var="day" in="${planningWindow}" status="i">
        paper.path("M"+eval(2*${i}*cellWidth+firstColWidth)+" 0L"+eval(2*${i}*cellWidth+firstColWidth)+" "+height+
            "M"+eval((2*${i}+1)*cellWidth+firstColWidth)+" "+Math.floor(headerHeight/2)+"L"+eval((2*${i}+1)*cellWidth+firstColWidth)+" "+height).attr(
        {
            "stroke":"#999999",
            "stroke-width":"1"
        });
        paper.text(eval((2*${i}+1)*cellWidth+firstColWidth), Math.floor(headerHeight/4), "<g:formatDate format="dd.MM" date="${day.toDate()}"/>");
   </g:each>
	<g:each var="room" in="${rooms}" status="i">
		paper.text(10, (rowHeight*${i}+Math.floor(rowHeight/2)+headerHeight), "${room.name} [${room.id}]").attr(
        {
            "font-family":"arial", 
            "font-size":"14",
            "text-anchor":"start"
        });
	</g:each> --}%
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
