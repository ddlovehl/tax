package com.ebuy.tax.user.api.merchant.controller;


import org.springframework.web.bind.annotation.RequestMapping;

import com.ebuy.tax.user.api.merchant.service.MerchantBizService;
import net.sf.json.JSONObject;
import org.springframework.web.bind.annotation.*;


import org.springframework.stereotype.Controller;

/**
 * @Project new_project
 * @Package com.ebuy.tax.user.api.merchant.dao
 * @Author hdq
 * @Date 2018-09-05 09:57:25
 * @Description merchantController
 */

@RestController
@RequestMapping("/v1/merchantAdmin")
public class MerchantController {

        private MerchantBizService merchantBizService;


    /**
     * @return java.lang.String
     * @author hdq
     * @Description 根据ID查询单条记录
     * @date 2018-09-05 09:57:25
     *  @see   [obj]
     */
    @PostMapping(value = "/queryById")
    public String queryById(@RequestBody JSONObject obj) throws Exception {
        //json字符串转成request封装类型
        //QueryByIdRequest用于接收转化json对象的封装类
        //QueryByIdRequest req = JsonUtil.jsonObjctToBean(obj,QueryByIdRequest.class);
        //Merchant merchant = merchantBizService.queryById(new BigInteger(req.getId()));
        //QueryByIdResponse用于返回转化json字符串的封装类
        //QueryByIdResponse res = new QueryByIdResponse();
        //BeanUtils.copyProperties(merchant,res);
        //return ResponseUtil.fillResponseToJson(res);
        return null;
    }

}

