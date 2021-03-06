package com.ebuy.tax.user.implementation.user.dao;

import com.ebuy.tax.user.api.user.entity.User;
import com.ebuy.tax.user.implementation.user.mapper.UserMapper;

import com.ebuy.tax.user.api.user.dao.IUserDao;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ebuy.tax.common.constants.SysConstant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import java.util.List;
/**
 * @Project new_project
 * @Package com.ebuy.tax.user.implementation.user.dao
 * @author hdq
 * @Date 2018-09-07 15:01:18
 * @Description
 */
@Slf4j
@Repository(value = "userDao")

public class UserDaoImpl extends ServiceImpl<UserMapper, User> implements IUserDao {

        @Override
        public int queryCount(User user) {
            return baseMapper.queryCount(user);
        }

        @Override
        public List<User> queryList(User user) {
            return baseMapper.queryList(user);
        }

        @Override
        public List<User> queryListForPage(User user, Integer pageNo, Integer pageSize) {
        //返回记录行的偏移量
            Integer start = (pageNo-SysConstant.ONE)*(pageSize);
            return baseMapper.queryListForPage(user, start, pageSize);
        }

        @Override
        public User queryEntityByUserEntity(User user) {
            return baseMapper.queryEntityByUserEntity(user);
        }

}
