package com.ebuy.tax.user.api.accountDetail.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ebuy.tax.common.constants.SysConstant;
import com.ebuy.tax.user.entity.User;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
/**
 * 账户服务
* @author dd
* @date 2018年9月5日
 */
@Api("账户服务")
@RestController
public class UserController {

	@ApiOperation(value="获取单个用户信息", notes="根据用户名获取用户信息")// 使用该注解描述接口方法信息
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username", value = "用户username", required = true, dataType = "String", paramType="path")
    })
	@GetMapping(value="demo")
	public User demo(String name) {
		System.out.println("执行user的DemoController");
		User user = new User();
		user.setUsername(name);
		user.setPassword("123456");
		return user;
	}
}
