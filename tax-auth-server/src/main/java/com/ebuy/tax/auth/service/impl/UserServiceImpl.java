package com.ebuy.tax.auth.service.impl;

import org.springframework.stereotype.Service;

import com.ebuy.tax.auth.entity.UserVo;
import com.ebuy.tax.auth.service.UserService;
import com.ebuy.tax.common.vo.Result;

import lombok.extern.slf4j.Slf4j;

/**
 * 
* @author dd
* @date 2018年9月4日
 */
@Service
@Slf4j
public class UserServiceImpl implements UserService {
    @Override
    public Result<UserVo> findByUsername(String username) {
        log.info("调用{}失败","findByUsername");
        return Result.failure(100,"调用findByUsername接口失败");
    }
}
