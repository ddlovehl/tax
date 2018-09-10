package com.ebuy.tax.user.api.customer.entity;


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
 * å®¢æˆ·è¡¨
 * </p>
 *
 * @author hdq
 * @since 2018-09-07
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel
@TableName("tax_customer")
public class Customer extends SuperEntity<Customer> {

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
    * 公司id
    */
    @TableField("company_id")
    private String companyId;
    /**
    * 指派商户id
    */
    @TableField("allot_merchant_id")
    private String allotMerchantId;
    /**
    * 分配客户用户id
    */
    @TableField("allot_kefu_user_id")
    private String allotKefuUserId;
    /**
    * 分配会计用户id
    */
    @TableField("allot_bursar_user_id")
    private String allotBursarUserId;
    /**
    * 分配商户状态（1：已分配，2：未分配）
    */
    @TableField("allot_merchant_status")
    private Integer allotMerchantStatus;
    /**
    * 分配客服状态（1：待分配；2：已分配）
    */
    @TableField("allot_kefu_status")
    private Integer allotKefuStatus;
    /**
    * 分配会计状态（1:未分配；2：已分配）
    */
    @TableField("allot_bursar_stauts")
    private Integer allotBursarStauts;
    /**
    * 客户状态（0:;1:潜在客户；2:正式客户）
    */
    @TableField("customer_status")
    private Integer customerStatus;
    /**
    * 客户来源
    */
    @TableField("customer_source")
    private String customerSource;
    /**
    * 预留字段1
    */
    private String reserve1;
    /**
    * 预留字段2
    */
    private String reserve2;
    /**
    * 预留字段3
    */
    private String reserve3;
    /**
    * 备注
    */
    private String remark;
    /**
    * 创建日期
    */
    @TableField("create_time")
    private Date createTime;
    /**
    * 更新日期
    */
    @TableField("update_time")
    private Date updateTime;


    @Override
    protected Serializable pkVal() {
                return this.id;
            }

}
