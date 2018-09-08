package com.ebuy.tax.user.api.invited.entity;


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
 * è¢«é‚€è¯·è¡¨
 * </p>
 *
 * @author hdq
 * @since 2018-09-07
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel
@TableName("tax_invited")
public class Invited extends SuperEntity<Invited> {

private static final long serialVersionUID = 1L;

    /**
    * id
    */
    private String id;
    /**
    * 邀请人id
    */
    @TableField("invite_user_id")
    private String inviteUserId;
    /**
    * 被邀请人id
    */
    @TableField("invited_user_id")
    private String invitedUserId;
    /**
    * 被邀请人姓名
    */
    @TableField("invited_name")
    private String invitedName;
    /**
    * 被邀请人手机号
    */
    @TableField("invited_mobile")
    private String invitedMobile;
    /**
    * 被邀请人性别
    */
    @TableField("invited_sex")
    private Integer invitedSex;
    /**
    * 被邀请可看公司id
    */
    @TableField("company_id")
    private String companyId;
    /**
    * 年龄
    */
    @TableField("invited_age")
    private Integer invitedAge;
    /**
    * 职位
    */
    @TableField("invited_position")
    private String invitedPosition;
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
    * 是否删除（0：正常，9删除）
    */
    @TableField("is_del")
    private Integer isDel;
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
