<%
response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
response.setDateHeader("Expires", -1);
%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page session="true" %>

<!DOCTYPE html>
<html>	
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

		<!-- DEV links : turn this on when you like to develop directly -->
		<!--<link rel="stylesheet" type="text/css" media="screen" href="../Source_UNMINIFIED_CSS/smartadmin-production.css">-->
		<!--<link rel="stylesheet" type="text/css" media="screen" href="../Source_UNMINIFIED_CSS/smartadmin-skins.css">-->

		<!-- SmartAdmin RTL Support -->
		<link rel="stylesheet" type="text/css" media="screen" href="/resources/css/smartadmin-rtl.min.css"> 

		<!-- We recommend you use "your_style.css" to override SmartAdmin
		     specific styles this will also ensure you retrain your customization with each SmartAdmin update.-->
		<link rel="stylesheet" type="text/css" media="screen" href="/resources/css/egis.css"> 

		<!-- Demo purpose only: goes with demo.js, you can delete this css when designing your own WebApp -->
		<link rel="stylesheet" type="text/css" media="screen" href="/resources/css/demo.min.css">
		
		<!-- Add CSS -->
		<!-- 포함하면 : 필터박스깨짐, 셀선택기능 됨, table scrollX:false 안먹음 -->
<!-- 		<link rel="stylesheet" type="text/css" media="screen" href="/resources/css/datatables/jquery.dataTables.min.css "> -->
		
		<link rel="stylesheet" type="text/css" media="screen" href="/resources/css/datatables/buttons.dataTables.min.css ">
 		<link rel="stylesheet" type="text/css" media="screen" href="/resources/css/datatables/dataTables.tableTools.css "> 
		
		<!-- DateRangePicker -->
		<link rel="stylesheet" type="text/css" media="screen" href="/resources/css/plugin/bootstrap-daterangepicker/daterangepicker.css">
		
		<!-- DateTimePicker -->
		<link rel="stylesheet" type="text/css" media="screen" href="/resources/css/plugin/bootstrap-datetimepicker/bootstrap-datetimepicker.min.css">

		<!-- #FAVICONS -->
		<link rel="shortcut icon" href="/resources/img/favicon/favicon.ico" type="image/x-icon">
		<link rel="icon" href="/resources/img/favicon/favicon.ico" type="image/x-icon">

		<!-- #GOOGLE FONT -->
<!-- 		<link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Open+Sans:400italic,700italic,300,400,700"> -->

		<!-- #APP SCREEN / ICONS -->
		<!-- Specifying a Webpage Icon for Web Clip 
			 Ref: https://developer.apple.com/library/ios/documentation/AppleApplications/Reference/SafariWebContent/ConfiguringWebApplications/ConfiguringWebApplications.html -->
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
		
		<script>
// 			$(function(){
// 				$('body').append( $('<div>').load("/resources/html/common.html"));
// 			});
			
		</script>
	</head>
	
	<c:if test="${sessionScope.prePage ne null && sessionScope.prePage != ''}">
		<c:redirect url="/lockPage" />
	</c:if>
	
	<body class="smart-style-1">

		<!-- #HEADER -->
		<header id="header" style="padding-top:0px;margin-top:0px">
			
			<div id="logo-group" style="border:0px solid #FFF;text-align:left;">
				<span id="logo"> <img src="/resources/img/egis/web-acasia-v.png" alt="SmartAdmin"> </span>
<!-- 					<h4 style="margin-top:13px"><strong><span style="color:#0669B3">EG</span><span style="color:#8686a6">SBC</span></strong></h4> -->
			</div>

			<!-- #TOGGLE LAYOUT BUTTONS -->
			<!-- pulled right: nav area -->
			<div class="pull-right">
			
				<!-- top menu test -->
<!-- 				<div class="btn-header transparent pull-right"> -->
<!-- 					<span> <a href="javascript:$('#smart-topmenu').click()" title="Collapse Menu"><i class="fa fa-arrows-v"></i></a> </span> -->
<!-- 				</div> -->
				
				<!-- collapse menu button -->
