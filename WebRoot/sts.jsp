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
    <title>EventTeller Index</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="EventTeller Index">
	
	<link rel="stylesheet" type="text/css" href="public/css/bootstrap.min.css">

  </head>
  
  <body>
    <jsp:include page="header.jsp"/>
    	
    <div class="container">
		
		<div class="row">
			
			<div class="col-md-6">
				<div class="row" id = "chart1"></div>
			</div>
			
			<div class="col-md-6">
				<div class="row" id="chart2"></div>
			</div>
		
		</div>
			
   	</div>
   		
  	 <jsp:include page="footer.html"/>
    
    <script src="public/js/jquery.js"></script>
    <script src="public/js/jquery-ui.js"></script>
   	<script src="public/js/bootstrap.min.js"></script>	
    <script src="public/js/search.js"></script>
    <script src="public/js/highcharts.js"></script>
    <script src="public/js/sts.js"></script>
  </body>
</html>
