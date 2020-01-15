package com.duanxin.zqls.umps.api;

import com.duanxin.zqls.umps.ao.UmsRoleAo;
import com.duanxin.zqls.umps.model.UmsRole;
import com.github.pagehelper.PageInfo;

/**
 * 角色Service层接口
 * @author duanxin
 * @version 1.0
 * @date 2020/1/10 8:03
 */
public interface UmsRoleService {
    /**
     * 添加角色信息
     * @param umsRole 角色实体
     * @date 2020/1/10 8:04
     * @return int
     **/
    int saveUmsRole(UmsRole umsRole);

    /**
     * get role info by primary id
     * @param id role primary id
     * @date 2020/1/15 10:01
     * @return com.duanxin.zqls.umps.ao.UmsRoleAo
     **/
    UmsRoleAo selectUmsRoleByPrimaryId(Integer id);

    /**
     * get role info with page
     * @param currentPage current page num
     * @param pageSize page size
     * @date 2020/1/15 10:38
     * @return com.github.pagehelper.PageInfo<com.duanxin.zqls.umps.ao.UmsRoleAo>
     **/
    PageInfo<UmsRoleAo> selectAll(Integer currentPage, Integer pageSize);

    /**
     * delete role by primary key
     * @param id role primary key
     * @date 2020/1/15 10:38
     * @return int
     **/
    int deleteUmsRoleByPrimaryKey(Integer id);

    /**
     * update role info
     * @param umsRole updating role info
     * @date 2020/1/15 10:51
     * @return com.duanxin.zqls.umps.ao.UmsRoleAo
     **/
    UmsRoleAo updateUmsRole(UmsRole umsRole);
}
