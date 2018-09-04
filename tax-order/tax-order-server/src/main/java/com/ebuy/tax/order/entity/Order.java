package com.ebuy.tax.order.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class Order extends BaseEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1525278513020270676L;

	@ApiModelProperty(value="用户名", hidden=false, notes="主键，隐藏", required=true, dataType="String")// 使用该注解描述属性信息,当hidden=true时，该属性不会在api中显示
	private String username;
	
	@ApiModelProperty(value="密码")
	private String password;
	
	@ApiModelProperty(value="微信授权openid")
	private String openid;
}
