package com.ebuy.tax.user.api.accountDetail.entity;


import java.io.Serializable;
import java.math.BigDecimal;
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
@TableName("tax_account_detail")
public class AccountDetail extends SuperEntity<AccountDetail> {

private static final long serialVersionUID = 1L;

    /**
    * å”¯ä¸€Id
    */
    private String id;
    /**
    * ç”¨æˆ·id
    */
    @TableField("user_id")
    private String userId;
    /**
    * å‘ç”Ÿé‡‘é¢
    */
    @TableField("occur_amt")
    private BigDecimal occurAmt;
    /**
    * é‡‘é¢æ–¹å‘ï¼ˆ1:æ”¶å…¥ï¼›-1:æ”¯å‡ºï¼‰
    */
    @TableField("amt_dir")
    private Integer amtDir;
    /**
    * å½“å‰ä½™é¢
    */
    @TableField("curr_bal")
    private BigDecimal currBal;
    /**
    * äº¤æ˜“ç±»åž‹
    */
    private String type;
    /**
    * å‘ç”Ÿé‡‘é¢æè¿°
    */
    @TableField("occur_type_desc")
    private String occurTypeDesc;
    /**
    * å‘ç”Ÿé‡‘é¢æ—¥æœŸ
    */
    @TableField("occur_time")
    private Date occurTime;
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
    * å¤‡æ³¨
    */
    private String remark;
    @TableField("create_time")
    private Date createTime;
    @TableField("update_time")
    private Date updateTime;


    @Override
    protected Serializable pkVal() {
                return this.id;
            }

}
