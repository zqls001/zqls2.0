package com.duanxin.zqls.base;

import com.duanxin.zqls.exception.CheckException;
import com.duanxin.zqls.exception.ValidateException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 基础控制类
 * @author duanxin
 * @version 1.0
 * @date 2019/9/22 9:45
 */
@Slf4j
public abstract class BaseController {

    @ExceptionHandler
    public ModelAndView exceptionHandler(HttpServletRequest req, HttpServletResponse resp, Exception e) {
        log.error("统一处理异常：{}", e);
        ModelAndView mv = null;

        req.setAttribute("ex", e);
        // 判断是否是ajax请求，是则添加头部信息
        if (null != req.getHeader("X-Requested-With") && "XMLHttpRequest".equalsIgnoreCase(req.getHeader("X-Requested-With"))) {
            req.setAttribute("requestHeader", "ajax");
        }

        if (e instanceof CheckException) {
            BaseResult result = BaseResult.failed("出现检查异常，请检查您的信息");
            mv = new ModelAndView("jsonView", result.toMap());
        }

        if (e instanceof ValidateException) {
            BaseResult result = BaseResult.failed("出现校验异常，您的信息不存在");
            mv = new ModelAndView("jsonView", result.toMap());
        }

        return mv;
    }
}
