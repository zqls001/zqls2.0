package com.duanxin.zqls.common.base;

import com.duanxin.zqls.common.exception.CheckException;
import com.duanxin.zqls.common.exception.ValidateException;
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

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public BaseResult exceptionHandler(Exception e) {
        log.info(">>>>出现异常,名称：{}<<<<", e.getClass().getName());
        if (e instanceof CheckException) {
            CheckException ce = (CheckException) e;
            log.info(">>>>检查异常，{}<<<<", e.getMessage());
            return BaseResult.failed(ce.getMessage());
        }
        if (e instanceof ValidateException) {
            ValidateException ve = (ValidateException) e;
            log.info(">>>>校验异常，{}<<<<", e.getMessage());
            return BaseResult.validateFailed(ve.getMessage());
        }
        log.error(">>>>系统异常，{}<<<<", e);
        return BaseResult.failed("系统异常");
    }

}
