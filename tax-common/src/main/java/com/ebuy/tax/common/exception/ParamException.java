/**
 * 请求参数异常类
 */
package com.ebuy.tax.common.exception;

/**
 * 参数异常
 *
 * @author hdq
 * @version <b>1.0.0</b>
 */
@SuppressWarnings("serial")
public class ParamException extends AbstractGenericException {

    /**
     * <br>------------------------------<br>
     *
     * @param errorCode
     */
    public ParamException(String errorCode) {
        super(errorCode);
    }

    /**
     * <br>------------------------------<br>
     *
     * @param errorCode
     * @param message
     */
    public ParamException(String errorCode, String message) {
        super(errorCode, message);
    }

    /**
     * <br>------------------------------<br>
     *
     * @param code
     * @param message
     * @param throwable
     */
    public ParamException(String errorCode, String message, Throwable throwable) {
        super(errorCode, message, throwable);
    }

    /**
     * <br>------------------------------<br>
     *
     * @param errorCode
     * @param throwable
     */
    public ParamException(String errorCode, Throwable throwable) {
        super(errorCode, throwable);
    }

    /**
     * <br>------------------------------<br>
     *
     * @param errorCode
     * @param arguments
     */
    public ParamException(String errorCode, Object... arguments) {
        super(errorCode, arguments);
    }
}
