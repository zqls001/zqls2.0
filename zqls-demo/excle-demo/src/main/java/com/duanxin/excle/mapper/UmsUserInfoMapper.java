package com.duanxin.excle.mapper;


import com.duanxin.excle.model.UmsUserInfo;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface UmsUserInfoMapper extends Mapper<UmsUserInfo> {
    List selectWithId();

//    int insert(@Param("list") List<UmsUserInfo> list);

//    int insertSelective(@Param("user") UmsUserInfo record);
}