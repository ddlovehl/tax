<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../taglibs.jsp"%>
<html lang="zh">
<head>
	<meta charset="UTF-8" />
	<meta name="viewport" content="width=device-width,initial-scale=1.0,maximum-scale=1.0,minimum-scale=1.0,user-scalable=no" />
	<meta http-equiv="X-UA-Compatible" content="ie=edge" />
    <meta name="referrer" content="never">
	<title>看账</title>
	<style type="text/css">
		.main{padding-bottom: 0.84rem;}
	</style>
</head>
<body>
	<div class="header billHeader">
		<i></i>
		<h2 class="sj">上海翼倍信息科技有限公司</h2>
	</div>
	<div class="main billPage">
		<div class="billHead">
		  	<div class="swiper-container" id="billHead">
			    <div class="swiper-wrapper">
			      	<div class="swiper-slide"><span profit="" expenditure="" income="" >2018年3月</span></div>
			      	<div class="swiper-slide"><span profit="" expenditure="" income="" >2018年4月</span></div>
			      	<div class="swiper-slide"><span profit="" expenditure="" income="" >2018年5月</span></div>
			    </div>
		  	</div>
		  	<div class="billHeadBtnBox">		  		
			    <div class="swiper-button-next"></div>
    			<div class="swiper-button-prev"></div>
		  	</div>
		  	<div class="number">
		  		<div class="top">
		  			<p id="profit">200,000.00</p>
		  			<p>本月利润（元）</p>
		  		</div>
		  		<div class="bottom">
		  			<div>
		  				<p id="expenditure">532,200.00</p>
		  				<p><span>收入（元）</span></p>
		  			</div>
		  			<div>
		  				<p id="income">332,000.00</p>
		  				<p><span>支出（元）</span></p>
		  			</div>
		  		</div>
		  	</div>
		</div>
		<div class="tapList">
			<ul></ul>
		</div>
		<div class="canvasBox">
			<div class="block block1">
				<h2 class="icon1Title">利润支出分析</h2>
				<div id="chart1"></div>
			</div>
			<div class="block block2">
				<h2 class="icon1Title">纳税分析</h2>
				<div id="chart2"></div>
			</div>
		</div>
	</div>
	<div class="drop-down">
		<ul>
			<li>上海翼倍信息科技有限公司1</li>
			<li>上海翼倍信息科技有限公司2</li>
			<li>上海翼倍信息科技有限公司3</li>
			<li>上海翼倍信息科技有限公司4</li>
			<li>上海翼倍信息科技有限公司5</li>
			<li>上海翼倍信息科技有限公司6</li>
			<li>上海翼倍信息科技有限公司7</li>
			<li>上海翼倍信息科技有限公司8</li>
			<li>上海翼倍信息科技有限公司9</li>
			<li>上海翼倍信息科技有限公司10</li>
			<li>上海翼倍信息科技有限公司11</li>
			<li>上海翼倍信息科技有限公司12</li>
			<li>上海翼倍信息科技有限公司13</li>
			<li>上海翼倍信息科技有限公司14</li>
			<li>上海翼倍信息科技有限公司15</li>
			<li>上海翼倍信息科技有限公司16</li>
			<li>上海翼倍信息科技有限公司17</li>
			<li>上海翼倍信息科技有限公司18</li>
			<li>上海翼倍信息科技有限公司19</li>
			<li>上海翼倍信息科技有限公司20</li>
		</ul>
	</div>
	<!-- <div class="footer">
		<ul class="icon-text-list">
			<li>
				<a href="index.html">
					<i></i>
					<span>首页</span>					
				</a>
			</li>
			<li class="active">
				<a href="bill.html">
					<i></i>
					<span>看账</span>					
				</a>
			</li>
			<li>
				<a href="msg.html">
					<i></i>
					<span>消息</span>
				</a>
			</li>
			<li>
				<a href="my.html">
					<i></i>
					<span>我的</span>
				</a>
			</li>
		</ul>
	</div> -->
	<script src="${ctx }/static/mui/mui.min.js"></script>
	<script src="${ctx }/static/js/echarts.common.min.js"></script>
	<script src="${ctx }/static/js/rem.js"></script>
	<script src="${ctx }/static/js/swiper.min.js"></script>
	<script src="${ctx }/static/js/public.js"></script>
	<script type="text/javascript">
		$('.billPage').show();
		//  循环添加 列表
		var htmlarray = ['资产负债表','利润表','现金流量表','现金流','净利润','应付账款','应收账款','纳税表','科目余额表','总账','明细账','凭证票据'];
		var htmlhref = ['liabilities.html','profit.html','cashflow.html','cash.html','netprofit.html','copewith.html','receivable.html','paytaxes.html','subjectbalance.html','总账','明细账','凭证票据'];
		var html = ''
		$.each(htmlarray, function(i,d) {
			++i;
			html += '<li><a href="'+htmlhref[i - 1]+'"><i style="background-image:url(${ctx}/static/img/bill/icon'+i+'.png)"></i><p>'+d+'</p></a></li>';
		});
		
		$('.tapList ul').html(html);
		// 标题列表
		$('.billHeader').on('tap',function(){
			$(".drop-down").toggleClass('status');
			if($('.drop-down').hasClass('status')){
				HeadListCLoseShow(true);
			}else{
				HeadListCLoseShow(false);
			}
		});
		
		// 标题列表点击事件
		$('.drop-down ul li').on('tap',function(){
			$('.billHeader h2').text($(this).text());
			HeadListCLoseShow(false);
		});
		
		function HeadListCLoseShow(status){
			if(status){
				$(".drop-down").stop().removeClass('HeaderListUp').addClass('HeaderListDown');
				$('.billPage').css({'height':$(window).height(),'overflow':'hidden'});
			}else{
				$(".drop-down").stop().removeClass('HeaderListDown').addClass('HeaderListUp');
				$('.billPage').css({'height':'auto','overflow':'auto'});
			}
		}
		
		window.addEventListener("resize", function() {}, false);
		
