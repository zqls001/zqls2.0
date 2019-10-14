package com.duanxin.zqls.ucenter.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.duanxin.zqls.base.BaseConstants;
import com.duanxin.zqls.base.BaseResult;
import com.duanxin.zqls.ucenter.api.UmsUserInfoService;
import com.duanxin.zqls.ucenter.model.UmsUserInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户信息Controller层实现
 * @author duanxin
 * @version 1.0
 * @date 2019/10/14 15:48
 */
@RestController
@RequestMapping("/UmsUser")
public class UmsUserInfoController {

    @Reference
    private UmsUserInfoService umsUserInfoService;

    @GetMapping("/{id}")
    public BaseResult getUmsUserInfoByPrimaryKey(@PathVariable("id") Integer id) {
        UmsUserInfo umsUserInfo = umsUserInfoService.selectByPrimaryKey(id).get(0);
        if (null != umsUserInfo) {
            String status = String.valueOf(umsUserInfo.getStatus());
            if (StringUtils.isNotBlank(status) && StringUtils.equals(status, BaseConstants.STATUS_CONSTANT)) {
                return BaseResult.success(umsUserInfo);
            }
        }
        return BaseResult.failed("该用户不存在");
    }

}
