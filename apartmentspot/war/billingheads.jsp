<%@ page
	import="com.viraneel.apartmentspot.valuebeans.UserSessionProfile"%>
<%@ page import="com.viraneel.apartmentspot.entities.BillingHeads"%>
<%@ page import="com.viraneel.apartmentspot.entities.Refund"%>
<%@ page import="com.viraneel.apartmentspot.entities.Receipt"%>
<%@ page import="com.viraneel.apartmentspot.entities.Accounting"%>
<%@ page import="com.viraneel.apartmentspot.entities.Society"%>

<%!private String getVal(String str) {
		String returnStr = "";
		if (str != null) {
			returnStr = str;
		}
		return returnStr;
	}%>
<%
	UserSessionProfile userSessProfile = (UserSessionProfile) session
			.getAttribute("userSessionProfile");

	String billingHead1 = "";
	String billingHead2 = "";
	String billingHead3 = "";
	String billingHead4 = "";
	String billingHead5 = "";
	String billingHead6 = "";
	String billingHead7 = "";
	String billingHead8 = "";
	String billingHead9 = "";
	String billingHead10 = "";
	String billingHead11 = "";
	String billingHead12 = "";
	
	if (null != userSessProfile) {
		Society soc = userSessProfile.getCurrentSociety();
		BillingHeads bh = userSessProfile.getBillingHeads();
		billingHeadID = getVal(soc.getBillingIDfromSocietyID().toString());
		billingHead1 = getVal(bh.getBillingHead1());
		billingHead2 = getVal(bh.getBillingHead2());
		billingHead3 = getVal(bh.getBillingHead3());
		billingHead4 = getVal(bh.getBillingHead4());
		billingHead5 = getVal(bh.getBillingHead5());
		billingHead6 = getVal(bh.getBillingHead6());
		billingHead7 = getVal(bh.getBillingHead7());
		billingHead8 = getVal(bh.getBillingHead8());
		billingHead9 = getVal(bh.getBillingHead9());
		billingHead10 = getVal(bh.getBillingHead10());
		billingHead11 = getVal(bh.getBillingHead11());
		billingHead12 = getVal(bh.getBillingHead12());
		
		
		
		
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


<form name="frmBillingHeads" id="frmBillingHeads" method="post"
	action="accounting">
	<input type="hidden" name="userAction" value="Update_BillingHeads_Details" />
	<input type="hidden" name="billingHeadID" id="billingHeadID"
		value="<%=billingHeadID%>" />
	<fieldSet>
		<div>
			<label for="billingHead1">Billing Head 1*</label> <input type="text"
				class="text  ui-widget-content ui-corner-all" name="billingHead1"
				value="<%=billingHead1%>"
				class="text  ui-widget-content ui-corner-all" />
		</div>

		<div>
			<label for="billingHead2">Billing Head 2</label> <input type="text"
				class="text  ui-widget-content ui-corner-all" name="billingHead2"
				value="<%=billingHead2%>"
				class="text  ui-widget-content ui-corner-all" />
		</div>

		<div>
			<label for="billingHead3">Billing Head 3</label> <input type="text"
				class="text  ui-widget-content ui-corner-all" name="billingHead3"
				value="<%=billingHead3%>"
				class="text  ui-widget-content ui-corner-all" />
		</div>

		<div>
			<label for="billingHead4">Billing Head 4</label> <input type="text"
				class="text  ui-widget-content ui-corner-all" name="billingHead4"
				value="<%=billingHead4%>"
				class="text  ui-widget-content ui-corner-all" />
		</div>

		<div>
			<label for="billingHead5">Billing Head 5</label> <input type="text"
				class="text  ui-widget-content ui-corner-all" name="billingHead5"
				value="<%=billingHead5%>"
				class="text  ui-widget-content ui-corner-all" />
		</div>

		<div>
			<label for="billingHead6">Billing Head 6</label> <input type="text"
				class="text  ui-widget-content ui-corner-all" name="billingHead6"
				value="<%=billingHead6%>"
				class="text  ui-widget-content ui-corner-all" />
		</div>

		<div>
			<label for="billingHead7">Billing Head 7</label> <input type="text"
				class="text  ui-widget-content ui-corner-all" name="billingHead7"
				value="<%=billingHead7%>"
				class="text  ui-widget-content ui-corner-all" />
		</div>

		<div>
			<label for="billingHead8">Billing Head 8</label> <input type="text"
				class="text  ui-widget-content ui-corner-all" name="billingHead8"
				value="<%=billingHead8%>"
				class="text  ui-widget-content ui-corner-all" />
		</div>

		<div>
			<label for="billingHead9">Billing Head 9</label> <input type="text"
				class="text  ui-widget-content ui-corner-all" name="billingHead9"
				value="<%=billingHead9%>"
				class="text  ui-widget-content ui-corner-all" />
		</div>

		<div>
			<label for="billingHead10">Billing Head 10</label> <input type="text"
				class="text  ui-widget-content ui-corner-all" name="billingHead10"
				value="<%=billingHead10%>"
				class="text  ui-widget-content ui-corner-all" />
		</div>

		<div>
			<label for="billingHead11">Billing Head 11</label> <input type="text"
				class="text  ui-widget-content ui-corner-all" name="billingHead11"
				value="<%=billingHead11%>"
				class="text  ui-widget-content ui-corner-all" />
		</div>

		<div>
			<label for="billingHead12">Billing Head 12</label> <input type="text"
				class="text  ui-widget-content ui-corner-all" name="billingHead12"
				value="<%=billingHead12%>"
				class="text  ui-widget-content ui-corner-all" />
		</div>

		


		<p align="center">
			<input type="button" value="Save" name="btnSavebillingHeads"
				id="btnSavebillingHeads" />&nbsp;<input type="button"
				value="Reset" name="btnReset" id="btnReset" />
		</p>
	</fieldSet>
</form>
<div id="dialog-message" title="Data Saved Successfully">
	<p>
		<span class="ui-icon ui-icon-circle-check"
			style="float: left; margin: 0 7px 50px 0;"></span> Billing Heads updated successfully.
	</p>
	
</div>
<script>
	
			
		$("input[type=button]").button().click(
				function(event) {
					var url = "accounting"; // the script where you handle the form input.

					$.ajax({
						type : "POST",
						url : url,
						data : $("#frmBillingHeads").serialize(), // serializes the form's elements.
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

