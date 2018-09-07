package com.ebuy.tax.user.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Project parent_parent
 * @Package com.jsonmedia.shop.api.user.model
 * @Author hdq
 * @Date 2018/7/25 18:40
 * @Description
 */
@ApiModel(value="获取用户信息接口返回数据封装")
@Data
public class QueryUserInfoResponse {

    /**
     *  手机号
     */
    @ApiModelProperty(value="手机号",name="mobile")
    private String mobile;

    /**
     *  姓名
     */
    @ApiModelProperty(value="姓名",name="name")
    private String name;

    /**
     *  昵称
     */
    @ApiModelProperty(value="昵称",name="userName")
    private String userName;

    /**
     *  性别
     */
    @ApiModelProperty(value="性别",name="sex")
    private Integer sex;

    /**
     *  邮箱
     */
    @ApiModelProperty(value="邮箱",name="mail")
    private String mail;
}
