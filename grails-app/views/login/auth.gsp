<html>
<head>
<meta name="layout" content="blankpage"/>
<title>Roombix -- Login</title>
</head>
<body>
<div class="container">
<nav class="navbar navbar-default" role="navigation">
    <div class="navbar-header">
        <g:link class="navbar-brand" uri="/">Roombix</g:link> 
    </div>
</nav>
</div>
<div class="row">
    <div class="container">
    <div class="col-lg-6 col-lg-offset-3">
      <div class="well">
        <legend>Sign in to Roombix App</legend>
%{--         <g:if test='${flash.message}'>
			<div class='login_message'>${flash.message}</div>
		</g:if>
 --}%        <g:if test='${flash.message}'>
        <div class="alert alert-error">
            <a class="close" data-dismiss="alert" href="#">x</a>${flash.message}
        </div>      
        </g:if>
        <g:form class="form-horizontal" url="${postUrl}" id="loginForm">
            <div class="form-group">
                <label for="username" class="col-lg-3 control-label">Username</label>
                <div class="col-lg-9">
                    <input class="form-control" placeholder="Username" type="text" name="j_username" id="username" value="user" %{-- value="${session['SPRING_SECURITY_LAST_USERNAME']}" --}%>
                </div>
            </div>
            <div class="form-group">
                <label for="password" class="col-lg-3 control-label">Password</label>
                <div class="col-lg-9">
                    <input class="form-control" placeholder="Password" type="password" name="j_password" id="password" value="test"> 
                </div>
            </div>
            <div class="form-group">
                <label for="licenseKey" class="col-lg-3 control-label">License key</label>

                <!-- show input field -->
                <div class="col-lg-9" id="license_input" style="display:none;">
                    <input class="form-control" placeholder="License key" type="text" name="j_licenseKey" id="licenseKey" value="WR9WX-Q9CTF-2QFCY-YRY9V-PPHK6">
                </div>
    			
                <!-- show text -->
                <div class="col-lg-9" id="license_show" style="display:none;">
    				<span class="form-control" id="licenseKey">XXXXX-XXXXX-XXXXX-XXXXX-XXXXX</span> 
    				<a href="#" id="changeLicenseKey">Change...</a>
    			</div>
            </div>

            <div class="form-group">
                <label class="col-lg-3 control-label"></label>
                <div class="col-lg-9">
                    <div class="checkbox">
                        <label>
                            <input type="checkbox" name="${rememberMeParameter}" id="remember_me"
                            <g:if test='${hasCookie}'>checked='checked'</g:if> />&nbsp;
                            <g:message code="springSecurity.login.remember.me.label" />
                        </label>
                    </div>
                </div>
            </div>
                
            <div class="form-group">
                <label class="col-lg-3 control-label"></label>
                <div class="col-lg-9">
                    <button class="btn btn-info col-lg-6" type="submit" id="submit">
                   	    <g:message code="springSecurity.login.button"/>
                    </button> 
                </div>
            </div>

        </g:form>    
      </div>
    </div>
    </div>
</div>
</div>

<script type='text/javascript'>	
(function() {
	document.forms['loginForm'].elements['j_username'].focus();
})();

var LICENSE_KEY = 'hms.license.key'; 
	
function isLocalStorageAvailable() {
    try {
        return 'localStorage' in window && window['localStorage'] !== null;
    } catch (e) {
        return false;
    }
};

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
});

$("#changeLicenseKey").click(function() {
	localStorage.removeItem(LICENSE_KEY);
    $("#license_input").show();
    $("#license_show").hide();
	return true;
});

</script>

</body>
</html>