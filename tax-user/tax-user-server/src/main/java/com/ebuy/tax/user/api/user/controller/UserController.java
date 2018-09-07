package com.ebuy.tax.user.api.user.controller;


import java.awt.image.BufferedImage;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.RandomUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.ebuy.tax.common.enums.ErrorCodeEnum;
import com.ebuy.tax.common.exception.BusinessException;
import com.ebuy.tax.common.utils.StringUtils;
import com.ebuy.tax.common.utils.VerifyUtils;
import com.ebuy.tax.user.api.user.entity.User;
import com.ebuy.tax.user.api.user.service.UserBizService;
import com.ebuy.tax.user.api.user.vo.GetImgCodeResp;
import com.ebuy.tax.user.api.user.vo.GetSmsCodeVo;
import com.ebuy.tax.user.api.user.vo.RegisterVo;
import com.ebuy.tax.user.api.user.vo.WxIsBindMobileVo;
import com.ebuy.tax.user.redis.RedisUtil;
import com.ebuy.tax.user.vo.Result;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @Project new_project
 * @Package com.ebuy.tax.user.api.user.dao
 * @Author hdq
 * @Date 2018-09-05 09:57:25
 * @Description userController
 */

@Api("用户信息controller")
@RestController
@RequestMapping("/v1/userAdmin")
public class UserController {
	@Autowired
    private UserBizService userBizService;

	@Autowired
	private RedisUtil redisUtil;

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
   
	/**
    * cookie路径
    */
    private static final String COOKIE_PATH = "/tax-gateway-server";
    /**
     * 保存登陆状态
     */
    private static final String COOKIE_USER = "com.tax.user.session";
    
    /**
     * 发送验证码间隔失效时间缓存key前缀
     */
    public static final String CACHE_KEY_PREFIX_SEND_VERIFY_INTERVAL_CODE = "tax_send_verify_interval_code_";

    /**
     * 手机验证码缓存key前缀
     */
    public static final String CACHE_KEY_PREFIX_PHONE_VERIFY_CODE = "tax_phone_verify_code_";
    /**
     * 发送验证码间隔失效时间 单位秒
     */
    public static final Long CACHE_TIMEOUT_SEND_VERIFY_INTERVAL_CODE = 60L;

    /**
     * 验证码失效时间 单位秒
     */
    public static final Long CACHE_TIMEOUT_PHONE_VERIFY_CODE = 180L;

