package com.duanxin.zqls.ucenter.controller;

import com.baidu.unbiz.fluentvalidator.FluentValidator;
import com.baidu.unbiz.fluentvalidator.Result;
import com.baidu.unbiz.fluentvalidator.ResultCollectors;
import com.duanxin.zqls.base.BaseConstants;
import com.duanxin.zqls.base.BaseController;
import com.duanxin.zqls.base.BaseResult;
import com.duanxin.zqls.ucenter.ao.UmsUserInfoAo;
import com.duanxin.zqls.ucenter.api.UmsUserAccountInfoService;
import com.duanxin.zqls.ucenter.api.UmsUserInfoService;
import com.duanxin.zqls.ucenter.model.UmsUserAccountInfo;
import com.duanxin.zqls.ucenter.model.UmsUserInfo;
import com.duanxin.zqls.ucenter.vo.UmsUserInfoVo;
import com.duanxin.zqls.util.GsonUtil;
import com.duanxin.zqls.util.MD5Util;
import com.duanxin.zqls.validator.LengthValidator;
import com.duanxin.zqls.validator.NotNullValidator;
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

    @Reference(version = "0.0.1", protocol = "dubbo", mock = "true", check = false)
    private UmsUserInfoService umsUserInfoService;
    @Reference(version = "0.0.1", protocol = "dubbo", mock = "true", check = false)
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
                .on(jobNumber, new LengthValidator(9, 11, "学工号"))
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
        UmsUserInfoVo umsUserInfoVo = new UmsUserInfoVo(umsUserAccountInfos, umsUserInfo);
        return BaseResult.success(umsUserInfoVo);
    }

    @PostMapping("/sendSms/{phone}")
    public BaseResult sendSms(@PathVariable("phone") String phone) {
        int result = umsUserInfoService.sendSms(phone);
        if (1 == result) {
            return BaseResult.success("发送成功", phone);
        }
        return BaseResult.failed("服务维修中，请耐心等待");
    }

    @PostMapping("/checkSmsCode")
    public BaseResult checkSmsCode(@RequestParam("jobNumber") String jobNumber,
                                @RequestParam("phone") String phone,
                                @RequestParam("code") String code) {

        // 校验数据
        Result result = FluentValidator.checkAll()
                .on(jobNumber, new NotNullValidator("学工号"))
                .on(phone, new NotNullValidator("手机号"))
                .on(code, new NotNullValidator("验证码"))
                .on(jobNumber, new LengthValidator(9, 11, "学工号"))
                .on(phone, new LengthValidator(10, 12, "手机号"))
                .on(code, new LengthValidator(5, 7, "验证码"))
                .doValidate()
                .result(ResultCollectors.toSimple());
        if (!result.isSuccess()) {
            return BaseResult.validateFailed(GsonUtil.objectToString(result.getErrors()));
        }

        UmsUserInfoAo umsUserInfoAo = umsUserInfoService.checkCode(jobNumber, phone, code);
        UmsUserInfo umsUserInfo = umsUserInfoAo.getUmsUserInfo();
        // 校验该用户是否合法
        if (null == umsUserInfo || !StringUtils.equals(umsUserInfo.getStatus() + "",
                BaseConstants.STATUS_CONSTANT)) {
            return BaseResult.failed("该用户不存在");
        }
        // 检查是否验证成功
        if (0 == umsUserInfoAo.getCheckCode()) {
            return BaseResult.validateFailed("验证失败");
        }
        return BaseResult.success("绑定成功", phone);
    }

    @PostMapping("/sendMail")
    public BaseResult sendMail(@RequestParam("to") String to) {
        if (StringUtils.isBlank(to)) {
            return BaseResult.failed("邮箱地址不存在");
        }
        int result = umsUserInfoService.sendMail(to);
        return BaseResult.success(result);
    }

    @PostMapping("/checkMailCode")
    public BaseResult checkMailCode(@RequestParam("jobNumber") String jobNumber,
                                    @RequestParam("mail") String mail,
                                    @RequestParam("code") String code) {
        // 校验数据
        Result result = FluentValidator.checkAll()
                .on(jobNumber, new NotNullValidator("学工号"))
                .on(mail, new NotNullValidator("邮箱"))
                .on(code, new NotNullValidator("验证码"))
                .on(jobNumber, new LengthValidator(9, 11, "学工号"))
                .on(code, new LengthValidator(5, 7, "验证码"))
                .doValidate()
                .result(ResultCollectors.toSimple());
        if (!result.isSuccess()) {
            return BaseResult.validateFailed(GsonUtil.objectToString(result.getErrors()));
        }
        UmsUserInfoAo umsUserInfoAo = umsUserInfoService.checkMailCode(jobNumber, mail, code);
        UmsUserInfo umsUserInfo = umsUserInfoAo.getUmsUserInfo();
        // 校验用户合法性
        if (null == umsUserInfo || !StringUtils.equals(umsUserInfo.getStatus() + "",
                BaseConstants.STATUS_CONSTANT)) {
            return BaseResult.failed("用户不存在");
        }
        // 校验是否验证成功
        if (0 == umsUserInfoAo.getCheckCode()) {
            return BaseResult.validateFailed("验证失败");
        }
        return BaseResult.success("绑定成功", mail);
    }
}
