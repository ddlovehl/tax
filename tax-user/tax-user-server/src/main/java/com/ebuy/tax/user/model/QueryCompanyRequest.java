package com.ebuy.tax.user.model;

import com.baomidou.mybatisplus.annotation.TableField;
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
@ApiModel(value="获取公司信息接口接收参数封装")
@Data
public class QueryCompanyRequest {

    /**
     * 公司id
     */
    @Validator(isEmpty = false,maxLength = 32,description = "公司id")
    @ApiModelProperty(value="公司id",name="companyId")
    private String companyId;
}
