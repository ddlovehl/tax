package com.ebuy.tax.user.api.sequence.service;

/**
 * @Package com.ebuy.tax.user.api.sequence.dao
 * @author hdq
 * @Date 2018-09-08 16:57:34
 * @Description
 */
public interface SequenceBizService{
	//获取管理后台用户id
	public String genAdminUserId();
	//获取商户管理员用户id
	public String genMerchantUserId();
	//获取商户普通用户id
	public String genSubMerchantUserId();
	//获取商户普通用户id
	public String genCompanyId(String userId);
	//获取客户用户id
	public String genCustomerUserId();
	//获取服务id
	public String genServerId(String serverType);
	//获取子服务id
	public String genSubServerId();
}

