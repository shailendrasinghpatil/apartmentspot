<%@ page import="com.viraneel.apartmentspot.valuebeans.UserSessionProfile"%>
<?xml version="1.0" encoding="ISO-8859-1" ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<style>
#tabs {
	position:absolute;
	top: 80px;
	left: 10px;
	padding: 0.1em;
	height: 500px;
	border: 0px;
	
}

#subtabs-1 #subtabs-2 #subtabs-3 #subtabs-4 {
	position: relative;
	left: 5px;
	padding: 0.1em;
	height: 400px;
	z-index:-5;
}

.ui-dialog{
z-index:999;
}

.ui-tabs-vertical {
	width: 100%;
}

.ui-tabs-vertical>.ui-tabs-nav {
	position: relative;
	top: 50px;
	padding: .2em .1em .2em .2em;
	float: left;
	width: 20em;
}

.ui-tabs-vertical>.ui-tabs-nav li {
	clear: left;
	width: 100%;
	border-bottom-width: 1px !important;
	border-right-width: 0 !important;
	margin: 0 -1px .2em 0;
}

.ui-tabs-vertical>.ui-tabs-nav li a {
	display: block;
}

.ui-tabs-vertical>.ui-tabs-nav li.ui-tabs-active {
	padding-bottom: 0;
	padding-right: .1em;
	border-right-width: 1px;
}

.ui-tabs-vertical>.ui-tabs-panel {
	padding: 1em;
	float: right;
	width: 80%;
}
</style>
<title>Accounts</title>
</head>
<body>
	<%@include file="header.jsp"%>

		<%
		UserSessionProfile userData = (UserSessionProfile)session.getAttribute("userSessionProfile");
		
		List<Section> userSections = userData.getAccessibleSections();
		
		String currentMainSection = "Accounts";
		List<Section> currentSubSectionList = null;
		
		for (Section userSection: userSections){
			if(userSection.getSectionName().equalsIgnoreCase(currentMainSection)){
				currentSubSectionList = userSection.getSubSections();
			}
		}
		
		if(null != currentSubSectionList){
			%>
	<div id="tabs">
		<ul>			
			<%
		int i=0;
		for(Section currentSubSection: currentSubSectionList){		
		%>
			<%if((currentSubSection.getSubSections() == null) || ((currentSubSection.getSubSections() != null) && (currentSubSection.getSubSections().size() == 0)) ){ %>
			<li><a href="<%=currentSubSection.getContentURL()%>"><%=currentSubSection.getSectionName()%></a></li>
		<%}else{i= i+1;%>
			
		<li><a href="#tabs-<%=i%>"><%=currentSubSection.getSectionName()%></a></li>
		<%} %>
		<%}%>	
		</ul>
		
		
		<%
		int j=0; 
		for(Section currentSubSection: currentSubSectionList){
			
			if(!((currentSubSection.getSubSections() == null) || ((currentSubSection.getSubSections() != null) && (currentSubSection.getSubSections().size() == 0))) ){
				j=j+1;
		%>
		<div id="tabs-<%=j%>">
			<div id="subtabs-<%=j%>">
				<ul>
				   <%for(Section currentSubSubSection: currentSubSection.getSubSections()) {%>
					<li><a href="<%=currentSubSubSection.getContentURL()%>"><%=currentSubSubSection.getSectionName()%></a></li>
					<%} %>
				</ul>
			</div>
		</div>
		<%			
			}
		} %>
		
		</div>
	<script>
		$(document).ready(
		function() {
	   <%
			String active="0";
			String subactive="0";
			if(null != request.getParameter("active")){active = request.getParameter("active"); }
			if(null != request.getParameter("subactive")){subactive = request.getParameter("subactive"); }
	   %>
			$("#tabs").tabs({active :<%=active%>}).addClass("ui-tabs-vertical ui-helper-clearfix");
			$("#tabs li").removeClass("ui-corner-top").addClass("ui-corner-left");
		<%	for(int k=1; k <= j; k++){%>
				$("#subtabs-<%=k%>").tabs(<%if(active.equals("" + (k-1))){%>{active :<%=subactive%>}<%}%>);				
		<%	} %>		
			
		});
	</script>
	<%} %>
</body>

</html>
