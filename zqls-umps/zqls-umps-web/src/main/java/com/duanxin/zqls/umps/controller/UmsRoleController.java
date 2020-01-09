package com.duanxin.zqls.umps.controller;

import com.duanxin.zqls.web.base.BaseResult;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author duanxin
 * @version 1.0
 * @date 2020/1/7 8:56
 */
@RestController
@RequestMapping("/UmsRole")
@Api(value = "权限模块业务的接口", tags = {"角色模块的Controller接口"})
public class UmsRoleController {

    @GetMapping("/test")
    public BaseResult test() {
        return BaseResult.success("test success");
    }
}
