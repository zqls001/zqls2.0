package com.duanxin.zqls.ucenter.api;

import com.duanxin.zqls.ucenter.model.UmsUserAccountConsume;
import com.duanxin.zqls.ucenter.model.UmsUserAccountInfo;
import com.duanxin.zqls.ucenter.vo.UmsUserInfoVo;

import java.math.BigDecimal;
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
    List<UmsUserAccountInfo> selectByAid(Integer aid);

    /**
     * 根据学工号查询用户账户信息
     * @param jobNumber 学工号
     * @date 2019/11/23 11:33
     * @return com.duanxin.zqls.ucenter.model.UmsUserAccountInfo
     **/
    UmsUserAccountInfo selectByJobNumber(String jobNumber);

    /**
     * 添加用户消费信息
     * @param umsUserAccountConsume 用户消费实体类
     * @date 2019/12/5 10:46
     * @return int
     **/
    int insertUserAccountConsume(UmsUserAccountConsume umsUserAccountConsume);

    /**
     * 用户账户余额扣减
     * @param uid 用户学工号
     * @param pay 消费金额
     * @param flowId 消费流水
     * @date 2019/12/5 10:58
     * @return com.duanxin.zqls.ucenter.vo.UmsUserInfoVo
     **/
    UmsUserInfoVo deductionBalance(String uid, BigDecimal pay, Integer flowId);
}
