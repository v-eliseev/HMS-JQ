<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<meta name="layout" content="main" />
<title>Room category</title>
</head>
<body>
	<div class="body">
		<h3>Room category</h3>
			Name: ${fieldValue(bean: roomCategoryInstance, field: "name")}
			
		<h4>Room features</h4>
		<ul>
			<g:each in="${roomFeatureInstanceList}" status="i"
				var="roomFeatureInstance">
				<li><g:link controller="roomFeature" action="show"
						id="${roomFeatureInstance.id}">
						${fieldValue(bean: roomFeatureInstance, field: "name")}
					</g:link></li>
			</g:each>
		</ul>
		<g:link action="addRoomFeature">Add room feature...</g:link>

		<h4>Rooms</h4>
		<ul>
			<g:each in="${roomInstanceList}" status="i"
				var="roomInstance">
				<li><g:link controller="room" action="show"
						id="${roomInstance.id}">
						${fieldValue(bean: roomInstance, field: "name")}
					</g:link></li>
			</g:each>
		</ul>
		<g:link controller="room" action="createNew">Add room ...</g:link>
	</div>
</body>
</html>