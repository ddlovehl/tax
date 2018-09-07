package com.ebuy.tax.user.implementation.accountDetail.dao;

import com.ebuy.tax.user.api.accountDetail.entity.AccountDetail;
import com.ebuy.tax.user.implementation.accountDetail.mapper.AccountDetailMapper;

import com.ebuy.tax.user.api.accountDetail.dao.IAccountDetailDao;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ebuy.tax.common.constants.SysConstant;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import java.util.List;
/**
 * @Project new_project
 * @Package com.ebuy.tax.user.implementation.accountDetail.dao
 * @author hdq
 * @Date 2018-09-05 18:26:55
 * @Description
 */
@Repository(value = "accountDetailDao")

public class AccountDetailDaoImpl extends ServiceImpl<AccountDetailMapper, AccountDetail> implements IAccountDetailDao {

        private static final Logger logger = LoggerFactory.getLogger(IAccountDetailDao.class);

        @Override
        public int queryCount(AccountDetail accountDetail) {
            return baseMapper.queryCount(accountDetail);
        }

        @Override
        public List<AccountDetail> queryList(AccountDetail accountDetail) {
            return baseMapper.queryList(accountDetail);
        }

        @Override
        public List<AccountDetail> queryListForPage(AccountDetail accountDetail, Integer pageNo, Integer pageSize) {
        //返回记录行的偏移量
            Integer start = (pageNo-SysConstant.ONE)*(pageSize);
            return baseMapper.queryListForPage(accountDetail, start, pageSize);
        }

        @Override
            public AccountDetail queryEntityByAccountDetailEntity(AccountDetail accountDetail) {
            return baseMapper.queryEntityByAccountDetailEntity(accountDetail);
        }
}
