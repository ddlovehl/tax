package com.ebuy.tax.common.exception;

/**
 * @Project new_project
 * @Package com.jsonmedia.shop.core.exception
 * @Author Tom
 * @Date 2018/7/24 00:37
 * @Description
 */
public class SystemException extends AbstractGenericException {

    private static final long serialVersionUID = -4519317699123717034L;

    /**
     * <br>------------------------------<br>
     *
     * @param code
     */
    public SystemException(String code) {
        super(code);
    }

    /**
     * <br>------------------------------<br>
     *
     * @param code
     * @param message
     */
    public SystemException(String code, String message) {
        super(code, message);
    }

    /**
     * <br>------------------------------<br>
     *
     * @param code
     * @param message
     * @param throwable
     */
    public SystemException(String code, String message, Throwable throwable) {
        super(code, message, throwable);
    }

    /**
     * <br>------------------------------<br>
     *
     * @param code
     * @param throwable
     */
    public SystemException(String code, Throwable throwable) {
        super(code, throwable);
    }

    /**
     * <br>------------------------------<br>
     *
     * @param code
     * @param arguments
     */
    public SystemException(String code, Object... arguments) {
        super(code, arguments);
    }
}
