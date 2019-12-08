package com.duanxin.zqls.fms.api;

import com.duanxin.zqls.fms.ao.FmsUserLikeAo;
import com.duanxin.zqls.fms.model.FmsUserLike;

/**
 * 用户喜好设置降级服务
 * @author duanxin
 * @version 1.0
 * @date 2019/12/7 11:19
 */
public class FmsUserLikeServiceMock implements FmsUserLikeService{
    @Override
    public int saveUserLike(FmsUserLike fmsUserLike) {
        return 0;
    }

    @Override
    public FmsUserLikeAo getUserLikeByUid(Integer id) {
        return null;
    }

    @Override
    public FmsUserLikeAo updateUserLike(FmsUserLike fmsUserLike) {
        return null;
    }

    @Override
    public int deleteByJobNumber(String jobNumber) {
        return 0;
    }
}
