<style>
div#residents-contain {
	margin: 20px 0;
	width: 100%;
}

div#residents-contain table {
	margin: 1em 0;
	border-collapse: collapse;
	width: 100%;
}

div#residents-contain table td,div#residents-contain table th {
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
		$('#residents-contain')
				.jtable(
						{
							title : 'Residents in Society',
							jqueryuiTheme : true,
							editColumns : 2,
							paging : true,
							pageSize : 20,
							pageSizes : [ 20, 50, 75, 100, 200, 500 ],
							defaultSorting : 'fullName ASC',
							deleteConfirmation : function(data) {
								data.deleteConfirmMessage = 'Are you sure to delete record Resident '
										+ data.record.residentName + '?';
							},
							sorting : true,
							actions : {
								listAction : 'masterdata',
								createAction : 'masterdata',
								updateAction : 'masterdata',
								deleteAction : 'masterdata?userAction=Delete_Resident_Details'
							},
							fields : {
								memberID : {
									key : true,
									list : false,
									create : false,
									edit : true,
									display : function(data) {
										return data.record.memberID.id;
									},
									input : function(data) {
										if (data.record) {
											return '<input type="hidden" name="memberID" value="' + data.record.memberID.id + '" />';
										}
									}
								},
								userAction : {
									create : true,
									edit : true,
									defaultValue : 'Update_Resident_Details',
									input : function(data) {
										return '<input type="hidden" name="userAction" value="Update_Resident_Details" />';
									},
									list : false
								},
								houses : {
									create : false,
									edit : false,									
									title : '',
									width : '1%',
									inputClass : 'text  ui-widget-content ui-corner-all inputClass',
									display: function (houseData){
										var $ul = $('<a href="#" class="ui-icon ui-icon-home"></a>');
										$ul.click(function (){
											$('#residents-contain').jtable('openChildTable', $ul.closest('tr'),
											{
									            title: 'Resident\'s Houses in Society',
									            jqueryuiTheme:true,
									            editColumns: 2,
									            paging:false,
									            pageSize:3,
									            pageSizes:[3,5,10,20,50,100],
									            defaultSorting: 'houseNo ASC',
									            deleteConfirmation: function(data) {
									                data.deleteConfirmMessage = 'Are you sure to delete record House ' + data.record.houseName + '?';
									            },	            
									            sorting:false,
									            actions: {
									                listAction: 'masterdata',
									                createAction: 'masterdata',
									                updateAction: 'masterdata',
									                deleteAction: 'masterdata?userAction=Delete_House_Details'
									            },
									            fields: {
													memberID : {
														key : false,
														list : false,
														create : true,
														edit : true,
														input : function(data) {
															if (houseData.record) {
																return '<input type="hidden" name="memberID" value="' + houseData.record.memberID.id + '" />';
															}
														}
													},									            	
									            	houseID:{
									            		key: true,
									            		list: false,
									                    create: false,
									                    edit: true,
									                    display: function (data){	                    	
									                    	return data.record.houseID.id;
									                    },
									                    input: function (data) {
									                        if (data.record) {
									                            return '<input type="hidden" name="houseID" value="' + data.record.houseID.id + '" />';
									                        }
									                    }	    
									                },
									            	userAction: {
									            		create:true,
									            		edit:true,
									            		defaultValue:'Update_House_Details',
									                    input: function (data) {
									                            return '<input type="hidden" name="userAction" value="Update_House_Details" />';
									                    },	 	            		
									            		list:false
									            	},	                
													houseNo:{
									                	title: 'No',
									                	width: '7%',
									                	inputClass: 'text  ui-widget-content ui-corner-all inputClass'
									                },
													houseName:{
									                	title: 'Name',
									                	width: '7%',
									                	inputClass: 'text  ui-widget-content ui-corner-all inputClass'
									                },	                
													plotNo:{
									                	title: 'Plot#',
									                	width: '7%',
									                	inputClass: 'text  ui-widget-content ui-corner-all inputClass'
									                },
													intercomNo:{
									                	title: 'Intercom#',
									                	width: '10%',
									                	inputClass: 'text  ui-widget-content ui-corner-all inputClass'
									                },
													totalAreaSQFT:{
									                	title: 'Total Area',
									                	width: '10%',
									                	inputClass: 'text  ui-widget-content ui-corner-all inputClass'
									                },
													carpetAreaSQFT:{
									                	title: 'Carpet Area',
									                	width: '11%',
									                	inputClass: 'text  ui-widget-content ui-corner-all inputClass'
									                },
													builtupAreaSQFT:{
									                	title: 'Builtup Area',
									                	width: '11%',
									                	inputClass: 'text  ui-widget-content ui-corner-all inputClass'
									                },
													openSpaceAreaSQFT:{
									                	title: 'Open Space',
									                	width: '11%',
									                	inputClass: 'text  ui-widget-content ui-corner-all inputClass'
									                },
													building:{
									                	title: 'Building',
									                	width: '8%',
									                    display: function (data){	      
									                    	return data.record.building.buildingNO +  " "  + data.record.building.buildingName;
									                    },	                	
									                	options:'masterdata?userAction=Get_Building_Options',
									                	inputClass: 'text  ui-widget-content ui-corner-all inputClass'
									                },
													houseType:{
									                	title: 'Type',
									                	width: '7%',
									                	display: function (data){
									                		return data.record.houseType.houseType;
									                	},
									                	options:'masterdata?userAction=Get_House_Type_Options',
									                	inputClass: 'text  ui-widget-content ui-corner-all inputClass'
									                },
													parkingSpots: {
									                	title: 'Parking',
									                	width: '10%',
									                	inputClass: 'text  ui-widget-content ui-corner-all inputClass'
													},
													
													sinceDate:{
									                	title: 'Since',
									                	width: '7%',
									                	inputClass: 'text  ui-widget-content ui-corner-all inputClass',
									                	type: 'date',
									                    displayFormat: 'yy-mm-dd'
													},
													toDate:{
									                	title: 'Till',
									                	width: '7%',
									                	inputClass: 'text  ui-widget-content ui-corner-all inputClass',	
									                	type: 'date',
									                   displayFormat: 'yy-mm-dd'
													},
													residentType :{
									                	title: 'Ownership',
									                	width: '7%',
									                	display: function (data){
									                		var residentType = "";
									                		if(data.record.residentType != null){
									                			residentType = data.record.residentType.residentType;
									                		}
									                		return residentType;
									                	},									                	
									                	options:'masterdata?userAction=Get_Resident_Type_Options',
									                	inputClass: 'text  ui-widget-content ui-corner-all inputClass'															
													}
									            },
									            
									            formCreated:function (event, data) 
									                {
									            	
									            	if(data.formType == 'edit'){
									            	 var houseType = data.form.find('select[name="houseType"]');	
									            	 var building = data.form.find('select[name="building"]');
									            	 var residentType = data.form.find('select[name="residentType"]');
									            	 if(houseType != null){
									            	 	houseType.val(data.record.houseType.houseType);
									            	 }
									            	if(building != null){
									            	 	building.val(data.record.building.buildingID.id);
									            	}
									            	 if(residentType != null){
									            		 residentType.val(data.record.residentType.residentType);
									            	 }
									            	}


									            	 
									                }
											}, 
											function (data) { //opened handler
			                                    data.childTable.jtable('load',{userAction : 'Get_House_Details', memberID:houseData.record.memberID.id});
			                                });
										});
										return $ul;
									}
								},									
								fullName : {
									create : false,
									edit : false,																		
									title : 'Name',
									width : '15%',
									inputClass : 'text  ui-widget-content ui-corner-all inputClass'
								},								
								firstName : {
									title : 'First Name',
									create : true,
									edit : true,									
									width : '7%',
									list : false,
									inputClass : 'text  ui-widget-content ui-corner-all inputClass'
								},
								middleName : {
									create : true,
									edit : true,									
									title : 'Middle Name',
									width : '7%',
									list : false,
									inputClass : 'text  ui-widget-content ui-corner-all inputClass'
								},
								lastName : {
									create : true,
									edit : true,									
									title : 'Last Name',
									list : false,
									width : '7%',
									inputClass : 'text  ui-widget-content ui-corner-all inputClass'
								},								
								phone : {
									title : 'Phone',
									width : '7%',
									inputClass : 'text  ui-widget-content ui-corner-all inputClass'
								},								
								email : {
									title : 'Email',
									width : '10%',
									inputClass : 'text  ui-widget-content ui-corner-all inputClass'
								},
								address : {
									title : 'Address',
									width : '20%',
									inputClass : 'text  ui-widget-content ui-corner-all inputClass'
								},
							
								status : {
									title : 'Status',
									width : '7%',
									display: function (data){
										var statusName = "";
										if(data.record.status != null){
											statusName = data.record.status.statusName;
										}
				                		return statusName;
				                	},
									options:'masterdata?userAction=Get_Status_Options',									
									inputClass : 'text  ui-widget-content ui-corner-all inputClass'
								},
								
								memberRole: {
									title: 'Role',
									width : '7%',
									display: function (data){
										var roleName = "";
										if(data.record.memberRole != null){
											roleName = data.record.memberRole.roleName;
										}
				                		return roleName;
				                	},
									options:'masterdata?userAction=Get_Society_Roles_Options',
									inputClass : 'text  ui-widget-content ui-corner-all inputClass'
									
								}

							},

							formCreated : function(event, data) {
								if (data.formType == 'edit') {
									var memberRole = data.form
											.find('select[name="memberRole"]');
									var status = data.form
									.find('select[name="status"]');
									
					            	 if(data.record.memberRole != null){
						            	 memberRole.val(data.record.memberRole.roleID.id);
						            }
					            	 if(data.record.status != null){
					            		 status.val(data.record.status.statusID.id);					            		 
					            	 }
								}
							}

						});
		$('#residents-contain').jtable('load', {
			userAction : 'Get_Resident_Details'
		});

	});
</script>

<div id="residents-contain" class="ui-widget"></div>