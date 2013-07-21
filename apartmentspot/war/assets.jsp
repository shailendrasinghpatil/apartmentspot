<script>
	$(function() {
	       $('#assets-contain').jtable({
	            title: 'Assets in Society',
	            jqueryuiTheme:true,
	            paging:true,
	            pageSize:2,
	            pageSizes:[2,5,10,15,20,25],
	            defaultSorting: 'AssetID ASC',
	            deleteConfirmation: function(data) {
	                data.deleteConfirmMessage = 'Are you sure you want to delete Asset record? ' + data.record.assetName + '?';
	                
	            },	            
	            sorting:true,
	            actions: {
	                listAction: 'masterdata',
	                createAction: 'masterdata',
	                updateAction: 'masterdata',
	                deleteAction: 'masterdata?userAction=Delete_Asset_Details'
	            },
	            fields: {	            	
	            	assetID: {
	            		key: true,
	            		list: false,
	                    create: false,
	                    edit: true,
	                    display: function (data){	                    	
	                    	return data.record.assetID.id;
	                    },
	                    input: function (data) {
	                        if (data.record) {
	                            return '<input type="hidden" name="assetID" value="' + data.record.assetID.id + '" />';
	                        }
	                    }	                    
	            	},
	            	userAction: {
	            		create:true,
	            		edit:true,
	            		defaultValue:'Update_Asset_Details',
	                    input: function (data) {
	                            return '<input type="hidden" name="userAction" value="Update_Asset_Details" />';
	                    },	 	            		
	            		list:false
	            	},
	                AssetNo: {
	                	title: 'Asset Number',
	                	width: '20%'
	                },
	                AssetName: {
	                    title: 'Asset Name',
	                    width: '30%'
	                },
	                AssetCategory: {
	                    title: 'Description',
	                    width: '20%'
	                },
	                AssetQty: {
	                    title: 'Quantity',
	                    width: '20%'
	                },
	                AssetModel: {
	                    title: 'Model',
	                    width: '20%'
	                },
	                AssetPurchaseDate: {
	                    title: 'PurchaseDate',
	                    width: '20%'
	                },
	                AssetExpiryDate: {
	                    title: 'ExpiryDate',
	                    width: '20%'
	                },
	                totalAssets: {
	                    title: 'totalAssets',
	                    width: '30%',
	                }
	            }
	        });		
	       $('#assets-contain').jtable('load',{userAction : 'Get_Asset_Details'});
	});
</script>




<div id="assets-contain" class="ui-widget">

</div>