<!-- 				<div id="hide-menu" class="btn-header pull-right"> -->
<!-- 					<span> <a href="javascript:void(0);" data-action="toggleMenu" title="Collapse Menu"><i class="fa fa-reorder"></i></a> </span> -->
<!-- 				</div> -->
				<!-- end collapse menu -->
				

				<!-- logout button -->
<!-- 				<div id="logout" class="btn-header transparent pull-right"> -->
<!-- 					<span> <a href="login.html" title="Sign Out" data-action="userLogout" data-logout-msg="You can improve your security further after logging out by closing this opened browser"><i class="fa fa-sign-out"></i></a> </span> -->
<!-- 				</div> -->
				<!-- end logout button -->
				
				
				<!-- fullscreen button -->
<!-- 				<div id="fullscreen" class="btn-header transparent pull-right"> -->
<!-- 					<span> <a href="javascript:void(0);" data-action="launchFullscreen" title="Full Screen"><i class="fa fa-arrows-alt"></i></a> </span> -->
<!-- 				</div> -->
				<div id="fullscreen" class="btn-header transparent pull-right">
					<span> <a href="javascript:void(0);" onclick="Egis.toggleFullScreen()" title="Full Screen"><i class="fa fa-arrows-alt"></i></a> </span>
				</div>
				<!-- end fullscreen button -->

				<!-- Logout -->
				<div class="pull-right" style="margin-top:19px;margin-left:10px;margin-right:10px">
					<a href="/logout" style="color:#8B91A0" id="btnLogout" ><i class="fa fa-power-off "> </i>&nbsp; Logout </a>
				</div>
				
				<!-- User -->
				<div class="pull-right" style="margin-top:19px;margin-left:10px;margin-right:10px">
					<nav><a href="/resources/html/system/manager/manager.html"><span style="color:#8B91A0"> <i class="fa fa-user"></i>&nbsp; ${userVO.id}</span></a></nav>
				</div>
				
				<!-- Alarm Information-->
				<div class="pull-right" style="margin-top:19px;margin-left:10px;margin-right:10px">
					<nav><a href="/resources/html/report/history/alarmHistory.html?level=1"><span style="color:#EFEFEF">Information</span></a></nav>
				</div>
				<div class="pull-right" style="margin-top:19px;margin-left:10px;margin-right:10px">
						<i class="fa fa-lg fa-fw fa-bell-o colorGreen"><em class="badge badge-inverse alarm-event" id="alarmInformationCnt" style="font-weight:bold;color:#000">0</em ></i>
				</div>
				
				<!-- Alarm MINOR-->
				<div class="pull-right" style="margin-top:19px;margin-left:10px;margin-right:10px">
					<nav><a href="/resources/html/report/history/alarmHistory.html?level=2"><span style="color:#EFEFEF">Minor</span></a></nav>
				</div>
				<div class="pull-right" style="margin-top:19px;margin-left:10px;margin-right:10px">
						<i class="fa fa-lg fa-fw fa-bell-o colorYellow"><em class="badge badge-inverse alarm-minor" id="alarmMinorCnt" style="color:#000">0</em ></i>
				</div>
				
				<!-- Alarm MAJOR-->
				<div class="pull-right" style="margin-top:19px;margin-left:10px;margin-right:10px">
					<nav><a href="/resources/html/report/history/alarmHistory.html?level=3"><span style="color:#EFEFEF">Major</span></a></nav>
				</div>
				<div class="pull-right" style="margin-top:19px;margin-left:10px;margin-right:10px">
						<i class="fa fa-lg fa-fw fa-bell-o colorOrange"><em class="badge badge-inverse alarm-major" id="alarmMajorCnt" style="color:#000">0</em ></i>
				</div>
				
				<!-- Alarm CRITICAL-->
				<div class="pull-right" style="margin-top:19px;margin-left:10px;margin-right:10px">
					<nav><a href="/resources/html/report/history/alarmHistory.html?level=4"><span style="color:#EFEFEF">Critical</span></a></nav>
				</div>
				<div class="pull-right" style="margin-top:19px;margin-left:10px;margin-right:10px">
						<i class="fa fa-lg fa-fw fa-bell-o colorRed"><em class="badge badge-inverse alarm-critical" id="alarmCriticalCnt" style="color:#000">0</em ></i>
				</div>
				
				<!-- Server Time-->
				<div class="pull-right" style="margin-top:19px;margin-left:10px;margin-right:10px">
					<span style="color:#EFEFEF" id="systemDateTime"></span>
				</div>
				
				<div class="pull-right" style="margin-top:19px;margin-left:10px;margin-right:10px">
					<span style="color:#EFEFEF" id="msg"></span>
				</div>
				
