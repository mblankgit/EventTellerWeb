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
			       	<li>
			        	<a href="word">
			        		词语
			        	</a>
			        </li>
      			</ul>
      			
      			<form class="navbar-form navbar-right" method="post" role="search" action="search">
	        		<div class="form-group">
	          			<input type="text" class="form-control" placeholder="Search Events" name="EventQuery" id="EventQuery">
	        		</div>
	        		<button type="submit" class="btn btn-default " id="BTEventSearch">搜索</button>
      			</form>
		    </div>		    
		    
    	</div>
  	</nav>
