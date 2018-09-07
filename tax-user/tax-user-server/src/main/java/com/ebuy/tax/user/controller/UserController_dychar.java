package com.ebuy.tax.user.controller;


import com.ebuy.tax.common.entity.ResponseBase;
import com.ebuy.tax.common.utils.JsonUtil;
import com.ebuy.tax.common.utils.ResponseUtil;
import com.ebuy.tax.user.api.user.entity.User;
import com.ebuy.tax.user.api.user.service.UserBizService;
import com.ebuy.tax.user.model.LoginRequest;
import com.ebuy.tax.user.model.QueryUserInfoRequest;
import com.ebuy.tax.user.model.QueryUserInfoResponse;
import com.ebuy.tax.user.model.UpdateUserInfoRequest;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import net.sf.json.JSONObject;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Project new_project
 * @Package com.ebuy.tax.user.api.accountDetail.dao
 * @Author hdq
 * @Date 2018-09-05 09:57:24
 * @Description accountDetailController
 */

@Api(value = "/用户相关接口", description = "用户")
@RestController
@Slf4j
@RequestMapping("/v1/userAdmin")
public class UserController_dychar {

    @Resource(name = "userBizService")
    private UserBizService userBizService;

    /**
     * @return java.lang.String
     * @author hdq
     * @Description 获取用户信息
     * @date 2018-09-05 09:57:24
     *  @see   [obj]
     */
    @ApiOperation(value="获取用户信息", notes="获取用户信息")// 使用该注解描述接口方法信息
    @PostMapping(value = "/queryUserInfo")
    @ApiResponses({
            @ApiResponse(code=200,message="成功",response=QueryUserInfoResponse.class),
    })
    public String queryUserInfoRequest(@RequestBody @ApiParam(name="QueryUserInfoRequest",value="传入json格式",required=true) QueryUserInfoRequest req) throws Exception {
        log.info("-----------获取用户信息------------");
        User user = new User();
        user.setMobile(req.getMobile());
        User result = userBizService.queryByParam(user);
        //QueryUserInfoResponse用于返回转化json字符串的封装类
        QueryUserInfoResponse res = new QueryUserInfoResponse();
        BeanUtils.copyProperties(result,res);
        return ResponseUtil.fillResponseToJson(res);
    }

    /**
     * @return java.lang.String
     * @author hdq
     * @Description 更新用户信息
     * @date 2018-09-05 09:57:24
     *  @see   [obj]
     */
    @ApiOperation(value="更新用户信息", notes="更新用户信息")// 使用该注解描述接口方法信息
    @PostMapping(value = "/updateUserInfo")
    public String updateUserInfo(@RequestBody @ApiParam(name="QueryUserInfoRequest",value="传入json格式",required=true) UpdateUserInfoRequest req) throws Exception {
        log.info("-----------更新用户信息------------");
        User user = new User();
        user.setMobile(req.getMobile());
        userBizService.update(user);
        return ResponseUtil.responseToJson();
    }
}

