<%@ page import="hms.License" %>

<g:applyLayout name="twoblocks">
<head>
<title><g:message code="title.superuser.index" /></title>
<asset:javascript src="bootbox/bootbox.js" />
</head>

<content tag="top">
</content>

<content tag="main">
    <div class="row">
        <div class="col-lg-6">
            <legend>License data</legend>
            <g:form class="form-horizontal" action="#" method="POST">

                <div class="form-group">
                    <label class="col-lg-3 control-label">
                        <g:message code="user.name.label" default="License key" />
                    </label>
                    <div class="col-lg-9">
                        <p class="form-control-static">${licenseInstance.key}</p>
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-lg-3 control-label">
                        <g:message code="user.name.label" default="License type" />
                    </label>
                    <div class="col-lg-9">
                        <p class="form-control-static">
                            <g:if test="${licenseInstance.mode == License.LicenseMode.DEMO}">
                                Demo
                            </g:if>
                            <g:else>
                                Production
                            </g:else>
                        </p>
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-lg-3 control-label">
                        <g:message code="user.name.label" default="Admin e-mail" />
                    </label>
                    <div class="col-lg-9">
                        <p class="form-control-static">${licenseInstance.email}</p>
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-lg-3 control-label">
                        <g:message code="user.name.label" default="Enabled" />
                    </label>
                    <div class="col-lg-9">
                        <p class="form-control-static">${licenseInstance.enabled}</p>
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-lg-3 control-label">
                        <g:message code="user.name.label" default="Issued" />
                    </label>
                    <div class="col-lg-9">
                        <p class="form-control-static"><g:formatDate format="yyyy-MM-dd" date="${licenseInstance.issued}"/></p>
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-lg-3 control-label">
                        <g:message code="user.name.label" default="Expires" />
                    </label>
                    <div class="col-lg-9">
                        <p class="form-control-static"><g:formatDate format="yyyy-MM-dd" date="${licenseInstance.expires}"/></p>
                    </div>
                </div>
            </g:form>    

            <g:link action="disableLicense" class="btn btn-danger" id="${licenseInstance.id}" elementId="deleteBtn">Disable license</g:link>
            
            <g:form action="prolongateLicense" class="form-inline">
                <div class="form-group">
                    <label for="period" class="col-lg-3 control-label"><g:message code="user.name.label" default="Period/Date" /></label>
                    <div class="col-lg-9">
                        <input type="text"class="form-control" id="period" name="period" placeholder="Enter date/period">
                    </div>
                </div>
                <input type="hidden" name="id" value="${licenseInstance.id}"/>
                <g:submitButton class="btn btn-danger" name="prolongate" value="Prolongate license" />
            </g:form>

        </div>
        <div class="col-lg-6">
            <legend>Owner data</legend>

        </div>
    </div>

<script type='text/javascript'>
    // $("#deleteBtn").click(function(e) {
    //     e.preventDefault();
    //     bootbox.confirm("Are you sure?", function(confirmed) {
    //         console.log("Confirmed: "+confirmed);
    //     });
    // });        
</script>
</content>

</g:applyLayout>
