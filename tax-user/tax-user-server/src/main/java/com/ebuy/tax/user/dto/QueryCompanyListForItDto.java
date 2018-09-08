package com.ebuy.tax.user.dto;

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
@ApiModel(value="获取我的公司--邀请列表接口返回数据")
@Data
public class QueryCompanyListForItDto {

    /**
     *  公司id
     */
    @ApiModelProperty(value="公司id",name="companyId")
    private String companyId;

    /**
     *  公司名称
     */
    @ApiModelProperty(value="公司名称",name="companyName")
    private String companyName;

}
