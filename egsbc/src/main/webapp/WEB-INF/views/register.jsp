<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en-us" id="extr-page">
	<head>
		<meta charset="utf-8">
		<title> SABER-V </title>
		<meta name="description" content="">
		<meta name="author" content="">
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
		
		<!-- #CSS Links -->
		<!-- Basic Styles -->
		<link rel="stylesheet" type="text/css" media="screen" href="/resources/css/bootstrap.min.css">
		<link rel="stylesheet" type="text/css" media="screen" href="/resources/css/font-awesome.min.css">

		<!-- SmartAdmin Styles : Caution! DO NOT change the order -->
		<link rel="stylesheet" type="text/css" media="screen" href="/resources/css/smartadmin-production-plugins.min.css">
		<link rel="stylesheet" type="text/css" media="screen" href="/resources/css/smartadmin-production.min.css">
		<link rel="stylesheet" type="text/css" media="screen" href="/resources/css/smartadmin-skins.min.css">

		<!-- SmartAdmin RTL Support -->
		<link rel="stylesheet" type="text/css" media="screen" href="/resources/css/smartadmin-rtl.min.css"> 


		<!-- Demo purpose only: goes with demo.js, you can delete this css when designing your own WebApp -->
		<link rel="stylesheet" type="text/css" media="screen" href="/resources/css/demo.min.css">
		
		<link rel="stylesheet" type="text/css" media="screen" href="/resources/css/egis.css">
	</head>
	
	<body class="animated fadeInDown " >


		<div id="main" role="main" >

			<!-- MAIN CONTENT -->
			<div id="content" class="container" >

				<div class="row" >
					
					<div class="col-xs-12 col-sm-12 col-md-4 col-lg-4 col-center-block align-middle">
						<div class="well no-padding">
							<form action="register" id="frmRegister" method="post" class="smart-form client-form">
								<header>
									SABER-V <br />
									Change ID/Password for Admin Level User
								</header>

								<fieldset>
									
									<section>
										<label class="label">*User ID</label>
										<label class="input"> <i class="icon-append fa fa-user"></i>
											<input type="text" name="id">
									</section>

									<section>
										<label class="label">*Password</label>
										<label class="input"> <i class="icon-append fa fa-lock"></i>
											<input type="password" name="pw" id="pw">
										<label style="color:#8B8B8B">(10 ~ 64 characters : alphabet + number + “!@#$”)</label>	
									</section>
									
									<section>
										<label class="label">*Confirm Password</label>
										<label class="input"> <i class="icon-append fa fa-lock"></i>
											<input type="password" name="pw2" id="pw2">
									</section>
								
								</fieldset>
								<footer>
									<button type="button" class="btn btn-primary" id="btnRegister">
										Save
									</button>
								</footer>
							</form>

						</div>
						
						
					</div>
				</div>
			</div>

		</div>

		<!--================================================== -->	

		<!-- PACE LOADER - turn this on if you want ajax loading to show (caution: uses lots of memory on iDevices)-->
		<script src="/resources/js/plugin/pace/pace.min.js"></script>

	    <script src="/resources/js/libs/jquery-2.1.1.min.js"></script>
		<script src="/resources/js/libs/jquery-ui-1.10.3.min.js"></script>

		<!-- IMPORTANT: APP CONFIG -->
		<script src="/resources/js/app.config.js"></script>

		<!-- JS TOUCH : include this plugin for mobile drag / drop touch events 		
		<script src="js/plugin/jquery-touch/jquery.ui.touch-punch.min.js"></script> -->

		<!-- BOOTSTRAP JS -->		
		<script src="/resources/js/bootstrap/bootstrap.min.js"></script>

		<!-- JQUERY VALIDATE -->
		<script src="/resources/js/plugin/jquery-validate/jquery.validate.min.js"></script>
		
		<!-- JQUERY MASKED INPUT -->
		<script src="/resources/js/plugin/masked-input/jquery.maskedinput.min.js"></script>
		
		<!--[if IE 8]>
			
			<h1>Your browser is out of date, please update your browser by going to www.microsoft.com/download</h1>
			
		<![endif]-->
		
		<script src="/resources/js/plugin/jquery-form/jquery-form.min.js"></script>

		<!-- MAIN APP JS FILE -->
		<script src="/resources/js/app.min.js"></script>

		<script type="text/javascript">
			$(function() {
				// Validation
				$("#frmRegister").validate({
					rules : {
						id : {
							required : true,
							minlength : 4,
							maxlength : 20,
							idcheck: true
						},
						pw : {
							required : true,
							minlength : 10,
							maxlength : 64,
							pwcheck: true,
						}
					},
					messages : {
						id : {
							required : '<span class="colorRedRose">Input ID.</span>',
							minlength : '<span class="colorRedRose">Input ID by proper length. </span>',
							maxlength : '<span class="colorRedRose">Input ID by proper length. </span>',
							idcheck: '<span class="colorRedRose">Input proper ID.</span>',
						},
						pw : {
							required : '<span class="colorRedRose">Input password.</span>',
							minlength : '<span class="colorRedRose">Input password by proper length. </span>',
							maxlength : '<span class="colorRedRose">Input password by proper length. </span>',
							pwcheck: '<span class="colorRedRose">Input proper password.</span>',
						}
					},
					errorPlacement : function(error, element) {
						error.insertAfter(element.parent());
					},
					submitHandler: function(form) {
						if($("#pw").val()!=$("#pw2").val()){
							alert('passwords do not mach!');
							return false;
						}
						return true;
					}
				});
				
				$.validator.addMethod("idcheck", function(value) {
					   return /^([a-zA-Z0-9]+)$/.test(value) 
				});
					       
				$.validator.addMethod("pwcheck", function(value) {
					   //return /^[A-Za-z0-9\d=!\-@._*]*$/.test(value) // consists of only these
					       return /[A-Za-z]/.test(value) 
					       && /\d/.test(value) 
					       && /[\{\}\[\]\/?.,;:|\)*~`!^\-_+<>@\#$%&\\\=\(\'\"]/.test(value) 
				});

				$("#btnRegister").click(function(){
					if(!$("#frmRegister").valid()) return;
 					$("#frmRegister").submit();
				});
				
				
				$("body").append($("<div>").load("/resources/html/common.html"));
			});
		</script>

	</body>
</html>