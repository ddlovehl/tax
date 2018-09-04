package com.ebuy.tax.common.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * @Project new_project
 * @Package com.jsonmedia.shop.api.user.entity
 * @Author Tom
 * @Date 2018/7/24 03:48
 * @Description
 */
@EqualsAndHashCode(callSuper = false)
public class SuperEntity<T extends Model> extends Model<T> {

    /**
     * 主键ID , 这里故意演示注解可以无
     */
    protected Long id;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}