package com.ebuy.tax.user.api.sequence.entity;


import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableId;
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
 * @since 2018-09-08
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel
public class Sequence extends SuperEntity<Sequence> {

private static final long serialVersionUID = 1L;

    @TableId("NAME")
    private String name;
    private String value;


    @Override
    protected Serializable pkVal() {
                return this.name;
            }

}
