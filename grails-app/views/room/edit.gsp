<!DOCTYPE html> 
<html>
<head>
	<title>Edit Room</title>
</head>
<body>
<div class="body">
<h3>Edit Room</h3>
<g:form action="editRoom" id="${roomId}">
<fieldset>
	<legend>Room data</legend>
	<label for="name">Name:</label>
	<g:textField name="name" value="${roomName}"/>
	<label for="roomCategory">RoomCategory:</label>
	<g:select name="roomCategory" value="${roomCategory}" from="${roomCategories}" optionKey="id" optionValue="name"/>
</fieldset>
<g:submitButton name="editRoom" value="Save"></g:submitButton>
</g:form>
</div>
</body>
</html>