package com.duanxin.zqls.fms.controller;

import com.baidu.unbiz.fluentvalidator.FluentValidator;
import com.baidu.unbiz.fluentvalidator.Result;
import com.baidu.unbiz.fluentvalidator.ResultCollectors;
import com.duanxin.zqls.common.util.GsonUtil;
import com.duanxin.zqls.fms.ao.FmsUserLikeAo;
import com.duanxin.zqls.fms.api.FmsUserLikeService;
import com.duanxin.zqls.fms.model.FmsUserLike;
import com.duanxin.zqls.web.base.BaseResult;
import com.duanxin.zqls.web.validate.LengthValidator;
import com.duanxin.zqls.web.validate.NotNullValidator;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.*;

/**
 * 用户个人喜好模块Controller接口
 * @author duanxin
 * @version 1.0
 * @date 2019/12/7 11:07
 */
@RestController
@RequestMapping("/UserLike")
@Api(value = "食物系统模块业务接口", tags = {"用户喜好业务Controller接口"})
public class FmsUserLikeController {

    @Reference(version = "0.0.1", mock = "true", check = false, protocol = "dubbo")
    private FmsUserLikeService fmsUserLikeService;

    @PostMapping("/save")
    @ApiOperation(value = "设置添加用户喜好信息", notes = "用户端进行喜好设置，服务端保存到数据库",
            httpMethod = "POST", response = BaseResult.class)
    @ApiImplicitParam(name = "fmsUserLike", value = "用户设置喜好实体类",
            dataTypeClass = FmsUserLike.class, required = true)
    public BaseResult saveUserLike(@RequestBody FmsUserLike fmsUserLike) {
        int result = fmsUserLikeService.saveUserLike(fmsUserLike);
        if (result == 0) {
            return BaseResult.failed("系统维护中，请耐心等待。。。");
        }
        return BaseResult.success("添加成功", result);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "获取用户喜好", notes = "根据用户主键id获取用户喜好设置",
            httpMethod = "GET", response = BaseResult.class)
    @ApiImplicitParam(name = "id", value = "用户主键id", dataType = "int", required = true, example = "1")
    public BaseResult getUserLike(@PathVariable("id") Integer id) {
        FmsUserLikeAo fmsUserLikeAo = fmsUserLikeService.getUserLikeByUid(id);
        if (null == fmsUserLikeAo) {
            return BaseResult.failed("系统维护中，请耐性等待。。。。");
        }
        if (fmsUserLikeAo.getCheck().equals(1)) {
            return BaseResult.failed("用户不存在");
        }
        return BaseResult.success("查询成功", fmsUserLikeAo.getFmsUserLike());
    }

    @PutMapping("/update")
    @ApiOperation(value = "更改用户喜好", notes = "用户可以通过该功能进行喜好更改",
            httpMethod = "PUT", response = BaseResult.class)
    @ApiImplicitParam(name = "fmsUserLike", value = "用户更改后的数据信息", dataTypeClass = FmsUserLike.class, required = true, example = "{\"fmsUserLike\":{\"tasteType1\":3, \"favoriteDishes1\": 4}}")
    public BaseResult updateUserLike(@RequestBody FmsUserLike fmsUserLike) {
        FmsUserLikeAo fmsUserLikeAo = fmsUserLikeService.updateUserLike(fmsUserLike);
        if (null == fmsUserLikeAo) {
            return BaseResult.failed("系统维护中，请耐心等待。。。。");
        }
        if (fmsUserLikeAo.getCheck().equals(1)) {
            return BaseResult.failed("用户不存在");
        }
        return BaseResult.success("更新成功",
                fmsUserLikeAo.getFmsUserLike());
    }

    @DeleteMapping("/{jobNumber}")
    @ApiOperation(value = "删除喜好设置", notes = "根据用户学工号删除或重置喜好设置",
            httpMethod = "DELETE", response = BaseResult.class)
    @ApiImplicitParam(name = "jobNumber", value = "用户学工号",
            dataType = "String", required = true, example = "10200001")
    public BaseResult deleteByJobNumber(@PathVariable("jobNumber") String jobNumber) {
        Result result1 = FluentValidator.
                checkAll().
                on(jobNumber, new LengthValidator(7, 9, "学工号")).
                on(jobNumber, new NotNullValidator("学工号")).
                doValidate().
                result(ResultCollectors.toSimple());
        if (!result1.isSuccess()) {
            return BaseResult.validateFailed(GsonUtil.objectToString(result1.getErrors()));
        }

        int result = fmsUserLikeService.deleteByJobNumber(jobNumber);
        if (0 == result) {
            return BaseResult.failed("系统维护中，请耐心等待。。。。");
        }
        return BaseResult.success("删除或重置成功", result);
    }
}
