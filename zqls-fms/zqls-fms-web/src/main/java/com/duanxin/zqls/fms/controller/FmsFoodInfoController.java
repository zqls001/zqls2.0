package com.duanxin.zqls.fms.controller;

import com.duanxin.zqls.common.base.BaseResult;
import com.duanxin.zqls.fms.api.FmsFoodInfoService;
import com.duanxin.zqls.fms.model.FmsFoodInfo;
import com.duanxin.zqls.fms.vo.FmsFoodInfoVo;
import com.github.pagehelper.PageInfo;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{id}")
    public BaseResult getFoodInfoByPrimaryId(@PathVariable("id") Integer id) {
        FmsFoodInfo fmsFoodInfo = fmsFoodInfoService.getFoodInfoByPrimaryId(id);
        if (null == fmsFoodInfo) {
            return BaseResult.failed("系统维护中，请耐心等待。。。。");
        }
        return BaseResult.success(fmsFoodInfo);
    }

    @GetMapping("/getAll")
    public BaseResult selectAll(@RequestParam("currentPage") Integer currentPage,
                                @RequestParam("pageSize") Integer pageSize) {
        PageInfo<FmsFoodInfo> fmsFoodInfos = fmsFoodInfoService.selectAll(currentPage, pageSize);
        if (null == fmsFoodInfos) {
            return BaseResult.failed("系统维护中，请耐性等待。。。");
        }
        return BaseResult.success(fmsFoodInfos);
    }
}
