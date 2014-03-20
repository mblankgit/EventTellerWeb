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
  </head>
  
  <body>
    
	<jsp:include page="header.jsp"/>
    
          
    <div class="container">
	    
	    <div class="jumbotron">
	    	<h1>Welcome!</h1>
	    	<p>EventTeller is a project which aims to detect Chinese News Event and Topic Tracking.</p>
	    	<p></p>
	    	<p><a class="btn btn-lg btn-success" href="https://github.com/mblankgit/EventTeller" target ="_blank" role="button">View On GitHub</a></p>
	    </div>
	    
	    <div class="container">
	    	<h1></h1>
	    </div>
	    
    
    </div>
    
    
    <jsp:include page="footer.html"/>
    
    <script src="public/js/jquery.js"></script>
    <script src="public/js/jquery-ui.js"></script>
   	<script src="public/js/bootstrap.min.js"></script>	
   	<script src="public/js/search.js"></script> 
  </body>
</html>
