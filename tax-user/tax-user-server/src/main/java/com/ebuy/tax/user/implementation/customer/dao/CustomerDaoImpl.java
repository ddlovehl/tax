package com.ebuy.tax.user.implementation.customer.dao;

import com.ebuy.tax.user.api.customer.entity.Customer;
import com.ebuy.tax.user.implementation.customer.mapper.CustomerMapper;

import com.ebuy.tax.user.api.customer.dao.ICustomerDao;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ebuy.tax.common.constants.SysConstant;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import java.util.List;
/**
 * @Project new_project
 * @Package com.ebuy.tax.user.implementation.customer.dao
 * @author hdq
 * @Date 2018-09-05 09:57:25
 * @Description
 */
@Repository(value = "customerDao")

public class CustomerDaoImpl extends ServiceImpl<CustomerMapper, Customer> implements ICustomerDao {

        private static final Logger logger = LoggerFactory.getLogger(ICustomerDao.class);

        @Override
        public int queryCount(Customer customer) {
            return baseMapper.queryCount(customer);
        }

        @Override
        public List<Customer> queryList(Customer customer) {
            return baseMapper.queryList(customer);
        }

        @Override
        public List<Customer> queryListForPage(Customer customer, Integer pageNo, Integer pageSize) {
        //返回记录行的偏移量
            Integer start = (pageNo-SysConstant.ONE)*(pageSize);
            return baseMapper.queryListForPage(customer, start, pageSize);
        }

        @Override
            public Customer queryEntityByCustomerEntity(Customer customer) {
            return baseMapper.queryEntityByCustomerEntity(customer);
        }
}
