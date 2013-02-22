<%@ page import="roomplanner.PlanHelper" %>
<!DOCTYPE html>
<html>
<head>
<title>Hotel Plan</title>
<style>
td { border: 1px solid gray; }
</style>
</head>
<body>
	<div class="body">
		<h3>Hotel Plan</h3>

		<p>Feasible: ${plan.getScore().getFeasible()}</p>
		<p>Score: ${plan.getScore().getHard()}/${plan.getScore().getSoft()}</p>
		
		<g:link action="newConfiguration">New configuration</g:link>
		
		<table>
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
				<td>${room.getId() }</td>
				<td>${room.getRoomCategory().getId() }</td>
				<td>${room.getAdults() }
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
</body>
</html>