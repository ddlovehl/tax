package com.ebuy.tax.user.implementation.company.dao;

import com.ebuy.tax.user.api.company.entity.Company;
import com.ebuy.tax.user.implementation.company.mapper.CompanyMapper;

import com.ebuy.tax.user.api.company.dao.ICompanyDao;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ebuy.tax.common.constants.SysConstant;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import java.util.List;
/**
 * @Project new_project
 * @Package com.ebuy.tax.user.implementation.company.dao
 * @author hdq
 * @Date 2018-09-05 09:57:25
 * @Description
 */
@Repository(value = "companyDao")

public class CompanyDaoImpl extends ServiceImpl<CompanyMapper, Company> implements ICompanyDao {

        private static final Logger logger = LoggerFactory.getLogger(ICompanyDao.class);

        @Override
        public int queryCount(Company company) {
            return baseMapper.queryCount(company);
        }

        @Override
        public List<Company> queryList(Company company) {
            return baseMapper.queryList(company);
        }

        @Override
        public List<Company> queryListForPage(Company company, Integer pageNo, Integer pageSize) {
        //返回记录行的偏移量
            Integer start = (pageNo-SysConstant.ONE)*(pageSize);
            return baseMapper.queryListForPage(company, start, pageSize);
        }

        @Override
            public Company queryEntityByCompanyEntity(Company company) {
            return baseMapper.queryEntityByCompanyEntity(company);
        }
}
