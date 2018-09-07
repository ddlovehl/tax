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
@ApiModel(value="获取用户信息接口接受参数封装")
@Data
public class QueryUserInfoRequest {

    /**
     *  手机号
     */
    @ApiModelProperty(value="手机号",name="mobile")
    private String mobile;

}
