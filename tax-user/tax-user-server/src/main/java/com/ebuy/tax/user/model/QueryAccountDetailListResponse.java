package com.ebuy.tax.user.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.ebuy.tax.common.entity.PageResult;
import com.ebuy.tax.user.dto.AccountDetailDto;
import com.ebuy.tax.user.dto.QueryCompanyListForCtDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @Project parent_parent
 * @Package com.jsonmedia.shop.api.user.model
 * @Author hdq
 * @Date 2018/7/25 18:40
 * @Description
 */
@ApiModel(value="获取我的账户详情列表接口返回数据封装")
@Data
public class QueryAccountDetailListResponse {

    /**
     * 详情列表
     */
    @ApiModelProperty(value = "详情列表", name = "result")
    private List<AccountDetailDto> result;

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

    public QueryAccountDetailListResponse(PageResult pr, String pageNo, String pageSize){
        this.result = (List<AccountDetailDto>)pr.getResult();
        this.count = pr.getCount();
        this.pageNo = pageNo;
        this.pageSize = pageSize;
    }
}
