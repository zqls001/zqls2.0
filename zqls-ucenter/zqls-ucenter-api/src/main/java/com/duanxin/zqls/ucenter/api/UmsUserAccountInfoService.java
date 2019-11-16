package com.duanxin.zqls.ucenter.api;

import com.duanxin.zqls.ucenter.model.UmsUserAccountInfo;

import java.util.List;

/**
 * 用户账户信息Service层接口
 * @author duanxin
 * @version 1.0
 * @date 2019/10/15 10:12
 */
public interface UmsUserAccountInfoService {
    /**
     * 根据账户id获取账户信息
     * @param aid 账户id
     * @date 2019/10/15 10:16
     * @return java.util.List<com.duanxin.zqls.ucenter.model.UmsUserAccountInfo>
     **/
    List<UmsUserAccountInfo> selectByAid(String aid);
}
