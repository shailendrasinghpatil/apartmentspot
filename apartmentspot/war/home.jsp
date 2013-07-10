<?xml version="1.0" encoding="ISO-8859-1" ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />

<style>
#notice {
	position: absolute;
	top: 85px;
	left: 50px;
	width: 350px;
	padding: 0.5em;
	z-index: -2;
}

#statistics {
	position: absolute;
	top: 85px;
	left: 500px;
	width: 350px;
	padding: 0.5em;
	z-index: -2;
}

#events {
	position: absolute;
	top: 385px;
	left: 50px;
	width: 350px;
	padding: 0.5em;
	z-index: -2;
}

#announcements {
	position: absolute;
	top: 385px;
	left: 500px;
	width: 350px;
	padding: 0.5em;
	z-index: -2;
}

.column {
	width: 170px;
	float: left;
	padding-bottom: 100px;
}

.portlet {
	margin: 0 1em 1em 0;
}

.portlet-header {
	margin: 0.3em;
	padding-bottom: 4px;
	padding-left: 0.2em;
}

.portlet-header .ui-icon {
	float: right;
}

.portlet-content {
	padding: 0.4em;
	height:100px;
	overflow:auto;
}

.ui-sortable-placeholder {
	border: 1px dotted black;
	visibility: visible !important;
	height: 50px !important;
}

.ui-sortable-placeholder * {
	visibility: hidden;
}
</style>
<title>Welcome</title>
</head>
<body>
	<%@include file="header.jsp"%>
	<script>
		$(document)
				.ready(
						function() {
							$(".column").sortable({
								connectWith : ".column" ,
								handle: ".sort"
							});
							$(".portlet")
									.addClass(
											"ui-widget ui-widget-content ui-helper-clearfix ui-corner-all")
									.find(".portlet-header")
									.addClass("ui-widget-header ui-corner-all")
									.prepend(
											"<span class='ui-icon ui-icon-minusthick'></span>")
									.end().find(".portlet-content");

							$(".portlet-header .ui-icon").click(
									function() {
										$(this).toggleClass(
												"ui-icon-minusthick")
												.toggleClass(
														"ui-icon-plusthick");
										$(this).parents(".portlet:first").find(
												".portlet-content").toggle();
									});

							$(".column").disableSelection();
							//$("#notice").resizable();
							$("#events").resizable();
							$("#announcements").resizable();
							$("#statistics").resizable();
						});
	</script>

	<div id="notice" title="Notice Board" class="column">
		<div class="portlet">
			<div class="portlet-header">Notice</div>
			<div class="portlet-content">
				notice1<br></br>notice2 notice1<br></br>notice2 notice1<br></br>notice2
				notice1<br></br>notice2 notice1<br></br>notice2 notice1<br></br>notice6
				notice1<br></br>notice7 notice1<br></br>notice8
			</div>
		</div>
	</div>
	<div id="events" title="Events" class="column">
		<div class="portlet">
			<div class="portlet-header">Events</div>
			<div class="portlet-content">Events will be shown here</div>
		</div>
	</div>

	<div id="announcements" title="Announcements" class="column">
		<div class="portlet">
			<div class="portlet-header">Announcements</div>
			<div class="portlet-content">announcements will come here</div>
		</div>
	</div>
	
	<div id="statistics" title="Statistics" class="column">
		<div class="portlet">
			<div class="portlet-header">Statistics</div>
			<div class="portlet-content">Statistics</div>
		</div>
	</div>
	<div id="footer"></div>
</body>
</html>