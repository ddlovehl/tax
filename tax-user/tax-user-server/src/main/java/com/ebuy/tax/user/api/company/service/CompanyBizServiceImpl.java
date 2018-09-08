package com.ebuy.tax.user.api.company.service;

import com.ebuy.tax.common.constants.ResponseConstant;
import com.ebuy.tax.common.utils.CommonExceptionUtils;
import com.ebuy.tax.user.api.company.entity.Company;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.math.BigInteger;
import java.util.LinkedList;
import java.util.stream.Collectors;

import com.ebuy.tax.user.api.customer.entity.Customer;
import com.ebuy.tax.user.api.customer.service.CustomerDmlService;
import com.ebuy.tax.user.api.customer.service.CustomerQueryService;
import com.ebuy.tax.user.api.invited.entity.Invited;
import com.ebuy.tax.user.api.invited.service.InvitedQueryService;
import com.ebuy.tax.user.dto.QueryCompanyListForCtDto;
import com.ebuy.tax.user.dto.QueryCompanyListForItDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import com.ebuy.tax.common.entity.PageResult;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Package com.ebuy.tax.user.api.company.dao
 * @author hdq
 * @Date 2018-09-07 15:01:17
 * @Description
 */
@Slf4j
@Transactional
@Service(value = "companyBizService")
public class CompanyBizServiceImpl implements CompanyBizService {

    @Resource(name = "companyDmlService")
    private CompanyDmlService companyDmlService;

    @Resource(name = "companyQueryService")
    private CompanyQueryService companyQueryService;

    @Resource(name = "customerQueryService")
    private CustomerQueryService customerQueryService;

    @Resource(name = "customerDmlService")
    private CustomerDmlService customerDmlService;

    @Resource(name = "invitedQueryService")
    private InvitedQueryService invitedQueryService;

    /**
     * @author hdq
     * @see         [Company]
     * @return List<Company>
     * @Description 查询列表
     * @date        2018-09-07 15:01:17
     */
    @Override
    public List<Company> queryList(Company company) {
        return companyQueryService.queryAllCompany(company);
    }

    /**
     * @author hdq
     * @see         [Company] [pageNo] [pageSize]
     * @return PageResult
     * @Description 查询列表(分页)
     * @date        2018-09-07 15:01:17
     */
    @Override
    public PageResult queryListPage(Company company, Integer pageNo, Integer pageSize) {
        //查询分页列表总数
        int count = companyQueryService.queryCountCompany(company);
        List<Company> list = new LinkedList<Company>();
        if (count > 0) {
            list = companyQueryService.queryListForPageCompany(company, pageNo, pageSize);
        }
        return new PageResult(list, (long) count);
    }

    /**
     * @author hdq
     * @see         [id]
     * @return      Company
     * @Description 按id查询
     * @date        2018-09-07 15:01:17
     */
    @Override
    public Company queryById(String id) {
        return companyQueryService.queryById(id);
    }

    /**
     * @author hdq
     * @see         [ids]
     * @return List<Company>
     * @Description 按ids查询列表
     * @date        2018-09-07 15:01:17
     */
    @Override
    public List<Company> queryByIds(List<String> ids) {
        return companyQueryService.queryByIds(ids);
    }

    /**
     * @author hdq
     * @see         [Company]
     * @return      Company
     * @Description 根据entity查询一条记录
     * @date        2018-09-07 15:01:17
     */
    @Override
    public Company queryByParam(Company company) {
        return companyQueryService.queryEntityByCompanyEntity(company);
    }

    /**
     * @author hdq
     * @see         [Company]
     * @return
     * @Description 我的公司--新增
     * @date        2018-09-07 15:01:17
     */
    @Override
    public void insert(Company company) {
        Company param = new Company();
        param.setCompanyName(company.getCompanyName());
        //根据公司名称查询公司信息
        Company result = companyQueryService.queryEntityByCompanyEntity(param);

        CommonExceptionUtils.isNull(result, ResponseConstant.ERR_CODE_USER.COMPANY_NAME_EXIST,ResponseConstant.ERR_INFO_USER.COMPANY_NAME_EXIST);

        company.setId(System.currentTimeMillis()+"");//TODO 公司id待定
        companyDmlService.insertCompany(company);

        Customer customer = new Customer();
        customer.setCompanyId(company.getId());
        customer.setUserId("32161321651516");//TODO 暂时写死
        customer.setCompanyId(System.currentTimeMillis()+"");//TODO customerId待定
        //建立关联数据
        customerDmlService.insertCustomer(customer);
    }

