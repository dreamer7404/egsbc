<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en-us" id="lock-page">
	<head>
		<meta charset="utf-8">
		<title> SmartAdmin</title>
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

		<!-- page related CSS -->
		<link rel="stylesheet" type="text/css" media="screen" href="/resources/css/lockscreen.min.css">

		<!-- #FAVICONS -->
		<link rel="shortcut icon" href="/resources/img/favicon/favicon.ico" type="image/x-icon">
		<link rel="icon" href="/resources/img/favicon/favicon.ico" type="image/x-icon">

		<!-- #GOOGLE FONT -->
		<link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Open+Sans:400italic,700italic,300,400,700">

		<!-- #APP SCREEN / ICONS -->
		<link rel="apple-touch-icon" href="/resources/img/splash/sptouch-icon-iphone.png">
		<link rel="apple-touch-icon" sizes="76x76" href="/resources/img/splash/touch-icon-ipad.png">
		<link rel="apple-touch-icon" sizes="120x120" href="/resources/img/splash/touch-icon-iphone-retina.png">
		<link rel="apple-touch-icon" sizes="152x152" href="/resources/img/splash/touch-icon-ipad-retina.png">
		
		<!-- iOS web-app metas : hides Safari UI Components and Changes Status Bar Appearance -->
		<meta name="apple-mobile-web-app-capable" content="yes">
		<meta name="apple-mobile-web-app-status-bar-style" content="black">
		
		<!-- Startup image for web apps -->
		<link rel="apple-touch-startup-image" href="/resources/img/splash/ipad-landscape.png" media="screen and (min-device-width: 481px) and (max-device-width: 1024px) and (orientation:landscape)">
		<link rel="apple-touch-startup-image" href="/resources/img/splash/ipad-portrait.png" media="screen and (min-device-width: 481px) and (max-device-width: 1024px) and (orientation:portrait)">
		<link rel="apple-touch-startup-image" href="/resources/img/splash/iphone.png" media="screen and (max-device-width: 320px)">

		
	</head>
	
	<body>

		<div id="main" role="main">

			<!-- MAIN CONTENT -->
			<form class="lockscreen animated flipInY" id="frm">
				<div class="logo">
					<h1 class="semi-bold"> ACASIA-V &nbsp;&nbsp;&nbsp;<i class="fa fa-lock text-muted"></i> &nbsp;Screen Locked</h1>
				</div>
				<div>
					<div>
						<h1><i class="fa fa-user"></i> ${userId} &nbsp;&nbsp;&nbsp;</h1>
						<div class="input-group">
							<input class="form-control" type="password" placeholder="Password" id="pw" name="pw" value="egis1234!@" >
							<div class="input-group-btn">
								<button class="btn btn-primary" type="button" id="btnCheck">
									<i class="fa fa-key"></i>
								</button>
							</div>
						</div>
						<div id="divWrong" style="display:none;color:red">
							wrong password!
						</div>
						<p class="no-margin margin-top-5">
							<a href="/login"> go to login</a>
						</p>
					</div>

				</div>
				<p class="font-xs margin-top-5">
					Copyright EGISTECH Co., Ltd. All Rights Reserved. 
				</p>
			</form>

		</div>

		<!--================================================== -->	

		<!-- PACE LOADER - turn this on if you want ajax loading to show (caution: uses lots of memory on iDevices)-->
		<script src="/resources/js/plugin/pace/pace.min.js"></script>

	    <!-- Link to Google CDN's jQuery + jQueryUI; fall back to local -->
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
		
		<script src="/resources/js/plugin/idle/jquery.idle.min.js"></script> <!-- jquery idle -->
		
		<!-- MAIN APP JS FILE -->
		<script src="/resources/js/plugin/jquery-form/jquery-form.min.js"></script> <!-- jquery form -->
		<script src="/resources/scripts/common/checkPw.js"></script>
		
		<script>
		$(function(){
			var forceLogoutByNoActionDuration = $("#hidForceLogoutByNoActionDuration").val();
			if(forceLogoutByNoActionDuration != '' && forceLogoutByNoActionDuration > 0){
				$(document).idle({
					onIdle: function(){ location.href = "/logout"; },
				  	idle: 1000*forceLogoutByNoActionDuration
				});
			}
		});	
		</script>
		
		<input type="hidden" id="hidForceLogoutByNoActionDuration" value="${forceLogoutByNoActionDuration}" /> 

	</body>
</html>