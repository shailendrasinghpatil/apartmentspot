<%@ page
	import="com.viraneel.apartmentspot.valuebeans.UserSessionProfile"%>
<%@ page import="com.viraneel.apartmentspot.entities.Member"%>
<%@ page import="com.viraneel.apartmentspot.entities.Section"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.Map"%>
<%@ page import="java.util.HashMap"%>
<%
	if(request.getParameter("themedropdown") != null){
		session.setAttribute("defaultTheme", request.getParameter("themedropdown"));
	}

	if(null == session.getAttribute("defaultTheme")){
	session.setAttribute("defaultTheme", "cupertino");
}
%>
<link rel="stylesheet"
	href="css/themes/<%=(String)session.getAttribute("defaultTheme")%>/jquery-ui.css" />
<script src="js/jquery-1.9.1.js"></script>
<script src="js/jquery-ui.js"></script>
<script type="text/javascript" src="js/jquery.ui.menubar.js"></script>
<script src="js/jquery.jtable.min.js" type="text/javascript"></script>
<script src="js/jquery.juirte.js"></script>
<script type="text/javascript" src="js/pramukhime.js"></script>
<script type="text/javascript" src="js/pramukhindic.js"></script>
<script type="text/javascript" src="js/pramukhime-common.js"></script>
<link href="css/themes/jqueryui/jtable_jqueryui.css" rel="stylesheet"
	type="text/css" />
<link rel="stylesheet" href="css/apartmentspot.css" type="text/css"
	media="screen" />
<link rel="stylesheet" type="text/css" href="css/jquery.juirte.css" />
<link type="text/css" href="css/pramukhtypepad.css" rel="Stylesheet" />
<div id="headerbar" class="ui-widget-header">
	<div id="title" class="logoHeader">
		<a href="index.html"><span class="logo">Community Adda</span></span></a>
	</div>
	<div id="welcome" class="welcome">
		<%
			UserSessionProfile userSessionProfile = (UserSessionProfile) session
				.getAttribute("userSessionProfile");

				String firstName = "";
				List<Section> sections = null;
				if (null != userSessionProfile) {
			Member currentUser = userSessionProfile.getCurrentUser();
			firstName = currentUser.getFirstName();
			sections = userSessionProfile.getAccessibleSections();
				}
		%>
		Welcome
		<%=firstName%>
		&nbsp;&nbsp; <a href="logout">logout</a>
	</div>
	<div id="theme">
		<%
			if(null ==session.getAttribute("themeMap")){
				Map<String, String> themeMap = new java.util.HashMap<String, String>();
				
				themeMap.put("ui-lightness", "UI Lightness");
				themeMap.put("ui-darkness", "UI Darkness");
				themeMap.put("smoothness", "Smoothness");
				themeMap.put("start", "Start");
				themeMap.put("redmond", "Redmond");
				themeMap.put("sunny", "Sunny");
				themeMap.put("overcast", "Overcast");
				themeMap.put("le-frog", "Le Frog");
				themeMap.put("flick", "Flick");
				themeMap.put("pepper-grinder", "Pepper Grinder");
				themeMap.put("eggplant", "Eggplant");
				themeMap.put("dark-hive", "Dark Hive");
				themeMap.put("cupertino", "Cupertino");
				themeMap.put("south-street", "South Street");
				themeMap.put("blitzer", "Blitzer");
				themeMap.put("humanity", "Humanity");
				themeMap.put("blitzer", "Blitzer");
				themeMap.put("hot-sneaks", "Hot Sneaks");
				themeMap.put("excite-bike", "Excite Bike");
				themeMap.put("vader", "Vader");
				themeMap.put("dot-luv", "Dot Luv");
				themeMap.put("mint-choc", "Mint Chocolate");
				themeMap.put("black-tie", "Black Tie");
				themeMap.put("trontastic", "Trontastic");
				themeMap.put("swanky-purse", "Swanky Purse");		
				session.setAttribute("themeMap",themeMap);
			}
		%>
		<form name="frmTheme" id="frmTheme" method="post">
			Change theme <select id="themedropdown" name="themedropdown"
				class="ui-widget-content ui-corner-all">
				<%
					Map<String, String> themeMap = (Map<String, String>)session.getAttribute("themeMap");
						for (Map.Entry<String, String> entry : themeMap.entrySet())
					{
				%>
				<option value="<%=entry.getKey()%>"
					<%if(entry.getKey().equalsIgnoreCase((String)session.getAttribute("defaultTheme"))){%>
					selected <%}%>>
					<%=entry.getValue()%>
				</option>

				<%
					}
				%>
			</select> <input type="submit" id="ChangeTheme" name="ChangeTheme" value="Go" />
		</form>

	</div>
	<div class="menubarcontainer">
		<ul id="menu">
			<%
				if (null != sections){
			%>

			<%
				for(Section section: sections){
			%>
			<li><a href="<%=section.getUrl()%>"><%=section.getSectionName()%></a>
				<%
					if(null != section.getSubSections()) {
				%>
				<ul>
					<%
						for (Section subsection: section.getSubSections()){
					%>
					<li><a href="<%=subsection.getUrl()%>"><%=subsection.getSectionName()%></a>
						<%
							if(null != subsection.getSubSections()){
						%>
						<ul>
							<%
								for (Section subsubsection: subsection.getSubSections()) {
							%>
							<li><a href="<%=subsubsection.getUrl()%>"><%=subsubsection.getSectionName()%></a>
								<%
									}
								%>
						</ul> <%
 	}
 %></li>
					<%
						}
					%>
				</ul> <%
 	}
 %></li>
			<%
				}}
			%>
			
			<li><a href="#">Complaints and Notices </a>
				<ul>
					<li><a href="#">Complaint Box</a></li>
					<li><a href="#">Complaint Reports</a></li>
					<li><a href="#">Notices</a></li>
				</ul></li>
			<li><a href="#">Service Requests</a>
				<ul>
					<li><a href="#">Service Request</a></li>
					<li><a href="#">Service Request Report</a></li>
				</ul></li>
			<li><a href="http://communityadda.appspot.com/">MailBox</a>
				<ul>
					<li><a href="#">Society Inbox</a></li>
				</ul></li>
			<li><a href="http://communityadda.appspot.com/">Polls</a>
				<ul>
					<li><a href="#">Conduct a Poll</a></li>
					<li><a href="#">View Poll Results</a></li>
				</ul></li>
			<li><a href="http://communityadda.appspot.com/">Classifieds</a>
				<ul>
					<li><a href="#">Post Classified</a></li>
					<li><a href="#">View Classifieds</a></li>
				</ul></li>
		</ul>
	</div>
</div>
<script>
	$(function() {
		$("#menu").menubar({
			autoExpand : true,
			menuIcon : true,
			buttons : true
		});
		//$('li.ui-menu-item a.ui-corner-all').addClass('ui-widget-header');
	});
</script>