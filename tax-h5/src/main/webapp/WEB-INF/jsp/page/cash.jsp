<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../taglibs.jsp"%>
<html lang="zh">
<head>
	<meta charset="UTF-8" />
	<meta name="viewport" content="width=device-width,initial-scale=1.0,maximum-scale=1.0,minimum-scale=1.0,user-scalable=no" />
	<meta http-equiv="X-UA-Compatible" content="ie=edge" />
    <meta name="referrer" content="never">
	<title>现金流</title>
	<style type="text/css">
		.main{padding-bottom: 0;}
	</style>
</head>
<body>
	<div class="header billHeader">
		<i class="back"></i>
		<h2>现金流</h2>
	</div>
	<div class="main billPage">
		<div class="billHead cashHead">
			<div class="cashbox">
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
			</div>
		  	<div class="number">
		  		<div class="top">
		  			<p id="profit">200,000.00</p>
		  			<p>净流动资金(元)</p>
		  		</div>
		  		<div class="bottom">
		  			<div>
		  				<p id="expenditure">532,200.00</p>
		  				<p><span>初期(元)</span></p>
		  			</div>
		  			<div>
		  				<p id="income">332,000.00</p>
		  				<p><span>末期(元)</span></p>
		  			</div>
		  		</div>
		  	</div>
		</div>
		<div class="cashList">
			<h2 class="icon1Title">现金明细流</h2>
			<ul class="OneLevelList">
				<li>
					<p class="title rightIcon">库存现金</p>
					<div>
						<p><span>初期：</span><span>123123123123123123123123123123123123</span></p>
						<p><span>末期：</span><span>123</span></p>
					</div>
					<ul class="TwoLevelList">
						<li>
							<p>库存现金</p>
							<div>
								<p><span>初期：</span><span>123123123123123123123123123123123123</span></p>
								<p><span>末期：</span><span>123</span></p>
							</div>
						</li>
					</ul>
				</li>
				<li>
					<p class="title">库存现金</p>
					<div>
						<p><span>初期：</span><span>123123123123123123123123123123123123</span></p>
						<p><span>末期：</span><span>123</span></p>
					</div>
				</li>
				<li>
					<p class="title">库存现金</p>
					<div>
						<p><span>初期：</span><span>123123123123123123123123123123123123</span></p>
						<p><span>末期：</span><span>123</span></p>
					</div>
				</li>
				<li>
					<p class="title">库存现金</p>
					<div>
						<p><span>初期：</span><span>123123123123123123123123123123123123</span></p>
						<p><span>末期：</span><span>123</span></p>
					</div>
				</li>
				<li>
					<p class="title">库存现金</p>
					<div>
						<p><span>初期：</span><span>123123123123123123123123123123123123</span></p>
						<p><span>末期：</span><span>123</span></p>
					</div>
				</li>
				<li>
					<p class="title">库存现金</p>
					<div>
						<p><span>初期：</span><span>123123123123123123123123123123123123</span></p>
						<p><span>末期：</span><span>123</span></p>
					</div>
				</li>
				<li>
					<p class="title">库存现金</p>
					<div>
						<p><span>初期：</span><span>123123123123123123123123123123123123</span></p>
						<p><span>末期：</span><span>123</span></p>
					</div>
				</li>
				<li>
					<p class="title">库存现金</p>
					<div>
						<p><span>初期：</span><span>123123123123123123123123123123123123</span></p>
						<p><span>末期：</span><span>123</span></p>
					</div>
				</li>
				<li>
					<p class="title">库存现金</p>
					<div>
						<p><span>初期：</span><span>123123123123123123123123123123123123</span></p>
						<p><span>末期：</span><span>123</span></p>
					</div>
				</li>
				<li>
					<p class="title">库存现金</p>
					<div>
						<p><span>初期：</span><span>123123123123123123123123123123123123</span></p>
						<p><span>末期：</span><span>123</span></p>
					</div>
				</li>
				<li>
					<p class="title">库存现金</p>
					<div>
						<p><span>初期：</span><span>123123123123123123123123123123123123</span></p>
						<p><span>末期：</span><span>123</span></p>
					</div>
				</li>
			</ul>
		</div>
	</div>
	<script src="${ctx }/static/mui/mui.min.js"></script>
	<script src="${ctx }/static/js/echarts.common.min.js"></script>
	<script src="${ctx }/static/js/rem.js"></script>
	<script src="${ctx }/static/js/swiper.min.js"></script>
	<script src="${ctx }/static/js/public.js"></script>
	<script type="text/javascript">
		$('.billPage').show();
		
//		profit 利润  expenditure 支出   income 收入
		var swiperSlideHtml = '';
		for(var i = 1; i < 13; i++){
			swiperSlideHtml += '<div class="swiper-slide"><span profit="'+Math.round(Math.random() * 10000000)+'" expenditure="'+Math.round(Math.random() * 10000000)+'" income="'+Math.round(Math.random() * 10000000)+'" >2018年'+i+'月</span></div>';
		};
		
		$('#billHead .swiper-wrapper').html(swiperSlideHtml);
		
		$('.OneLevelList > li').on('tap',function(){
			$(this).find('p.rightIcon').toggleClass('sta')
			$(this).find('ul.TwoLevelList').stop().slideToggle();
		})
		
		
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
	    
	</script>
</body>
</html>