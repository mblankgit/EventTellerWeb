<%@ page language="java" import="java.util.*" pageEncoding="utf-8" contentType="text/html; charset=utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>EventTeller - Show Topic</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" href="public/css/bootstrap.min.css">
	<link rel="stylesheet" href="public/css/jquery-ui.css" />
	<link rel="stylesheet" href="public/css/style.css" />
	<style>
	body{background-color: #000;}
	#chart{position: absolute;}
	</style>
  </head>
  
  <body>
    <jsp:include page="header.jsp"/>
    
    <div id='body' style="position: realtive;">
    	<div id="chart"></div>
    </div>
  	
  	<script src="public/js/jquery.js"></script>
    <script src="public/js/jquery-ui.js"></script>
   	<script src="public/js/bootstrap.min.js"></script>
   	<script src="public/js/d3.min.js"></script>
	<script src="public/js/stsline.js"></script>
  </body>
</html>
