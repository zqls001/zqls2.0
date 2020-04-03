package com.duanxin.zqls.common.exception;

/**
 * 自定义校验异常
 * @author duanxin
 * @version 1.0
 * @date 2019/9/22 9:39
 */
public class ValidateException extends RuntimeException {

    private final static long serialVersionUID = -7285211528095468156L;

    public ValidateException() {
    }

    public ValidateException(String message) {
        super(message);
    }
}
