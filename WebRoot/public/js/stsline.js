/**
 * 画布大小
 */
var width = 4060,
    height = 600;

/**
 * 横轴起始坐标
 */
var xc = {
  x: 50,
  y: height - 60,
  ox: 50,
  oy: height - 60,
}

var beginDay = _parseDate("2013-03-01");
var dataIndex = 0;
var dayDuration = 1 * 60 * 60 * 1000; //时间推进进度
var eventList = [];

/**
 * 星星的图片加载
 */
var starImg = new Image();
starImg.src = "./public/img/particle.png";
starImg.onload = starImg.onerror = function(){
  initAll();
}


var nodes = [];
var force = d3.layout.force()
    .gravity(0)
    .nodes(nodes)
    .charge(function(d, i) { 
      if (d.ipar) return 0;
      else return -300;
    })
    .size([width, height]);

var color = d3.scale.category20();
var svg = d3.select("#chart").append("svg:svg")
    .attr("width", width)
    .attr("height", height);

svg.selectAll("circle")
    .data(nodes)
  .enter().append("svg:circle")
    .attr("r", function(d) { return d.radius - 2; })
    .style("fill", function(d, i) { return color(d.type); });

//画布
var canvas = d3.select("#body").append("canvas").attr("width", width).attr("height", height).attr("style","background-color:black");
var context = canvas.node().getContext("2d");

function _parseDate(str){
  return new Date(Date.parse(str.replace(/-/g,   "/")))
}  

function drawXC(){
  context.shadowColor = "black";
  context.drawImage(starImg, xc.x+20, xc.y-29);
}

function checkTime(){
  beginDay = new Date(beginDay.getTime() + dayDuration);
  context.fillStyle = "white";
  context.fillText(beginDay.getFullYear()+" 年 "+(beginDay.getMonth()+1)+" 月 "+beginDay.getDate()+" 日 ", 50, 50);

  if (beginDay.getTime() == dataPart[dataIndex].time){
    drawOneCircle(dataPart[dataIndex], xc);
    dataIndex++;
  }

  eventList.forEach(function(v, k){
    if (v.time == beginDay.getTime()){
      drawEventCircle(v);
    }
  });
}

function drawOneCircle(d, xc){
  d = $.extend({}, d);
  d.radius = d.num;
  d.type = nodes.length;
  d.x = xc.x;
  d.y = d.hot / 10 * height;

  nodes.push(d);
  force.start();

  svg.selectAll("circle").data(nodes)
    .enter().append("circle")
    .attr("cx", function(d) { return d.x; })
    .attr("cy", function(d) { return d.y; })
    .attr("r", function(d) { return d.radius - 2; })
    .style("fill", function(d) {return color(d.type);})
    .transition()
      .duration(750)
      .attrTween("r", function(d) {
        var i = d3.interpolate(0, d.radius);
        return function(t) { return d.radius = i(t); };
      });
}

function drawEventCircle(d){
  d = $.extend({}, d);
  d.radius = 7;
  d.x = Math.random() * width;
  d.y = Math.random() * height;

  for (var i in nodes){
    if (nodes[i]._id == d.par){
      d.ipar = i;
      break;
    }
  }

  nodes.push(d);
  force.start();

  svg.selectAll("circle").data(nodes)
    .enter().append("circle")
    .attr("cx", function(d) { return d.x; })
    .attr("cy", function(d) { return d.y; })
    .attr("r", function(d) { return d.radius - 2; })
    .style("fill", function(d) {return color(20);});
}

function initAll(){
  initDataPart();

  var ks = setInterval(function(){
    if (xc.x > 2000) clearInterval(ks); 
    context.clearRect(0,0,width,height);

    checkTime();
  
    context.beginPath();
    context.strokeStyle = "#fff";
    context.lineCap = "round";
    context.shadowBlur = 40;

    xc.x += 5;
    drawXC();
    context.fillStyle="white";
    context.shadowColor = "white";
    context.fillRect(xc.ox, xc.oy, xc.x, 5);
  }, 15);
}

/**
 * 初始化数据
 * @return {[type]} [description]
 */
function initDataPart(){
  dataPart.forEach(function(v, k){
    v.time = _parseDate(v.start).getTime();
    v._id = k;
    v.events.forEach(function(y, k){
      eventList.push({
        par : v._id,
        time : _parseDate(y.start).getTime()
      });      
    });
  });
}

/**
 * 力学的每秒控制
 * @param  {[type]} e [description]
 * @return {[type]}   [description]
 */
force.on("tick", function(e){
  var q = d3.geom.quadtree(nodes),
      k = e.alpha * .1,
      i = 0,
      n = nodes.length,
      o;
  while (++i < n) {
    o = nodes[i];
    if (!o.ipar) {
      continue;
    }
    c = nodes[o.ipar];
    o.x += (c.x - o.x) * k;
    o.y += (c.y - o.y) * k;
    q.visit(collide(o));
  }

  svg.selectAll("circle")
      .attr("cx", function(d) { return d.x; })
      .attr("cy", function(d) { return d.y; });
});

force.start();

function collide(node) {
  var r = node.radius + 8,
      nx1 = node.x - r,
      nx2 = node.x + r,
      ny1 = node.y - r,
      ny2 = node.y + r;
  return function(quad, x1, y1, x2, y2) {
    if (quad.point && (quad.point !== node)) {
      var x = node.x - quad.point.x,
          y = node.y - quad.point.y,
          l = Math.sqrt(x * x + y * y),
          r = node.radius + quad.point.radius;
      if (l < r) {
        l = (l - r) / l * .5;
        node.px += x * l;
        node.py += y * l;
      }
    }
    return x1 > nx2
        || x2 < nx1
        || y1 > ny2
        || y2 < ny1;
  };
}

var dataPart = [
  {
    sname: "test1",
    start: "2013-03-03",
    num: 20,
    hot: 5,
    events: [{ start: "2013-03-03" },{ start: "2013-03-03" },{ start: "2013-03-04" },{ start: "2013-03-06" },{ start: "2013-03-07" },{ start: "2013-03-04" },{ start: "2013-03-06" },{ start: "2013-03-05" },{ start: "2013-03-06" }]
  },
  {
    sname: "test2",
    start: "2013-03-09",
    num: 30,
    hot: 8,
    events: [{ start: "2013-03-09" },{ start: "2013-03-10" },{ start: "2013-03-11" },{ start: "2013-03-11" },{ start: "2013-03-11" },{ start: "2013-03-13" }]
  },
  {
    sname: "test3",
    start: "2013-03-15",
    num: 40,
    hot: 2,
    events: [{ start: "2013-03-16" },{ start: "2013-03-16" },{ start: "2013-03-16" },{ start: "2013-03-17" }]
  },
  {
    sname: "test4",
    start: "2013-04-15",
    num: 20,
    hot: 3,
    events: []
  }
];
