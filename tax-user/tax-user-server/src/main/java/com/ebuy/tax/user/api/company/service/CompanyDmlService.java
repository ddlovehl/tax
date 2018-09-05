package com.ebuy.tax.user.api.company.service;

import com.ebuy.tax.user.api.company.entity.Company;


import  java.util.List;
import java.math.BigInteger;

/**
 * @Package com.ebuy.tax.user.api.company.dao
 * @author hdq
 * @Date 2018-09-05 18:26:55
 * @Description Company操作服务
 */
public interface CompanyDmlService{

    /**
     * @author      hdq
     * @see         [Company]
     * @return      boolean
     * @Description 添加信息
     * @date        2018-09-05 18:26:55
     */
    public boolean insertCompany(Company company);

    /**
     * @author      hdq
     * @see         [Company]
     * @return      boolean
     * @Description 批量增加
     * @date        2018-09-05 18:26:55
     */
    public boolean insertCompanys(List<Company> list);

    /**
     * @author      hdq
     * @see         [Company]
     * @return      boolean
     * @Description 增加or更新
     * @date        2018-09-05 18:26:55
     */
    public boolean insertOrUpdateCompany(Company company);

    /**
     * @author      hdq
     * @see         [Company]
     * @return      boolean
     * @Description 更新
     * @date        2018-09-05 18:26:55
     */
    public boolean updateCompany(Company company);

    /**
     * @author      hdq
     * @see         [Company]
     * @return      boolean
     * @Description 更新
     * @date        2018-09-05 18:26:55
     */
    public boolean updateCompanys(List<Company> list);

    /**
     * @author      hdq
     * @see         [Company]
     * @return      boolean
     * @Description 删除
     * @date        2018-09-05 18:26:55
     */
    public boolean deleteCompany(BigInteger id);

    /**
     * @author      hdq
     * @see         [Company]
     * @return      boolean
     * @Description 根据id批量删除
     * @date        2018-09-05 18:26:55
     */
    public boolean deleteCompanys(List<BigInteger> ids);
}

