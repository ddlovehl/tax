package com.ebuy.tax.user.api.company.controller;


import org.springframework.web.bind.annotation.RequestMapping;

import com.ebuy.tax.user.api.company.service.CompanyBizService;
import net.sf.json.JSONObject;
import org.springframework.web.bind.annotation.*;


import org.springframework.stereotype.Controller;

/**
 * @Project new_project
 * @Package com.ebuy.tax.user.api.company.dao
 * @Author hdq
 * @Date 2018-09-04 21:42:18
 * @Description companyController
 */

@RestController
@RequestMapping("/v1/companyAdmin")
public class CompanyController {

        private CompanyBizService companyBizService;


    /**
     * @return java.lang.String
     * @author hdq
     * @Description 根据ID查询单条记录
     * @date 2018-09-04 21:42:18
     *  @see   [obj]
     */
    @PostMapping(value = "/queryById")
    public String queryById(@RequestBody JSONObject obj) throws Exception {
        //json字符串转成request封装类型
        //QueryByIdRequest用于接收转化json对象的封装类
        //QueryByIdRequest req = JsonUtil.jsonObjctToBean(obj,QueryByIdRequest.class);
        //Company company = companyBizService.queryById(new BigInteger(req.getId()));
        //QueryByIdResponse用于返回转化json字符串的封装类
        //QueryByIdResponse res = new QueryByIdResponse();
        //BeanUtils.copyProperties(company,res);
        //return ResponseUtil.fillResponseToJson(res);
        return null;
    }

}

