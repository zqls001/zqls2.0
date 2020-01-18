package com.duanxin.zqls.umps.controller;

import com.duanxin.zqls.umps.ao.UmsRoleAo;
import com.duanxin.zqls.umps.api.UmsRoleService;
import com.duanxin.zqls.umps.dto.UmsRoleDto;
import com.duanxin.zqls.umps.dto.UmsRolePageInfo;
import com.duanxin.zqls.umps.model.UmsRole;
import com.duanxin.zqls.umps.vo.UmsRoleVo;
import com.duanxin.zqls.web.base.BaseResult;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author duanxin
 * @version 1.0
 * @date 2020/1/7 8:56
 */
@RestController
@RequestMapping("/UmsRole")
@Api(value = "权限模块业务的接口", tags = {"角色模块的Controller接口"})
public class UmsRoleController {

    @Reference(version = "0.0.1", check = false, mock = "true", protocol = "dubbo")
    private UmsRoleService umsRoleService;

    @GetMapping("/test")
    public BaseResult test() {
        return BaseResult.success("test success");
    }

    @PostMapping("/save")
    @ApiOperation(value = "添加角色", notes = "添加用户角色信息，如普通管理员、超级管理员之类",
            httpMethod = "POST", response = BaseResult.class)
    @ApiImplicitParam(name = "umsRole", value = "角色", required = true,
            dataTypeClass = UmsRole.class, example = "{\"name\" : \"root\", \"type\" : 0}")
    public BaseResult saveUmsRole(@RequestBody UmsRoleVo umsRoleVo) {
        int result = umsRoleService.saveUmsRole(umsRoleVo);
        if (0 == result) {
            return BaseResult.failed("系统维护中，请耐心等待。。。。");
        }
        return BaseResult.success("添加成功");
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "查询角色", notes = "根据角色主键id查询信息",
            httpMethod = "GET", response = BaseResult.class)
    @ApiImplicitParam(name = "id", value = "角色主键id", required = true,
    dataType = "int", example = "1")
    public BaseResult selectUmsRoleByPrimaryId(@PathVariable("id") Integer id) {
        UmsRoleAo umsRoleAo = umsRoleService.selectUmsRoleByPrimaryId(id);
        if (null == umsRoleAo) {
            return BaseResult.failed("系统维护中，请耐心等待。。。");
        }
        if (umsRoleAo.getCheckCode() == 1) {
            return BaseResult.failed("该角色信息不存在");
        }
        UmsRole umsRole = umsRoleAo.getUmsRole();
        UmsRoleDto umsRoleDto = UmsRoleDto.builder().
                id(umsRole.getId()).
                name(umsRole.getName()).
                type(umsRole.getType()).
                remark(umsRole.getRemark()).
                status(umsRole.getStatus()).
                build();
        return BaseResult.success(umsRoleDto);
    }

    @GetMapping("/getAll")
    @ApiOperation(value = "查询角色", notes = "分页查询角色信息",
    httpMethod = "GET", response = BaseResult.class)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "currentPage", value = "当前页大小", required = true,
            dataType = "int", example = "0"),
            @ApiImplicitParam(name = "pageSize", value = "每页大小", required = true,
            dataType = "int", example = "10")
    })
    public BaseResult selectAll(Integer currentPage, Integer pageSize) {
        PageInfo<UmsRoleAo> umsRoleAos = umsRoleService.selectAll(currentPage, pageSize);
        if (null == umsRoleAos) {
            return BaseResult.failed("系统维护中，请耐心等待。。。");
        }
        List<UmsRoleDto> umsRoleDtos = Lists.newArrayList();
        umsRoleAos.getList().stream().filter(u -> u.getCheckCode() != 1).forEach(u -> {
            UmsRole umsRole = u.getUmsRole();
            umsRoleDtos.add(UmsRoleDto.builder().
                    id(umsRole.getId()).
                    type(umsRole.getType()).
                    name(umsRole.getName()).
                    remark(umsRole.getRemark()).
                    status(umsRole.getStatus()).
                    build());
        });
        if (umsRoleDtos.size() == 0) {
            return BaseResult.failed("查询失败，不存在有效信息");
        }
        UmsRolePageInfo umsRolePageInfo = UmsRolePageInfo.builder().
                umsRoleDtos(umsRoleDtos).
                nextPage(umsRoleAos.getNextPage()).
                pageSize(umsRoleAos.getPageSize()).
                pageNo(umsRoleAos.getPageNum()).
                prePage(umsRoleAos.getPrePage()).
                totalCount(umsRoleAos.getTotal()).
                totalPage(umsRoleAos.getPages()).
                build();
        return BaseResult.success(umsRolePageInfo);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "删除角色", notes = "根据角色主键id删除角色",
            httpMethod = "DELETE", response = BaseResult.class)
    @ApiImplicitParam(name = "id", value = "角色主键", required = true,
            dataType = "int", example = "1")
    public BaseResult deleteUmsRoleByPrimaryKey(@PathVariable("id") Integer id) {
        int result = umsRoleService.deleteUmsRoleByPrimaryKey(id);
        if (0 == result) {
            return BaseResult.failed("系统维护中，请耐心等待。。。");
        }
        return BaseResult.success("删除成功");
    }

    @PutMapping("/update")
    @ApiOperation(value = "更新信息", notes = "更新角色信息",
            httpMethod = "PUT", response = BaseResult.class)
    @ApiImplicitParam(name = "umsRole", value = "需要更新的角色信息", required = true,
            dataTypeClass = UmsRole.class, example = "{\"name\":\"admin\"}")
    public BaseResult updateUmsRole(@RequestBody UmsRole umsRole) {
        UmsRoleAo umsRoleAo = umsRoleService.updateUmsRole(umsRole);
        if (null == umsRoleAo) {
            return BaseResult.failed("系统维护中，请耐心等待。。。");
        }
        if (umsRoleAo.getCheckCode() == 1) {
            return BaseResult.failed("角色不存在");
        }
        UmsRole umsRole1 = umsRoleAo.getUmsRole();
        return BaseResult.success("更新成功", UmsRoleVo.builder().
                status(umsRole1.getStatus()).
                type(umsRole1.getType()).
                name(umsRole1.getName()).
                remark(umsRole1.getRemark()).
                build()
        );
    }
}
