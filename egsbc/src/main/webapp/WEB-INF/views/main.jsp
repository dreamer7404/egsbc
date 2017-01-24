<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<sec:authentication var="principal" property="principal" />
<sec:authorize var="isAuthorizeAny" access="hasAnyRole('ROLE_USER','ROLE_ADMIN')" ></sec:authorize>

<!DOCTYPE html>
<html>
<head>
 	<meta http-equiv="Content-Type" content="text/html" charset="utf-8">
	
	<!-- Basic Styles -->
	<link rel="stylesheet" type="text/css" media="screen" href="/resources/css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" media="screen" href="/resources/css/font-awesome.min.css">
	
	<!--  add  -->
	<link rel="stylesheet" type="text/css" media="screen" href="/resources/css/datatables/jquery.dataTables.min.css ">
	<link rel="stylesheet" type="text/css" media="screen" href="/resources/css/datatables/buttons.dataTables.min.css ">
<!-- 	<link rel="stylesheet" type="text/css" href="/release-datatables/extensions/TableTools/css/dataTables.tableTools.css"> -->

		<link rel="stylesheet" type="text/css" media="screen" href="/resources/css/smartadmin-production-plugins.min.css">
		<link rel="stylesheet" type="text/css" media="screen" href="/resources/css/smartadmin-production.min.css">
		<link rel="stylesheet" type="text/css" media="screen" href="/resources/css/smartadmin-skins.min.css">

		<!-- SmartAdmin RTL Support -->
		<link rel="stylesheet" type="text/css" media="screen" href="/resources/css/smartadmin-rtl.min.css"> 

		<!-- Demo purpose only: goes with demo.js, you can delete this css when designing your own WebApp -->
		<link rel="stylesheet" type="text/css" media="screen" href="/resources/css/demo.min.css">
	
	

	


<style type="text/css" class="init">
	
	div.dataTables_wrapper {
		width: 800px;
		margin: 0 auto;
	}
	</style>


<title>SBC</title>

<script type="text/javascript">
if(window.HTMLAudioElement){
    var player = new Audio(''); 
    function play(url){
        if(player.paused || url != player.src){
            if(player.canPlayType('audio/mp3')){
                player.src = url;
            }
            player.play();
        } else {
            player.pause();
            player.currentTime = 0; 
        }
    }
}
</script>

<script type="text/javascript">
	function testUDP(){
		$.post('/testUDP', {req: "hello"} , function(data){
			alert('data.result: ' + data.result);
		});
	}
	function testTCP(){
		$.post('/testTCP', {req: "hello"} , function(data){
			alert('data.result: ' + data.result);
		});
	}
	
	function getUsers(){
		$.post('/getUsers', {} , function(data){
			alert('data.result: ' + data.list.length);
		});
	}
</script>

</head>
<body >

<div style="margin-left:20px;">

	<h1>this is Main.jsp</h1>
	<p><a href="#" onClick="play('/resources/my/audio/rtu.mp3')">audioA.mp3</a></p>
	<p><a href="javascript:testUDP()" >test UDP</a></p>
	<p><a href="javascript:testTCP()" >test TCP</a></p>
	<p><a href="javascript:getUsers()" >getUsers</a></p>
	
