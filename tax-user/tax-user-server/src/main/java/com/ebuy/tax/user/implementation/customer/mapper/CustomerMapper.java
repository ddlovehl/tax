package com.ebuy.tax.user.implementation.customer.mapper;

import com.ebuy.tax.user.api.customer.entity.Customer;
import com.ebuy.tax.common.entity.SuperMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
/**
 * @Package com.ebuy.tax.user.implementation.customer.dao
 * @author hdq
 * @Date 2018-09-04 21:41:20
 * @Description å®¢æˆ·è¡¨ Mapper 接口
 */
public interface CustomerMapper extends SuperMapper<Customer> {

    int queryCount(Customer customer);

    List<Customer> queryList(Customer customer);

    List<Customer> queryListForPage( @Param("entity")Customer customer, @Param("start")Integer start, @Param("pageSize")Integer pageSize);

    Customer queryEntityByCustomerEntity(Customer customer);
}
