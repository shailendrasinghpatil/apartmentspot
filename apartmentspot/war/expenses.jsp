<style>
div#expenses-contain {
	margin: 20px 0;
	width: 100%;
}

div#expenses-contain table {
	margin: 1em 0;
	border-collapse: collapse;
	width: 100%;
}

div#expenses-contain table td,div#expenses-contain table th {
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
		$('#expenses-contain')
				.jtable(
						{
							title : 'Expenses and Salaries',
							jqueryuiTheme : true,
							paging : true,
							pageSize : 2,
							pageSizes : [ 2, 5, 10, 15, 20, 25 ],
							defaultSorting : 'expenseID ASC',
							deleteConfirmation : function(data) {
								data.deleteConfirmMessage = 'Are you sure you want to delete the Expense record  '
										+ data.record.expenseNumber + '?';

							},
							sorting : true,
							actions : {
								listAction : 'accounting',
								createAction : 'accounting',
								updateAction : 'accounting',
								deleteAction : 'accounting?userAction=Delete_Expense_Details'
							},
							fields : {
								expenseID : {
									key : true,
									list : false,
									create : false,
									edit : true,
									display : function(data) {
										return data.record.expenseID.id;
									},
									input : function(data) {
										if (data.record) {
											return '<input type="hidden" name="expenseID" value="' + data.record.expenseID.id + '" />';
										}
									}
								},
								userAction : {
									create : true,
									edit : true,
									defaultValue : 'Update_Expense_Details',
									input : function(data) {
										return '<input type="hidden" name="userAction" value="Update_Expense_Details" />';
									},
									list : false
								},
								expenseNumber : {
									title : 'Number',
									width : '10%',
									inputClass : 'text  ui-widget-content ui-corner-all inputClass',
								},
								expenseDate : {
									title : 'Date',
									width : '15%',
									inputClass : 'text  ui-widget-content ui-corner-all inputClass',
									type : 'date',
									displayFormat : 'dd-mm-yy'
								},
								expenseFor : {
									title : 'Recepient',
									width : '20%',
									inputClass : 'text  ui-widget-content ui-corner-all inputClass',
								},
								expenseAmount : {
									title : 'Amount',
									width : '7%',
									inputClass : 'text  ui-widget-content ui-corner-all inputClass',
								},
								expenseDescription : {
									title : 'Details',
									width : '7%',
									inputClass : 'text  ui-widget-content ui-corner-all inputClass',
								},
								expenseType : {
									title: 'Towards',
				                	width: '7%',
				                	display: function (data){
				                		return data.record.expenseType.expenseType;
				                	},
				                	options:'accounting?userAction=Get_Expense_Options',
				                	inputClass: 'text  ui-widget-content ui-corner-all inputClass'
				                	},
								expenseDescription : {
									title : 'Details',
									width : '7%',
									inputClass : 'text  ui-widget-content ui-corner-all inputClass',
								},
								TDSdeducted : {
									title : 'TDS Deducted',
									width : '7%',
									inputClass : 'text  ui-widget-content ui-corner-all inputClass',
								},
								panDeductee : {
									title : 'PAN Payee',
									width : '7%',
									inputClass : 'text  ui-widget-content ui-corner-all inputClass',
								},
								tanDeductee : {
									title : 'TAN Payee',
									width : '7%',
									inputClass : 'text  ui-widget-content ui-corner-all inputClass',
								},
								totalexpenses : {
									title : 'Total <br/> Expenses',
									width : '8%',
									inputClass : 'text  ui-widget-content ui-corner-all inputClass',
								}
							}
						});
		$('#expenses-contain').jtable('load', {
			userAction : 'Get_Expense_Details'
		});
	});
</script>


<div id="expenses-contain" class="ui-widget"></div>