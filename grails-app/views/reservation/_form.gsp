<%@ page import="hms.Reservation" %>



<div class="fieldcontain ${hasErrors(bean: reservationInstance, field: 'distributionChannel', 'error')} ">
	<label for="distributionChannel">
		<g:message code="reservation.distributionChannel.label" default="Distribution Channel" />
		
	</label>
	<g:select id="distributionChannel" name="distributionChannel.id" from="${hms.DistributionChannel.list()}" optionKey="id" value="${reservationInstance?.distributionChannel?.id}" class="many-to-one" noSelection="['null': '']"/>
</div>

<div class="fieldcontain ${hasErrors(bean: reservationInstance, field: 'reservationMotive', 'error')} ">
	<label for="reservationMotive">
		<g:message code="reservation.reservationMotive.label" default="Reservation Motive" />
		
	</label>
	<g:select id="reservationMotive" name="reservationMotive.id" from="${hms.ReservationMotive.list()}" optionKey="id" value="${reservationInstance?.reservationMotive?.id}" class="many-to-one" noSelection="['null': '']"/>
</div>

<div class="fieldcontain ${hasErrors(bean: reservationInstance, field: 'reservationType', 'error')} ">
	<label for="reservationType">
		<g:message code="reservation.reservationType.label" default="Reservation Type" />
		
	</label>
	<g:select id="reservationType" name="reservationType.id" from="${hms.ReservationType.list()}" optionKey="id" value="${reservationInstance?.reservationType?.id}" class="many-to-one" noSelection="['null': '']"/>
</div>

<div class="fieldcontain ${hasErrors(bean: reservationInstance, field: 'reservationStatus', 'error')} ">
	<label for="reservationStatus">
		<g:message code="reservation.reservationStatus.label" default="Reservation Status" />
		
	</label>
	<g:select id="reservationStatus" name="reservationStatus.id" from="${hms.ReservationStatus.list()}" optionKey="id" value="${reservationInstance?.reservationStatus?.id}" class="many-to-one" noSelection="['null': '']"/>
</div>

<div class="fieldcontain ${hasErrors(bean: reservationInstance, field: 'cancellationReason', 'error')} ">
	<label for="cancellationReason">
		<g:message code="reservation.cancellationReason.label" default="Cancellation Reason" />
		
	</label>
	<g:select id="cancellationReason" name="cancellationReason.id" from="${hms.CancellationReason.list()}" optionKey="id" value="${reservationInstance?.cancellationReason?.id}" class="many-to-one" noSelection="['null': '']"/>
</div>

<div class="fieldcontain ${hasErrors(bean: reservationInstance, field: 'notes', 'error')} ">
	<label for="notes">
		<g:message code="reservation.notes.label" default="Notes" />
		
	</label>
	<g:textField name="notes" value="${reservationInstance?.notes}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: reservationInstance, field: 'articles', 'error')} ">
	<label for="articles">
		<g:message code="reservation.articles.label" default="Articles" />
		
	</label>
	<g:select name="articles" from="${hms.Article.list()}" multiple="multiple" optionKey="id" size="5" value="${reservationInstance?.articles*.id}" class="many-to-many"/>
</div>

<div class="fieldcontain ${hasErrors(bean: reservationInstance, field: 'customers', 'error')} ">
	<label for="customers">
		<g:message code="reservation.customers.label" default="Customers" />
		
	</label>
	<g:select name="customers" from="${hms.Customer.list()}" multiple="multiple" optionKey="id" size="5" value="${reservationInstance?.customers*.id}" class="many-to-many"/>
</div>

<div class="fieldcontain ${hasErrors(bean: reservationInstance, field: 'fromDate', 'error')} required">
	<label for="fromDate">
		<g:message code="reservation.fromDate.label" default="From Date" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="fromDate" precision="day"  value="${reservationInstance?.fromDate}"  />
</div>

<div class="fieldcontain ${hasErrors(bean: reservationInstance, field: 'rooms', 'error')} ">
	<label for="rooms">
		<g:message code="reservation.rooms.label" default="Rooms" />
		
	</label>
	<g:select name="rooms" from="${hms.Room.list()}" multiple="multiple" optionKey="id" size="5" value="${reservationInstance?.rooms*.id}" class="many-to-many"/>
</div>

<div class="fieldcontain ${hasErrors(bean: reservationInstance, field: 'toDate', 'error')} required">
	<label for="toDate">
		<g:message code="reservation.toDate.label" default="To Date" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="toDate" precision="day"  value="${reservationInstance?.toDate}"  />
</div>

