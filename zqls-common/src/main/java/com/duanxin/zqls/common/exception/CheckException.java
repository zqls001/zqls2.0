package com.duanxin.zqls.common.exception;

import lombok.NoArgsConstructor;

/**
 * 自定义校验异常
 * @author duanxin
 * @version 1.0
 * @date 2019/9/22 9:35
 */
@NoArgsConstructor
public class CheckException extends RuntimeException {

    private final static long serialVersionUID = 1L;

    public CheckException(String message) {
        super(message);
    }

    public CheckException(Throwable cause) {
        super(cause);
    }

    public CheckException(String message, Throwable cause) {
        super(message, cause);
    }

    public CheckException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
