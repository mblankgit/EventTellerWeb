$(function () { 
	
window.opentimeline1 = function(){
	$("#my-timeline").empty();
	createStoryJS({
        type:       'timeline',
        height:     '450',
        source:     'public/Events.json',
        embed_id:   'my-timeline',
        lang: 'zh-cn',
        css:  'public/css/timeline.css',
        js: 'public/js/timeline-min.js'
    });
}

window.opentimeline2 = function(){
	$("#placement").empty();
	var tg1 = {};
	tg1 = $("#placement").timeline({
		"min_zoom":20, 
		"max_zoom":35,
		"show_centerline":true,
		"icon_folder":"public/timeglider/timeglider/icons/",
		"data_source":"public/Events_large.json",
		"show_footer":true,
		"culture": "zh-Hans"
	});
	
	tg_actor = tg1.data("timeline");
	
	$("#scrolldown").bind("click", function() {
		$(".timeglider-timeline-event").animate({top:"+=100"})
	})
	
	$("#scrollup").bind("click", function() {
		$(".timeglider-timeline-event").animate({top:"-=100"})
	});
	
	timeglider.eventActions = {
		nagavigateTo:function(obj) {
			var nav = obj.navigateTo;
			tg_actor.goTo(nav.focus_date,nav.zoom_level);
			
			setTimeout(function () {
				$el = $(".timeglider-timeline-event#" + obj.id);
				$el.find(".timeglider-event-spanner").css({"border":"1px solid green"}); // 
			}, 50);
		},
		
		
		loadTimeline: function(obj) {
			tg_actor.loadTimeline(
				obj.loadTimeline.url, 
				{	
					fn:function(args, data) { debug.log("data:", data[0]); }, 
				 	args:"",
				 	display:true
				}
			);
		}
	}
}

// $.get("public/Events.json", function(data){
// 	var data = data.timeline.date;
// 	var res = [{"id": "idahoTimeline",
// 	"title": "2013年热门事件总览",
// 	"focus_date": "2014-03-01 12:00",
// 	"initial_zoom": "35",
// 	"color": "#82530d",
// 	"size_importance": "true",
// 	"image_lane_height":50,
// 	"events": []
//     }];
//     var attrs = ["triangle_green.png", "circle_yellow.png", "flag_blue.png", "inf_orange.png", "music_purple.png", "square_gray.png", "star_white.png"];
// 	for (var i in data){
// 		var obj = {
// 			"id": i,
// 	        "title": data[i].headline,
// 	        "startdate": data[i].startDate,
// 	        "description": data[i].text,
// 	        "event_type": "event",
// 	        "icon": attrs[Math.floor(Math.random()*attrs.length)],
// 	        "low_threshold": "1",
// 	        "high_threshold": "60",
// 	        "importance": "35",
// 	        "ypix": "0",
// 	        "slug":"",
// 			"modal_type":"full"
// 		};
// 	    if (data[i].asset.media){
// 	    	obj.image = data[i].asset.media;
// 	    }
// 		res[0].events.push(obj);
// 	}
// 	console.log(JSON.stringify(res));
// });

$("#linebtn").click(function(){
	if ($("#placement").is(':visible')){
		$("#placement").fadeOut(function(){
			$("#my-timeline").fadeIn();
		});
	}else{
		$("#my-timeline").fadeOut(function(){
			$("#placement").fadeIn();
		});
	}
});

opentimeline2();
opentimeline1();
}); // end document-ready
