package com.ebuy.tax.common.exception;

import com.baomidou.mybatisplus.extension.api.IErrorCode;

/**
 * @Project new_project
 * @Package com.jsonmedia.shop
 * @Author Tom
 * @Date 2018/7/24 08:33
 * @Description
 */
public enum ErrorCode implements IErrorCode {
    TEST("1000", "测试错误编码");

    private String code;
    private String msg;

    ErrorCode(final String code, final String msg) {
        this.code = code;
        this.msg = msg;
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getMsg() {
        return msg;
    }
}