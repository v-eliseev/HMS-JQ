<g:applyLayout name="twoblocks">
<head>
<title><g:message code="title.admin.rooms" /></title>
<asset:stylesheet src="datetimepicker/bootstrap-datetimepicker.min.css"/>
<asset:javascript src="datetimepicker/bootstrap-datetimepicker.min.js"/>
</head>

<content tag="top"> 
</content>

<content tag="main"> 
<legend>New User Account</legend>
<g:form class="form-horizontal" role="form" action="saveUser" method="POST">
<div class="row">
    <div class="col-lg-9">

        <div class="form-group">
            <label for="inputUsername" class="col-lg-2 control-label"><g:message code="user.name.label" default="Username" /></label>
            <div class="col-lg-8">
                <input type="text"class="form-control" id="inputUsername" name="username" placeholder="Enter username" value="${user?.username}">
            </div>
            <div class="col-lg-2">
                <span class="label label-success">OK!</span>
            </div>
        </div>

        <div class="form-group">
            <label for="inputEmail" class="col-lg-2 control-label"><g:message code="user.email.label" default="E-Mail" /></label>
            <div class="col-lg-8">
                <input type="email" class="form-control" id="inputEmail" name="email" placeholder="Enter e-mail" value="${user?.email}">
            </div>
        </div>

        <div class="form-group">
            <label for="inputPassword" class="col-lg-2 control-label"><g:message code="user.password.label" default="Password" /></label>
            <div class="col-lg-8">
                <div class="input-group">
                    <input type="password"class="form-control" id="inputPassword" name="password" placeholder="Enter password">
                    <span class="input-group-btn">
                        <button class="btn btn-default" type="button"><i class="icon-random"></i></button>
                    </span>    
                    <span class="input-group-btn">
                        <button class="btn btn-default" type="button"><i class="icon-eye-open"></i></button>
                    </span>    
                </div>
            </div>
            <div class="col-lg-2">
                <span class="label label-warning">Good!</span>
            </div>
        </div>

        <div class="form-group">
            <label for="inputPasswordRetype" class="col-lg-2 control-label"><g:message code="user.passwordRetype.label" default="Retype" /></label>
            <div class="col-lg-8">
                <div class="input-group">
                    <input type="password"class="form-control" id="inputPasswordRetype" name="passwordRetype" placeholder="Retype password">
                    <span class="input-group-btn">
                        <button class="btn btn-default" type="button"><i class="icon-eye-open"></i></button>
                    </span>    
                </div>
            </div>
            <div class="col-lg-2">
                <span class="label label-success">OK!</span>
            </div>
        </div>

    </div>
    <div class="col-lg-3">
        <div class="panel panel-default">
            <div class="panel-heading">Account status</div>
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
</div>
<div class="row">
    %{-- <g:render template="userform"/> --}%
    <div class="col-lg-9">
        <div class="col-lg-8 col-lg-offset-2">
            <div class="col-lg-6">
                <div class="checkbox">
                    <label><g:checkBox name="expirePassword" checked="${user?.expirePassword}"/> Expire password</label>
                <button type="button" class="btn btn-primary btn-xs pull-right">Now</button>
                </div>
            <div class="panel panel-default">
                <div class="panel-body">
                    <div class="radio">
                        <label><input type="radio" name="passwordExpiresType" id="po2" value="2">On</label>
                    </div>
                    <div class="input-group" id="passwordExpiresOn">
                        <input type="text" class="form-control" name="passwordExpiresOn"/>
                        <span class="input-group-addon">...</span>
                    </div>
                    <div class="radio">
                        <label><input type="radio" name="passwordExpiresType" id="po3" value="3">Every</label>
                    </div>
                    <div>
                            <select class="form-control" id="passwordExpiresEvery" name ="passwordExpiresEveryCode">
                                <option value="1">1 month</option>
                                <option value="2">3 months</option>
                                <option value="3">6 months</option>
                                <option value="4">1 year</option>
                            </select>
                    </div>
                </div>
            </div>
            </div>
            <div class="col-lg-6">
                <div class="panel panel-default">
                    <div class="panel-heading">Account expires</div>
                    <div class="panel-body">
                        <button type="button" class="btn btn-primary btn-xs">Expire now</button>
                        <div class="radio">
                            <label><input type="radio" name="accountExpiresType" id="ao1" value="1" checked>Never</label>
                        </div>
                        <div class="radio">
                            <label><input type="radio" name="accountExpiresType" id="ao2" value="2">On</label>
                        </div>
                        <div>
                            <input type="text" class="form-control" id="accountExpiresOn"/>
                        </div>
                        <div class="radio">
                            <label><input type="radio" name="accountExpiresType" id="ao3" value="3">Every</label> 
                        </div>
                        <div>
                            <select class="form-control" id="accountExpiresEvery" name="accountExpiresEveryCode">
                                <option value="1">1 month</option>
                                <option value="2">3 months</option>
                                <option value="3">6 months</option>
                                <option value="4">1 year</option>
                            </select>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="col-lg-3">
        <div class="panel panel-default">
            <div class="panel-heading">Roles</div>
            <div class="panel-body">
                <g:each in="${roleInstanceList}" var="roleInstance">
                <div class="checkbox">
                    <label><input type="checkbox" value="${roleInstance.authority}" name="accountRole">${roleInstance.authority}</label>
                </div>
                </g:each>
            </div>
        </div>
    </div>
</div>
<div class="row">
    <div class="col-lg-6">
    <div class="form-group">
        <div class="col-lg-offset-3 col-lg-9">
            <button type="submit" class="btn btn-primary" href="#">Create account</button>
        </div>
    </div>
    </div>
</div>
</g:form>
<script type="text/javascript">
$(document).ready(function() {
    $('#passwordExpiresOn').datetimepicker(
    {
    })
});
</script>
</content>

</g:applyLayout>