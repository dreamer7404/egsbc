$(function() {
	$("#btnLogin").click(function(){
		 loginSubmit();
	});
	
//	$("#login-form").validate({
//		rules : {
//			inputId : {
//				required : true,
//				minlength : 4,
//				maxlength : 20,
//				idcheck: true
//			},
//			pw : {
//				required : true, 
//				minlength : 10,
//				maxlength : 64,
//				pwcheck: true
//			}
//		},
//		messages : {
//			inputId : {
//				required : 'Please enter ID',
//				minlength : 'Input proper length.',
//				maxlength : 'Input proper length.',
//				idcheck: 'Input proper ID.',	
//			},
//			pw : {
//				required : 'Please enter password',
//				minlength : 'Input proper length.',
//				maxlength : 'Input proper length.',
//				pwcheck: 'Input proper password.',	
//			}
//		},
//		errorPlacement : function(error, element) { error.insertAfter(element.parent()); }
//	});
//	
//	$.validator.addMethod("idcheck", function(value) {
//		   return /^([a-zA-Z0-9]+)$/.test(value) 
//	});
//		       
//	$.validator.addMethod("pwcheck", function(value) {
//		   //return /^[A-Za-z0-9\d=!\-@._*]*$/.test(value) // consists of only these
//		       return /[A-Za-z]/.test(value) 
//		       && /\d/.test(value) 
//		       && /[\{\}\[\]\/?.,;:|\)*~`!^\-_+<>@\#$%&\\\=\(\'\"]/.test(value) 
//	});
	
	
	$("#id, #pw").keypress(function(e) {
	    if (e.keyCode == 13) {
	    	 loginSubmit();
	    }
	});
});
function loginSubmit(){
	
	var objStayed = $("input:checkbox[id='stayLoggedIn']");
	var chkStayed = "";
	
	if(objStayed.length==0 || objStayed.is(":checked")){
		chkStayed = "0";
	}else{
		chkStayed = "1";
	}
	
//	if(!$('#login-form').valid()){
//		return;
//	}
	$("#hidId").val($("#id").val()+"|"+chkStayed);
	$("#login-form").submit();
}