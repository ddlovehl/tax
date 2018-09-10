package com.ebuy.tax.user.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @Project parent_parent
 * @Package com.jsonmedia.shop.api.user.model
 * @Author hdq
 * @Date 2018/7/25 18:40
 * @Description
 */
@ApiModel(value = "获取我的账户余额接口返回数据封装")
@Data
public class QueryAccountBalanceResponse {

    /**
     * 余额
     */
    @ApiModelProperty(value = "余额", name = "balance")
    private String balance;

}
