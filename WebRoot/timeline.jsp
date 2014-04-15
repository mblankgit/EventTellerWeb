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
    <title>EventTeller - Timeline</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" href="public/css/bootstrap.min.css">
	<link rel="stylesheet" href="public/css/timeline.css">
	<link rel="stylesheet" href="public/css/jquery-ui.css" />
	<link rel="stylesheet" href="public/timeglider/css/jquery-ui-1.8.5.custom.css" type="text/css" media="screen" title="no title" charset="utf-8">
	
	<link rel="stylesheet" href="public/timeglider/timeglider/Timeglider.css" type="text/css" media="screen" title="no title" charset="utf-8">
	<style>
	.navbar-brand{
		padding: 0px;
		margin-top:13px;
		height: 0;
	}
	.navbar-form .form-control{
		padding:0 4px;
	}
	</style>
 </head>
  
  <body>
    
    
    <jsp:include page="header.jsp"/>
	<button class="btn btn-default" style="position:fixed; left:0px; top:100px;" id="linebtn">MAGIC</button>
     
	<div class="container">			
		<div class="row">
			<div id="placement" class="col-md-12" style="height:600px; margin-bottom:100px;"></div>
			<div id="my-timeline" class="col-md-12" style="min-height:600px;">
			</div>
		</div>
	</div>
  
    
    <jsp:include page="footer.html"/>
   
	<script src="public/js/jquery.js"></script>
    <script src="public/js/jquery-ui.js"></script>
   	<script src="public/js/bootstrap.min.js"></script>
   	<script src="public/js/timeline.min.js"></script>
   	<script src="public/js/timeline.js"></script>
   	
	<script src="public/timeglider/js/json2.js" type="text/javascript" charset="utf-8"></script>
	
	<script src="public/timeglider/js/underscore-min.js" type="text/javascript" charset="utf-8"></script>
	<script src="public/timeglider/js/backbone-min.js" type="text/javascript" charset="utf-8"></script>
	<script src="public/timeglider/js/jquery.tmpl.js" type="text/javascript" charset="utf-8"></script>
	<script src="public/timeglider/js/ba-debug.min.js" type="text/javascript" charset="utf-8"></script>
	<script src="public/timeglider/js/ba-tinyPubSub.js" type="text/javascript" charset="utf-8"></script>
	<script src="public/timeglider/js/jquery.mousewheel.js" type="text/javascript" charset="utf-8"></script>
	<script src="public/timeglider/js/jquery.ui.ipad.js" type="text/javascript" charset="utf-8"></script>
	<script src="public/timeglider/js/globalize.js" type="text/javascript" charset="utf-8"></script>	
		
	<script src="public/timeglider/timeglider/TG_Date.js" type="text/javascript" charset="utf-8"></script>
	<script src="public/timeglider/timeglider/TG_Org.js" type="text/javascript" charset="utf-8"></script>
	<script src="public/timeglider/timeglider/TG_Timeline.js" type="text/javascript" charset="utf-8"></script> 
	<script src="public/timeglider/timeglider/TG_TimelineView.js" type="text/javascript" charset="utf-8"></script>
	<script src="public/timeglider/timeglider/TG_Mediator.js" type="text/javascript" charset="utf-8"></script> 
	<script src="public/timeglider/timeglider/timeglider.timeline.widget.js" type="text/javascript"></script>
	
	<script src="public/timeglider/timeglider/timeglider.datepicker.js" type="text/javascript"></script>

	<!-- New, as of June 2012 -->
	<script src="public/timeglider/js/jquery.jscrollpane.min.js" type="text/javascript"></script>
	
	<script src="public/js/search.js"></script>
  </body>
</html>
