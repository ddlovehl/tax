package com.ebuy.tax.user.api.user.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class GetImgCodeResp {

	@ApiModelProperty(value="图片验证码ID")
	private String verifyId;
	
	@ApiModelProperty(value="图片验证码base64字符串")
	private String imgBase64Str;
	
	
}
