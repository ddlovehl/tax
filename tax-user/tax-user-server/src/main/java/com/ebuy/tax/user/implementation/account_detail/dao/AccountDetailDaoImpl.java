package com.ebuy.tax.user.implementation.account_detail.dao;

import com.ebuy.tax.user.api.account_detail.entity.AccountDetail;
import com.ebuy.tax.user.implementation.account_detail.mapper.AccountDetailMapper;

import com.ebuy.tax.user.api.user.dao.IUserDao;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ebuy.tax.common.constants.SysConstant;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import java.util.List;
/**
 * @Project new_project
 * @Package com.ebuy.tax.user.implementation.account_detail.dao
 * @author hdq
 * @Date 2018-09-04 21:44:21
 * @Description
 */
@Repository(value = "account_detailDao")

public class AccountDetailDaoImpl extends ServiceImpl<AccountDetailMapper, AccountDetail> implements IAccountDetailDao {

        private static final Logger logger = LoggerFactory.getLogger(IAccountDetailDao.class);

        @Override
        public int queryCount(AccountDetail account_detail) {
            return baseMapper.queryCount(account_detail);
        }

        @Override
        public List<AccountDetail> queryList(AccountDetail account_detail) {
            return baseMapper.queryList(account_detail);
        }

        @Override
        public List<AccountDetail> queryListForPage(AccountDetail account_detail, Integer pageNo, Integer pageSize) {
        //返回记录行的偏移量
            Integer start = (pageNo-SysConstant.ONE)*(pageSize);
            return baseMapper.queryListForPage(account_detail, start, pageSize);
        }

        @Override
            public AccountDetail queryEntityByAccountDetailEntity(AccountDetail account_detail) {
            return baseMapper.queryEntityByAccountDetailEntity(account_detail);
        }
}
