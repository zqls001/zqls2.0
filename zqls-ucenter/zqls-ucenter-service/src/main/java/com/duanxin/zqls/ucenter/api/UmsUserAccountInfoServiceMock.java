package com.duanxin.zqls.ucenter.api;

import com.duanxin.zqls.ucenter.model.UmsUserAccountInfo;

import java.util.List;

/**
 * 用户账户Service层服务降级
 * @author duanxin
 * @version 1.0
 * @date 2019/10/22 9:00
 */
public class UmsUserAccountInfoServiceMock implements UmsUserAccountInfoService {
    @Override
    public List<UmsUserAccountInfo> selectByAid(String aid) {
        return null;
    }
}
