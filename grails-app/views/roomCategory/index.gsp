<%@ page contentType="text/html;charset=ISO-8859-1" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"/>
<meta name="layout" content="main"/>
<title>Room categories</title>
</head>
<body>
<div class="body">
<%
  def pageDataModel = [
  	url:"${createLink(controller:'roomCategory', action:'listJSON', params:[:])}",
  	editurl:"${createLink(controller:'roomCategory', action:'editJSON', params:[id:id])}",
	colNames:"['ID', 'Name', 'Short Description', 'Description', 'Is bookable online', 'Date created', 'Last Updated']",
	colModel:"[ \
		{name:'id',index:'id', width:55, sortable:false, editable:false, editoptions:{readonly:true,size:10}}, \
		{name:'name',index:'name', width:200,editable:true}, \
		{name:'shortDescription',index:'shortDescription', width:200,editable:true, editoptions:{size:20}}, \
		{name:'description',index:'description', width:300,editable:true, edittype:'textarea', editoptions:{cols:20, rows:5}}, \
		{name:'isBookableOnline', index:'isBookableOnline', width:150, editable:true, edittype:'checkbox'}, \
		{name:'dateCreated',index:'dateCreated', width:100, editable:true, editoptions:{readonly:true}}, \
		{name:'lastUpdated',index:'lastUpdated', width:100} \
	]",
  	caption:"Room Categories"
  ]
 %>
<g:render template="/itemTable" model="${pageDataModel}"/>
</div>
</body>
</html>