$(document).ready(function() {
    var i1 = Math.floor(new Date().getTime()/1000) - 1396257661 + 4794759;
    $(".i1").text(i1);

    function q1(){
        i1+= Math.floor(Math.random()*100);
        $(".i1").text(i1);     
        setTimeout(q1, 2000);
    };

    var i2 = Math.floor(new Date().getTime()/1000) - 1396257661 + 2896594;
    $(".i2").text(i2);

    function q2(){
        i2 += 1;
        $(".i2").text(i2);     
        setTimeout(q2, 10000);
    };

    var i3 = Math.floor(new Date().getTime()/1000) - 1396257661 + 1222225;
    $(".i3").text(i3);

    function q3(){
        i3 += 1;
        $(".i3").text(i3);     
        setTimeout(q1, 15000);
    };


    (function(){
        q1();
        q2();
        q3();
    })();
    
    showChar1();
});


function showChar1() {
    $('#chart1').highcharts({
        chart: {
            plotBackgroundColor: null,
            plotBorderWidth: null,
            plotShadow: false
        },
        title: "新闻数据源来源",
        tooltip: {
            pointFormat: '{series.name}: <b>{point.y}</b>'
        },
        plotOptions: {
            pie: {
                allowPointSelect: true,
                cursor: 'pointer',
                dataLabels: {
                        enabled: false
                },
                showInLegend: true
            }
        },
        series: [{
            type: 'pie',
            name: '网页数',
            data: [
                ['163',     322040],
                ['bjnews',      37703],
                ['ce',      109847],
                ['china',       192460],
                ['chinacourt',    35245],
                ['chinadaily',    17513],
                ['chinanews', 532906],
                ['cntv',        242731],
                ['cyol',        52405],
                ['dahe',        158375],
                ['dffyw',       5167],
                ['fabang',      13420],
                ['gjzx',        88013],
                ['HuanQiu',     205767],
                ['ifeng',       317312],
                ['jcrb',        22548],
                ['legalinfo', 126],
                ['msn',     67560],
                ['mylegist',  181],
                ['newschina', 75359],
                ['people',      246790],
                ['sina',        549986],
                ['sohu',        354128],
                ['southcn',     159837],
                ['takungpao', 127994],
                ['tencent',     213117],
                ['xinhuanet', 494619],
                ['yahoo',       91207],
                {
                    name: 'yangtse',
                    y: 615507,
                    sliced: true,
                    selected: true
                },
            ]
        }]
    });
}