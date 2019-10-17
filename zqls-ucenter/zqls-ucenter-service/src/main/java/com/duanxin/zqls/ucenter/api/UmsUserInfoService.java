package com.duanxin.zqls.ucenter.api;

import com.duanxin.zqls.ucenter.model.UmsUserInfo;

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
    UmsUserInfo selectByPrimaryKey(Integer id);

    /**
     * 根据主键删除用户
     * @param id 主键
     * @date 2019/10/15 8:43
     **/
    void deleteUserInfoByPrimaryKey(Integer id);

    /**
     * 根据学工号获取记录
     * @param jobNumber 学工号
     * @date 2019/10/15 10:08
     * @return com.duanxin.zqls.ucenter.model.UmsUserInfo
     **/
    UmsUserInfo selectByJobNumber(String jobNumber);

    /**
     * 发送短信
     * @param phone 手机号码
     * @date 2019/10/17 9:36
     **/
    void sendSms(String phone);
}
