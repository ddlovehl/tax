package com.ebuy.tax.common.utils;

import com.ebuy.tax.common.constants.ResponseConstant;
import com.ebuy.tax.common.exception.BusinessException;
import com.ebuy.tax.common.exception.ParamException;
import com.ebuy.tax.common.exception.SystemException;

import java.io.Serializable;
import java.util.List;

/**
 * 公共调用  异常util
 *
 * @author hdq
 * @date 2018年7月19日 下午8:33:01
 */
@SuppressWarnings({"rawtypes"})
public class CommonExceptionUtils {

    /**
     * 通用异常  - code:99  info:系统错误
     *
     * @throws Exception
     */
    public static void throwException() throws Exception {
        throw new ParamException(ResponseConstant.ERR_CODE.FAIL, ResponseConstant.ERR_INFO.FAIL);
    }

    /**
     * 通用异常  - code:01          参数级别
     *
     * @param info
     * @throws ParamException
     */
    public static void throwParamException(String info) throws ParamException {
        throw new ParamException(ResponseConstant.ERR_CODE.PARAM, info);
    }

    /**
     * 通用异常  - code:02        业务级别
     *
     * @param info
     * @throws BusinessException
     */
    public static void throwBusinessException(String info) throws BusinessException {
        throw new BusinessException(ResponseConstant.ERR_CODE.BUSINESS, info);
    }

    /**
     * 通用异常  - code:02        系统级别
     *
     * @param info
     * @throws BusinessException
     */
    public static void throwSystemException(String info) throws BusinessException {
        throw new SystemException(ResponseConstant.ERR_CODE.FAIL, info);
    }

    /**
     * 通用异常  -        参数级别
     *
     * @param code info
     * @throws BusinessException
     */
    public static void throwException(String code, String info) throws Exception {
        throw new ParamException(code, info);
    }

    /**
     * @Desc 对象判空并且抛出业务级别异常返回信息
     * @return
     */
    public static void isNull(Serializable s, String errorCode, String info) throws BusinessException {
        if (s == null) {
            throw new BusinessException(errorCode, info);
        }
    }

    /**
     * 对象非空判断并且抛出业务级别异常返回信息
     *
     * @param s errorCode info
     * @throws BusinessException
     */
    public static void isNotNull(Serializable s, String errorCode, String info) throws BusinessException {
        if (s != null) {
            throw new BusinessException(errorCode, info);
        }
    }

    /**
     * list判空并且抛出业务级别异常返回信息
     *
     * @param list errorCode info
     * @throws BusinessException
     */
    public static void isNotNull(List list, String errorCode, String info) throws BusinessException {
        if (list != null && !list.isEmpty()) {
            throw new BusinessException(errorCode, info);
        }
    }

    /**
     * llist非空判断并且抛出业务级别异常返回信息
     *
     * @param list errorCode info
     * @throws BusinessException
     */
    public static void isNull(List list, String errorCode, String info) throws Exception {
        if (list == null || list.isEmpty()) {
            throw new BusinessException(errorCode, info);
        }
    }
}
