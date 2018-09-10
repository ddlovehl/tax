package com.ebuy.tax.user.model;

import com.ebuy.tax.common.annotations.Validator;
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
@ApiModel(value="获取我的公司--邀请列表接口接受参数封装")
@Data
public class QueryCompanyListForItRequest {

    /**
     * 用户id
     */
    @Validator(isEmpty = false,maxLength = 32,description = "用户id")
    @ApiModelProperty(value="用户id",name="userId")
    private String userId;
}
