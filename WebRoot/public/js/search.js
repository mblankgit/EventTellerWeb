$(document).ready(function()
{
    if(document.title == "EventTeller - Search Results"){
    	$('#EventQuery').hide();
    	$('#BTEventSearch').hide();
    }
});


function showResults(events){
	
	var html = "<br>";
	if(events == null || events.length == 0 ){
		html += "<div class=\"col-md-6\"><div class=\"alert alert-danger\"><strong>Sorry!</strong> No Results found..</div></div>";
		return html;
	}
	html +=  "<div class=\"col-md-9\">";
	for(var i = 0 ;i < events.length;i++){
		html += "<hr class=\"soften\">";
    	html += "<a href=\"show_events?eid=" + events[i].id + "\" target=\"_blank\">";
    	html += "<h4>" + events[i].title + "</a>";
    	html += "<span class=\"label label-warning pull-right\">" + events[i].number +"</span></h4>";
    	html += "<h5><small>" + events[i].pubtime.replace("T"," ") + "</small></h5>";
    	html += "<p>" + events[i].content.substring(0,Math.min(251,events[i].content.length)).replace("!##!","\n") + "</p>";
	}			
	html += "</div>";	
	return html;       	
}

function getResults(query){
	 	 $("#results").hide();
	 $("#loadimg").show();
	 $.post(
		'SearchEventJson',
		{
			EventQuery:query
		},
		function(data){
			var html ;
			html = showResults(data.results);
			 $('#results').html(html);
        	 $("#loadimg").hide();
        	 $("#results").fadeIn(500);
		}
	 );
}


$('#SBTEventSearch').click(function(e){
	var query = $('#SEventQuery').val();
	getResults(query);
});


