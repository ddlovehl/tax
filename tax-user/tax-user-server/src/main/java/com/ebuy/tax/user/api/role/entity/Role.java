package com.ebuy.tax.user.api.role.entity;


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
 * è§’è‰²è¡¨
 * </p>
 *
 * @author hdq
 * @since 2018-09-04
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("tax_role")
public class Role extends SuperEntity<Role> {

private static final long serialVersionUID = 1L;

    /**
    * å”¯ä¸€æ ‡è¯†
    */
    private String id;
    /**
    * è§’è‰²åç§°
    */
    @TableField("role_name")
    private String roleName;
    /**
    * è§’è‰²æè¿°
    */
    @TableField("role_desc")
    private String roleDesc;
    /**
    * è§’è‰²åŒºåŸŸ(1:ä¼ä¸šè¿è¥ï¼Œ2:åŠ ç›Ÿå•†æˆ·ï¼Œ3:åˆä½œå®¢æˆ·)
    */
    @TableField("role_area")
    private Integer roleArea;
    /**
    * æ˜¯å¦åˆ é™¤(0:æ­£å¸¸ï¼Œ9åˆ é™¤)
    */
    @TableField("is_del")
    private Integer isDel;
    /**
    * æ·»åŠ æ—¥æœŸ
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
