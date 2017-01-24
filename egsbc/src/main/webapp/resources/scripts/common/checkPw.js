$(function() {	
				
	$("#btnCheck").click(function(){ 
		do_submit();
	});
	
	$('#frm input').keydown(function(e) {
	    if (e.keyCode == 13) {
	    	do_submit();
	    }
	});
	
});



function do_submit(){
	
	var pw = $("#pw").val();
	if(pw==''){
		alert('input password!');
		return;
	}
	
// 				$("#frm").ajaxForm({
// 					url: "/checkPw",
// 					type: "POST",
// 					success: function(responseText, statusText, xhr, $form){
// 						location.href=responseText.page;
// 				});
	$.ajax({
	    type: "post",
	    url: "/checkPw",
	    data: { pw: pw},
	    success: function(result) {
	    	if(result.page!=''){
	    		location.href=result.prePage;
	    	}else{
	    		$("#divWrong").show();
	    	}
	    }
	});

}