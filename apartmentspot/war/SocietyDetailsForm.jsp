<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page
	import="com.viraneel.apartmentspot.valuebeans.UserSessionProfile"%>
<%@ page import="com.viraneel.apartmentspot.entities.Society"%>
<%@ page import="com.viraneel.apartmentspot.entities.Member"%>
<%!private String getVal(String str) {
		String returnStr = "";
		if (str != null) {
			returnStr = str;
		}
		return returnStr;
	}%>
<%
System.out.println("society details called");
	UserSessionProfile userSessProfile = (UserSessionProfile) session
			.getAttribute("userSessionProfile");

	String societyID = "";
	String societyEmail = "";
	String societyName = "";
	String surveyNumber = "";
	String registrationNumber = "";
	String registrationDate = "";
	String road = "";
	String area = "";
	String landmark = "";
	String city = "";
	String state = "";
	String country = "";
	String zip = "";
	String phone = "";
	String fax = "";
	String builderName = "";
	String builderAddress = "";
	if (null != userSessProfile) {
		Society soc = userSessProfile.getCurrentSociety();
		societyID = getVal(soc.getSocietyID().toString());
		societyEmail = getVal(soc.getEmail());
		societyName = getVal(soc.getName());
		surveyNumber = getVal(soc.getSurveyNumber());
		registrationNumber = getVal(soc.getRegistrationNumber());
		registrationDate = getVal(soc.getRegistrationDate());
		road = getVal(soc.getRoad());
		area = getVal(soc.getArea());
		landmark = getVal(soc.getLandmark());
		city = getVal(soc.getCity());
		state = getVal(soc.getState());
		country = getVal(soc.getCountry());
		zip = getVal(soc.getZip());
		phone = getVal(soc.getPhone());
		fax = getVal(soc.getFax());
		builderName = getVal(soc.getBuilderName());
		builderAddress = getVal(soc.getBuilderAddress());
	}
%>
<style>
label {
	display: block;
	float: left;
	width: 30%;
	text-align: left;
	padding: .2em;
	font-weight: 700;
}

input.text {
	display: block;
	width: 55%;
	padding: .4em;
	margin: 10 10 10 10px;
}

fieldset {
	padding: 0;
	border: 0;
	margin-top: 25px;
	width: 80%;
}

fieldset>div {
	margin-bottom: 5px;
}

.ui-autocomplete-loading {
	background: white url('/css/themes/start/images/ui-anim_basic_16x16.gif') right center
		no-repeat;
}

</style>


