<!DOCTYPE html> 
<html> 
<head> 
	<title>List</title>
</head> 
<body> 

<div data-role="page">

	<div data-role="header">
		<h1>Available rooms</h1>
	</div><!-- /header -->

	<div data-role="content">
	<ul data-role="listview" data-inset="true">
		<g:each in="${dataList}" status="i" var="item">
		<li><g:link action="show" id="${item.id}">
				${fieldValue(bean: item, field: "name")}
				<span class="ui-li-count">2</span>
		</g:link>
		</li>
		</g:each>	
	</ul>
	</div><!-- /content -->

	<div data-role="footer">
		<h4>Page Footer</h4>
	</div><!-- /footer -->

</div><!-- /page -->

</body>
</html>