//		profit 利润  expenditure 支出   income 收入
		var swiperSlideHtml = '';
		for(var i = 1; i < 13; i++){
			swiperSlideHtml += '<div class="swiper-slide"><span profit="'+Math.round(Math.random() * 10000000)+'" expenditure="'+Math.round(Math.random() * 10000000)+'" income="'+Math.round(Math.random() * 10000000)+'" >2018年'+i+'月</span></div>';
		};
		
		$('#billHead .swiper-wrapper').html(swiperSlideHtml);
	    var swiper = new Swiper('#billHead', {
	      	slidesPerView: 3,
	      	centeredSlides: true,
      		navigation: {
		        nextEl: '.billHeadBtnBox .swiper-button-next',
		        prevEl: '.billHeadBtnBox .swiper-button-prev',
	      	},
	      	on:{
	      		tap:function(e){
	      			swiper.slideTo(swiper.clickedIndex,1000,false);
	      			swiper.update();
	      		},
	      		slideChange: function(){
	      			var dom = $(this.slides[this.activeIndex]);
	      			GetSetNumber(dom);
			    },
	      	},
	    });
	    // 设置 对应月份的 利润 收入 支出
	    function GetSetNumber(dom){
	    	var profit = dom.find('span').attr('profit');
  			var expenditure = dom.find('span').attr('expenditure');
  			var income = dom.find('span').attr('income');
  			$('#profit').text(profit);
  			$('#expenditure').text(expenditure);
  			$('#income').text(income);
	    }
	    // 获取当前月份 swiper 跳转对应 slider
	    var thistime = new Date().getMonth();
	    swiper.slideTo(thistime,1000,false);
	    // 曲线图 和 饼状图
	    Diagram('chart1');
		pie('chart2');
	</script>
</body>
</html>