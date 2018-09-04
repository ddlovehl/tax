package com.ebuy.tax.user.api.user_account.entity;


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
 * è´¦æˆ·è¡¨
 * </p>
 *
 * @author hdq
 * @since 2018-09-04
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("tax_user_account")
public class UserAccount extends SuperEntity<UserAccount> {

private static final long serialVersionUID = 1L;

    /**
    * å”¯ä¸€æ ‡è¯†
    */
    private String id;
    /**
    * ç”¨æˆ·id
    */
    @TableField("user_id")
    private String userId;
    /**
    * è´¦æˆ·ä½™é¢
    */
    private BigDecimal balance;
    /**
    * å¤‡æ³¨
    */
    private String remak;
    /**
    * çŠ¶æ€(0:æ­£å¸¸ï¼Œ9å†»ç»“)
    */
    private Integer status;
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
    * åˆ›å»ºæ—¶é—´
    */
    @TableField("create_time")
    private Date createTime;
    /**
    * æ›´æ–°æ—¶é—´
    */
    @TableField("update_time")
    private Date updateTime;


    @Override
    protected Serializable pkVal() {
                return this.id;
            }

}
