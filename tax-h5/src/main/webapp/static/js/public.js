
$('.header .back').on('touchstart',function(){
	location.href = 'javascript:history.go(-1)';
});

$('.phoneIcon').on('tap',function(){
	Dialing('400-600-8123');
});
function GetRequest() {   
   	var url = location.search; //获取url中"?"符后的字串   
   	var theRequest = new Object();   
   	if (url.indexOf("?") != -1) {   
      	var str = url.substr(1);   
      	strs = str.split("&");   
      	for(var i = 0; i < strs.length; i ++) {   
         	theRequest[strs[i].split("=")[0]]=unescape(strs[i].split("=")[1]);   
      	}   
   	}   
   	return theRequest;   
}

function Dialing(number){
	var btnArray = ['取消', '确定'];
	mui.confirm('',number, btnArray, function(e) {
		if (e.index == 1) {
			location.href = 'tel:'+number;
		}
	})
}

// 曲线图
function Diagram(dom,color){
	var ColorDe = color?color:['#6D99E0','#5ACBD7','#807FE5','#CDAC87'];
	
	var chart1 = document.getElementById(dom);
	var myChart1 = echarts.init(chart1,null,{renderer: 'canvas'});
	var app = {};
	option = null;
	option = {
	    tooltip: {
	        trigger: 'axis'
	    },
	    legend: {
	        data:['邮件营销','联盟广告','123'],
	        top: '3%',
	        left:'3%',
	        itemWidth: 9,
	        itemHeight: 3,
	        icon:'stack',
	        textStyle:{
	        	color:'#999',
	        }
	    },
	    grid: {
	        left: '3%',
	        right: '3%',
	        bottom: '10',
	        containLabel: true
	    },
	    xAxis: {
	        type: 'category',
	        splitLine:{show: true,lineStyle:{opacity:0.2}},
	        boundaryGap: false,
	        data: ['周一','周二','周三','周四','周五','周六','周日'],
	        axisLine:{
	        	lineStyle:{
	        		color: '#999'
	        	},
	        },
	        axisLabel: {
                textStyle: {
                    color: '#999'
                }
            }
	    },
	    yAxis: {
	    	splitLine:{show: true,lineStyle:{opacity:0.2}},
	        axisLine:{
	        	lineStyle:{
	        		color: '#999'
	        	},
	        },
	        axisLabel: {
                textStyle: {
                    color: '#999'
                }
            }
	    },
	    color:ColorDe,
	    series: [
	        {
	            name:'邮件营销',
	            type:'line',
	            smooth: true,

	            data: [10, 932, 50, 1200, 40, 1800, 20]
	        },
	        {
	            name:'联盟广告',
	            type:'line',
	            smooth: true,

	            data: [932, 10, 1200, 50, 1800, 40, 20]
	        },
	        {
	            name:'123',
	            type:'line',
	            smooth: true,

	            data: [600, 600, 600, 600, 600, 600, 600]
	        }
	    ]
	};

	
	if (option && typeof option === "object") {
	    myChart1.setOption(option, true);
	}
}
// 饼状图
function pie(dom,name,color){
	var ColorDe = color?color:['#6D99E0','#5ACBD7','#807FE5','#CDAC87'];
    var chart2 = document.getElementById(dom);
	var myChart2 = echarts.init(chart2,null,{renderer: 'canvas'});
	var app = {};
	app.title = '环形图';
	option2 = null;
	option2 = {
	    tooltip: {
	        trigger: 'item',
	        formatter: "{a} <br/>{b}: {c} ({d}%)"
	    },
	    legend: {
	    	top:'0%',
	    	left:'3%',
	    	bottom:'10%',
	    	itemWidth: 9,
	        itemHeight: 3,
	        data:['邮件营销','联盟广告','视频广告','直接访问'],
	        textStyle:{
	        	color:'#999',
	        }
	    },
	    grid:{

	    },
	    color:ColorDe,
	    series: [
	        {
	            name:'访问来源',
	            type:'pie',
	            radius: ['50%', '70%'],
	            avoidLabelOverlap: false,
	            label: {
	                normal: {
	                    show: false,
	                    position: 'center'
	                },
	                emphasis: {
	                    show: true,
	                    textStyle: {
	                        fontSize: '30',
	                        fontWeight: 'bold'
	                    }
	                }
	            },
	            labelLine: {
	                normal: {
	                    show: false
	                }
	            },
	            data:[
	                {value:335, name:'直接访问'},
	                {value:310, name:'邮件营销'},
	                {value:234, name:'联盟广告'},
	                {value:135, name:'视频广告'},
	            ]
	        }
	    ]
	};
	if (option2 && typeof option2 === "object") {
	    myChart2.setOption(option2, true);
	}
}
