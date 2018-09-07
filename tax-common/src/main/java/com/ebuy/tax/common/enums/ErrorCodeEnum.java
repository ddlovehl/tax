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
	
	//---qp
	ERROR_20001(20001,"手机号码不能为空"),
	ERROR_20002(20002,"图形验证码不能为空"),
	ERROR_20003(20003,"短信验证码不能为空"),
	ERROR_20004(20004,"手机号码不正确"),
	ERROR_20005(20005,"图形验证码不正确"),
	ERROR_20006(20006,"短信验证码不正确"),
	ERROR_20007(20007,"deviceId不能为空"),
	ERROR_20008(20008,"参数不能为空"),
	ERROR_20009(20009,"60s内不能重复获取验证码")
	
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
