<style>
div#purchaseorders-contain {
	margin: 20px 0;
	width: 100%;
}

div#purchaseorders-contain table {
	margin: 1em 0;
	border-collapse: collapse;
	width: 100%;
}

div#purchaseorders-contain table td,div#purchaseorders-contain table th {
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
		$('#purchaseorders-contain')
				.jtable(
						{
							title : 'PurchaseOrders',
							jqueryuiTheme : true,
							paging : true,
							pageSize : 2,
							pageSizes : [ 2, 5, 10, 15, 20, 25 ],
							defaultSorting : 'purchaseOrderID ASC',
							deleteConfirmation : function(data) {
								data.deleteConfirmMessage = 'Are you sure you want to delete the PurchaseOrder record  '
										+ data.record.purchaseOrderNumber + '?';

							},
							sorting : true,
							actions : {
								listAction : 'accounting',
								createAction : 'accounting',
								updateAction : 'accounting',
								deleteAction : 'accounting?userAction=Delete_PurchaseOrder_Details'
							},
							fields : {
								purchaseOrderID : {
									key : true,
									list : false,
									create : false,
									edit : true,
									display : function(data) {
										return data.record.purchaseorderID.id;
									},
									input : function(data) {
										if (data.record) {
											return '<input type="hidden" name="purchaseorderID" value="' + data.record.purchaseorderID.id + '" />';
										}
									}
								},
								userAction : {
									create : true,
									edit : true,
									defaultValue : 'Update_PurchaseOrder_Details',
									input : function(data) {
										return '<input type="hidden" name="userAction" value="Update_PurchaseOrder_Details" />';
									},
									list : false
								},
								purchaseOrderNumber : {
									title : 'PO<br/>Number',
									width : '10%',
									inputClass : 'text  ui-widget-content ui-corner-all inputClass',
								},								
								purchaseOrderAmount : {
									title : 'PO Amount',
									width : '7%',
									inputClass : 'text  ui-widget-content ui-corner-all inputClass',
								},
								purchaseOrderFor : {
									title : 'Vendor',
									width : '15%',
									inputClass : 'text  ui-widget-content ui-corner-all inputClass',
								},
								purchaseOrderDescription : {
									title : 'Details',
									width : '10%',
									inputClass : 'text  ui-widget-content ui-corner-all inputClass',
								},
								expenseType : {
									title: 'Category',
				                	width: '10%',
				                	
				                	display: function (data){
				                	var expenseType = "";
		                				if(data.record.expenseType != null){
		                					expenseType = data.record.expenseType.expenseType;
		                				}
		                			return expenseType;
		                			},									                	
		                	     	options:'accounting?userAction=Get_Expense_Options',
				                	inputClass: 'text  ui-widget-content ui-corner-all inputClass'
				                },
								purchaseOrderDate : {
									title : 'Date',
									width : '10%',
									inputClass : 'text  ui-widget-content ui-corner-all inputClass',
									type : 'date',
									displayFormat : 'dd-mm-yy'
								}
							}
						});
		$('#purchaseorders-contain').jtable('load', {
			userAction : 'Get_PurchaseOrder_Details'
		});
	});
</script>


<div id="purchaseorders-contain" class="ui-widget"></div>