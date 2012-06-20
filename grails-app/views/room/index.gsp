<!DOCTYPE html> 
<html>
<head>
	<title>Rooms</title>
</head>
<body>
<div class="body">
<h3>Rooms</h3>
<g:link action="add">Add</g:link>
<g:form name="myForm" action="delete" method="POST"> 
<g:actionSubmit action="delete" value="Delete selected"/>
<g:javascript>
	checked=false;
	function checkedAll (frm1) {
	var aa= document.getElementById(frm1);
	 if (checked == false)
          {
           checked = true
          }
        else
          {
          checked = false
          }
	for (var i =0; i < aa.elements.length; i++) 
	{
	 aa.elements[i].checked = checked;
	}
    }
</g:javascript>
<table>
<thead>
<tr>
	<td>Room name</td>
	<td>Room type</td>
	<td><input type="checkbox" name="checkall" onclick="checkedAll('myForm')"/></td>
	<td>Edit</td>
</tr>
</thead>
<tbody>
<g:each var="item" in="${dataList}" status="i">
<tr>
	<td><g:link action="show" id="${item.id}">${item.name}</g:link></td>
	<td>${item.roomCategory.name}</td>
	<td><g:checkBox name="cb${item.id}"></g:checkBox></td>
	<td><g:link action="edit" id="${item.id}">Edit</g:link></td>
</tr>
</g:each>
</tbody>
</table>
</g:form>
</div>
</body>
</html>