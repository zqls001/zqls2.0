package com.duanxin.zqls.common.exception;

import lombok.NoArgsConstructor;

/**
 * 自定义校验异常
 * @author duanxin
 * @version 1.0
 * @date 2019/9/22 9:39
 */
@NoArgsConstructor
public class ValidateException extends RuntimeException {

    private final static long serialVersionUID = -7285211528095468156L;

    public ValidateException(String message) {
        super(message);
    }
}
