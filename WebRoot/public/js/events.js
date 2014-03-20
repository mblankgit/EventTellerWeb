	
	$(document).ready(function()
        {
            $("#event_date_text").datepicker({
            	dateFormat: "yy-mm-dd"
            });
                		
    		selectNews();
        });
	
        
        
        function combineListNews(events){
        	var html = "";
        	if(events == null || events.length == 0 ){
        		html = "<div class=\"col-md-6\"><div class=\"alert alert-danger\"><strong>Sorry!</strong> No news to show.</div></div>";
        		return html;
        	}
        	html +=  "<div class=\"col-md-9\">";
			for(var i = 0 ;i < events.length;i++){
	        	
	        	html += "<a href=\"show_events?eid=" + events[i].id + "\" target=\"_blank\">";
	        	html += "<h4>" + events[i].title + "</a>";
	        	html += "<span class=\"label label-warning pull-right\">" + events[i].number +"</span></h4>";
	        	html += "<h5><small>" + events[i].pubtime.replace("T"," ") + "</small></h5>";
	        	html += "<p>" + events[i].content + "</p>";
	        	html += "<hr class=\"soften\">";
			}			
			html += "</div>";	
			return html;
        	
        }
        
        
        
        function selectNews(){
        	
       	 	 $("#events").hide();
			 $("#loadimg").show();
        	 $.post(
        		'SelectEvents',
        		{
        			indate:$('#event_date_text').val(),
        			subtopic:$("#myTab .active").text()
        		},
        		function(data){
        			var html ;
        			html = combineListNews(data.ets);
        			 $('#events').html(html);
		        	 $("#loadimg").hide();
		        	 $("#events").fadeIn(1000);
        		}
        	 );
        }

        $('#bt_show_events').click(function (e){
        	selectNews();
        });
        
        
		$('#myTab li:eq(0) a').click(function (e) {
  		  	e.preventDefault();
  		  	$(this).tab('show');
  		  	selectNews();
  		});

		$('#myTab li:eq(1) a').click(function (e) {
  		  	e.preventDefault();
  		  	$(this).tab('show');
  		  	selectNews();
  		});
		
		$('#myTab li:eq(2) a').click(function (e) {
  		  	e.preventDefault();
  		  	$(this).tab('show');
  		  	selectNews();
  		});

		$('#myTab li:eq(3) a').click(function (e) {
  		  	e.preventDefault();
  		  	$(this).tab('show');
  		  	selectNews();
  		});
        
		$('#myTab li:eq(4) a').click(function (e) {
  		  	e.preventDefault();
  		  	$(this).tab('show');
  		  	selectNews();
	  	});
		
		$('#myTab li:eq(5) a').click(function (e) {
  		  	e.preventDefault();
  		  	$(this).tab('show');
  		  	selectNews();
	  	});
		
		$('#myTab li:eq(6) a').click(function (e) {
  		  	e.preventDefault();
  		  	$(this).tab('show');
  		  	selectNews();
	  	});
		
		$('#myTab li:eq(7) a').click(function (e) {
  		  	e.preventDefault();
  		  	$(this).tab('show');
  		  	selectNews();
	  	});
		
		$('#myTab li:eq(8) a').click(function (e) {
  		  	e.preventDefault();
  		  	$(this).tab('show');
  		  	selectNews();
	  	});
		
		$('#myTab li:eq(9) a').click(function (e) {
  		  	e.preventDefault();
  		  	$(this).tab('show');
  		  	selectNews();	  		  
	  	});

		$('#myTab li:eq(10) a').click(function (e) {
  		  	e.preventDefault();
  		  	$(this).tab('show');
  		  	selectNews();
	  	});
		
		$('#myTab li:eq(11) a').click(function (e) {
  		  	e.preventDefault();
  		  	$(this).tab('show');
  		  	selectNews();
	  	});
		
		

     