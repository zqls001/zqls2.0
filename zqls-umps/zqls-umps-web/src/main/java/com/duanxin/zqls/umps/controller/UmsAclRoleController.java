package com.duanxin.zqls.umps.controller;

import com.duanxin.zqls.umps.api.UmsAclRoleService;
import com.duanxin.zqls.umps.dto.UmsAclDto;
import com.duanxin.zqls.web.base.BaseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.dubbo.config.annotation.Reference;
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
    @ApiImplicitParams({
            @ApiImplicitParam(name = "rid", value = "角色主键id",
                    dataType = "int", required = true, example = "1"),
            @ApiImplicitParam(name = "aids", value = "权限集合id",
                    dataTypeClass = List.class, required = true, example = "[1,2,3,4]")
    })
    public BaseResult changeRoleAcl(Integer rid, List<Integer> aids) {
        return null;
    }

    @GetMapping("/{rid}")
    @ApiOperation(value = "查询角色权限", notes = "根据角色主键id查询该角色的权限集合",
            httpMethod = "GET", response = BaseResult.class)
    @ApiImplicitParam(name = "rid", value = "角色主键id",
            dataType = "int", required = true, example = "1")
    public BaseResult selectRoleAcls(@PathVariable("rid") Integer rid) {
        List<UmsAclDto> umsAclDtos = umsAclRoleService.selectRoleAcls(rid);
        if (umsAclDtos == null) {
            return BaseResult.failed("系统维护中，请耐心等待。。。");
        }
        return BaseResult.success("查询成功", umsAclDtos);
    }
}
