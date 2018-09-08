package com.ebuy.tax.user.controller;


//import com.alibaba.fastjson.JSON;

import com.ebuy.tax.common.entity.ResponseBase;
import com.ebuy.tax.common.utils.ResponseUtil;
import com.ebuy.tax.common.utils.ValidateUtil;
import com.ebuy.tax.user.api.company.entity.Company;
import com.ebuy.tax.user.api.company.service.CompanyBizService;
import com.ebuy.tax.user.api.userAccount.service.UserAccountBizService;
import com.ebuy.tax.user.dto.QueryCompanyListForCtDto;
import com.ebuy.tax.user.dto.QueryCompanyListForItDto;
import com.ebuy.tax.user.model.*;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;

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
	@ApiOperation(value="获取账户余额", notes="获取账户余额--暂写死userid=111111，后续补充")
	@PostMapping(value = "/queryAccountBalance")
	@ApiResponses({
			@ApiResponse(code=200,message="成功",response= QueryAccountBalanceResponse.class),
	})
	public ResponseBase queryAccountBalance() throws Exception {
		log.info("获取我的账户余额");
		BigDecimal balance = userAccountBizService.queryAccountBalance();
		QueryAccountBalanceResponse res = new QueryAccountBalanceResponse();
		res.setBalance(balance.toString());
		return ResponseUtil.fillResponse(res);
	}

}

