<%@ page language="java" import="java.util.*" pageEncoding="utf-8" contentType="text/html; charset=utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

      	<nav class="navbar navbar-default" role="navigation">
  		<div class="container">
		    <div class="navbar-header">
		    	<a class="navbar-brand" href="#">EventTeller</a>
		    </div>
		    
		    <div class="collapse navbar-collapse">
		    	 <ul class="nav navbar-nav"  id="navbar_header">
			        <li><a href="">Home</a></li>
			        <li><a href="events">Event</a></li>
			        <li><a href="topics">Topic</a></li>
			        <li><a href="sts">Sts</a></li>
      			</ul>
      			
      			<form class="navbar-form navbar-right" method="post" role="search" action="search">
	        		<div class="form-group">
	          			<input type="text" class="form-control" placeholder="Search Events" name="EventQuery" id="EventQuery">
	        		</div>
	        		<button type="submit" class="btn btn-default " id="BTEventSearch">Search</button>
      			</form>
		    </div>		    
		    
    	</div>
  	</nav>
