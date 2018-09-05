package com.ebuy.tax.user.api.company.dao;

import com.ebuy.tax.user.api.company.entity.Company;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * @Project new_project
 * @Package com.ebuy.tax.user.api.company.dao
 * @Author hdq
 * @Date 2018-09-05 18:26:55
 * @Description IcompanyDao
 */
public interface ICompanyDao extends IService<Company> {

    /**
     * @author      hdq
     * @see         [Company]
     * @return      java.lang.Long
     * @Description 查询列表总数
     * @date        2018-09-05 18:26:55
     */
    public int queryCount(Company company);

    /**
     * @author      hdq
     * @see         [Company]
     * @return      List<Company>
     * @Description 查询列表
     * @date        2018-09-05 18:26:55
     */
    public List<Company> queryList(Company company);

    /**
     * @author      hdq
     * @see         List<Company>
     * @return      java.lang.Long
     * @Description 查询列表
     * @date        2018-09-05 18:26:55
     */
    public List<Company>  queryListForPage(Company company,Integer pageNo,Integer pageSize);

    /**
     * @author      hdq
     * @see         [Company]
     * @return      List<Company>
     * @Description 查询列表
     * @date        2018-09-05 18:26:55
     */
    public Company queryEntityByCompanyEntity(Company company);
}
