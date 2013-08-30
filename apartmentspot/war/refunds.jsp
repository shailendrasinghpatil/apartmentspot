<style>
div#refunds-contain {
	margin: 20px 0;
	width: 100%;
}

div#refunds-contain table {
	margin: 1em 0;
	border-collapse: collapse;
	width: 100%;
}

div#refunds-contain table td,div#refunds-contain table th {
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
		$('#refunds-contain')
				.jtable(
						{
							title : 'Refunds',
							jqueryuiTheme : true,
							paging : true,
							pageSize : 2,
							pageSizes : [ 2, 5, 10, 15, 20, 25 ],
							defaultSorting : 'refundID ASC',
							deleteConfirmation : function(data) {
								data.deleteConfirmMessage = 'Are you sure you want to delete the Refund record  '
										+ data.record.refundNumber + '?';

							},
							sorting : true,
							actions : {
								listAction : 'accounting',
								createAction : 'accounting',
								updateAction : 'accounting',
								deleteAction : 'accounting?userAction=Delete_Refund_Details'
							},
							fields : {
								refundID : {
									key : true,
									list : false,
									create : false,
									edit : true,
									display : function(data) {
										return data.record.refundID.id;
									},
									input : function(data) {
										if (data.record) {
											return '<input type="hidden" name="refundID" value="' + data.record.refundID.id + '" />';
										}
									}
								},
								userAction : {
									create : true,
									edit : true,
									defaultValue : 'Update_Refund_Details',
									input : function(data) {
										return '<input type="hidden" name="userAction" value="Update_Refund_Details" />';
									},
									list : false
								},
								refundNumber : {
									title : 'Refund<br/>No',
									width : '10%',
									inputClass : 'text  ui-widget-content ui-corner-all inputClass',
								},
								refundTo : {
									title : 'Refunded<br/>To',
									width : '10%',
									inputClass : 'text  ui-widget-content ui-corner-all inputClass',
								},
								
								refundReason : {
									title : 'Refund<br/>Reason',
									width : '20%',
									inputClass : 'text  ui-widget-content ui-corner-all inputClass',
								},
								refundAmount : {
									title : 'Amount',
									width : '7%',
									inputClass : 'text  ui-widget-content ui-corner-all inputClass',
								},
								refundPaymentDetails : {
									title : 'Details',
									width : '7%',
									inputClass : 'text  ui-widget-content ui-corner-all inputClass',
								},
								refundType : {
									title: 'Towards',
				                	width: '15%',
				                	display: function (data){
				                		var refundType = "";
		                					if(data.record.billingHeadType != null){
		                						refundType = data.record.billingHeadType.billingHeadType;
		                					}
		                				return refundType;
				                		},					    
				                		
				                	options:'accounting?userAction=Get_BillingHead_Options',
				                	inputClass: 'text  ui-widget-content ui-corner-all inputClass'
				                	},
								refundDate : {
									title : 'Date',
									width : '15%',
									inputClass : 'text  ui-widget-content ui-corner-all inputClass',
									type : 'date',
									displayFormat : 'yy-mm-dd'
								}
							}
						});
		$('#refunds-contain').jtable('load', {
			userAction : 'Get_Refund_Details'
		});
	});
</script>


<div id="refunds-contain" class="ui-widget"></div>