    /**
     * 注册、登陆、微信登陆
     * @return
     */
	@ApiOperation(value="注册、登陆、微信登陆", notes="注册、登陆、微信登陆")
    @PostMapping(value = "/register")
    public Result<Object> register(@RequestBody RegisterVo registerVo,HttpServletResponse response){
		//手机号
		String mobile = registerVo.getMobile();
		//短信验证码
		String smsCode = registerVo.getSmsCode();
		//openid
		String openId = registerVo.getOpenId();
		logger.info("用户发起注册用户或登陆请求,参数:{}",JSON.toJSONString(registerVo));
		//check
		if(StringUtils.isEmpty(mobile)){
			throw new BusinessException(ErrorCodeEnum.ERROR_20001.getCode()+"",ErrorCodeEnum.ERROR_20001.getMsg());
		}
		if(StringUtils.isEmpty(smsCode)){
			throw new BusinessException(ErrorCodeEnum.ERROR_20003.getCode()+"",ErrorCodeEnum.ERROR_20003.getMsg());
		}
		if(!StringUtils.isMobileNO(mobile)){
			throw new BusinessException(ErrorCodeEnum.ERROR_20004.getCode()+"",ErrorCodeEnum.ERROR_20004.getMsg());
		}
		// check验证码（从redis获取短信验证码）
		String code = redisUtil.get(CACHE_KEY_PREFIX_PHONE_VERIFY_CODE+mobile);
		if(StringUtils.isEmpty(code)){
			throw new BusinessException(ErrorCodeEnum.ERROR_20006.getCode()+"",ErrorCodeEnum.ERROR_20006.getMsg());
		}
		if(!code.equals(smsCode)){
			throw new BusinessException(ErrorCodeEnum.ERROR_20006.getCode()+"",ErrorCodeEnum.ERROR_20006.getMsg());
		}
		//查询用户是否已经注册
		User user = new User();
		user.setMobile(mobile);
		User queryUser = userBizService.queryByParam(user);
		logger.info("查询用户信息,参数:{},结果:{}",JSON.toJSONString(user),JSON.toJSONString(queryUser));
		if(!StringUtils.isEmpty(openId)){
			user.setOpenid(openId);
		}
		//未注册、注册用户
		if(queryUser == null){
			user.setId(System.currentTimeMillis()+"");
			user.setCreateTime(new Date());
			user.setUpdateTime(new Date());
			user.setName(mobile);
			userBizService.insert(user);
		}else{
			if(!StringUtils.isEmpty(openId)){
				user.setId(queryUser.getId());
				userBizService.update(user);
			}
		}
		//保存登陆信息
		saveTicket(response,mobile);
		return new Result<Object>();
    	
    }
    /**
     * 微信登陆是否绑定过手机号
     * @return
     */
	@ApiOperation(value="微信登陆是否绑定过手机号", notes="微信登陆是否绑定过手机号")
    @PostMapping(value = "/wxIsBindMobile")
    public Result<Object> wxIsBindMobile(@RequestBody WxIsBindMobileVo wxIsBindMobileVo,HttpServletResponse response){
		String openId = wxIsBindMobileVo.getOpenId();
		logger.info("微信登陆是否绑定过手机号请求,参数:{}",JSON.toJSONString(wxIsBindMobileVo));
		//check
		if(StringUtils.isEmpty(openId)){
			throw new BusinessException(ErrorCodeEnum.ERROR_20008.getCode()+"",ErrorCodeEnum.ERROR_20008.getMsg());
		}
		boolean flag = false;
		//查询微信登陆是否绑定过手机号
		User user = new User();
		user.setOpenid(openId);
		User queryUser = userBizService.queryByParam(user);
		logger.info("查询微信登陆是否绑定过手机号,参数:{},结果:{}",JSON.toJSONString(user),JSON.toJSONString(queryUser));
		//已注册、并已经绑定过手机号返回true
		if(queryUser != null && !StringUtils.isEmpty(queryUser.getMobile())){
			flag = true;
		}
		Result<Object> code = new Result<Object>();
		code.setData(flag);
		return code;
    	
    }
	 /**
     * 保存登录会话并发送cookie
     *
     * @param response
     * @param userInfo
     * @param secretKey
     * @param customerSourceType
     * @param clientVersion
     */
    private void saveTicket(HttpServletResponse response,String mobile) {
        // 获取并保存 ticket
        String ticket = UUID.randomUUID().toString().replaceAll("-", "");
        //TODO 存缓存
        Map<String, String> value = new HashMap<String, String>();
        value.put("mobile", ticket);
        redisUtil.hset(COOKIE_USER, value);
        // 设置customId cookie
        Cookie customIdCk = new Cookie("USER_ID", mobile);
        customIdCk.setPath(COOKIE_PATH);
        response.addCookie(customIdCk);

        // 设置ticket cookie
        Cookie ticketCk = new Cookie("TICKET", ticket);
        ticketCk.setPath(COOKIE_PATH);
        response.addCookie(ticketCk);
    }
    
