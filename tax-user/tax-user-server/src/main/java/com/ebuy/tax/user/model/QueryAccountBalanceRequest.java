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
@ApiModel(value="获取我的账户余额接口接收参数封装")
@Data
public class QueryAccountBalanceRequest {

    /**
     *  用户id
     */
    @ApiModelProperty(value="用户id",name="userId")
    private String userId;

}
