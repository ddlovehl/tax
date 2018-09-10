package com.ebuy.tax.user.model;

import com.ebuy.tax.common.annotations.Validator;
import com.ebuy.tax.common.enums.RegexEnum;
import com.ebuy.tax.common.utils.RegexUtils;
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
@ApiModel(value="更新用户信息接口接受参数封装")
@Data
public class UpdateUserInfoRequest {

    /**
     *  公司id
     */
    @ApiModelProperty(value="公司id",name="companyId")
    private String companyId;

    /**
     *  姓名
     */
    @Validator(maxLength = 20,description = "姓名")
    @ApiModelProperty(value="姓名",name="name")
    private String name;

    /**
     *  昵称
     */
    @Validator(maxLength = 30,description = "昵称")
    @ApiModelProperty(value="昵称",name="userName")
    private String userName;

    /**
     *  性别
     */
    @Validator(regexExpression = RegexUtils.REGEX_SEX,description = "性别)")
    @ApiModelProperty(value="性别(1:男，2:女，3:未知)",name="sex")
    private String sex;

    /**
     *  邮箱
     */
    @Validator(regexType = RegexEnum.EMAIL,description = "邮箱")
    @ApiModelProperty(value="邮箱",name="mail")
    private String mail;

}
