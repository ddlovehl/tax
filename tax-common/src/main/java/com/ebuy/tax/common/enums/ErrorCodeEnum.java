package com.ebuy.tax.common.enums;

/**
 * 错误码enum
* @author dd
* @date 2018年9月4日
 */
public enum ErrorCodeEnum {
	
	ERROR_99401(99401,"无权访问"),
	
	ERROR_10010(10010,"注销成功"),
	
	ERROR_10011(10011,"注销失败"),
	
	;
	
	private int code;
	
	private String msg;
	
	/**
	 * 构造函数
	 * @param code
	 * @param msg
	 */
	ErrorCodeEnum(int code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	
}
