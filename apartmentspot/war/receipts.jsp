<style>
div#receipts-contain {
	margin: 20px 0;
	width: 100%;
}

div#receipts-contain table {
	margin: 1em 0;
	border-collapse: collapse;
	width: 100%;
}

div#receipts-contain table td,div#receipts-contain table th {
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
		$('#receipts-contain')
				.jtable(
						{
							title : 'Receipts',
							jqueryuiTheme : true,
							paging : true,
							pageSize : 2,
							pageSizes : [ 2, 5, 10, 15, 20, 25 ],
							defaultSorting : 'receiptID ASC',
							deleteConfirmation : function(data) {
								data.deleteConfirmMessage = 'Are you sure you want to delete the Receipt record  '
										+ data.record.receiptNO + '?';

							},
							sorting : true,
							actions : {
								listAction : 'accounting',
								createAction : 'accounting',
								updateAction : 'accounting',
								deleteAction : 'accounting?userAction=Delete_Receipt_Details'
							},
							fields : {
								receiptID : {
									key : true,
									list : false,
									create : false,
									edit : true,
									display : function(data) {
										return data.record.receiptID.id;
									},
									input : function(data) {
										if (data.record) {
											return '<input type="hidden" name="receiptID" value="' + data.record.receiptID.id + '" />';
										}
									}
								},
								userAction : {
									create : true,
									edit : true,
									defaultValue : 'Update_Receipt_Details',
									input : function(data) {
										return '<input type="hidden" name="userAction" value="Update_Receipt_Details" />';
									},
									list : false
								},
								receiptNumber : {
									title : 'Number',
									width : '10%',
									inputClass : 'text  ui-widget-content ui-corner-all inputClass',
								},
								receiptTo : {
									title : 'Receipient',
									width : '20%',
									inputClass : 'text  ui-widget-content ui-corner-all inputClass',
								},
								receiptAmount : {
									title : 'Amount',
									width : '7%',
									inputClass : 'text  ui-widget-content ui-corner-all inputClass',
								},
								receiptDescription : {
									title : 'Details',
									width : '7%',
									inputClass : 'text  ui-widget-content ui-corner-all inputClass',
								},
								receiptType : {
									title: 'Towards',
				                	width: '7%',
				                	display: function (data){
				                		return data.record.billingHeadType.billingHeadType;
				                	},
				                	options:'accounting?userAction=Get_BillingHead_Options',
				                	inputClass: 'text  ui-widget-content ui-corner-all inputClass'
				                	},
								receiptDate : {
									title : 'Date',
									width : '15%',
									inputClass : 'text  ui-widget-content ui-corner-all inputClass',
									type : 'date',
									displayFormat : 'dd-mm-yy'
								},
								totalreceipts : {
									title : 'Total <br/> Receipts',
									width : '8%',
									inputClass : 'text  ui-widget-content ui-corner-all inputClass',
								}
							}
						});
		$('#receipts-contain').jtable('load', {
			userAction : 'Get_Receipt_Details'
		});
	});
</script>


<div id="receipts-contain" class="ui-widget"></div>