    /**
     * 获取手机验证码
     * @return
     */
	@SuppressWarnings("unchecked")
	@ApiOperation(value="获取手机验证码", notes="获取手机验证码")
    @PostMapping(value = "/getSmsCode")
    public Result<Object> getSmsCode(@RequestBody GetSmsCodeVo getSmsCodeVo,HttpServletRequest request){
		//手机号
		String mobile = getSmsCodeVo.getMobile();
		//短信验证码
		String imgCode = getSmsCodeVo.getImgCode();
		//imgToken
		String imgToken = getSmsCodeVo.getVerifyId();
		logger.info("获取手机验证码请求,参数:{}",JSON.toJSONString(getSmsCodeVo));
		//check
		if(StringUtils.isEmpty(mobile)){
			return Result.failure(ErrorCodeEnum.ERROR_20001.getCode(), ErrorCodeEnum.ERROR_20001.getMsg());
		}
		if(StringUtils.isEmpty(imgCode)){
			return Result.failure(ErrorCodeEnum.ERROR_20002.getCode(), ErrorCodeEnum.ERROR_20002.getMsg());
		}
		if(!StringUtils.isMobileNO(mobile)){
			return Result.failure(ErrorCodeEnum.ERROR_20004.getCode(), ErrorCodeEnum.ERROR_20004.getMsg());
		}
		//验证图形验证码（从redis获取短信验证码）
	    String code = redisUtil.get(imgToken);
		if(StringUtils.isEmpty(code)){
			return Result.failure(ErrorCodeEnum.ERROR_20005.getCode(), ErrorCodeEnum.ERROR_20005.getMsg());
		}
		code = code.replaceAll("\"", "");
		if(code.compareToIgnoreCase(imgCode)!=0){
			return Result.failure(ErrorCodeEnum.ERROR_20005.getCode(), ErrorCodeEnum.ERROR_20005.getMsg());
		}
		//判断60s内是否重复获取验证码
		String sCode = redisUtil.get(CACHE_KEY_PREFIX_SEND_VERIFY_INTERVAL_CODE+mobile);
		if(!StringUtils.isEmpty(sCode)){
			return Result.failure(ErrorCodeEnum.ERROR_20009.getCode(), ErrorCodeEnum.ERROR_20009.getMsg());
		}
		// 随机生成6位数的验证码
		String newVerify = String.valueOf(RandomUtils.nextInt(101030, 1000000));
		logger.info("手机号：" + mobile + ",产生的验证码:" + newVerify);
		//TODO 发送短信
		/**
		 * TODO 发送短信
		 * TODO 发送短信
		 * TODO 发送短信
		 * TODO 发送短信
		 */
		//发送验证码--间隔时间
		redisUtil.set(CACHE_KEY_PREFIX_SEND_VERIFY_INTERVAL_CODE + mobile, newVerify,CACHE_TIMEOUT_SEND_VERIFY_INTERVAL_CODE);
		//手机验证码--失效时间
		redisUtil.set(CACHE_KEY_PREFIX_PHONE_VERIFY_CODE + mobile, newVerify,CACHE_TIMEOUT_PHONE_VERIFY_CODE);
		return new Result<Object>();
    	
    }
    /**
     * 获取图形验证码
     * @return
     */
	@ApiOperation(value="获取图形验证码", notes="获取图形验证码")
    @PostMapping(value = "/getImgCode")
    public Result<GetImgCodeResp> getImgCode(HttpServletRequest request,HttpServletResponse response){
		
		Result<GetImgCodeResp> result = new Result<GetImgCodeResp>();
		
		String verifyID = UUID.randomUUID().toString().replace("-", "");
		Object[] objs = VerifyUtils.createImage();
		logger.info("图片token{}图形验证码:{}",verifyID,objs[0]);
	    redisUtil.set(verifyID, objs[0], 600L);
	    
	    String imgStr = "";
		try {
		    //将图片输出给浏览器  
		    BufferedImage image = (BufferedImage) objs[1];
		    imgStr = VerifyUtils.imageToBase64(image);
		} catch (Exception e) {
			logger.error("获取图形验证码异常，error:{}",e);
		}
		GetImgCodeResp resp = new GetImgCodeResp(verifyID,imgStr);
		result.setData(resp);
		return result;
    	
    }
}

