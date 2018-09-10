package com.ebuy.tax.user.api.company.entity;


import java.io.Serializable;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableField;
import com.ebuy.tax.common.entity.SuperEntity;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 公司表entity
 * </p>
 *
 * @author hdq
 * @since 2018-09-07
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel
@TableName("tax_company")
public class Company extends SuperEntity<Company> {

private static final long serialVersionUID = 1L;

    /**
    * 公司id
    */
    private String id;
    /**
    * 公司名称
    */
    @TableField("company_name")
    private String companyName;
    /**
    *  公司电话
    */
    @TableField("company_tel")
    private String companyTel;
    /**
    * 公司规模（A:微型企业（20人以下）；B:小型企业(20-99人)；C:中型企业(100-299人)；D:大型企业(300人以上)；)
    */
    @TableField("company_scope")
    private String companyScope;
    /**
    * 公司简称
    */
    @TableField("company_name_short")
    private String companyNameShort;
    /**
    * 法人代表姓名
    */
    @TableField("legal_name")
    private String legalName;
    /**
    * 法人代表电话
    */
    @TableField("legal_mobile")
    private String legalMobile;
    /**
    * 税务登记号
    */
    @TableField("tax_reg_no")
    private String taxRegNo;
    /**
    * 企业营业执照号
    */
    @TableField("business_license_no")
    private String businessLicenseNo;
    /**
    * 公司中间图片附件ids，（多张逗号分隔）
    */
    @TableField("certificate_pic_attach_ids")
    private String certificatePicAttachIds;
    /**
    * 负责人证件正面附件id
    */
    @TableField("legal_certificate_front__attach_id")
    private String legalCertificateFrontAttachId;
    /**
    * 负责人证件反面附件id
    */
    @TableField("legal_certificate_back__attach_id")
    private String legalCertificateBackAttachId;
    /**
    * 公司成立时间
    */
    @TableField("build_time")
    private String buildTime;
    /**
    * 所在地（省）
    */
    @TableField("location_province")
    private String locationProvince;
    /**
    * 所在地（市）
    */
    @TableField("location_city")
    private String locationCity;
    /**
    * 所在地（县、区）
    */
    @TableField("location_county")
    private String locationCounty;
    /**
    * 所在地 详细地址
    */
    @TableField("location_detail")
    private String locationDetail;
    /**
    * 纳税性质
    */
    @TableField("pay_tax_property")
    private String payTaxProperty;
    /**
    * 行业id
    */
    @TableField("industry_id")
    private String industryId;
    /**
    * 官方网站
    */
    @TableField("official_website")
    private String officialWebsite;
    /**
    * 业务负责人id
    */
    @TableField("bear_id")
    private String bearId;
    /**
    * 业务负责人姓名
    */
    @TableField("bear_name")
    private String bearName;
    /**
    * 业务负责人手机号
    */
    @TableField("bear_mobile")
    private String bearMobile;
    /**
    * 业务负责人职位
    */
    @TableField("bear_position")
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
    @TableField("is_default")
    private Integer isDefault;
    /**
    * 是否删除（0正常 9删除）
    */
    @TableField("is_del")
    private Integer isDel;
    @TableField("create_time")
    private Date createTime;
    @TableField("update_time")
    private Date updateTime;


    @Override
    protected Serializable pkVal() {
                return this.id;
            }

}
