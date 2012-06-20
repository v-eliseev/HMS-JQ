<%@ page contentType="text/html;charset=ISO-8859-1" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"/>
<meta name="layout" content="main"/>
<title>HMS -- My Property</title>
</head>
<body>
<div class="body">
<span class="page-title">My Property</span>
<!-- --> 		
<link rel="stylesheet" href="${resource(dir:'css',file:'form.css')}" />
<div class="message"></div>
<g:form id="${hotel.id}" action="save">
<div id="myPropertyForm">
<div class="col">
<fieldset id="contactInfo">
<legend>Contact Info</legend>
	<label for="name">Name</label>
	<input name="name" type="text" id="name" class="textfield" value="${hotel.name}"/>
	<label for="phone">Phone</label>
	<input name="phone" type="text" id="phone" class="textfield" value="${hotel.phone}"/>
	<label for="fax">Fax</label>
	<input name="fax" type="text" id="fax" class="textfield" value="${hotel.fax}"/>
	<label for="eMail">E-Mail</label>
	<input name="eMail" type="text" id="eMail" class="textfield" value="${hotel.eMail}"/>
	<label for="webSite">Website</label>
	<input name="webSite" type="text" id="webSite" class="textfield" value="${hotel.webSite}"/>
</fieldset>
<fieldset id="registrationInfo">
<legend>Registration Info</legend>
	<label for="registrationNr">Registration Nr.</label>
	<input name="registrationNr" type="text" id="registrationNr" class="textfield" value="${hotel.registrationNr}"/>
	<label for="taxNr">Tax Nr.</label>
	<input name="taxNr" type="text" id="taxNr" class="textfield" value="${hotel.taxNr}"/>
</fieldset>
</div>
<div class="col">
<fieldset id="bankInfo">
<legend>Bank Info</legend>
	<label for="bankName">Bank name</label>
	<input name="bankName" type="text" id="bankName" class="textfield" value="${hotel.bankName}"/>
	<label for="bankCode">Bank Code</label>
	<input name="bankCode" type="text" id="bankCode" class="textfield" value="${hotel.bankCode}"/>
	<label for="accountNr">Account Nr.</label>
	<input name="accountNr" type="text" id="accountNr" class="textfield" value="${hotel.accountNr}"/>
	<label for="bicCode">BIC Code</label>
	<input name="bicCode" type="text" id="bicCode" class="textfield" value="${hotel.bicCode}"/>
	<label for="iban">IBAN</label>
	<input name="iban" type="text" id="iban" class="textfield" value="${hotel.iban}"/>
</fieldset>
<fieldset id="locationInfo">
<legend>Location Info</legend>
	<label for="countryCode">Country Code</label>
	<input name="countryCode" type="text" id="countryCode" class="textfield" value="${hotel.countryCode}"/>
</fieldset>
</div>
<div class="col">
<fieldset id="otherInfo">
<legend>Other</legend>
	<label for="invoicePrefix">Invoice Prefix</label>
	<input name="invoicePrefix" type="text" id="invoicePrefix" class="textfield" value="${hotel.invoicePrefix}"/>
	<label for="invoiceStartId">Invoice Start ID</label>
	<input name="invoiceStartId" type="text" id="invoiceStartId" class="textfield" value="${hotel.invoiceStartId}"/>
	<label for="invoiceSuffix">Invoice Suffix</label>
	<input name="invoiceSuffix" type="text" id="invoiceSuffix" class="textfield" value="${hotel.invoiceSuffix}"/>
</fieldset>
</div>
<div id="buttonRow">
	<button type="submit" name="submitButton" value="Submit"><span>Submit</span></button>
</div>
</div>
</g:form>
<!-- --> 	

<script type="text/javascript">
<!--
$(document).ready(function(){
  var options = { 
  	target: "#output",
    beforeSubmit: showRequest, 
    success: showResponse 
  };
  
  $('#myForm').submit(function() { 
    $(this).ajaxSubmit(options); 
    return false;
  }); 
});

function showRequest(formData, jqForm, options) { 
    var queryString = $.param(formData); 
    alert(queryString); 
    return true; 
} 
-->
</script>

</div>
</body>
</html>