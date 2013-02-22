<g:applyLayout name="threeblocks">
<head>
<title><g:message code="title.superuser.index" /></title>
<r:require modules="togglebuttons, datepicker, bootbox"/>
</head>

<content tag="top">
    <li><g:link action="resetAdminPassword" id="${licenseInstance.id}">Reset Admin Password</g:link></li>
    <li><g:link action="deleteLicense" id="${licenseInstance.id}">Delete License</g:link></li>
</content>

<content tag="main">
    <g:form class="form-horizontal" action="#" method="POST">
        <fieldset>
            <legend>License data</legend>
            <g:if test="${licenseInstance?.key}">
                <div class="control-group">
                    <label class="control-label">
                        <g:message code="license.key.label" default="Key" />:
                    </label>
                    <div class="controls">
                        <span class="input-xlarge uneditable-input">
                            <g:fieldValue bean="${licenseInstance}" field="key"/>
                        </span>
                        <g:link class="btn btn-danger btn-small" 
                            action="delete" id="${licenseInstance.id}" elementId="deleteBtn">
                            <i class="icon-remove"></i>&nbsp;Delete
                        </g:link>
                        <r:script>
                            $("#deleteBtn").click(function(e) {
                                e.preventDefault();
                                bootbox.confirm("Are you sure?", function(confirmed) {
                                    console.log("Confirmed: "+confirmed);
                                });
                            });        
                        </r:script>
                    </div>
                </div>
            </g:if>
            <g:if test="${licenseInstance?.dateCreated}">
                <div class="control-group">
                    <label class="control-label">
                        <g:message code="license.key.label" default="Date created" />:
                    </label>
                    <div class="controls">
                        <span class="input-xlarge uneditable-input">
                            <g:fieldValue bean="${licenseInstance}" field="dateCreated"/>
                        </span>
                    </div>
                </div>
            </g:if>
            <g:if test="${licenseInstance?.email}">
                <div class="control-group">
                    <label class="control-label">
                        <g:message code="license.key.label" default="Admin e-mail" />:
                    </label>
                    <div class="controls">
                        <span class="input-xlarge uneditable-input">
                            <g:fieldValue bean="${licenseInstance}" field="email"/>
                        </span>
                        <g:link class="btn btn-primary btn-small" 
                            action="changeEmail" id="${licenseInstance.id}">
                            Change admin e-mail
                        </g:link>
                    </div>
                </div>
            </g:if>
            <g:if test="${licenseInstance?.demoMode != null}">
                <div class="control-group">
                    <label class="control-label">
                        <g:message code="license.key.label" default="Demo mode" />:
                    </label>
                    <div class="controls">
                        <span class="input-xlarge uneditable-input">
                            <g:fieldValue bean="${licenseInstance}" field="demoMode"/>
                        </span>
                        <g:link class="btn btn-primary btn-small ${(licenseInstance?.demoMode)?:'disabled'}" 
                            action="changeDemoToProduction" id="${licenseInstance.id}">
                            Change Demo To Production
                        </g:link>
                    </div>
                </div>
            </g:if>
            <g:if test="${licenseInstance?.expires}">
                <div class="control-group">
                    <label class="control-label">
                        <g:message code="license.key.label" default="Expires" />:
                    </label>
                    <div class="controls">
                        <span class="input-xlarge uneditable-input">
                            <g:fieldValue bean="${licenseInstance}" field="expires"/>
                        </span>
                        <g:link class="btn btn-primary btn-small" action="prolongateLicense" id="${licenseInstance.id}">Prolongate license
                        </g:link>
                    </div>
                </div>
            </g:if>
            <g:if test="${licenseInstance?.lastUpdated}">
                <div class="control-group">
                    <label class="control-label">
                        <g:message code="license.key.label" default="Last updated" />:
                    </label>
                    <div class="controls">
                        <span class="input-xlarge uneditable-input">
                            <g:fieldValue bean="${licenseInstance}" field="lastUpdated"/>
                        </span>
                    </div>
                </div>
            </g:if>
        </fieldset>
    </g:form>
    <div class="control-group">
        <div class="controls">
            <button class="btn btn-primary" href="#">Update</button>
        </div>
    </div>

</content>

<content tag="sidemenu">
    <li><g:link action="showLicenses">Show licences</g:link></li>
    <li><g:link action="showApplicationStatus">Show application status</g:link></li>
    <li><g:link action="showStatistics">Show statistics</g:link></li>
    <li><g:link action="cleanup">Cleanup</g:link></li>
</content>

</g:applyLayout>
