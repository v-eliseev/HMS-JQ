<g:applyLayout name="threeblocks">
<head>
<title><g:message code="title.admin.rooms" /></title>
<r:require module="daterangepicker"/>
</head>

<content tag="top"> 
</content>

<content tag="main"> 
    <legend>Reservation Board</legend>
    <div id="reportrange" class="pull-right">
        <i class="icon-calendar icon-large"></i>
            <span>
                <g:formatDate format="yyyy-MM-dd" date="${dates.first()}"/>
                &nbsp;-&nbsp;
                <g:formatDate format="yyyy-MM-dd" date="${dates.last()}"/>
            </span> <b class="caret"></b>
    </div>
    <div id="status" class="pull-right">
    </div>

    <table class="table table-striped table-condensed">
    <thead>
        <tr>
        	<td>&nbsp;</td>
		    <g:each in="${dates}" status="i" var="date">
		    	<td><small><g:formatDate format="EEE, yyyy-MM-dd" date="${date}"/></small></td>
			</g:each>
        </tr>
    </thead>
    <tbody>
    <g:each in="${roomInstanceList}" status="i" var="roomInstance">
        <tr>
            <td><code>${fieldValue(bean: roomInstance, field: "name")}</code></td>
            <td colspan="${dates.size()}">
            	<div id="container">
            	</div>
            </td>
        </tr>
    </g:each>
    </tbody>
    </table>

<script type='text/javascript'>
$('#reportrange').daterangepicker(
    {
        ranges: {
            'Next 7 Days': [Date.today().add({ days: -1 }), Date.today().add({ days: 6 }),],
            'Next 30 Days': [Date.today().add({ days: -1 }), Date.today().add({ days: 30 }),],
            'This Month': [Date.today().moveToFirstDayOfMonth(), Date.today().moveToLastDayOfMonth()]
        }
    },
    function(start, end) {
        $('#reportrange span').html(start.toString('yyyy-MM-dd') + ' - ' + end.toString('yyyy-MM-dd'));

        $.ajax({
            url: "${g.createLink(controller:'reservationBoard',action:'indexJSON')}",
            dataType: 'json',            
            data: {
                fromDate: start.getTime(),
                toDate: end.getTime()
            },
            success: function( data ) {
                $('#status').html('Rooms: ' + data.roomInstanceList.length + ' Reservations: ' + data.reservationInstanceList.length);
            }
        });        
    }
);
</script>    
</content>

<content tag="sidemenu">
<g:render template="/templates/userNavigation"/>
</content>

</g:applyLayout>