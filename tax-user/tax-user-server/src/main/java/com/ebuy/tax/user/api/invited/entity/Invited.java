package com.ebuy.tax.user.api.invited.entity;


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
 * è¢«é‚€è¯·è¡¨
 * </p>
 *
 * @author hdq
 * @since 2018-09-05
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("tax_invited")
public class Invited extends SuperEntity<Invited> {

private static final long serialVersionUID = 1L;

    /**
    * å”¯ä¸€æ ‡è¯†
    */
    private String id;
    /**
    * é‚€è¯·äººid
    */
    @TableField("invite_user_id")
    private String inviteUserId;
    /**
    * è¢«é‚€è¯·äººid
    */
    @TableField("invited_user_id")
    private String invitedUserId;
    /**
    * è¢«é‚€è¯·äººå§“å
    */
    @TableField("invited_name")
    private String invitedName;
    /**
    * è¢«é‚€è¯·äººæ‰‹æœºå·
    */
    @TableField("invited_mobile")
    private String invitedMobile;
    /**
    * æ€§åˆ«
    */
    @TableField("invited_sex")
    private Integer invitedSex;
    /**
    * è¢«é‚€è¯·å¯çœ‹å…¬å¸id
    */
    @TableField("company_id")
    private String companyId;
    /**
    * å¹´é¾„
    */
    @TableField("invited_age")
    private Integer invitedAge;
    /**
    * èŒä½
    */
    @TableField("invited_position")
    private String invitedPosition;
    /**
    * é¢„ç•™å­—æ®µ1
    */
    private String reseve1;
    /**
    * é¢„ç•™å­—æ®µ1
    */
    private String reseve2;
    /**
    * é¢„ç•™å­—æ®µ3
    */
    private String reseve3;
    /**
    * æ˜¯å¦åˆ é™¤ï¼ˆ0ï¼šæ­£å¸¸ï¼Œ9åˆ é™¤ï¼‰
    */
    @TableField("is_del")
    private Integer isDel;
    /**
    * åˆ›å»ºæ—¥æœŸ
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
