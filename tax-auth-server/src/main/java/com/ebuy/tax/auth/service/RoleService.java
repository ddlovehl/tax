package com.ebuy.tax.auth.service;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.ebuy.tax.auth.entity.RoleVo;
import com.ebuy.tax.auth.service.impl.RoleServiceImpl;
import com.ebuy.tax.common.vo.Result;


/**
 * 获取角色client
* @author dd
* @date 2018年9月4日
 */
@FeignClient(name = "tax-user-server",fallback = RoleServiceImpl.class)
public interface RoleService {
    @GetMapping("role/getRoleByUserId/{userId}")
    Result<List<RoleVo>> getRoleByUserId(@PathVariable("userId") String userId);
}
