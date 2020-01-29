package com.duanxin.zqls.umps.api;

import com.duanxin.zqls.umps.dto.UmsAclDto;

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
    List<UmsAclDto> selectRoleAcls(Integer rid);
}
