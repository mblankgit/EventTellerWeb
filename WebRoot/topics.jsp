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
    
    <title>EventTeller - Topics</title>
    
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
     	<div class="row">
     		<div class="col-md-12" >
     			<div  id = "loadimg" style="text-align:center; display: none;">
					<img src="public/img/loading.gif" >
				</div>
				<br>
				<div id = "topics" style="min-height:400px;"></div>
				
				<ul class="pager">
				  <li class="previous" id="pretopic"><a href="">Previous</a></li>
				  <li id="topic_page_number">1</li>
				  <li class="next" id="nexttopic"><a href="">Next</a></li>
				</ul>
     		</div>
     		
     	</div>
     
     
     </div>
     
    <jsp:include page="footer.html"/>
   
	<script src="public/js/jquery.js"></script>
    <script src="public/js/jquery-ui.js"></script>
   	<script src="public/js/bootstrap.min.js"></script>
	<script src="public/js/search.js"></script>
	<script src="public/js/topics.js"></script>
  </body>
</html>
