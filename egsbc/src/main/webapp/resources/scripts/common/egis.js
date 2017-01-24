//--------------- Package ---------------------
var PACKAGE_RUNNING_COLOR = "#0000A8";
var PACKAGE_NOT_VALIDATE = "#CC0000";
var PACKAGE_DETAIL_TITLE = "Package Details";

//--------------- LOCK SCREEN -------------------
var destroy1=true,destroy2=true,destroy3=true,destroy4=true;

var systemStatusTimer=null;

var alarmCountInterval; // alarm count
var systemStatusInterval; // system status
var heartBeatInterval; // heart beat

var wsString="";

var isRefresh=true;

var _audioCritical, _audioMajor, _audioMinor;
var g_alarmSound = false;

//---------------Debug -------------------
var debug=true;

/*-------------------------------------------------------------------------------------
 * 
 * 							Chart Data
 * 
 -------------------------------------------------------------------------------------*/

var Data=(function(){
	var _sizeX=30;
	var _time=[[],[],[],[]];
	var _data=[[],[],[],[]];
	var _info=[ [[],[],[],[]], [[],[],[],[]], [[],[],[],[]], [[],[],[],[]]];
	
	return{
		addData:function(item){
			var idx = item.chartIndex;
			
			// data.datasets[tooltipItem.datasetIndex].data[tooltipItem.index] + " " + unit[tooltipItem.datasetIndex];
			// info
			_info[idx][0] = item.chartTitle; 					// title
			_info[idx][1] = item.legendArray.split(","); 	// legend
			_info[idx][2] = item.colorArray.split(",");		// color
			_info[idx][3] = item.unitArray.split(","); 		// unit
			
			// time
			_time[idx].push(item.dateTime);
			if(_time[idx].length > _sizeX){
				_time[idx].splice(0,1);
			}
			
			// data
			_data[idx].push(item.dataArray.split(","));
			if(_data[idx].length > _sizeX){
				_data[idx].splice(0,1);
			}
			
		},
		getTime: function(idx){
			var time = _time[idx];
			var t=[];
			
			for(var i=0; i<_sizeX; i++){
				if(i==0)  t.push(time[i].substring(11, 19)); // 처음
				else if(i>5 && i==(time.length-1)) t.push(time[i].substring(11, 19)); // 마지막
				else t.push("");
			}
			
			return t;
		},
		getInfo: function(idx){
			return _info[idx];
		},
		getData: function(idx){
			var data = _data[idx]
			var cnt = data[0].length;
			var d=[];
			for(var k=0; k<cnt; k++){
				var t=[];
				for(var i=0; i<data.length; i++){
					t.push(data[i][k]);
				}
				d.push(t);
			}
			
			
			for(var k=0; k<cnt; k++){
				for(var i=d[k].length; i<_sizeX; i++){
					d[k].push(null);
				}
			}
			
			return d;
		},
		getX:function(idx, dataIndex){
			return _time[idx][dataIndex];
		}
		
	}
	
})();

/*-------------------------------------------------------------------------------------
 * 
 * 							Trace Data
 * 
 -------------------------------------------------------------------------------------*/


