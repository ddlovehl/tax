package com.ebuy.tax.common.entity;

import net.sf.json.JSONObject;

import java.io.Serializable;
import java.util.List;

/**
 * @Project new_project
 * @Package com.jsonmedia.shop.core.entity
 * @Author Tom
 * @Date 2018/7/23 23:19
 * @Description
 */
public class PageResult implements Serializable {

    private static final long serialVersionUID = 1489870226049900709L;

    /**
     * 总行数
     */
    protected Long count;

    /**
     * 结果集
     */
    protected List<?> result;

    /**
     *
     * 功能描述: 分页
     *
     * @param:
     * @return: 
     * @author: Tom
     * @date: 2018/7/23 下午11:21
     */
    public PageResult(List<?> result, Long count) {
        super();
        this.result = result;
        this.count = count;
    }
    
    /**
     *
     * 功能描述: 获取总数
     *
     * @param:
     * @return: 
     * @author: Tom
     * @date: 2018/7/23 下午11:20
     */
    public Long getCount() {
        return count;
    }

    /**
     *
     * 功能描述: 获取结果集合
     *
     * @param:
     * @return: 
     * @author: Tom
     * @date: 2018/7/23 下午11:20
     */
    public List<?> getResult() {
        return result;
    }

    @Override
    public String toString() {
        JSONObject json = new JSONObject();
        json.put("total", count);
        json.put("data", result);
        return json.toString();
    }
}
