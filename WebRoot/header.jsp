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
<<<<<<< HEAD
			        <li><a href="">Home</a></li>
			        <li><a href="events">Event</a></li>
			        <li><a href="topics">Topic</a></li>
			        <li><a href="timeline">Timeline</a></li>
			        <li><a href="sts">Sts</a></li>
			    </ul>
=======
			        <li>
			        	<a href="">
			        		首页
			        	</a>
			        </li>
			        <li>
			        	<a href="events">事件</a>
			        </li>
			        <li>
			        	<a href="topics">话题</a>
			        </li>
			        <li>
			        	<a href="sts">统计</a>
			        </li>
			        <li>
			        	<a href="timeline">
			        		时间线
			        	</a>
			        </li>
      			</ul>
>>>>>>> ef2033b23dfe6f909a728959b88a4581db66839e
      			
      			<form class="navbar-form navbar-right" method="post" role="search" action="search">
	        		<div class="form-group">
	          			<input type="text" class="form-control" placeholder="Search Events" name="EventQuery" id="EventQuery">
	        		</div>
	        		<button type="submit" class="btn btn-default " id="BTEventSearch">搜索</button>
      			</form>
		    </div>		    
		    
    	</div>
  	</nav>
