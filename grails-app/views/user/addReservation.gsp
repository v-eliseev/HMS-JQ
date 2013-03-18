<g:applyLayout name="threeblocks">
<head>
<title><g:message code="title.superuser.index" /></title>
</head>

<content tag="top"> 
<ul>
    <li><g:link action="addReservation">Add reservation...</g:link></li>
</ul>
</content>

<content tag="main">
    <div>
        <g:form action="doAddReservation" method="POST">
            <div class="control-group">
                <label class="control-label">
                    <g:message code="user.name.label" default="From" />:
                </label>
                <div class="controls">
                    <input type="text" placeholder="Enter from date" value="${reservationInstance?.fromDate}">
                </div>
            </div>
            <div class="control-group">
                <label class="control-label">
                    <g:message code="user.name.label" default="To" />:
                </label>
                <div class="controls">
                    <input type="text" placeholder="Enter to date" value="${reservationInstance?.toDate}">
                </div>
            </div>
            <div class="control-group">
                <label class="control-label">
                    <g:message code="user.name.label" default="Adults" />:
                </label>
                <div class="controls">
                    <input type="text" placeholder="Enter adults" value="${reservationInstance?.adults}">
                </div>
            </div>
            <g:remoteLink action="checkReservation"
                params="[from: '2012-07-29', to: '2012-07-31', adults: 2]" onSuccess="alert(data.status)">Check!</g:remoteLink>
                <!-- \$('#checkReservationStatus').val(data.status) -->
            <div id="checkReservationStatus"></div>
            <g:submitButton name="Add" />
        </g:form>
    </div>
</content>

<content tag="sidemenu">
    <ul>
        <li><g:link action="showUsers">Show users</g:link></li>
        <li><g:link action="showStatistics">Show statistics</g:link></li>
    </ul>
</content>

</g:applyLayout>
