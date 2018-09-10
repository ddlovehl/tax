package com.ebuy.tax.user.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author hdq
 * @date 2018/9/10 19:46
 * @desc
 */
@Data
public class AccountDetailDto {

    /**
     * Id
     */
    @ApiModelProperty(value="id",name="id")
    private String id;
    /**
     * 用户id
     */
    @ApiModelProperty(value="用户id",name="userId")
    private String userId;
    /**
     * 发生金额
     */
    @ApiModelProperty(value="发生金额",name="occurAmt")
    private BigDecimal occurAmt;
    /**
     * 金额方向（1:收入；-1:支出）
     */
    @ApiModelProperty(value="金额方向（1:收入；-1:支出）",name="amtDir")
    private Integer amtDir;
    /**
     * 当前余额
     */
    @ApiModelProperty(value="当前余额",name="currBal")
    private BigDecimal currBal;
    /**
     * 交易类型
     */
    @ApiModelProperty(value="交易类型",name="type")
    private String type;
    /**
     * 发生金额描述
     */
    @ApiModelProperty(value="发生金额描述",name="occurTypeDesc")
    private String occurTypeDesc;
    /**
     * 发生金额日期
     */
    @ApiModelProperty(value="发生金额日期",name="occurTime")
    private Date occurTime;

    /**
     * 备注
     */
    @ApiModelProperty(value="备注",name="remark")
    private String remark;
}
