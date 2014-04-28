$(document).ready(function() {
    $("#event_date_text").datepicker({
        dateFormat: "yy-mm-dd"
    });

    $(".timedate").text(new Date().Format("yyyy-MM-dd"));

    var subtopic = 0;
    selectNews(subtopic);
});

$("#newcomment").click(function(){
	$(this).siblings("li").removeClass('active');
	$(this).addClass('active');
    $("#events").hide();
    $("#loadimg").show();

    $.get("/ControAnalysis/TopHit", {c: 100, t: new Date().Format("yyyy-MM-dd")}, function(data){
        var html;
        html = combineListNew_topic(data);
        $('#events').html(html);
        $("#loadimg").hide();
        $("#events").fadeIn(1000);
    },'json');
});

$("#newweibo").click(function(){
	$(this).siblings("li").removeClass('active');
	$(this).addClass('active');
    $("#events").hide();
    $("#loadimg").show();

    $.get("public/WeiboHotTopics.json", function(data){
        var html;
        html = combineListNewWeibo_topic(data);
        $('#events').html(html);
        $("#loadimg").hide();
        $("#events").fadeIn(1000);
    },'json'); 
});

function combineListNewWeibo_topic(events) {
    events = events.HotTopics;

    var html = "";
    if (events == null || events.length == 0) {
        html = "<div class=\"col-md-6\"><div class=\"alert alert-danger\"><strong>Sorry!</strong> No news to show.</div></div>";
        return html;
    }
    html += "<div class=\"col-md-9\">";
    for (var i = 0; i < events.length; i++) {
        html += "<a href='javascript:;' target=\"_blank\">";
        html += "<h4>" + events[i].Topic.title;
        html += "<span class=\"label label-warning pull-right\"><i class='glyphicon glyphicon-fire' style='margin-right:5px'></i>" + events[i].Topic.hot_degree + "</span></h4></a>";
        html += "<h5><small>" + events[i].Topic.crawl_date + "</small></h5>";
        html += "<p style='max-height:100px; overflow:hidden;'>" + events[i].Topic.content + "</p>";
        html += "<hr class=\"soften\">";
    }
    html += "</div>";
    return html;
}


function combineListNew_topic(events) {
    var html = "";
    if (events == null || events.length == 0) {
        html = "<div class=\"col-md-6\"><div class=\"alert alert-danger\"><strong>Sorry!</strong> No news to show.</div></div>";
        return html;
    }
    html += "<div class=\"col-md-9\">";
    for (var i = 0; i < events.length; i++) {
        html += "<a id='eveurl"+i+"' href='"+events[i].commenturl.replace(/@AND@/g,"&").replace(/(@U@)/g,"_").replace(/(@S@)/g,"#")+"' target=\"_blank\">";
        html += "<h4>" + events[i].title ;
        html += "<span class=\"label label-warning pull-right\">" + events[i].degree + "</span></h4></a>";
        html += "<h5><small>" + events[i].newstime + "</small></h5>";
        html += "<p id='eve"+i+"' style='max-height:100px; overflow:hidden;'>" + events[i].content + "</p>";
        html += "<a href='javascript:;' onclick='folder(\""+i+"\")'>展开/收起</a>"
        html += "<div style='margin-top:20px;' id='evecb"+i+"'></div>"
        html += "<hr class=\"soften\">";
    }
    html += "</div>";
    return html;
}

