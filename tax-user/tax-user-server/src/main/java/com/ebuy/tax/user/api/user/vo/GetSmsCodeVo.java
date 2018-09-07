package com.ebuy.tax.user.api.user.vo;

import io.swagger.annotations.ApiModelProperty;

public class GetSmsCodeVo {

	//手机号
	@ApiModelProperty(value="手机号码")
	private String mobile;
	//图形验证码
	@ApiModelProperty(value="图形验证码")
	private String imgCode;
	//手机唯一标识
	@ApiModelProperty(value="设备ID")
	private String deviceId;
	
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getImgCode() {
		return imgCode;
	}
	public void setImgCode(String imgCode) {
		this.imgCode = imgCode;
	}
	public String getDeviceId() {
		return deviceId;
	}
	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}
	
}