<form name="frmSocietyDetails" id="frmSocietyDetails" method="post"
	action="masterdata">
	<input type="hidden" name="userAction" value="Update_Society_Details" />
	<input type="hidden" name="societyID" id="societyID"
		value="<%=societyID%>" />
	<fieldSet>
		<div>
			<label for="societyName">Name *</label> <input type="text"
				class="text  ui-widget-content ui-corner-all" name="societyName"
				value="<%=societyName%>"
				class="text  ui-widget-content ui-corner-all" />
		</div>

		<div>
			<label for="">Road</label><input type="text"
				class="text  ui-widget-content ui-corner-all" name="road"
				value="<%=road%>" />
		</div>
		<div>
			<label for="">Area</label><input type="text"
				class="text  ui-widget-content ui-corner-all" name="area" id="area"
				value="<%=area%>" />
		</div>
		<div>
			<label for="">Landmark</label> <input type="text" name="landmark"
				id="landmark" value="<%=landmark%>"
				class="text  ui-widget-content ui-corner-all" name="builderName" />
		</div>
		<div>
			<label for="">City</label><input type="text"
				class="text  ui-widget-content ui-corner-all" name="city" id="city"
				value="<%=city%>" /> Powered by <a href="http://geonames.org">geonames.org</a>
		</div>
		<div>
			<label for="">State</label><input type="text"
				class="text  ui-widget-content ui-corner-all" name="state" id="state"
				value="<%=state%>" />
		</div>
		<div>
			<label for="">Country</label><input type="text"
				class="text  ui-widget-content ui-corner-all" name="country" id="country"
				value="<%=country%>" />
		</div>
		<div>
			<label for="">PIN/ZIP</label><input type="text"
				class="text  ui-widget-content ui-corner-all" name="zip"
				value="<%=zip%>" />
		</div>
		<div>
			<label for="">Phone</label><input type="text"
				class="text  ui-widget-content ui-corner-all" name="phone"
				value="<%=phone%>" />
		</div>
		<div>
			<label for="">FAX</label><input type="text"
				class="text  ui-widget-content ui-corner-all" name="fax"
				value="<%=fax%>" />
		</div>
		<div>
			<label for="">Email</label><input type="text"
				class="text  ui-widget-content ui-corner-all" name="email"
				value="<%=societyEmail%>" />
		</div>
		<div>
			<label for="">Survey No</label><input type="text"
				class="text  ui-widget-content ui-corner-all" name="surveyNumber"
				value="<%=surveyNumber%>" />
		</div>
		<div>
			<label for="">Registration No</label><input type="text"
				class="text  ui-widget-content ui-corner-all"
				name="registrationNumber" id="registrationNumber"
				value="<%=registrationNumber%>" />
		</div>
		<div>
			<label for="">Registration Date</label><input type="text"
				class="text  ui-widget-content ui-corner-all"
				name="registrationDate" id="registrationDate"
				value="<%=registrationDate%>" />
		</div>
		<div>
			<label for="">Name of the builder</label><input type="text"
				class="text  ui-widget-content ui-corner-all" name="builderName"
				value="<%=builderName%>" />

		</div>
		<div>
			<label for="builderAddress">Address of the builder</label> <input
				name="builderAddress" id="builderAddress"
				value="<%=builderAddress%>"
				class="text  ui-widget-content ui-corner-all" name="builderName" />
		</div>
		<p align="center">
			<input type="button" value="Save" name="btnSaveSocietyDetails"
				id="btnSaveSocietyDetails" />&nbsp;<input type="button"
				value="Reset" name="btnReset" id="btnReset" />
		</p>
	</fieldSet>
</form>
<div id="dialog-message" title="Data Saved Successfully">
	<p>
		<span class="ui-icon ui-icon-circle-check"
			style="float: left; margin: 0 7px 50px 0;"></span> Society
		Information is updated successfully in our database.
	</p>
	<p>
		Currently we are verifying the information you entered. After
		verification you will recieve the mail. <b>This is done to avoid
			frauds</b>.
	</p>
</div>
<script>
	$(function() {
		$("#registrationDate").datepicker();
	
		
		$("#dialog-message").dialog({
			autoOpen : false,
			modal : true,
			buttons : {
				Ok : function() {
					$(this).dialog("close");
				}
			}
		});
		function log(message) {
			//alert(message);
			var arr = message.split(",");
			//alert(arr.length);
			if(arr.length == 3){
				$("#state").val(jQuery.trim(arr[1]));
				$("#country").val(jQuery.trim(arr[2]));	
				//alert(message);
			}
			
		};

		$("#city").autocomplete(
				{
					source : function(request, response) {
						$.ajax({
							url : "http://ws.geonames.org/searchJSON",
							dataType : "jsonp",
							data : {
								featureClass : "P",
								style : "full",
								maxRows : 25,
								name_startsWith : request.term
							},
							success : function(data) {
								response($.map(data.geonames, function(item) {
									return {
										label : item.name
												+ (item.adminName1 ? ", "
														+ item.adminName1 : "")
												+ ", " + item.countryName,
										value : item.name
									}
								}));
							}
						});
					},
					minLength : 2,
					select : function(event, ui) {
						log(ui.item ? ui.item.label
								: this.value);
					},
					open : function() {
						$(this).removeClass("ui-corner-all").addClass(
								"ui-corner-top");
					},
					close : function() {
						$(this).removeClass("ui-corner-top").addClass(
								"ui-corner-all");
					}
				});				
		$("input[type=button]").button().click(
				function(event) {
					var url = "masterdata"; // the script where you handle the form input.

					$.ajax({
						type : "POST",
						url : url,
						data : $("#frmSocietyDetails").serialize(), // serializes the form's elements.
						success : function(data) {
							//alert(data); // show response from the php script.
							$("#dialog-message")
									.dialog("option", "title", data).dialog(
											"open");
						}
					});

					return false;

				});
	
	});
</script>

