
<%@ page import="hms.Reservation" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'reservation.label', default: 'Reservation')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-reservation" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-reservation" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list reservation">
			
				<g:if test="${reservationInstance?.distributionChannel}">
				<li class="fieldcontain">
					<span id="distributionChannel-label" class="property-label"><g:message code="reservation.distributionChannel.label" default="Distribution Channel" /></span>
					
						<span class="property-value" aria-labelledby="distributionChannel-label"><g:link controller="distributionChannel" action="show" id="${reservationInstance?.distributionChannel?.id}">${reservationInstance?.distributionChannel?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${reservationInstance?.reservationMotive}">
				<li class="fieldcontain">
					<span id="reservationMotive-label" class="property-label"><g:message code="reservation.reservationMotive.label" default="Reservation Motive" /></span>
					
						<span class="property-value" aria-labelledby="reservationMotive-label"><g:link controller="reservationMotive" action="show" id="${reservationInstance?.reservationMotive?.id}">${reservationInstance?.reservationMotive?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${reservationInstance?.reservationType}">
				<li class="fieldcontain">
					<span id="reservationType-label" class="property-label"><g:message code="reservation.reservationType.label" default="Reservation Type" /></span>
					
						<span class="property-value" aria-labelledby="reservationType-label"><g:link controller="reservationType" action="show" id="${reservationInstance?.reservationType?.id}">${reservationInstance?.reservationType?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${reservationInstance?.reservationStatus}">
				<li class="fieldcontain">
					<span id="reservationStatus-label" class="property-label"><g:message code="reservation.reservationStatus.label" default="Reservation Status" /></span>
					
						<span class="property-value" aria-labelledby="reservationStatus-label"><g:link controller="reservationStatus" action="show" id="${reservationInstance?.reservationStatus?.id}">${reservationInstance?.reservationStatus?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${reservationInstance?.cancellationReason}">
				<li class="fieldcontain">
					<span id="cancellationReason-label" class="property-label"><g:message code="reservation.cancellationReason.label" default="Cancellation Reason" /></span>
					
						<span class="property-value" aria-labelledby="cancellationReason-label"><g:link controller="cancellationReason" action="show" id="${reservationInstance?.cancellationReason?.id}">${reservationInstance?.cancellationReason?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${reservationInstance?.notes}">
				<li class="fieldcontain">
					<span id="notes-label" class="property-label"><g:message code="reservation.notes.label" default="Notes" /></span>
					
						<span class="property-value" aria-labelledby="notes-label"><g:fieldValue bean="${reservationInstance}" field="notes"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${reservationInstance?.articles}">
				<li class="fieldcontain">
					<span id="articles-label" class="property-label"><g:message code="reservation.articles.label" default="Articles" /></span>
					
						<g:each in="${reservationInstance.articles}" var="a">
						<span class="property-value" aria-labelledby="articles-label"><g:link controller="article" action="show" id="${a.id}">${a?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
				<g:if test="${reservationInstance?.customers}">
				<li class="fieldcontain">
					<span id="customers-label" class="property-label"><g:message code="reservation.customers.label" default="Customers" /></span>
					
						<g:each in="${reservationInstance.customers}" var="c">
						<span class="property-value" aria-labelledby="customers-label"><g:link controller="customer" action="show" id="${c.id}">${c?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
				<g:if test="${reservationInstance?.dateCreated}">
				<li class="fieldcontain">
					<span id="dateCreated-label" class="property-label"><g:message code="reservation.dateCreated.label" default="Date Created" /></span>
					
						<span class="property-value" aria-labelledby="dateCreated-label"><g:formatDate date="${reservationInstance?.dateCreated}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${reservationInstance?.fromDate}">
				<li class="fieldcontain">
					<span id="fromDate-label" class="property-label"><g:message code="reservation.fromDate.label" default="From Date" /></span>
					
						<span class="property-value" aria-labelledby="fromDate-label"><g:formatDate date="${reservationInstance?.fromDate}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${reservationInstance?.lastUpdated}">
				<li class="fieldcontain">
					<span id="lastUpdated-label" class="property-label"><g:message code="reservation.lastUpdated.label" default="Last Updated" /></span>
					
						<span class="property-value" aria-labelledby="lastUpdated-label"><g:formatDate date="${reservationInstance?.lastUpdated}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${reservationInstance?.rooms}">
				<li class="fieldcontain">
					<span id="rooms-label" class="property-label"><g:message code="reservation.rooms.label" default="Rooms" /></span>
					
						<g:each in="${reservationInstance.rooms}" var="r">
						<span class="property-value" aria-labelledby="rooms-label"><g:link controller="room" action="show" id="${r.id}">${r?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
				<g:if test="${reservationInstance?.toDate}">
				<li class="fieldcontain">
					<span id="toDate-label" class="property-label"><g:message code="reservation.toDate.label" default="To Date" /></span>
					
						<span class="property-value" aria-labelledby="toDate-label"><g:formatDate date="${reservationInstance?.toDate}" /></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${reservationInstance?.id}" />
					<g:link class="edit" action="edit" id="${reservationInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
