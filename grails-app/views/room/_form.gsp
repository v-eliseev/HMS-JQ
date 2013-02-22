<div class="control-group">
    <label class="control-label">
        <g:message code="user.name.label" default="Name" />:
    </label>
    <div class="controls">
        <input type="text" placeholder="Enter room name" value="${roomInstance?.name}">
    </div>
</div>
<div class="control-group">
    <label class="control-label">
        <g:message code="user.name.label" default="RoomCategory" />:
    </label>
    <div class="controls">
        <g:select name="roomCategory" from="${roomCategoryInstanceList}" optionKey="id" optionValue="name" value="${roomCategoryInstance}"/>
    </div>
</div>
<div class="control-group">
    <label class="control-label">
        <g:message code="user.name.label" default="Adults" />:
    </label>
    <div class="controls">
        <input type="text" placeholder="Enter bed count" value="${roomInstance?.adults}">
    </div>
</div>