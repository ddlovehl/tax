package com.ebuy.tax.user.api.company.service;

import com.ebuy.tax.user.api.company.entity.Company;

import com.ebuy.tax.common.entity.PageResult;
import com.ebuy.tax.user.dto.CompanyDto;
import com.ebuy.tax.user.dto.QueryCompanyListForCtDto;
import com.ebuy.tax.user.dto.QueryCompanyListForItDto;

import java.util.List;
import java.math.BigInteger;

/**
 * @Package com.ebuy.tax.user.api.company.dao
 * @author hdq
 * @Date 2018-09-07 15:01:17
 * @Description
 */
public interface CompanyBizService{

    /**
     * @author      hdq
     * @see         [Company]
     * @return      List<Company>
     * @Description 查询列表
     * @date        2018-09-07 15:01:17
     */
    public List<Company> queryList(Company company);

    /**
     * @author      hdq
     * @see         [Company] [pageNo] [pageSize]
     * @return          PageResult
     * @Description 查询列表(分页)
     * @date        2018-09-07 15:01:17
     */
    public PageResult queryListPage(Company company, Integer pageNo, Integer  pageSize);

    /**
     * @author      hdq
     * @see         [id]
     * @return      Company
     * @Description 按id查询
     * @date        2018-09-07 15:01:17
     */
    public Company queryById(String id);

    /**
     * @author      hdq
     * @see         [ids]
     * @return      List<Company>
     * @Description 按ids查询列表
     * @date        2018-09-07 15:01:17
     */
    public List<Company> queryByIds(List<String> ids);

    /**
     * @author      hdq
     * @see         [Company]
     * @return      Company
     * @Description 根据entity查询一条记录
     * @date        2018-09-07 15:01:17
     */
    public Company queryByParam(Company company);

    /**
     * @author      hdq
     * @see         [Company]
     * @return
     * @Description 新增公司
     * @date        2018-09-07 15:01:17
     */
    public void insert(CompanyDto companyDto);

    /**
     * @author      hdq
     * @see         [Company]
     * @return
     * @Description 添加or更新
     * @date        2018-09-07 15:01:17
     */
    public void insertOrUpdate(Company company);

    /**
     * @author      hdq
     * @see         [Company]
     * @return
     * @Description 更新
     * @date        2018-09-07 15:01:17
     */
    public void update(Company company);

    /**
     * @return java.lang.String
     * @param userId pageNo pageSize
     * @author hdq
     * @Description 查询我的公司--创建列表 (分页)
     * @date 2018/9/7 19:20
     */
    public PageResult queryCompanyListForCt(String userId, Integer pageNo, Integer pageSize);

    /**
     * @return java.lang.String
     * @param userId pageNo pageSize
     * @author hdq
     * @Description 查询我的公司--邀请列表
     * @date 2018/9/7 19:20
     */
    public PageResult queryCompanyListForIt(String userId, Integer pageNo, Integer pageSize);
}

