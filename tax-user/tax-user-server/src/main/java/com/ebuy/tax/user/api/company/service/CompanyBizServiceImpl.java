package com.ebuy.tax.user.api.company.service;

import com.ebuy.tax.user.api.company.entity.Company;


import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.math.BigInteger;
import java.util.LinkedList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import com.ebuy.tax.common.entity.PageResult;

/**
 * @Package com.ebuy.tax.user.api.company.dao
 * @author hdq
 * @Date 2018-09-04 21:42:18
 * @Description
 */
public class CompanyBizServiceImpl implements CompanyBizService{

    private static final Logger logger = LoggerFactory.getLogger(CompanyBizServiceImpl.class);

    private CompanyDmlService companyDmlService;

    private CompanyQueryService companyQueryService;

    /**
     * @author      hdq
     * @see         [Company]
     * @return      List<Company>
     * @Description 查询列表
     * @date        2018-09-04 21:42:18
     */
    public List<Company> queryList(Company company){
        return companyQueryService.queryAllCompany(company);
    }

    /**
     * @author      hdq
     * @see         [Company] [pageNo] [pageSize]
     * @return          PageResult
     * @Description 查询列表(分页)
     * @date        2018-09-04 21:42:18
     */
    public PageResult queryListPage(Company company, Integer pageNo, Integer  pageSize){
        //查询分页列表总数
        int count = companyQueryService.queryCountCompany(company);
        List<Company> list = new LinkedList<Company>();
        if(count > 0) {
            list = companyQueryService.queryListForPageCompany(company,pageNo,pageSize);
        }
        return  new PageResult(list,(long)count);
    }

    /**
     * @author      hdq
     * @see         [id]
     * @return      Company
     * @Description 按id查询
     * @date        2018-09-04 21:42:18
     */
    public Company queryById(BigInteger id){
        return companyQueryService.queryById(id);
    }

    /**
     * @author      hdq
     * @see         [ids]
     * @return      List<Company>
     * @Description 按ids查询列表
     * @date        2018-09-04 21:42:18
     */
    public List<Company> queryByIds(List<BigInteger> ids){
        return companyQueryService.queryByIds(ids);
    }

    /**
     * @author      hdq
     * @see         [Company]
     * @return      Company
     * @Description 根据entity查询一条记录
     * @date        2018-09-04 21:42:18
     */
    public Company queryByParam(Company company){
        return companyQueryService.queryEntityByCompanyEntity(company);
    }

    /**
     * @author      hdq
     * @see         [Company]
     * @return
     * @Description 添加
     * @date        2018-09-04 21:42:18
     */
    public void insert(Company company){
        companyDmlService.insertCompany(company);
    }

    /**
     * @author      hdq
     * @see         [Company]
     * @return
     * @Description 添加or更新
     * @date        2018-09-04 21:42:18
     */
    public void insertOrUpdate(Company company){
        companyDmlService.insertOrUpdateCompany(company);
    }

    /**
     * @author      hdq
     * @see         [Company]
     * @return
     * @Description 更新
     * @date        2018-09-04 21:42:18
     */
    public void update(Company company){
        companyDmlService.updateCompany(company);
    }


}

