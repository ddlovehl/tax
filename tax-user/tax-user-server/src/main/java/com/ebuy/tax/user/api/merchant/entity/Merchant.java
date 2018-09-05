package com.ebuy.tax.user.api.merchant.entity;


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
 * 
 * </p>
 *
 * @author hdq
 * @since 2018-09-05
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("tax_merchant")
public class Merchant extends SuperEntity<Merchant> {

private static final long serialVersionUID = 1L;

    /**
    * å•†æˆ·ç¼–å·å”¯ä¸€æ ‡è¯†
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
    * æœåŠ¡ç±»åž‹(å¤šä¸ªè‹±æ–‡é€—å·åˆ†éš”ï¼›A:æ³¨å†Œå…¬å¸ã€B:ä»£ç†è®°è´¦ã€C:å…¬å¸å˜æ›´ã€D:ç¨Žæ”¶ç­¹åˆ’)
    */
    @TableField("service_type")
    private String serviceType;
    /**
    * å•†æˆ·æ¥æº
    */
    @TableField("merchant_source")
    private String merchantSource;
    /**
    * å•†æˆ·çŠ¶æ€(1:æ½œåœ¨å•†æˆ·;2:æ­£å¼å•†æˆ·;3:æš‚åœå•†æˆ·)
    */
    @TableField("merchant_status")
    private Integer merchantStatus;
    /**
    * æ‰€æœ‰è€…ç”¨æˆ·id
    */
    @TableField("allot_user_id")
    private String allotUserId;
    /**
    * æ‰€æœ‰è€…ç”¨æˆ·å§“å
    */
    @TableField("allot_user_name")
    private String allotUserName;
    /**
    * æ”¶æ¬¾æ–¹å¼(WX:å¾®ä¿¡ZFB:æ”¯ä»˜å®WY:ç½‘é“¶XJ:çŽ°é‡‘)
    */
    @TableField("receive_type")
    private String receiveType;
    /**
    * æ”¶æ¬¾æ¡æ¬¾ï¼ˆ1:æœˆç»“ï¼‰
    */
    @TableField("receive_clause")
    private Integer receiveClause;
    /**
    * å®¡æ ¸çŠ¶æ€(1:å¾…æäº¤2:å¾…å®¡æ ¸3:å·²å®¡æ ¸)
    */
    @TableField("audit_status")
    private Integer auditStatus;
    /**
    * å¤‡æ³¨
    */
    private String remark;
    /**
    * é¢„ç•™å­—æ®µ
    */
    private String reseve1;
    /**
    * é¢„ç•™å­—æ®µ
    */
    private String reseve2;
    /**
    * é¢„ç•™å­—æ®µ
    */
    private String reseve3;
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
