package com.duanxin.zqls.ucenter.api;


import com.duanxin.zqls.ucenter.ao.UmsUserInfoAo;
import com.duanxin.zqls.ucenter.model.UmsUserInfo;
import com.duanxin.zqls.ucenter.vo.UmsUserInfoVo;
import com.github.pagehelper.PageInfo;

import java.math.BigDecimal;
import java.util.List;

/**
 * 用户信息Service层接口
 * @author duanxin
 * @version 1.0
 * @date 2019/10/14 15:38
 */
public interface UmsUserInfoService {

    Integer selectAidByJobNumber(String jobNumber);

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
    int deleteUserInfoByPrimaryKey(Integer id);

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
    int sendSms(String phone);

    /**
     * 校验验证码并进行手机号绑定
     * @param jobNumber 学工号
     * @param phone 手机号
     * @param code 验证码
     * @date 2019/10/19 10:22
     * @return com.duanxin.zqls.ucenter.model.UmsUserInfo
     **/
    UmsUserInfoAo checkCode(String jobNumber, String phone, String code);

    /**
     * 发送邮件
     * @param to 接收者
     * @date 2019/10/22 16:45
     * @return int
     **/
    int sendMail(String to);

    /**
     * 校验邮箱验证码并进行绑定
     * @param jobNumber 学工号
     * @param mail 邮箱
     * @param code 验证码
     * @date 2019/10/26 10:02
     * @return com.duanxin.zqls.ucenter.model.UmsUserInfo
     **/
    UmsUserInfoAo checkMailCode(String jobNumber, String mail, String code);

    /**
     * 更新密码
     * @param jobNumber 学工号
     * @param password 更新后密码
     * @date 2019/10/28 9:20
     * @return com.duanxin.zqls.ucenter.ao.UmsUserInfoAo
     **/
    UmsUserInfoAo updatePassword(String jobNumber, String password);

    /**
     * 更新用户信息
     * @param umsUserInfo 用户更新数据
     * @date 2019/11/3 8:32
     * @return com.duanxin.zqls.ucenter.ao.UmsUserInfoAo
     **/
    UmsUserInfoAo updateUmsUserInfo(UmsUserInfo umsUserInfo);

    /**
     * 分页查询用户信息
     * @param currentPage 当前页
     * @param pageSize 页面大小
     * @date 2019/11/3 9:10
     * @return com.github.pagehelper.Page<com.duanxin.zqls.ucenter.model.UmsUserInfo>
     **/
    PageInfo<UmsUserInfo> selectAll(int currentPage, int pageSize);

    /**
     * 进行交易
     * @param uid 用户学工号
     * @param place 交易地点
     * @param pay 本次交易金额
     * @date 2019/12/5 10:38
     * @return com.duanxin.zqls.ucenter.vo.UmsUserInfoVo
     **/
    UmsUserInfoVo settleAccounts(String uid, String place, BigDecimal pay);

    /**
     * 根据id集合查询用户信息
     * @param uids 用户主键id集合
     * @date 2020/2/4 9:11
     * @return java.util.List<com.duanxin.zqls.ucenter.model.UmsUserInfo>
     **/
    List<UmsUserInfo> selectListByIds(List<Integer> uids);

    /**
     * 通过学工号和密码查询用户信息
     * @param jobNumber 学工号
     * @param password 加密后的密码
     * @date 2020/3/31 10:11
     * @return com.duanxin.zqls.ucenter.ao.UmsUserInfoAo
     **/
    UmsUserInfoAo selectInfoForLogin(String jobNumber, String password);
}
