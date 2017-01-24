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
<title>SABER-V</title> 
</head> 
<frameset rows="0,*" border="0" frameborder="no" framespacing="0"> 
	<frame name="header" scrolling="no" marginwidth="10" marginheight="0" namo_target_frame="main" src=""> 
	<frame name="main" scrolling="auto" marginwidth="0" marginheight="0" src="/home2"></frameset> 
</html> 
