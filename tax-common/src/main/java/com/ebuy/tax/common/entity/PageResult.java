package com.ebuy.tax.common.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
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
@Data
@ApiModel
public class PageResult implements Serializable {

    /**
     * 总行数
     */
    @ApiModelProperty(value="总行数",name="count")
    protected Long count;

    /**
     * 结果集
     */
    @ApiModelProperty(value="结果集",name="result")
    protected List<?> result;

    /**
     * 页码
     */
    @ApiModelProperty(value="页码",name="pageNo")
    protected String pageNo;

    /**
     * 页面大小
     */
    @ApiModelProperty(value="页面大小",name="pageSize")
    protected String pageSize;

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

}
