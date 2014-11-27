<g:applyLayout name="twoblocks">

<head>
<title><g:message code="title.admin.users" /></title>
</head>

<content tag="top">
</content>

<content tag="main">
    <div class="row">
        <div class="col-lg-6">
			<g:form class="form-horizontal" role="form" action="update" id="${hotelInstance?.id}" method="POST">
			<legend>Hotel data</legend>

			<ul id="tabs" class="nav nav-tabs">
				<li class="active"><a href="#basic" data-toggle="tab">Basic data</a></li>
				<li><a href="#registration" data-toggle="tab">Registration info</a></li>
				<li><a href="#bank" data-toggle="tab">Bank info</a></li>
				<li><a href="#location" data-toggle="tab">Location</a></li>
				<li><a href="#other" data-toggle="tab">Other</a></li>
			</ul>
			<div id="tabsContent" class="tab-content">
				<div class="tab-pane fade in active" id="basic">
			        <div class="form-group">
			            <label for="name" class="col-lg-4 control-label"><g:message code="hotel.name.label" default="Name" /></label>
			            <div class="col-lg-8">
			                <input type="text" class="form-control" id="name" name="name" placeholder="Enter name" value="${hotelInstance.name}">
			            </div>
					</div>		
					<div class="form-group">
					    <label class="col-lg-4 control-label" for="phone">Phone</label> 
						<div class="col-lg-8">
						    <input name="phone" type="text"	id="phone" class="form-control" placeholder="Enter phone" value="${hotelInstance.phone}" />
						</div>
					</div>
					<div class="form-group">
				    	<label class="col-lg-4 control-label" for="fax">Fax</label>
						<div class="col-lg-8">
				    		<input name="fax" type="text" id="fax" class="form-control" placeholder="" value="${hotelInstance.fax}" /> 
				    	</div>
				    </div>
					<div class="form-group">
				    	<label class="col-lg-4 control-label" for="eMail">E-Mail</label>
						<div class="col-lg-8">
							<input name="eMail" type="text" id="eMail" class="form-control" placeholder="" value="${hotelInstance.eMail}" />
						</div>
					</div>
					<div class="form-group">
						<label class="col-lg-4 control-label" for="webSite">Website</label>
						<div class="col-lg-8">
							<input name="webSite" type="text" id="webSite" class="form-control" placeholder="" value="${hotelInstance.webSite}" />
						</div>
					</div>
					</fieldset>
			 	</div>
				<div class="tab-pane fade" id="registration">
			 		<fieldset>
					<div class="form-group">
						<label class="col-lg-4 control-label" for="registrationNr">Registration Nr.</label> 
						<div class="col-lg-8">
							<input name="registrationNr" type="text" id="registrationNr" class="form-control" placeholder="" 
							value="${hotelInstance.registrationNr}" /> 
						</div>
					</div>
					<div class="form-group">
						<label class="col-lg-4 control-label" for="taxNr">Tax Nr.</label>
						<div class="col-lg-8">
							<input name="taxNr" type="text" id="taxNr" class="form-control" placeholder="" value="${hotelInstance.taxNr}" />
						</div>
					</div>
					</fieldset>
				</div>
				<div class="tab-pane fade" id="bank">
					sadfdsf
				</div>
				<div class="tab-pane fade" id="location">
					sadffdsg
				</div>
				<div class="tab-pane fade" id="other">
					asfasfgfs
				</div>
			</div>

			%{-- <div>
			<span class="page-title">My Property</span>
			<link rel="stylesheet" href="${resource(dir:'css',file:'form.css')}" />
			<div class="message"></div>
				<g:form id="${hotelInstance.id}" action="save">
				<div id="myPropertyForm">
					<div class="col">
						<fieldset id="contactInfo">
							<legend>Contact Info</legend>
							<label for="name">Name</label> 
							<input name="name" type="text"
								id="name" class="textfield" value="${hotelInstance.name}" /> 
						    <label for="phone">Phone</label> 
						    <input name="phone" type="text"
								id="phone" class="textfield" value="${hotelInstance.phone}" /> <label
								for="fax">Fax</label> <input name="fax" type="text" id="fax"
								class="textfield" value="${hotelInstance.fax}" /> <label for="eMail">E-Mail</label>
							<input name="eMail" type="text" id="eMail" class="textfield"
										value="${hotelInstance.eMail}" /> <label for="webSite">Website</label> <input
										name="webSite" type="text" id="webSite" class="textfield"
										value="${hotelInstance.webSite}" />
								</fieldset>
								<fieldset id="registrationInfo">
									<legend>Registration Info</legend>
									<label for="registrationNr">Registration Nr.</label> <input
										name="registrationNr" type="text" id="registrationNr"
										class="textfield" value="${hotelInstance.registrationNr}" /> <label
										for="taxNr">Tax Nr.</label> <input name="taxNr" type="text"
										id="taxNr" class="textfield" value="${hotelInstance.taxNr}" />
								</fieldset>
							</div>
							<div class="col">
								<fieldset id="bankInfo">
									<legend>Bank Info</legend>
									<label for="bankName">Bank name</label> <input name="bankName"
										type="text" id="bankName" class="textfield"
										value="${hotelInstance.bankName}" /> <label for="bankCode">Bank
										Code</label> <input name="bankCode" type="text" id="bankCode"
										class="textfield" value="${hotelInstance.bankCode}" /> <label
										for="accountNr">Account Nr.</label> <input name="accountNr"
										type="text" id="accountNr" class="textfield"
										value="${hotelInstance.accountNr}" /> <label for="bicCode">BIC
										Code</label> <input name="bicCode" type="text" id="bicCode"
										class="textfield" value="${hotelInstance.bicCode}" /> <label for="iban">IBAN</label>
									<input name="iban" type="text" id="iban" class="textfield"
										value="${hotelInstance.iban}" />
								</fieldset>
								<fieldset id="locationInfo">
									<legend>Location Info</legend>
									<label for="countryCode">Country Code</label> <input
										name="countryCode" type="text" id="countryCode" class="textfield"
										value="${hotelInstance.countryCode}" />
								</fieldset>
							</div>
							<div class="col">
								<fieldset id="otherInfo">
									<legend>Other</legend>
									<label for="invoicePrefix">Invoice Prefix</label> <input
										name="invoicePrefix" type="text" id="invoicePrefix"
										class="textfield" value="${hotelInstance.invoicePrefix}" /> <label
										for="invoiceStartId">Invoice Start ID</label> <input
										name="invoiceStartId" type="text" id="invoiceStartId"
										class="textfield" value="${hotelInstance.invoiceStartId}" /> <label
										for="invoiceSuffix">Invoice Suffix</label> <input
										name="invoiceSuffix" type="text" id="invoiceSuffix"
										class="textfield" value="${hotelInstance.invoiceSuffix}" />
								</fieldset>
							</div>
							<div id="buttonRow">
								<button type="submit" name="submitButton" value="Submit">
									<span>Submit</span>
								</button>
							</div>
						</div>
					</g:form>
					</div>
			 --}%	

                <div class="form-group">
                    <div class="col-lg-8 col-lg-offset-4">
                        <input type="hidden" name="id" value="${licenseInstance.id}"/>
                        <g:submitButton class="btn btn-primary" name="update" value="Update" />
                    </div>
                </div>

			</g:form>
			</div>

	        <div class="col-lg-6">
				<legend>Property</legend>
				<div class="col-lg-12">
				    <legend><i class="icon-signin"></i> Room categories</legend>
				    <div class="list-group">
				        <g:each in="${roomCategoryInstanceList}" status="i" var="roomCategoryInstance">
				            <g:link class="list-group-item" id="${roomCategoryInstance.id}">
				                <h5 class="list-group-item-heading"><span class="label label-default">${i+1}</span>&nbsp;Code: ${roomCategoryInstance.name}</h5>
				            </g:link>
				        </g:each>        
				    </div>
				</div>
			</div>		
</content>

</g:applyLayout>