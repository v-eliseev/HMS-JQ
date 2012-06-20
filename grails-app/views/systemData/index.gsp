<%@ page contentType="text/html;charset=ISO-8859-1"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<meta name="layout" content="main" />
<title>System Data</title>
</head>
<body>
	<script type="text/javascript">
$(function(){
  $("#accordion").accordion({
    fillSpace: true,
    active: 0
  });
});
</script>

	<div class="body">
		<span class="page-title">System Data</span>
<!-- --> 		
		<div id="accordion-resizer" class="ui-widget-content">
		<div id="accordion" class="ui-accordion">
			<h3>
				<a href="#">Hotel Settings</a>
			</h3>
			<div>
				<div class="icon">
					<g:link controller="roomCategory">
						<img src="${resource(dir:'images',file:'dbb.png')}"/>
						<span>Room Categories</span>
					</g:link>
				</div>		
				<div class="icon">
					<g:link controller="room">
						<img src="${resource(dir:'images',file:'dbb.png')}"/>
						<span>Rooms</span>
					</g:link>
				</div>		
				<div class="icon">
					<g:link controller="roomFeature">
						<img src="${resource(dir:'images',file:'dbb.png')}"/>
						<span>Room Features</span>
					</g:link>
				</div>		
				<div class="icon">
					<g:link controller="customer">
						<img src="${resource(dir:'images',file:'dbb.png')}"/>
						<span>Customer Profile</span>
					</g:link>
				</div>		
				<div class="icon">
					<g:link controller="hotel">
						<img src="${resource(dir:'images',file:'dbb.png')}"/>
						<span>My Property</span>
					</g:link>
				</div>		
			</div>
			<h3>
				<a href="#">Reservation</a>
			</h3>
			<div>
				<div class="icon">
					<g:link controller="pricing">
						<img src="${resource(dir:'images',file:'dbb.png')}"/>
						<span>Pricing</span>
					</g:link>
				</div>		
				<div class="icon">
					<g:link controller="reservationCode">
						<img src="${resource(dir:'images',file:'dbb.png')}"/>
						<span>Reservation Codes</span>
					</g:link>
				</div>		
			</div>
			<h3>
				<a href="#">Point of Sales</a>
			</h3>
			<div>
				<div class="icon">
					<g:link controller="article">
						<img src="${resource(dir:'images',file:'dbb.png')}"/>
						<span>Articles</span>
					</g:link>
				</div>		
				<div class="icon">
					<g:link controller="articleGroup">
						<img src="${resource(dir:'images',file:'dbb.png')}"/>
						<span>Article Groups</span>
					</g:link>
				</div>		
				<div class="icon">
					<g:link controller="payment">
						<img src="${resource(dir:'images',file:'dbb.png')}"/>
						<span>Payments</span>
					</g:link>
				</div>		
				<div class="icon">
					<g:link controller="taxCode">
						<img src="${resource(dir:'images',file:'dbb.png')}"/>
						<span>Taxes</span>
					</g:link>
				</div>		
			</div>
			<h3>
				<a href="#">Documents</a>
			</h3>
			<div>
				<div class="icon">
					<g:link controller="template">
						<img src="${resource(dir:'images',file:'dbb.png')}"/>
						<span>Templates</span>
					</g:link>
				</div>		
			</div>
			<h3>
				<a href="#">System</a>
			</h3>
			<div>
				<div class="icon">
					<g:link controller="language">
						<img src="${resource(dir:'images',file:'dbb.png')}"/>
						<span>Language Settings</span>
					</g:link>
				</div>		
				<div class="icon">
					<g:link controller="userManagement">
						<img src="${resource(dir:'images',file:'dbb.png')}"/>
						<span>User Management</span>
					</g:link>
				</div>		
			</div>
		</div>
	</div>
	</div>
</body>
</html>