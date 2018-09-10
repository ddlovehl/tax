package com.ebuy.tax.user.api.accountDetail.entity;


import java.io.Serializable;
import java.math.BigDecimal;
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
 * 
 * </p>
 *
 * @author hdq
 * @since 2018-09-07
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel
@TableName("tax_account_detail")
public class AccountDetail extends SuperEntity<AccountDetail> {

private static final long serialVersionUID = 1L;

    /**
    * Id
    */
    private String id;
    /**
    * 用户id
    */
    @TableField("user_id")
    private String userId;
    /**
    * 发生金额
    */
    @TableField("occur_amt")
    private BigDecimal occurAmt;
    /**
    * 金额方向（1:收入；-1:支出）
    */
    @TableField("amt_dir")
    private Integer amtDir;
    /**
    * 当前余额
    */
    @TableField("curr_bal")
    private BigDecimal currBal;
    /**
    * 交易类型
    */
    private String type;
    /**
    * 发生金额描述
    */
    @TableField("occur_type_desc")
    private String occurTypeDesc;
    /**
    * 发生金额日期
    */
    @TableField("occur_time")
    private Date occurTime;
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
    @TableField("create_time")
    private Date createTime;
    @TableField("update_time")
    private Date updateTime;


    @Override
    protected Serializable pkVal() {
                return this.id;
            }

}
