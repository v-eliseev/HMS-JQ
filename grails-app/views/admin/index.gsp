<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<meta name="layout" content="main" />
<title>Administrator page</title>
</head>
<body>
	<div class="body">
		<div class="nav" role="navigation">
			<ul>
				<li><g:link action="changePassword">Change password</g:link></li>
			</ul>
		</div>

		<div>
			<h4>License</h4>
			Key:
			${fieldValue(bean: licenseInstance, field: "key")}<br> Issued:
			<g:formatDate date="${licenseInstance.issued}" />
			<br> Expires:
			<g:formatDate date="${licenseInstance.expires}" />
			<br> Days left:
			${licenseInstance.expires-licenseInstance.issued}

			<h4>Hotel</h4>
			<g:link controller="hotel" action="show" id="${hotelInstance.id}">
				${fieldValue(bean: hotelInstance, field: "name")}
			</g:link>

			<h4>Room Categories</h4>
			<ul>
				<g:each in="${roomCategoryInstanceList}" status="i"
					var="roomCategoryInstance">
					<li><g:link controller="roomCategory" action="show"
							id="${roomCategoryInstance.id}">
							${fieldValue(bean: roomCategoryInstance, field: "name")}
						</g:link></li>
				</g:each>
			</ul>
			<g:link action="addRoomCategory">Add room category...</g:link>

			<h4>Users</h4>
			<g:if test="${!userInstanceList.empty}">
				<table>
					<thead>
						<tr>
							<g:sortableColumn property="username"
								title="${message(code: 'license.key.label', default: 'Name')}" />
							<g:sortableColumn property="enabled"
								title="${message(code: 'license.demoMode.label', default: 'Enabled')}" />
							<g:sortableColumn property="accountExpired"
								title="${message(code: 'license.expires.label', default: 'Account Expired')}" />
							<g:sortableColumn property="accountLocked"
								title="${message(code: 'license.demoMode.label', default: 'Account Locked')}" />
							<g:sortableColumn property="passwordExpired"
								title="${message(code: 'license.expires.label', default: 'Password Expired')}" />
							<g:sortableColumn property="authorities"
								title="${message(code: 'license.expires.label', default: 'Authorities')}" />
						</tr>
					</thead>
					<tbody>
						<g:each in="${userInstanceList}" status="i" var="userInstance">
							<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
								<td><g:link controller="user" action="show"
										id="${userInstance.id}">
										${fieldValue(bean: userInstance, field: "username")}
									</g:link></td>
								<td><g:formatBoolean boolean="${userInstance.enabled}" /></td>
								<td><g:formatBoolean
										boolean="${userInstance.accountExpired}" /></td>
								<td><g:formatBoolean
										boolean="${userInstance.accountLocked}" /></td>
								<td><g:formatBoolean
										boolean="${userInstance.passwordExpired}" /></td>
								<td><g:each in="${userInstance.getAuthorities()}"
										status="j" var="roleInstance">
										${roleInstance.authority}&nbsp;
							</g:each></td>
							</tr>
						</g:each>
					</tbody>
				</table>
				<g:link action="createUser">New user...</g:link>
			</g:if>
		</div>

		<h4>Reservations</h4>
		<ul>
			<g:each in="${reservationInstanceList}" status="i"
				var="reservationInstance">
				<li><g:link controller="reservation" action="show"
						id="${reservationInstance.id}">
						${fieldValue(bean: reservationInstance, field: "rooms")}
					</g:link>(${reservationInstance.fromDate}--${reservationInstance.toDate}])</li>
			</g:each>
		</ul>
		<g:link action="addReservation">Add reservation...</g:link>

	</div>
</body>
</html>