package com.ebuy.tax.user.model;

import com.ebuy.tax.common.entity.PageResult;
import com.ebuy.tax.user.dto.QueryCompanyListForItDto;
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
@ApiModel(value = "获取我的公司--邀请列表接口返回数据封装")
@Data
public class QueryCompanyListForItResponse {

    /**
     * 我的公司列表
     */
    @ApiModelProperty(value = "我的公司列表", name = "QueryCompanyList")
    private List<QueryCompanyListForItDto> result;

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

    public QueryCompanyListForItResponse(PageResult pr, String pageNo, String pageSize){
        this.result = (List<QueryCompanyListForItDto>)pr.getResult();
        this.count = pr.getCount();
        this.pageSize = pageSize;
    }

}
