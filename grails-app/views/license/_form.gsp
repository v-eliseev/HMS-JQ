<%@ page import="hms.License" %>



<div class="fieldcontain ${hasErrors(bean: licenseInstance, field: 'code', 'error')} ">
	<label for="key">
		<g:message code="license.key.label" default="Key" />
		
	</label>
	<g:textField name="key" value="${licenseInstance?.key}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: licenseInstance, field: 'demoMode', 'error')} ">
	<label for="demoMode">
		<g:message code="license.demoMode.label" default="Demo Mode" />
		
	</label>
	<g:checkBox name="demoMode" value="${licenseInstance?.demoMode}" />
</div>

<div class="fieldcontain ${hasErrors(bean: licenseInstance, field: 'expires', 'error')} required">
	<label for="expires">
		<g:message code="license.expires.label" default="Expires" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="expires" precision="day"  value="${licenseInstance?.expires}"  />
</div>

