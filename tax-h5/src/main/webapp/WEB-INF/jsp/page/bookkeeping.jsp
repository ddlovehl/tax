<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../taglibs.jsp"%>
<html lang="zh">
<head>
	<meta charset="UTF-8" />
	<meta name="viewport" content="width=device-width,initial-scale=1.0,maximum-scale=1.0,minimum-scale=1.0,user-scalable=no" />
	<meta http-equiv="X-UA-Compatible" content="ie=edge" />
    <meta name="referrer" content="never">
	<title>代理记账</title>
	<style type="text/css">
		
	</style>
</head>
<body>
	<div class="header header1">
		<i class="back"></i>
		<h2>代理记账</h2>
	</div>
	<div class="main regconpany">
		<div class="mainTop">
			<div class="swiper-container navswiper">
			    <div class="swiper-wrapper">
			      	<div class="swiper-slide active">小规模企业</div>
		    	  	<div class="swiper-slide">一般纳税人</div>
			    </div>
		  	</div>
	  	  	<div class="swiper-container gallery-thumbs">
			    <div class="swiper-wrapper">
		            <div class="swiper-slide" style="background-image:url(${ctx}/static/img/bookkeeping/company.png)"></div>
		            <div class="swiper-slide" style="background-image:url(${ctx}/static/img/bookkeeping/personal.png)"></div>
			    </div>
		  	</div>
		</div>

		<div class="RegContentBox bookkeeping">
		  	<div class="swiper-container" id="regContentBox">
		    	<div class="swiper-wrapper">
		    		<div class="swiper-slide">
		      			<div class="regProcess homeblock">
							<h2 class="icon1Title">申请流程</h2>
							<div class="reg-lc-box">
								<i class="reg-lc"></i>					
							</div>
						</div>
						<div class="material homeblock">
							<h2 class="icon1Title">所需材料</h2>
							<div class="btns">
								<button class="active">新公司所需材料</button>
								<button>正常公司所需材料</button>
							</div>
							<ul class="materialList newcompany">
								<li>章照<span>（营业执照、开户行许可证、公章、法人和 股东身份证原件）。</span></li>
								<li>工资表。</li>
								<li>一证通。</span></li>
								<li>许可证复印件或许可证明。</li>
							</ul>
							<ul class="materialList campany">
								<li>章照<span>（营业执照、开户行许可证、公章、法人和 股东身份证原件）。</span></li>
								<li>工资表。</li>
								<li>一证通。</li>
								<li>记账凭证。</li>
								<li>银行对账单。</li>
								<li>总账、明细账。</li>
								<li>税务申报表。</li>
								<li>工商年报、报告书。</li>
							</ul>
						</div>
						<div class="Certificates homeblock">
							<h2 class="icon1Title">你所获得</h2>
							<ul class="ImgList">
								<li>
									<i style="background-image: url(${ctx}/static/img/bookkeeping/get1.png);"></i>
									<span>财务报表</span>
								</li>
								<li>
									<i style="background-image: url(${ctx}/static/img/bookkeeping/get2.png);"></i>
									<span>总账明细账</span>
								</li>
								<li>
									<i style="background-image: url(${ctx}/static/img/bookkeeping/get3.png);"></i>
									<span>票据整理</span>
								</li>
								<li>
									<i style="background-image: url(${ctx}/static/img/bookkeeping/get4.png);"></i>
									<span>财税解答</span>
								</li>
							</ul>
							<i class="CertificatesImg"></i>
						</div>
						<div class="advantage homeblock">
							<h2 class="icon1Title">六大优势</h2>
							<ul>
								<li>
									<i></i>
									<p>资金安全</p>
									<span>收费价格透明合理，未服务自由退款</span>
								</li>
								<li>
									<i></i>
									<p>专业团队</p>
									<span>专业资深顾问，售前售后全程一对一服务</span>
								</li>
								<li>
									<i></i>
									<p>资金安全</p>
									<span>收费价格透明合理，未服务自由退款</span>
								</li>
								<li>
									<i></i>
									<p>降低成本</p>
									<span>根据客户实际情况制定方案，帮助企业降低注册、财务成本</span>
								</li>
								<li>
									<i></i>
									<p>资金安全</p>
									<span>收费价格透明合理，未服务自由退款</span>
								</li>
								<li>
									<i></i>
									<p>资金安全</p>
									<span>收费价格透明合理，未服务自由退款</span>
								</li>
							</ul>
						</div>
		      		</div>
		      		<div class="swiper-slide">
		      			<div class="regProcess homeblock">
							<h2 class="icon1Title">申请流程</h2>
							<div class="reg-lc-box">
								<i class="reg-lc"></i>					
							</div>
						</div>
						<div class="material homeblock">
							<h2 class="icon1Title">所需材料</h2>
							<div class="btns">
								<button class="active">新公司所需材料</button>
								<button>正常公司所需材料</button>
							</div>
							<ul class="materialList newcompany">
								<li>章照<span>（营业执照、开户行许可证、公章、法人和 股东身份证原件）。</span></li>
								<li>工资表。</li>
								<li>一证通。</span></li>
								<li>许可证复印件或许可证明。</li>
							</ul>
							<ul class="materialList campany">
								<li>章照<span>（营业执照、开户行许可证、公章、法人和 股东身份证原件）。</span></li>
								<li>工资表。</li>
								<li>一证通。</li>
								<li>记账凭证。</li>
								<li>银行对账单。</li>
								<li>总账、明细账。</li>
								<li>税务申报表。</li>
								<li>工商年报、报告书。</li>
							</ul>
						</div>
						<div class="Certificates homeblock">
							<h2 class="icon1Title">你所获得</h2>
							<ul class="ImgList">
								<li>
									<i style="background-image: url(${ctx}/static/img/bookkeeping/get1.png);"></i>
									<span>财务报表</span>
								</li>
								<li>
									<i style="background-image: url(${ctx}/static/img/bookkeeping/get2.png);"></i>
									<span>总账明细账</span>
								</li>
								<li>
									<i style="background-image: url(${ctx}/static/img/bookkeeping/get3.png);"></i>
									<span>票据整理</span>
								</li>
								<li>
									<i style="background-image: url(${ctx}/static/img/bookkeeping/get4.png);"></i>
									<span>财税解答</span>
								</li>
							</ul>
							<i class="CertificatesImg"></i>
						</div>
						<div class="advantage homeblock">
							<h2 class="icon1Title">六大优势</h2>
							<ul>
								<li>
									<i></i>
									<p>资金安全</p>
									<span>收费价格透明合理，未服务自由退款</span>
								</li>
								<li>
									<i></i>
									<p>专业团队</p>
									<span>专业资深顾问，售前售后全程一对一服务</span>
								</li>
								<li>
									<i></i>
									<p>资金安全</p>
									<span>收费价格透明合理，未服务自由退款</span>
								</li>
								<li>
									<i></i>
									<p>降低成本</p>
									<span>根据客户实际情况制定方案，帮助企业降低注册、财务成本</span>
								</li>
								<li>
									<i></i>
									<p>资金安全</p>
									<span>收费价格透明合理，未服务自由退款</span>
								</li>
								<li>
									<i></i>
									<p>资金安全</p>
									<span>收费价格透明合理，未服务自由退款</span>
								</li>
							</ul>
						</div>
		      		</div>
		    	</div>
		  	</div>
		</div>
		<div class="phoneIcon"></div>
	</div>
	<!-- <div class="regfooter">
		<button><a href="">在线咨询</a></button>
		<button><a href="postapply.html?type=tax">立即申请</a></button>
	</div> -->
	<script src="${ctx }/static/mui/mui.min.js"></script>
	<script src="${ctx }/static/js/rem.js"></script>
	<script src="${ctx }/static/js/swiper.min.js"></script>
	<script src="${ctx }/static/js/public.js"></script>
	<script type="text/javascript">
		var swiper = null,swiper2 = null,ContentSwiper = null;
		(function(){
			$('.bookkeeping').show();
			
			$('.btns button').on('touchstart',function(){
				$(this).parent().find('button').removeClass('active');
				$(this).addClass('active');
				var idx = $(this).index();
				$(this).parents('.material').find('.materialList').hide();
				$(this).parents('.material').find('.materialList').eq(idx).show();
				ContentSwiper.update();
			});
			
			// swiper
		 	swiper = new Swiper('.navswiper', {
		      	slidesPerView: 2,
		      	freeMode: true,
		      	on:{
				    tap: function(event){
				    	$('.mainTop .navswiper .swiper-slide').removeClass('active');
				    	$(swiper.clickedSlide).addClass('active');
				    	var tindex = swiper.activeIndex;
				    	var le = swiper.slides.length;
				    	swiper2.slideTo(this.clickedIndex,1000,false);
				    	ContentSwiper.slideTo(this.clickedIndex,1000,false);
						ContentSwiper.update();
				    	if(le == 7){
				    		
				    	}
				    },
				},
		    });
		    
	        swiper2 = new Swiper('.gallery-thumbs', {
	      	  	spaceBetween: 50,
		      	allowTouchMove:false
		    });
	
			ContentSwiper = new Swiper('#regContentBox',{
		      	allowTouchMove:false,
		      	autoHeight: true,
			});
			
			setTimeout(function(){
				ContentSwiper.update();
			},50)
			
		})()
		
	</script>
</body>
</html>