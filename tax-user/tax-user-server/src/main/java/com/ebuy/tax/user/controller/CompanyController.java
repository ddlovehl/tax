package com.ebuy.tax.user.controller;



import com.ebuy.tax.common.constants.SysConstant;
import com.ebuy.tax.common.entity.PageResult;
import com.ebuy.tax.common.entity.ResponseBase;
import com.ebuy.tax.common.utils.ResponseUtil;
import com.ebuy.tax.common.utils.StringUtils;
import com.ebuy.tax.common.utils.ValidateUtil;
import com.ebuy.tax.user.api.company.entity.Company;
import com.ebuy.tax.user.api.company.service.CompanyBizService;
import com.ebuy.tax.user.dto.CompanyDto;
import com.ebuy.tax.user.model.*;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.beanutils.PropertyUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.*;

/**
 * @Project new_project
 * @Package com.ebuy.tax.user.api.user.dao
 * @Author hdq
 * @Date 2018-09-05 09:57:25
 * @Description userController
 */

@Slf4j
@Api("公司信息controller")
@RestController
@RequestMapping("/v1/companyAdmin")
public class CompanyController {

	@Resource(name = "companyBizService")
    private CompanyBizService companyBizService;

	/**
	 * @return java.lang.String
	 * @author hdq
	 * @Description 获取我的公司-创建列表
	 * @date 2018-09-05 09:57:24
	 *  @see   [obj]
	 */
	@ApiOperation(value="我的公司列表-创建列表", notes="获取我的公司-创建列表")
	@PostMapping(value = "/queryCompanyListForCt")
	@ApiResponses({
			@ApiResponse(code=200,message="成功",response= QueryCompanyListForCtResponse.class),
	})
	public ResponseBase queryCompanyListForCt(@RequestBody @ApiParam(name="QueryCompanyListForCtRequest",value="传入json格式",required=true) QueryCompanyListForCtRequest req) throws Exception {
		log.info("获取我的公司-创建列表，参数：{}",req);
		//参数校验
		ValidateUtil.valid(req);
		//为空填充默认pageNo,pageSize
		Integer pageNo = StringUtils.isBlank(req.getPageNo()) ? SysConstant.PAGE_NO:Integer.parseInt(req.getPageNo());
		Integer pageSize = StringUtils.isBlank(req.getPageSize()) ? SysConstant.PAGE_SIZE:Integer.parseInt(req.getPageSize());
		PageResult result = companyBizService.queryCompanyListForCt(req.getUserId(), pageNo, pageSize);
		//转化结果集 填充页面大小，页码
		return ResponseUtil.fillResponse(new QueryCompanyListForCtResponse(result,pageNo.toString(),pageSize.toString()));
	}

	/**
	 * @return java.lang.String
	 * @author hdq
	 * @Description 获取我的公司-邀请列表
	 * @date 2018-09-05 09:57:24
	 *  @see   [obj]
	 */
	@ApiOperation(value="我的公司列表-邀请列表", notes="获取我的公司-邀请列表")
	@PostMapping(value = "/queryCompanyListForIt")
	@ApiResponses({
			@ApiResponse(code=200,message="成功",response= QueryCompanyListForItResponse.class),
	})
	public ResponseBase queryCompanyListForIt(@RequestBody @ApiParam(name="QueryCompanyListForItRequest",value="传入json格式",required=true) QueryCompanyListForItRequest req) throws Exception {
		log.info("获取我的公司-邀请列表，参数：{}",req);
		//参数校验
		ValidateUtil.valid(req);
		//为空填充默认pageNo,pageSize
		Integer pageNo = StringUtils.isBlank(req.getPageNo()) ? SysConstant.PAGE_NO:Integer.parseInt(req.getPageNo());
		Integer pageSize = StringUtils.isBlank(req.getPageSize()) ? SysConstant.PAGE_SIZE:Integer.parseInt(req.getPageSize());
		PageResult result = companyBizService.queryCompanyListForIt(req.getUserId(),pageNo,pageSize);
		//转化结果集 填充页面大小，页码
		return ResponseUtil.fillResponse(new QueryCompanyListForItResponse(result,pageNo.toString(),pageSize.toString()));
	}

	/**
	 * @return java.lang.String
	 * @author hdq
	 * @Description 新增公司
	 * @date 2018-09-05 09:57:24
	 *  @see   [obj]
	 */
	@ApiOperation(value="我的公司详情--新增公司", notes="新增公司")
	@PostMapping(value = "/addCompany")
	public ResponseBase addCompany(@RequestBody @ApiParam(name="AddCompanyRequest",value="传入json格式",required=true) AddCompanyRequest req) throws Exception {
		log.info("新增公司参数：{}",req);
		//参数校验
		ValidateUtil.valid(req);
		CompanyDto companyDto = new CompanyDto();
		//req转化dto
		BeanUtils.copyProperties(req,companyDto);
		companyBizService.insert(companyDto);
		return ResponseUtil.successResponse();
	}

	/**
	 * @return java.lang.String
	 * @author hdq
	 * @Description 编辑公司
	 * @date 2018-09-05 09:57:24
	 *  @see   [obj]
	 */
	@ApiOperation(value="我的公司详情--编辑公司", notes="编辑公司")
	@PostMapping(value = "/updateCompany")
	public ResponseBase updateCompany(@RequestBody @ApiParam(name="UpdateCompanyRequest",value="传入json格式",required=true) UpdateCompanyRequest req) throws Exception {
		log.info("编辑公司参数：{}",req);
		//参数校验
		ValidateUtil.valid(req);
		Company company = new Company();
		//req转化entity
		BeanUtils.copyProperties(req,company);
		company.setId(req.getCompanyId());
		companyBizService.update(company);
		return ResponseUtil.successResponse();
	}

	/**acc
	 * @return jalang.String
	 * @author hdq
	 * @Description 获取公司信息
	 * @date 2018-09-05 09:57:24
	 *  @see   [obj]
	 */
	@ApiOperation(value="我的公司详情--获取公司信息", notes="获取公司信息")
	@ApiResponses({
			@ApiResponse(code=200,message="成功",response= QueryCompanyResponse.class),
	})
	@PostMapping(value = "/queryCompany")
	public ResponseBase queryCompany(@RequestBody @ApiParam(name="QueryCompanyRequest",value="传入json格式",required=true) QueryCompanyRequest req) throws Exception {
		log.info("获取公司信息参数：{}",req);
		//参数校验
		ValidateUtil.valid(req);
		Company company = companyBizService.queryById(req.getCompanyId());
		QueryCompanyResponse res = new QueryCompanyResponse();
		PropertyUtils.copyProperties(company,res);
		return ResponseUtil.fillResponse(res);
	}

}

