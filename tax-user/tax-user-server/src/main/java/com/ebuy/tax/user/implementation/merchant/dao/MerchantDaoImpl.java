package com.ebuy.tax.user.implementation.merchant.dao;

import com.ebuy.tax.user.api.merchant.entity.Merchant;
import com.ebuy.tax.user.implementation.merchant.mapper.MerchantMapper;

import com.ebuy.tax.user.api.merchant.dao.IMerchantDao;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ebuy.tax.common.constants.SysConstant;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import java.util.List;
/**
 * @Project new_project
 * @Package com.ebuy.tax.user.implementation.merchant.dao
 * @author hdq
 * @Date 2018-09-05 18:26:55
 * @Description
 */
@Repository(value = "merchantDao")

public class MerchantDaoImpl extends ServiceImpl<MerchantMapper, Merchant> implements IMerchantDao {

        private static final Logger logger = LoggerFactory.getLogger(IMerchantDao.class);

        @Override
        public int queryCount(Merchant merchant) {
            return baseMapper.queryCount(merchant);
        }

        @Override
        public List<Merchant> queryList(Merchant merchant) {
            return baseMapper.queryList(merchant);
        }

        @Override
        public List<Merchant> queryListForPage(Merchant merchant, Integer pageNo, Integer pageSize) {
        //返回记录行的偏移量
            Integer start = (pageNo-SysConstant.ONE)*(pageSize);
            return baseMapper.queryListForPage(merchant, start, pageSize);
        }

        @Override
            public Merchant queryEntityByMerchantEntity(Merchant merchant) {
            return baseMapper.queryEntityByMerchantEntity(merchant);
        }
}
