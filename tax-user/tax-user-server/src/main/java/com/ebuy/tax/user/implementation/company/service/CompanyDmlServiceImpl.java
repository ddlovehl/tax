package com.ebuy.tax.user.implementation.company.service;

import com.ebuy.tax.user.api.company.entity.Company;
import com.ebuy.tax.user.api.company.dao.ICompanyDao;
import com.ebuy.tax.user.api.company.service.CompanyDmlService;
import com.ebuy.tax.common.constants.ResponseConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.math.BigInteger;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.transaction.annotation.Transactional;
import com.ebuy.tax.common.exception.SystemException;
import javax.annotation.Resource;

/**
 * @Package com.ebuy.tax.user.implementation.company.dao
 * @author hdq
 * @Date 2018-09-05 09:57:25
 * @Description å…¬å¸è¡¨ 操作服务
 */
@CacheConfig(cacheNames = {"CompanyCache}"})
public class CompanyDmlServiceImpl implements CompanyDmlService {

    private static final Logger log = LoggerFactory.getLogger(CompanyDmlServiceImpl.class);

    @Resource(name = "companyDao")
    private ICompanyDao companyDao;

    /**
     * @author      hdq
     * @see         [Company]
     * @return      boolean
     * @Description 添加信息
     * @date        2018-09-05 09:57:25
     */
    @Override
    @CacheEvict(allEntries = true, beforeInvocation = true)
    public boolean insertCompany(Company company){
        boolean flag = true;
        try{
            flag = companyDao.insert(company);
        } catch (Exception e){
            log.error("CompanyDmlServiceImpl-insertCompany添加异常", e);
            throw new SystemException(ResponseConstant.ERR_CODE.FAIL, "添加用户信息失败");
        }
        return flag;
    }

    /**
     * @author      hdq
     * @see         [Company]
     * @return      boolean
     * @Description 批量增加
     * @date        2018-09-05 09:57:25
     */
    @Override
    @CacheEvict(allEntries = true, beforeInvocation = true)
    public boolean insertCompanys(List<Company> list){
        boolean flag = true;
        try{
            flag = companyDao.insertBatch(list);
        } catch (Exception e){
            log.error("CompanyDmlServiceImpl-insertCompanys添加异常", e);
            throw new SystemException(ResponseConstant.ERR_CODE.FAIL, "添加用户信息失败");
        }
        return flag;
    }

    /**
     * @author      hdq
     * @see         [Company]
     * @return      boolean
     * @Description 增加or更新
     * @date        2018-09-05 09:57:25
     */
    @Override
    @CacheEvict(allEntries = true, beforeInvocation = true)
    public boolean insertOrUpdateCompany(Company company){
        boolean flag = true;
        try{
        //存在更新记录，否插入一条记录
        flag = companyDao.insertOrUpdate(company);
        } catch (Exception e){
           log.info("CompanyDmlServiceImpl-update更新异常",e);
            throw new SystemException(ResponseConstant.ERR_CODE.FAIL, "更新用户信息失败");
        }
        return flag;
    }

    /**
     * @author      hdq
     * @see         [Company]
     * @return      boolean
     * @Description 更新
     * @date        2018-09-05 09:57:25
     */
    @Override
    @CacheEvict(allEntries = true, beforeInvocation = true)
    public boolean updateCompany(Company company){
        boolean flag = true;
        try{
            flag = companyDao.updateById(company);
        } catch (Exception e){
            log.error("CompanyDmlServiceImpl-updateCompany更新异常",e);
            throw new SystemException(ResponseConstant.ERR_CODE.FAIL, "更新用户信息失败");
        }
        return flag;
    }

    /**
     * @author      hdq
     * @see         [Company]
     * @return      boolean
     * @Description 更新
     * @date        2018-09-05 09:57:25
     */
    @Override
    @CacheEvict(allEntries = true, beforeInvocation = true)
    public boolean updateCompanys(List<Company> list){
        boolean flag = true;
        try{
            flag = companyDao.updateBatchById(list);
        } catch (Exception e){
            log.error("CompanyDmlServiceImpl-updateCompanys更新异常",e);
            throw new SystemException(ResponseConstant.ERR_CODE.FAIL, "批量更新用户信息失败");
        }
        return flag;
    }

    /**
     * @author      hdq
     * @see         [Company]
     * @return      boolean
     * @Description 删除
     * @date        2018-09-05 09:57:25
     */
    @Override
    @CacheEvict(allEntries = true, beforeInvocation = true)
    public boolean deleteCompany(BigInteger id){
        boolean flag = true;
        try{
            flag = companyDao.deleteById(Long.parseLong(id.toString()));
        } catch (Exception e){
            log.error("CompanyDmlServiceImpl-deleteCompany删除异常",e);
            throw new SystemException(ResponseConstant.ERR_CODE.FAIL, "删除用户信息失败");
        }
        return flag;
    }

    /**
     * @author      hdq
     * @see         [Company]
     * @return      boolean
     * @Description 根据id批量删除
     * @date        2018-09-05 09:57:25
     */
    @Override
    @CacheEvict(allEntries = true, beforeInvocation = true)
    public boolean deleteCompanys(List<BigInteger> ids){
        boolean flag = true;
        try{
            flag = companyDao.deleteBatchIds(ids);
        } catch (Exception e){
            log.error("CompanyDmlServiceImpl-deleteCompanys删除异常",e);
            throw new SystemException(ResponseConstant.ERR_CODE.FAIL, "批量删除用户信息失败");
        }
        return flag;
    }
}

