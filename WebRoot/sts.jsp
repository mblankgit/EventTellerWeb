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
	<link rel="stylesheet" type="text/css" href="public/css/style.css">

  </head>
  
  <body>
    <jsp:include page="header.jsp"/>
    	
    <div class="mobile-warp" style="margin-top:-20px;">			
		<div class="mobile-body">
			<div class="mobile-inner">
				<div class="mobile_feature_01">
					<h4>实时页面爬取 <span class="i1"></span> 个</h4>
					<p>我们实现的网页爬虫一直<br>
	                在孜孜不倦地运转着</p>
				</div>
				<div class="mobile_feature_02">
					<h4>事件聚合 <span class="i2">2896594</span> 个</h4>
					<p>网页主体分析进程将相似<br>
	                新闻进行聚合整理</p>
				</div>
				<div class="mobile_feature_03">
					<h4>话题生成 <span class="i3">1222225</span> 个</h4>
					<p>新生事件是旧话题的延伸<br>
	                或者是新话题的开创</p>
				</div>
				<div class="mobile_feature_04">
					<div id="chart1" style="width:400px; height: 400px;float:left;">
						
					</div>
					<div style="float:left;">
						<h4 style="padding-left:140px;">来源多家知名新闻网站</h4>
						<p style="padding-left:145px;">我们的新闻来源于高权威<br>
		                高可信度的新闻网站</p>
	                </div>
				</div>
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
