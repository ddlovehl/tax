package com.ebuy.tax.user.api.user_account.controller;


import org.springframework.web.bind.annotation.RequestMapping;

import com.ebuy.tax.user.api.user_account.service.UserAccountBizService;
import net.sf.json.JSONObject;
import org.springframework.web.bind.annotation.*;


import org.springframework.stereotype.Controller;

/**
 * @Project new_project
 * @Package com.ebuy.tax.user.api.user_account.dao
 * @Author hdq
 * @Date 2018-09-04 21:43:56
 * @Description user_accountController
 */

@RestController
@RequestMapping("/v1/user_accountAdmin")
public class UserAccountController {

        private UserAccountBizService user_accountBizService;


    /**
     * @return java.lang.String
     * @author hdq
     * @Description 根据ID查询单条记录
     * @date 2018-09-04 21:43:56
     *  @see   [obj]
     */
    @PostMapping(value = "/queryById")
    public String queryById(@RequestBody JSONObject obj) throws Exception {
        //json字符串转成request封装类型
        //QueryByIdRequest用于接收转化json对象的封装类
        //QueryByIdRequest req = JsonUtil.jsonObjctToBean(obj,QueryByIdRequest.class);
        //UserAccount user_account = user_accountBizService.queryById(new BigInteger(req.getId()));
        //QueryByIdResponse用于返回转化json字符串的封装类
        //QueryByIdResponse res = new QueryByIdResponse();
        //BeanUtils.copyProperties(user_account,res);
        //return ResponseUtil.fillResponseToJson(res);
        return null;
    }

}

