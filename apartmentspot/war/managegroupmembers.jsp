
<style>
div#groupmembers {
	margin: 20px 0;
	width: 100%;
}

div#groupmembers table {
	margin: 1em 0;
	border-collapse: collapse;
	width: 100%;
}

div#groupmembers table td,div#groupmembers table th {
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
		
		$('#groupmembers')
				.jtable(
						{
							title : 'Members in Society',
							jqueryuiTheme : true,
							selecting : true, //Enable selecting
							multiselect : true, //Allow multiple selecting
							selectingCheckboxes : true,
							paging : true,
							pageSize : 20,
							pageSizes : [ 20, 50, 75, 100, 200, 500 ],
							defaultSorting : 'fullName ASC',
							sorting : true,
							actions : {
								listAction : 'group'
							},
							fields : {
								groupID : {
									key : true,
									list : false
								},
								memberID : {
									key : true,
									list : false
								},

								fullName : {
									create : false,
									edit : false,
									title : 'Name',
									width : '15%'
								},
	/*							memberRole : {
									create : false,
									edit : false,
									list : true,
									title : 'Role in Group',
									width : '7%',
									display : function(data) {
										var roleName = "";
										if (data.record.memberRole != null) {
											roleName = data.record.memberRole.roleName;
										}
										return roleName;
									}

								},*/
								sinceDate : {
									list : true,
									title : 'Member Since',
									inputClass : 'text  ui-widget-content ui-corner-all inputClass'
								}
							},
							
							recordsLoaded : function(event, data){								
								
										if(null != data.records){											
											$.each(data.records, function(index, record){
												if((null != record.sinceDate) && (null == record.toDate) ){
												var row = $("#groupmembers").jtable('getRowByKey', record.memberID);
													$("#groupmembers").jtable('selectRows',row);
												}		
											});
										}
							}

						});
		
		$('#groupmembers').jtable('load', {userAction : 'Get_All_Resident_Details', groupID:'<%=request.getParameter("groupID")%>'});
		
		
	});
</script>

<div id="groupmembers" class="ui-widget"></div>