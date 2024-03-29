<style>
div#facility-contain {
	margin: 20px 0;
	width: 100%;
}

div#facility-contain table {
	margin: 1em 0;
	border-collapse: collapse;
	width: 100%;
}

div#facility-contain table td,div#facility-contain table th {
	border: 1px solid #eee;
	padding: .6em 10px;
	text-align: left;
}

.inputClass {
	display: block;
	width: 400px;
	padding: .2em;
}
</style>
<script>
	$(function() {
		$('#facility-contain')
				.jtable(
						{
							title : <strong> 'Facilities in Society' </strong>,
							jqueryuiTheme : true,
							paging : true,
							pageSize : 2,
							pageSizes : [ 2, 5, 10, 15, 20, 25 ],
							defaultSorting : 'AssetID ASC',
							deleteConfirmation : function(data) {
								data.deleteConfirmMessage = 'Are you sure you want to delete the Facility   '
										+ data.record.facilityName + '?';

							},
							sorting : true,
							actions : {
								listAction : 'masterdata',
								createAction : 'masterdata',
								updateAction : 'masterdata',
								deleteAction : 'masterdata?userAction=Delete_Facility_Details'
							},
							fields : {
								facilityID : {
									key : true,
									list : false,
									create : false,
									edit : true,
									display : function(data) {
										return data.record.facilityID.id;
									},
									input : function(data) {
										if (data.record) {
											return '<input type="hidden" name="facilityID" value="' + data.record.facilityID.id + '" />';
										}
									}
								},
								userAction : {
									create : true,
									edit : true,
									defaultValue : 'Update_facility_Details',
									input : function(data) {
										return '<input type="hidden" name="userAction" value="Update_facility_Details" />';
									},
									list : false
								},
								facilityName : {
									title : 'Facility <br/> Name',
									width : '15%',
									inputClass : 'text  ui-widget-content ui-corner-all inputClass',
								},
								facilityType : {
									title: 'Type',
				                	width: '7%',
				                	display: function (data){
				                		return data.record.facilityType.facilityType;
				                	},
				                	options:'masterdata?userAction=Get_Facility_Type_Options',
				                	inputClass: 'text  ui-widget-content ui-corner-all inputClass'
				                	},
								facilityLocation : {
									title : 'Location',
									width : '15%',
									inputClass : 'text  ui-widget-content ui-corner-all inputClass',
								},
														
								
							}
						});
		$('#facility-contain').jtable('load', {
			userAction : 'Get_Facility_Details'
		});
	});
</script>



<div id="facility-contain" class="ui-widget"></div>