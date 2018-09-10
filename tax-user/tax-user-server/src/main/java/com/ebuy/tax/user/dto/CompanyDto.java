package com.ebuy.tax.user.dto;


import com.ebuy.tax.common.entity.SuperEntity;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 公司表entity
 * </p>
 *
 * @author hdq
 * @since 2018-09-07
 */
@Data
@Accessors(chain = true)
@ApiModel
public class CompanyDto {

private static final long serialVersionUID = 1L;

    /**
    * 公司id
    */
    private String id;
    /**
    * 公司名称
    */
    private String companyName;
    /**
    *  公司电话
    */
    private String companyTel;
    /**
    * 公司规模（A:微型企业（20人以下）；B:小型企业(20-99人)；C:中型企业(100-299人)；D:大型企业(300人以上)；)
    */
    private String companyScope;
    /**
    * 公司简称
    */
    private String companyNameShort;
    /**
    * 法人代表姓名
    */
    private String legalName;
    /**
    * 法人代表电话
    */
    private String legalMobile;
    /**
    * 税务登记号
    */
    private String taxRegNo;
    /**
    * 企业营业执照号
    */
    private String businessLicenseNo;
    /**
    * 公司中间图片附件ids，（多张逗号分隔）
    */
    private String certificatePicAttachIds;
    /**
    * 负责人证件正面附件id
    */
    private String legalCertificateFrontAttachId;
    /**
    * 负责人证件反面附件id
    */
    private String legalCertificateBackAttachId;
    /**
    * 公司成立时间
    */
    private String buildTime;
    /**
    * 所在地（省）
    */
    private String locationProvince;
    /**
    * 所在地（市）
    */
    private String locationCity;
    /**
    * 所在地（县、区）
    */
    private String locationCounty;
    /**
    * 所在地 详细地址
    */
    private String locationDetail;
    /**
    * 纳税性质
    */
    private String payTaxProperty;
    /**
    * 行业id
    */
    private String industryId;
    /**
    * 官方网站
    */
    private String officialWebsite;
    /**
    * 业务负责人id
    */
    private String bearId;
    /**
    * 业务负责人姓名
    */
    private String bearName;
    /**
    * 业务负责人手机号
    */
    private String bearMobile;
    /**
    * 业务负责人职位
    */
    private String bearPosition;
    /**
    * 预留字段1
    */
    private String reseve1;
    /**
    * 预留字段2
    */
    private String reseve2;
    /**
    * 预留字段3
    */
    private String reseve3;
    /**
    * 备注
    */
    private String remark;
    /**
    * 是否默认
    */
    private Integer isDefault;
    /**
    * 是否删除（0正常 9删除）
    */
    private Integer isDel;
    private Date createTime;
    private Date updateTime;

    /**
     * 用户id
     */
    private String userId;

}