<!-- 				<div class="pull-right" style="margin-top:19px;margin-left:10px;margin-right:10px"> -->
<!-- 					<button type="button" class="btn" id="btnTest">test</button> -->
<!-- 				</div> -->
				
				

				<!-- multiple lang dropdown : find all flags in the flags page -->
<!-- 				<ul class="header-dropdown-list hidden-xs"> -->
<!-- 					<li> -->
<!-- 						<a href="#" class="dropdown-toggle" data-toggle="dropdown"> <img src="/resources/img/blank.gif" class="flag flag-us" alt="United States"> <span> US</span> <i class="fa fa-angle-down"></i> </a> -->
<!-- 						<ul class="dropdown-menu pull-right"> -->
<!-- 							<li class=""> -->
<!-- 								<a href="javascript:void(0);"><img src="/resources/img/blank.gif" class="flag flag-us" alt="United States"> English (US)</a> -->
<!-- 							</li> -->
<!-- 							<li> -->
<!-- 								<a href="javascript:void(0);"><img src="/resources/img/blank.gif" class="flag flag-fr" alt="France"> FranÃ§ais</a> -->
<!-- 							</li> -->
<!-- 							<li> -->
<!-- 								<a href="javascript:void(0);"><img src="/resources/img/blank.gif" class="flag flag-es" alt="Spanish"> EspaÃ±ol</a> -->
<!-- 							</li> -->
<!-- 							<li> -->
<!-- 								<a href="javascript:void(0);"><img src="/resources/img/blank.gif" class="flag flag-de" alt="German"> Deutsch</a> -->
<!-- 							</li> -->
<!-- 							<li> -->
<!-- 								<a href="javascript:void(0);"><img src="/resources/img/blank.gif" class="flag flag-jp" alt="Japan"> æ¥æ¬èª</a> -->
<!-- 							</li> -->
<!-- 							<li> -->
<!-- 								<a href="javascript:void(0);"><img src="/resources/img/blank.gif" class="flag flag-cn" alt="China"> ä¸­æ</a> -->
<!-- 							</li>	 -->
<!-- 							<li> -->
<!-- 								<a href="javascript:void(0);"><img src="/resources/img/blank.gif" class="flag flag-it" alt="Italy"> Italiano</a> -->
<!-- 							</li>	 -->
<!-- 							<li> -->
<!-- 								<a href="javascript:void(0);"><img src="/resources/img/blank.gif" class="flag flag-pt" alt="Portugal"> Portugal</a> -->
<!-- 							</li> -->
<!-- 							<li> -->
<!-- 								<a href="javascript:void(0);"><img src="/resources/img/blank.gif" class="flag flag-ru" alt="Russia"> Ð ÑÑÑÐºÐ¸Ð¹ ÑÐ·ÑÐº</a> -->
<!-- 							</li> -->
<!-- 							<li> -->
<!-- 								<a href="javascript:void(0);"><img src="/resources/img/blank.gif" class="flag flag-kr" alt="Korea"> íêµ­ì´</a> -->
<!-- 							</li>						 -->
							
<!-- 						</ul> -->
<!-- 					</li> -->
<!-- 				</ul> -->
				<!-- end multiple lang -->

			</div>
			<!-- end pulled right: nav area -->

		</header>
		<!-- END HEADER -->

		<!-- #NAVIGATION -->
		<aside id="left-panel">
			<!-- User info -->
