package com.duanxin.zqls.umps.service;

import com.duanxin.zqls.ucenter.api.UmsUserInfoService;
import com.duanxin.zqls.ucenter.model.UmsUserInfo;
import com.duanxin.zqls.umps.ao.UmsUserRoleAo;
import com.duanxin.zqls.umps.api.UmsUserRoleService;
import com.duanxin.zqls.umps.mapper.UmsRoleMapper;
import com.duanxin.zqls.umps.mapper.UmsUserRoleMapper;
import com.duanxin.zqls.umps.model.UmsRole;
import com.duanxin.zqls.umps.model.UmsUserRole;
import com.duanxin.zqls.umps.vo.UmsUserRoleVo;
import com.google.common.collect.Lists;
import org.apache.dubbo.common.utils.CollectionUtils;
import org.apache.dubbo.config.annotation.Reference;
import org.apache.dubbo.config.annotation.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 用户角色Service层实现
 * @author duanxin
 * @version 1.0
 * @date 2020/2/2 9:28
 */
@Service(version = "0.0.1")
public class UmsUserRoleServiceImpl implements UmsUserRoleService {

    @Resource
    private UmsUserRoleMapper umsUserRoleMapper;
    @Resource
    private UmsRoleMapper umsRoleMapper;
    @Reference(version = "0.0.1", check = false, mock = "true", protocol = "dubbo")
    private UmsUserInfoService umsUserInfoService;

    @Override
    public List<UmsUserInfo> selectUserListByRid(Integer rid) {
        List<UmsUserInfo> umsUserInfos = umsUserRoleMapper.selectUserListByRid(rid);
        if (CollectionUtils.isEmpty(umsUserInfos)) {
            return Lists.newArrayList();
        }
        if (CollectionUtils.isNotEmpty(umsUserInfos)) {
            List<UmsUserInfo> collect = umsUserInfos.stream().
                    filter(u -> u.getStatus().equals(Byte.parseByte("0"))).
                    collect(Collectors.toList());
            if (CollectionUtils.isEmpty(collect)) {
                return Lists.newArrayList();
            }
        }
        return umsUserInfos;
    }

    @Override
    public UmsUserRoleAo changeRoleUsers(UmsUserRoleVo umsUserRoleVo) {
        UmsUserRoleAo umsUserRoleAo = new UmsUserRoleAo();
        UmsRole umsRole = umsRoleMapper.selectByPrimaryKey(umsUserRoleVo.getRid());
        List<UmsUserInfo> umsUserInfos = umsUserInfoService.selectListByIds(umsUserRoleVo.getUids());
        // 判断数据是否合法
        if (umsRole == null || umsRole.getStatus().equals(Byte.parseByte("1"))) {
            umsUserRoleAo.setCheckCode(1);
            return umsUserRoleAo;
        }
        umsUserRoleAo.setUmsRole(umsRole);
        if (CollectionUtils.isNotEmpty(umsUserInfos)) {
            List<UmsUserInfo> collect = umsUserInfos.stream().
                    filter(u -> u.getStatus().equals(Byte.parseByte("0"))).
                    collect(Collectors.toList());
            umsUserRoleAo.setUmsUserInfos(collect);
        }
        // 判断是否是原用户集合
        List<Integer> originalUids = umsUserRoleMapper.selectUidsByRid(umsUserRoleVo.getRid());
        if (CollectionUtils.isNotEmpty(originalUids) && originalUids.containsAll(umsUserRoleVo.getUids())) {
            return umsUserRoleAo;
        }
        // 更新用户集合
        updateRoleUsers(umsUserRoleVo.getRid(), umsUserRoleVo.getUids());
        return umsUserRoleAo;
    }

    private void updateRoleUsers(Integer rid, List<Integer> uids) {
        // 删除之前的记录
        umsUserRoleMapper.delete(UmsUserRole.builder().rid(rid).build());
        if (CollectionUtils.isEmpty(uids)) {
            return ;
        }
        List<UmsUserRole> umsUserRoles = Lists.newArrayList();
        uids.forEach(u -> {
            umsUserRoles.add(UmsUserRole.builder().
                    uid(u).
                    rid(rid).
                    operateIp("0.0.0.0").
                    operateTime(new Date()).
                    operator("李四").
                    build()
            );
        });
        umsUserRoleMapper.insertBatch(umsUserRoles);
    }
}
