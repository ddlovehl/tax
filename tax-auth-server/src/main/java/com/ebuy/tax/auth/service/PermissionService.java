package com.ebuy.tax.auth.service;


import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.ebuy.tax.auth.entity.MenuVo;
import com.ebuy.tax.auth.service.impl.PermissionServiceImpl;
import com.ebuy.tax.common.vo.Result;

/**
 * 
* @author dd
* @date 2018年9月4日
 */
@FeignClient(name = "tax-user-server",fallback = PermissionServiceImpl.class)
public interface PermissionService {
    @GetMapping("permission/getRolePermission/{roleId}")
    Result<List<MenuVo>> getRolePermission(@PathVariable("roleId") Integer roleId);
}
