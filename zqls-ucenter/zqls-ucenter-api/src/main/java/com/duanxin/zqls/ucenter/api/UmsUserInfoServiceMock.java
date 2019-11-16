package com.duanxin.zqls.ucenter.api;

import com.duanxin.zqls.ucenter.ao.UmsUserInfoAo;
import com.duanxin.zqls.ucenter.model.UmsUserInfo;
import com.github.pagehelper.PageInfo;

/**
 * 用户信息Service层服务降级
 * @author duanxin
 * @version 1.0
 * @date 2019/10/22 8:57
 */
public class UmsUserInfoServiceMock implements UmsUserInfoService {

    @Override
    public UmsUserInfo selectByPrimaryKey(Integer id) {
        return null;
    }

    @Override
    public int deleteUserInfoByPrimaryKey(Integer id) {
        return -1;
    }

    @Override
    public UmsUserInfo selectByJobNumber(String jobNumber) {
        return null;
    }

    @Override
    public int sendSms(String phone) {
        return -1;
    }

    @Override
    public UmsUserInfoAo checkCode(String jobNumber, String phone, String code) {
        return null;
    }

    @Override
    public int sendMail(String to) {
        return -1;
    }

    @Override
    public UmsUserInfoAo checkMailCode(String jobNumber, String mail, String code) {
        return null;
    }

    @Override
    public UmsUserInfoAo updatePassword(String jobNumber, String password) {
        return null;
    }

    @Override
    public UmsUserInfoAo updateUmsUserInfo(UmsUserInfo umsUserInfo) {
        return null;
    }

    @Override
    public PageInfo<UmsUserInfo> selectAll(int currentPage, int pageSize) {
        return null;
    }
}
