<g:applyLayout name="threeblocks">

<head>
<title><g:message code="title.admin.users" /></title>
</head>

<content tag="top">
<ul>
    <li><g:link action="addReservation">Add reservation...</g:link></li>
</ul>
</content>

<content tag="main">
<h4>Reservations</h4>
<ul>
    <g:each in="${reservationInstanceList}" status="i" var="reservationInstance">
    <li>
        <g:link controller="reservation" action="show"
            id="${reservationInstance.id}">
            ${fieldValue(bean: reservationInstance, field: "rooms")}</g:link>
            (${reservationInstance.fromDate}--${reservationInstance.toDate}])
    </li>
    </g:each>
</ul>
</content>

<content tag="sidemenu">
<g:render template="/templates/adminNavigation"/>
</content>

</g:applyLayout>