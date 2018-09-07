package com.ebuy.tax.user.api.user.vo;

import io.swagger.annotations.ApiModelProperty;

public class WxIsBindMobileVo {

	//openid
	@ApiModelProperty(value="微信openId")
	private String openId;
	public String getOpenId() {
		return openId;
	}
	public void setOpenId(String openId) {
		this.openId = openId;
	}
}