function folder(id){
    var target = $("#eve"+id);

    if (target.data('fold') == 'true') {
        $("#evecb"+id).empty();
        target.css("maxHeight", 100);
        target.data('fold', 'false');
    }else{
        $.get("/ControAnalysis/ComHit", {commenturl: $("#eveurl"+id).attr("href").replace(/(_)/g,"@U@").replace(/(#)/g,"@S@").replace(/(&)/g, "@AND@")}, function(data){
            $("#evecb"+id).empty();
            for (var i = 0; i < data.length; i++) {
                var html = "";
                html +='<div class="bs-callout bs-callout-info"><h4>'+data[i].user+'</h4><p>'+data[i].context+'</p></div>';
                $("#evecb"+id).append(html);
            };
        },'json');

        target.css('maxHeight', 'auto');
        target.data('fold', 'true');        
    }
}

Date.prototype.Format = function (fmt) { //author: meizz 
    var o = {
        "M+": this.getMonth() + 1, //月份 
        "d+": this.getDate(), //日 
        "h+": this.getHours(), //小时 
        "m+": this.getMinutes(), //分 
        "s+": this.getSeconds(), //秒 
        "q+": Math.floor((this.getMonth() + 3) / 3), //季度 
        "S": this.getMilliseconds() //毫秒 
    };
    if (/(y+)/.test(fmt)) fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
    for (var k in o)
    if (new RegExp("(" + k + ")").test(fmt)) fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
    return fmt;
}

function combineListNews(events) {
    var html = "";
    if (events == null || events.length == 0) {
        html = "<div class=\"col-md-6\"><div class=\"alert alert-danger\"><strong>Sorry!</strong> No news to show.</div></div>";
        return html;
    }
    html += "<div class=\"col-md-9\">";
    for (var i = 0; i < events.length; i++) {

        html += "<a href=\"show_events?eid=" + events[i].id + "\" target=\"_blank\">";
        html += "<h4>" + events[i].title + "</a>";
        html += "<span class=\"label label-warning pull-right\">" + events[i].number + "</span></h4>";
        html += "<h5><small>" + events[i].pubTime.replace("T", " ") + "</small></h5>";
        html += "<p>" + events[i].content.substring(0,Math.min(251,events[i].content.length)).replace("!##!","\n") + "</p>";
        html += "<hr class=\"soften\">";
    }
    html += "</div>";
    return html;
}

function selectNews(topic) {
    $("#events").hide();
    $("#loadimg").show();

    $.post(
        'SelectEvents', {
            indate: $('#event_date_text').val(),
            subtopic: topic
        },
        function(data) {
            var html;
            html = combineListNews(data.ets);
            $('#events').html(html);
            $("#loadimg").hide();
            $("#events").fadeIn(1000);
        }
    );
}
/**
 * 点击日期
 * @param  {[type]} e [description]
 * @return {[type]}   [description]
 */
$('#bt_show_events').click(function(e) {
    var topic = $('#myTab li.active').index();
    selectNews(topic);
    $(".timedate").text("");
});


$('#myTab li:eq(0) a').click(function(e) {
    e.preventDefault();
    $(this).tab('show');
    var topic = $('#myTab li.active').index();
    selectNews(topic);
});

$('#myTab li:eq(1) a').click(function(e) {
    e.preventDefault();
    $(this).tab('show');
    var topic = $('#myTab li.active').index();
    selectNews(topic);
});

$('#myTab li:eq(2) a').click(function(e) {
    e.preventDefault();
    $(this).tab('show');
    var topic = $('#myTab li.active').index();
    selectNews(topic);
});

$('#myTab li:eq(3) a').click(function(e) {
    e.preventDefault();
    $(this).tab('show');
    var topic = $('#myTab li.active').index();
    selectNews(topic);
});

$('#myTab li:eq(4) a').click(function(e) {
    e.preventDefault();
    $(this).tab('show');
    var topic = $('#myTab li.active').index();
    selectNews(topic);
});

$('#myTab li:eq(5) a').click(function(e) {
    e.preventDefault();
    $(this).tab('show');
    var topic = $('#myTab li.active').index();
    selectNews(topic);
});

$('#myTab li:eq(6) a').click(function(e) {
    e.preventDefault();
    $(this).tab('show');
    var topic = $('#myTab li.active').index();
    selectNews(topic);
});

$('#myTab li:eq(7) a').click(function(e) {
    e.preventDefault();
    $(this).tab('show');
    var topic = $('#myTab li.active').index();
    selectNews(topic);
});

$('#myTab li:eq(8) a').click(function(e) {
    e.preventDefault();
    $(this).tab('show');
    var topic = $('#myTab li.active').index();
    selectNews(topic);
});

$('#myTab li:eq(9) a').click(function(e) {
    e.preventDefault();
    $(this).tab('show');
    var topic = $('#myTab li.active').index();
    selectNews(topic);
});

$('#myTab li:eq(10) a').click(function(e) {
    e.preventDefault();
    $(this).tab('show');
    var topic = $('#myTab li.active').index();
    selectNews(topic);
});

$('#myTab li:eq(11) a').click(function(e) {
    e.preventDefault();
    $(this).tab('show');
    var topic = $('#myTab li.active').index();
    selectNews(topic);
});