<!-- 			<div class="login-info"> -->
<!-- 				<span> User image size is adjusted inside CSS, it should stay as is  -->
					
<!-- 					<a href="javascript:void(0);" id="show-shortcut" data-action="toggleShortcut"> -->
<!-- 						<img src="/resources/img/avatars/sunny.png" alt="me" class="online" />  -->
<!-- 						<span> -->
<!-- 							john.doe  -->
<!-- 						</span> -->
<!-- 						<i class="fa fa-angle-down"></i> -->
<!-- 					</a>  -->
					
<!-- 				</span> -->
<!-- 			</div> -->
			<!-- end user info -->

			<nav>

				<ul>
					<li>
						<a href="/resources/html/dashboard/dashboard.html" title="DASHBOARD"><i class="fa fa-lg fa-fw fa-home"></i> <span class="menu-item-parent">DASHBOARD</span></a>
					</li>
					<li>
						<a href="#" title="Real-time Status"><i class="fa fa-lg fa-fw fa-search"></i> <span class="menu-item-parent">REAL-TIME STATUS</span></a>
						<ul>
							<li>
								<a href="/resources/html/overview/currentCall.html" title="Current Call">Current Call</a>
							</li>
							<li>
								<a href="/resources/html/overview/currentSubscriber.html" title="Current Call">Current Subscriber</a>
							</li>
							<li>
								<a href="/resources/html/overview/currentNatEntry.html" title="Current Nat Entry">Current Nat Entry</a>
							</li>
						</ul>	
					</li>
					<li>
						<a href="#" title="CONFIGURATION"><i class="fa fa-lg fa-fw fa-cog"></i> <span class="menu-item-parent">CONFIGURATION</span></a>
						<ul>
							<li>
								<a href="/resources/html/configuration/interface.html" title="Network Interface">Network Interface</a>
							</li>
							<li>
								<a href="/resources/html/configuration/transport.html" title="Transport">Transport</a>
							</li>
							<li>
								<a href="/resources/html/configuration/voIP/easy.html" title="SIP Profiles">SIP Profiles</a>
							</li>
<!-- 							<li> -->
<!-- 								<a href="#">VoIP</a> -->
<!-- 								<ul> -->
<!-- 									<li> -->
<!-- 										<a href="/resources/html/configuration/voIP/easy.html" title="Easy">Easy</a> -->
<!-- 									</li> -->
<!-- 									<li> -->
<!-- 										<a href="/resources/html/configuration/voIP/routing.html" title="Routing" id="menuRouting">Routing</a> -->
<!-- 									</li> -->
<!-- 									<li> -->
<!-- 										<a href="/resources/html/configuration/voIP/signallingServerRealm.html" title="Signalling Server Realm">Signalling Server Realm</a> -->
<!-- 									</li> -->
<!-- 									<li> -->
<!-- 										<a href="/resources/html/configuration/voIP/signallingTrunking.html" title="Signalling Trunking">Signalling Trunking</a> -->
<!-- 									</li> -->
<!-- 								</ul> -->
<!-- 							</li> -->
							<li>
								<a href="/resources/html/configuration/natService.html" title="NAT Profiles">NAT Profiles</a>
							</li>
							<li>
								<a href="/resources/html/configuration/staticACL.html" title="NAT Service">Static ACL</a>
							</li>
							<li>
								<a href="/resources/html/configuration/certification.html" title="Certificates">Certificates</a>
							</li>
<!-- 							<li> -->
<!-- 								<a href="/resources/html/configuration/advancedSip.html" title="Advanced SIP">Advanced SIP</a> -->
<!-- 							</li> -->
							<li>
