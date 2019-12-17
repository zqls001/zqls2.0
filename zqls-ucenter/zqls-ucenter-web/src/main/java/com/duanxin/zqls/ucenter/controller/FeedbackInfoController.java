package com.duanxin.zqls.ucenter.controller;

import com.baidu.unbiz.fluentvalidator.FluentValidator;
import com.baidu.unbiz.fluentvalidator.Result;
import com.baidu.unbiz.fluentvalidator.ResultCollectors;
import com.duanxin.zqls.common.util.GsonUtil;
import com.duanxin.zqls.ucenter.ao.FeedbackInfoAo;
import com.duanxin.zqls.ucenter.api.FeedbackInfoService;
import com.duanxin.zqls.ucenter.constants.CommonConstant;
import com.duanxin.zqls.ucenter.model.FeedbackInfo;
import com.duanxin.zqls.web.annotation.LoginRequired;
import com.duanxin.zqls.web.base.BaseResult;
import com.duanxin.zqls.web.util.FastdfsUtil;
import com.duanxin.zqls.web.validate.LengthValidator;
import com.duanxin.zqls.web.validate.NotNullValidator;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Arrays;

/**
 * 反馈信息Controller层接口
 * @author duanxin
 * @version 1.0
 * @date 2019/12/8 10:46
 */
@RestController
@RequestMapping("/FeedBack")
@Api(value = "用户模块业务接口", tags = {"用户反馈信息Controller接口"})
@Slf4j
public class FeedbackInfoController {

    @Reference(version = "0.0.1", mock = "true", check = false, protocol = "dubbo")
    private FeedbackInfoService feedbackInfoService;

    @PostMapping("/save")
    @ApiOperation(value = "添加用户反馈信息", httpMethod = "POST",
            response = BaseResult.class)
    @ApiImplicitParam(name = "feedBackInfo", value = "用户反馈信息实体",
            dataTypeClass = FeedbackInfo.class, required = true)
    @LoginRequired
    public BaseResult saveFeedbackInfo(@RequestBody FeedbackInfo feedbackInfo) {
        // validate
        Result results = FluentValidator.
                checkAll().
                on(feedbackInfo.getUid(), new LengthValidator(7, 9, "学工号")).
                on(feedbackInfo.getUid(), new NotNullValidator("学工号")).
                doValidate().
                result(ResultCollectors.toSimple());
        if (!results.isSuccess()) {
            return BaseResult.validateFailed(GsonUtil.objectToString(results.getErrors()));
        }
        int result = feedbackInfoService.saveFeedbackInfo(feedbackInfo);
        if (0 == result) {
            return BaseResult.failed("系统维护中，请耐心等待。。。");
        }
        return BaseResult.success("反馈成功", result);
    }

    @PostMapping(value = "/uploadFile", headers = "content-type=multipart/form-data")
    @ApiOperation(value = "上传文件", notes = "用户上传反馈信息图片接口",
            httpMethod = "POST", response = BaseResult.class)
    @LoginRequired
    public BaseResult uploadFile(@ApiParam(name = "file", value = "文件实体") @RequestParam("file") MultipartFile file) {
        StringBuilder sb = new StringBuilder(CommonConstant.PIC_URL_PRE);
        try {
            byte[] buffBytes = file.getBytes();
            String fileName = file.getOriginalFilename();
            String[] files = FastdfsUtil.uploadFile(buffBytes, fileName);
            Arrays.stream(files).forEach(s -> sb.append("/").append(s));
        } catch (IOException e) {
            log.error("上传失败", e);
            return BaseResult.failed("上传文件失败");
        }
        return BaseResult.success("上传成功", sb.toString());
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "查询反馈详情", notes = "根据反馈主键id查询反馈详情",
            httpMethod = "GET", response = BaseResult.class)
    @ApiImplicitParam(name = "id", value = "反馈主键id", dataType = "int",
            required = true, example = "1")
    @LoginRequired
    public BaseResult getFeedbackById(@PathVariable("id") Integer id) {
        FeedbackInfoAo feedbackInfoAo = feedbackInfoService.getFeedbackById(id);
        if (feedbackInfoAo == null) {
            return BaseResult.failed("系统维护中，请耐心等待。。。。");
        }
        if (1 == feedbackInfoAo.getCheckCode()) {
            return BaseResult.failed("反馈信息不存在");
        }
        return BaseResult.success("查询成功", feedbackInfoAo.getFeedbackInfo());
    }

