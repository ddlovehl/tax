package com.ebuy.tax.user.model;

import com.ebuy.tax.common.annotations.Validator;
import com.ebuy.tax.common.utils.RegexUtils;
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
@ApiModel(value="获取我的账户详情列表接口接收参数封装")
@Data
public class QueryAccountDetailListRequest {

    /**
     *  用户id
     */
    @ApiModelProperty(value="用户id",name="userId")
    private String userId;

    /**
     * 页码
     */
    @Validator(regexExpression = RegexUtils.REGEX_PAGENO,description = "页码")
    @ApiModelProperty(value="页码",name="pageNo")
    private String pageNo;

    /**
     * 页面大小
     */
    @Validator(regexExpression = RegexUtils.REGEX_PAGESIZE,description = "页面大小")
    @ApiModelProperty(value="页面大小",name="pageSize")
    private String pageSize;
}