<!-- 								<a href="#">Detailed SIP settings</a> -->
<!-- 								<ul> -->
<!-- 									<li> -->
<!-- 										<a href="/resources/html/configuration/voIP/signallingTrunking.html" title="Trunking">Trunking</a> -->
<!-- 									</li> -->
<!-- 									<li> -->
<!-- 										<a href="/resources/html/configuration/voIP/signallingServerRealm.html" title="Server/Realm">Server/Realm</a> -->
<!-- 									</li> -->
<!-- 									<li> -->
<!-- 										<a href="/resources/html/configuration/voIP/routing.html" title="Routing" id="menuRouting">Routing</a> -->
<!-- 									</li> -->
<!-- 									<li> -->
<!-- 										<a href="/resources/html/configuration/advancedSip.html" title="Advanced SIP">Advanced SIP</a> -->
<!-- 									</li> -->
<!-- 								</ul> -->
							</li>		

						</ul>	
					</li>
					<c:if test="${userVO.level eq 1}">
					<li>
						<a href="#" title="SYSTEM"><i class="fa fa-lg fa-fw fa-tasks"></i> <span class="menu-item-parent">SYSTEM</span></a>
						<ul>
							<li>
								<a href="#">Core Set</a>
								<ul>
<!-- 									<li> -->
<!-- 										<a href="#" title="License">License</a> -->
<!-- 									</li> -->
									<li>
										<a href="/resources/html/system/coreSet/dateNtp.html" title="Date/NTP" >Date/NTP</a>
									</li>
									<li>
										<a href="/resources/html/system/alarmCode.html" title="Alarm Code">Alarm Code</a>
									</li>
									<li>
										<a href="/resources/html/system/coreSet/email.html" title="E-mail">E-mail</a>
									</li>
<!-- 									<li class=""> -->
<!-- 										<a href="/resources/html/system/resourceMonitoring.html" title="Resource">Resource</a> -->
<!-- 									</li> -->
								</ul>
							</li>
							<li class="">
								<a href="/resources/html/system/control.html" title="System Control">System Control</a>
							</li>
							<li>
								<a href="#">Manager</a>
								<ul>
									<li>
										<a href="/resources/html/system/manager/manager.html" title="Manager List">Manager List</a>
									</li>
									<li>
										<a href="/resources/html/system/manager/configure.html" title="Configure">Configure</a>
									</li>
									<li>
										<a href="/resources/html/system/manager/acl.html" title="IP ACL List">IP ACL List</a>
									</li>
									<li>
										<a href="/resources/html/system/manager/commandLevel.html" title="Command Level List">Command Level List</a>
									</li>
								</ul>
							</li>
							<li>
								<a href="#">DB & File</a>
								<ul>
									<li>
										<a href="/resources/html/package/packageMgmt.html" title="Package">Package</a>
									</li>
									<li>
										<a href="/resources/html/system/dbBackupRestore.html" title="DB Backup/Restore">DB Backup/Restore</a>
									</li>
									<li>
										<a href="/resources/html/system/dataManage/policy.html" title="Policy">Policy</a>
									</li>
								</ul>
							</li>
							<li>
								<a href="#">Debugging Tool</a>
								<ul>
<!-- 									<li class=""> -->
<!-- 										<a href="/resources/html/system/trace.html" title="Trace" id="menuTrace">Trace</a> -->
<!-- 									</li> -->
									<li class="">
										<a href="/resources/html/system/tcpDump.html" title="TcpDump">TcpDump</a>
									</li>
									<li class="">
										<a href="/resources/html/system/ping.html" title="Ping">Ping</a>
									</li>
								</ul>
							</li>
