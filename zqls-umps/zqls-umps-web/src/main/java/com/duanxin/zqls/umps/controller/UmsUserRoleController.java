package com.duanxin.zqls.umps.controller;

import com.duanxin.zqls.ucenter.dto.UmsUserInfoDto;
import com.duanxin.zqls.ucenter.model.UmsUserInfo;
import com.duanxin.zqls.umps.ao.UmsUserRoleAo;
import com.duanxin.zqls.umps.api.UmsUserRoleService;
import com.duanxin.zqls.umps.dto.UmsRoleDto;
import com.duanxin.zqls.umps.dto.UmsUserRoleDto;
import com.duanxin.zqls.umps.model.UmsRole;
import com.duanxin.zqls.umps.vo.UmsUserRoleVo;
import com.duanxin.zqls.web.base.BaseResult;
import com.google.common.collect.Lists;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.apache.dubbo.common.utils.CollectionUtils;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 用户角色Controller层实现
 * @author duanxin
 * @version 1.0
 * @date 2020/2/2 8:53
 */
@RestController
@RequestMapping("/UmsUserRole")
@Api(value = "权限模块业务接口", tags = {"用户角色模块Controller接口"})
public class UmsUserRoleController {

    @Reference(version = "0.0.1", check = false, mock = "true", protocol = "dubbo")
    private UmsUserRoleService umsUserRoleService;

    @GetMapping("/{rid}")
    @ApiOperation(value = "查询角色用户集合", notes = "根据角色主键id查询用户集合",
            httpMethod = "GET", response = BaseResult.class)
    @ApiImplicitParam(name = "rid", value = "角色主键id",
            required = true, dataType = "int", example = "1")
    public BaseResult selectUserListByRid(@PathVariable("rid") Integer rid) {
        List<UmsUserInfo> umsUserInfos = umsUserRoleService.selectUserListByRid(rid);
        if (umsUserInfos == null) {
            return BaseResult.failed("系统维护中，请耐心等待。。。");
        }
        if (umsUserInfos.size() == 0) {
            return BaseResult.failed("用户集合信息不存在或不合法");
        }
        List<UmsUserInfoDto> umsUserInfoDtos = Lists.newArrayList();
        umsUserInfos.forEach(u -> {
            umsUserInfoDtos.add(UmsUserInfoDto.builder().
                    id(u.getId()).
                    userName(u.getUserName()).
                    type(u.getType()).
                    remark(u.getRemark()).
                    status(u.getStatus()).
                    aid(u.getAid()).
                    email(u.getEmail()).
                    gender(u.getGender()).
                    headPic(u.getHeadPic()).
                    phone(u.getPhone()).
                    jobNumber(u.getJobNumber()).
                    build()
            );
        });
        return BaseResult.success("查询成功", umsUserInfoDtos);
    }

    @PostMapping("/changeUsers")
    @ApiOperation(value = "给角色添加用户", notes = "给该角色添加用户集合",
            httpMethod = "POST", response = BaseResult.class)
    @ApiImplicitParam(name = "umsUserRoleVo", value = "角色用户实体类",
            required = true, dataTypeClass = UmsUserRoleVo.class, example = "{\"rid\": 1, \"uids\": [2,3,4]}")
    public BaseResult changeRoleUsers(@RequestBody UmsUserRoleVo umsUserRoleVo) {
        UmsUserRoleAo umsUserRoleAo = umsUserRoleService.changeRoleUsers(umsUserRoleVo);
        if (null == umsUserRoleAo) {
            return BaseResult.failed("系统维护中，请耐心等待。。。");
        }
        if (umsUserRoleAo.getCheckCode() == 1) {
            return BaseResult.failed("角色信息不存在");
        }
        if (CollectionUtils.isEmpty(umsUserRoleAo.getUmsUserInfos())) {
            return BaseResult.failed("用户集合信息不存在");
        }
        UmsRole umsRole = umsUserRoleAo.getUmsRole();
        UmsRoleDto umsRoleDto = UmsRoleDto.builder().
                id(umsRole.getId()).
                name(umsRole.getName()).
                type(umsRole.getType()).
                remark(umsRole.getRemark()).
                status(umsRole.getStatus()).
                build();
        List<UmsUserInfoDto> umsUserInfoDtos = Lists.newArrayList();
        umsUserRoleAo.getUmsUserInfos().forEach(u -> {
            umsUserInfoDtos.add(UmsUserInfoDto.builder().
                    userName(u.getUserName()).
                    id(u.getId()).
                    type(u.getType()).
                    remark(u.getRemark()).
                    status(u.getStatus()).
                    aid(u.getAid()).
                    email(u.getEmail()).
                    gender(u.getGender()).
                    headPic(u.getHeadPic()).
                    phone(u.getPhone()).
                    jobNumber(u.getJobNumber()).
                    build()
            );
        });
        UmsUserRoleDto umsUserRoleDto = UmsUserRoleDto.builder().
                umsRoleDto(umsRoleDto).
                umsUserInfoDtos(umsUserInfoDtos).
                build();
        return BaseResult.success("更新成功", umsUserRoleDto);
    }
}
