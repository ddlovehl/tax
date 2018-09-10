package com.ebuy.tax.user.model;

import com.ebuy.tax.common.entity.PageResult;
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
@ApiModel(value = "获取我的公司--创建列表接口返回数据封装")
@Data
public class QueryCompanyListForCtResponse {

    /**
     * 我的公司列表
     */
    @ApiModelProperty(value = "我的公司列表", name = "QueryCompanyList")
    private List<QueryCompanyListForCtDto> result;

    /**
     * 总行数
     */
    @ApiModelProperty(value = "总行数", name = "count")
    private Long count;

    /**
     * 页码
     */
    @ApiModelProperty(value="页码",name="pageNo")
    protected String pageNo;

    /**
     * 页面大小
     */
    @ApiModelProperty(value="页面大小",name="pageSize")
    protected String pageSize;

    public QueryCompanyListForCtResponse(PageResult pr, String pageNo, String pageSize){
        this.result = (List<QueryCompanyListForCtDto>)pr.getResult();
        this.count = pr.getCount();
        this.pageNo = pageNo;
        this.pageSize = pageSize;
    }
}
