package com.duanxin.zqls.fms.controller;

import com.baidu.unbiz.fluentvalidator.FluentValidator;
import com.baidu.unbiz.fluentvalidator.Result;
import com.baidu.unbiz.fluentvalidator.ResultCollectors;
import com.duanxin.zqls.common.util.GsonUtil;
import com.duanxin.zqls.fms.api.FmsFoodInfoService;
import com.duanxin.zqls.fms.dto.FoodInfoAndUserInfoDto;
import com.duanxin.zqls.fms.model.FmsFoodConsume;
import com.duanxin.zqls.fms.model.FmsFoodInfo;
import com.duanxin.zqls.fms.vo.FmsFoodInfoVo;
import com.duanxin.zqls.ucenter.vo.UmsUserInfoVo;
import com.duanxin.zqls.web.base.BaseResult;
import com.duanxin.zqls.web.validate.LengthValidator;
import com.duanxin.zqls.web.validate.NotNullValidator;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
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
@Api(value = "食物模块业务的接口", tags = {"食物基本信息业务的Controller接口"})
public class FmsFoodInfoController {

    @Reference(version = "0.0.1", protocol = "dubbo", mock = "true", check = false)
    private FmsFoodInfoService fmsFoodInfoService;

    @GetMapping("/test")
    public BaseResult test() {
        return BaseResult.success("测试成功");
    }

    @GetMapping("/hots")
    @ApiOperation(value = "获取热点食物基本信息", notes = "该功能是获取三天内最受欢迎食物信息",
            httpMethod = "GET", response = BaseResult.class)
    public BaseResult getHotFmsFoodInfos() {
        FmsFoodInfoVo fmsFoodInfoVo = fmsFoodInfoService.getHotFmsFoodInfos();
        if (null == fmsFoodInfoVo) {
            return BaseResult.failed("系统维护中，请耐心等待。。。");
        }
        return BaseResult.success(fmsFoodInfoVo);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "获取食物基本信息", notes = "通过食物主键id获取食物的基本信息",
            httpMethod = "GET", response = BaseResult.class)
    @ApiImplicitParam(name = "id", value = "食物主键id",
            dataType = "int", required = true, example = "1")
    public BaseResult getFoodInfoByPrimaryId(@PathVariable("id") Integer id) {
        FmsFoodInfo fmsFoodInfo = fmsFoodInfoService.getFoodInfoByPrimaryId(id);
        if (null == fmsFoodInfo) {
            return BaseResult.failed("系统维护中，请耐心等待。。。。");
        }
        return BaseResult.success(fmsFoodInfo);
    }

    @GetMapping("/getAll")
    @ApiOperation(value = "获取所有食物信息", notes = "管理员分页查询食物基本信息",
            httpMethod = "GET", response = BaseResult.class)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "currentPage", value = "当前所在页数，从0开始",
                    dataType = "int", required = true, example = "1"),
            @ApiImplicitParam(name = "pageSize", value = "每页所展示的用户数",
                    dataType = "int", required = true, example = "10")
    })
    public BaseResult getAll(@RequestParam("currentPage") Integer currentPage,
                                @RequestParam("pageSize") Integer pageSize) {
        PageInfo<FmsFoodInfo> fmsFoodInfos = fmsFoodInfoService.selectAll(currentPage, pageSize);
        if (null == fmsFoodInfos) {
            return BaseResult.failed("系统维护中，请耐性等待。。。");
        }
        return BaseResult.success(fmsFoodInfos);
    }

    @GetMapping("/getInfos")
    @ApiOperation(value = "获取食物信息和用户信息", notes = "该模块给硬件端提供食物信息和用户信息",
            httpMethod = "GET", response = BaseResult.class)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "fid", value = "食物主键id",
                    dataType = "int", required = true, example = "1"),
            @ApiImplicitParam(name = "jobNumber", value = "用户学工号",
                    dataType = "String", required = true, example = "10200001")
    })
    public BaseResult getFmsInfoAndUmsInfoById(@RequestParam("fid") Integer fid,
                                               @RequestParam("jobNumber") String jobNumber) {
        // validate params
        Result result = FluentValidator.checkAll().
                on(jobNumber, new NotNullValidator("学工号")).
                on(jobNumber, new LengthValidator(7, 9, "学工号")).
                result(ResultCollectors.toSimple());
        if (!result.isSuccess()) {
            return BaseResult.validateFailed(GsonUtil.objectToString(result.getErrors()));
        }
        // select
        FoodInfoAndUserInfoDto foodInfoAndUserInfoDto =
                fmsFoodInfoService.selectFmsInfoAndUmsInfoById(fid, jobNumber);
        // judgment mock
        if (null == foodInfoAndUserInfoDto) {
            return BaseResult.failed("系统维护中，请耐性等待。。。");
        }
        if (null == foodInfoAndUserInfoDto.getUmsUserAccountInfo()) {
            return BaseResult.failed("用户不存在");
        }
        return BaseResult.success(foodInfoAndUserInfoDto);
    }

    @PostMapping("/account")
    @ApiOperation(value = "进行交易结算", notes = "当用户操作完毕进行自动结算时调用的方法",
            httpMethod = "POST", response = BaseResult.class)
    @ApiImplicitParam(name = "fmsFoodConsume", value = "用户食物消耗信息",
            dataTypeClass = FmsFoodConsume.class, required = true)
    public BaseResult settleAccounts(@RequestBody FmsFoodConsume fmsFoodConsume) {
        // validate
        Result result = FluentValidator.
                checkAll().
                on(fmsFoodConsume.getUid(), new NotNullValidator("学工号")).
                on(fmsFoodConsume.getUid(), new LengthValidator(7, 9, "学工号")).
                doValidate().
                result(ResultCollectors.toSimple());
        if (!result.isSuccess()) {
            return BaseResult.validateFailed(GsonUtil.objectToString(result.getErrors()));
        }

        UmsUserInfoVo umsUserInfoVo = fmsFoodInfoService.settleAccounts(fmsFoodConsume);
        if (null == umsUserInfoVo) {
            return BaseResult.failed("系统维护中，请耐性等待。。。。");
        }
        return BaseResult.success("交易成功", umsUserInfoVo);
    }
}