<!-- 	<p><a href="/home" >home</a></p> -->
	<p><label>${principal.username}</label></p>
	<p>
		<sec:authorize ifAnyGranted="ROLE_SYSTEM">ROLE_SYSTEM</sec:authorize>
		<sec:authorize ifAnyGranted="ROLE_ADMIN">[ROLE_ADMIN]</sec:authorize>
		<sec:authorize ifAnyGranted="ROLE_USER">[ROLE_USER]</sec:authorize>
	</p>
	
	<p><a href="/logout">logout</a></p>
	<p><a href="/home">home</a></p>
	
	<p><a href="/form-elements">form-elements</a></p>
	<p><a href="/form-templates">form-templates</a></p>
	<p><a href="/test01">ajaxForm</a></p>
	
	<p><button class="btn btn-default" id="btnShowAdd">show add</button></p>
	
	
	<table width="100%" class="display" id="example" cellspacing="0">
        <thead>
            <tr>
            	<th><input name="select_all" id="example-select-all" type="checkbox" value="1"></th>
                <th>Name</th>
                <th>Position</th>
                <th>Office</th>
                <th>Age</th>
                <th>Start date</th>
                <th>Salary</th>
            </tr>
        </thead>
        <tbody>
            <tr>
            	<td>1</td>
                <td>Tiger Nixon</td>
                <td>System Architect</td>
                <td>Edinburgh</td>
                <td>12</td>
                <td>2011/04/25</td>
                <td>$320,800</td>
            </tr>
            <tr>
            	<td>2</td>
                <td>Garrett Winters</td>
                <td>Accountant</td>
                <td>Tokyo</td>
                <td>11</td>
                <td>2011/07/25</td>
                <td>$170,750</td>
            </tr>
             <tr>
             	<td>3</td>
                <td>Tiger Nixon</td>
                <td>System Architect</td>
                <td>Edinburgh</td>
                <td>10</td>
                <td>2011/04/25</td>
                <td>$320,800</td>
            </tr>
            <tr>
            	<td>4</td>
                <td>Garrett Winters</td>
                <td>Accountant</td>
                <td>Tokyo</td>
                <td>9</td>
                <td>2011/07/25</td>
                <td>$170,750</td>
            </tr>
             <tr>
             	<td>5</td>
                <td>Tiger Nixon</td>
                <td>System Architect</td>
                <td>Edinburgh</td>
                <td>8</td>
                <td>2011/04/25</td>
                <td>$320,800</td>
            </tr>
            <tr>
            	<td>6</td>
                <td>Garrett Winters</td>
                <td>Accountant</td>
                <td>Tokyo</td>
                <td>7</td>
                <td>2011/07/25</td>
                <td>$170,750</td>
            </tr>
             <tr>
             	<td>7</td>
                <td>Tiger Nixon</td>
                <td>System Architect</td>
                <td>Edinburgh</td>
                <td>6</td>
                <td>2011/04/25</td>
                <td>$320,800</td>
            </tr>
            <tr>
            	<td>8</td>
                <td>Garrett Winters</td>
                <td>Accountant</td>
                <td>Tokyo</td>
                <td>5</td>
                <td>2011/07/25</td>
                <td>$170,750</td>
            </tr>
             <tr>
             	<td>9</td>
                <td>Tiger Nixon</td>
                <td>System Architect</td>
                <td>Edinburgh</td>
                <td>4</td>
                <td>2011/04/25</td>
                <td>$320,800</td>
            </tr>
            <tr>
            	<td>10</td>
                <td>Garrett Winters</td>
                <td>Accountant</td>
                <td>Tokyo</td>
                <td>3</td>
                <td>2011/07/25</td>
                <td>$170,750</td>
            </tr>
             <tr>
             	<td>11</td>
                <td>Tiger Nixon</td>
                <td>System Architect</td>
                <td>Edinburgh</td>
                <td>2</td>
                <td>2011/04/25</td>
                <td>$320,800</td>
            </tr>
            <tr>
            	<td>12</td>
                <td>Garrett Winters</td>
                <td>Accountant</td>
                <td>Tokyo</td>
                <td>1</td>
                <td>2011/07/25</td>
                <td>$1111111</td>
            </tr>
		</tbody>
	</table>
	
	

	<div style="width:800px;border:1px solid #000">
		<table width="100%" class="display nowrap" id="example2" cellspacing="0">
		<thead>
            <tr>
                <th>id</th>
                <th>pw</th>
                <th>level</th>
                <th>status</th>
                <th>dateTime</th>
            </tr>
        </thead>
		</table>
		<button onclick="loadTable2()">loadTable2</button>
		<button onclick="myReload()">myReload</button>
	
	</div>
	<div id="divAdd" >
		<form name="FrmAddUser" id="FrmAddUser" action="testUser" method="post">
			id: <input type="text" id="id" name="id" ><br />
			pw: <input type="text" id="pw" name="pw" ><br />
			level: <input type="text" id="level" name="level" ><br />
			status: <input type="text" id="status" name="status" ><br />
			<input type="submit" value="확인">
		</form>
	</div>
	
