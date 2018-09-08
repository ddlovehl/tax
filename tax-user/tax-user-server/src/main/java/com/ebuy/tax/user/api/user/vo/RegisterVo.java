package com.ebuy.tax.user.api.user.vo;

public class RegisterVo {

	//手机号
	private String mobile;
	//短信验证码
	private String smsCode;
	//openid
	private String openId;
	
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getSmsCode() {
		return smsCode;
	}
	public void setSmsCode(String smsCode) {
		this.smsCode = smsCode;
	}
	public String getOpenId() {
		return openId;
	}
	public void setOpenId(String openId) {
		this.openId = openId;
	}
}
