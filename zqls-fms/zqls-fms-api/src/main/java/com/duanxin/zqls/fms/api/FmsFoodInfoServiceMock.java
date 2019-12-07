package com.duanxin.zqls.fms.api;

import com.duanxin.zqls.fms.dto.FoodInfoAndUserInfoDto;
import com.duanxin.zqls.fms.model.FmsFoodConsume;
import com.duanxin.zqls.fms.model.FmsFoodInfo;
import com.duanxin.zqls.fms.vo.FmsFoodInfoVo;
import com.github.pagehelper.PageInfo;

/**
 * food info service mock
 * @author duanxin
 * @version 1.0
 * @date 2019/11/16 9:56
 */
public class FmsFoodInfoServiceMock implements FmsFoodInfoService {
    @Override
    public FmsFoodInfoVo getHotFmsFoodInfos() {
        return null;
    }

    @Override
    public FmsFoodInfo getFoodInfoByPrimaryId(Integer id) {
        return null;
    }

    @Override
    public PageInfo<FmsFoodInfo> selectAll(Integer currentPage, Integer pageSize) {
        return null;
    }

    @Override
    public FoodInfoAndUserInfoDto selectFmsInfoAndUmsInfoById(Integer fid, String jobNumber) {
        return null;
    }

    @Override
    public com.duanxin.zqls.ucenter.vo.UmsUserInfoVo settleAccounts(FmsFoodConsume fmsFoodConsume) {
        return null;
    }
}
