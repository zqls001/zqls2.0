package com.duanxin.zqls.fms.api;

import com.duanxin.zqls.fms.dto.FoodInfoAndUserInfoDto;
import com.duanxin.zqls.fms.model.FmsFoodConsume;
import com.duanxin.zqls.fms.model.FmsFoodInfo;
import com.duanxin.zqls.fms.vo.FmsFoodInfoVo;
import com.duanxin.zqls.ucenter.vo.UmsUserInfoVo;
import com.github.pagehelper.PageInfo;

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

    /**
     * 根据id主键查询记录
     * @param id 主键
     * @date 2019/11/23 8:26
     * @return com.duanxin.zqls.fms.model.FmsFoodInfo
     **/
    FmsFoodInfo getFoodInfoByPrimaryId(Integer id);

    /**
     * 分页查询食物信息
     * @param currentPage 当前页
     * @param pageSize 每页页数
     * @date 2019/11/23 9:46
     * @return com.github.pagehelper.PageInfo<com.duanxin.zqls.fms.model.FmsFoodInfo>
     **/
    PageInfo<FmsFoodInfo> selectAll(Integer currentPage, Integer pageSize);

    /**
     * 根据硬件系统传过来的食物id查询食物信息，学工号查询账户信息
     * @param fid 食物id
     * @param jobNumber 学工号
     * @date 2019/11/23 11:23
     * @return com.duanxin.zqls.fms.dto.FoodInfoAndUserInfoDto
     **/
    FoodInfoAndUserInfoDto selectFmsInfoAndUmsInfoById(Integer fid, String jobNumber);

    /**
     * 根据硬件端传来用户交易情况进行完成交易
     * @param fmsFoodConsume 食物消耗实体类
     * @date 2019/12/5 8:45
     * @return UmsUserInfoVo
     **/
    UmsUserInfoVo settleAccounts(FmsFoodConsume fmsFoodConsume);
}
