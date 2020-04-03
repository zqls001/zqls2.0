package com.duanxin.zqls.umps.api;

import com.duanxin.zqls.umps.ao.UmsAclRoleAo;
import com.duanxin.zqls.umps.model.UmsAcl;

import java.util.List;

/**
 * 权限角色Service层接口
 * @author duanxin
 * @version 1.0
 * @date 2020/1/26 8:41
 */
public interface UmsAclRoleService {

    /**
     * 根据角色主键查询权限信息集合
     * @param rid 角色主键id
     * @date 2020/1/28 8:53
     * @return java.util.List<com.duanxin.zqls.umps.dto.UmsAclDto>
     **/
    List<UmsAcl> selectRoleAcls(Integer rid);

    /**
     * 更改角色权限集合
     * @param rid 角色主键id
     * @param aids 权限id集合
     * @date 2020/1/30 8:51
     * @return com.duanxin.zqls.umps.dto.UmsAclRoleDto
     **/
    UmsAclRoleAo changeRoleAcl(Integer rid, List<Integer> aids);

    /**
     * 根据角色id集合查询权限id集合
     * @param rids 角色id集合
     * @date 2020/3/6 17:58
     * @return java.util.List<java.lang.Integer>
     **/
    List<Integer> selectAidsByRids(List<Integer> rids);
}
