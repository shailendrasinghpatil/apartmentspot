
<style>
label {
	display: block;
	float: left;
	width: 30%px;
	text-align: left;
	padding: .2em;
	font-weight: 700;
}

#dialog-form {
	z-Index:999;
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

h1 {
	font-size: 1.2em;
	margin: .6em 0;
}

div#users-contain {
	width: 350px;
	margin: 20px 0;
}

div#users-contain table {
	margin: 1em 0;
	border-collapse: collapse;
	width: 100%;
}

div#users-contain table td,div#users-contain table th {
	border: 1px solid #eee;
	padding: .6em 10px;
	text-align: left;
}

.ui-dialog .ui-state-error {
	padding: .3em;
}

.validateTips {
	border: 1px solid transparent;
	padding: 0.3em;
}
</style>
<script>
	$(function() {
		var name = $("#name"), email = $("#email"), password = $("#password"), allFields = $(
				[]).add(name).add(email).add(password), tips = $(".validateTips");

		function updateTips(t) {
			tips.text(t).addClass("ui-state-highlight");
			setTimeout(function() {
				tips.removeClass("ui-state-highlight", 1500);
			}, 500);
		}

		function checkLength(o, n, min, max) {
			if (o.val().length > max || o.val().length < min) {
				o.addClass("ui-state-error");
				updateTips("Length of " + n + " must be between " + min
						+ " and " + max + ".");
				return false;
			} else {
				return true;
			}
		}

		function checkRegexp(o, regexp, n) {
			if (!(regexp.test(o.val()))) {
				o.addClass("ui-state-error");
				updateTips(n);
				return false;
			} else {
				return true;
			}
		}

		$("#dialog-form")
				.dialog(
						{
							autoOpen : false,
							height : 500,
							width : 600,
							modal : true,
							buttons : {
								"Save Apartment Details" : function() {
									var bValid = true;
									allFields.removeClass("ui-state-error");

									if (bValid) {
										
										$(this).dialog("close");
									}
								},
								Cancel : function() {
									$(this).dialog("close");
								}
							},
							close : function() {
								allFields.val("").removeClass("ui-state-error");
							}
						});

		$("#addApartment").button().click(function() {
			$("#dialog-form").dialog("open");
		});
	});
</script>

<div id="dialog-form" title="Add New House">
	<p class="validateTips">All form fields with asterisk(*) are
		required.</p>

	<form>
		<fieldset>
			<div>
				<label for="houseNo">House No *</label> <input type="text"
					name="houseNo" id="houseNo"
					class="text ui-widget-content ui-corner-all" />
			</div>
			<div>
				<label for="floorNo">Floor</label> <input type="text"
					name="floorNo" id="floorNo"
					class="text ui-widget-content ui-corner-all" />
			</div>			
			<div>
				<label for="houseType">House Type *</label> <select name="houseType"
					id="houseType" class="select ui-widget-content ui-corner-all">
					<option value="">Select</option>
					<option value="Flat">Flat</option>
					<option value="Duplex">Duplex</option>
					<option value="Independent">Independent</option>
					<option value="RowHouse">RowHouse</option>
					<option value="TwinBunglow">TwinBunglow</option>
				</select>
			</div>
			<div>
				<label for="houseName">House Name</label> <input type="text"
					name="houseName" id="houseName" value=""
					class="text ui-widget-content ui-corner-all" />
			</div>
			<div>
				<label for="buildingName">Building Name</label> <input type="text"
					name="buildingName" id="buildingName" value=""
					class="text ui-widget-content ui-corner-all" />
			</div>
			<div>
				<label for="buildingName">Intercom Number</label> <input type="text"
					name="intercomNo" id="intercomNo" value=""
					class="text ui-widget-content ui-corner-all" />
			</div>			
			<div>
				<label for="phaseName">Phase</label> <input type="text"
					name="phaseName" id="phaseName" value=""
					class="text ui-widget-content ui-corner-all" />
			</div>
			<div>
				<label for="wingName">Wing</label> <input type="text"
					name="wingName" id="wingName" value=""
					class="text ui-widget-content ui-corner-all" />
			</div>
			<div>
				<label for="plotNo">Plot No</label> <input type="text" name="plotNo"
					id="plotNo" value="" class="text ui-widget-content ui-corner-all" />
			</div>
			<div>
				<label for="totalArea">Total Area</label> <input type="text"
					name="totalArea" id="totalArea" value=""
					class="text ui-widget-content ui-corner-all" />
			</div>
			<div>
				<label for="builtUpArea">BuiltUp Area</label> <input type="text"
					name="builtUpArea" id="builtUpArea" value=""
					class="text ui-widget-content ui-corner-all" />
			</div>
			<div>
				<label for="carpetUpArea">Carpet Area</label> <input type="text"
					name="carpetArea" id="carpetArea" value=""
					class="text ui-widget-content ui-corner-all" />
			</div>
			<div>
				<label for="openSpaceArea">Open Space Area</label> <input
					type="text" name="openSpaceArea" id="openSpaceArea" value=""
					class="text ui-widget-content ui-corner-all" />
			</div>
			
			<div>
			 <label for="parkingSpotNo">Parking Spot</label>
			 <input type="text" name="partkingSpotNo" id="partkingSpotNo" value="" class="text ui-widget-content ui-corner-all"/>			
			</div>

		</fieldset>
	</form>
</div>


<div id="users-contain" class="ui-widget">
	<table id="users" class="ui-widget ui-widget-content">
		<thead>
			<tr class="ui-widget-header ">
				<th>Name</th>
				<th>Email</th>
				<th>Password</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>John Doe</td>
				<td>john.doe@example.com</td>
				<td>johndoe1</td>
			</tr>
		</tbody>
	</table>
</div>

<button id="addApartment">Add New House Detail</button>
