package com.ebuy.tax.user.api.userAccount.entity;


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
 * è´¦æˆ·è¡¨
 * </p>
 *
 * @author hdq
 * @since 2018-09-07
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel
@TableName("tax_user_account")
public class UserAccount extends SuperEntity<UserAccount> {

private static final long serialVersionUID = 1L;

    /**
    * id
    */
    private String id;
    /**
    * 用户id
    */
    @TableField("user_id")
    private String userId;
    /**
    * 余额
    */
    private BigDecimal balance;
    /**
    * 备注
    */
    private String remak;
    /**
    * 状态(0:正常，9冻结)
    */
    private Integer status;
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
    * 创建时间
    */
    @TableField("create_time")
    private Date createTime;
    /**
    * 更新时间
    */
    @TableField("update_time")
    private Date updateTime;


    @Override
    protected Serializable pkVal() {
                return this.id;
            }

}
