<g:applyLayout name="threeblocks">
<head>
<title><g:message code="title.admin.rooms" /></title>
</head>

<content tag="top"> 
</content>

<content tag="main"> 
    <legend>Reservation Board</legend>
    <table class="table table-striped table-condensed">
    <thead>
        <tr>
        	<td>&nbsp;</td>
		    <g:each in="${dates}" status="i" var="date">
		    	<td><small><g:formatDate format="EEE, yyyy-MM-dd" date="${date}"/></small></td>
			</g:each>
        </tr>
    </thead>
    <tbody>
    <g:each in="${roomInstanceList}" status="i" var="roomInstance">
        <tr>
            <td><code>${fieldValue(bean: roomInstance, field: "name")}</code></td>
            <td colspan="${dates.size()}">
            	<div id="container">
            	</div>
            </td>
        </tr>
    </g:each>
    </tbody>
    </table>
</content>

<content tag="sidemenu">
<g:render template="/templates/userNavigation"/>
</content>

</g:applyLayout>