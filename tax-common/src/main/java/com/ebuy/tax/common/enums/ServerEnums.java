package com.ebuy.tax.common.enums;

/**
 * 服务相关enums
* @author dd
* @date 2018年9月10日
 */
public class ServerEnums {

	
	/**
	 * 服务类型
	 */
	public final static String SERVER_TYPE_ZCGS = "1";
	public final static String SERVER_TYPE_GSBG = "2";
	public final static String SERVER_TYPE_SWCH = "3";
	public final static String SERVER_TYPE_JZFW = "4";
	
	/**
	 * 登陆类型enum
	* @author dd
	* @date 2018年9月8日
	 */
	public enum ServerType {
		
		ZCGS(SERVER_TYPE_ZCGS,"注册公司"),
		GSBG(SERVER_TYPE_GSBG,"公司变更"),
		SWCH(SERVER_TYPE_SWCH,"税务筹划"),
		JZFW(SERVER_TYPE_JZFW,"记账服务"),
		;
		
		
		
		private String code;
		
		private String msg;
		
		/**
		 * 构造函数
		 * @param code
		 * @param msg
		 */
		ServerType(String code, String msg) {
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
		
		public static String getByCode(String code) {
			ServerType[] enums = ServerType.values();
			for (int i = 0; i < enums.length; i++) {
				if (enums[i].getCode().equals(code)) {
					return enums[i].getMsg();
				}
			}
			return "";
		}
		
		
	}
}
