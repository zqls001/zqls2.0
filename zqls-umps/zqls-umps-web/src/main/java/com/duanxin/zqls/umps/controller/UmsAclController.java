package com.duanxin.zqls.umps.controller;

import com.duanxin.zqls.umps.ao.UmsAclAo;
import com.duanxin.zqls.umps.api.UmsAclService;
import com.duanxin.zqls.umps.dto.UmsAclDto;
import com.duanxin.zqls.umps.dto.UmsAclPageInfo;
import com.duanxin.zqls.umps.model.UmsAcl;
import com.duanxin.zqls.umps.vo.UmsAclVo;
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
 * 权限Controller层接口
 * @author duanxin
 * @version 1.0
 * @date 2020/1/16 9:21
 */
@RestController
@RequestMapping("/UmsAcl")
@Api(value = "权限模块业务的接口", tags = {"权限管理模块的Controller接口"})
public class UmsAclController {

    @Reference(version = "0.0.1", check = false, mock = "true", protocol = "dubbo")
    private UmsAclService umsAclService;

    @PostMapping("/save")
    @ApiOperation(value = "添加权限信息", notes = "添加权限信息，如删除权限，查看权限",
            httpMethod = "POST", response = BaseResult.class)
    @ApiImplicitParam(name = "umsAclVo", value = "权限实体类", required = true,
            dataTypeClass = UmsAclVo.class, example = "\"code\": \"001\", \"name\": \"查询权限\", \"url\": \"http:127.0.0.1:8071/UmsUser/getAll\", \"type\": 0, \"status\": 0, \"remark\": \"该权限用于查询用户信息\"")
    public BaseResult saveUmsAcl(@RequestBody UmsAclVo umsAclVo) {
        int result = umsAclService.saveUmsAcl(umsAclVo);
        if (0 == result) {
            return BaseResult.failed("系统维护中，请耐心等待。。。");
        }
        return BaseResult.success("添加成功");
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "查询权限信息", notes = "根据权限主键id查询权限信息",
            httpMethod = "GET", response = BaseResult.class)
    @ApiImplicitParam(name = "id", value = "权限主键id", required = true,
            dataType = "int", example = "1")
    public BaseResult selectUmsAclByPrimaryKey(@PathVariable("id") Integer id) {
        UmsAclAo umsAclAo = umsAclService.selectUmsAclByPrimaryKey(id);
        if (null == umsAclAo) {
            return BaseResult.failed("系统维护中，请耐心等待。。。");
        }
        if (1 == umsAclAo.getCheckCode()) {
            return BaseResult.failed("查询失败，该权限信息不存在");
        }
        UmsAcl umsAcl = umsAclAo.getUmsAcl();
        UmsAclDto umsAclDto = UmsAclDto.builder().
                id(umsAcl.getId()).
                name(umsAcl.getName()).
                type(umsAcl.getType()).
                url(umsAcl.getUrl()).
                remark(umsAcl.getRemark()).
                status(umsAcl.getStatus()).
                build();
        return BaseResult.success("查询成功", umsAclDto);
    }

    @GetMapping("/getAll")
    @ApiOperation(value = "查询权限", notes = "分页查询权限信息",
            httpMethod = "GET", response = BaseResult.class)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "currentPage", value = "当前页大小", required = true,
                    dataType = "int", example = "0"),
            @ApiImplicitParam(name = "pageSize", value = "每页大小", required = true,
                    dataType = "int", example = "10")
    })
    public BaseResult selectAll(@RequestParam("currentPage") Integer currentPage,
                                @RequestParam("pageSize") Integer pageSize) {
        PageInfo<UmsAclAo> umsAclAos = umsAclService.selectAll(currentPage, pageSize);
        List<UmsAclDto> umsAclDtos = Lists.newArrayList();
        umsAclAos.getList().stream().filter(u -> u.getCheckCode() != 1).forEach(u -> {
            UmsAcl umsAcl = u.getUmsAcl();
            umsAclDtos.add(UmsAclDto.builder().
                    id(umsAcl.getId()).
                    name(umsAcl.getName()).
                    url(umsAcl.getUrl()).
                    type(umsAcl.getType()).
                    code(umsAcl.getCode()).
                    remark(umsAcl.getRemark()).
                    status(umsAcl.getStatus()).
                    build()
            );
        });
        if (0 == umsAclDtos.size()) {
            return BaseResult.failed("查询结果不存在");
        }
        com.duanxin.zqls.common.dto.PageInfo pageInfo = com.duanxin.zqls.common.dto.PageInfo.builder().
                nextPage(umsAclAos.getNextPage()).
                pageSize(umsAclAos.getPageSize()).
                pageNo(umsAclAos.getPageNum()).
                prePage(umsAclAos.getPrePage()).
                totalCount(umsAclAos.getTotal()).
                totalPage(umsAclAos.getPages()).
                build();
        UmsAclPageInfo aclPageInfo = UmsAclPageInfo.builder().
                pageInfo(pageInfo).
                umsAclDtos(umsAclDtos).
                build();
        return BaseResult.success("查询成功", aclPageInfo);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "删除权限信息", notes = "根据权限主键id删除权限",
            httpMethod = "DELETE", response = BaseResult.class)
    @ApiImplicitParam(name = "id", value = "角色主键", required = true,
            dataType = "int", example = "1")
    public BaseResult deleteUmsAclByPrimaryKey(@PathVariable("id") Integer id) {
        int result = umsAclService.deleteUmsAclByPrimaryKey(id);
        if (result == 0) {
            return BaseResult.failed("系统维护中，请耐心等待。。。");
        }
        return BaseResult.success("删除成功");
    }

    @PutMapping("/update")
    @ApiOperation(value = "更新信息", notes = "更新权限信息",
            httpMethod = "PUT", response = BaseResult.class)
    @ApiImplicitParam(name = "umsAcl", value = "需更新的权限信息",
            required = true, dataTypeClass = UmsAcl.class, example = "\"id\": 1,\"name\": \"根据权限主键删除信息\", \"url\": \"http://localhost:8072/UmsAcl/1\"")
    public BaseResult updateUmsAcl(@RequestBody UmsAcl umsAcl) {
        UmsAclAo umsAclAo = umsAclService.updateUmsAcl(umsAcl);
        if (null == umsAclAo) {
            return BaseResult.failed("系统维护中，请耐心等待。。。");
        }
        if (1 == umsAclAo.getCheckCode()) {
            return BaseResult.failed("该权限不存在");
        }
        UmsAcl umsAcl1 = umsAclAo.getUmsAcl();
        UmsAclDto umsAclDto = UmsAclDto.builder().
                id(umsAcl1.getId()).
                name(umsAcl1.getName()).
                type(umsAcl1.getType()).
                url(umsAcl1.getUrl()).
                status(umsAcl1.getStatus()).
                remark(umsAcl1.getRemark()).
                code(umsAcl1.getCode()).
                build();
        return BaseResult.success("更新成功", umsAclDto);
    }
}
