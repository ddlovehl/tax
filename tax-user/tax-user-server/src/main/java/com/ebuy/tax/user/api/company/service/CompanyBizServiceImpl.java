package com.ebuy.tax.user.api.company.service;

import com.ebuy.tax.common.constants.ResponseConstant;
import com.ebuy.tax.common.utils.CommonExceptionUtils;
import com.ebuy.tax.common.utils.PageUtils;
import com.ebuy.tax.common.utils.StringUtils;
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
import com.ebuy.tax.user.dto.CompanyDto;
import com.ebuy.tax.user.dto.QueryCompanyListForCtDto;
import com.ebuy.tax.user.dto.QueryCompanyListForItDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import com.ebuy.tax.common.entity.PageResult;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author hdq
 * @Package com.ebuy.tax.user.api.company.dao
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
     * @return List<Company>
     * @author hdq
     * @Description 查询列表
     * @date 2018-09-07 15:01:17
     * @see [Company]
     */
    @Override
    public List<Company> queryList(Company company) {
        return companyQueryService.queryAllCompany(company);
    }

    /**
     * @return PageResult
     * @author hdq
     * @Description 查询列表(分页)
     * @date 2018-09-07 15:01:17
     * @see [Company] [pageNo] [pageSize]
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
     * @return Company
     * @author hdq
     * @Description 按id查询
     * @date 2018-09-07 15:01:17
     * @see [id]
     */
    @Override
    public Company queryById(String id) {
        return companyQueryService.queryById(id);
    }

    /**
     * @return List<Company>
     * @author hdq
     * @Description 按ids查询列表
     * @date 2018-09-07 15:01:17
     * @see [ids]
     */
    @Override
    public List<Company> queryByIds(List<String> ids) {
        return companyQueryService.queryByIds(ids);
    }

    /**
     * @return Company
     * @author hdq
     * @Description 根据entity查询一条记录
     * @date 2018-09-07 15:01:17
     * @see [Company]
     */
    @Override
    public Company queryByParam(Company company) {
        return companyQueryService.queryEntityByCompanyEntity(company);
    }

    /**
     * @return
     * @author hdq
     * @Description 我的公司--新增
     * @date 2018-09-07 15:01:17
     * @see [Company]
     */
    @Override
    public void insert(CompanyDto companyDto) {
        Company param = new Company();
        param.setCompanyName(companyDto.getCompanyName());
        //根据公司名称查询公司信息
        Company result = companyQueryService.queryEntityByCompanyEntity(param);

        CommonExceptionUtils.isNotNull(result, ResponseConstant.ERR_CODE_USER.COMPANY_NAME_EXIST, ResponseConstant.ERR_INFO_USER.COMPANY_NAME_EXIST);

        companyDto.setId(System.currentTimeMillis() + "");//TODO 公司id待定
        //dto转化
        Company company = new Company();
        BeanUtils.copyProperties(companyDto,company);
        companyDmlService.insertCompany(company);

        Customer customer = new Customer();
        customer.setCompanyId(companyDto.getId());
        customer.setUserId(companyDto.getUserId());
        customer.setId(System.currentTimeMillis() + "");//TODO customerId待定
        //建立关联数据
        customerDmlService.insertCustomer(customer);
    }

    /**
     * @return
     * @author hdq
     * @Description 添加or更新
     * @date 2018-09-07 15:01:17
     * @see [Company]
     */
    @Override
    public void insertOrUpdate(Company company) {
        companyDmlService.insertOrUpdateCompany(company);
    }

    /**
     * @return
     * @author hdq
     * @Description 更新
     * @date 2018-09-07 15:01:17
     * @see [Company]
     */
    @Override
    public void update(Company company) {
        Company param = new Company();
        param.setCompanyName(company.getCompanyName());
        //根据公司名称查询公司信息
        Company result = companyQueryService.queryEntityByCompanyEntity(param);

        CommonExceptionUtils.isNotNull(result, ResponseConstant.ERR_CODE_USER.COMPANY_NAME_EXIST, ResponseConstant.ERR_INFO_USER.COMPANY_NAME_EXIST);

        company.setUpdateTime(new Date());
        companyDmlService.updateCompany(company);
    }

    /**
     * @return
     * @author hdq
     * @Description 查询我的公司--创建列表 (分页)
     * @date 2018-09-07 15:01:17
     * @see [Company]
     */
    @Override
    public PageResult queryCompanyListForCt(String userId, Integer pageNo, Integer pageSize) {

        Customer customerParam = new Customer();
        customerParam.setUserId(userId);
        //查询分页列表总数
        int count = customerQueryService.queryCountCustomer(customerParam);

        List<QueryCompanyListForCtDto> queryCompanyListDtoListForCt = new LinkedList<QueryCompanyListForCtDto>();

        if (count > 0) {
            //查询客户表关联的公司数据
            List<Customer> customerList = customerQueryService.queryAllCustomer(customerParam);

            //单独取出公司id的list
            List<String> companyIdList = customerList.stream().map(Customer::getCompanyId).collect(Collectors.toList());

            //截取分页conpanyIds
            List<String> companyIds = PageUtils.subListForPage(companyIdList,pageNo,pageSize);
            //根据公司idlist查询公司列表信息
            List<Company> companyList = companyQueryService.queryByIds(companyIds);

            //合并结果集
            for (Customer customer : customerList) {
                for (Company company : companyList) {
                    if (customer.getCompanyId().equals(company.getId())) {
                        QueryCompanyListForCtDto queryCompanyListForCtDto = new QueryCompanyListForCtDto();
                        queryCompanyListForCtDto.setCompanyId(customer.getCompanyId());
                        queryCompanyListForCtDto.setCompanyName(company.getCompanyName());
                        queryCompanyListForCtDto.setCustomerStatus(customer.getCustomerStatus() == null ? null : customer.getCustomerStatus().toString());
                        queryCompanyListForCtDto.setIsDefault(company.getIsDefault()==null?null:company.getIsDefault().toString());//TODO 需要改表结构， 暂时先写死  0否 1是
                        queryCompanyListDtoListForCt.add(queryCompanyListForCtDto);
                    }
                }
            }

        }
        return new PageResult(queryCompanyListDtoListForCt, (long) count);

    }

    /**
     * @return
     * @author hdq
     * @Description 查询我的公司--邀请列表 (分页)
     * @date 2018-09-07 15:01:17
     * @see [Company]
     */
    @Override
    public PageResult queryCompanyListForIt(String userId, Integer pageNo, Integer pageSize) {
        Invited invitedParam = new Invited();
        invitedParam.setInvitedUserId(userId);

        //查询分页列表总数
        int count = invitedQueryService.queryCountInvited(invitedParam);

        List<QueryCompanyListForItDto> queryCompanyListForItDtoList = new LinkedList<QueryCompanyListForItDto>();

        if (count > 0) {
            //查询被邀请的公司数据
            List<Invited> invitedList = invitedQueryService.queryAllInvited(invitedParam);

            //单独取出公司id的list
            List<String> companyIdList = invitedList.stream().map(Invited::getCompanyId).collect(Collectors.toList());
            //截取分页conpanyIds
            List<String> conpanyIds = PageUtils.subListForPage(companyIdList,pageNo,pageSize);

            //根据公司idlist查询公司列表信息
            List<Company> companyList = companyQueryService.queryByIds(conpanyIds);
            //合并结果集
            for (Invited invited : invitedList) {
                for (Company company : companyList) {
                    if (invited.getCompanyId().equals(company.getId())) {
                        QueryCompanyListForItDto queryCompanyListForItDto = new QueryCompanyListForItDto();
                        queryCompanyListForItDto.setCompanyId(invited.getCompanyId());
                        queryCompanyListForItDto.setCompanyName(company.getCompanyName());
                        queryCompanyListForItDtoList.add(queryCompanyListForItDto);
                    }
                }
            }
        }

        return new PageResult(queryCompanyListForItDtoList, (long) count);
    }
}

