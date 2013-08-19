
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
							title : 'Members in Group',
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
								memberRole : {
									title : 'Role in Group',
									width : '7%',
									display : function(data) {
										var roleName = "";
										if (data.record.memberRole != null) {
											roleName = data.record.memberRole.roleName;
										}
										return roleName;
									}

								},
								memberSince : {
									list : true,
									title : 'Member Since',
									inputClass : 'text  ui-widget-content ui-corner-all inputClass'
								}
							}

						});
		
		$('#groupmembers').jtable('load');
		
		
	});
</script>

<div id="groupmembers" class="ui-widget"></div>