<!-- 							<li> -->
<!-- 								<a href="#">Advanced Set</a> -->
<!-- 								<ul> -->
<!-- 									<li> -->
<!-- 										<a href="/resources/html/system/advancedSet/liveChart.html" title="Live Chart" >Live Chart</a> -->
<!-- 									</li> -->
<!-- 								</ul> -->
<!-- 							</li> -->
						</ul>
							
					</li>
					<li>
						<a href="#" title="SYSTEM"><i class="fa fa-lg fa-fw fa-lock"></i> <span class="menu-item-parent">SECURITY</span></a>
						<ul>
							<li class="">
								<a href="/resources/html/security/rateLimit.html" title="Rate Limit">Rate Limit</a>
							</li>
							<li class="">
								<a href="/resources/html/security/call.html" title="Call">Call</a>
							</li>
							<li class="">
								<a href="/resources/html/security/spam.html" title="SPAM">SPAM</a>
							</li>
						</ul>
					</li>	
					</c:if>	
					<li>
						<a href="#"><i class="fa fa-lg fa-fw fa-file-text-o"></i> <span class="menu-item-parent">REPORT</span></a>
						<ul>
							<li class="">
								<a href="/resources/html/report/statistics.html" title="Statistics">Statistics</a>
							</li>
							<li>
								<a href="#">History</a>
								<ul>
									<li>
										<a href="/resources/html/report/history/alarmHistory.html" title="Alarm">Alarm</a>
									</li>
									<li>
										<a href="/resources/html/report/history/natHistory.html" title="NAT" >NAT</a>
									</li>
									<li class="">
										<a href="/resources/html/statistics/call.html" title="Call">Call</a>
									</li>
									<li class="">
										<a href="/resources/html/statistics/subscriber.html" title="Subscriber">Subscriber</a>
									</li>
									<li class="">
										<a href="/resources/html/report/history/commandHistory.html" title="Command History">Command History</a>
									</li>
									<li class="">
										<a href="/resources/html/report/history/dbBackup.html" title="DB Backup">DB Backup</a>
									</li>
									<li class="">
										<a href="/resources/html/report/history/logBackup.html" title="Log Backup">Log Backup</a>
									</li>
									<li class="">
										<a href="/resources/html/report/history/checkValidity.html" title="Check Validify">Check Validify</a>
									</li>
								</ul>
							</li>
						</ul>	
					</li>
					
				</ul>
			</nav>
			
			<span class="minifyme" data-action="minifyMenu"> <i class="fa fa-arrow-circle-left hit"></i> </span>
			

		</aside>
		<!-- END NAVIGATION -->
		
		<!-- #MAIN PANEL -->
		<div id="main" role="main"  style="border:0px solid red;padding-bottom:0px">

			<!-- RIBBON -->
			<div id="ribbon" style="height:30px">

				<span class="ribbon-button-alignment"> 
<!-- 					<span id="refresh" class="btn btn-ribbon" data-action="resetWidgets" data-title="refresh" rel="tooltip" data-placement="bottom" ><i class="fa fa-refresh"></i></span>  -->
<!-- 					<i class="fa fa-chevron-right"></i>&nbsp; -->
				</span>

				<!-- breadcrumb -->
				<ol class="breadcrumb">
					<!-- This is auto generated -->
				</ol>
				<!-- end breadcrumb -->

				<!-- You can also add more buttons to the
				ribbon for further usability

				Example below:

				<span class="ribbon-button-alignment pull-right" style="margin-right:25px">
					<a href="#" id="search" class="btn btn-ribbon hidden-xs" data-title="search"><i class="fa fa-grid"></i> Change Grid</a>
					<span id="add" class="btn btn-ribbon hidden-xs" data-title="add"><i class="fa fa-plus"></i> Add</span>
					<button id="search" class="btn btn-ribbon" data-title="search"><i class="fa fa-search"></i> <span class="hidden-mobile">Search</span></button>
				</span> -->

			</div>
			<!-- END RIBBON -->

			<!-- #MAIN CONTENT -->
			<div id="content" style="border:0px solid green">
					
			</div>
			
			<!-- END #MAIN CONTENT -->
			
			<input type="hidden" id="hidRoutingServiceName" /> 
			<input type="hidden" id="hidId" value="${userVO.id}" /> 
			<input type="hidden" id="hidLevel" value="${userVO.level}" /> 
			<input type="hidden" id="hidSleepModeByNoActionDuration" value="${sleepModeByNoActionDuration}" /> 
			<input type="hidden" id="hidForceLogoutByNoActionDuration" value="${forceLogoutByNoActionDuration}" /> 
			

		</div>
		<!-- END #MAIN PANEL -->

		<!-- #PAGE FOOTER -->
		<div id="divFooter" class="page-footer" style="border:0px solid red">
			<div class="row">
				<div class="col-xs-12 col-sm-6">
					<span class="txt-color-blackLight"> 
