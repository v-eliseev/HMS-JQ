<%@ page contentType="text/html;charset=ISO-8859-1"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<meta name="layout" content="main" />
<title>Dashboard</title>
</head>
<body>
<script type="text/javascript">
<!--
$(function(){
  $("#accordion").accordion({
    fillSpace: true,
    active: 0
  });
});
-->
</script>

	<div class="body">
		<span class="page-title">Dashboard</span>
<!-- --> 		
		<div id="accordion-resizer" class="ui-widget-content">
		<div id="accordion" class="ui-accordion">
			<h3>
				<a href="#">Reservation</a>
			</h3>
			<div>
				<div class="icon">
					<g:link controller="reservationBoard">
						<img src="${resource(dir:'images',file:'dbb.png')}"/>
						<span>Reservation board</span>
					</g:link>
				</div>		
				<div class="icon">
					<g:link controller="reservationRequest">
						<img src="${resource(dir:'images',file:'dbb.png')}"/>
						<span>Reservation request</span>
					</g:link>
				</div>		
				<div class="icon">
					<a href="#">
						<img src="${resource(dir:'images',file:'dbb.png')}"/>
						<span>Reservation list</span>
					</a>
				</div>		
				<div class="icon">
					<g:link controller="customer">
						<img src="${resource(dir:'images',file:'dbb.png')}"/>
						<span>Guest search</span>
					</g:link>
				</div>		
			</div>
			<h3>
				<a href="#">Reporting</a>
			</h3>
			<div>
				<div class="icon">
					<a href="#">
						<img src="${resource(dir:'images',file:'dbb.png')}"/>
						<span>Check-in list</span>
					</a>
				</div>		
				<div class="icon">
					<a href="#">
						<img src="${resource(dir:'images',file:'dbb.png')}"/>
						<span>Check-out list</span>
					</a>
				</div>		
				<div class="icon">
					<a href="#">
						<img src="${resource(dir:'images',file:'dbb.png')}"/>
						<span>Cancellation list</span>
					</a>
				</div>		
				<div class="icon">
					<a href="#">
						<img src="${resource(dir:'images',file:'dbb.png')}"/>
						<span>Householding list</span>
					</a>
				</div>		
			</div>
		</div>
		</div>
<!--  -->	
	</div>
</body>
</html>