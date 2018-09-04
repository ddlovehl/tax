package com.ebuy.tax.common.exception;

import com.ebuy.tax.common.utils.StringUtils;

import java.io.Serializable;
import java.text.MessageFormat;

/**
 * @Project new_project
 * @Package com.jsonmedia.shop.core.exception
 * @Author Tom
 * @Date 2018/7/23 21:36
 * @Description
 */
public class AbstractGenericException extends RuntimeException implements Serializable {

    private static final long serialVersionUID = -6785244690920409384L;

    protected String errorCode;

    protected String message;

    private Object[] arguments;

    private String fullMessage;

    private static String pattern = "errorCode:{0},message:{1}";

    public AbstractGenericException(String errorCode) {
        this.errorCode = errorCode;
    }

    public AbstractGenericException(String errorCode, String message) {
        super(MessageFormat.format(pattern, errorCode, message));
        this.errorCode = errorCode;
        this.message = message;
        this.fullMessage = MessageFormat.format(pattern, this.errorCode, message);
    }

    public AbstractGenericException(String errorCode, Throwable throwable) {
        super(errorCode, throwable);
        this.errorCode = errorCode;
        this.fullMessage = StringUtils.toString(throwable);
        this.message = MessageFormat.format(pattern, this.errorCode, message);
    }

    public AbstractGenericException(String errorCode, String message, Throwable throwable) {
        super(message, throwable);
        this.fullMessage = MessageFormat.format(pattern, this.errorCode, message) + StringUtils.toString(throwable);
        this.errorCode = errorCode;
        this.message = message;
    }

    public AbstractGenericException(String errorCode, Object... arguments) {
        this.errorCode = errorCode;
        this.arguments = arguments;
    }

    public String getErrorCode() {
        return errorCode;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public Object[] getArguments() {
        return arguments;
    }

    public void setArguments(Object[] arguments) {
        this.arguments = arguments;
    }

    public String getFullMessage() {
        return fullMessage;
    }

    public void setFullMessage(String fullMessage) {
        this.fullMessage = fullMessage;
    }
}