<!-- 						SABER-V  WEB 1.0.0 -->
<!-- 						<span class="hidden-xs"> - Web Configuration Application</span> -->
					</span>
				</div>

				<div class="col-xs-6 col-sm-6 text-right hidden-xs">
					<div class="txt-color-white inline-block">
<!-- 						<i class="hidden-mobile" style="color:#8686a6;font-size:16px"><strong><span style="color:#0669B3">EGIS</span>TECH &nbsp;</strong> </i> -->
 						<img src="/resources/img/egis/egis_logo.png"  height="12">

<!--						<div class="btn-group dropup"> -->
<!-- 							<button class="btn btn-xs dropdown-toggle bg-color-blue txt-color-white" data-toggle="dropdown"> -->
<!-- 								<i class="fa fa-link"></i> <span class="caret"></span> -->
<!-- 							</button> -->
<!-- 							<ul class="dropdown-menu pull-right text-left"> -->
<!-- 								<li> -->
<!-- 									<div class="padding-5"> -->
<!-- 										<p class="txt-color-darken font-sm no-margin">Download Progress</p> -->
<!-- 										<div class="progress progress-micro no-margin"> -->
<!-- 											<div class="progress-bar progress-bar-success" style="width: 50%;"></div> -->
<!-- 										</div> -->
<!-- 									</div> -->
<!-- 								</li> -->
<!-- 								<li class="divider"></li> -->
<!-- 								<li> -->
<!-- 									<div class="padding-5"> -->
<!-- 										<p class="txt-color-darken font-sm no-margin">Server Load</p> -->
<!-- 										<div class="progress progress-micro no-margin"> -->
<!-- 											<div class="progress-bar progress-bar-success" style="width: 20%;"></div> -->
<!-- 										</div> -->
<!-- 									</div> -->
<!-- 								</li> -->
<!-- 								<li class="divider"></li> -->
<!-- 								<li > -->
<!-- 									<div class="padding-5"> -->
<!-- 										<p class="txt-color-darken font-sm no-margin">Memory Load <span class="text-danger">*critical*</span></p> -->
<!-- 										<div class="progress progress-micro no-margin"> -->
<!-- 											<div class="progress-bar progress-bar-danger" style="width: 70%;"></div> -->
<!-- 										</div> -->
<!-- 									</div> -->
<!-- 								</li> -->
<!-- 								<li class="divider"></li> -->
<!-- 								<li> -->
<!-- 									<div class="padding-5"> -->
<!-- 										<button class="btn btn-block btn-default">refresh</button> -->
<!-- 									</div> -->
<!-- 								</li> -->
<!-- 							</ul> -->
<!-- 						</div> -->
						<!-- end btn-group-->
					</div>
					<!-- end div-->
				</div>
				<!-- end col -->
			</div>
			<!-- end row -->
		</div>
		<!-- END FOOTER -->
		
		

		<!-- #SHORTCUT AREA : With large tiles (activated via clicking user name tag)
			 Note: These tiles are completely responsive, you can add as many as you like -->
		<div id="shortcut">
			<ul>
				<li>
					<a href="#ajax/inbox.html" class="jarvismetro-tile big-cubes bg-color-blue"> <span class="iconbox"> <i class="fa fa-envelope fa-4x"></i> <span>Mail <span class="label pull-right bg-color-darken">14</span></span> </span> </a>
				</li>
				<li>
					<a href="#ajax/calendar.html" class="jarvismetro-tile big-cubes bg-color-orangeDark"> <span class="iconbox"> <i class="fa fa-calendar fa-4x"></i> <span>Calendar</span> </span> </a>
				</li>
				<li>
					<a href="#ajax/gmap-xml.html" class="jarvismetro-tile big-cubes bg-color-purple"> <span class="iconbox"> <i class="fa fa-map-marker fa-4x"></i> <span>Maps</span> </span> </a>
				</li>
				<li>
					<a href="#ajax/invoice.html" class="jarvismetro-tile big-cubes bg-color-blueDark"> <span class="iconbox"> <i class="fa fa-book fa-4x"></i> <span>Invoice <span class="label pull-right bg-color-darken">99</span></span> </span> </a>
				</li>
				<li>
					<a href="#ajax/gallery.html" class="jarvismetro-tile big-cubes bg-color-greenLight"> <span class="iconbox"> <i class="fa fa-picture-o fa-4x"></i> <span>Gallery </span> </span> </a>
				</li>
				<li>
					<a href="#ajax/profile.html" class="jarvismetro-tile big-cubes selected bg-color-pinkDark"> <span class="iconbox"> <i class="fa fa-user fa-4x"></i> <span>My Profile </span> </span> </a>
				</li>
			</ul>
		</div>
		<!-- END SHORTCUT AREA -->
		

		<!--================================================== -->

		<!-- PACE LOADER - turn this on if you want ajax loading to show (caution: uses lots of memory on iDevices)
		<script data-pace-options='{ "restartOnRequestAfter": true }' src="/resources/js/plugin/pace/pace.min.js"></script>-->


		<!-- #PLUGINS -->
