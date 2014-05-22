<%@ page language="java" import="java.util.*" pageEncoding="utf-8" contentType="text/html; charset=utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>EventTeller - Person</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" href="public/css/bootstrap.min.css">
	<link rel="stylesheet" href="public/css/jquery-ui.css" />
<style>

.link {
  fill: none;
  stroke: #ccc;
  stroke-width: 100px;
}

.node circle {
  fill: #ccc;
  stroke: #fff;
  stroke-width: 1.5px;
}

text {
  font: 10px sans-serif;
  pointer-events: none;
}

</style>
  </head>
  
  <body>
    
    <jsp:include page="header.jsp"/>
    
    <div class="container">
    	<div class="row">
    		<div class="container">
				<br>
				<div class="col-md-6">
					<div class="input-append">
			         	<input type="text" class="form-control" id="SPersonQuery">
			        </div>
				</div>
				<div class="col-md-3">
			        <button type="button" class="btn btn-default " id="SBTPersonSearch">Search</button>
				</div>
			</div>
    	</div>
    	<br />
    	<div class="row">
    		<ul class="nav nav-tabs nav-justified" id="wordTab">
				<li class="active" id="tab1" data-tag="ptab1"><a href="javascript:;">关注热度与相关实体分析</a></li>
				<li id="tab2" data-tag="ptab2"><a href="javascript:;">人物关系图</a></li>
				<li id="tab3" data-tag="ptab3"><a href="javascript:;">相关话题</a></li>
			</ul>
    	</div>
    	<div class="row">
    		<div class="container">
    			<div class="row">
    				<div id = "namelodingimg" style="text-align:center; display: none;" class="col-md-2">
						<img src="public/img/loading.gif" >
					</div>
					<br />
					<div class="alert alert-danger" id="info">
					</div>
    			</div>
	    		<br/>
    		</div>
    	</div>

    	
    	<div class="row  pc" id = "ptab1" style="display:block;">
    		<div class="row" style="height:400px;">
    			<div class="col-md-12" id = "WordTimeChart"></div>    					
    		</div>
    		
    		<div class="row">

				<div class="col-md-6">
				
					<div class="row">						
   						<div class="panel panel-primary">
   							<div class="panel-heading">Input Days</div>
   							<div class="panel-body">
   								<form class="form-inline" role="form">
   									<div class="form-group">
   										<input id="DayStart" class="form-control" placeholder="StartDay">
   									</div>
   									<div class="form-group">
   										<input id="DayEnd" class="form-control" placeholder="EndDay">
   									</div>
    								<button type="button" class="btn btn-warning" id="BTShowRelatedWord">Show Words</button>
   								</form>
   							</div>
   						</div>
   					</div>
    					
    				<div class="row">
    				
    					<div id = "relatedlodingimg" style="text-align:center; display: none;" class="col-md-2">
							<img src="public/img/loading.gif" >
						</div>
   						<div class="col-md-4">
   							<div class="panel panel-primary">
    							<div class="panel-heading">Persons</div>
    							<div class="panel-body">
    								<div id = "RelatedPersons"></div>
    							</div>
   							</div>    					
   						</div>
   						<div class="col-md-4">
   							<div class="panel panel-primary">
    							<div class="panel-heading">Positions</div>
    							<div class="panel-body">
    								<div id = "RelatedPositions"></div>
    							</div>
   							</div>    					
   						</div>		
	    						
    					<div class="col-md-4">
    						<div class="panel panel-primary">
	    						<div class="panel-heading">Verbs</div>
	    						<div class="panel-body">
	    							<div id = "RelatedVerbs">
	    							</div>
	    						</div>
    						</div>    					
    					</div>	 
    				</div>  
    				 						
   				</div>
    				
   				<div class="col-md-6">
   					<div class="panel panel-primary">
   						<div class="panel-heading">Related Events</div>
   						<div class="panel-body">
   							<div id = "eventslodingimg" style="text-align:center; display: none;" class="col-md-2">
								<img src="public/img/loading.gif" >
							</div>
							<div class="row" id = "EventsByWord"></div>
   						</div>
   					</div>    					
   				</div> 		
   						
    		</div>
    				

    	</div>
    			
    			
    			
	  	<div class="row  pc" id = "ptab2" style="display:none;">
	  		<div class="row"> 
	  			<div class="col-md-4" style="text-align:center;">
		  			<h3><span class="label label-primary">Choose A Time Point Here</span></h3>
	  			</div>
	  			<div class="col-md-8" style="text-align:center;">
		    		<div id="slider"></div>
	  			</div>
	  		</div>
	  		<br />
	  		<div class="row">
	  			<div id = "tprlodingimg" style="text-align:center; display: none;">
					<img src="public/img/loading.gif" >
				</div>
				<hr />
	  			<div id="personGraph" class="container" style="text-align:center; height:700px;"></div>
	  		</div> 	
	  	</div>
    			
    	<div class="row  pc" id = "ptab3" style="display:none;">
    		<div class="row">
    			<div class="col-md-2">
    				<div class="panel panel-primary">
    					<div class="panel-heading">Related Topic Words</div>
    					<div class="panel-body">
    						<div id="topicRelatedWords"></div>
    					</div>
    				</div>
    			</div>
    			<div class="col-md-10">
    				<div class="panel panel-primary">
    					<div class="panel-heading">Related Topics</div>
    					<div class="panel-body">
    						<div id = "wordTopiclodingimg" style="text-align:center; display: none;" class="col-md-2">
								<img src="public/img/loading.gif" >
							</div>
    						<div id="wordsRelatedTopics"></div>
    					</div>
    				</div>
    			</div>
    		</div>
    		<div class="row">
    			<div class="container" style="height:800px;">
    				<hr>
    				<h1>Event Relations</h1>
    				<div id = "EventsGraph"></div>
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
	<script src="public/js/d3.js"></script>
	<script src="public/js/word.js"></script>
    
  </body>
</html>
