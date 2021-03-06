package com.ebuy.tax.user.model;

import com.ebuy.tax.common.annotations.Validator;
import com.ebuy.tax.common.enums.RegexEnum;
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
@ApiModel(value="获取用户信息接接收参数封装")
@Data
public class QueryUserInfoRequest {

    /**
     *  用户id
     */
    @Validator(isNotNull = true,maxLength = 32,description = "用户id")
    @ApiModelProperty(value="用户id",name="userId")
    private String userId;

}
