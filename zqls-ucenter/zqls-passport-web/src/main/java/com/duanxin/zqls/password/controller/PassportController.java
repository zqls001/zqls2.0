package com.duanxin.zqls.password.controller;

import com.baidu.unbiz.fluentvalidator.FluentValidator;
import com.baidu.unbiz.fluentvalidator.Result;
import com.baidu.unbiz.fluentvalidator.ResultCollectors;
import com.duanxin.zqls.common.util.GsonUtil;
import com.duanxin.zqls.ucenter.api.JwtService;
import com.duanxin.zqls.web.base.BaseResult;
import com.duanxin.zqls.web.validate.LengthValidator;
import com.duanxin.zqls.web.validate.NotNullValidator;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.*;

/**
 * 认证中心Controller层接口
 * @author duanxin
 * @version 1.0
 * @date 2019/12/15 16:25
 */
@RestController
@RequestMapping("/passport")
@Api(value = "认证中心模块接口", tags = {"认证中心Controller接口"})
public class PassportController {

    @Reference(version = "0.0.1", check = false, mock = "true", protocol = "dubbo")
    private JwtService jwtService;

    @PostMapping("/login")
    @ApiOperation(value = "登入", notes = "用户提供学工号和密码进行登入",
            httpMethod = "POST", response = BaseResult.class)
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "jobNumber", value = "用户学工号",
                    required = true, dataType = "String", example = "10200001"),
            @ApiImplicitParam(name = "password", value = "用户密码",
                    required = true, dataType = "String", example = "123456")
    })
    public BaseResult login(@RequestParam("jobNumber") String jobNumber,
                            @RequestParam("password") String password) {
        Result result = FluentValidator.checkAll()
                .on(jobNumber, new NotNullValidator("学工号"))
                .on(password, new NotNullValidator("密码"))
                .on(jobNumber, new LengthValidator(7, 9, "学工号"))
                .on(password, new LengthValidator(5, 101, "密码"))
                .doValidate()
                .result(ResultCollectors.toSimple());
        // 校验失败，返回错误信息
        if (!result.isSuccess()) {
            return BaseResult.validateFailed(GsonUtil.objectToString(result.getErrors()));
        }
        String token = jwtService.login(jobNumber, password);
        if (StringUtils.isBlank(token)) {
            return BaseResult.failed("系统维护中，请耐性等待。。。");
        }
        return BaseResult.success(token);
    }

    @GetMapping("/checkToken")
    @ApiOperation(value = "校验token", notes = "用户进行是否登入校验",
            httpMethod = "GET", response = BaseResult.class)
    @ApiImplicitParam(name = "token", value = "客户端待校验数据",
            dataType = "String", required = true)
    public BaseResult validate(@RequestParam("token") String token) {
        boolean checkJwt = jwtService.checkJwt(token);
        if (checkJwt) {
            return BaseResult.success("success", "");
        }
        return BaseResult.failed("fail");
    }

    @PutMapping("/refreshJwt")
    @ApiOperation(value = "更新token", notes = "当token时效小于3天时，进行token更新",
            httpMethod = "PUT", response = BaseResult.class)
    @ApiImplicitParam(name = "token", value = "客户端待校验数据",
            dataType = "String", required = true)
    public BaseResult refreshJwt(@RequestParam("token") String token) {
        String refreshJwt = jwtService.refreshJwt(token);
        if (StringUtils.isBlank(refreshJwt)) {
            return BaseResult.failed("系统维护中，请耐性等待。。。");
        }
        return BaseResult.success(refreshJwt);
    }

    @GetMapping("/logout")
    @ApiOperation(value = "退出登入", httpMethod = "GET", response = BaseResult.class)
    @ApiImplicitParam(name = "token", value = "客户端待校验数据",
            dataType = "String", required = true)
    public BaseResult logout(@RequestParam("token") String token) {
        int inValid = jwtService.inValid(token);
        if (0 == inValid) {
            return BaseResult.failed("系统维护中，请耐性等待。。。");
        }
        return BaseResult.success("退出成功");
    }
}
