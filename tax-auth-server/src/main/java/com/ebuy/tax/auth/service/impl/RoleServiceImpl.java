package com.ebuy.tax.auth.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ebuy.tax.auth.entity.RoleVo;
import com.ebuy.tax.auth.service.RoleService;
import com.ebuy.tax.common.vo.Result;

import lombok.extern.slf4j.Slf4j;

/**
 * 
* @author dd
* @date 2018年9月4日
 */
@Service
@Slf4j
public class RoleServiceImpl implements RoleService {
    @Override
    public Result<List<RoleVo>> getRoleByUserId(String userId) {
        log.info("调用{}失败","getRoleByUserId");
        return Result.failure(100,"调用getRoleByUserId失败");
    }
}
