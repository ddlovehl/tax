package com.ebuy.tax.user.model;

import com.ebuy.tax.user.dto.QueryCompanyListForCtDto;
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
@ApiModel(value="获取我的公司--创建列表接口返回数据封装")
@Data
public class QueryCompanyListForCtResponse {

    /**
     *  我的公司列表
     */
    @ApiModelProperty(value="我的公司列表",name="QueryCompanyList")
    private List<QueryCompanyListForCtDto> QueryCompanyList;

}
