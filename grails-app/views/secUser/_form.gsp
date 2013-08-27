<div class="control-group">
    <label class="control-label">
        <g:message code="user.name.label" default="E-Mail:" />:
    </label>
    <div class="controls">
        <input type="text" placeholder="Enter e-mail">
    </div>
</div>
<div class="control-group">
    <label class="control-label">
        <g:message code="user.enabled.label" default="Enabled" />:
    </label>
    <div class="controls">
        <div id="enabledTB">
            <input type="checkbox" checked>
        </div>
    </div>
</div>
<div class="control-group">
    <label class="control-label">
        <g:message code="user.enabled.label" default="Locked" />:
    </label>
    <div class="controls">
        <div id="lockedTB">
            <input type="checkbox">
        </div>
    </div>
</div>
<div class="control-group">
    <label class="control-label">
        <g:message code="user.enabled.label" default="Account status" />:
    </label>
    <div class="controls">
        <span class="label label-success">Valid</span>
        <button class="btn btn-primary btn-mini" href="#">Expire now</button>
    </div>
</div>
<div class="control-group">
    <label class="control-label">Account expires</label>
    <div class="controls">
        <label class="radio"><input type="radio" name="expireAccount" value="option1" checked>Never</label>
        <label class="radio"><input type="radio" name="expireAccount" value="option2">On
            <div class="input-append date" id="expireAccountDP">
                <input size="16" type="text" placeholder="Account expiration date" value="">
                <span class="add-on"><i class="icon-th"></i></span>
            </div>
        </label>
        <label class="radio"><input type="radio" name="expireAccount" value="option3">Every<input type="text"> days</label>
    </div>
</div>
<div class="control-group">
    <label class="control-label">
        <g:message code="user.enabled.label" default="Password status" />:
    </label>
    <div class="controls">
        <span class="label label-success">Valid</span>
        <button class="btn btn-primary btn-mini" href="#">Expire now</button>
    </div>
</div>
<div class="control-group">
    <label class="control-label">Password expires</label>
    <div class="controls">
        <label class="radio"><input type="radio" name="expirePassword" value="option1" checked>Never</label>
        <label class="radio"><input type="radio" name="expirePassword" value="option2">On
            <div class="input-append date" id="expirePasswordDP">
                <input size="16" type="text" placeholder="Password expiration date" value="">
                <span class="add-on"><i class="icon-th"></i></span>
            </div>
        </label>
        <label class="radio"><input type="radio" name="expirePassword" value="option3">Every<input class="span2"type="text"> days</label>
    </div>
</div>

<r:script>
    $('#enabledTB').toggleButtons({
        label: {
            enabled: 'Yes',
            disabled: 'No'
            }
        });
    $('#lockedTB').toggleButtons({
        label: {
            enabled: 'Yes',
            disabled: 'No'
            }
        });
    $('#expireAccountDP').datetimepicker({
        format: 'dd-mm-yyyy',
        weekStart: '1',
        autoclose: 'true',
        todayHighlight: 'true'
    });
    $('#expirePasswordDP').datetimepicker({
        format: 'dd-mm-yyyy',
        weekStart: '1',
        autoclose: 'true',
        todayHighlight: 'true'
    });
</r:script>
