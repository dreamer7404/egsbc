//--------------- Static ACL ---------------------

//--------------- Package ---------------------
var PACKAGE_RUNNING_COLOR = "#0000A8";
var PACKAGE_NOT_VALIDATE = "#CC0000";
var PACKAGE_DETAIL_TITLE = "Package Details";

//--------------- LOCK SCREEN -------------------
var IDLE_TIME_MINUTES = 10;

//--------------- socket ------------------------
var socket;
var stompClient ;
var connectCallback;

//---------------- dashboard chart ----------------
var line1, line2, line3, line4;
var LineConfig1={};
var chartLabels1=[];
var chartData1=[], chartData2=[];

//---------------- dashboard alarm/event----------
var tableAlarmEvent;


$(function() {
	
	/*
	 * ----------------- resize trigger ------------------------------
	 */
	$(window).bind('resize', function() {
		//setInterval(function(){
			resize(); 
		//}, 500);
	}).trigger('resize');
	
		    
	// start menu
	//$('nav a[href="/resources/html/overview/overview.html"]').trigger("click"); 

	$('body').append( $('<div>').load("/resources/html/idle.html"));
	
	
	/*
	 * ------------ Page Lock --------------------------------------------------------
	 */
	
	$(document).idle({
		onIdle: function(){
			$.post("/lock",{url:window.location.href}, function(json){
				location.href = "/" + json.page;
	    	});
	  	},
  		idle: 1000*60*IDLE_TIME_MINUTES
	  	//idle: 5000
	});
	
	/*
	 * ------------ System Time --------------------------------------------------------
	 */
	
	socket = new SockJS("/ws");
	stompClient = Stomp.over(socket);

	connectCallback = function() {
		  stompClient.subscribe('/topic/datetime', renderDatetime);
		  stompClient.subscribe('/topic/status', renderStatus);
		  stompClient.subscribe('/topic/chart', renderChart);
	}; 

	stompClient.connect("guest", "guest", connectCallback, errorCallback);
	
	
	// init chart data
	
	for(var i=0; i<10; i++){
		chartLabels1.push("");
		chartData1.push(null);
		chartData2.push(null);
	}
	
	
	/*
	 * ------------ WebSocket --------------------------------------------------------
	 */
	
	// Connect
//	ws = new WebSocket('ws://localhost:9090/ws/trace');
//	ws.onopen = function(){
//		setListener();
//	};
	
	
	
	
	
	
    
})();

window.onbeforeunload = function(){
	ws.close();
	ws = null;
}

function setListener(){
	// receive event
	ws.onmessage = function(event){
		alert(event.data);
		$("#systemDateTime").html(event.data);
	};
	
	// close event
	ws.onclose = function(event){
		alert('close websocket');
	};
}

function getFormattedDate(){
    var d = new Date();
    d = d.getFullYear() + "-" + ('0' + (d.getMonth() + 1)).slice(-2) + "-" + ('0' + d.getDate()).slice(-2) + " " + ('0' + d.getHours()).slice(-2) + ":" + ('0' + d.getMinutes()).slice(-2) + ":" + ('0' + d.getSeconds()).slice(-2);
    return d;
}

//----------------------- sockjs ---------------------------------


var errorCallback = function(error) {
	  alert(error.headers.message);
};

function renderDatetime(frame) {
	  var dateTime = JSON.parse(frame.body);
	  $("#systemDateTime").html(dateTime);
}

