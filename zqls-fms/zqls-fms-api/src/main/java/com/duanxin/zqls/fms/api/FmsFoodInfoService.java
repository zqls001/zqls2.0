package com.duanxin.zqls.fms.api;

import com.duanxin.zqls.fms.vo.FmsFoodInfoVo;

/**
 * 食物信息Service层接口
 * @author duanxin
 * @version 1.0
 * @date 2019/11/16 9:28
 */
public interface FmsFoodInfoService {

    /**
     * 查询最热食物，根据用户现在查询时间往前三天食物消耗量推算
     * @date 2019/11/16 10:55
     * @return com.duanxin.zqls.fms.vo.FmsFoodInfoVo
     **/
    FmsFoodInfoVo getHotFmsFoodInfos();
}
