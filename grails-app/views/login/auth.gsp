<html>
<head>
<meta name='layout' content='main' />
<title><g:message code="springSecurity.login.title" /></title>
</head>

<body>
	<div id='login'>
		<div class='inner'>
			<div class='fheader'>
				<g:message code="springSecurity.login.header" />
			</div>

			<g:if test='${flash.message}'>
				<div class='login_message'>
					${flash.message}
				</div>
			</g:if>

			<form action='${postUrl}' method='POST' id='loginForm'
				class='cssform' autocomplete='off'>
				<p>
					<label for='username'><g:message
							code="springSecurity.login.username.label" />:</label> <input type='text'
						class='text_' name='j_username' id='username' 
						value="${session['SPRING_SECURITY_LAST_USERNAME']}"/>
				</p>

				<p>
					<label for='password'><g:message
							code="springSecurity.login.password.label" />:</label> <input
						type='password' class='text_' name='j_password' id='password' />
				</p>

				<div id="license_input">
					<p>
						<label for='license'><g:message
								code="springSecurity.login.license.label" />:</label> <input type='text'
							class='text_' name='j_licenseKey' id='license' />
					</p>
				</div>

				<div id="license_show">
					<p>
						<label for='license'><g:message	code="springSecurity.login.license.label" />:</label>
						<span id="licenseKey">XXXXX-XXXXX-XXXXX-XXXXX-XXXXX</span> 
						<a id="changeLicenseKey">Change...</a>
					</p>
				</div>

				<p id="remember_me_holder">
					<input type='checkbox' class='chk' name='${rememberMeParameter}'
						id='remember_me'
						<g:if test='${hasCookie}'>checked='checked'</g:if> /> <label
						for='remember_me'><g:message
							code="springSecurity.login.remember.me.label" /></label>
				</p>

				<p>
					<input type='submit' id="submit"
						value='${message(code: "springSecurity.login.button")}' />
				</p>
			</form>
		</div>
	</div>
	<script type='text/javascript'>	(function() {
		document.forms['loginForm'].elements['j_username'].focus();
	})();

	var LICENSE_KEY = 'hms.license.key'; 
		
	function isLocalStorageAvailable() {
	    try {
	        return 'localStorage' in window && window['localStorage'] !== null;
	    } catch (e) {
	        return false;
	    }
	}

	$(document).ready(function() {
		if(!isLocalStorageAvailable()) {
			alert('Local storage is not supported');
		} else {
			var licenseKey = localStorage.getItem(LICENSE_KEY);
			if (licenseKey != null) {
				$(this).find("#licenseKey").text(licenseKey);
				$("#license_show").show();
				$("#license_input").hide();
			} else {
				$("#license_input").show();
				$("#license_show").hide();
			}
		}
	})

	$("#changeLicenseKey").click(function() {
		localStorage.removeItem(LICENSE_KEY);
		return true;
	})	
	
	</script>
</body>
</html>
