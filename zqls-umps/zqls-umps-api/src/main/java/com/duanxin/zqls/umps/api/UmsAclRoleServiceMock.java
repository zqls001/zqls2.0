package com.duanxin.zqls.umps.api;

import com.duanxin.zqls.umps.ao.UmsAclRoleAo;
import com.duanxin.zqls.umps.dto.UmsAclDto;

import java.util.List;

/**
 * 权限角色服务降级接口
 * @author duanxin
 * @version 1.0
 * @date 2020/1/26 8:42
 */
public class UmsAclRoleServiceMock implements UmsAclRoleService {
    @Override
    public List<UmsAclDto> selectRoleAcls(Integer rid) {
        return null;
    }

    @Override
    public UmsAclRoleAo changeRoleAcl(Integer rid, List<Integer> aids) {
        return null;
    }
}
