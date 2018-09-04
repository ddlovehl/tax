package com.ebuy.tax.common.exception;

/**
 * @Project new_project
 * @Package com.jsonmedia.shop.core.exception
 * @Author Tom
 * @Date 2018/7/23 22:08
 * @Description
 */
public class BusinessException extends AbstractGenericException {

    private static final long serialVersionUID = -4519317699123717034L;

    /**
     * <br>------------------------------<br>
     *
     * @param errorCode
     */
    public BusinessException(String errorCode) {
        super(errorCode);
    }

    /**
     * <br>------------------------------<br>
     *
     * @param errorCode
     * @param message
     */
    public BusinessException(String errorCode, String message) {
        super(errorCode, message);
    }

    /**
     * <br>------------------------------<br>
     *
     * @param errorCode
     * @param message
     * @param throwable
     */
    public BusinessException(String errorCode, String message, Throwable throwable) {
        super(errorCode, message, throwable);
    }

    /**
     * <br>------------------------------<br>
     *
     * @param errorCode
     * @param throwable
     */
    public BusinessException(String errorCode, Throwable throwable) {
        super(errorCode, throwable);
    }

    /**
     * <br>------------------------------<br>
     *
     * @param errorCode
     * @param arguments
     */
    public BusinessException(String errorCode, Object... arguments) {
        super(errorCode, arguments);
    }

}
