package com.duanxin.zqls.umps.api;

import com.duanxin.zqls.umps.ao.UmsAclAo;
import com.duanxin.zqls.umps.model.UmsAcl;
import com.duanxin.zqls.umps.vo.UmsAclVo;
import com.github.pagehelper.PageInfo;

/**
 * 权限Service层服务降级
 * @author duanxin
 * @version 1.0
 * @date 2020/1/16 9:23
 */
public class UmsAclServiceMock implements UmsAclService {
    @Override
    public int saveUmsAcl(UmsAclVo umsAclVo) {
        return 0;
    }

    @Override
    public UmsAclAo selectUmsAclByPrimaryKey(Integer id) {
        return null;
    }

    @Override
    public PageInfo<UmsAclAo> selectAll(Integer currentPage, Integer pageSize) {
        return null;
    }

    @Override
    public int deleteUmsAclByPrimaryKey(Integer id) {
        return 0;
    }

    @Override
    public UmsAclAo updateUmsAcl(UmsAcl umsAcl) {
        return null;
    }
}
