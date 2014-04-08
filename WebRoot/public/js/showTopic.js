$(function(){
	$(".nav li").click(function(){
		$(this).siblings("li").removeClass('active');
		$(this).addClass('active');
		$(".pc").hide();
		$("#"+$(this).data("t")).show();
	});

	$("li[data-t='num2']").click(function(){
		generateTimeLine();
	});

	$(".loadimg").show();
	$.post(
			'ShowTopicCharts',
			{
				tid:getUrlParam('tid')
			},
			function(tp){
				$(".loadimg").hide();
				$("li[data-t='num3']").click(function(){
					generateTimeNumber(tp);
				});

				$("li[data-t='num4']").click(function(){
					generateWordCloud(tp);
				});


				//combineHtml(tp);
			}
	);

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

	$("#num1 .n1item").each(function(item, i){
		tdata.push({
	        type:     'blog_post',
	        date:     $(this).find("h5 small").text(),
	        title:    $(this).find("a.title").text(),
	        width:    350,
	        content:  "<h5><a target=_blank href='"+$(this).find("a.title").attr("href")+"'>"+$(this).find("a.title").text()+"</a></h5>"+$(this).find("p").text()
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

function generateTimeNumber(tp){
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
		series:[{
			name:"热度曲线",
			data:[]
		}]
	});
	
	var chart = $('#timeNumberChart').highcharts();
	var chartData=[];
	for(var i = 0 ; i < tp.days.length; i++){
		var point = [];
		var date = new Date(tp.days[i]*24*60*60*1000);
		point.push(Date.UTC(date.getUTCFullYear(), date.getUTCMonth()+1, date.getUTCDate()));
		point.push(tp.numbers[i]);
		chartData.push(point);
	}
    chart.series[0].setData(chartData);
}


function getUrlParam(name){
	var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)"); 
	var r = window.location.search.substr(1).match(reg); 
	if (r!=null) return unescape(r[2]); return null; 
} 



