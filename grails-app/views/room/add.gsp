<!DOCTYPE html> 
<html>
<head>
	<title>Add Room(s)</title>
</head>
<body>
<div class="body">
<h3>Add Room(s)</h3>
<g:form action="addRoom">
<fieldset>
	<legend>Room data</legend>
	<label for="name">Name:</label>
	<g:textField name="name" value=""/>
	<label for="roomCategory">RoomCategory:</label>
	<g:select name="roomCategory" from="${roomCategories}" optionKey="id" optionValue="name"/>
</fieldset>
<g:submitButton name="addRoom" value="Add"></g:submitButton>
</g:form>
</div>
</body>
</html>