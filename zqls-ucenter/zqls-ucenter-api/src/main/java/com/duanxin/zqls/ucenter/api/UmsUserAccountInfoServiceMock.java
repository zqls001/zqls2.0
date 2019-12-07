package com.duanxin.zqls.ucenter.api;

import com.duanxin.zqls.ucenter.model.UmsUserAccountConsume;
import com.duanxin.zqls.ucenter.model.UmsUserAccountInfo;
import com.duanxin.zqls.ucenter.vo.UmsUserInfoVo;

import java.math.BigDecimal;
import java.util.List;

/**
 * 用户账户Service层服务降级
 * @author duanxin
 * @version 1.0
 * @date 2019/10/22 9:00
 */
public class UmsUserAccountInfoServiceMock implements UmsUserAccountInfoService {
    @Override
    public List<UmsUserAccountInfo> selectByAid(Integer aid) {
        return null;
    }

    @Override
    public UmsUserAccountInfo selectByJobNumber(String jobNumber) {
        return null;
    }

    @Override
    public int insertUserAccountConsume(UmsUserAccountConsume umsUserAccountConsume) {
        return 0;
    }

    @Override
    public UmsUserInfoVo deductionBalance(String uid, BigDecimal pay, Integer flowId) {
        return null;
    }
}
