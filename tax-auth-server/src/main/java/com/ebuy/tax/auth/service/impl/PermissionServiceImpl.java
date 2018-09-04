package com.ebuy.tax.auth.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ebuy.tax.auth.entity.MenuVo;
import com.ebuy.tax.auth.service.PermissionService;
import com.ebuy.tax.common.vo.Result;

import lombok.extern.slf4j.Slf4j;

/**
 * 
* @author dd
* @date 2018年9月4日
 */
@Slf4j
@Service
public class PermissionServiceImpl implements PermissionService {
    @Override
    public Result<List<MenuVo>> getRolePermission(Integer roleId) {
        log.info("调用{}失败","getRolePermission");
        return Result.failure(100,"调用getRolePermission失败");
    }
}
