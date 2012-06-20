<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<meta name="layout" content="main" />
<title>Hotels list</title>
</head>
<body>
	<div class="body">
		<h4>Hotels</h4>
		<ul>
			<g:each in="${hotelInstanceList}" status="i" var="hotelInstance">
				<li><g:link controller="hotel" action="show"
						id="${hotelInstance.id}">
						${fieldValue(bean: hotelInstance, field: "name")}
					</g:link></li>
			</g:each>
		</ul>
	</div>
</body>
</html>