    /**
     * @author hdq
     * @see         [Company]
     * @return
     * @Description 添加or更新
     * @date        2018-09-07 15:01:17
     */
    @Override
    public void insertOrUpdate(Company company) {
            companyDmlService.insertOrUpdateCompany(company);
    }

    /**
     * @author hdq
     * @see         [Company]
     * @return
     * @Description 更新
     * @date        2018-09-07 15:01:17
     */
    @Override
    public void update(Company company) {
        company.setUpdateTime(new Date());
        companyDmlService.updateCompany(company);
    }

    /**
     * @author hdq
     * @see         [Company]
     * @return
     * @Description 查询我的公司--创建列表
     * @date        2018-09-07 15:01:17
     */
    @Override
    public List<QueryCompanyListForCtDto> queryCompanyListForCt(String userId){
        Customer customerParam = new Customer();
        customerParam.setUserId(userId);
        //查询客户表关联的公司数据
        List<Customer> customerList = customerQueryService.queryAllCustomer(customerParam);

        //未查询到结果集直接返回
        if(customerList.isEmpty()){
            return null;
        }
        //单独取出公司id的list
        List<String> companyIds = customerList.stream().map(Customer :: getCompanyId).collect(Collectors.toList());
        //根据公司idlist查询公司列表信息
        List<Company> companyList = companyQueryService.queryByIds(companyIds);
        List<QueryCompanyListForCtDto> queryCompanyListDtoListForCt = new LinkedList<QueryCompanyListForCtDto>();
        //合并结果集
        for(Customer customer : customerList){
            for(Company company : companyList){
                if(customer.getCompanyId().equals(company.getId())){
                    QueryCompanyListForCtDto queryCompanyListForCtDto = new QueryCompanyListForCtDto();
                    queryCompanyListForCtDto.setCompanyId(customer.getCompanyId());
                    queryCompanyListForCtDto.setCompanyName(company.getCompanyName());
                    queryCompanyListForCtDto.setCustomerStatus(customer.getCustomerStatus().toString());
                    queryCompanyListForCtDto.setIsDefault("0");//TODO 需要改表结构， 暂时先写死  0否 1是
                    queryCompanyListDtoListForCt.add(queryCompanyListForCtDto);
                }
            }
        }

        return queryCompanyListDtoListForCt;
    }

    /**
     * @author hdq
     * @see         [Company]
     * @return
     * @Description 查询我的公司--创建列表
     * @date        2018-09-07 15:01:17
     */
    @Override
    public List<QueryCompanyListForItDto> queryCompanyListForIt(String userId){
        Invited invitedParam = new Invited();
        invitedParam.setInvitedUserId(userId);
        //查询被邀请的公司数据
        List<Invited> invitedList = invitedQueryService.queryAllInvited(invitedParam);

        //未查询到结果集直接返回
        if(invitedList.isEmpty()){
            return null;
        }
        //单独取出公司id的list
        List<String> companyIds = invitedList.stream().map(Invited :: getCompanyId).collect(Collectors.toList());
        //根据公司idlist查询公司列表信息
        List<Company> companyList = companyQueryService.queryByIds(companyIds);
        List<QueryCompanyListForItDto> queryCompanyListForItDtoList = new LinkedList<QueryCompanyListForItDto>();
        //合并结果集
        for(Invited invited : invitedList){
            for(Company company : companyList){
                if(invited.getCompanyId().equals(company.getId())){
                    QueryCompanyListForItDto queryCompanyListForItDto = new QueryCompanyListForItDto();
                    queryCompanyListForItDto.setCompanyId(invited.getCompanyId());
                    queryCompanyListForItDto.setCompanyName(company.getCompanyName());
                    queryCompanyListForItDtoList.add(queryCompanyListForItDto);
                }
            }
        }

        return queryCompanyListForItDtoList;
    }
}

