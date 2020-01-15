package com.duanxin.zqls.umps.service;

import com.duanxin.zqls.umps.ao.UmsRoleAo;
import com.duanxin.zqls.umps.api.UmsRoleService;
import com.duanxin.zqls.umps.constants.RoleConstant;
import com.duanxin.zqls.umps.mapper.UmsRoleMapper;
import com.duanxin.zqls.umps.model.UmsRole;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;
import org.apache.dubbo.config.annotation.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * 角色Service层实现
 * @author duanxin
 * @version 1.0
 * @date 2020/1/10 8:05
 */
@Service(version = "0.0.1")
public class UmsRoleServiceImpl implements UmsRoleService{

    @Resource
    private UmsRoleMapper umsRoleMapper;

    @Override
    public int saveUmsRole(UmsRole umsRole) {
        umsRole.setStatus(RoleConstant.change("0"));
        umsRole.setOperateTime(new Date());
        umsRole.setOperator("李四");
        umsRole.setOperateIp("0.0.0.0");
        return umsRoleMapper.insertSelective(umsRole);
    }

    @Override
    public UmsRoleAo selectUmsRoleByPrimaryId(Integer id) {
        UmsRoleAo umsRoleAo = new UmsRoleAo();
        UmsRole umsRole = umsRoleMapper.selectByPrimaryKey(id);
        if (umsRole == null || umsRole.getStatus().equals(Byte.parseByte("1"))) {
            umsRoleAo.setCheckCode(1);
        }
        umsRoleAo.setUmsRole(umsRole);
        return umsRoleAo;
    }

    @Override
    public PageInfo<UmsRoleAo> selectAll(Integer currentPage, Integer pageSize) {
        PageHelper.startPage(currentPage, pageSize);
        List<UmsRoleAo> umsRoleAos = Lists.newArrayList();
        List<UmsRole> umsRoles = umsRoleMapper.selectAll();
        umsRoles.forEach(u -> {
            UmsRoleAo umsRoleAo = new UmsRoleAo();
            if (u.getStatus().equals(Byte.parseByte("1"))) {
                umsRoleAo.setCheckCode(1);
            }
            umsRoleAo.setUmsRole(u);
            umsRoleAos.add(umsRoleAo);
        });
        return new PageInfo<>(umsRoleAos);
    }

    @Override
    public int deleteUmsRoleByPrimaryKey(Integer id) {
        return umsRoleMapper.updateByPrimaryKeySelective(UmsRole.builder().
                id(id).
                status(Byte.parseByte("1")).
                operateIp("0.0.0.0").
                operateTime(new Date()).
                operator("李四").
                build()
        );
    }

    @Override
    public UmsRoleAo updateUmsRole(UmsRole umsRole) {
        UmsRoleAo umsRoleAo = new UmsRoleAo();
        umsRole.setOperator("李四");
        umsRole.setOperateIp("0.0.0.0");
        umsRole.setOperateTime(new Date());
        umsRoleMapper.updateByPrimaryKeySelective(umsRole);
        UmsRole umsRole1 = umsRoleMapper.selectByPrimaryKey(umsRole.getId());
        if (umsRole1 == null || umsRole1.getStatus().equals(Byte.parseByte("1"))) {
            umsRoleAo.setCheckCode(1);
        }
        umsRoleAo.setUmsRole(umsRole1);
        return umsRoleAo;
    }
}
