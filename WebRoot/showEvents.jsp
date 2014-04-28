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
    	
    	<div class="content-panel blog-panel" style="margin-top:-20px; padding-bottom: 40px;">
			<div class="container content-container">			

	
			<div class="content col-md-12">
				<div class="content-wrapper">
				<div class="article">
					<h3 class="article-title" align="center">
						<s:property value="curet.title" />
					</h3>
					<div class="article-meta">
						<span class="glyphicon glyphicon-dashboard"> </span>
						<span class="published"><s:date name="curet.pubTime" format="yyyy-MM-dd hh:mm:ss"/>
						</span>
						<span class="pull-right badge"><s:property value="curet.number" /></span> 					
					</div>

					<p></p>
					
					<div class="article-summary article-markdown">
						<div class = "text-center">
							<s:iterator value="imgs" >
								<img src = <s:property /> class="img-rounded"></img> 
								<p></p>
							</s:iterator>
						</div>
							
						<s:iterator value="pas">
							<p><s:property /></p>
						</s:iterator>
					</div>
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
  </body>
</html>
