/**
 *
 */
package com.ebuy.tax.common.entity;

import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * @author hdq
 * @date 2018年7月18日 上午11:12:48
 * @Description 返回报文通用
 */
@SuppressWarnings("serial")
@Data
@ApiModel
public class ResponseBase implements IBaseModel {

    /**
     *
     */
    public ResponseBase() {
        super();
    }

    /**
     * @param errCode 返回码
     * @param errInfo 返回描述
     * @param data     返回数据
     */
    public ResponseBase(String errCode, String errInfo, Object data) {
        this.respCode = errCode;
        this.respDesc = errInfo;
        this.data = data;
    }

    /**
     * @param errCode 返回码
     * @param errInfo 返回描述
     */
    public ResponseBase(String errCode, String errInfo) {
        this.respCode = errCode;
        this.respDesc = errInfo;
    }

    private String respCode;

    private String respDesc;

    private Object data;

}
