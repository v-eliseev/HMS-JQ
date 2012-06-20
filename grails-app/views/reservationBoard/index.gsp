<%@ page contentType="text/html;charset=ISO-8859-1" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"/>
<meta name="layout" content="main"/>
<title>Reservation Board</title>
</head>
<body>
<div class="body">
<span class="page-title">Reservation Board</span>
<!-- --> 		
<link rel="stylesheet" href="${resource(dir:'css',file:'reservationBoard.css')}" />
<div class="message"></div>
<div id="filter">
Date: <input type="text" id="datepicker"/>
</div>
<div id="board">
<table>
<thead>
<tr>
<td>Room</td>
<g:each in="${model.dates}" var="date">
<td>${date}</td>
</g:each>
</tr>
</thead>
<g:each in="${model.rooms}" var="room">
<tr>
<td>${room.name}</td>
</tr>
</g:each>
</table>
</div>
<!-- --> 
<script type="text/javascript">
	$(function() {
		$( "#datepicker" ).datepicker({
			minDate: -1,
			onSelect: function(dateText, obj) {
				$.ajax({
					url:"${createLink(controller:'reservationBoard', action:'listReservationsJSON', params:['fromDate':dateText])}"
				})
			}
		});
	});
	$(document).ready(function() {
		$( "#datepicker" ).setDate("${model.fromDate}");
	});
</script>	
</div>
</body>
</html>