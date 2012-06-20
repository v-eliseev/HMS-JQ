<%@ page contentType="text/html;charset=ISO-8859-1"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<meta name="layout" content="main" />
<title>HMS -- Reservation List</title>
</head>
<body>
	<div class="body">
		<span class="page-title">Reservation list</span>
		<!-- -->
		<link rel="stylesheet" href="${resource(dir:'css',file:'form.css')}" />
		<div class="message"></div>
		<!-- -->
		<table>
			<thead>
				<tr>
					<g:sortableColumn property="id"
						title="Id" />
					<g:sortableColumn property="dateFrom"
						title="From" />
					<g:sortableColumn property="dateTo"
						title="To" />
					<g:sortableColumn property="name"
						title="Guest Name" />
					<g:sortableColumn property="status"
						title="Status" />
				</tr>
			</thead>
			<tbody>
				<g:each in="${dataList}" status="i" var="item">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
						<td><g:link action="show" id="${item.id}">
								${fieldValue(bean: item, field: "id")}
							</g:link></td>
						<td>${item.fromDate}</td>
						<td>${item.toDate}</td>
						<td>xxx</td>
						<td>${item.reservationStatus?.name}</td>
					</tr>
				</g:each>
			</tbody>
		</table>
		
		<g:link elementId="newReservation" action="create">New</g:link>

<script type="text/javascript">
<!--
$( "#newReservation" ).button();
-->
</script>

	</div>
</body>
</html>