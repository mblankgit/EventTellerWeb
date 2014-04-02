$(function(){
<<<<<<< HEAD
	var settings = {
        "size" : {
            "grid" : 4
        },
        "options" : {
            "color" : "random-light",
            "printMultiplier" : 3
        },
        "font" : "Futura, Helvetica, sans-serif",
        "shape" : "circle"
    }
    $("#wordcloud2").awesomeCloud(settings);
=======

    var cap = 0;
    setInterval(function(){
        cap = (cap+1) % 4;
        $("#cap").fadeOut(1000, function(){
            $("#cap").attr("src", "public/img/cap"+cap+".png");
        }).fadeIn(1000);
    }, 5000);

    $.get("public/HotTopic.json", function(data){
        var hotlist = data.hottopic;
        for (var i = 0; i < hotlist.length; i++) {
            draw(hotlist[i]);
        };

        $(".list-group-item:first").trigger("click");
        var index = 0;
        setInterval(function() {
            index = (index + 1) % 7;
            console.log()
            $(".list-group-item:eq("+index+")").trigger("click");
        }, 5000);

    });

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
    }
    
    function draw(item){
        var li = $("<li class='list-group-item'>"+item.topic.title+"</li>");
        li.on("click", function(){
            $(".list-group-item").removeClass('list-group-item-info');
            li.addClass('list-group-item-info');

            $("#wordcloud2").empty();
            for (i in item.topic.keywords) {
                $("#wordcloud2").append("<span data-weight='"+(item.topic.keywords[i] * 500)+"'>"+i+"</span>")
            };
            $("#wordcloud2").awesomeCloud(settings);
        });
        $(".wordcd").append(li);
    };

>>>>>>> ef2033b23dfe6f909a728959b88a4581db66839e
});