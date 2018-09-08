<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../taglibs.jsp"%>
<html lang="zh">
<head>
	<meta charset="UTF-8" />
	<meta name="viewport" content="width=device-width,initial-scale=1.0,maximum-scale=1.0,minimum-scale=1.0,user-scalable=no" />
	<meta http-equiv="X-UA-Compatible" content="ie=edge" />
    <meta name="referrer" content="never">
	<title>公司变更</title>
	<style type="text/css">
		
	</style>
</head>
<body>
	<div class="header header1">
		<i class="back"></i>
		<h2>公司变更</h2>
	</div>
	<div class="main regconpany">
		<div class="mainTop">
			<div class="swiper-container navswiper">
			    <div class="swiper-wrapper">
			      	<div class="swiper-slide active">公司名称</div>
		    	  	<div class="swiper-slide">公司地址</div>
			      	<div class="swiper-slide">股权变更</div>
			      	<div class="swiper-slide">经营范围</div>
			      	<div class="swiper-slide">资金变更</div>
			      	<div class="swiper-slide">法人变更</div>
			      	<div class="swiper-slide">注销</div>
			    </div>
		  	</div>
	  	  	<div class="swiper-container gallery-thumbs">
			    <div class="swiper-wrapper">
		            <div class="swiper-slide" style="background-image:url(${ctx}/static/img/companychange/companychange1.png)"></div>
		            <div class="swiper-slide" style="background-image:url(${ctx}/static/img/companychange/companychange2.png)"></div>
		            <div class="swiper-slide" style="background-image:url(${ctx}/static/img/companychange/companychange3.png)"></div>
		            <div class="swiper-slide" style="background-image:url(${ctx}/static/img/companychange/companychange4.png)"></div>
		            <div class="swiper-slide" style="background-image:url(${ctx}/static/img/companychange/companychange5.png)"></div>
		            <div class="swiper-slide" style="background-image:url(${ctx}/static/img/companychange/companychange6.png)"></div>
		            <div class="swiper-slide" style="background-image:url(${ctx}/static/img/companychange/companychange7.png)"></div>
			    </div>
		  	</div>
		</div>

		<div class="RegContentBox companychange">
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
							<ul class="materialList">
								<li>营业执照正副本。</li>
								<li>公章。</li>
								<li>法人身份证。</span></li>
								<li>公司章程。</li>
								<li>3-5个公司名称。</li>
							</ul>
						</div>
						<div class="Certificates homeblock">
							<h2 class="icon1Title">你所获得</h2>
							<ul class="ImgList">
								<li>
									<i style="background-image: url(${ctx}/static/img/regcompany/img1.png);"></i>
									<span>营业执照正本</span>
								</li>
								<li>
									<i style="background-image: url(${ctx}/static/img/regcompany/img2.png);"></i>
									<span>营业执照副本</span>
								</li>
								<li>
									<i style="background-image: url(${ctx}/static/img/regcompany/img3.png);"></i>
									<span>公司章程</span>
								</li>
								<li>
									<i style="background-image: url(${ctx}/static/img/regcompany/img4.png);"></i>
									<span>公司印章及印鉴留存卡</span>
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
							<ul class="materialList">
								<li>营业执照正副本。</li>
								<li>公章。</li>
								<li>法人身份证。</span></li>
								<li>注册用房屋产权复印件或房屋租赁合同原件。</li>
								<li>租金发票原件。</li>
								<li>住所证明页。</li>
							</ul>
						</div>
						<div class="Certificates homeblock">
							<h2 class="icon1Title">你所获得</h2>
							<ul class="ImgList">
								<li>
									<i style="background-image: url(${ctx}/static/img/regcompany/img2.png);"></i>
									<span>营业执照正本</span>
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
							<ul class="materialList">
								<li>营业执照正副本。</li>
								<li>公章。</li>
								<li>全体新旧股东身份证复印件。</span></li>
								<li>验资报告。</li>
							</ul>
						</div>
						<div class="Certificates homeblock">
							<h2 class="icon1Title">你所获得</h2>
							<ul class="ImgList">
								<li>
									<i style="background-image: url(${ctx}/static/img/regcompany/img2.png);"></i>
									<span>营业执照正本</span>
								</li>
								<li>
									<i style="background-image: url(${ctx}/static/img/regcompany/img4.png);"></i>
									<span>司印章及印鉴留存卡</span>
								</li>
								<li>
									<i style="background-image: url(${ctx}/static/img/regcompany/img3.png);"></i>
									<span>公司章程</span>
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
							<ul class="materialList">
								<li>营业执照正副本。</li>
								<li>公章。</li>
								<li>法人身份证。</span></li>
								<li>变更后经营范围。</li>
								<li>公司章程。</li>
							</ul>
						</div>
						<div class="Certificates homeblock">
							<h2 class="icon1Title">你所获得</h2>
							<ul class="ImgList">
								<li>
									<i style="background-image: url(${ctx}/static/img/regcompany/img2.png);"></i>
									<span>营业执照副本</span>
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
							<ul class="materialList">
								<li>营业执照正副本。</li>
								<li>公章。</li>
								<li>公司章程修正案。</span></li>
								<li>验资证明。</li>
								<li>公司变更登记申请书。</li>
								<li>司股东出资情况表。</li>
							</ul>
						</div>
						<div class="Certificates homeblock">
							<h2 class="icon1Title">你所获得</h2>
							<ul class="ImgList">
								<li>
									<i style="background-image: url(${ctx}/static/img/regcompany/img2.png);"></i>
									<span>营业执照副本</span>
								</li>
								<li>
									<i style="background-image: url(${ctx}/static/img/regcompany/img4.png);"></i>
									<span>司印章及印鉴留存卡</span>
								</li>
								<li>
									<i style="background-image: url(${ctx}/static/img/regcompany/img3.png);"></i>
									<span>公司章程</span>
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
							<ul class="materialList">
								<li>营业执照正副本。</li>
								<li>公章。</li>
								<li>法人身份证。</span></li>
								<li>全体股东身份证复印件。</li>
							</ul>
						</div>
						<div class="Certificates homeblock">
							<h2 class="icon1Title">你所获得</h2>
							<ul class="ImgList">
								<li>
									<i style="background-image: url(${ctx}/static/img/regcompany/img2.png);"></i>
									<span>营业执照副本</span>
								</li>
								<li>
									<i style="background-image: url(${ctx}/static/img/regcompany/img4.png);"></i>
									<span>司印章及印鉴留存卡</span>
								</li>
								<li>
									<i style="background-image: url(${ctx}/static/img/regcompany/img3.png);"></i>
									<span>公司章程</span>
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
							<ul class="materialList">
								<li>营业执照正副本。</li>
								<li>公章。</li>
								<li>全部财务资料。</li>
							</ul>
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
		<button><a href="">立即申请</a></button>
	</div> -->
	<script src="${ctx}/static/mui/mui.min.js"></script>
	<script src="${ctx}/static/js/rem.js"></script>
	<script src="${ctx}/static/js/swiper.min.js"></script>
	<script src="${ctx}/static/js/public.js"></script>
	<script type="text/javascript">
		var swiper = null,swiper2 = null,ContentSwiper = null;
		(function(){
			$('.companychange').show();
		 	swiper = new Swiper('.navswiper', {
		      	slidesPerView: 5,
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