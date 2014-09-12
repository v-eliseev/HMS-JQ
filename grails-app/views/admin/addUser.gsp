<g:applyLayout name="twoblocks">
<head>
<title><g:message code="title.admin.rooms" /></title>
%{-- <asset:stylesheet src="datetimepicker/bootstrap-datetimepicker.min.css"/> --}%
%{-- <asset:javascript src="datetimepicker/bootstrap-datetimepicker.min.js"/> --}%
<asset:javascript src="password/showpassword.js"/>
</head>

<content tag="top"> 
</content>

<content tag="main"> 
<div class="row">
    <div class="col-lg-10">
    <legend>New User Account</legend>

<g:form class="form-horizontal" role="form" action="saveUser" method="POST">
<div class="row">
    <div class="col-lg-6">

        <div class="form-group">
            <label for="inputUsername" class="col-lg-4 control-label"><g:message code="user.name.label" default="Username" /></label>
            <div class="col-lg-8">
                <input type="text"class="form-control" id="inputUsername" name="username" placeholder="Enter username" value="${user?.username}">
            </div>
        </div>

        <div class="form-group">
            <label for="inputPassword" class="col-lg-4 control-label"><g:message code="user.password.label" default="Password" /></label>
            <div class="col-lg-8">
                <input type="password" class="form-control" id="inputPassword" name="password" placeholder="Enter password">
            </div>
        </div>

        <div class="form-group">
            <label for="inputPasswordRetype" class="col-lg-4 control-label"><g:message code="user.passwordRetype.label" default="Retype password" /></label>
            <div class="col-lg-8">
                <input type="password" class="form-control" id="inputPasswordRetype" name="passwordRetype" placeholder="Retype password">
            </div>
        </div>

        <div class="form-group">
            <label for="inputEmail" class="col-lg-4 control-label"><g:message code="user.email.label" default="E-Mail" /></label>
            <div class="col-lg-8">
                <input type="email" class="form-control" id="inputEmail" name="email" placeholder="Enter e-mail" value="${user?.email}">
            </div>
        </div>

%{--         <div class="form-group">
            <label for="inputFullName" class="col-lg-4 control-label"><g:message code="user.email.label" default="Full Name" /></label>
            <div class="col-lg-8">
                <input type="text" class="form-control" id="inputFullname" name="email" placeholder="Enter full name" value="${user?.fullname}">
            </div>
        </div>
 --}%

    </div>
    <div class="col-lg-3">
        <div class="panel panel-default">
            <div class="panel-heading">Account Status</div>
            <div class="panel-body">
                <div class="checkbox">
                    <label><g:checkBox name="accountEnabled" checked="${user?.enabled}"/>Enabled</label>
                </div>
                <div class="checkbox">
                    <label><g:checkBox name="accountLocked" checked="${user?.accountLocked}"/>Locked</label>
                </div>
            </div>
        </div>
    </div>
    <div class="col-lg-3">
        <div class="panel panel-default">
            <div class="panel-heading">Account Role</div>
            <div class="panel-body">
                <div class="radio">
                  <label>
                    <input type="radio" name="roles" id="role1" value="ROLE_ADMIN">
                    ROLE_ADMIN
                  </label>
                </div>
                <div class="radio">
                  <label>
                    <input type="radio" name="roles" id="role2" value="ROLE_USER" checked>
                    ROLE_USER
                  </label>
                </div>
            </div> 
        </div> 
    </div>
</div>
<div class="row">
    %{-- <g:render template="userform"/> --}%
    <div class="col-lg-6">
    </div>
    <div class="col-lg-6">
    </div>
</div>
<div class="row">
    <div class="col-lg-6">
    <div class="form-group">
        <div class="col-lg-offset-4 col-lg-8">
            <button type="submit" class="btn btn-primary" href="#">Create account</button>
        </div>
    </div>
    </div>
</div>
</g:form>

    </div>
    <div class="col-lg-2">
        <legend>Actions</legend>
            <g:link action="lockAccount" id="${user?.id}" class="btn btn-primary btn-block">Lock account</g:link>
            <g:link action="disableAccount" id="${user?.id}" class="btn btn-primary btn-block">Disable account</g:link>
            <g:link action="expireAccount" id="${user?.id}" class="btn btn-primary btn-block">Expire account</g:link>
            <g:link action="expirePassword" id="${user?.id}" class="btn btn-primary btn-block">Expire password</g:link>
            <g:link action="resetPassword" id="${user?.id}" class="btn btn-primary btn-block">Reset password</g:link>
            <g:link action="deleteAccount" id="${user?.id}" class="btn btn-primary btn-block">Delete account</g:link>
    </div>
</div>

<script type="text/javascript">
$(document).ready(function() {
    $('#inputPassword').showPassword({});
    $('#inputPasswordRetype').showPassword({});
});
</script>
</content>

</g:applyLayout>