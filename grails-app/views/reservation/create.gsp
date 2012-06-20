<%@ page contentType="text/html;charset=ISO-8859-1" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"/>
<meta name="layout" content="main"/>
<title>HMS -- Reservation Request</title>
</head>
<body>
<div class="body">
<span class="page-title">Reservation Request</span>
<!-- --> 		
<link rel="stylesheet" href="${resource(dir:'css',file:'form.css')}" />
<div class="message"></div>
<g:form name="reservationRequest" action="save">
<div id="reservationRequestForm">
<fieldset id="dates">
<legend>Dates</legend>
	<label for="roomCategory">Room Category</label>
	<g:select
    	name="roomCategory"
        value="${roomCategory?.id}"
        optionKey="id"
        optionValue="name"
        from="${roomCategoriesList}"
        noSelection="['':'-Choose category-']"
        class="selectlist"/>	
    <label for="fromDate">From</label>
    <g:textField
    	name="fromDate"
    	value="${initial.fromDate}"
    	class="textfield"/>
	<label for="toDate">To</label>
    <g:textField
    	name="toDate"
    	value="${initial.toDate}"
    	class="textfield"/>
	<label for="checkAvailability"></label>
	<button id="checkAvailability">Check availability!</button>
	<div id="display"></div>
</fieldset>
<fieldset id="guestInfo">
<legend>Guest Info</legend>
	<label for="name">Name</label>
	<g:textField 
		name="name" 
		value="${name}"
		class="textfield"/>

	<label for="reservationMotive">Motive</label>
	<g:select
    	name="reservationMotive"
        value="${reservationMotive?.id}"
        optionKey="id"
        optionValue="name"
        from="${reservationMotivesList}"
        noSelection="['':'-Choose motive-']"
        class="selectlist"/>	
	<label for="distributionChannel">Channel</label>
	<g:select
    	name="distributionChannel"
        value="${distributionChannel?.id}"
        optionKey="id"
        optionValue="name"
        from="${distributionChannelsList}"
        noSelection="['':'-Choose channel-']"
        class="selectlist"/>	
	<label for="notes">Notes</label>
	<g:textArea 
		name="notes" 
		value="${notes}" 
		class="textarea"/>
	
</fieldset>
<div id="buttonRow">
	<button type="submit" name="submitButton" value="Submit"><span>Submit</span></button>
</div>
</div>
</g:form>
<!-- --> 	
</div>

<script>
$(document).ready(function(){
  $( "#checkAvailability" ).button();
  $( "#checkAvailability" ).click(function() {
    var fromDate = $("input#fromDate").val();
    var toDate = $("input#toDate").val();
    var roomCategory = $("select#roomCategory").val();
    $.ajax({
      type: "POST",
	  url: "checkAvailabilityJSON", 
	  data: {roomCategory: roomCategory, fromDate: fromDate, toDate: toDate},
	  success: function(data){
		$("#display").html(data.status);
	  },
	  dataType: "json"
    });
    return false;
  });
	
  $( "#fromDate" ).datepicker({minDate: 0});
  $( "#toDate" ).datepicker({minDate: +1});
});
</script>

</body>
</html>