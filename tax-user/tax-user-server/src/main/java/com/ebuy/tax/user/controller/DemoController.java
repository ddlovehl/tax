package com.ebuy.tax.user.controller;

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
 * demo
* @author dd
* @date 2018年8月29日
 */

@Api("测试的controller")
@RestController
public class DemoController {
	
	//读取配置中心的配置
	@Value(value="${demo.username}")
	String username;

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
