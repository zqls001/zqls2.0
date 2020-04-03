package com.duanxin.zqls.umps.api;

import com.duanxin.zqls.ucenter.model.UmsUserInfo;
import com.duanxin.zqls.umps.ao.UmsUserRoleAo;
import com.duanxin.zqls.umps.vo.UmsUserRoleVo;

import java.util.List;

/**
 * 用户角色Service层接口
 * @author duanxin
 * @version 1.0
 * @date 2020/2/2 9:26
 */
public interface UmsUserRoleService {
    /**
     * 根据角色主键id查询用户集合
     * @param rid 角色主键id
     * @date 2020/2/2 9:41
     * @return com.duanxin.zqls.umps.ao.UmsUserRoleAo
     **/
    List<UmsUserInfo> selectUserListByRid(Integer rid);

    /**
     * 更新用户权限
     * @param umsUserRoleVo 用户权限实体对象
     * @date 2020/2/4 8:30
     * @return com.duanxin.zqls.umps.ao.UmsUserRoleAo
     **/
    UmsUserRoleAo changeRoleUsers(UmsUserRoleVo umsUserRoleVo);

    /**
     * 根据用户主键获取用户角色id集合
     * @param uid 用户主键id
     * @date 2020/3/6 17:06
     * @return java.util.List<java.lang.Integer>
     **/
    List<Integer> selectRidsByUid(Integer uid);
}
