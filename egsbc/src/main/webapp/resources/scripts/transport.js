var tableSip, tableMedia, tableNat;
var validatorInterfaceAdd;

pageSetUp();


var pagefunction = function() {
	var responsiveHelper_datatable_col_reorder = undefined;
	var breakpointDefinition = {
			tablet : 1024,
			phone : 480
		};
	
	var sDom = "<'dt-toolbar'<'col-xs-12 col-sm-6'f><'col-sm-6 col-xs-6 hidden-xs'TC>r>"+
		"t"+
		"<'dt-toolbar-footer'<'col-sm-6 col-xs-12 hidden-xs'><'col-sm-6 col-xs-12'>>";
	var oLanguage = { "sSearch": '<span class="input-group-addon"><i class="fa fa-search"></i></span>'};	
	var sSwfPath = "/resources/js/plugin/datatables/swf/copy_csv_xls_pdf.swf";
	var tableTools =  {
		 "sSwfPath": "/resources/js/plugin/datatables/swf/copy_csv_xls_pdf.swf",
    	 "aButtons": [
	             "xls",
	                {
	                    "sExtends": "pdf",
	                    "sTitle": "SmartAdmin_PDF",
	                    "sPdfMessage": "SmartAdmin PDF Export",
	                    "sPdfSize": "letter"
	                }
         ],
     };
	
	tableSip = $('#dtSip').DataTable({
		"sDom": sDom,
		"oLanguage": oLanguage,
		"autoWidth" : true,
		"tableTools":tableTools,
		"scrollY" : "400px",
		"scrollX" : false,
			"scrollCollapse": true,
		"paging": false,
		"processing": true,
        "ajax": {
        	url: "/getSipTransport",
        	type: "post"
        },
        'order': [[1, 'asc']],
        "columns": [
    				{ "data": null},        	
    				{ "data": "name"},       
    		        { "data": "vipName"},	
    		        { "data": "svcType" },	
    		        { "data": "transType" }, 	
    		        { "data": "sigPort"}, 		
    		        { "data": "minPort"},				
    		        { "data": "maxPort"},
    		        { "data": "qosType"}, 	
    		        { "data": "qosValue"} 
    		    ],
    	'columnDefs': [	 
				{'targets': 0, 'className': 'text-center',  'searchable': false,  'orderable': false},   
				{'targets': 1, 'className': 'text-center'}, 
				{'targets': 2, 'className': 'text-center'},    
				{'targets': 3, 'className': 'text-center', 'render': function (data, type, full, meta){ return getVipName($('<div/>').text(data).html()); }},    
				{'targets': 4, 'className': 'text-center', 'render': function (data, type, full, meta){ return getTransType($('<div/>').text(data).html()); }},    
				{'targets': 5, 'className': 'text-center'},    
				{'targets': 6, 'className': 'text-center'},    
				{'targets': 7, 'className': 'text-center'},    
				{'targets': 8, 'className': 'text-center'},
				{'targets': 9, 'className': 'text-center'}
    	 ]
	});
	
	tableMedia = $('#dtMedia').DataTable({
		"sDom": sDom,
		"oLanguage": oLanguage,
		"autoWidth" : true,
		"tableTools":tableTools,
		"scrollY" : "400px",
		"scrollX" : false,
			"scrollCollapse": true,
		"paging": false,
		"processing": true,
        "ajax": {
        	url: "/getMediaTransport",
        	type: "post"
        },
        'order': [[1, 'asc']],
        "columns": [
    				{ "data": null},        	
    				{ "data": "name"},       
    		        { "data": "vipName"},	
    		        { "data": "minPort"},				
    		        { "data": "maxPort"},
    		        { "data": "qosType"}, 	
    		        { "data": "qosValue"} 
    		    ],
    	'columnDefs': [	 
				{'targets': 0, 'className': 'text-center',  'searchable': false,  'orderable': false},   
				{'targets': 1, 'className': 'text-center'}, 
				{'targets': 2, 'className': 'text-center'},    
				{'targets': 3, 'className': 'text-center'},  
				{'targets': 4, 'className': 'text-center'},    
				{'targets': 5, 'className': 'text-center'},    
				{'targets': 6, 'className': 'text-center'},    
    	 ]
	});
	
	tableNat = $('#dtNat').DataTable({
		"sDom": sDom,
		"oLanguage": oLanguage,
		"autoWidth" : true,
		"tableTools":tableTools,
		"scrollY" : "400px",
		"scrollX" : false,
			"scrollCollapse": true,
		"paging": false,
		"processing": true,
        "ajax": {
        	url: "/getNatTransport",
        	type: "post"
        },
        'order': [[1, 'asc']],
        "columns": [
    				{ "data": null},        	
    				{ "data": "name"},       
    		        { "data": "vipName"},	
    		        { "data": "minPort"},				
    		        { "data": "maxPort"},
    		        { "data": "protocol"}, 	
    		        { "data": null}, 
    		        { "data": null}, 
    		        { "data": null}
    		    ],
    	'columnDefs': [	 
				{'targets': 0, 'className': 'text-center',  'searchable': false,  'orderable': false},   
				{'targets': 1, 'className': 'text-center'}, 
				{'targets': 2, 'className': 'text-center'},    
				{'targets': 3, 'className': 'text-center'},    
				{'targets': 4, 'className': 'text-center'},    
				{'targets': 5, 'className': 'text-center'},    
				{'targets': 6, 'className': 'text-center'},    
				{'targets': 7, 'className': 'text-center'},    
				{'targets': 8, 'className': 'text-center'}
    	 ]
	});
	
	//	seq number
	tableSip.on( 'order.dt search.dt', function () {
		tableSip.column(0, {search:'applied', order:'applied'}).nodes().each( function (cell, i) {
            cell.innerHTML = i+1;
        } );
    } ).draw();
	
	tableMedia.on( 'order.dt search.dt', function () {
		tableMedia.column(0, {search:'applied', order:'applied'}).nodes().each( function (cell, i) {
            cell.innerHTML = i+1;
        } );
    } ).draw();
	
	tableNat.on( 'order.dt search.dt', function () {
		tableNat.column(0, {search:'applied', order:'applied'}).nodes().each( function (cell, i) {
            cell.innerHTML = i+1;
        } );
    } ).draw();
	
	//	click row
	tableSip.on( 'click', 'tr', function () {
		tableSip.$('tr.selected').removeClass('selected');
		$(this).addClass('selected');
	});
	
	tableMedia.on( 'click', 'tr', function () {
		tableMedia.$('tr.selected').removeClass('selected');
		$(this).addClass('selected');
	});
	
	tableNat.on( 'click', 'tr', function () {
		tableNat.$('tr.selected').removeClass('selected');
		$(this).addClass('selected');
	});
	
	
	
	//추가버튼
	$("#btnAdd").click(function(){
		
//			$("#hidInterface1").val('');
//			$("#hidInterface2").val('');
	
//			$.post("/getInterfaceNameList",{},function(json){
//				var data=json.data;
			
//				// 인터페이스명 list
//				$("#selIntfNameEdit").empty();
//				$("#selIntfNameEdit").append("<option value=''  selected='' disabled=''>선택</option>");
//				for(var i=0; i<data.length; i++){
//					$("#selIntfNameEdit").append("<option value='"+data[i]+"'>"+data[i]+"</option>");
//				}
//				showModalEdit();
//			});


		$("#modalSip").modal({backdrop: 'static',keyboard: false});
	});
	
	
	$("#spinner1").spinner();
	$("#spinner2").spinner();
	
//	$("#spinner-decimal").spinner({
//	    step: 0.01,
//	    numberFormat: "n"
//	});
	
} // pagefunction

//loadScript("/resources/js/plugin/datatables/jquery.dataTables.min.js", function(){
//	loadScript("/resources/js/plugin/datatables/dataTables.colVis.min.js", function(){
//		loadScript("/resources/js/plugin/datatables/dataTables.tableTools.min.js", function(){
//			loadScript("/resources/js/plugin/datatables/dataTables.bootstrap.min.js", function(){
//				loadScript("/resources/js/plugin/datatable-responsive/datatables.responsive.min.js", pagefunction)
//			});
//		});
//	});
//});

function getVipName(val){
	if(val==0) return "Server";
	else if(val==1) return "Realm";
	else "";
}
function getTransType(val){
	if(val==1) return "udp";
	else if(val==2) return "tcp";
	else if(val==3) return "tls";
	else "";
}

