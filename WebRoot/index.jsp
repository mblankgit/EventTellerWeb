<%@ page language="java" import="java.util.*" pageEncoding="utf-8" contentType="text/html; charset=utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>EventTeller - Home</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" href="public/css/bootstrap.min.css">
	<link rel="stylesheet" href="public/css/style.css">
  </head>
  
  <body>
    <!--[if lte IE 8]>
	<SCRIPT LANGUAGE="Javascript">
	alert("您的浏览器过时了，请更换现代浏览器使用本系统，推荐使用Chrome浏览器！");
	</SCRIPT>
	<h1 style="text-align:center; margin-bottom:100px">您的浏览器过时了，请更换现代浏览器使用本系统，推荐使用Chrome浏览器！</h1>
	<![endif]-->

    <jsp:include page="header.jsp"/>
	
	<div class="wrap-all" style="margin-top:-20px">
		<div class="inner">
			<div id="index-wrap">
				<div class="index-banner">
					<div class="index-banner-wrap">
						<div class="index-banner-inner">
							<h1>EventTeller</h1>
							<p style="margin-bottom:30px">EventTeller is a project which aims to detect Chinese News Event and Topic Tracking.</p>
							<div class="index-banner-action">
								<a class="btn btn-lg btn-success" href="https://github.com/mblankgit/EventTeller" target ="_blank" role="button">View on GitHub</a>
							</div>
							<div class="index-banner-carousel">
								<img id="cap" src="public/img/cap0.png" alt="">
							</div>
						</div>
					</div>
				</div>
				<div class="index-body">
					<h3 class="index-feature-title">
						<span>系统特色</span>
					</h3>
					<ul class="index-feature">
						<li>
							<i class="i1 glyphicon glyphicon-briefcase"></i>
							<br>
							<h4>事件聚类</h4>
							还在为肆意转发的“假”新闻头疼吗<br >我们给您提供最纯正的新闻事件
						</li>
						<li>
							<i class="i2 glyphicon glyphicon-facetime-video"></i>
							<br>
							<h4>话题追踪</h4>
							想知道某个热门话题的事件走向<br >我们帮您追踪其热度浮沉
						</li>
						<li>
							<i class="i3 glyphicon glyphicon-camera"></i>
							<br>
							<h4>历史回顾</h4>
							突然想回顾过去一年的热门事件<br >
							热门事件盘点给您想要的2013
						</li>
						<li>
							<i class="i4 glyphicon glyphicon-search"></i>
							<br>
							<h4>精确定位</h4>
							互联网搜索出的结果太繁杂了<br >
							我们只做新闻，每个新闻源都有迹可循
						</li>
					</ul>
					<div class="index-say" style="padding:40px;">
						<div class="index-say-inner">
							<h3 class="index-say-title">热门事件</h3>
							<div class="row">
								<ul class="wordcd list-group col-md-3">
								</ul>
								<div id="wordcloud2" class="col-md-9" style="height:288px; background:white; border:1px solid #ccc; border-radius:4px;">
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
    
    <jsp:include page="footer.html"/>
    
    <script src="public/js/jquery.js"></script>
    <script src="public/js/jquery-ui.js"></script>
    <script src="public/js/awesomeCloud.min.js"></script>
   	<script src="public/js/bootstrap.min.js"></script>
   	<script src="public/js/index.js"></script>
   	<script src="public/js/search.js"></script> 
  </body>
</html>
