package com.ebuy.tax.user.implementation.userAccount.dao;

import com.ebuy.tax.user.api.userAccount.entity.UserAccount;
import com.ebuy.tax.user.implementation.userAccount.mapper.UserAccountMapper;

import com.ebuy.tax.user.api.userAccount.dao.IUserAccountDao;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ebuy.tax.common.constants.SysConstant;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import java.util.List;
/**
 * @Project new_project
 * @Package com.ebuy.tax.user.implementation.userAccount.dao
 * @author hdq
 * @Date 2018-09-05 18:26:56
 * @Description
 */
@Repository(value = "userAccountDao")

public class UserAccountDaoImpl extends ServiceImpl<UserAccountMapper, UserAccount> implements IUserAccountDao {

        private static final Logger logger = LoggerFactory.getLogger(IUserAccountDao.class);

        @Override
        public int queryCount(UserAccount userAccount) {
            return baseMapper.queryCount(userAccount);
        }

        @Override
        public List<UserAccount> queryList(UserAccount userAccount) {
            return baseMapper.queryList(userAccount);
        }

        @Override
        public List<UserAccount> queryListForPage(UserAccount userAccount, Integer pageNo, Integer pageSize) {
        //返回记录行的偏移量
            Integer start = (pageNo-SysConstant.ONE)*(pageSize);
            return baseMapper.queryListForPage(userAccount, start, pageSize);
        }

        @Override
            public UserAccount queryEntityByUserAccountEntity(UserAccount userAccount) {
            return baseMapper.queryEntityByUserAccountEntity(userAccount);
        }
}
