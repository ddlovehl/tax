package com.ebuy.tax.auth.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.endpoint.FrameworkEndpoint;
import org.springframework.security.oauth2.provider.token.ConsumerTokenServices;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ebuy.tax.common.enums.ErrorCodeEnum;
import com.ebuy.tax.common.vo.Result;

/**
 * Created by Mr.Yangxiufeng on 2018/1/2.
 * Time:9:22
 * ProjectName:Mirco-Service-Skeleton
 */
@FrameworkEndpoint
public class RevokeTokenEndpoint {
    @Autowired
    private ConsumerTokenServices consumerTokenServices;

    @RequestMapping(value = "/oauth/token", method= RequestMethod.DELETE)
    public @ResponseBody
    Result revokeToken(String access_token){
    	Result result = new Result();
        if (consumerTokenServices.revokeToken(access_token)){
        	result.setCode(ErrorCodeEnum.ERROR_10010.getCode());
        	result.setMsg("注销成功");
        }else {
        	result.setCode(ErrorCodeEnum.ERROR_10010.getCode());
        	result.setMsg("注销失败");
        }
        return result;
    }
}
