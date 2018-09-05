package com.ebuy.tax.user.api.merchant.service;

import com.ebuy.tax.user.api.merchant.entity.Merchant;

import com.ebuy.tax.common.entity.PageResult;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.math.BigInteger;

/**
 * @Package com.ebuy.tax.user.api.merchant.dao
 * @author hdq
 * @Date 2018-09-05 18:26:55
 * @Description
 */
public interface MerchantBizService{

    /**
     * @author      hdq
     * @see         [Merchant]
     * @return      List<Merchant>
     * @Description 查询列表
     * @date        2018-09-05 18:26:55
     */
    public List<Merchant> queryList(Merchant merchant);

    /**
     * @author      hdq
     * @see         [Merchant] [pageNo] [pageSize]
     * @return          PageResult
     * @Description 查询列表(分页)
     * @date        2018-09-05 18:26:55
     */
    public PageResult queryListPage(Merchant merchant, Integer pageNo, Integer  pageSize);

    /**
     * @author      hdq
     * @see         [id]
     * @return      Merchant
     * @Description 按id查询
     * @date        2018-09-05 18:26:55
     */
    public Merchant queryById(BigInteger id);

    /**
     * @author      hdq
     * @see         [ids]
     * @return      List<Merchant>
     * @Description 按ids查询列表
     * @date        2018-09-05 18:26:55
     */
    public List<Merchant> queryByIds(List<BigInteger> ids);

    /**
     * @author      hdq
     * @see         [Merchant]
     * @return      Merchant
     * @Description 根据entity查询一条记录
     * @date        2018-09-05 18:26:55
     */
    public Merchant queryByParam(Merchant merchant);

    /**
     * @author      hdq
     * @see         [Merchant]
     * @return
     * @Description 添加
     * @date        2018-09-05 18:26:55
     */
    public void insert(Merchant merchant);

    /**
     * @author      hdq
     * @see         [Merchant]
     * @return
     * @Description 添加or更新
     * @date        2018-09-05 18:26:55
     */
    public void insertOrUpdate(Merchant merchant);

    /**
     * @author      hdq
     * @see         [Merchant]
     * @return
     * @Description 更新
     * @date        2018-09-05 18:26:55
     */
    public void update(Merchant merchant);


}

