<style>
label {
	display: block;
	float: left;
	width: 30% px;
	text-align: left;
	padding: .2em;
	font-weight: 700;
}

input.text {
	display: block;
	width: 55%;
	padding: .4em;
	margin: 10 10 10 10px;
}

fieldset {
	padding: 0;
	border: 0;
	margin-top: 25px;
	width: 80%;
}

fieldset>div {
	margin-bottom: 5px;
}

h1 {
	font-size: 1.2em;
	margin: .6em 0;
}

div#buildings-contain {
	margin: 20px 0;
}

div#buildings-contain table {
	margin: 1em 0;
	border-collapse: collapse;
	width: 100%;
}

thead > td {
background-color:black;

}

div#buildings-contain table td,div#buildings-contain table th {
	border: 1px solid #eee;
	padding: .6em 10px;
	text-align: left;
}

.ui-dialog .ui-state-error {
	padding: .3em;
}

.validateTips {
	border: 1px solid transparent;
	padding: 0.3em;
}
</style>
<script>
	$(function() {
	       $('#buildings-contain').jtable({
	            title: 'Buildings in Society',
	            jqueryuiTheme:true,
	            paging:true,
	            pageSize:2,
	            pageSizes:[2,5,10,15,20,25],
	            defaultSorting: 'buildingNO ASC',
	            deleteConfirmation: function(data) {
	                data.deleteConfirmMessage = 'Are you sure to delete record building ' + data.record.buildingName + '?';
	                
	            },	            
	            sorting:true,
	            actions: {
	                listAction: 'masterdata',
	                createAction: 'masterdata',
	                updateAction: 'masterdata',
	                deleteAction: 'masterdata?userAction=Delete_Building_Details'
	            },
	            fields: {	            	
	            	buildingID: {
	            		key: true,
	            		list: false,
	                    create: false,
	                    edit: true,
	                    display: function (data){	                    	
	                    	return data.record.buildingID.id;
	                    },
	                    input: function (data) {
	                        if (data.record) {
	                            return '<input type="hidden" name="buildingID" value="' + data.record.buildingID.id + '" />';
	                        }
	                    }	                    
	            	},
	            	userAction: {
	            		create:true,
	            		edit:true,
	            		defaultValue:'Update_Building_Details',
	                    input: function (data) {
	                            return '<input type="hidden" name="userAction" value="Update_Building_Details" />';
	                    },	 	            		
	            		list:false
	            	},
	                buildingNO: {
	                	title: 'Building No',
	                	width: '20%'
	                },
	                buildingName: {
	                    title: 'Building Name',
	                    width: '30%',
	                    display: function (data){
	                    	//alert("आला रे" + data.record.buildingName);
	                    	return data.record.buildingName;
	                    }
	                },
	                totalFloors: {
	                    title: 'Floors',
	                    width: '20%'
	                },
	                totalHouses: {
	                    title: 'Houses',
	                    width: '30%',
	                }
	            }
	        });		
	       $('#buildings-contain').jtable('load',{userAction : 'Get_Building_Details'});
	});
</script>




<div id="buildings-contain" class="ui-widget">

</div>


