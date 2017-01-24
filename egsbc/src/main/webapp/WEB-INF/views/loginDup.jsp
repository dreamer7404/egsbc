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
		<link rel="stylesheet" type="text/css" media="screen" href="/resources/css/bootstrap.min.css">
		<link rel="stylesheet" type="text/css" media="screen" href="/resources/css/font-awesome.min.css">
		<link rel="stylesheet" type="text/css" media="screen" href="/resources/css/smartadmin-production-plugins.min.css">
		<link rel="stylesheet" type="text/css" media="screen" href="/resources/css/smartadmin-production.min.css">
		<style>
		html, body {
		    height: 100%;
		}
		#main {
		    height: 100%;
		    width: 100%;
		    display: table;
		}
		#content {
		    display: table-cell;
		    height: 100%;
		    vertical-align: middle;
		}
		</style>
	</head>
	<body >
		<div id="main"  style="border:0px solid green" >
			<div id="content" >
				<div class="row" style="border:0px solid blue">
				
					<div class="col-md-6" style="text-align:right;border:0px solid red">
						<img src="/resources/img/egis/login_egis.jpg">
					</div>
					<div class="col-md-6" style="border:0px solid red;padding-left:30px;margin-top:150px">
					
							<form action="loginProcess" id="login-form" method="post" class="smart-form client-form" >
							
								<div style="width:300px;border:0px solid blue;">
								
									<div style="padding:6px;border-bottom:1px solid #d1d1d1">
										<strong><h3>Login</h3></strong>
									</div>	
									
									<fieldset>
										<section>
											<label class="label">ID</label>
											<label class="input"> <i class="icon-append fa fa-user"></i>
												<input type="text" id="id" value="">
												<input type="hidden" name="id" id="hidId" >
												<b class="tooltip tooltip-top-right"><i class="fa fa-user txt-color-teal"></i> Input ID.</b></label>
										</section>
	
										<section>
											<label class="label">Password</label>
											<label class="input"> <i class="icon-append fa fa-lock"></i>
												<input type="password" name="pw" value="" id="pw">
												<b class="tooltip tooltip-top-right"><i class="fa fa-lock txt-color-teal"></i> Input Password.</b> </label>
										</section>
										
<!-- 										<section> -->
<!-- 											<label class="checkbox"  > -->
<!-- 												<input type="checkbox"  id="stayLoggedIn" ><i></i>Stay logged in -->
<!-- 											</label> -->
<!-- 										</section> -->
										
										<section>
											<label class="label" >
												<span style="color:#C02631">
													<i class="fa fa-exclamation-triangle" aria-hidden="true"></i>
													Duplicate Login
												</span>	
											</label>
										</section>
										
									</fieldset>
									
									<div style="padding:6px;border-top:1px solid #d1d1d1;text-align:right">
										<button type="button" class="btn btn-primary" id="btnLogin" style="width: 95px;height: 30px;">Login</button>
									</div>	
									
								</div>	
								<input type="hidden"  id="hidStayLoggedIn" name="stayLoggedIn" >
							</form>

					</div>

				</div>
			</div>

		</div>
		
		
		
		

		<!--================================================== -->	


	    <script src="/resources/js/libs/jquery-2.1.1.min.js"></script>
		<script src="/resources/js/libs/jquery-ui-1.10.3.min.js"></script>
		<!-- BOOTSTRAP JS -->		
		<script src="/resources/js/bootstrap/bootstrap.min.js"></script>

		<!-- JQUERY VALIDATE -->
		<script src="/resources/js/plugin/jquery-validate/jquery.validate.min.js"></script>
		
		<!-- JQUERY MASKED INPUT -->
		<script src="/resources/js/plugin/masked-input/jquery.maskedinput.min.js"></script>
		<script src="/resources/scripts/common/login.js"></script>

	</body>
</html>