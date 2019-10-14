package com.duanxin.zqls.ucenter.api;

import com.duanxin.zqls.ucenter.model.UmsUserInfo;

import java.util.List;

/**
 * 用户信息Service层接口
 * @author duanxin
 * @version 1.0
 * @date 2019/10/14 15:38
 */
public interface UmsUserInfoService {
    /**
     * 根据用户id获取记录
     * @param id 主键
     * @date 2019/10/14 15:50
     * @return com.duanxin.zqls.ucenter.model.UmsUserInfo
     **/
    List<UmsUserInfo> selectByPrimaryKey(Integer id);
}
