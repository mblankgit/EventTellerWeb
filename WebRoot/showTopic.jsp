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
	<link rel="stylesheet" href="public/css/timeline-v.css" />
  </head>
  
  <body>
     <jsp:include page="header.jsp"/>
     
     <div class="container" id = "results">
		<div class="row">
			<h3 id="tp_title"><s:property value="title" /></h3>
			<ul class="nav nav-tabs">
				<li data-t="num2" class="active"><a href="javascript:;">时间线视图</a></li>
				<li data-t="num3"><a href="javascript:;">热度跟踪</a></li>
				<li data-t="num4"><a href="javascript:;">关键词云图</a></li>
			</ul>
		</div>
	
		<div class="row">
			<s:if test="events == null || events.length() == 0">
				<br />
				<div class="col-md-12">
					<div class="alert alert-danger"><strong>Sorry!</strong> No Results Found..</div>
				</div>
			</s:if>
			<s:else>
				<div class="col-md-12">
					<div class="pc" id="num1">
					<s:iterator value="events" id = "Event">
					<div class="n1item">
						<hr class="soften" />
		        		<h4>
							<a class="title" href="show_events?eid=<s:property value="#Event.id" />" target="_blank"><s:property value="#Event.title"/></a>
		        			<span class="lnumber label label-warning pull-right"><s:property value="#Event.number" /></span>
		        		</h4>
		        		<h5><small><s:date name="#Event.pubTime" format="yyyy-MM-dd hh:mm:ss" /></small></h5>
		        		<p><s:property value="#Event.content" /></p>
		        		<h6 style="display:none;"><s:property value="#Event.imgs" /></h6>
		        	</div>
					</s:iterator>
					</div>
					<div class="pc" id="num2">
						<div id="timeline" style="margin-top:20px;">
							
						</div>
					</div>
					<div class="pc" id="num3" style="position:relative;">
						<div id="timeNumberChart"></div>
						<div id="reporting" style="width:200px; height:100px; border:1px solid #000; position:absolute; left:0; top:0; display:none;"></div>
					</div>
					<div class="pc" id="num4">
						<div  class = "loadimg" style="display: none;">
							<img src="public/img/loading.gif" >
						</div>
						<div id="wordCloudChart" style="height:400px; margin-top:20px; border:1px solid #ccc; border-radius:5px; padding:10px; display:none"></div>
					</div>
				</div>
			</s:else>	
		</div>

		</div>
     
    <jsp:include page="footer.html"/>
     
  	<script src="public/js/jquery.js"></script>
    <script src="public/js/jquery-ui.js"></script>
   	<script src="public/js/bootstrap.min.js"></script>
   	<script src="public/js/timeline-v-min.js"></script>
	<script src="public/js/search.js"></script>
	<script src="public/js/awesomeCloud.min.js"></script>
	<script src="public/js/highcharts.js"></script>
	<script src="public/js/showTopic.js"></script>
  </body>
</html>
