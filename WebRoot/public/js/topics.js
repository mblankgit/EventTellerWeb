
$(document).ready(function(){
	
	var page = $('#topic_page_number').text();
	var type = 1;
	showTopics(page,type);
	$('#pretopic').attr("class","previous disabled");
});


function showTopics(page,type){
	 $("#topics").hide();
	 $("#loadimg").show();
	 $.post(
		'SelectTopics',
		{
			pagenum:page,
			type:type
		},
		function(data){
			var html ;
			 html = combineListTopics(data.topics);
			 $('#topics').html(html);
        	 $("#loadimg").hide();
        	 $("#topics").fadeIn(500);
			if(html == ""){
				$('#nexttopic').attr("class","next disabled");
			}
		}
	 );
}

$('#nexttopic').click(
		function(e){
			e.preventDefault();
			if($('#nexttopic').attr("class") != "next disabled"){
				var page = Number($('#topic_page_number').text()) + 1;
				var type = "1";
				$('#pretopic').attr("class","previous");
				$('#topic_page_number').text(page);
				showTopics(page,type);
			}
		}		
	);
	
	
	
	$('#pretopic').click(
			function(e){
				e.preventDefault();
				var page = Number($('#topic_page_number').text()) - 1;
				var type = "1";
				if(page == 1){
					$('#pretopic').attr("class","previous disabled");
				}
				if(page >= 1){
					$('#nexttopic').attr("class","next");
					$('#topic_page_number').text(page);
					showTopics(page,type);
				}
			}		
		);
	
	
    function combineListTopics(topics){
    	var html = "";
    	if(topics == null || topics.length == 0){
    		html = "<div class=\"col-md-12\"><div class=\"alert alert-danger\"><strong>Sorry!</strong> No Topics to show.</div></div>";
    		$('#nexttopic').attr("class","next disabled");
    		return html;
    	}
		for(var i = 0 ;i < topics.length;i++){
        	html +=  "<div class=\"col-md-12\">";
        	html += "<a href=\"show_topic?tid=" + topics[i].id + "\" target=\"_blank\">";
        	html += "<h4>" + topics[i].summary + "</a>";
        	html += "<span class=\"badge badge-warning pull-right\">" + topics[i].number +"</span></h4>";
        	html += "<br>";
        	html += "<h5><span class=\"label label-primary\">From</span><small> " + topics[i].startTime.replace("T"," ") + "</small>";
        	html += " <span class=\"label label-success\">To</span><small> " + topics[i].endTime.replace("T"," ") +"</small>";
        	html += "</h5>";
        	html += "<hr class=\"soften\">";
        	html += "</div>";	
		}			
		return html;
    }

