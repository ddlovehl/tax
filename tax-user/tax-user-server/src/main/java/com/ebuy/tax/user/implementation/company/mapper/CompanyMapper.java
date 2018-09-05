package com.ebuy.tax.user.implementation.company.mapper;

import com.ebuy.tax.user.api.company.entity.Company;
import com.ebuy.tax.common.entity.SuperMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
/**
 * @Package com.ebuy.tax.user.implementation.company.dao
 * @author hdq
 * @Date 2018-09-05 18:26:55
 * @Description å…¬å¸è¡¨ Mapper 接口
 */
public interface CompanyMapper extends SuperMapper<Company> {

    int queryCount(Company company);

    List<Company> queryList(Company company);

    List<Company> queryListForPage( @Param("entity")Company company, @Param("start")Integer start, @Param("pageSize")Integer pageSize);

    Company queryEntityByCompanyEntity(Company company);
}
