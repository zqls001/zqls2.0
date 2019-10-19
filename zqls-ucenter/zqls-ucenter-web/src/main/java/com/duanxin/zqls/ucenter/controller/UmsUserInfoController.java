package com.duanxin.zqls.ucenter.controller;

import com.baidu.unbiz.fluentvalidator.FluentValidator;
import com.baidu.unbiz.fluentvalidator.Result;
import com.baidu.unbiz.fluentvalidator.ResultCollectors;
import com.duanxin.zqls.base.BaseConstants;
import com.duanxin.zqls.base.BaseController;
import com.duanxin.zqls.base.BaseResult;
import com.duanxin.zqls.ucenter.api.UmsUserAccountInfoService;
import com.duanxin.zqls.ucenter.api.UmsUserInfoService;
import com.duanxin.zqls.ucenter.model.UmsUserAccountInfo;
import com.duanxin.zqls.ucenter.model.UmsUserInfo;
import com.duanxin.zqls.util.GsonUtil;
import com.duanxin.zqls.util.MD5Util;
import com.duanxin.zqls.validator.LengthValidator;
import com.duanxin.zqls.validator.NotNullValidator;
import com.google.gson.Gson;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 用户信息Controller层实现
 * @author duanxin
 * @version 1.0
 * @date 2019/10/14 15:48
 */
@RestController
@RequestMapping("/UmsUser")
public class UmsUserInfoController extends BaseController {

    @Reference(version = "0.0.1")
    private UmsUserInfoService umsUserInfoService;
    @Reference(version = "0.0.1")
    private UmsUserAccountInfoService umsUserAccountInfoService;

    @GetMapping("/{id}")
    public BaseResult getUmsUserInfoByPrimaryKey(@PathVariable("id") Integer id) {
        UmsUserInfo umsUserInfo = umsUserInfoService.selectByPrimaryKey(id);
        if (null != umsUserInfo) {
            String status = String.valueOf(umsUserInfo.getStatus());
            if (StringUtils.isNotBlank(status) && StringUtils.equals(status, BaseConstants.STATUS_CONSTANT)) {
                return BaseResult.success(umsUserInfo);
            }
        }
        return BaseResult.failed("该用户不存在");
    }

    @DeleteMapping("/{id}")
    public BaseResult deleteUmsUserByPrimaryKey(@PathVariable("id") Integer id) {

        umsUserInfoService.deleteUserInfoByPrimaryKey(id);
        return BaseResult.success("删除成功", id);
    }

    @PostMapping("/login")
    public BaseResult login(@RequestParam("jobNumber") String jobNumber,
                            @RequestParam("password") String password) {
        Result result = FluentValidator.checkAll()
                .on(jobNumber, new NotNullValidator("学工号"))
                .on(password, new NotNullValidator("密码"))
                .on(jobNumber, new LengthValidator(10, 12, "学工号"))
                .on(password, new LengthValidator(5, 101, "密码"))
                .doValidate()
                .result(ResultCollectors.toSimple());
        // 校验失败，返回错误信息
        if (!result.isSuccess()) {
            return BaseResult.validateFailed(GsonUtil.objectToString(result.getErrors()));
        }
        // 校验成功，查询用户信息
        UmsUserInfo umsUserInfo = umsUserInfoService.selectByJobNumber(jobNumber);
        // 校验用户是否存在
        if (null == umsUserInfo) {
            return BaseResult.failed("用户不存在");
        }
        // 进行密码校验
        if (!MD5Util.md5(password).equals(umsUserInfo.getPassword())) {
            return BaseResult.failed("用户密码错误");
        }
        // 所有校验都成功
        // 查询账户信息
        List<UmsUserAccountInfo> umsUserAccountInfos =
                umsUserAccountInfoService.selectByAid(umsUserInfo.getAid());
        umsUserInfo.setUmsUserAccountInfoList(umsUserAccountInfos);
        return BaseResult.success(umsUserInfo);
    }

    @PostMapping("/sendSms/{phone}")
    public BaseResult sendSms(@PathVariable("phone") String phone) {
        umsUserInfoService.sendSms(phone);
        return BaseResult.success("发送成功", phone);
    }
}
