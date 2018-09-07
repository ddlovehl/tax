package com.ebuy.tax.user.api.user.vo;

import io.swagger.annotations.ApiModelProperty;

public class GetImgCodeVo {

	//手机唯一标识
	@ApiModelProperty(value="设备ID")
	private String deviceId;
	
	public String getDeviceId() {
		return deviceId;
	}
	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}
	
}
