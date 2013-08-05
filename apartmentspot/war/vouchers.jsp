<style>
div#vouchers-contain {
	margin: 20px 0;
	width: 100%;
}

div#vouchers-contain table {
	margin: 1em 0;
	border-collapse: collapse;
	width: 100%;
}

div#vouchers-contain table td,div#vouchers-contain table th {
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
		$('#vouchers-contain')
				.jtable(
						{
							title : 'Petty Cash & Vouchers',
							jqueryuiTheme : true,
							paging : true,
							pageSize : 2,
							pageSizes : [ 2, 5, 10, 15, 20, 25 ],
							defaultSorting : 'voucherID ASC',
							deleteConfirmation : function(data) {
								data.deleteConfirmMessage = 'Are you sure you want to delete the Voucher record  '
										+ data.record.voucherNumber + '?';

							},
							sorting : true,
							actions : {
								listAction : 'accounting',
								createAction : 'accounting',
								updateAction : 'accounting',
								deleteAction : 'accounting?userAction=Delete_Voucher_Details'
							},
							fields : {
								voucherID : {
									key : true,
									list : false,
									create : false,
									edit : true,
									display : function(data) {
										return data.record.voucherID.id;
									},
									input : function(data) {
										if (data.record) {
											return '<input type="hidden" name="voucherID" value="' + data.record.voucherID.id + '" />';
										}
									}
								},
								userAction : {
									create : true,
									edit : true,
									defaultValue : 'Update_Voucher_Details',
									input : function(data) {
										return '<input type="hidden" name="userAction" value="Update_Voucher_Details" />';
									},
									list : false
								},
								voucherNumber : {
									title : 'Number',
									width : '10%',
									inputClass : 'text  ui-widget-content ui-corner-all inputClass',
								},
								voucherFor : {
									title : 'Recepient',
									width : '20%',
									inputClass : 'text  ui-widget-content ui-corner-all inputClass',
								},
								voucherAmount : {
									title : 'Amount',
									width : '7%',
									inputClass : 'text  ui-widget-content ui-corner-all inputClass',
								},
								voucherDescription : {
									title : 'Details',
									width : '7%',
									inputClass : 'text  ui-widget-content ui-corner-all inputClass',
								},
								voucherType : {
									title: 'Towards',
				                	width: '7%',
				                	display: function (data){
				                		return data.record.voucherType.voucherType;
				                	},
				                	options:'accounting?userAction=Get_Voucher_Options',
				                	inputClass: 'text  ui-widget-content ui-corner-all inputClass'
				                	},
								voucherDate : {
									title : 'Date',
									width : '15%',
									inputClass : 'text  ui-widget-content ui-corner-all inputClass',
									type : 'date',
									displayFormat : 'dd-mm-yy'
								},
								totalvouchers : {
									title : 'Total <br/> Vouchers',
									width : '8%',
									inputClass : 'text  ui-widget-content ui-corner-all inputClass',
								}
							}
						});
		$('#vouchers-contain').jtable('load', {
			userAction : 'Get_Voucher_Details'
		});
	});
</script>


<div id="vouchers-contain" class="ui-widget"></div>