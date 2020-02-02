package com.duanxin.zqls.umps.service;

import com.duanxin.zqls.umps.ao.UmsAclRoleAo;
import com.duanxin.zqls.umps.api.UmsAclRoleService;
import com.duanxin.zqls.umps.dto.UmsAclDto;
import com.duanxin.zqls.umps.mapper.UmsAclMapper;
import com.duanxin.zqls.umps.mapper.UmsAclRoleMapper;
import com.duanxin.zqls.umps.mapper.UmsRoleMapper;
import com.duanxin.zqls.umps.model.UmsAcl;
import com.duanxin.zqls.umps.model.UmsAclRole;
import com.duanxin.zqls.umps.model.UmsRole;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import org.apache.dubbo.common.utils.CollectionUtils;
import org.apache.dubbo.config.annotation.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * 角色权限Service层实现
 * @author duanxin
 * @version 1.0
 * @date 2020/1/28 8:38
 */
@Service(version = "0.0.1")
public class UmsAclRoleServiceImpl implements UmsAclRoleService {

    @Resource
    private UmsAclRoleMapper umsAclRoleMapper;
    @Resource
    private UmsRoleMapper umsRoleMapper;
    @Resource
    private UmsAclMapper umsAclMapper;

    @Override
    public List<UmsAclDto> selectRoleAcls(Integer rid) {
        List<UmsAcl> umsAcls = umsAclRoleMapper.selectAclInfosByRid(rid);
        if (CollectionUtils.isEmpty(umsAcls)) {
            return Lists.newArrayList();
        }
        List<UmsAclDto> umsAclDtos = Lists.newArrayList();
        umsAcls.forEach(u -> {
            umsAclDtos.add(UmsAclDto.builder().
                    id(u.getId()).
                    name(u.getName()).
                    type(u.getType()).
                    url(u.getUrl()).
                    status(u.getStatus()).
                    remark(u.getRemark()).
                    code(u.getCode()).
                    build()
            );
        });
        return umsAclDtos;
    }

    @Override
    public UmsAclRoleAo changeRoleAcl(Integer rid, List<Integer> aids) {
        UmsAclRoleAo umsAclRoleAo = new UmsAclRoleAo();
        UmsRole umsRole = umsRoleMapper.selectByPrimaryKey(rid);
        List<UmsAcl> umsAcls = umsAclMapper.selectBatch(aids);
        // 判断数据库中是否有相应的数据
        if (umsRole == null || umsRole.getStatus().equals(Byte.parseByte("1")) || CollectionUtils.isEmpty(umsAcls)) {
            umsAclRoleAo.setCheckCode(1);
            return umsAclRoleAo;
        }
        umsAclRoleAo.setUmsAcls(umsAcls);
        umsAclRoleAo.setUmsRole(umsRole);
        // 判断是否是原权限
        List<Integer> originalAids = umsAclRoleMapper.selectAidsByRid(rid);
        if (CollectionUtils.isNotEmpty(originalAids)) {
            Set<Integer> originalAidSet = Sets.newHashSet(originalAids);
            originalAidSet.removeAll(aids);
            if (CollectionUtils.isEmpty(originalAidSet)) {
                return umsAclRoleAo;
            }
        }
        // 更新权限
        updateRoleAcl(rid, aids);
        return umsAclRoleAo;
    }

    private void updateRoleAcl(Integer rid, List<Integer> aids) {
        if (CollectionUtils.isEmpty(aids)) {
            return ;
        }

        List<UmsAclRole> umsAclRoles = Lists.newArrayList();
        aids.forEach(a -> {
            umsAclRoles.add(UmsAclRole.builder().
                    rid(rid).
                    aid(a).
                    operateIp("0.0.0.0").
                    operateTime(new Date()).
                    operator("李四").
                    build()
            );
        });
        umsAclRoleMapper.insertBatch(umsAclRoles);
    }
}
