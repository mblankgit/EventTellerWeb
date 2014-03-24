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
  </head>
  
  <body>
     <jsp:include page="header.jsp"/>
     
     <div class="container" id = "results">
			<s:if test="events == null || events.length() == 0">
				<br />
				<div class="col-md-6">
					<div class="alert alert-danger"><strong>Sorry!</strong> No Results Found..</div>					
				</div>
			</s:if>
			<s:else>
				<div class="col-md-9">
					<s:iterator value="events" id = "Event">
						<hr class="soften" />
		        		<h4>
							<a href="show_events?eid=<s:property value="#Event.id" />" target="_blank"><s:property value="#Event.title"/></a>
		        			<span class="label label-warning pull-right"><s:property value="#Event.number" /></span>
		        		</h4>
		        		<h5><small><s:date name="#Event.pubtime" format="yyyy-MM-dd hh:mm:ss" /></small></h5>
		        		<p><s:property value="#Event.content" /></p>
					</s:iterator>
				</div>
			</s:else>	
		</div>
     
     <jsp:include page="footer.html"/>
     
  	<script src="public/js/jquery.js"></script>
    <script src="public/js/jquery-ui.js"></script>
   	<script src="public/js/bootstrap.min.js"></script>
	<script src="public/js/search.js"></script>
  </body>
</html>
