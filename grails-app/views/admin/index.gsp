<g:applyLayout name="threeblocks">
<head>
<title><g:message code="title.superuser.index" /></title>
</head>

<content tag="top"> 
</content>

<content tag="main">
<div>
    <legend>License</legend>
    <ul class="unstyled">
        <li>Key: ${fieldValue(bean: licenseInstance, field: "key")}</li> 
        <li>Issued: <g:formatDate date="${licenseInstance.issued}" /></li> 
        <li>Expires: <g:formatDate date="${licenseInstance.expires}" /></li> 
        <li>Days left: ${licenseInstance.expires-licenseInstance.issued}</li>
    </ul>
</div> 
</content>

<content tag="sidemenu">
<g:render template="/templates/adminNavigation"/>
</content>

</g:applyLayout>
