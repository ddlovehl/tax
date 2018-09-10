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
@ApiModel(value="编辑公司接口接收参数封装")
@Data
public class UpdateCompanyRequest {

    /**
     * 公司id
     */
    @Validator(isEmpty = false,maxLength = 32,description = "公司id")
    @ApiModelProperty(value="公司id",name="companyId")
    private String companyId;

    /**
     *  公司名称
     */
    @Validator(isEmpty = false,maxLength = 100,description = "公司名称")
    @ApiModelProperty(value="公司名称",name="companyName")
    private String companyName;

    /**
     *  是否默认
     */
    @Validator(maxLength = 1,description = "是否默认")
    @ApiModelProperty(value="是否默认",name="isDefault")
    private String isDefault;

    /**
     * 行业id
     */
    @Validator(isEmpty = false,maxLength = 32,description = "行业id")
    @ApiModelProperty(value="行业id",name="industryId")
    private String industryId;

    /**
     * 所在地（省）
     */
    @Validator(isEmpty = false,maxLength = 20,description = "所在地（省）")
    @ApiModelProperty(value="所在地（省",name="locationProvince")
    private String locationProvince;
    /**
     * 所在地（市）
     */
    @Validator(isEmpty = false,maxLength = 20,description = "所在地（市）")
    @ApiModelProperty(value="所在地（市）",name="locationCity")
    private String locationCity;
    /**
     * 所在地（县、区）
     */
    @Validator(isEmpty = false,maxLength = 20,description = "所在地（县、区）")
    @ApiModelProperty(value="所在地（县、区）",name="locationCounty")
    private String locationCounty;

    /**
     * 公司规模（A:微型企业（20人以下）；B:小型企业(20-99人)；C:中型企业(100-299人)；D:大型企业(300人以上)；)
     */
    @Validator(maxLength = 20,description = "公司规模")
    @ApiModelProperty(value="公司规模",name="companyScope")
    private String companyScope;

    /**
     * 业务负责人职位
     */
    @Validator(maxLength = 100,description = "业务负责人职位")
    @ApiModelProperty(value="业务负责人职位",name="bearPosition")
    private String bearPosition;
}
