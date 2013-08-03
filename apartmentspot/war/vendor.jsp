<style>
div#vendor-contain {
	margin: 20px 0;
	width: 100%;
}

div#vendor-contain table {
	margin: 1em 0;
	border-collapse: collapse;
	width: 100%;
}

div#vendor-contain table td,div#vendor-contain table th {
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
		$('#vendor-contain')
				.jtable(
						{
							title : <strong> 'Vendors OR Service Providers to Society' </strong>,
							jqueryuiTheme : true,
							paging : true,
							pageSize : 2,
							pageSizes : [ 2, 5, 10, 15, 20, 25 ],
							defaultSorting : 'AssetID ASC',
							deleteConfirmation : function(data) {
								data.deleteConfirmMessage = 'Are you sure you want to delete the Vendor   '
										+ data.record.vendorName + '?';

							},
							sorting : true,
							actions : {
								listAction : 'masterdata',
								createAction : 'masterdata',
								updateAction : 'masterdata',
								deleteAction : 'masterdata?userAction=Delete_Vendor_Details'
							},
							fields : {
								vendorID : {
									key : true,
									list : false,
									create : false,
									edit : true,
									display : function(data) {
										return data.record.vendorID.id;
									},
									input : function(data) {
										if (data.record) {
											return '<input type="hidden" name="vendorID" value="' + data.record.vendorID.id + '" />';
										}
									}
								},
								userAction : {
									create : true,
									edit : true,
									defaultValue : 'Update_vendor_Details',
									input : function(data) {
										return '<input type="hidden" name="userAction" value="Update_Vendor_Details" />';
									},
									list : false
								},
								vendorName : {
									title : 'Vendor <br/> Name',
									width : '15%',
									inputClass : 'text  ui-widget-content ui-corner-all inputClass',
								},
								vendorType : {
									title: 'Type',
				                	width: '7%',
				                	display: function (data){
				                		return data.record.vendorType.vendorType;
				                	},
				                	options:'masterdata?userAction=Get_Vendor_Type_Options',
				                	inputClass: 'text  ui-widget-content ui-corner-all inputClass'
				                	},
								vendorLocation : {
									title : 'Address',
									width : '15%',
									inputClass : 'text  ui-widget-content ui-corner-all inputClass',
								},
								vendorContact : {
									title : 'Contacts',
									width : '15%',
									inputClass : 'text  ui-widget-content ui-corner-all inputClass',
								},
								vendorPAN : {
									title : 'PAN',
									width : '15%',
									inputClass : 'text  ui-widget-content ui-corner-all inputClass',
								},
								vendorTAN : {
									title : 'TAN',
									width : '15%',
									inputClass : 'text  ui-widget-content ui-corner-all inputClass',
								},
														
								
							}
						});
		$('#vendor-contain').jtable('load', {
			userAction : 'Get_Vendor_Details'
		});
	});
</script>



<div id="vendor-contain" class="ui-widget"></div>