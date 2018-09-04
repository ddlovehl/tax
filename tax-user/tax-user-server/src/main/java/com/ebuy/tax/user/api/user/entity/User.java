package com.ebuy.tax.user.api.user.entity;


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
 * ç”¨æˆ·è¡¨
 * </p>
 *
 * @author hdq
 * @since 2018-09-04
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("tax_user")
public class User extends SuperEntity<User> {

private static final long serialVersionUID = 1L;

    /**
    * å”¯ä¸€æ ‡è¯†
    */
    private String id;
    /**
    * ç”¨æˆ·å
    */
    private String username;
    /**
    * å¯†ç 
    */
    private String password;
    /**
    * ç®¡ç†è§’è‰²è¡¨id
    */
    @TableField("role_id")
    private String roleId;
    /**
    * å¾®ä¿¡å”¯ä¸€æ ‡è¯†
    */
    private String openid;
    /**
    * æ‰‹æœºå·
    */
    private String mobile;
    /**
    * é‚®ç®±å·
    */
    private String mail;
    /**
    * å§“å
    */
    private String name;
    /**
    * æ€§åˆ«(1:ç”·ï¼Œ2:å¥³ï¼Œ3:æœªçŸ¥)
    */
    private Integer sex;
    /**
    * å¹´é¾„
    */
    private Integer age;
    /**
    * èŒä½
    */
    private String position;
    /**
    * å¤´åƒé™„ä»¶id
    */
    @TableField("profile_pic_attach_id")
    private String profilePicAttachId;
    /**
    * ç±»åˆ«ï¼ˆ1:ä¸šåŠ¡è´Ÿè´£äººï¼›2:å…¶ä»–è”ç³»äººï¼‰
    */
    @TableField("user_category")
    private Integer userCategory;
    /**
    * çˆ¶çº§ç”¨æˆ·
    */
    @TableField("parent_id")
    private String parentId;
    /**
    * ç”¨æˆ·çŠ¶æ€(0:æ­£å¸¸ï¼Œ1:ç¦ç”¨ï¼Œ9:åˆ é™¤)
    */
    @TableField("user_status")
    private Integer userStatus;
    /**
    * é¢„ç•™å­—æ®µ1
    */
    private String reserve1;
    /**
    * é¢„ç•™å­—æ®µ2
    */
    private String reserve2;
    /**
    * é¢„ç•™å­—æ®µ3
    */
    private String reserve3;
    /**
    * å¤‡æ³¨
    */
    private String remark;
    /**
    * æ·»åŠ æ—¶é—´
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
