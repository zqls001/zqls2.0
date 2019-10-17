package com.duanxin.zqls.base;

import com.duanxin.zqls.exception.CheckException;
import com.duanxin.zqls.exception.ValidateException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 基类Controller
 * @author duanxin
 * @version 1.0
 * @date 2019/10/15 9:34
 */
@Slf4j
public abstract class BaseController {

    @ExceptionHandler
    @ResponseBody
    public BaseResult exceptionHandler(Exception e) {
        log.info(">>>>出现异常,名称：{}<<<<", e.getClass().getName());
        if (e instanceof CheckException) {
            CheckException ce = (CheckException) e;
            return BaseResult.failed(ce.getMessage());
        }
        if (e instanceof ValidateException) {
            ValidateException ve = (ValidateException) e;
            return BaseResult.validateFailed(ve.getMessage());
        }
        log.error(">>>>系统异常，{}<<<<", e);
        return BaseResult.failed("系统异常");
    }

}
