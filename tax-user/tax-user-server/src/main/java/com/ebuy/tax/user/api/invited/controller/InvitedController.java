package com.ebuy.tax.user.api.invited.controller;


import org.springframework.web.bind.annotation.RequestMapping;

import com.ebuy.tax.user.api.invited.service.InvitedBizService;
import net.sf.json.JSONObject;
import org.springframework.web.bind.annotation.*;


import org.springframework.stereotype.Controller;

/**
 * @Project new_project
 * @Package com.ebuy.tax.user.api.invited.dao
 * @Author hdq
 * @Date 2018-09-05 09:35:19
 * @Description invitedController
 */

@RestController
@RequestMapping("/v1/invitedAdmin")
public class InvitedController {

        private InvitedBizService invitedBizService;


    /**
     * @return java.lang.String
     * @author hdq
     * @Description 根据ID查询单条记录
     * @date 2018-09-05 09:35:19
     *  @see   [obj]
     */
    @PostMapping(value = "/queryById")
    public String queryById(@RequestBody JSONObject obj) throws Exception {
        //json字符串转成request封装类型
        //QueryByIdRequest用于接收转化json对象的封装类
        //QueryByIdRequest req = JsonUtil.jsonObjctToBean(obj,QueryByIdRequest.class);
        //Invited invited = invitedBizService.queryById(new BigInteger(req.getId()));
        //QueryByIdResponse用于返回转化json字符串的封装类
        //QueryByIdResponse res = new QueryByIdResponse();
        //BeanUtils.copyProperties(invited,res);
        //return ResponseUtil.fillResponseToJson(res);
        return null;
    }

}

