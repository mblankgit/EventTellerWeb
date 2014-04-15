
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

        	drawlines(data);
        	
			if(html == ""){
				$('#nexttopic').attr("class","next disabled");
			}
		}
	 );
}

function drawlines(data){
	window.Eevents = [];
	var colors = ['#1f77b4', '#aec7e8', '#ff7f0e', '#ffbb78', '#2ca02c', '#98df8a', '#d62728', '#ff9896', '#9467bd', '#c5b0d5', '#8c564b', '#c49c94', '#e377c2', '#f7b6d2', '#7f7f7f', '#c7c7c7', '#bcbd22', '#dbdb8d', '#17becf', '#9edae5'];
	for (var i = 0; i < data.topics.length; i++) {
		var str = data.topics[i].startTime.split("T")[0].split('-');
		var etr = data.topics[i].endTime.split("T")[0].split('-');
		Eevents.push({
			dates: [new Date(str[0], parseInt(str[1])-1, str[2]), new Date(etr[0], parseInt(etr[1])-1, etr[2])],
			title: data.topics[i].summary,
			section: i,
			attrs: {fill:colors[i % 20], stroke:colors[i % 20]},
		});
	};

	$("#panel").empty();
	var timeline = new Chronoline(document.getElementById("panel"), Eevents,
    { 
      visibleSpan: DAY_IN_MILLISECONDS * 365,
      animated: true,
      sectionLabelAttrs: {'fill': '#997e3d', 'font-weight': 'bold'},
      labelInterval: isHalfMonth,
      hashInterval: isHalfMonth,
      scrollLeft: prevQuarter,
      scrollRight: nextQuarter,
      floatingSubLabels: false,
	});
	$("#panel").hide();

}

$("#linebtn").click(function(){
	if ($("#panel").is(':visible')){
		$("#panel").slideUp();
	}else{
		$("#panel").slideDown(function(){
					});
	}
});


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

