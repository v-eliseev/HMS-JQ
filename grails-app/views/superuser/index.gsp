<g:applyLayout name="twoblocks">
<head>
<title><g:message code="title.superuser.index" /></title>
</head>

<content tag="top"> 
</content>

<content tag="main"> 
	<div class="row">
		<div class="col-lg-6">
		    <legend>Licenses</legend>
		    <table class="table table-striped table-condensed">
		    <thead>
		        <tr>
		            <g:sortableColumn property="key"
		                title="${message(code: 'license.key.label', default: 'Key')}" />
		            <g:sortableColumn property="demoMode"
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
		                <g:if test="${licenseInstance.demoMode}">
		                    <span class="label label-warning">Demo</span>
		                </g:if>
		                <g:else>
		                    <span class="label label-success">Production</span>
		                </g:else>
		            </td>
		            <td><g:formatDate format="yyyy-MM-dd" date="${licenseInstance.expires}" /></td>
		        </tr>
		    </g:each>
		    </tbody>
		    </table>

		</div>
		<div class="col-lg-6">
		    <legend>New License</legend>
			<div class="panel panel-default">
		  		<div class="panel-body">
					<g:form class="form-horizontal" role="form" action="createLicense" method="POST">
				        <div class="form-group">
				            <label for="inputEmail" class="col-lg-2 control-label"><g:message code="license.email.label" default="e-mail" /></label>
				            <div class="col-lg-8">
				                <input type="text"class="form-control" id="inputEmail" name="email" placeholder="Enter e-mail" value="v-eliseev@yandex.ru">
				            </div>
				            <div class="col-lg-2">
				                <span class="label label-success">OK!</span>
				            </div>
				        </div>

		   		        <div class="form-group">
		   		        	<label for="licenseType" class="col-lg-2 control-label"><g:message code="license.type.label" default="Type" /></label>
							<div class="col-lg-10">
						        <div class="radio">
				  					<label>
				  						<input type="radio" name="licenseType" id="licenseTypeProduction" value="production" checked />Production
				  					</label>
				  				</div>
						        <div class="radio">
				  					<label>
				  						<input type="radio" name="licenseType" id="licenseTypeDemo" value="demo"/>Demo
				  					</label>
								</div>
			  				</div>
						</div>

						<div class="form-group">
		        			<div class="col-lg-offset-2 col-lg-10">
		            			<button type="submit" class="btn btn-primary" href="#">Create license</button>
		        			</div>
		    			</div>

					</g:form>
				</div>
			</div>
		</div>
	</div>
</content>

</g:applyLayout>