var TraceData=(function(){
	var _list=[];
	
	var _traceCondition={};
	var _result=[];
	var _flow=[];
	
	
	var _arrowLeft =	
		'<td  style="width:10px;height:9px;line-height:9px;;color:COLOR;"><i class="fa fa-arrow-left"></i></td>';
	var _arrowRight =
		'<td  style="width:10px;height:9px;line-height:9px;;color:COLOR;"><i class="fa fa-arrow-right"></i></td>';
	
	var _method = 
		'<table border="0" width="100%" onclick="TraceData.showMsg(FLOW_INDEX)">'+ 
		'<tr>'+  
			'<td colspan="COLSPAN" align="center" height="20px" style="padding:0;vertical-align:bottom">METHOD</td>'+  
		'</tr>'+ 
		'<tr>'+ 
			'ARROW_LEFT'+
			'<td>'+ 
				'<table width="100%">'+ 
				'<tr>'+ 
					'<td style="height:3px"></td>'+ 
				'</tr>'+ 
				'<tr>'+ 
					'<td style="height:3px;background-color:COLOR" ></td>'+ 
				'</tr>'+ 
				'<tr>'+ 
					'<td  style="height:3px"></td>'+ 
				'</tr>'+ 
				'</table>'+ 
			'</td>'+ 
			'ARROW_RIGHT'+
		'</tr>'+ 
		'</table>';
		
		
	
	var _traceColors=['BlueViolet', 'Brown','Crimson','DarkCyan','DarkGoldenRod','DarkGreen','DarkMagenta','Olive'];
	var _colorIndex = 0;
	
	
	var _getResult = function(callId){
		for(var i=0; i<_result.length; i++){
			var item = _result[i];
			if(item.callId==callId){
				return item;
				break;
			}
		}
		return null;
	};
	
	var _isCheck = function(callId){
		var b = false;
		tableTraceResult.$('input[type="checkbox"]').each(function(){
			if(this.value==callId && this.checked){
				b=true;
			}
		});
		return b;
	};
	
	var _getFlowBody = function(){
		
		var first=true;
		var rowcnt=0;
		var html = '';
		
		var msg='';
		
		for(var i=0; i<_flow.length; i++){
			var item = _flow[i];
			if(!_isCheck(item.callId)) continue;
			
				html +=
				'<tr>'+
					'<td width="160px" align="center" style="padding-right:0px;padding-left:0px;padding-top:14px">'+item.time+'</td>'+
					'<td width="110px" align="center" style="padding-right:0px;padding-left:0px;padding-top:14px">IP_A</td>'+
					'<td width="200px" style="padding:0" title="CALLID1" >METHOD1</td>';
				
				if(first){
					html += '<td  rowspan="ROWCNT" align="center" style="vertical-align:middle;background-color:#ddd">SBC</td>';
					first=false;
				}
				
				html +=	
					'<td width="200px" style="padding:0" title="CALLID2">METHOD2</td>'+
					'<td width="110px" style="padding-right:0px;padding-left:0px;padding-top:14px">IP_D</td>'+
				'</tr>';
				
				
				//------------ sip_trace -----------------------------
				if(item.msgType=='S'){
					if(item.src == "src_a"){
						var method1 = _method.replace("METHOD",  item.method)
						.replace("ARROW_LEFT", "")
						.replace("ARROW_RIGHT", _arrowRight)
						.replace(/COLOR/g, item.color)
						.replace('FLOW_INDEX', i)
						.replace('COLSPAN', 2);
						
						html = html.replace("IP_A", item.srcIp)
						.replace("CALLID1", item.callId)
						.replace("METHOD1", method1)
						.replace("CALLID2", "")
						.replace("METHOD2", "")
						.replace("IP_D", "");
						
						$("#Ip_b").text( item.dstIp);
					}else if(item.src == "src_b"){
						var method1 = _method.replace("METHOD",  item.method)
						.replace("ARROW_LEFT", _arrowLeft)
						.replace("ARROW_RIGHT", "")
						.replace(/COLOR/g, item.color)
						.replace('FLOW_INDEX', i)
						.replace('COLSPAN', 2);
						
						html = html.replace("IP_A", item.dstIp)
						.replace("CALLID1", item.callId)
						.replace("METHOD1", method1)
						.replace("CALLID2", "")
						.replace("METHOD2", "")
						.replace("IP_D", "");
						
						$("#Ip_b").text( item.srcIp);
					}else if(item.src == "src_c"){
						var method2 = _method.replace("METHOD", item.method)
						.replace("ARROW_LEFT", "")
						.replace("ARROW_RIGHT", _arrowRight)
						.replace(/COLOR/g, item.color)
						.replace('FLOW_INDEX', i)
						.replace('COLSPAN', 2);
						
						html = html.replace("IP_A", "")
						.replace("CALLID1", "")
						.replace("METHOD1", "")
						.replace("CALLID2", item.callId)
						.replace("METHOD2", method2)
						.replace("IP_D",  item.dstIp);
						
						$("#Ip_c").text( item.srcIp);
					}else if(item.src == "src_d"){
						var method2 = _method.replace("METHOD",  item.method)
						.replace("ARROW_LEFT", _arrowLeft)
						.replace("ARROW_RIGHT", "")
						.replace(/COLOR/g, item.color)
						.replace('FLOW_INDEX', i)
						.replace('COLSPAN', 2);
						
						html = html.replace("IP_A", "")
						.replace("CALLID1", "")
						.replace("METHOD1", "")
						.replace("CALLID2", item.callId)
						.replace("METHOD2", method2)
						.replace("IP_D",  item.srcIp);
						
						$("#Ip_c").text( item.dstIp);
					}
				//------------ media_trace -----------------------------	
				}else if(item.msgType=='M'){
					
					var method1 = _method.replace("METHOD", item.lType + "(" + item.lStatus + ")")
					.replace("ARROW_LEFT", _arrowLeft)
					.replace("ARROW_RIGHT", _arrowRight)
					.replace(/COLOR/g, item.color)
					.replace('FLOW_INDEX', i)
					.replace('COLSPAN', 3);
					
					var method2 = _method.replace("METHOD", item.rType + "(" + item.rStatus + ")")
					.replace("ARROW_LEFT", _arrowLeft)
					.replace("ARROW_RIGHT", _arrowRight)
					.replace(/COLOR/g, item.color)
					.replace('FLOW_INDEX', i)
					.replace('COLSPAN', 3);
					
					html = html.replace("IP_A", item.aIp)
					.replace("CALLID1", item.callId)
					.replace("METHOD1", method1)
					.replace("CALLID2", item.callId)
					.replace("METHOD2", method2)
					.replace("IP_D",  item.dIp);
				}
				
				rowcnt++;
		}
		html = html.replace("ROWCNT", rowcnt);
		
		return html;
	
	};
	
	var _showFlow = function(){
		 // show flow
		 var obj = $("#dtFlowBody");
		 if(obj.length == 1){
			 obj.html(_getFlowBody());
			 
			 Egis.resize();
		 }
	};
	
	
	return{
		addList:function(item){
			_list.push({selected:false, createdTime:item.createdTime, traceType:item.traceType, condition: item.condition, duration: item.duration});
			//_list.push([item.createdTime, item.traceType,  item.condition, item.duration]);
		},
		removeList: function(item){ 
			for(var i=0; i<_list.length; i++){
				var data=_list[i];
				//alert(data.traceType +' , ' +data.condition+' | ' +item.traceType+' , ' +item.condition);
				if(data.traceType==item.traceType && data.condition==item.condition){
					_list.splice(i,1);
					break;
				}
			}
		},
		showList: function(){
			 var obj = $("#dtTrace");
			 if(obj.length == 1){
				 tableTrace.clear().draw();
				 for(var i=0; i<_list.length; i++){
					 tableTrace.row.add(_list[i]).draw(false);
				 }
			 }
		},
		getListSize: function(){
			return _list.length;
		},
		getList: function(){
			return _list;
		},
		setListSelected: function(item, b){
			for(var i=0; i<_list.length; i++){
				if(_list[i].createdTime==item.createdTime &&
					 _list[i].traceType==item.traceType &&
					 _list[i].condition==item.condition){
					_list[i].selected = b;
					break;
				}
			}
		},
		setTraceCondition: function(item){
			_traceCondition = item;
		},
		getTraceCondition: function(){
			return _traceCondition;
		},
		getResultSize: function(){
			return _result.length;
		},
		addResult: function(item){

			var color;
			var result = _getResult(item.callId);
			if(result==null){
				
				_colorIndex = (_colorIndex == _traceColors.length)? 0 : _colorIndex; 
				color =  _traceColors[_colorIndex];
				 
				_result.push({
					check:false,
					color: color,
					method: item.method, 
					callId: item.callId, 
					time: item.time, 
					from: item.from, 
					to: item.to, 
				});
				
				_colorIndex++;
					
			}else{
				color = result.color;
			}
			
			
			if(item.msgType=='S'){
				_flow.push({
					msgType: item.msgType,
					color:color,
					
					method: item.method, 
					code: item.code, 
					callId: item.callId, 
					time: item.time, 
					from: item.from, 
					to: item.to, 
					protocol: item.protocol, 
					src: item.src, 
					srcIp: item.srcIp, 
					srcPort: item.srcPort,
					dst: item.dst,
					dstIp: item.dstIp,
					dstPort: item.dstPort,
					
					msg: item.msg,
				});
			}else if(item.msgType=='M'){
				
				_flow.push({
					msgType: item.msgType,
					color:color,
				
					callId: item.callId, 
					time: item.time, 
					lStatus: item.lStatus,
					lType: item.lType,
					rStatus: item.rStatus,
					rType: item.rType,
					aIp: item.aIp,
					aPort: item.aPort,
					bIp: item.bIp,
					bPort: item.bPort,
					cIp: item.cIp,
					cPort: item.cPort,
					dIp: item.dIp,
					dPort: item.dPort,
					
					msg: item.msg
				});
			}
			
		},
		clearResult: function(){
			_result.length = 0;
			_flow.length = 0;
		},
		showResult: function(){
			
			// list에 선택된 것이 있나?
			if(typeof tableTrace != 'undefined' && tableTrace != null){
				var data = tableTrace.rows('.selected').data();
				if(data.length!=0){
				
					// show result
					 var obj = $("#dtTraceResult");
					 if(obj.length == 1 && tableTraceResult != null){
						 tableTraceResult.clear().draw();
						 for(var i=0; i<_result.length; i++){
							 tableTraceResult.row.add(_result[i]).draw(false);
						 }
					 }
					 
					 // show flow
					 _showFlow();
				 
				}else{ // no select
					tableTraceResult.clear().draw();
				}
			}
			 
			 
		},
		checkResult: function(callId, bCheck){
			//alert(callId + ' , ' + bCheck)
			for(var i=0; i<_result.length; i++){
				if(_result[i].callId==callId){
					_result[i].check = bCheck;
					break;
				}
			}
			
			 _showFlow(); // show flow
		},
//		checkAll: function(bCheck){
//			for(var i=0; i<_result.length; i++){
//				_result[i].check = bCheck;
//			}
//			
//			 _showFlow(); // show flow
//		},
		showFlow: function(){
			_showFlow();
		},
		showMsg: function(index){
			var divMessage = $("#divMessage");
			if(divMessage.length == 1){
				var msg = _flow[index].msg.replace(/\n/g, "<br />");
				divMessage.html(msg);
			}
		},
		getTest: function(){
			return "ahnks";
		}
		
		
	}
	
	
})();

