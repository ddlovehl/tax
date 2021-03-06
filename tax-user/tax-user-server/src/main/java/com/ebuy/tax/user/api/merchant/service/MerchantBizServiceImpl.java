package com.ebuy.tax.user.api.merchant.service;

import com.ebuy.tax.user.api.merchant.entity.Merchant;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.math.BigInteger;
import java.util.LinkedList;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import com.ebuy.tax.common.entity.PageResult;

/**
 * @Package com.ebuy.tax.user.api.merchant.dao
 * @author hdq
 * @Date 2018-09-07 15:01:18
 * @Description
 */
@Slf4j
@Service(value = "merchantBizService")
public class MerchantBizServiceImpl implements MerchantBizService {

    @Resource(name = "merchantDmlService")
    private MerchantDmlService merchantDmlService;

    @Resource(name = "merchantQueryService")
    private MerchantQueryService merchantQueryService;

    /**
     * @author hdq
     * @see         [Merchant]
     * @return List<Merchant>
     * @Description 查询列表
     * @date        2018-09-07 15:01:18
     */
    @Override
    public List<Merchant> queryList(Merchant merchant) {
        return merchantQueryService.queryAllMerchant(merchant);
    }

    /**
     * @author hdq
     * @see         [Merchant] [pageNo] [pageSize]
     * @return PageResult
     * @Description 查询列表(分页)
     * @date        2018-09-07 15:01:18
     */
    @Override
    public PageResult queryListPage(Merchant merchant, Integer pageNo, Integer pageSize) {
        //查询分页列表总数
        int count = merchantQueryService.queryCountMerchant(merchant);
        List<Merchant> list = new LinkedList<Merchant>();
        if (count > 0) {
            list = merchantQueryService.queryListForPageMerchant(merchant, pageNo, pageSize);
        }
        return new PageResult(list, (long) count);
    }

    /**
     * @author hdq
     * @see         [id]
     * @return      Merchant
     * @Description 按id查询
     * @date        2018-09-07 15:01:18
     */
    @Override
    public Merchant queryById(BigInteger id) {
        return merchantQueryService.queryById(id);
    }

    /**
     * @author hdq
     * @see         [ids]
     * @return List<Merchant>
     * @Description 按ids查询列表
     * @date        2018-09-07 15:01:18
     */
    @Override
    public List<Merchant> queryByIds(List<BigInteger> ids) {
        return merchantQueryService.queryByIds(ids);
    }

    /**
     * @author hdq
     * @see         [Merchant]
     * @return      Merchant
     * @Description 根据entity查询一条记录
     * @date        2018-09-07 15:01:18
     */
    @Override
    public Merchant queryByParam(Merchant merchant) {
        return merchantQueryService.queryEntityByMerchantEntity(merchant);
    }

    /**
     * @author hdq
     * @see         [Merchant]
     * @return
     * @Description 添加
     * @date        2018-09-07 15:01:18
     */
    @Override
    public void insert(Merchant merchant) {
            merchantDmlService.insertMerchant(merchant);
    }

    /**
     * @author hdq
     * @see         [Merchant]
     * @return
     * @Description 添加or更新
     * @date        2018-09-07 15:01:18
     */
    @Override
    public void insertOrUpdate(Merchant merchant) {
            merchantDmlService.insertOrUpdateMerchant(merchant);
    }

    /**
     * @author hdq
     * @see         [Merchant]
     * @return
     * @Description 更新
     * @date        2018-09-07 15:01:18
     */
    @Override
    public void update(Merchant merchant) {
            merchantDmlService.updateMerchant(merchant);
    }


}

