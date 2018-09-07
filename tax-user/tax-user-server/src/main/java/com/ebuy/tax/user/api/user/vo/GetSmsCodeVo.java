package com.ebuy.tax.user.api.user.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class GetSmsCodeVo {

	//手机号
	@ApiModelProperty(value="手机号码")
	private String mobile;
	//图形验证码
	@ApiModelProperty(value="图形验证码")
	private String imgCode;
	//手机唯一标识
	@ApiModelProperty(value="图片验证码ID")
	private String verifyId;
}
