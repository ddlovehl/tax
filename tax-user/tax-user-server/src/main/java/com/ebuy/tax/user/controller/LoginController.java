package com.ebuy.tax.user.controller;


import com.ebuy.tax.common.utils.JsonUtil;
import com.ebuy.tax.common.utils.ResponseUtil;
import com.ebuy.tax.user.api.accountDetail.service.AccountDetailBizService;
import com.ebuy.tax.user.api.user.service.UserBizService;
import com.ebuy.tax.user.entity.User;
import com.ebuy.tax.user.model.LoginRequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @Project new_project
 * @Package com.ebuy.tax.user.api.accountDetail.dao
 * @Author hdq
 * @Date 2018-09-05 09:57:24
 * @Description accountDetailController
 */

@Api(value = "/login", description = "登录")
@RestController
@RequestMapping("/v1")
public class LoginController {

    @Resource(name = "userBizService")
    private UserBizService userBizService;

    /**
     * @return java.lang.String
     * @author hdq
     * @Description 登录
     * @date 2018-09-05 09:57:24
     *  @see   [obj]
     */
    @ApiOperation(value="登录", notes="第一次登陆包含注册")// 使用该注解描述接口方法信息
    @PostMapping(value = "/login")
    public String login(@RequestBody JSONObject obj) throws Exception {
        //json字符串转成request封装类型
        //QueryByIdRequest用于接收转化json对象的封装类
        LoginRequest req = JsonUtil.jsonObjctToBean(obj,LoginRequest.class);
        //调用bizservice进行业务处理
        //.........bizservice.()....
        //QueryByIdResponse用于返回转化json字符串的封装类
        //QueryByIdResponse res = new QueryByIdResponse();
        //BeanUtils.copyProperties(accountDetail,res);
        return ResponseUtil.responseToJson();
    }

}

