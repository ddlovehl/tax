package com.ebuy.tax.user.controller;



import com.ebuy.tax.common.constants.SysConstant;
import com.ebuy.tax.common.entity.PageResult;
import com.ebuy.tax.common.entity.ResponseBase;
import com.ebuy.tax.common.utils.ResponseUtil;
import com.ebuy.tax.common.utils.StringUtils;
import com.ebuy.tax.common.utils.ValidateUtil;
import com.ebuy.tax.user.api.userAccount.entity.UserAccount;
import com.ebuy.tax.user.api.userAccount.service.UserAccountBizService;
import com.ebuy.tax.user.model.*;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * @Project new_project
 * @Package com.ebuy.tax.user.api.user.dao
 * @Author hdq
 * @Date 2018-09-05 09:57:25
 * @Description userController
 */

@Slf4j
@Api("账户controller")
@RestController
@RequestMapping("/v1/accountAdmin")
public class AccountController {

	@Resource(name = "userAccountBizService")
    private UserAccountBizService userAccountBizService;

	/**
	 * @return java.lang.String
	 * @author hdq
	 * @Description 获取账户余额
	 * @date 2018-09-05 09:57:24
	 *  @see   [obj]
	 */
	@ApiOperation(value="我的账户--获取账户余额", notes="获取账户余额")
	@PostMapping(value = "/queryAccountBalance")
	@ApiResponses({
			@ApiResponse(code=200,message="成功",response= QueryAccountBalanceResponse.class),
	})
	public ResponseBase queryAccountBalance(@RequestBody @ApiParam(name="QueryAccountBalanceRequest",value="传入json格式",required=true) QueryAccountBalanceRequest req) throws Exception {
		log.info("获取我的账户余额");
		//参数校验
		ValidateUtil.valid(req);
		BigDecimal balance = userAccountBizService.queryAccountBalance(req.getUserId());
		QueryAccountBalanceResponse res = new QueryAccountBalanceResponse();
		res.setBalance(balance.toString());
		return ResponseUtil.fillResponse(res);
	}

	/**
	 * @return java.lang.String
	 * @author hdq
	 * @Description 获取账户余额
	 * @date 2018-09-05 09:57:24
	 *  @see   [obj]
	 */
	@ApiOperation(value="我的账户--获取账户详情列表", notes="获取账户详情列表")
	@PostMapping(value = "/queryAccountDetailList")
	@ApiResponses({
			@ApiResponse(code=200,message="成功",response= QueryAccountDetailListResponse.class),
	})
	public ResponseBase queryAccountDetailList(@RequestBody @ApiParam(name="QueryAccountDetailListRequest",value="传入json格式",required=true) QueryAccountDetailListRequest req) throws Exception {
		log.info("获取我的账户详情列表");
		//参数校验
		ValidateUtil.valid(req);
		//为空填充默认pageNo,pageSize
		Integer pageNo = StringUtils.isBlank(req.getPageNo()) ? SysConstant.PAGE_NO:Integer.parseInt(req.getPageNo());
		Integer pageSize = StringUtils.isBlank(req.getPageSize()) ? SysConstant.PAGE_SIZE:Integer.parseInt(req.getPageSize());
		UserAccount param = new UserAccount();
		param.setUserId(req.getUserId());
		PageResult result = userAccountBizService.queryListPage(param,pageNo,pageSize);
		//转化结果集 填充页面大小，页码
		return ResponseUtil.fillResponse(new QueryAccountDetailListResponse(result,pageNo.toString(),pageSize.toString()));
	}
}

