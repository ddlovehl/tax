

$('#GetImgCode').on('touchstart',function(){
	var Rom = parseInt(Math.random() * 10000);
	var sr = 'img/login/imgcode.png?qwe=';
	$(this).attr('src',sr+Rom);
});

var SMSCodeTime = 10;
var SMSCodeStatus = true;
$('#GetSMSCode').on('touchstart',function(){
	if(SMSCodeStatus){
		var phone = $('#phone').val();
		var imgcode = $('#ImgCode').val();
		var z_phone = /^1{3|5|6|7|8|9}{1}\d{9}$/;
		
		if(!phone){
			mui.toast('请输入手机号');
			return false;
		}
		if(!z_phone.test(phone)){
			mui.toast('请输入正确格式的手机号');
			return false;
		}
		if(!imgcode && imgcode.length != 4){
			mui.toast('请输入图片验证码');
			return false;
		}
		
		CodeTime(SMSCodeTime,this);
	}
});

function CodeTime(number,dom){
	SMSCodeStatus = false;
	var Time = setInterval(function(){
		--number;
		$(dom).text(number+'s');
		if(number <= 0){
			clearInterval(Time);
			$(dom).text('获取验证码');
			SMSCodeStatus = true;
		}
	},1000);
}

$('#check').on('touchstart',function(){
	$(this).toggleClass('check');
});

$('#Login').on('touchstart',function(){
//	var phone = $('#phone').val();
//	var smscode = $('#SMSCode').val();
//	var z_phone = /^1{3|5|6|7|8|9}{1}\d{9}$/;
//	if($('#check').hasClass('check')){
//		mui.toast('请阅读并同意用户协议');
//		return false;
//	}
//	
//	if(!phone){
//		mui.toast('请输入手机号');
//		return false;
//	}
//	if(!z_phone.test(phone)){
//		mui.toast('请输入正确格式的手机号');
//		return false;
//	}
//	if(!smscode && smscode.length != 4){
//		mui.toast('请输入短信验证码');
//		return false;
//	}
	
	location.href = 'index.html';
//	mui.toast('登录成功');
	
})

//$('#UserAgree')
//$('#PrivacyAgree')

