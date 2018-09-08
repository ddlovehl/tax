package com.ebuy.tax.common.enums;

/**
 * 登陆相关enum
* @author dd
* @date 2018年9月8日
 */
public class LoginEnums {
	
	/**
	 * 登陆类型
	 */
	public final static String LOGIN_TYPE_MOBILE = "mobile";
	public final static String LOGIN_TYPE_WX = "wechat";
	
	/**
	 * 登陆类型enum
	* @author dd
	* @date 2018年9月8日
	 */
	public enum LoginType {
		
		MOBILE(LOGIN_TYPE_MOBILE,"手机验证码登陆"),
		WX(LOGIN_TYPE_WX,"微信登陆"),
		;
		
		
		
		private String code;
		
		private String msg;
		
		/**
		 * 构造函数
		 * @param code
		 * @param msg
		 */
		LoginType(String code, String msg) {
			this.code = code;
			this.msg = msg;
		}

		public String getCode() {
			return code;
		}

		public void setCode(String code) {
			this.code = code;
		}

		public String getMsg() {
			return msg;
		}

		public void setMsg(String msg) {
			this.msg = msg;
		}
		
		
	}
	
	
}
