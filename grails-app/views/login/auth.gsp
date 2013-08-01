<html>
<head>
<meta name="layout" content="blankpage"/>
<title>Roombix &emdash; Login</title>
</head>
<body>
<div class="container">
<div class="navbar">
    <div class="container">
      <span class="navbar-brand" uri="/">Roombix</span> 
    </div>
</div><!-- /navbar -->	
<div class="row">
    <div class="container">
    <div class="col-lg-4 col-offset-4">
      <div class="well">
        <legend>Sign in to Roombix App</legend>
        <g:if test='${flash.message}'>
			<div class='login_message'>${flash.message}</div>
		</g:if>
        <form method="POST" action="${postUrl}" accept-charset="UTF-8">
	        <g:if test='${flash.message}'>
            <div class="alert alert-error">
                <a class="close" data-dismiss="alert" href="#">x</a>${flash.message}
            </div>      
			</g:if>
            <div class="col-lg-9">
            <input class="form-control" placeholder="Username" type="text" name="j_username" id="username"
				value="user"
				%{-- value="${session['SPRING_SECURITY_LAST_USERNAME']}" --}%
            >
            </div>
            <div class="col-lg-9">
            <input class="form-control" placeholder="Password" type="password" name="j_password" id="password"
            	value="test"
            > 
            </div>
            <div class="col-lg-9">
            <input class="form-control" placeholder="License key" type="text" name="j_licenseKey" id="licenseKey"
				value="WR9WX-Q9CTF-2QFCY-YRY9V-PPHK6"
            >
            </div>
			<div id="license_show">
				<g:message	code="springSecurity.login.license.label" />:
				<span id="licenseKey">XXXXX-XXXXX-XXXXX-XXXXX-XXXXX</span> 
				<a href="#" id="changeLicenseKey">Change...</a>
			</div>
            <label class="checkbox">
                <input type="checkbox" name="${rememberMeParameter}" id="remember_me"
                <g:if test='${hasCookie}'>checked='checked'</g:if> />&nbsp;
                <g:message code="springSecurity.login.remember.me.label" />
            </label>
            <button class="btn-info btn" type="submit" id="submit">
            	<g:message code="springSecurity.login.button"/>
            </button>      
        </form>    
      </div>
    </div>
    </div>
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