<!-- 		<script src="//ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script> -->
<!-- 		<script src="//ajax.googleapis.com/ajax/libs/jqueryui/1.10.3/jquery-ui.min.js"></script> -->
		<script src="/resources/js/libs/jquery-2.1.1.min.js"></script>
		<script src="/resources/js/libs/jquery-ui-1.10.3.min.js"></script>

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

		<!-- JQUERY VALIDATE -->
		<script src="/resources/js/plugin/jquery-validate/jquery.validate.min.js"></script>
		<script src="/resources/js/plugin/jquery-validate/additional-methods.min.js"></script>

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

		<!-- Demo purpose only , ahnks : Layout Options -->
 		<script src="/resources/js/demo.min.js"></script> 

		<!-- MAIN APP JS FILE -->
		<script src="/resources/js/app.min.js"></script>

		<!-- ENHANCEMENT PLUGINS : NOT A REQUIREMENT -->
		<!-- Voice command : plugin -->
		<script src="/resources/js/speech/voicecommand.min.js"></script>

		<!-- Add JS -->
		<script src="/resources/js/plugin/jquery-form/jquery-form.min.js"></script> <!-- jquery form -->
		
		<script src="/resources/js/plugin/bootbox/bootbox.min.js"></script> <!-- bootbox -->
		<script src="/resources/js/plugin/idle/jquery.idle.min.js"></script> <!-- jquery idle -->
		<script src="/resources/js/plugin/datatables/dataTables.buttons.min.js"></script>
	
		<script src="/resources/js/plugin/datatables/jquery.dataTables.min.js"></script>
		
		<script src="/resources/js/plugin/datatables/dataTables.colVis.min.js"></script>
		<script src="/resources/js/plugin/datatables/dataTables.tableTools.min.js"></script>
		<script src="/resources/js/plugin/datatables/dataTables.bootstrap.min.js"></script>
		<script src="/resources/js/plugin/datatable-responsive/datatables.responsive.min.js"></script>
		
		<script src="/resources/js/plugin/datatables/fnReloadAjax.js"></script>
		<script src="/resources/js/plugin/datatables/dataTables.rowsGroup.js"></script>
		
		<!-- daterangepicker -->
		<script src="/resources/js/plugin/bootstrap-daterangepicker/moment.min.js"></script>
		<script src="/resources/js/plugin/bootstrap-daterangepicker/daterangepicker.js"></script>
		
		<!-- datetimepicker -->
		<script src="/resources/js/plugin/bootstrap-datetimepicker/bootstrap-datetimepicker.min.js"></script>
		
		<!-- sockjs -->
		<script src="/resources/js/plugin/sockjs/sockjs-0.3.4.min.js"></script>
		<script src="/resources/js/plugin/sockjs/stomp.js"></script>
		
		<!-- EGIS Global -->
		<script src="/resources/scripts/common/egis.js"></script>
		<script src="/resources/scripts/common/formHelper.js"></script>
	
		
	</body>

</html>
