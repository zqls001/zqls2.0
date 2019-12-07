package com.duanxin.zqls.fms.mapper;

import com.duanxin.zqls.fms.model.FmsFoodInfo;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface FmsFoodInfoMapper extends Mapper<FmsFoodInfo> {

    /**
     * 获取食物所在地集合
     * @date 2019/12/7 10:25
     * @return java.util.List<java.lang.String>
     **/
    List<String> getFoodPlace();
}