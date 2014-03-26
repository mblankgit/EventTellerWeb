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
 </head>
  
  <body>
    
    
    <jsp:include page="header.jsp"/>

	<div class="container">			
		<div class="row">
			<div id="my-timeline" class="col-md-12" style="min-height:800px">
				

			</div>
		</div>
	</div>
  
    
    <jsp:include page="footer.html"/>
   
	<script src="public/js/jquery.js"></script>
    <script src="public/js/jquery-ui.js"></script>
   	<script src="public/js/bootstrap.min.js"></script>
   	<script src="public/js/timeline.min.js"></script>
   	<script src="public/js/timeline.js"></script>
	<script src="public/js/search.js"></script>
  </body>
</html>
