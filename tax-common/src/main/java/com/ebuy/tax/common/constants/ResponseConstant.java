package com.ebuy.tax.common.constants;

/**
 * @author hdq
 * @desc error_code 返回码,  error_info返回信息
 */
public class ResponseConstant {

    public static class ERR_CODE {

        /**
         * 成功 返回码
         */
        public static final String NORMAL = "00";
        /**
         * 参数级别  异常返回码
         */
        public static final String PARAM = "01";

        /**
         * 业务级别   异常返回码
         */
        public static final String BUSINESS = "02";

        /**
         * 系统错误
         */
        public static final String FAIL = "99";
    }

    public static class ERR_INFO {
        public static final String NORMAL = "成功";
        public static final String PARAM = "参数错误";
        public static final String NOMETHOD = "请求方法不存在";
        public static final String JSON_TO_BEAN_ERROR = "JSON报文解析出错";
        public static final String NOBIZDATA = "业务参数为空";
        public static final String NOBASEDATA = "基础参数为空";
        public static final String AUTHORIZATION_FAILED = "授权失败";
        public static final String ILLEGAL_PARAMETER = "请求参数校验失败";
        public static final String FAIL = "系统错误";
        public static final String AUTH_ERROR = "权限不足";
    }

    public static class ERR_CODE_PAGE extends ERR_CODE {
        public static final String PAGE_SIZE_ERROR = "10";
        public static final String PAGE_NO_ERROR = "10";
        public static final String PAGE_NO_OVERSIZE = "10";

    }

    public static class ERR_INFO_PAGE extends ERR_INFO {
        public static final String PAGE_SIZE_ERROR = "页面大小格式不正确";
        public static final String PAGE_NO_ERROR = "页码格式不正确";
        public static final String PAGE_NO_OVERSIZE = "页码过大";
    }
}
