function setServiceGroupList(item, titlePost){
	var urlRealm="", urlServer="";
	var mode = $("#frmService input:radio[name='mode']").is(":checked"); 
	if(mode==1){ // Trunking
		urlRealm = "getSipRealmGroupNameList";
		urlServer = "getSipServerGroupNameList";
	}else{ // Server/Realm
		urlRealm = "getSipRealmGroupNameList";
		urlServer = "getSipServerGroupNameList";
	}
	
	$.post(urlRealm, {}, function(json2){
		var data2=json2.data;
		
		setControlDualList("frmService", "nameList2", (item==null)?null:getLGroupList(item), data2, '', false);
		
		$.post(urlServer, {}, function(json1){
  			var data1=json1.data;
  			
			setControlDualList("frmService", "nameList1", (item==null)?null:getRGroupList(item), data1, '', false);
			
			showModal($("#modalService"));
			$("#titleModalService").html("Service "+titlePost);
 		});
	});	
}

function initDualList(obj){
	return obj.bootstrapDualListbox({
	      showFilterInputs:false,
	      infoText:false,
	      selectorMinimalHeight:150
  	});
}
// setControlDualList('frmRealmGroup", "nameList', null, data, '', false);
function setControlDualList(frmId, id, unselData, selData, value, disabled){
	var obj = initDualList($("#"+frmId+" #"+id));
	obj.empty();
	if(unselData != null){
		for(var i=0; i<unselData.length; i++){
			obj.append("<option value='"+unselData[i]+"'>"+unselData[i]+"</option>");
		}
	}
	for(var i=0; i<selData.length; i++){
		if(unselData != null){
			if(!isElem(unselData, selData[i])){
				obj.append("<option value='"+selData[i]+"' selected='selected'>"+selData[i]+"</option>");
			}
		}else{
			obj.append("<option value='"+selData[i]+"' selected='selected'>"+selData[i]+"</option>");
		}
	}
	obj.bootstrapDualListbox('refresh');
}
