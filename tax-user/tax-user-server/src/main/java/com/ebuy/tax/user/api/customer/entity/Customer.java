package com.ebuy.tax.user.api.customer.entity;


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
 * å®¢æˆ·è¡¨
 * </p>
 *
 * @author hdq
 * @since 2018-09-05
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("tax_customer")
public class Customer extends SuperEntity<Customer> {

private static final long serialVersionUID = 1L;

    /**
    * å®¢æˆ·ç¼–å·ï¼šå”¯ä¸€
    */
    private String id;
    /**
    * ç”¨æˆ·id
    */
    @TableField("user_id")
    private String userId;
    /**
    * å…¬å¸id
    */
    @TableField("company_id")
    private String companyId;
    /**
    * æŒ‡æ´¾å•†æˆ·Id
    */
    @TableField("allot_merchant_id")
    private String allotMerchantId;
    /**
    * åˆ†é…å®¢æœç”¨æˆ·id
    */
    @TableField("allot_kefu_user_id")
    private String allotKefuUserId;
    /**
    * åˆ†é…ä¼šè®¡ç”¨æˆ·id
    */
    @TableField("allot_bursar_user_id")
    private String allotBursarUserId;
    /**
    * åˆ†é…å•†æˆ·çŠ¶æ€ï¼ˆ1ï¼šå·²åˆ†é…ï¼Œ2ï¼šæœªåˆ†é…ï¼‰
    */
    @TableField("allot_merchant_status")
    private Integer allotMerchantStatus;
    /**
    * åˆ†é…å®¢æœçŠ¶æ€ï¼ˆ1ï¼šå¾…åˆ†é…ï¼›2ï¼šå·²åˆ†é…ï¼‰
    */
    @TableField("allot_kefu_status")
    private Integer allotKefuStatus;
    /**
    * åˆ†é…ä¼šè®¡çŠ¶æ€ï¼ˆ1:æœªåˆ†é…ï¼›2ï¼šå·²åˆ†é…ï¼‰
    */
    @TableField("allot_bursar_stauts")
    private Integer allotBursarStauts;
    /**
    * å®¢æˆ·çŠ¶æ€ï¼ˆ1:æ½œåœ¨å®¢æˆ·ï¼›2:æ­£å¼å®¢æˆ·ï¼‰
    */
    @TableField("customer_status")
    private Integer customerStatus;
    /**
    * å®¢æˆ·æ¥æº
    */
    @TableField("customer_source")
    private String customerSource;
    /**
    * é¢„ç•™å­—æ®µ
    */
    private String reserve1;
    /**
    * é¢„ç•™å­—æ®µ
    */
    private String reserve2;
    /**
    * é¢„ç•™å­—æ®µ
    */
    private String reserve3;
    /**
    * å¤‡æ³¨
    */
    private String remark;
    /**
    * åˆ›å»ºæ—¥æœŸ
    */
    @TableField("create_time")
    private Date createTime;
    /**
    * æ›´æ–°æ—¥æœŸ
    */
    @TableField("update_time")
    private Date updateTime;


    @Override
    protected Serializable pkVal() {
                return this.id;
            }

}
