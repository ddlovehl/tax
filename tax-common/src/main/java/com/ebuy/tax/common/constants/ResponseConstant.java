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
        public static final String NORMAL = "0000";
        /**
         * 参数级别  通用异常返回码
         */
        public static final String PARAM = "1000";

        /**
         * 业务级别   通用异常返回码
         */
        public static final String BUSINESS = "2000";

        /**
         * 系统错误
         */
        public static final String FAIL = "9999";
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

    /**
     * User服务  详细返回码 2xxx
     *  用户20xx  公司21xx
     */
    public static class ERR_CODE_USER extends ERR_CODE{
        public static final String USER_NONE_ERROR = "2001";
        public static final String USER_DISABLE_ERROR = "2002";
        public static final String USER_DELETED_ERROR = "2003";
        public static final String COMPANY_NAME_EXIST = "2101";
    }

    /**
     * User服务  详细返回信息
     */
    public static class ERR_INFO_USER extends ERR_INFO {
        public static final String USER_NONE_ERROR = "用户不存在";
        public static final String USER_DISABLE_ERROR = "用户已禁用";
        public static final String USER_DELETED_ERROR = "用户已删除";
        public static final String COMPANY_NAME_EXIST = "公司名称已经存在";

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
