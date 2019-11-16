package com.duanxin.zqls.fms.controller;

import com.duanxin.zqls.fms.api.FmsFoodInfoService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;

/**
 * 食物信息Controller层实现
 * @author duanxin
 * @version 1.0
 * @date 2019/11/16 9:31
 */
@Controller
public class FmsFoodInfoController {

    @Reference(version = "0.0.1", check = false, protocol = "dubbo", mock = "true")
    private FmsFoodInfoService fmsFoodInfoService;

}
