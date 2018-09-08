package com.ebuy.tax.user.controller;


import com.ebuy.tax.common.entity.ResponseBase;
import com.ebuy.tax.common.enums.ErrorCodeEnum;
import com.ebuy.tax.common.exception.BusinessException;
import com.ebuy.tax.common.utils.*;
import com.ebuy.tax.common.vo.Result;
import com.ebuy.tax.user.api.user.entity.User;
import com.ebuy.tax.user.api.user.service.UserBizService;
import com.ebuy.tax.user.api.user.vo.GetImgCodeVo;
import com.ebuy.tax.user.api.user.vo.GetSmsCodeVo;
import com.ebuy.tax.user.api.user.vo.RegisterVo;
import com.ebuy.tax.user.api.user.vo.WxIsBindMobileVo;
import com.ebuy.tax.user.model.QueryUserInfoRequest;
import com.ebuy.tax.user.model.QueryUserInfoResponse;
import com.ebuy.tax.user.model.UpdateUserInfoRequest;
import com.ebuy.tax.user.redis.RedisUtil;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @Project new_project
 * @Package com.ebuy.tax.user.api.user.dao
 * @Author hdq
 * @Date 2018-09-05 09:57:25
 * @Description userController
 */

@Slf4j
@Api("用户信息controller")
@RestController
@RequestMapping("/v1/userAdmin")
public class UserController {
	@Resource(name = "userBizService")
    private UserBizService userBizService;

