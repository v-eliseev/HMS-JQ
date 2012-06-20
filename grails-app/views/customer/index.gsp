<%@ page contentType="text/html;charset=ISO-8859-1" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"/>
<meta name="layout" content="main"/>
<title>Customers</title>
</head>
<body>
<div class="body">
<%
  def pageDataModel = [
	url:"${createLink(controller:'customer', action:'listJSON', params:[:])}",
	editurl:"${createLink(controller:'customer', action:'editJSON', params:[id:id])}",
	colNames:"['ID', 'Salutation', 'Name', 'Date created', 'Last Updated']",
	colModel:"[ \
		{name:'id',index:'id', width:55, sortable:false, editable:false, editoptions:{readonly:true,size:10}}, \
		{name:'salutation',index:'salutation', width:100,editable:true}, \
		{name:'name',index:'name', width:200,editable:true}, \
		{name:'dateCreated',index:'dateCreated', width:100}, \
		{name:'lastUpdated',index:'lastUpdated', width:100}, \
	]",
	caption:"Customers"
  ]
%>	
<g:render template="/itemTable" model="${pageDataModel}"/>
</div>
</body>
</html>