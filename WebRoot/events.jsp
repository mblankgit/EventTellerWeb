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
	<link rel="stylesheet" href="public/css/style.css" />
 </head>
  
  <body>
    
    
      <jsp:include page="header.jsp"/>
    
	<div class="container">
	
    	<ul class="nav nav-tabs" id="myTab">
			<li class="active"><a href="">热门</a></li>
			<li><a href="">国内</a></li>
			<li><a href="">国外</a></li>
			<li><a href="">社会</a></li>
			<li><a href="">军事</a></li>
			<li><a href="">健康</a></li>
			<li><a href="">体育</a></li>
			<li><a href="">娱乐</a></li>
			<li><a href="">财经</a></li>
			<li><a href="">科技</a></li>
			<li><a href="">教育</a></li>
			<li><a href="">法律</a></li>
			<li id="newcomment"><a href="javascript:;">热议新闻</a></li>
			<li id="newweibo"><a href="javascript:;">热门微博</a></li>
		</ul>
		
		<p></p>
		
		<div class="row">
				
			<div class="col-md-9" style="min-height:600px;">
			
				<div id="loadimg" style="display: none; text-align:center;">
					<img src="public/img/loading.gif" >
				</div>
				
				<div class="container" id = "events"></div>
								
			</div>
		
			<div class="col-md-3">
					<h4 class="timedate" style="color:#999"></h4>
					<div class="input-group ">
	      				<input type="text" class="form-control" id="event_date_text">
	      				<span class="input-group-btn">
	        				<button class="btn btn-default" type="button" id="bt_show_events">Go!</button>
	      				</span>
	    			</div>

	    			<div id="commentbox" style="margin-top:10px;">
	    				

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
