<%@ page import="hms.License" %>

<g:applyLayout name="threeblocks">
<head>
<title><g:message code="title.superuser.licenses" /></title>
</head>

<content tag="top"> 
</content>

<content tag="main"> 
    <legend>Licenses</legend>
    <table class="table table-striped table-condensed">
    <thead>
        <tr>
            <g:sortableColumn property="key"
                title="${message(code: 'license.key.label', default: 'Key')}" />
            <g:sortableColumn property="mode"
                title="${message(code: 'license.demoMode.label', default: 'Mode')}" />
            <g:sortableColumn property="expires"
                title="${message(code: 'license.expires.label', default: 'Expires')}" />
        </tr>
    </thead>
    <tbody>
    <g:each in="${licenseInstanceList}" status="i" var="licenseInstance">
        <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
            <td>
                <g:link action="showLicense" id="${licenseInstance.id}">
                    <code>${fieldValue(bean: licenseInstance, field: "key")}</code>
                </g:link>
            </td>
            <td>
                <g:if test="${licenseInstance.mode == License.LicenseMode.DEMO}">
                    <span class="label label-warning">Demo</span>
                </g:if>
                <g:else>
                    <span class="label label-success">Production</span>
                </g:else>
            </td>
            <td><g:formatDate date="${licenseInstance.expires}" /></td>
        </tr>
    </g:each>
    </tbody>
    </table>

    <div class="btn-group">
        <g:link action="createStandardLicense" class="btn btn-primary">Create license</g:link>
        <button type="button" class="btn btn-primary dropdown-toggle" data-toggle="dropdown"><span class="caret"></span></button>
        <ul class="dropdown-menu" role="menu">
            <li><g:link action="createStandardLicense">Create standard license</g:link></li>
            <li><g:link action="createDemoLicense">Create demo license</g:link></li>
        </ul>
    </div>

</content>

<content tag="sidemenu">
    <li><g:link action="showLicenses">Show licences</g:link></li>
    <li><g:link action="showApplicationStatus">Show application status</g:link></li>
    <li><g:link action="showStatistics">Show statistics</g:link></li>
    <li><g:link action="cleanup">Cleanup</g:link></li>
</content>

</g:applyLayout>
