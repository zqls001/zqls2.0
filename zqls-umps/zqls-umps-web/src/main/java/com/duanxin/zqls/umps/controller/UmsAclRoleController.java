package com.duanxin.zqls.umps.controller;

import com.duanxin.zqls.common.util.Builder;
import com.duanxin.zqls.umps.ao.UmsAclRoleAo;
import com.duanxin.zqls.umps.api.UmsAclRoleService;
import com.duanxin.zqls.umps.dto.UmsAclDto;
import com.duanxin.zqls.umps.dto.UmsAclRoleDto;
import com.duanxin.zqls.umps.dto.UmsRoleDto;
import com.duanxin.zqls.umps.model.UmsAcl;
import com.duanxin.zqls.umps.model.UmsRole;
import com.duanxin.zqls.umps.vo.UmsAclRoleVo;
import com.duanxin.zqls.web.base.BaseResult;
import com.google.common.collect.Lists;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.apache.dubbo.common.utils.CollectionUtils;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 权限角色Controller层实现
 * @author duanxin
 * @version 1.0
 * @date 2020/1/26 8:38
 */
@RestController
@RequestMapping("/UmsAclRole")
@Api(value = "权限模块业务的接口", tags = {"权限角色模块Controller接口"})
public class UmsAclRoleController {

    @Reference(version = "0.0.1", mock = "true", check = false, protocol = "dubbo")
    private UmsAclRoleService umsAclRoleService;

    @PostMapping("/changeAcls")
    @ApiOperation(value = "给角色添加权限", notes = "给该角色添加权限集合",
            httpMethod = "POST", response = BaseResult.class)
    @ApiImplicitParam(name = "umsAclRoleVo", value = "角色权限实体类",
            required = true, dataTypeClass = UmsAclRoleVo.class, example = "{\"rid\": 2, \"aids\": [\"1\", \"2\"]}")
    public BaseResult changeRoleAcl(@RequestBody UmsAclRoleVo umsAclRoleVo) {
        UmsAclRoleAo umsAclRoleAo =
                umsAclRoleService.changeRoleAcl(umsAclRoleVo.getRid(), umsAclRoleVo.getAids());
        if (umsAclRoleAo == null) {
            return BaseResult.failed("系统维护中，请耐心等待");
        }
        if (umsAclRoleAo.getCheckCode() == 1) {
            return BaseResult.failed("角色信息不存在");
        }
        if (CollectionUtils.isEmpty(umsAclRoleAo.getUmsAcls())) {
            return BaseResult.failed("用户信息不存在");
        }
        UmsRole umsRole = umsAclRoleAo.getUmsRole();
        UmsRoleDto umsRoleDto = new UmsRoleDto();
        BeanUtils.copyProperties(umsRole, umsRoleDto);
        List<UmsAclDto> umsAclDtos = Lists.newArrayList();
        umsAclRoleAo.getUmsAcls().forEach(u -> {
            UmsAclDto umsAclDto1 = new UmsAclDto();
            BeanUtils.copyProperties(u, umsAclDto1);
            umsAclDtos.add(umsAclDto1);
        });
        UmsAclRoleDto umsAclRoleDto = Builder.
                of(UmsAclRoleDto::new).
                with(UmsAclRoleDto::setUmsAclDtos, umsAclDtos).
                with(UmsAclRoleDto::setUmsRoleDto, umsRoleDto).
                build();
        return BaseResult.success("更新成功", umsAclRoleDto);
    }

    @GetMapping("/{rid}")
    @ApiOperation(value = "查询角色权限", notes = "根据角色主键id查询该角色的权限集合",
            httpMethod = "GET", response = BaseResult.class)
    @ApiImplicitParam(name = "rid", value = "角色主键id",
            dataType = "int", required = true, example = "1")
    public BaseResult selectRoleAcls(@PathVariable("rid") Integer rid) {
        List<UmsAcl> umsAcls = umsAclRoleService.selectRoleAcls(rid);
        if (umsAcls == null) {
            return BaseResult.failed("系统维护中，请耐心等待。。。");
        }
        List<UmsAclDto> umsAclDtos = Lists.newArrayList();
        umsAcls.forEach(u -> {
            UmsAclDto umsAclDto1 = new UmsAclDto();
            BeanUtils.copyProperties(u, umsAclDto1);
            umsAclDtos.add(umsAclDto1);
        });
        return BaseResult.success("查询成功", umsAclDtos);
    }
}
