package com.duanxin.zqls.fms.controller;

import com.duanxin.zqls.common.base.BaseResult;
import com.duanxin.zqls.fms.api.FmsFoodInfoService;
import com.duanxin.zqls.fms.vo.FmsFoodInfoVo;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 食物信息Controller层实现
 * @author duanxin
 * @version 1.0
 * @date 2019/11/16 9:31
 */
@RestController
@RequestMapping("/FmsFood")
public class FmsFoodInfoController {

    @Reference(version = "0.0.1", protocol = "dubbo", mock = "true", check = false)
    private FmsFoodInfoService fmsFoodInfoService;

    @GetMapping("/test")
    public BaseResult test() {
        return BaseResult.success("测试成功");
    }

    @GetMapping("/hots")
    public BaseResult getHotFmsFoodInfos() {
        FmsFoodInfoVo fmsFoodInfoVo = fmsFoodInfoService.getHotFmsFoodInfos();
        if (null == fmsFoodInfoVo) {
            return BaseResult.failed("系统维护中，请耐心等待。。。");
        }
        return BaseResult.success(fmsFoodInfoVo);
    }

}
