package com.duanxin.zqls.ucenter.controller;

import com.baidu.unbiz.fluentvalidator.FluentValidator;
import com.baidu.unbiz.fluentvalidator.Result;
import com.baidu.unbiz.fluentvalidator.ResultCollectors;
import com.duanxin.zqls.common.base.BaseConstants;
import com.duanxin.zqls.common.util.Builder;
import com.duanxin.zqls.common.util.GsonUtil;
import com.duanxin.zqls.ucenter.ao.UmsUserInfoAo;
import com.duanxin.zqls.ucenter.api.UmsUserAccountInfoService;
import com.duanxin.zqls.ucenter.api.UmsUserInfoService;
import com.duanxin.zqls.ucenter.dto.UmsUserInfoDto;
import com.duanxin.zqls.ucenter.dto.UmsUserPageInfo;
import com.duanxin.zqls.ucenter.model.UmsUserInfo;
import com.duanxin.zqls.web.annotation.LoginRequired;
import com.duanxin.zqls.web.base.BaseResult;
import com.duanxin.zqls.web.validate.LengthValidator;
import com.duanxin.zqls.web.validate.NotNullValidator;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.BeanUtils;
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
@Api(value = "用户模块业务的接口", tags = {"用户基本信息业务的Controller"})
public class UmsUserInfoController {

    @Reference(version = "0.0.1", protocol = "dubbo", mock = "true", check = false)
    private UmsUserInfoService umsUserInfoService;
    @Reference(version = "0.0.1", protocol = "dubbo", mock = "true", check = false)
    private UmsUserAccountInfoService umsUserAccountInfoService;

    @GetMapping("/{id}")
    @ApiOperation(value = "获取用户基本信息", notes = "该接口根据用户的主键查询并获取用户的基本信息",
            httpMethod = "GET", response = BaseResult.class)
    @ApiImplicitParam(dataType = "int", name = "id", value = "用户主键id", required = true)
    @LoginRequired
    public BaseResult getUmsUserInfoByPrimaryKey(@PathVariable("id") Integer id) {
        UmsUserInfo umsUserInfo = umsUserInfoService.selectByPrimaryKey(id);
        if (null != umsUserInfo) {
            String status = String.valueOf(umsUserInfo.getStatus());
            if (StringUtils.isNotBlank(status) && StringUtils.equals(status, BaseConstants.STATUS_CONSTANT)) {
                return BaseResult.success(convertUserInfo(umsUserInfo));
            }
        }
        return BaseResult.failed("该用户不存在");
    }

    @GetMapping("/jobNumber")
    @ApiOperation(value = "获取用户基本信息", notes = "该接口根据用户的学工号查询并获取用户的基本信息",
            httpMethod = "GET", response = BaseResult.class)
    @ApiImplicitParam(dataType = "String", name = "jobNumber", value = "用户学工号", required = true)
    @LoginRequired
    public BaseResult getUmsUserInfoByJobNumber(@RequestParam("jobNumber") String jobNumber) {
        UmsUserInfo umsUserInfo = umsUserInfoService.selectByJobNumber(jobNumber);
        if (null == umsUserInfo) {
            return BaseResult.failed("用户不存在");
        }
        String status = String.valueOf(umsUserInfo.getStatus());
        if (StringUtils.isNotBlank(status) && !StringUtils.equals(status, BaseConstants.STATUS_CONSTANT)) {
            return BaseResult.failed("用户不存在");
        }
        return BaseResult.success(convertUserInfo(umsUserInfo));
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "删除用户", notes = "根据用户主键id删除用户",
            httpMethod = "DELETE", response = BaseResult.class)
    @ApiImplicitParam(name = "id", value = "用户主键id", required = true, dataType = "int")
    @LoginRequired
    public BaseResult deleteUmsUserByPrimaryKey(@PathVariable("id") Integer id) {

        int result = umsUserInfoService.deleteUserInfoByPrimaryKey(id);
        if (0 == result) {
            return BaseResult.failed("系统维护中，请耐心等待。。。。");
        }
        return BaseResult.success("删除成功", result);
    }

    @PostMapping("/sendSms/{phone}")
    @ApiOperation(value = "发送短信", notes = "用户绑定手机号码时进行验证码发送",
            httpMethod = "POST", response = BaseResult.class)
    @ApiImplicitParam(name = "phone", value = "用户手机号码",
            required = true, dataType = "String", example = "18820198888")
    @LoginRequired
    public BaseResult sendSms(@PathVariable("phone") String phone) {
        int result = umsUserInfoService.sendSms(phone);
        if (1 == result) {
            return BaseResult.success("发送成功", phone);
        }
        return BaseResult.failed("服务维修中，请耐心等待");
    }

