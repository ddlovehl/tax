package com.ebuy.tax.auth.service;



import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.ebuy.tax.auth.entity.UserVo;
import com.ebuy.tax.auth.service.impl.UserServiceImpl;
import com.ebuy.tax.common.vo.Result;

/**
 * 获取用户名client
* @author dd
* @date 2018年9月4日
 */
@FeignClient(name = "tax-user-server",fallback = UserServiceImpl.class)
public interface UserService {
    @GetMapping("user/findByUsername/{username}")
    Result<UserVo> findByUsername(@PathVariable("username") String username);
}
