package com.duanxin.zqls.umps.api;

import com.duanxin.zqls.ucenter.model.UmsUserInfo;
import com.duanxin.zqls.umps.ao.UmsUserRoleAo;
import com.duanxin.zqls.umps.vo.UmsUserRoleVo;

import java.util.List;

/**
 * 用户角色服务降级接口
 * @author duanxin
 * @version 1.0
 * @date 2020/2/2 9:27
 */
public class UmsUserRoleServiceMock implements UmsUserRoleService {
    @Override
    public List<UmsUserInfo> selectUserListByRid(Integer rid) {
        return null;
    }

    @Override
    public UmsUserRoleAo changeRoleUsers(UmsUserRoleVo umsUserRoleVo) {
        return null;
    }
}
