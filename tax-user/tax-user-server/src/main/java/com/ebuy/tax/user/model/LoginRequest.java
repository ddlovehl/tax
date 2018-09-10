package com.ebuy.tax.user.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Project parent_parent
 * @Package com.jsonmedia.shop.api.user.model
 * @Author hdq
 * @Date 2018/7/25 18:40
 * @Description
 */
@ApiModel(value="登陆接口接收参数封装")
@Data
public class LoginRequest {

    /**
     *  手机号
     */
    @ApiModelProperty(value="手机号",name="mobile")
    private String mobile;

    /**
     *  短信码
     */
    @ApiModelProperty(value="短信码",name="smsCode")
    private String smsCode;
}
