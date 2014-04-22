$(function(){
	$(".nav li").click(function(){
		$(this).siblings("li").removeClass('active');
		$(this).addClass('active');
		$(".pc").hide();
		$("#"+$(this).data("t")).show();
	});

	$("li[data-t='num2']").click(function(){
		generateTimeLine();
	}).trigger("click");

	$("li[data-t='num3']").click(function(){
		generateTimeNumber();
	});

	$(".loadimg").show();
	$.post('ShowTopicCharts', { tid:getUrlParam('tid') }, function(tp){
			$(".loadimg").hide();
			
			$("li[data-t='num4']").click(function(){
				generateWordCloud(tp);
			});

			$("li[data-t='num4'].active").trigger("click");
		}
	);

	$('.timeline_element').on("click", function(){
		var h4d = $(this).find("h4[data-id]").data("id");
		var title = $(".n1item:eq("+h4d+") h4 a").text(),
		content = $(".n1item:eq("+h4d+") p").text();
				
		$("#myModal .title").text(title);
		$("#myModal .content").text(content);

		$("#myModal").modal('show');
	});

	Highcharts.setOptions({
		lang: {
			months: ['一月', '二月', '三月', '四月', '五月', '六月',  '七月', '八月', '九月',
			 '十月', '十一月', '十二月'],
			weekdays: ['周一', '周二', '周三', '周四', '周五', '周六', '周日']
		}
	});
});

function generateTimeLine(){
	var tdata = [];

	$("#num1 .n1item").each(function(index, i){
		var imgsarr = $(this).find("h6").text().split("!##!");
		imgsarr.shift();
		var type = "blog_post";
		tdata.push({
	        type:     type,
	        date:     $(this).find("h5 small").text(),
	        title:    $(this).find("a.title").text(),
	        width:    350,
	        content:  "<h4 data-id='"+index+"'><a target=_blank href='"+$(this).find("a.title").attr("href")+"'>"+$(this).find("a.title").text()+"</a></h4>"+$(this).find("p").text().substring(0, 100),
	    	images: imgsarr
	    });
	});

	var timeline = new Timeline($('#timeline'), tdata);
	timeline.setOptions({
	    animation:   true,
	    lightbox:    true,
	    showYear:    true,
	    allowDelete: false,
	    columnMode:  'dual',
	    order:       'desc'
	});
	timeline.display();
}


var settings = {
        "size" : {
            "grid" : 10
        },
        "options" : {
            "color" : "random-light",
            "printMultiplier" : 5
        },
        "font" : "Futura, Helvetica, sans-serif",
        "shape" : "default"
};

function generateWordCloud(tp){
	$("#wordCloudChart").show().empty();
	var wordcloud = "";
	for(var i = 0 ; i < tp.words.length; i++){
		wordcloud += "<span data-weight=\"" + tp.weights[i] / 2 + "\">" + tp.words[i] + "</span>"; 
	}
	$('#wordCloudChart').html(wordcloud);
	$("#wordCloudChart").awesomeCloud(settings);
}

function generateTimeNumber(){
	var chartData = [];
	var tmp = {
		begin: 0,
		hot: 0,
	}

	var colors = ['#1f77b4', '#aec7e8', '#ff7f0e', '#ffbb78', '#2ca02c', '#98df8a', '#d62728', '#ff9896', '#9467bd', '#c5b0d5', '#8c564b', '#c49c94', '#e377c2', '#f7b6d2', '#7f7f7f', '#c7c7c7', '#bcbd22', '#dbdb8d', '#17becf', '#9edae5'];
	
	$("#num1 .n1item").each(function(item, i){
		var imgsarr = $(this).find("h6").text().split("!##!");
		var htime = new Date($(this).find("h5 small").text()).getTime();
		var hot = $(this).find(".lnumber").text();
		imgsarr.shift();
		if (htime - tmp.begin > 10 * 24 * 60 * 60 * 1000){
			var point = {};
			var date = new Date(htime);
			point.x = (Date.UTC(date.getUTCFullYear(), date.getUTCMonth()+1, date.getUTCDate()));
			point.y = tmp.hot;
			point.marker = {radius: 5 + Math.floor(Math.random() * 10)};
			point.events = {
				date:     $(this).find("h5 small").text(),
	        	title:    $(this).find("a.title").text(),
	        	content:  $(this).find("p").text().substring(0, 100),
	    		images: imgsarr[0],
	    		href: $(this).find("a.title").attr("href")
			}
			var c = colors[Math.floor(Math.random()*colors.length)];
			point.marker.fillColor = c;
			point.marker.lineColor = c;
			point.marker.states = {
				hover: {
					radius : point.marker.radius + 4,
					fillColor : c,
					lineColor: c
				}
			};
			chartData.push(point);

			tmp.begin = htime;
			tmp.hot = parseInt(hot);
		}else{
			tmp.hot += parseInt(hot);
		}
	});



	$('#timeNumberChart').highcharts({
		title: {
			text: '话题热度追踪折线图'
		},
		chart:{
			type:'line'
		},
		xAxis: {
            type: 'datetime',
            maxZoom: 14 * 24 * 3600000, // fourteen days
            title: {
                text: null
            }
        },
        plotOptions:{
        	series: {
                cursor: 'pointer',
                point: {
                    events: {
                        click: function() {
                        	var pointer = this;
                        	window.location.href = "/ETW/" + pointer.events.href;
                        	//console.log(pointer);
                        }
                    }
                }
            }
        },
        tooltip: {
        	formatter: function(){
        		return '<p style="text-align:center"><b style="font-size:20px;"><a target=_blank href="'+this.point.events.href+'">'+ this.point.events.title +'</a></b></p>'+
        		'<p style="width:100%; white-space:initial;">'+this.point.events.content.substring(0, 100)+'...</p><p style="text-align:center; white-space:initial;"><img src="'+this.point.events.images+'" style="max-width:270px; max-height:129px; margin-top:20px;"/></p>';
        	},
            useHTML: true,
        },
		series:[{
			name:"热度曲线",
			data: chartData
		}]
	});
	
	var chart = $('#timeNumberChart').highcharts();
    
    var i = 0;
    setInterval(function() {
    	if (i > 0) {
            chart.series[0].data[i-1].setState();
            chart.tooltip.hide();
        }
        if (i == chart.series[0].data.length) {
            i = 0;
        }
        chart.series[0].data[i].setState('hover');
        chart.tooltip.refresh(chart.series[0].data[i]);
        i++;
    }, 3000);

}

function getUrlParam(name){
	var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)"); 
	var r = window.location.search.substr(1).match(reg); 
	if (r!=null) return unescape(r[2]); return null; 
} 



