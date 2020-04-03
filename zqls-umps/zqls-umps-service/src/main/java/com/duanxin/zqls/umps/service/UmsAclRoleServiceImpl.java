package com.duanxin.zqls.umps.service;

import com.duanxin.zqls.common.util.Builder;
import com.duanxin.zqls.umps.ao.UmsAclRoleAo;
import com.duanxin.zqls.umps.api.UmsAclRoleService;
import com.duanxin.zqls.umps.mapper.UmsAclMapper;
import com.duanxin.zqls.umps.mapper.UmsAclRoleMapper;
import com.duanxin.zqls.umps.mapper.UmsRoleMapper;
import com.duanxin.zqls.umps.model.UmsAcl;
import com.duanxin.zqls.umps.model.UmsAclRole;
import com.duanxin.zqls.umps.model.UmsRole;
import com.google.common.collect.Lists;
import org.apache.dubbo.common.utils.CollectionUtils;
import org.apache.dubbo.config.annotation.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

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
    public List<UmsAcl> selectRoleAcls(Integer rid) {
        List<UmsAcl> umsAcls = umsAclRoleMapper.selectAclInfosByRid(rid);
        if (CollectionUtils.isEmpty(umsAcls)) {
            return Lists.newArrayList();
        }
        if (CollectionUtils.isNotEmpty(umsAcls)) {
            List<UmsAcl> collect = umsAcls.stream().
                    filter(u -> u.getStatus().equals(Byte.parseByte("0"))).
                    collect(Collectors.toList());
            if (CollectionUtils.isEmpty(collect)) {
                return Lists.newArrayList();
            }
        }
        return umsAcls;
    }

    @Override
    public UmsAclRoleAo changeRoleAcl(Integer rid, List<Integer> aids) {
        UmsAclRoleAo umsAclRoleAo = new UmsAclRoleAo();
        UmsRole umsRole = umsRoleMapper.selectByPrimaryKey(rid);
        List<UmsAcl> umsAcls = umsAclMapper.selectListByIds(aids);
        // 判断数据库中是否有相应的数据
        if (umsRole == null || umsRole.getStatus().equals(Byte.parseByte("1"))) {
            umsAclRoleAo.setCheckCode(1);
            return umsAclRoleAo;
        }
        if (CollectionUtils.isNotEmpty(umsAcls)) {
            List<UmsAcl> collect = umsAcls.stream().
                    filter(u -> u.getStatus().equals(Byte.parseByte("0"))).
                    collect(Collectors.toList());
            umsAclRoleAo.setUmsAcls(collect);
        }
        umsAclRoleAo.setUmsRole(umsRole);
        // 判断是否是原权限
        List<Integer> originalAids = umsAclRoleMapper.selectAidsByRid(rid);
        if (CollectionUtils.isNotEmpty(originalAids) && originalAids.containsAll(aids)) {
            return umsAclRoleAo;
        }
        // 更新权限
        updateRoleAcl(rid, aids);
        return umsAclRoleAo;
    }

    @Override
    public List<Integer> selectAidsByRids(List<Integer> rids) {
        return umsAclRoleMapper.selectAidsByRids(rids);
    }

    private void updateRoleAcl(Integer rid, List<Integer> aids) {
        // 删除之前的记录
        umsAclRoleMapper.delete(Builder.of(UmsAclRole::new).with(UmsAclRole::setRid, rid).build());
        if (CollectionUtils.isEmpty(aids)) {
            return ;
        }

        List<UmsAclRole> umsAclRoles = Lists.newArrayList();
        aids.forEach(a -> {
            umsAclRoles.add(Builder.of(UmsAclRole::new).
                    with(UmsAclRole::setRid, rid).
                    with(UmsAclRole::setAid, a).
                    with(UmsAclRole::setOperateIp, "0.0.0.0").
                    with(UmsAclRole::setOperateTime, new Date()).
                    with(UmsAclRole::setOperator, "李四").
                    build()
            );
        });
        umsAclRoleMapper.insertBatch(umsAclRoles);
    }
}
