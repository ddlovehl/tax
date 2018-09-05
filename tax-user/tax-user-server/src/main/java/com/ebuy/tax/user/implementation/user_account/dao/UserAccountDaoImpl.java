package com.ebuy.tax.user.implementation.user_account.dao;

import com.ebuy.tax.user.api.user_account.dao.IUserAccountDao;
import com.ebuy.tax.user.api.user_account.entity.UserAccount;
import com.ebuy.tax.user.implementation.user_account.mapper.UserAccountMapper;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ebuy.tax.common.constants.SysConstant;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import java.util.List;
/**
 * @Project new_project
 * @Package com.ebuy.tax.user.implementation.user_account.dao
 * @author hdq
 * @Date 2018-09-04 21:43:56
 * @Description
 */
@Repository(value = "user_accountDao")

public class UserAccountDaoImpl extends ServiceImpl<UserAccountMapper, UserAccount> implements IUserAccountDao {

        private static final Logger logger = LoggerFactory.getLogger(IUserAccountDao.class);

        @Override
        public int queryCount(UserAccount user_account) {
            return baseMapper.queryCount(user_account);
        }

        @Override
        public List<UserAccount> queryList(UserAccount user_account) {
            return baseMapper.queryList(user_account);
        }

        @Override
        public List<UserAccount> queryListForPage(UserAccount user_account, Integer pageNo, Integer pageSize) {
        //返回记录行的偏移量
            Integer start = (pageNo-SysConstant.ONE)*(pageSize);
            return baseMapper.queryListForPage(user_account, start, pageSize);
        }

        @Override
            public UserAccount queryEntityByUserAccountEntity(UserAccount user_account) {
            return baseMapper.queryEntityByUserAccountEntity(user_account);
        }
}
