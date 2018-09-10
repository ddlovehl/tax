package com.ebuy.tax.common.constants;

/**
 * 系统常量类
* @author dd
* @date 2018年9月4日
 */
public class SysConstant {

    public static final Integer ONE = 1;

    /** 英文逗号 */
    public static final String COMMA = ",";
    
    /** 用户版本号 */
    public static final String VERSION_USER_SERVER = "v1.0";
    
    /** h5版本号 */
    public static final String VERSION_H5_SERVER = "v1.0";
    
    /** UTF-8 */
    public static final String CHARSET_UTF8 = "UTF-8";
    
    /** yyyy-MM-dd hh:mm:ss */
    public static final String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd hh:mm:ss";
    
    
    public static final class Sequence {
		/** 后台管理账号序列 **/
		public static final String SEQ_ADMIN_USER_ID = "seq_admin_user_id";
		/** 公司序列 **/
		public static final String SEQ_COMPANY_ID = "seq_company_id";
		/** 客户序列 **/
		public static final String SEQ_CUSTOMER_USER_ID = "seq_customer_user_id";
		/** 商户员工序列 **/
		public static final String SEQ_MERCHANT_SUB_USER_ID = "seq_merchant_sub_user_id";
		/** 商户管理员序列 **/
		public static final String SEQ_MERCHANT_USER_ID = "seq_merchant_user_id";
		/** 服务序列 **/
		public static final String SEQ_SERVER_ID = "seq_server_id";
		/** 子单序列 **/
		public static final String SEQ_SERVER_SUB_ID = "seq_server_sub_id";
	}
}
