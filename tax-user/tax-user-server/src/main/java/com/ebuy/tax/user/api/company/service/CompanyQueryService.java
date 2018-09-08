package com.ebuy.tax.user.api.company.service;

import com.ebuy.tax.user.api.company.entity.Company;


import  java.util.List;
import java.math.BigInteger;

/**
 * @Package com.ebuy.tax.user.api.company.dao
 * @author hdq
 * @Date 2018-09-07 15:01:17
 * @Description å…¬å¸è¡¨ 查询服务
 */
public interface CompanyQueryService{

    /**
     * @author      hdq
     * @see         [Company]
     * @return      boolean
     * @Description 根据id查询
     * @date        2018-09-07 15:01:17
     */
    public Company queryById(BigInteger id);

    /**
     * @author      hdq
     * @see         [Company]
     * @return      boolean
     * @Description 根据ids查询列表
     * @date        2018-09-07 15:01:17
     */
    public List<Company> queryByIds(List<String> ids);

    /**
     * @author      hdq
     * @see         [Company]
     * @return      boolean
     * @Description 查询列表总数
     * @date        2018-09-07 15:01:17
     */
    public int queryCountCompany(Company company);

    /**
     * @author      hdq
     * @see         [Company]
     * @return      boolean
     * @Description 查询列表
     * @date        2018-09-07 15:01:17
     */
    public List<Company> queryAllCompany(Company company);

    /**
     * @author      hdq
     * @see         [Company]
     * @return      boolean
     * @Description 查询列表分页
     * @date        2018-09-07 15:01:17
     */
    public List<Company> queryListForPageCompany(Company company,Integer pageNo,Integer pageSize);

    /**
     * @author      hdq
     * @see         [Company]
     * @return      boolean
     * @Description 查询列表分页
     * @date        2018-09-07 15:01:17
     */
    public Company queryEntityByCompanyEntity(Company company);

}

