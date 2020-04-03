package com.duanxin.zqls.web.handler;

import com.duanxin.zqls.common.exception.CheckException;
import com.duanxin.zqls.common.exception.ValidateException;
import com.duanxin.zqls.web.base.BaseResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * web层同一异常处理类
 * @author duanxin
 * @version 1.0
 * @date 2020/3/6 18:28
 */
@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(value = {
            ValidateException.class,
            CheckException.class
    })
    @ResponseBody
    public BaseResult exceptionHandler(Exception e) {
        String msg = e.getMessage();
        if (e instanceof ValidateException) {
            return BaseResult.validateFailed(msg);
        }
        if (e instanceof CheckException) {
            return BaseResult.failed(msg);
        }
        return BaseResult.failed();
    }
}
