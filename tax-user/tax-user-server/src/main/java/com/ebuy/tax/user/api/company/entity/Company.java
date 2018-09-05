package com.ebuy.tax.user.api.company.entity;


import java.io.Serializable;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableField;
import com.ebuy.tax.common.entity.SuperEntity;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * å…¬å¸è¡¨
 * </p>
 *
 * @author hdq
 * @since 2018-09-05
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("tax_company")
public class Company extends SuperEntity<Company> {

private static final long serialVersionUID = 1L;

    /**
    * å”¯ä¸€æ ‡è¯†
    */
    private String id;
    /**
    * å…¬å¸åç§°
    */
    @TableField("company_name")
    private String companyName;
    /**
    * å…¬å¸ç”µè¯
    */
    @TableField("company_tel")
    private String companyTel;
    /**
    * å…¬å¸è§„æ¨¡ï¼ˆA:å¾®åž‹ä¼ä¸šï¼ˆ20äººä»¥ä¸‹ï¼‰ï¼›B:å°åž‹ä¼ä¸š(20-99äºº)ï¼›C:ä¸­åž‹ä¼ä¸š(100-299äºº)ï¼›D:å¤§åž‹ä¼ä¸š(300äººä»¥ä¸Š)ï¼›)
    */
    @TableField("company_scope")
    private String companyScope;
    /**
    * å…¬å¸ç®€ç§°
    */
    @TableField("company_name_short")
    private String companyNameShort;
    /**
    * æ³•äººä»£è¡¨å§“å
    */
    @TableField("legal_name")
    private String legalName;
    /**
    * æ³•äººä»£è¡¨ç”µè¯
    */
    @TableField("legal_mobile")
    private String legalMobile;
    /**
    * ç¨ŽåŠ¡ç™»è®°å·
    */
    @TableField("tax_reg_no")
    private String taxRegNo;
    /**
    * ä¼ä¸šè¥ä¸šæ‰§ç…§å·
    */
    @TableField("business_license_no")
    private String businessLicenseNo;
    /**
    * å…¬å¸è¯ä»¶å›¾ç‰‡é™„ä»¶idsï¼ˆå¤šå¼ é€—å·åˆ†éš”ï¼‰
    */
    @TableField("certificate_pic_attach_ids")
    private String certificatePicAttachIds;
    /**
    * è´Ÿè´£äººè¯ä»¶æ­£é¢é™„ä»¶id
    */
    @TableField("legal_certificate_front__attach_id")
    private String legalCertificateFrontAttachId;
    /**
    * è´Ÿè´£äººè¯ä»¶åé¢é™„ä»¶id
    */
    @TableField("legal_certificate_back__attach_id")
    private String legalCertificateBackAttachId;
    /**
    * å…¬å¸æˆç«‹æ—¶é—´
    */
    @TableField("build_time")
    private String buildTime;
    /**
    * æ‰€åœ¨åœ°-çœ
    */
    @TableField("location_province")
    private String locationProvince;
    /**
    * æ‰€åœ¨åœ°-å¸‚
    */
    @TableField("location_city")
    private String locationCity;
    /**
    * æ‰€åœ¨åœ°-åŽ¿ï¼ˆåŒºï¼‰
    */
    @TableField("location_county")
    private String locationCounty;
    /**
    * æ‰€åœ¨åœ°è¯¦ç»†åœ°å€
    */
    @TableField("location_detail")
    private String locationDetail;
    /**
    * çº³ç¨Žæ€§è´¨ï¼ˆA:å°è§„æ¨¡;B:ä¸€èˆ¬çº³ç¨Žäºº;ï¼‰
    */
    @TableField("pay_tax_property")
    private String payTaxProperty;
    /**
    * è¡Œä¸šid
    */
    @TableField("industry_id")
    private String industryId;
    /**
    * å®˜æ–¹ç½‘ç«™
    */
    @TableField("official_website")
    private String officialWebsite;
    /**
    * ä¸šåŠ¡è´Ÿè´£äººid
    */
    @TableField("bear_id")
    private String bearId;
    /**
    * ä¸šåŠ¡è´Ÿè´£äººå§“å
    */
    @TableField("bear_name")
    private String bearName;
    /**
    * ä¸šåŠ¡è´£ä»»æ‰‹æœºå·
    */
    @TableField("bear_mobile")
    private String bearMobile;
    /**
    * ä¸šåŠ¡è´Ÿè´£äººèŒä½
    */
    @TableField("bear_position")
    private String bearPosition;
    /**
    * é¢„ç•™å­—æ®µ1
    */
    private String reseve1;
    /**
    * é¢„ç•™å­—æ®µ2
    */
    private String reseve2;
    /**
    * é¢„ç•™å­—æ®µ3
    */
    private String reseve3;
    /**
    * å¤‡æ³¨
    */
    private String remark;
    /**
    * æ˜¯å¦é»˜è®¤(0:å¦ï¼›1:æ˜¯)
    */
    @TableField("is_default")
    private Integer isDefault;
    /**
    * æ˜¯å¦åˆ é™¤(0:æ­£å¸¸,9:åˆ é™¤)
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
