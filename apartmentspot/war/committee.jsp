<style>
div#groups-contain {
	margin: 20px 0;
	width: 100%;
}

div#groups-contain table {
	margin: 1em 0;
	border-collapse: collapse;
	width: 100%;
}

div#groups-contain table td,div#groups-contain table th {
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
        $( "#dialog4" ).dialog({
            autoOpen: false,
            height:$(window).height() - 150,
            width:$(window).width() - 250,
                show: {
                effect: "blind",
                duration: 400,
                },

                hide: {
                effect: "explode",
                duration: 400
                },
                close: function (e) {
                    $(this).empty();
                   // $(this).dialog('destroy');
                },                
                open: function (){
                	var memberData = $(this).data('groupMemberData');
                	$(this).load("managegroupmembers.jsp?groupID=" + memberData.record.groupID.id);
                	//$(this).parent().appendTo("body");
                },
    			buttons : {
    				"Save" : function() {
    		           var $selectedRows = $('#groupmembers').jtable('selectedRows');
    		            var records = new Array ();
    		            $selectedRows.each(function () {
    		                var record = $(this).data('record');    		                
    		                records.push(record);
    		            });
    		            $.ajax({
    		            	  type: "POST",
    		            	  url: "group?userAction=Update_Resident_Details",
    		            	  data: {'selectedRows': '{"Records" : ' + JSON.stringify(records) + "}"},
    		            	  success: function (){
    		            		 var ul = $( "#dialog4" ).data("ul");
    		            		 ul.trigger('click');
    		            		 $( "#dialog4" ).dialog("close");  		            		  
    		            		  
    		            	  }

    		            	});
    				},
    				"Cancel" : function() {
    					$(this).dialog("close");
    				}    				
    			}
        });
        
		$('#groups-contain')
				.jtable(
						{
							title : 'Groups in Society',
							jqueryuiTheme : true,
							editColumns : 2,
							paging : true,
							pageSize : 20,
							pageSizes : [ 20, 50, 75, 100, 200, 500 ],
							defaultSorting : 'groupID ASC',
							deleteConfirmation : function(data) {
								data.deleteConfirmMessage = 'Are you sure to delete stop group '
										+ data.record.groupName + '?';
							},
							sorting : true,
							actions : {
								listAction : 'group',
								createAction : 'group',
								updateAction : 'group',
								deleteAction : 'group?userAction=Delete_Group_Details'
							},
							fields : {
								groupID : {
									key : true,
									list : false,
									create : false,
									edit : true,
									display : function(data) {
										return data.record.groupID.id;
									},
									input : function(data) {
										if (data.record) {
											return '<input type="hidden" name="groupID" value="' + data.record.groupID.id + '" />';
										}
									}
								},
								userAction : {
									create : true,
									edit : true,
									defaultValue : 'Update_Group_Details',
									input : function(data) {
										return '<input type="hidden" name="userAction" value="Update_Group_Details" />';
									},
									list : false
								},
								members :{
									create : false,
									edit : false,									
									title : '',
									width : '1%',
									inputClass : 'text  ui-widget-content ui-corner-all inputClass',
									display: function (memberData){
										var $ul = $('<a href="#" class="ui-icon ui-icon-plus"></a>');
										$ul.click(function (){
											$('#groups-contain').jtable('openChildTable', $ul.closest('tr'),
											{
									            title: 'Members in Group',
									            jqueryuiTheme:true,
									            editColumns: 2,
									            paging:false,
									            pageSize:5,
									            pageSizes:[5,10,20,50,100],
									            defaultSorting: 'fullName ASC',
									            deleteConfirmation: function(data) {
									                data.deleteConfirmMessage = 'Are you sure to delete  from group ' + data.record.fullName + '?';
									            },	            
									            sorting:false,
									            toolbar: {
									            	items:[{
									            		text: 'Add Members',
									            		click : function (){									            				
									                            $( "#dialog4").data('groupMemberData', memberData).data("ul", $ul).dialog("open");				            			
									            		}
									            	}]
									            },
									            actions: {
									                listAction: 'group',
									                deleteAction: 'group?userAction=Delete_Resident_Details&groupID=' + memberData.record.groupID.id
									            },
									            fields: {
									            	groupID :{
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
												/*	memberRole: {
														title: 'Role in Group',
														width : '7%',
														display: function (data){
															var roleName = "";
															if(data.record.memberRole != null){
																roleName = data.record.memberRole.roleName;
															}
									                		return roleName;
									                	}							
																								
									            	},			*/						            	
									            	sinceDate: {
														list : true,
														title : 'Member Since',
									            		inputClass : 'text  ui-widget-content ui-corner-all inputClass'
									            	}
									            
									            }
											}, 
											function (data) { //opened handler
			                                    data.childTable.jtable('load',{userAction : 'Get_Resident_Details', groupID:memberData.record.groupID.id});
			                                });
										});
										return $ul;
									}
									},
								groupName : {
									title : 'Name',
									width : '20%',
									inputClass : 'text  ui-widget-content ui-corner-all inputClass'
								},
								groupDescription : {
									title : 'Description',
									width : '40%',
									type : 'textarea',
									inputClass : 'text  ui-widget-content ui-corner-all inputClass'
								},
								createdDate : {
									create : false,
									edit : false,										
									title : 'Created On',
									width : '15%',
									inputClass : 'text  ui-widget-content ui-corner-all inputClass'
								},
								endDate : {
									create : false,
									edit : false,										
									title : 'Stopped On',
									width : '15%',
									inputClass : 'text  ui-widget-content ui-corner-all inputClass'
								}
								
							},

							formCreated : function(event, data) {

								if (data.formType == 'edit') {

								}

							}

						});
		$('#groups-contain').jtable('load', {
			userAction : 'Get_Group_Details'
		});
		
	});
	
</script>

<div id="groups-contain" class="ui-widget"></div>
   <div id="dialog4" title="Add/Remove Members">
        <div class="content4"></div>
    </div>