package com.duanxin.zqls.umps.api;

import com.duanxin.zqls.umps.ao.UmsRoleAo;
import com.duanxin.zqls.umps.model.UmsRole;
import com.duanxin.zqls.umps.vo.UmsRoleVo;
import com.github.pagehelper.PageInfo;

/**
 * 角色Service层Mock
 * @author duanxin
 * @version 1.0
 * @date 2020/1/10 8:03
 */
public class UmsRoleServiceMock implements UmsRoleService{
    @Override
    public int saveUmsRole(UmsRoleVo umsRoleVo) {
        return 0;
    }

    @Override
    public UmsRoleAo selectUmsRoleByPrimaryId(Integer id) {
        return null;
    }

    @Override
    public PageInfo<UmsRoleAo> selectAll(Integer currentPage, Integer pageSize) {
        return null;
    }

    @Override
    public int deleteUmsRoleByPrimaryKey(Integer id) {
        return 0;
    }

    @Override
    public UmsRoleAo updateUmsRole(UmsRole umsRole) {
        return null;
    }
}