    @GetMapping("/getByJobNumber")
    @ApiOperation(value = "根据用户学工号分页查询自己的反馈", httpMethod = "GET", response = BaseResult.class)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "jobNumber", value = "用户学工号",
                    dataType = "String", required = true, example = "10200001"),
            @ApiImplicitParam(name = "currentPage", value = "当前所在页数，从0开始",
                    dataType = "int", required = true, example = "1"),
            @ApiImplicitParam(name = "pageSize", value = "每页所展示的用户数",
                    dataType = "int", required = true, example = "10")
    })
    @LoginRequired
    public BaseResult getFeedbackByJobNumberWithPages(@RequestParam("jobNumber") String jobNumber,
                                                      @RequestParam("currentPage") int currentPage,
                                                      @RequestParam("pageSize") int pageSize) {
        // validate
        Result result = FluentValidator.
                checkAll().
                on(jobNumber, new NotNullValidator("学工号")).
                on(jobNumber, new LengthValidator(7, 9, "学工号")).
                doValidate().
                result(ResultCollectors.toSimple());
        if (!result.isSuccess()) {
            return BaseResult.validateFailed(GsonUtil.objectToString(result.getErrors()));
        }

        PageInfo<FeedbackInfo> feedbackInfoPageInfo =
                feedbackInfoService.getFeedbackByJobNumberWithPages(jobNumber, currentPage, pageSize);
        if (null == feedbackInfoPageInfo) {
            BaseResult.failed("系统维护中，请耐心等待。。。");
        }
        return BaseResult.success("查询成功", feedbackInfoPageInfo);
    }

    @GetMapping("/getAll")
    @ApiOperation(value = "查询所有反馈信息", notes = "管理员分页查询反馈信息",
            httpMethod = "GET", response = BaseResult.class)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "currentPage", value = "当前所在页数，从0开始",
                    dataType = "int", required = true, example = "1"),
            @ApiImplicitParam(name = "pageSize", value = "每页所展示的用户数",
                    dataType = "int", required = true, example = "10")
    })
    @LoginRequired
    public BaseResult getAll(@RequestParam("currentPage") int currentPage,
                             @RequestParam("pageSize") int pageSize) {
        PageInfo<FeedbackInfo> feedbackInfoPageInfo =
                feedbackInfoService.getAll(currentPage, pageSize);
        if (feedbackInfoPageInfo == null) {
            return BaseResult.failed("系统维护中，请耐心等待。。。");
        }
        return BaseResult.success("查询成功", feedbackInfoPageInfo);
    }

    @PutMapping("/update")
    @ApiOperation(value = "反馈信息更新操作", httpMethod = "PUT", response = BaseResult.class)
    @ApiImplicitParam(name = "feedbackInfo", value = "更新后的反馈信息实体",
            dataTypeClass = FeedbackInfo.class)
    @LoginRequired
    public BaseResult updateFeedbackInfo(@RequestBody FeedbackInfo feedbackInfo) {
        FeedbackInfo info = feedbackInfoService.updateFeedbackInfo(feedbackInfo);
        if (info == null) {
            BaseResult.failed("系统维护中，请耐心等待。。。");
        }
        return BaseResult.success("更新成功", info);
    }

    @DeleteMapping("{id}")
    @ApiOperation(value = "根据主键id删除反馈信息", httpMethod = "DELETE",
            response = BaseResult.class)
    @ApiImplicitParam(name = "id", value = "反馈信息主键id",
            dataType = "int", required = true, example = "1")
    @LoginRequired
    public BaseResult deleteFeedbackInfo(@PathVariable("id") Integer id) {
        int result = feedbackInfoService.deleteFeedbackInfo(id);
        if (result == 0) {
            return BaseResult.failed("系统维护中，请耐心等待。。。");
        }
        if (result == 2) {
            return BaseResult.failed("反馈信息不存在");
        }
        return BaseResult.success("删除成功", result);
    }
}