/*-------------------------------------------------------------------------------------
 * 
 * 							EGIS
 * 
 -------------------------------------------------------------------------------------*/
var Egis=(function(){
	
	
	
	//------- smartbox ---------------------
	var _smartBox = null;
	
	//--------------- socket ------------------------
	var _ws;
	
	var _socket;
	var _stompClient ;
	
	
	//-------------- chart --------------------------
	var _chart1, _chart2, _chart3, _chart4;
	var options = {
        responsive: true,
        maintainAspectRatio: false,
        duration: 0,
        title : {
      	  	display: false,
        },
        hover: {
           mode: 'dataset'
        },
        scales: {
            xAxes: [{
                display: true,
                gridLines:{
              	  display: false
                },
                ticks: {
                    maxRotation: 0
                },
            }],
            yAxes: [{
                display: true,
                gridLines:{
              	  display: false
                },
                ticks: {
                    suggestedMin: 0,
                    suggestedMax: 100,
                    userCallback: function(value, index, values) {
                    	if(value < 10) 			return "          " + value;
                    	if(value < 100)		 	return "        " + value;
                    	if(value < 1000) 		return "      " + value;
                    	if(value < 10000) 	return "    " + value;
                    	if(value < 100000) 	return "  " + value;
                    	return value;
                    }
                }
            }]
        },
        legend: {
        	display: false
        },
        tooltips: {
        	enabled:true,
 //       	backgroundColor: 'rgba(0,0,0,0.4)',
//        	//mode:'x-axis',
        	intersect: true,
        	mode: 'single',
        	callbacks: {
//        		label: function(tooltipItem, data) {
//        			return data.datasets[tooltipItem.datasetIndex].data[tooltipItem.index];
//        		},
//        		title: function(tooltipItem, data) {
//        			//return data.labels[tooltipItem[0].index]; 
//        			return Data.getX(tooltipItem[0].index);
//        			//return " " +tooltipItem[0].index;
//        		},
//        		//footer: function(tooltipItem, data) { return 'Total:100'; }
        	},
        },

    };
    
	var _config1 = {type:'line', options:options };
	var _config2 = {type:'line', options:options };
	var _config3 = {type:'line', options:options };
	var _config4 = {type:'line', options:options };
	
	
	//-------------- _resize --------------------------
	var _resize = function(){
		
		var winHeight = $(window).height();
		
		var divChart = $("#divChart");
		var dtAlarm = $("#dtAlarm");
		
		var msg = "" + divChart.length;
		
		if(divChart.length==1){
			var chart1 = $("#chart1");
			var chart2 = $("#chart2");
			var chart3 = $("#chart3");
			var chart4 = $("#chart4");
			
			divChart.height(winHeight-370);
			
			msg += divChart 
			
			var w = divChart.width() - 20;
			var h = (divChart.height() - 200) / 4 ;
			
			chart1.width(w); 
			chart2.width(w); 
			chart3.width(w); 
			chart4.width(w); 
			
			chart1.height(h);
			chart2.height(h);
			chart3.height(h);
			chart4.height(h);
			
			if(typeof _chart1 != 'undefined') _chart1.resize();
			if(typeof _chart2 != 'undefined') _chart2.resize();
			if(typeof _chart3 != 'undefined') _chart3.resize();
			if(typeof _chart4 != 'undefined') _chart4.resize();
		
		}
		
		// dashboard alarm/event table
		if(dtAlarm.length == 1){
			$('div.dataTables_scrollBody').css('height',winHeight-422);
			tableAlarm.draw();
		}
		
		// ping message box
		var obj = $("#divPingMsg");
		if(obj.length == 1){
			obj.height(winHeight - 240);
		}
		
		// call trace message box
		var obj = $("#divMessage");
		if(obj.length == 1){
			obj.height(winHeight - 400);
		}
		
		// trace result - flow header width for scrolling data
		//TraceData.resizeFlow();
		var divFlow = $("#divFlow");
		if(divFlow.length == 1){
			// height
			divFlow.height(winHeight - 420);
			
			// is scrollbar?
			 if(divFlow.prop('scrollHeight') > divFlow.height()){
				 $("#tdFlowHeader").width(divFlow.width()-18);
				 divFlow.animate({ scrollTop: divFlow[0].scrollHeight }, 500);
			 }else{
				 $("#tdFlowHeader").width(divFlow.width());
			 }
			 
		}
		
		var divDateNtp = $("#divDateNtp");
		if(divDateNtp.length == 1){
			divDateNtp.height(winHeight - 180);
		}
		
	};
	
	//--------------------- socket ---------------------------------------------
	
	var _connectCallback = function() { 
//		  _stompClient.subscribe('/topic/datetime', _renderDatetime);
//		  _stompClient.subscribe('/topic/status', _renderStatus);
//		  _stompClient.subscribe('/topic/chart', _renderChart);
	};
	var _errorCallback = function(error) {
		  alert(error.headers.message);
	};
	
	var _renderDatetime = function(frame) {
		  var dateTime = JSON.parse(frame.body);
		  $("#systemDateTime").html(dateTime);
	};
	
	var _renderStatus = function(frame) {
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
	};
	
	
//	var _renderChart = function(frame){
//		 var item = JSON.parse(frame.body);
//		 Data.addData(item);
//		 
//		 // if chart switch is on, draw chart.
//		 var obj = $("#chartSwitch");
//		 if(obj.length == 1 && obj.is(':checked')){
//			 _drawChart(item.chartIndex);
//		 }
//	};
	
	
	var _drawChart = function(idx){
		
		if($("#chart"+(idx+1)).length == 0) return;

		var time = Data.getTime(idx); // []
		var data = Data.getData(idx); // [[]]
		
		var info = Data.getInfo(idx);
		var title = info[0]; // [0]
		var legend = info[1]; // []
		var color = info[2]; // []
		var unit = info[3]; // []
		
		if(typeof time == 'undefined' || time.length == 0) return;
		
		$("#chart"+(idx+1)+"Title").html('<i class="fa fa-caret-right"></i>&nbsp;' + title);
		
		var legendString='';
		for(var i=0; i<legend.length; i++){
			legendString += '<i class="fa fa-minus" style="color:'+color[i]+';padding-left:10px"></i><span style="font-size:10px;padding:0 10px 0 5px">' + legend[i] + '(' + unit[i] + ')</sapn>';
		}
		$("#chart"+(idx+1)+"Legend").html(legendString);
		
		var datasets = [];
		for(var i=0; i<legend.length; i++){
			datasets.push({
	                data: data[i],
	                borderWidth:1,
	                borderColor: color[i],
	                backgroundColor: "rgba(255,255,255,0)", 
	                radius: 2,
	            });
		}
		
		// tooltip - title
		options.tooltips.callbacks.title =  function(tooltipItem, data) {
			return Data.getX(idx, tooltipItem[0].index);
		};
		// tooltip - label
		options.tooltips.callbacks.label =  function(tooltipItem, data) {
			var index = tooltipItem.index;
			var datasetIndex = tooltipItem.datasetIndex;
			return legend[datasetIndex] + " : " + data.datasets[datasetIndex].data[index] + " " + unit[datasetIndex];
		};
		
		
		if(idx == 0) {
			if(typeof _chart1 != 'undefined' && destroy1){
				_chart1.destroy();
			}
			destroy1 = true;
			_config1.data = {labels: time, datasets: datasets};
			_chart1 = new Chart(document.getElementById("chart1"), _config1);
		}
		else if(idx ==1){
			if(typeof _chart2 != 'undefined' && destroy2){
				_chart2.destroy();
			}
			destroy2 = true;
			_config2.data = {labels: time, datasets: datasets};
			_chart2 = new Chart(document.getElementById("chart2"), _config2);
			$("#divChart2Head").show();
		}else if(idx ==2){
			if(typeof _chart3 != 'undefined' && destroy3){
				_chart3.destroy();
			}
			destroy3 = true;
			_config3.data = {labels: time, datasets: datasets};
			_chart3 = new Chart(document.getElementById("chart3"), _config3);
			$("#divChart3Head").show();
		}else if(idx ==3){
			if(typeof _chart4 != 'undefined' && destroy4){
				_chart4.destroy();
			}
			destroy4 = true;
			_config4.data = {labels: time, datasets: datasets};
			_chart4 = new Chart(document.getElementById("chart4"), _config4);
			$("#divChart4Head").show();
		}
		
		_resize();
		
	};
	
	var _initSocket = function(){
		
		_ws = new WebSocket(wsString+'://'+location.host+'/ws/trace'); // ws => wss (http=>https)
		_ws.onopen = function(){
			// receive event
			_ws.onmessage = function(event){
				 var item = JSON.parse(event.data);
				 
//				 if(item.msgType != 'T'){
//					 alert(item.msgType + ' , ' + item.msgMode + ' , '+ item.traceCmd);
//				 }
				 
				 if(item.msgType=='T'){	// date time
					 $("#systemDateTime").html(item.dateTime);
				 }else if(item.msgType=="C"){	// chart
					 Data.addData(item);
					 
					 // if chart switch is on, draw chart.
					 var obj = $("#chartSwitch");
					 if(obj.length == 1 && obj.is(':checked')){
						 _drawChart(item.chartIndex);
					 }
				 }else  if(item.msgType=="P"){	// ping
					 var obj = $("#divPingMsg");
					 if(obj.length == 1){
						 if(item.msgMode=='E'){
							 $("#btnPing").prop('disabled', false);
						 }else{
							 obj.append(item.msg + "<br />");
						 }
					 }
				//-------  tcp dump ----------------- 	 
				 }else  if(item.msgType=="D"){ 
					 
					 var obj = $("#divTcpDumpMsg");
					 if(obj.length == 1){
						 if(item.msgMode=='E'){ // end process
							 $("#btnStart").prop('disabled', false);
						 }else if(item.msgMode=='A'){ // alive thread
							 obj.append("<span style='color:red'>WARNING!</span> TCP Dump is running by other user.<br />");
							 $("#btnStart").prop('disabled', false);
						 }else{
							 obj.append(item.msg + "<br />");
						 }
					 }
					 
				//-------  trace list ok/error ----------------- 	 
				 }else if(item.msgType=="L"){ // 
					 
					 //alert(item.msgType + ' , ' + item.msgMode + ' , '+ item.traceCmd);
					 
					 if(item.msgMode=="ok"){
						 if(item.traceCmd=='add'){
							 $("#modalAddTrace").modal('hide');
							 TraceData.addList(item);
							 TraceData.showList();
							 
							
						 }else if(item.traceCmd=='del'){
							 hideConfirm();
							 TraceData.removeList(item);
							 TraceData.showList();
						 }
					 }else if(item.msgMode=="error"){
						 showMsg("ERROR", item.msg);
					 }
					 
				//-------  sip_trace result ----------------- 
				 }else if(item.msgType=="S"){
					 TraceData.addResult(item);
					 TraceData.showResult();
				//-------  media_trace result ----------------- 
				 }else if(item.msgType=="M"){
					 TraceData.addResult(item);
					 TraceData.showResult();
				 }
			};
			
			// close event
			_ws.onclose = function(event){
				//alert('close websocket');
			};
		};
	};
	
	var _showSmartMsg = function(type){
		
		if(type==1){ // down
			$.SmartMessageBox({
				title:'<i class="fa fa-exclamation-triangle" style="color:yellow"></i> No response from Server!',
				content:'Please, Check the server!',
				buttons:"[Reload]"
				},
				function(ButtonPressed){
					if (ButtonPressed === "Reload") {
						location.reload()
					}
				});
		}else if(type==2){	// duplecate
			$.SmartMessageBox({
				"title":'<i class="fa fa-exclamation-triangle" style="color:yellow"></i> Duplicate Login!!',
				"content":'Please, Login again!',
				"buttons":"[Login]"
				},
				function(ButtonPressed){
					if (ButtonPressed === "Login") {
						location.href = "/login";
					}
				});
		}
		
		 e.preventDefault();

	};
	
	var _showAlarmCount = function(){
		$.post("getAlarmCount", {}, function(json){
			var alarmCount = json.result;
			if(alarmCount != null){
				_setAlarmCount(alarmCount);
			}
		});
	};
	
	var _getLastAlarmDatetime = function(){
		var item = "";
		tableAlarm.rows().every( function ( rowIdx, tableLoop, rowLoop ) {
			var data = this.data();
			if(item==""){
				item = data.createDatetime.substring(0,19);
			}
		});
		return item;
	};
	
	var _getAlarmStatus = function(){
		if($("#alarmCriticalCnt").length == 1){
			
			var alarmLevel = -1;
			if(typeof g_alarmLevel != 'undefined'){
				alarmLevel = g_alarmLevel;
			}
			
			
			var lastAlarmDatetime = "";
			if(typeof tableAlarm != 'undefined'){
				lastAlarmDatetime = _getLastAlarmDatetime();
			}
			
			$.post("getAlarmStatus", {alarmLevel: alarmLevel}, function(json){
				
				var alarmCount = json.alarmCount;
				var lastAlarmDatetime2 = (json.lastAlarmDatetime == "")? "" : json.lastAlarmDatetime.substring(0,19);
				
				// alarm count
//				if(alarmCount != null){
//					_setAlarmCount(alarmCount);
//				}
				
				// alarm data of dashboard
//				if(alarmDataList != null && alarmDataList.length > 0){
				if(typeof tableAlarm != 'undefined' && lastAlarmDatetime != lastAlarmDatetime2 ){
					tableAlarm.ajax.reload(null, false);
				}
				
			});
		}
	};
	
	
	var _setAlarmCount = function(item){
		$("#alarmCriticalCnt").html(item.criticalCnt);
		$("#alarmMajorCnt").html(item.majorCnt);
		$("#alarmMinorCnt").html(item.minorCnt);
		$("#alarmInformationCnt").html(item.informationCnt);
		
		setTimeout(function(){
			
			// off alarm sound
			_audioCritical.pause();
			_audioCritical.currentTime = 0;
			
			_audioMajor.pause();
			_audioMajor.currentTime = 0;
			
			_audioMinor.pause();
			_audioMinor.currentTime = 0;
			
			// alarm Sound On
			if(g_alarmSound){
				
				if(item.criticalCnt >0){
					_audioCritical.loop = true;
					_audioCritical.play();
				}else if(item.majorCnt >0){
					_audioMajor.loop = true;
					_audioMajor.play();
				}else if(item.minorCnt >0){
					_audioMinor.loop = true;
					_audioMinor.play();
				}
			}
			
		},1000);
	};
	
	
	var _toggleFullScreen = function(){
			
		 	var doc = parent.document;
				
	        //Toggle fullscreen off, activate it
	        if (!doc.fullscreenElement && 
	        		!doc.mozFullScreenElement && 
	        		!doc.webkitFullscreenElement && 
	        		!doc.msFullscreenElement ) {
	            if (doc.documentElement.requestFullscreen) {
	            	doc.documentElement.requestFullscreen();
	            } else if (doc.documentElement.mozRequestFullScreen) {
	            	doc.documentElement.mozRequestFullScreen(); // Firefox
	            } else if (doc.documentElement.webkitRequestFullscreen) {
	            	doc.documentElement.webkitRequestFullscreen(); // Chrome and Safari
	            } else if (doc.documentElement.msRequestFullscreen) {
	                doc.documentElement.msRequestFullscreen(); // IE
	            }
	        //Toggle fullscreen on, exit fullscreen
	        } else {
	            if (doc.exitFullscreen) {
	            	doc.exitFullscreen();
	            } else if (doc.msExitFullscreen) {
	            	doc.msExitFullscreen();
	            } else if (doc.mozCancelFullScreen) {
	            	doc.mozCancelFullScreen();
	            } else if (doc.webkitExitFullscreen) {
	            	doc.webkitExitFullscreen();
	            }
	        }
	};
	
	
	
	
	
	return{
		init: function(){
		
			// load alarm sound
			_audioCritical = new Audio('/resources/sound/egis_alarm_critical.mp3');
			_audioMajor = new Audio('/resources/sound/egis_alarm_major.mp3');
			_audioMinor = new Audio('/resources/sound/egis_alarm_minor.mp3');
			
			
			if(!debug){
				
				// dashboard status
				systemStatusInterval = 2000;
				
				// alarm count
				alarmCountInterval = 2000;
				
				// heartBeatInterval
				heartBeatInterval = 3000;
				
				wsString = "wss";
				
				/*
				 * init menu
				 */ 
				//location.href = '/home#/resources/html/dashboard/dashboard.html';
				
				/*
				 * close browser - logout, 리프래시 해도 로그아웃 되버림.
				 */
				$(window).unload(function(){
					window.parent.location.href = '/logout';
				});
			
			}else{
				g_alarmSound = false;
				alarmCountInterval = 500000; 
				systemStatusInterval = 1000000; 
				heartBeatInterval = 200000;
				
				wsString = "ws";
				
			}
			
			/*
			 *   resize 
			 */
			$(window).bind('resize', function() {
				_resize(); 
			}).trigger('resize');
			
			
			/*
			 * session check for login duplicate
			 */
			setInterval(function(){
				 $.ajax({ 
					 	url: "/heartbeat",
				        type: "post",
				        data: '',
				        contentType: "application/json;",
				        dataType: "json",
				        success: function (json) {
				        	if(json.result==0){ // not alive
				        		 window.location.href="/login";
				        	}
				        },
				        error: function (xhr) {
				        	if(xhr.status==0){ // server is down.
				        		_showSmartMsg(1);
				        	}else if (xhr.status === 200) { // duplecate 
				                window.location.href="/login";
				        		//_showSmartMsg(2);
				            }
				        }
				    });
				}, heartBeatInterval);
			
			
			/*
			 *  append idle
			 */
			$('body').append( $('<div>').load("/resources/html/idle.html"));
			
			
			/*
			 *  Page Lock 
			 */
//			var sleepModeByNoActionDuration = $("#hidSleepModeByNoActionDuration").val();
//			if(sleepModeByNoActionDuration != '' && sleepModeByNoActionDuration != 0){ // sleepModeByNoActionDuration==0 은 stayLoggedIn==1이라서.
//				$(document).idle({
//					onIdle: function(){
//						$.post("/lock",{url:window.location.href}, function(json){
//							location.href = "/" + json.page + "?id="+$("#hidId").val();
//				    	});
//				  	},
//				  	idle: 1000*sleepModeByNoActionDuration
//				});
//			}
			
			/*
			 * forced Logout by No Action (lockPage에서 이동)
			 */
			var forceLogoutByNoActionDuration = $("#hidForceLogoutByNoActionDuration").val();
			if(forceLogoutByNoActionDuration != '' && forceLogoutByNoActionDuration > 0){
				$(document).idle({
					onIdle: function(){ location.href = "/logout"; },
				  	idle: 1000*forceLogoutByNoActionDuration
				});
			}
			
			
			
			/*
			 *  websocket - stomp
			 */
//			_socket = new SockJS("/ws");
//			_stompClient = Stomp.over(_socket);
//			_stompClient.connect("guest", "guest", _connectCallback, _errorCallback);
			
			
			/*
			 * websocket
			 */
			
			_initSocket();
			
			window.onbeforeunload = function(){
				_ws.close();
				_ws = null;
			}
			
//			ws = new WebSocket('ws://'+location.host+'/ws');
//			_stompClient = Stomp.over(ws);
//			_stompClient.connect("guest", "guest", _connectCallback, _errorCallback);
			
			/*
			 * switch
			 */
			
			$("#chartSwitch").change(function(){
				if($(this).is(":checked")){
					Egis.drawChart();
				}
			});
			
			
			/*
			 * getAlarmCount
			 */
			_showAlarmCount();
			setInterval(function(){
				_showAlarmCount();
				
				_getAlarmStatus();
				
			}, alarmCountInterval);	
			
			
			
			
		}, // init
		resize: function(){
			_resize();
		},
		drawChart: function(){
			setTimeout(function(){_drawChart(0);},500);
			setTimeout(function(){_drawChart(1);},500);
			setTimeout(function(){_drawChart(2);},500);
			setTimeout(function(){_drawChart(3);},500);
		},
		keepChart: function(){
			_keepChart1 = true;
		},
		sendPing: function(toIP, fromIP){
			var obj = {msgType:'P', toIP:toIP, fromIP:fromIP};
			_ws.send(JSON.stringify(obj));
		},
		sendTcpDump: function(msgMode, intf, transport, port, duration){
			var obj = {msgType:'D', msgMode:msgMode,  intf:intf, transport:transport, port:port, duration:duration};
			_ws.send(JSON.stringify(obj));
		},
		sendTrace: function(traceCmd, traceType, condition, duration){
			var obj = {msgType:'T', traceCmd: traceCmd, traceType:traceType, condition:condition, duration:duration};
			_ws.send(JSON.stringify(obj));
		},
		initSocket: function(){
			_initSocket();
		},
		getTest: function(){
			return "a";
		},
		showAlarmCount: function(){
			_showAlarmCount();
		},
		toggleFullScreen: function(){
			_toggleFullScreen();
		}
		
	}
	
})();
$(function(){Egis.init();});	
