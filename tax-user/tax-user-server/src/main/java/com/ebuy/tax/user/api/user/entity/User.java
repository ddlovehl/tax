package com.ebuy.tax.user.api.user.entity;


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
 * 用户entity
 * </p>
 *
 * @author hdq
 * @since 2018-09-07
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel
@TableName("tax_user")
public class User extends SuperEntity<User> {

private static final long serialVersionUID = 1L;

    /**
    *  id
    */
    private String id;
    /**
    *  用户名
    */
    private String username;
    /**
    * 用户名
    */
    private String password;
    /**
    * 角色id
    */
    @TableField("role_id")
    private String roleId;
    /**
    * openid
    */
    private String openid;
    /**
    * 手机号
    */
    private String mobile;
    /**
    * 邮件
    */
    private String mail;
    /**
    * 姓名
    */
    private String name;
    /**
    * 性别
    */
    private Integer sex;
    /**
    * 年龄
    */
    private Integer age;
    /**
    * 职位
    */
    private String position;
    /**
    * 头像附件
    */
    @TableField("profile_pic_attach_id")
    private String profilePicAttachId;
    /**
    * 类别（1:业务负责人；2:其他联系人）
    */
    @TableField("user_category")
    private Integer userCategory;
    /**
    * 父级id
    */
    @TableField("parent_id")
    private String parentId;
    /**
    * 用户状态(0:正常，1:禁用，9:删除)
    */
    @TableField("user_status")
    private Integer userStatus;
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
    * 创建时间
    */
    @TableField("create_time")
    private Date createTime;
    /**
    * 修改时间
    */
    @TableField("update_time")
    private Date updateTime;


    @Override
    protected Serializable pkVal() {
                return this.id;
            }

}
