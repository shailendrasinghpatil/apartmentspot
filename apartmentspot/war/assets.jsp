<style>
div#assets-contain {
	margin: 20px 0;
	width: 100%;
}

div#assets-contain table {
	margin: 1em 0;
	border-collapse: collapse;
	width: 100%;
}

div#assets-contain table td,div#assets-contain table th {
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
		$('#assets-contain')
				.jtable(
						{
							title : 'Assets in Society',
							jqueryuiTheme : true,
							paging : true,
							pageSize : 2,
							pageSizes : [ 2, 5, 10, 15, 20, 25 ],
							defaultSorting : 'AssetID ASC',
							deleteConfirmation : function(data) {
								data.deleteConfirmMessage = 'Are you sure you want to delete Asset record? '
										+ data.record.assetName + '?';

							},
							sorting : true,
							actions : {
								listAction : 'masterdata',
								createAction : 'masterdata',
								updateAction : 'masterdata',
								deleteAction : 'masterdata?userAction=Delete_Asset_Details'
							},
							fields : {
								assetID : {
									key : true,
									list : false,
									create : false,
									edit : true,
									display : function(data) {
										return data.record.assetID.id;
									},
									input : function(data) {
										if (data.record) {
											return '<input type="hidden" name="assetID" value="' + data.record.assetID.id + '" />';
										}
									}
								},
								userAction : {
									create : true,
									edit : true,
									defaultValue : 'Update_Asset_Details',
									input : function(data) {
										return '<input type="hidden" name="userAction" value="Update_Asset_Details" />';
									},
									list : false
								},
								assetNO : {
									title : 'Asset <br/> Number',
									width : '10%',
									inputClass : 'text  ui-widget-content ui-corner-all inputClass',
								},
								assetName : {
									title : 'Asset <br/> Name',
									width : '15%',
									inputClass : 'text  ui-widget-content ui-corner-all inputClass',
								},
								asset_description : {
									title : 'Description',
									width : '20%',
									inputClass : 'text  ui-widget-content ui-corner-all inputClass',
								},
								quantity : {
									title : 'Quantity',
									width : '7%',
									inputClass : 'text  ui-widget-content ui-corner-all inputClass',
								},
								assetModel : {
									title : 'Model',
									width : '10%',
									inputClass : 'text  ui-widget-content ui-corner-all inputClass',
								},
								asset_purchase_date : {
									title : 'Purchase <br/> Date',
									width : '15%',
									inputClass : 'text  ui-widget-content ui-corner-all inputClass',
									type : 'date',
									displayFormat : 'yy-mm-dd'
								},
								asset_expiry_date : {
									title : 'Expiry <br/> Date',
									width : '15%',
									inputClass : 'text  ui-widget-content ui-corner-all inputClass',
									type : 'date',
									displayFormat : 'yy-mm-dd'
								},
								totalassets : {
									title : 'Total <br/> Assets',
									width : '8%',
									inputClass : 'text  ui-widget-content ui-corner-all inputClass',
								}
							}
						});
		$('#assets-contain').jtable('load', {
			userAction : 'Get_Asset_Details'
		});
	});
</script>




<div id="assets-contain" class="ui-widget"></div>