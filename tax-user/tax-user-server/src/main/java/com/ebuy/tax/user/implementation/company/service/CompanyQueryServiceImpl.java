package com.ebuy.tax.user.implementation.company.service;

import com.ebuy.tax.user.api.company.entity.Company;
import com.ebuy.tax.user.api.company.dao.ICompanyDao;
import com.ebuy.tax.user.api.company.service.CompanyQueryService;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.math.BigInteger;

/**
 * @Package com.ebuy.tax.user.implementation.company.dao
 * @author hdq
 * @Date 2018-09-07 15:01:17
 * @Description å…¬å¸è¡¨ 查询服务
 */
@Service(value = "companyQueryService")
@CacheConfig(cacheNames = {"CompanyCache"})
public class CompanyQueryServiceImpl implements CompanyQueryService{

    @Resource(name = "companyDao")
    private ICompanyDao companyDao;

    /**
     * @author      hdq
     * @see         [Company]
     * @return      boolean
     * @Description 根据id查询
     * @date        2018-09-07 15:01:17
     */
    @Override
    public Company queryById(BigInteger id){
        return companyDao.selectById(id);
    }

    /**
     * @author      hdq
     * @see         [Company]
     * @return      boolean
     * @Description 根据ids查询列表
     * @date        2018-09-07 15:01:17
     */
    @Override
    public List<Company> queryByIds(List<String> ids){
        return (List<Company>)companyDao.selectBatchIds(ids);
    }

    /**
     * @author      hdq
     * @see         [Company]
     * @return      boolean
     * @Description 查询列表总数
     * @date        2018-09-07 15:01:17
     */
    @Override
    public int queryCountCompany(Company company){
        return companyDao.queryCount(company);
    }

    /**
     * @author      hdq
     * @see         [Company]
     * @return      boolean
     * @Description 查询列表
     * @date        2018-09-07 15:01:17
     */
    @Override
    public List<Company> queryAllCompany(Company company){
        return companyDao.queryList(company);
    }

    /**
     * @author      hdq
     * @see         [Company]
     * @return      boolean
     * @Description 查询列表分页
     * @date        2018-09-07 15:01:17
     */
    @Override
    public List<Company> queryListForPageCompany(Company company,Integer pageNo,Integer pageSize){
        return companyDao.queryListForPage(company,pageNo,pageSize);
    }

    /**
     * @author      hdq
     * @see         [Company]
     * @return      boolean
     * @Description 查询列表分页
     * @date        2018-09-07 15:01:17
     */
    @Override
    public Company queryEntityByCompanyEntity(Company company){
        return companyDao.queryEntityByCompanyEntity(company);
    }


}

