package com.duanxin.zqls.umps.service;

import com.duanxin.zqls.umps.api.UmsAclRoleService;
import com.duanxin.zqls.umps.dto.UmsAclDto;
import com.duanxin.zqls.umps.mapper.UmsAclRoleMapper;
import com.duanxin.zqls.umps.model.UmsAcl;
import com.google.common.collect.Lists;
import org.apache.dubbo.common.utils.CollectionUtils;
import org.apache.dubbo.config.annotation.Service;

import javax.annotation.Resource;
import java.util.List;

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
}
