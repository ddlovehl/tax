package com.ebuy.tax.user.api.account_detail.controller;


import org.springframework.web.bind.annotation.RequestMapping;

import com.ebuy.tax.user.api.account_detail.service.AccountDetailBizService;
import net.sf.json.JSONObject;
import org.springframework.web.bind.annotation.*;


import org.springframework.stereotype.Controller;

/**
 * @Project new_project
 * @Package com.ebuy.tax.user.api.account_detail.dao
 * @Author hdq
 * @Date 2018-09-04 21:44:21
 * @Description account_detailController
 */

@RestController
@RequestMapping("/v1/account_detailAdmin")
public class AccountDetailController {

        private AccountDetailBizService account_detailBizService;


    /**
     * @return java.lang.String
     * @author hdq
     * @Description 根据ID查询单条记录
     * @date 2018-09-04 21:44:21
     *  @see   [obj]
     */
    @PostMapping(value = "/queryById")
    public String queryById(@RequestBody JSONObject obj) throws Exception {
        //json字符串转成request封装类型
        //QueryByIdRequest用于接收转化json对象的封装类
        //QueryByIdRequest req = JsonUtil.jsonObjctToBean(obj,QueryByIdRequest.class);
        //AccountDetail account_detail = account_detailBizService.queryById(new BigInteger(req.getId()));
        //QueryByIdResponse用于返回转化json字符串的封装类
        //QueryByIdResponse res = new QueryByIdResponse();
        //BeanUtils.copyProperties(account_detail,res);
        //return ResponseUtil.fillResponseToJson(res);
        return null;
    }

}

