<!DOCTYPE html> 
<html> 
<head>
	<title>Request</title>
</head> 
<body> 

<div data-role="page">

	<div data-role="header">
		<h1>Reservation Request</h1>
	</div><!-- /header -->

	<div data-role="content">
	<form>
		<div data-role="fieldcontain">
			<label for="fromDate">From:</label>
			<input type="text" name="fromDate" id="fromDate" value="${fromDate}" />
			<label for="toDate">To:</label>
			<input type="text" name="toDate" id="toDate" value="${toDate}" />
			<label for="guests">Guests:</label>
			<input type="number" name="guests" id="guests" value="${guests}" min="1" max="4"/>
		</div>
		<g:actionSubmit action="listAvailableRoomTypes" value="Check!"/>
	</form>			
	</div><!-- /content -->

	<div data-role="footer">
		<h4>Page Footer</h4>
	</div><!-- /footer -->

</div><!-- /page -->

</body>
</html>