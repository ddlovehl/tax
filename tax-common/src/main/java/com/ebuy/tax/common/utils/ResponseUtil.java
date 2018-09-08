package com.ebuy.tax.common.utils;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.ebuy.tax.common.constants.ResponseConstant;
import com.ebuy.tax.common.entity.ResponseBase;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * @author hdq
 * @date 2018年7月18日 上午11:26:30
 * @desc 返回操作工具类
 */
@Slf4j
public class ResponseUtil {


    /**
     * @param obj
     * @return
     * @author hdq
     * @date 2018年7月18日 上午11:29:38
     * @desc 通用填充返回信息，转成json字符串
     */
    public static ResponseBase fillResponse(Object obj) throws Exception {
        log.debug("------填充返回信息，转成json字符串------");
        ResponseBase response = successResponse();
        try {
            response.setData(obj);
        } catch (Exception e) {
            log.error("填充返回信息，转成json字符串失败", e);
            CommonExceptionUtils.throwSystemException("json字符串转换失败");
        }
        log.info("返回信息：{}",response);
        return response;
    }

    /**
     * @param response
     * @return
     * @author hdq
     * @date 2018年7月18日 下午8:39:15
     * @desc Object转jsonString
     */
    public static String responseToJson(ResponseBase response) {
        return JsonUtil.beanToJsonStr(response).toString();
    }

    /**
     * @param model
     * @return
     * @author hdq
     * @date 2018年7月18日 下午8:39:15
     * @desc Object转jsonString
     */
    public static String responseToJson(List<Model> model) {
        return JsonUtil.beanToJsonStr(model).toString();
    }

    /**
     * @author      hdq
     * @see         []
     * @return      java.lang.String
     * @Description 成功返回信息填充
     * @date        2018/7/27 13:56
     */
    public static ResponseBase successResponse(){
        ResponseBase response = new ResponseBase();
        response.setRespCode(ResponseConstant.ERR_CODE.NORMAL);
        response.setRespDesc(ResponseConstant.ERR_INFO.NORMAL);
        return response;
    }

    /**
     * @param list
     * @return
     * @author hdq
     * @date 2018年7月18日 上午11:29:38
     * @desc 通用填充返回信息，转成json字符串
     */
    public static String fillResponseToJson(List list) throws Exception {
        log.debug("------填充返回信息，转成json字符串------");
        ResponseBase response = successResponse();
        try {
            response.setData(list);
        } catch (Exception e) {
            log.error("填充返回信息，转成json字符串失败", e);
            CommonExceptionUtils.throwSystemException("json字符串转换失败");
        }
        log.info("返回信息：{}",response);
        return JsonUtil.beanToJsonStr(response).toString();
    }
}
