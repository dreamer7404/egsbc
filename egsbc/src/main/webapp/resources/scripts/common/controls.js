//=================== get control object===========================
function findControlInput(frmId, id){
	return $("#"+frmId+" #"+id);
}
function findControlSelect(frmId, id){
	return $("#"+frmId+" #"+id);
}
function findControlCheck(frmId, id){
	return $("#"+frmId+" input:checkbox[id='"+id+"']");
}
function findControlRadio(frmId, name){
	return $("#"+frmId+" :radio[name='"+name+"']");
}

//=================== get control value===========================
function getControlInput(frmId, id){
	return $("#"+frmId+" #"+id).val();
}
function getControlSelect(frmId, id){
	return $("#"+frmId+" #"+id).val();
}
function getControlCheck(frmId, id){
	return $("#"+frmId+" input:checkbox[id='"+id+"']").is(":checked");  
}
function getControlRadio(frmId, name){
	return $("#"+frmId+" :radio[name='"+name+"']:checked").val();
}

//==================== set control ==========================
function setControlInput(frmId, id, value, disabled){
	var obj=$("#"+frmId+" #"+id);
	obj.val(value);
	obj.attr("disabled", disabled);
}

function setControlSelect(frmId, id, chooseText, data, value, disabled){
	var obj = $("#"+frmId+" #"+id);
	obj.empty();
	if(chooseText !=''){
		obj.append("<option value=''  selected='' >"+chooseText+"</option>");
	}
	for(var i=0; i<data.length; i++){
		obj.append("<option value='"+data[i]+"'>"+data[i]+"</option>");
	}
	setControlInput(frmId, id, value, disabled);
	if(obj.val()==null){
		obj.val('');
	}
}


function setControlCheck(frmId, id, checked, disabled){
	var obj=$("#"+frmId+" input:checkbox[id='"+id+"']");
	obj.prop("checked", checked); 
	obj.attr("disabled", disabled);
}

function setControlRadio(frmId, name, value, disabled){
	$("#"+frmId+" input:radio[name='"+name+"']:input[value='"+value+"']").prop("checked", true);
	$("#"+frmId+" input:radio[name='"+name+"']").attr("disabled", disabled);
}