    @PostMapping("/checkSmsCode")
    @ApiOperation(value = "号码绑定验证信息", notes = "用户填写验证码之后和系统进行校验",
            httpMethod = "POST", response = BaseResult.class)
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "jobNumber", value = "学工号",
                    dataType = "String", required = true, example = "10200001"),
            @ApiImplicitParam(name = "phone", value = "手机号码",
                    dataType = "String", required = true, example = "18820198888"),
            @ApiImplicitParam(name = "code", value = "验证码",
                    dataType = "String", required = true, example = "182374")
    })
    @LoginRequired
    public BaseResult checkSmsCode(@RequestParam("jobNumber") String jobNumber,
                                @RequestParam("phone") String phone,
                                @RequestParam("code") String code) {

        // 校验数据
        Result result = FluentValidator.checkAll()
                .on(jobNumber, new NotNullValidator("学工号"))
                .on(phone, new NotNullValidator("手机号"))
                .on(code, new NotNullValidator("验证码"))
                .on(jobNumber, new LengthValidator(7, 9, "学工号"))
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
    @ApiOperation(value = "发送邮件", notes = "当用户需要绑定邮箱时，该功能给用户邮箱发送验证码邮件进行绑定",
            httpMethod = "POST", response = BaseResult.class)
    @ApiImplicitParam(name = "to", value = "用户邮箱地址",
            dataType = "String", required = true, example = "18820198888@163.com")
    @LoginRequired
    public BaseResult sendMail(@RequestParam("to") String to) {
        if (StringUtils.isBlank(to)) {
            return BaseResult.failed("邮箱地址不存在");
        }
        int result = umsUserInfoService.sendMail(to);
        return BaseResult.success(result);
    }

    @PostMapping("/checkMailCode")
    @ApiOperation(value = "邮箱绑定验证信息", notes = "用户填写验证码之后和系统进行校验，校验成功绑定成功",
            httpMethod = "POST", response = BaseResult.class)
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "jobNumber", value = "学工号",
                    dataType = "String", required = true, example = "10200001"),
            @ApiImplicitParam(name = "to", value = "用户邮箱地址",
                    dataType = "String", required = true, example = "18820198888@163.com"),
            @ApiImplicitParam(name = "code", value = "验证码",
                    dataType = "String", required = true, example = "182374")
    })
    @LoginRequired
    public BaseResult checkMailCode(@RequestParam("jobNumber") String jobNumber,
                                    @RequestParam("mail") String mail,
                                    @RequestParam("code") String code) {
        // 校验数据
        Result result = FluentValidator.checkAll()
                .on(jobNumber, new NotNullValidator("学工号"))
                .on(mail, new NotNullValidator("邮箱"))
                .on(code, new NotNullValidator("验证码"))
                .on(jobNumber, new LengthValidator(7, 9, "学工号"))
                .on(code, new LengthValidator(5, 7, "验证码"))
                .doValidate()
                .result(ResultCollectors.toSimple());
        if (!result.isSuccess()) {
            return BaseResult.validateFailed(GsonUtil.objectToString(result.getErrors()));
        }
        UmsUserInfoAo umsUserInfoAo = umsUserInfoService.checkMailCode(jobNumber, mail, code);
        UmsUserInfo umsUserInfo = umsUserInfoAo.getUmsUserInfo();
        // 校验是否验证成功
        if (0 == umsUserInfoAo.getCheckCode()) {
            return BaseResult.validateFailed("验证失败");
        }
        // 校验用户合法性
        if (null == umsUserInfo || !StringUtils.equals(umsUserInfo.getStatus() + "",
                BaseConstants.STATUS_CONSTANT)) {
            return BaseResult.failed("用户不存在");
        }
        return BaseResult.success("绑定成功", mail);
    }

    @PostMapping("/updatePassword")
    @ApiOperation(value = "更新密码", notes = "用户填写新密码进行改密码操作",
            httpMethod = "POST", response = BaseResult.class)
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "jobNumber", value = "用户学工号",
                    dataType = "String", required = true, example = "10200001"),
            @ApiImplicitParam(name = "password", value = "用户新密码", dataType = "String", required = true, example = "654321")
    })
    @LoginRequired
    public BaseResult updatePassword(@RequestParam("jobNumber") String jobNumber,
                                     @RequestParam("password") String password) {
        // 进行参数校验
        Result result = FluentValidator.checkAll()
                .on(jobNumber, new NotNullValidator("学工号"))
                .on(password, new NotNullValidator("密码"))
                .on(jobNumber, new LengthValidator(7, 9, "学工号"))
                .on(password, new LengthValidator(5, 105, "密码"))
                .doValidate()
                .result(ResultCollectors.toSimple());
        if (!result.isSuccess()) {
            return BaseResult.validateFailed(GsonUtil.objectToString(result.getErrors()));
        }
        // 进行密码更新
        UmsUserInfoAo umsUserInfoAo = umsUserInfoService.updatePassword(jobNumber, password);
        // 服务降级判断
        if (null == umsUserInfoAo) {
            return BaseResult.failed("服务维修中，请耐心等待");
        }
        UmsUserInfo umsUserInfo = umsUserInfoAo.getUmsUserInfo();
        if (null == umsUserInfo || !StringUtils.equals(umsUserInfo.getStatus() + "",
                BaseConstants.STATUS_CONSTANT)) {
            return BaseResult.failed("用户不存在");
        }
        return BaseResult.success("更新密码成功", jobNumber);
    }

    @PutMapping("/update")
    @ApiOperation(value = "更新用户信息", notes = "用户更改自己信息",
            httpMethod = "PUT", response = BaseResult.class)
    @ApiImplicitParam(name = "umsUserInfo", value = "待更新的信息", dataTypeClass = UmsUserInfo.class)
    @LoginRequired
    public BaseResult updateUmsUserInfo(@RequestBody UmsUserInfo umsUserInfo) {

        UmsUserInfoAo umsUserInfoAo = umsUserInfoService.updateUmsUserInfo(umsUserInfo);
        // 服务降级判断
        if (null == umsUserInfoAo) {
            return BaseResult.failed("服务维修中，请耐心等待");
        }
        int checkCode = umsUserInfoAo.getCheckCode();
        if (0 == checkCode) {
            return BaseResult.failed("更新失败");
        }
        return BaseResult.success("更新成功", convertUserInfo(umsUserInfoAo.getUmsUserInfo()));
    }

    @GetMapping("/getAll")
    @ApiOperation(value = "查询多个用户信息", notes = "管理员用户分页查询用户信息",
            httpMethod = "GET", response = BaseResult.class)
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "currentPage", value = "当前所在页数，从0开始",
                    dataType = "int", required = true, example = "1"),
            @ApiImplicitParam(name = "pageSize", value = "每页所展示的用户数",
                    dataType = "int", required = true, example = "10")
    })
    @LoginRequired
    public BaseResult selectAll(@RequestParam("currentPage") int currentPage,
                                @RequestParam("pageSize") int pageSize) {
        PageInfo<UmsUserInfo> umsUserInfos =
                umsUserInfoService.selectAll(currentPage, pageSize);
        if (null == umsUserInfos) {
            return BaseResult.failed("系统维护中，请耐性等待");
        }
        List<UmsUserInfoDto> umsUserInfoDtos = Lists.newArrayList();
        com.duanxin.zqls.common.dto.PageInfo pageInfo =
                new com.duanxin.zqls.common.dto.PageInfo();
                pageInfo.setTotalPage(umsUserInfos.getPages());
                pageInfo.setTotalCount(umsUserInfos.getTotal());
                pageInfo.setPageSize(umsUserInfos.getPageSize());
                pageInfo.setPrePage(umsUserInfos.getPrePage());
                pageInfo.setNextPage(umsUserInfos.getNextPage());
                pageInfo.setPageNo(umsUserInfos.getPageNum());
        umsUserInfos.getList().forEach(u -> {
            umsUserInfoDtos.add(convertUserInfo(u));
        });
        return BaseResult.success(Builder.
                of(UmsUserPageInfo::new).
                with(UmsUserPageInfo::setPageInfo, pageInfo).
                with(UmsUserPageInfo::setUmsUserInfoDtos, umsUserInfoDtos).
                build());
    }

    private UmsUserInfoDto convertUserInfo(UmsUserInfo umsUserInfo) {
        UmsUserInfoDto umsUserInfoDto = new UmsUserInfoDto();
        BeanUtils.copyProperties(umsUserInfo, umsUserInfoDto);
        return umsUserInfoDto;
    }
}