</div>	
<br /><br /><br /><br /><br />

	<script src="//ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
		<script>
			if (!window.jQuery) {
				document.write('<script src="/resources/js/libs/jquery-2.1.1.min.js"><\/script>');
			}
		</script>

		<script src="//ajax.googleapis.com/ajax/libs/jqueryui/1.10.3/jquery-ui.min.js"></script>
		<script>
			if (!window.jQuery.ui) {
				document.write('<script src="/resources/js/libs/jquery-ui-1.10.3.min.js"><\/script>');
			}
		</script>
	<!-- IMPORTANT: APP CONFIG -->
	<script src="/resources/js/app.config.js"></script>

	<!-- JS TOUCH : include this plugin for mobile drag / drop touch events-->
	<script src="/resources/js/plugin/jquery-touch/jquery.ui.touch-punch.min.js"></script> 

	<!-- BOOTSTRAP JS -->
	<script src="/resources/js/bootstrap/bootstrap.min.js"></script>

	<!-- CUSTOM NOTIFICATION -->
	<script src="/resources/js/notification/SmartNotification.min.js"></script>

	<!-- JARVIS WIDGETS -->
	<script src="/resources/js/smartwidgets/jarvis.widget.min.js"></script>

	<!-- EASY PIE CHARTS -->
	<script src="/resources/js/plugin/easy-pie-chart/jquery.easy-pie-chart.min.js"></script>

	<!-- SPARKLINES -->
	<script src="/resources/js/plugin/sparkline/jquery.sparkline.min.js"></script>
	
	<!-- JQUERY FORM -->
	<script src="/resources/js/plugin/jquery-form/jquery-form.min.js"></script>

	<!-- JQUERY VALIDATE -->
	<script src="/resources/js/plugin/jquery-validate/jquery.validate.min.js"></script>

	<!-- JQUERY MASKED INPUT -->
	<script src="/resources/js/plugin/masked-input/jquery.maskedinput.min.js"></script>

	<!-- JQUERY SELECT2 INPUT -->
	<script src="/resources/js/plugin/select2/select2.min.js"></script>

	<!-- JQUERY UI + Bootstrap Slider -->
	<script src="/resources/js/plugin/bootstrap-slider/bootstrap-slider.min.js"></script>

	<!-- browser msie issue fix -->
	<script src="/resources/js/plugin/msie-fix/jquery.mb.browser.min.js"></script>

	<!-- FastClick: For mobile devices: you can disable this in app.js -->
	<script src="/resources/js/plugin/fastclick/fastclick.min.js"></script>

	<!--[if IE 8]>
		<h1>Your browser is out of date, please update your browser by going to www.microsoft.com/download</h1>
	<![endif]-->

	<!-- Demo purpose only -->
	<script src="/resources/js/demo.min.js"></script>

	<!-- MAIN APP JS FILE -->
	<script src="/resources/js/app.min.js"></script>
	
	
	<script src="/resources/js/plugin/datatables/jquery.dataTables.min.js"></script>
	<script src="/resources/js/plugin/datatables/dataTables.buttons.min.js"></script> <!-- add -->
	<script src="/resources/js/plugin/datatables/dataTables.colVis.min.js"></script>
	<script src="/resources/js/plugin/datatables/dataTables.tableTools.min.js"></script>
	<script src="/resources/js/plugin/datatables/dataTables.bootstrap.min.js"></script>
	<script src="/resources/js/plugin/datatable-responsive/datatables.responsive.min.js"></script>
	
	<script src="/resources/js/plugin/datatables/dataTables.tableTools.min.js"></script>
	
	<script type="text/javascript">
	var table;
	var table2;
	
	$(document).ready(function() {
		/*
		var table = $('#example').DataTable( {
//			 "scrollY":        "200px",
//			 "scrollX": true,
//              "scrollCollapse": true,
             
//              "paging":         false,	
//              "pagingType": "full_numbers",
             
// 	        "info":     false,
 //	        "ordering": true,
// 			"order": [[3, "desc"]],
// 			"columnDefs": [
// 			               {
// 			            	   "targets":[2],
// 			            	   "visible": false,
// 			            	   "searchable":false
// 			               }
// 			               ]
          
 //	       "lengthMenu": [[10, 25, 50, -1], [10, 25, 50, "All"]]
	
		"dom": '<"top"f<"clear">>rt<"bottom"ilp<"clear">>'
	    } );
		
		
		$('#example tbody').on('click', 'tr', function () {
	        var data = table.row( this ).data();
	        alert( 'You clicked on '+data[0]+'\'s row' );
	    } );
		*/
		
		
		
		
		/*
			방법1 : add
		*/
//		var t = $('#example2').DataTable();
//		
// 		$.post("/selectUserList", {}, function(data){
// 			var list=data.list;
// 			for(var i=0; i<list.length; i++){
// 				var item=list[i];
// 				t.row.add([
// 				           item.id, item.pw, item.level, item.status, item.dateTime
// 				 ]).draw(false);
// 			}
// 		});
		
		
		/*
			방법2: 직접
		*/
		
		table = $('#example').DataTable({ // dataTable => DataTable
 			//dom: 'Bfrtip',
			 buttons: [
	            {
	                text: 'My button',
	                action: function ( e, dt, node, config ) {
	                    //alert( 'Button 1' );
	                	getCheck();
	                }
	            },
	            {
	                text: 'My button2',
	                action: function ( e, dt, node, config ) {
	                    alert( 'Button 2' );
	                }
	            },
	            
	        ],
			"dom": 'BT<"clear">lrftip', // 'B': buttons, 'T': tools, 'l': show pages , 'f':filter , 't': table 'i': info, 'p': page numbers
	        "tableTools": {
	        	 "aButtons": [
//    		             "copy",
//    		             "csv",
   		             "xls",
   		                {
   		                    "sExtends": "pdf",
   		                    "sTitle": "SmartAdmin_PDF",
   		                    "sPdfMessage": "SmartAdmin PDF Export",
   		                    "sPdfSize": "letter"
   		                },
//    		             	{
//    	                    	"sExtends": "print",
//    	                    	"sMessage": "Generated by SmartAdmin <i>(press Esc to close)</i>"
//    	                	}
		         ],
	            "sSwfPath": "/resources/js/plugin/datatables/swf/copy_csv_xls_pdf.swf"

	        },
	        'columnDefs': [{
	        	'targets': 0,
	        	'searchable': false,
	            'orderable': false,
	        	'className': 'dt-body-center',
	        	'render': function (data, type, full, meta){
	                //return '<input type="checkbox" name="id[]" value="' + $('<div/>').text(data).html() + '">';
	                
	                var val=$('<div/>').text(data).html();
	        		return '<input type="checkbox" name="id[]" value="' + val + '">'+val;
	        	}
			}],
			 'order': [[1, 'asc']],
			 'scrollY': '150px',
			 'scrollX' : false
		});
		
		 // Handle click on "Select all" control
	   $('#example-select-all').on('click', function(){ 
		      var rows = table.rows({ 'search': 'applied' }).nodes();
		      $('input[type="checkbox"]', rows).prop('checked', this.checked);
	   });

		
		
	   // Handle click on checkbox to set state of "Select all" control
	   $('#example tbody').on('change', 'input[type="checkbox"]', function(){
	      // If checkbox is not checked
	      if(!this.checked){
	         var el = $('#example-select-all').get(0);
	         // If "Select all" control is checked and has 'indeterminate' property
	         if(el && el.checked && ('indeterminate' in el)){
	            // Set visual state of "Select all" control 
	            // as 'indeterminate'
	            el.indeterminate = true;
	         }
	      }
	   });
		
		
	   
	    
		
		
		
		
		
		
		
		
		
		
		
// 		$.post("/getUsers", {}, function(data){
// 			var data =eval(data.list);
// 			$('#example2').dataTable( {
// 			    "data": data,
// 			    "dataSrc": "list",
// 			    "columns": [
// 			        { "data": "id" },
// 			        { "data": "pw" },
// 			        { "data": "level" },
// 			        { "data": "status" },
// 			        { "data": "dateTime" }
// 			    ],
			   
// 			});
			
// 		});

		loadTable2();
		
		// 사용자저장 폼 보기
		$("#btnShowAdd").click(function(){
			$("#divAdd").show();
		});
		
		// 사용자저장
// 		$("#btnAddUser").click(function(){
// 			var data = $("form[name=FrmAddUser]").serialize();
// 			$.ajax({
// 				type:'post',
// 				url: '/addUser',
// 				data: data,
// 				dataType: 'json',
// 				success: function(json, status){
// 						alert('ok');
// 				}
				
// 			});
// 		});
		
		
		$("#FrmAddUser").ajaxForm({
			beforeSubmit: function(){ 
			    alert('서브밋 직전입니다!'); 
			  },
			  success: function(responseText, statusText, xhr, $form){
			      alert(responseText.result);
			      $form.hide();
			  }

		});
		
		
		$("#divAdd").hide();
		
		
	});
	
	
	 
	function getCheck(){   
	    var str="";
	    table.$('input[type="checkbox"]').each(function(){
	          if(this.checked){
	        	  if(str!=""){
	        		  str+=",";
	        	  }
	             str += this.value;
	          }
	    });
	    alert(str);
	}
	
	function loadTable2(){
		
// 		table2 = $('#example2').DataTable( {
// 			"bPaginate": false,
// 			 "bInfo": false,
// 			 "bSortClasses": true,
// 			 "bJQueryUI": true 
// 		} );
		
		table2 = $('#example2').DataTable( {
			"sDom": "<'dt-toolbar'<'col-xs-12 col-sm-6'f><'col-sm-6 col-xs-6 hidden-xs'TC>r>"+
			"t"+
			"<'dt-toolbar-footer'<'col-sm-6 col-xs-12 hidden-xs'><'col-sm-6 col-xs-12'>>",
			"columns": [
				{ "data": "id" , 'className':'dt-center'}, 
				{ "data": "pw" },
				{ "data": "level" },
				{ "data": "status" },
				{ "data": "dateTime" }
			],
			"processing": true,
	        //"serverSide": true,
	        "ajax": "/getUsers",
		});

		table2.ajax.reload();
		
		
	}
	
	function myReload(){
		table2.ajax.reload();
	}

	</script>
</body>
</html>