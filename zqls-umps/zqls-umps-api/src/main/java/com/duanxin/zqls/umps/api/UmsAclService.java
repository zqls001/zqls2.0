package com.duanxin.zqls.umps.api;

import com.duanxin.zqls.umps.ao.UmsAclAo;
import com.duanxin.zqls.umps.model.UmsAcl;
import com.duanxin.zqls.umps.vo.UmsAclVo;
import com.github.pagehelper.PageInfo;

/**
 * 权限Service层接口
 * @author duanxin
 * @version 1.0
 * @date 2020/1/16 9:23
 */
public interface UmsAclService {
    /**
     * 添加权限信息
     * @param umsAclVo 权限实体
     * @date 2020/1/18 15:20
     * @return int
     **/
    int saveUmsAcl(UmsAclVo umsAclVo);

    /**
     * 根据权限主键id查询权限信息
     * @param id 权限主键id
     * @date 2020/1/18 15:34
     * @return com.duanxin.zqls.umps.ao.UmsAclAo
     **/
    UmsAclAo selectUmsAclByPrimaryKey(Integer id);

    /**
     * 分页查询权限信息
     * @param currentPage 当前页数
     * @param pageSize 每页大小
     * @date 2020/1/20 9:04
     * @return com.github.pagehelper.PageInfo<com.duanxin.zqls.umps.ao.UmsAclAo>
     **/
    PageInfo<UmsAclAo> selectAll(Integer currentPage, Integer pageSize);

    /**
     * 根据权限主键删除权限
     * @param id 权限主键
     * @date 2020/1/20 9:14
     * @return int
     **/
    int deleteUmsAclByPrimaryKey(Integer id);

    /**
     * 更新权限信息
     * @param umsAcl 需更新的权限信息
     * @date 2020/1/20 9:25
     * @return com.duanxin.zqls.umps.ao.UmsAclAo
     **/
    UmsAclAo updateUmsAcl(UmsAcl umsAcl);
}
