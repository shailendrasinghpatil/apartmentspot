<?xml version="1.0" encoding="ISO-8859-1" ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8" />
<title>Apartment Spot</title>
<link rel="stylesheet" href="css/themes/cupertino/jquery-ui.css" />
<script src="js/jquery-1.9.1.js"></script>
<script src="js/jquery-ui.js"></script>
<script type="text/javascript" src="js/jquery.ui.menubar.js"></script>
<script src="js/jquery.jtable.min.js" type="text/javascript"></script>
<link rel="stylesheet" href="css/apartmentspot.css" type="text/css"
	media="screen" />
<script>
	$(document).ready(function() {
		$("#menu").menubar({
			autoExpand : true,
			menuIcon : true,
			buttons : true
		});
		$('li.ui-menu-item a.ui-corner-all').addClass('ui-widget-header');
		$("#tabs").tabs();

	});
</script>
<style>
.logoHeader {
	position: absolute;
	top: 0px;
	left: 0px;
	width: 230px;
	height: 55px;
	padding: 0.1em;
}

#tabs {
	position: absolute;
	top: 80px;
	left: 260px;
	padding: 0.1em;
	height: 500px;
	border: 0px;
	width: 50%;
}

.menubar {
	position: absolute;
	top: 20px;
	left: 231px;
	height: 55px;
	padding: 0.1em;
}
</style>
</head>

<body>
	<div id="headerbar" class="ui-widget-header">
		<div id="title" class="logoHeader">
			<a href="index.html"><span class="logo">Community Adda</span></a>
		</div>
		<div id="welcome" class="welcome">
			<%
				UserSessionProfile userSessionProfile = (UserSessionProfile) session
						.getAttribute("userSessionProfile");

				String firstName = "";

				if (null != userSessionProfile) {
					Member currentUser = userSessionProfile.getCurrentUser();
					firstName = currentUser.getFirstName();
				}

				if (!firstName.equalsIgnoreCase("")) {
			%>
			Welcome
			<%=firstName%>
			<%
				}
			%>
		</div>
		<div id="menubar" class="menubarcontainer">
			<ul id="menu">
				<li><a href="#">Home</a></li>
				<li><a href="#">About</a>
					<li><a href="#">Services </a>
						<ul>
							<li><a href="#">Software Development</a>
								<li><a href="#">Interface Design</a></li>
						</ul></li>
					<li><a href="#">Portfolio</a>
						<ul>
							<li><a href="#">Web Applications</a></li>
							<li><a href="#">SaaS</a></li>
							<li><a href="#">Windows Applications</a></li>
							<li><a href="#">Mobile Applications</a></li>
							<li><a href="#">Server Applications</a></li>
						</ul></li>
					<li><a href="#">Contact</a></li>
					<li><a href="logout">logout</a></li>
			</ul>
		</div>
	</div>
	<div id="tabs">
		<ul>
			<li><a href="#tabs-2">Register My Apartment</a></li>
			<li><a href="#tabs-1">My Apartment is already registered</a></li>
		</ul>
		<div id="tabs-1" class="group">
			<h3>My Apartment is already registered</h3>
			<div>
				<p>Search your apartment</p>
			</div>
		</div>
		<div id="tabs-2" class="group">
			<h3>Register My Apartment</h3>
			<div>
				<p><%@ include file="SocietyDetailsForm.jsp"%></p>
			</div>
		</div>
	</div>
</body>
</html>