	@Autowired
	private RedisUtil redisUtil;

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
    public Result<Object> register(@RequestBody RegisterVo registerVo,HttpServletResponse response) throws Exception{
		//手机号
		String mobile = registerVo.getMobile();
		//短信验证码
		String smsCode = registerVo.getSmsCode();
		//openid
		String openId = registerVo.getOpenId();
		log.info("用户发起注册用户或登陆请求,参数:{}", registerVo);
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
		log.info("查询用户信息,参数:{},结果:{}",user,queryUser);
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
		log.info("微信登陆是否绑定过手机号请求,参数:{}",wxIsBindMobileVo);
		//check
		if(StringUtils.isEmpty(openId)){
			throw new BusinessException(ErrorCodeEnum.ERROR_20008.getCode()+"",ErrorCodeEnum.ERROR_20008.getMsg());
		}
		boolean flag = false;
		//查询微信登陆是否绑定过手机号
		User user = new User();
		user.setOpenid(openId);
		User queryUser = userBizService.queryByParam(user);
		log.info("查询微信登陆是否绑定过手机号,参数:{},结果:{}",user,queryUser);
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
	@ApiOperation(value="获取手机验证码", notes="获取手机验证码")
    @PostMapping(value = "/getSmsCode")
    public Result<Object> getSmsCode(@RequestBody GetSmsCodeVo getSmsCodeVo,HttpServletRequest request){
		//手机号
		String mobile = getSmsCodeVo.getMobile();
		//短信验证码
		String imgCode = getSmsCodeVo.getImgCode();
		//deviceId
		String deviceId = getSmsCodeVo.getDeviceId();
		log.info("获取手机验证码请求,参数:{}",getSmsCodeVo);
		//check
		if(StringUtils.isEmpty(mobile)){
			throw new BusinessException(ErrorCodeEnum.ERROR_20001.getCode()+"",ErrorCodeEnum.ERROR_20001.getMsg());
		}
		if(StringUtils.isEmpty(imgCode)){
			throw new BusinessException(ErrorCodeEnum.ERROR_20002.getCode()+"",ErrorCodeEnum.ERROR_20002.getMsg());
		}
		if(!StringUtils.isMobileNO(mobile)){
			throw new BusinessException(ErrorCodeEnum.ERROR_20004.getCode()+"",ErrorCodeEnum.ERROR_20004.getMsg());
		}
		//验证图形验证码（从redis获取短信验证码）
	    String code = redisUtil.get(deviceId);
		if(StringUtils.isEmpty(code)){
			throw new BusinessException(ErrorCodeEnum.ERROR_20005.getCode()+"",ErrorCodeEnum.ERROR_20005.getMsg());
		}
		code = code.replaceAll("\"", "");
		if(!code.equals(imgCode)){
			throw new BusinessException(ErrorCodeEnum.ERROR_20005.getCode()+"",ErrorCodeEnum.ERROR_20005.getMsg());
		}
		//判断60s内是否重复获取验证码
		String sCode = redisUtil.get(CACHE_KEY_PREFIX_SEND_VERIFY_INTERVAL_CODE+mobile);
		if(!StringUtils.isEmpty(sCode)){
			throw new BusinessException(ErrorCodeEnum.ERROR_20009.getCode()+"",ErrorCodeEnum.ERROR_20009.getMsg());
		}
		// 随机生成6位数的验证码
		String newVerify = String.valueOf(RandomUtils.nextInt(101030, 1000000));
		log.info("手机号：" + mobile + ",产生的验证码:" + newVerify);
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
    public Result<Object> getImgCode(@RequestBody GetImgCodeVo getImgCodeVo,HttpServletRequest request,HttpServletResponse response){
		//deviceId
		String deviceId = getImgCodeVo.getDeviceId();
		log.info("获取图形验证码请求,参数:{}", getImgCodeVo);
		//check
		if(StringUtils.isEmpty(deviceId)){
			throw new BusinessException(ErrorCodeEnum.ERROR_20007.getCode()+"",ErrorCodeEnum.ERROR_20007.getMsg());
		}
		Object[] objs = VerifyUtils.createImage();
		log.info("图形验证码:{}",objs[0]);
	    redisUtil.set(deviceId, objs[0], 600L);
		try {
		    /*//将图片输出给浏览器  
		    BufferedImage image = (BufferedImage) objs[1];
		    response.setContentType("image/png");
			OutputStream os = response.getOutputStream();
			ImageIO.write(image, "png", os);*/
		} catch (Exception e) {
			log.error("获取图形验证码异常，error:{}",e);
		}
	    
		Result<Object> code = new Result<Object>();
		code.setData(objs[0]);
		return code;
    	
    }


	/**
	 * @return java.lang.String
	 * @author hdq
	 * @Description 获取用户信息
	 * @date 2018-09-05 09:57:24
	 *  @see   [obj]
	 */
	@ApiOperation(value="获取用户信息", notes="获取用户信息, 暂需要传userid，待完善登录接口保存用户信息后，不需要传参数，直接获取用户信息")// 使用该注解描述接口方法信息
	@PostMapping(value = "/queryUserInfo")
	@ApiResponses({
			@ApiResponse(code=200,message="成功",response= QueryUserInfoResponse.class),
	})
	public ResponseBase queryUserInfoRequest(@RequestBody @ApiParam(name="QueryUserInfoRequest",value="传入json格式",required=true) QueryUserInfoRequest req) throws Exception {
		log.info("获取用户信息，参数：{}",req);
		//参数校验
		ValidateUtil.valid(req);
		User user = new User();
		user.setMobile(req.getUserId());
		User result = userBizService.queryByParam(user);
		//QueryUserInfoResponse用于返回转化json字符串的封装类
		QueryUserInfoResponse res = new QueryUserInfoResponse();
		BeanUtils.copyProperties(result,res);
		return ResponseUtil.fillResponse(res);
	}

	/**
	 * @return java.lang.String
	 * @author hdq
	 * @Description 更新用户信息
	 * @date 2018-09-05 09:57:24
	 *  @see   [obj]
	 */
	@ApiOperation(value="更新用户信息", notes="更新用户信息---暂需要传userid，待完善登录接口保存用户信息后，不需要传userid")// 使用该注解描述接口方法信息
	@PostMapping(value = "/updateUserInfo")
	public ResponseBase updateUserInfo(@RequestBody @ApiParam(name="QueryUserInfoRequest",value="传入json格式",required=true) UpdateUserInfoRequest req) throws Exception {
		log.info("更新用户信息参数：{}",req);
		//参数校验
		ValidateUtil.valid(req);
		User user = new User();
		BeanUtils.copyProperties(req,user);
		userBizService.update(user);
		return ResponseUtil.successResponse();
	}
}