function renderStatus(frame) {
	  var list = JSON.parse(frame.body);
	  if(list.length != 0){
		  for(var i in list) {
			  var item = list[i];
			  //obj.html('i: ' + i + ', side: ' + item.side);
			  //alert(item.side);
			  
			  // System Status
			  
			  $("#frmStatus #dualFlag").html((item.dualFlag==0)?"Single Mode" : "Dual Mode");
			  $("#frmStatus #desLicense").html(item.desLicense);
			  $("#frmStatus #mgmtIp").html(item.mgmtIp);
			  
			  // System Information
			  $('#usageCpu').data('easyPieChart').update((item.usageCpuDisp1=='')?0:item.usageCpuDisp1);
			  $('#usageRamDisp2').data('easyPieChart').update((item.usageRamDisp2=='')?0:item.usageRamDisp2);
			  $('#usageDisk2Disp').data('easyPieChart').update((item.usageDisk2Disp=='')?0:item.usageDisk2Disp);
			  $('#usageTempCur').data('easyPieChart').update((item.usageTempCur=='')?0:item.usageTempCur);
			  
			  $('#usageRamDisp1').html(item.usageRamDisp1);
			  $('#usageDisk1Disp').html(item.usageDisk1Disp);
			  $('#bootTime').html(item.bootTime);
			  $('#descOs').html(item.descOs); 
			  $('#descPkgVer').html(item.descPkgVer);
			  break;
		  }
	  }
	  
	  
}

function setConfig(labels, d1, d2){
 LineConfig1 = {
        type: 'line',
        data: {
            labels: labels,
            datasets: [{
                label: "register ok",
                data: d1,
                borderWidth:1,
                borderColor: "rgba(147,185,203,1)",
                backgroundColor: "rgba(147,185,203,0.4)",
                radius: 2,

            }, {
                label: "register try",
                data: d2,
                borderWidth:1,
                borderColor: "rgba(228,228,228,1)",
                backgroundColor: "rgba(228,228,228,0.4)",
                radius: 2,
            }]
        },
        options: {
            responsive: true,
            maintainAspectRatio: false,
            duration: 0,
            title : {
      	  	display: true,
      	    text: 'Subscriber',
      	    fontSize:10
            },
            tooltips: {
               mode: 'label'
            },
            hover: {
               mode: 'dataset'
            },
            scales: {
                xAxes: [{
                    display: true,
//                     scaleLabel: {
//                         show: true,
//                         labelString: 'Month'
//                     },
                    gridLines:{
                  	  display: false
                    },
                    ticks: {
                        maxRotation: 0
                    },
                }],
                yAxes: [{
                    display: true,
//                     scaleLabel: {
//                         show: true,
//                         labelString: 'Value'
//                     },
                    gridLines:{
                  	  display: false
                    },
                    ticks: {
                        suggestedMin: 0,
                        suggestedMax: 100,
                    }
                }]
            }
        }
  };
}

function renderChart(frame){
	
	 var list = JSON.parse(frame.body);
	 if(list.length > 0){
		 for(var i=0; i<list.length; i++){
			 
			 var item = list[i];
			 var num1 = item.num1;
			 var num2 = item.num2;
			 
			 
			 $("#msg").html(num1 + " , " + num2);
			 
			 
			 chartLabels1.shift();
			 chartData1.shift();
			 chartData2.shift();
			 
			 chartLabels1.push("10");
			 chartData1.push(num1);
			 chartData2.push(num2);
			 
			 setConfig(chartLabels1, chartData1, chartData2);
			 line1 = new Chart(document.getElementById("chart1"), LineConfig1);
			 
			 //updateChart(chartLabels1, chartData1, chartData2);
		 }
		 
	 }
}

//----------------------------------- resize ---------------------------

function resize(){

	var divChart = $("#divChart");
	var dtAlarmEvent = $("#dtAlarmEvent");
	
	var msg = "" + divChart.length;
	
	if(divChart.length==1){
		//alert('1');
		var chart1 = $("#chart1");
		var chart2 = $("#chart2");
		var chart3 = $("#chart3");
		var chart4 = $("#chart4");
		
		var winHeight = $(window).height();
		divChart.height(winHeight-320);
		
		msg += divChart 
		$("#msg").html(divChart.height);
		
		var w = divChart.width() - 20;
		var h = (divChart.height() - 10) / 4 ;
		
		chart1.width(w); 
		chart2.width(w); 
		chart3.width(w); 
		chart4.width(w); 
		
		chart1.height(h);
		chart2.height(h);
		chart3.height(h);
		chart4.height(h);
	
	}
	
	
	if(dtAlarmEvent.length == 1){
		$('div.dataTables_scrollBody').css('height',winHeight-450);
		tableAlarmEvent.draw();
	}
	

}	  
	
