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
    <title>EventTeller - Event</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" href="public/css/bootstrap.min.css">
	<link rel="stylesheet" href="public/css/jquery-ui.css" />
 </head>
  
  <body>
    
    
      <jsp:include page="header.jsp"/>
    
	<div class="container">
	
    	<ul class="nav nav-tabs" id="myTab">
			<li class="active"><a href="">Main</a></li>
			<li><a href="">China</a></li>
			<li><a href="">World</a></li>
			<li><a href="">Society</a></li>
			<li><a href="">Military</a></li>
			<li><a href="">Health</a></li>
			<li><a href="">Sports</a></li>
			<li><a href="">Entertainment</a></li>
			<li><a href="">Finance</a></li>
			<li><a href="">Technology</a></li>
			<li><a href="">Education</a></li>
			<li><a href="">Law</a></li>
		</ul>
		
		<p></p>
		
		<div class="row">
				
			<div class="col-md-9" >
			
				<div  id = "loadimg" style="display: none;">
					<img src="public/img/loading.gif" >
				</div>
				
				<div class="container" id = "events"></div>
								
			</div>
		
			<div class="col-md-3">
					<div class="input-group ">
	      				<input type="text" class="form-control" id="event_date_text">
	      				<span class="input-group-btn">
	        				<button class="btn btn-default" type="button" id="bt_show_events">Go!</button>
	      				</span>
	    			</div>
			</div>
		
		</div>
		
	</div>
  
    
    <jsp:include page="footer.html"/>
   
	<script src="public/js/jquery.js"></script>
    <script src="public/js/jquery-ui.js"></script>
   	<script src="public/js/bootstrap.min.js"></script>
	<script src="public/js/events.js"></script>
	<script src="public/js/search.js"></script>
  </body>
</html>
