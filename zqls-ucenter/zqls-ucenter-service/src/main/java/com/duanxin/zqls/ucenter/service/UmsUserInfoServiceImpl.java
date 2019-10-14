package com.duanxin.zqls.ucenter.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.duanxin.zqls.ucenter.api.UmsUserInfoService;
import com.duanxin.zqls.ucenter.mapper.UmsUserInfoMapper;
import com.duanxin.zqls.ucenter.model.UmsUserInfo;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author duanxin
 * @version 1.0
 * @date 2019/10/14 15:42
 */
@Service
public class UmsUserInfoServiceImpl implements UmsUserInfoService {

    @Resource
    private UmsUserInfoMapper umsUserInfoMapper;

    @Override
    public List<UmsUserInfo> selectByPrimaryKey(Integer id) {
        Example example = new Example(UmsUserInfo.class);
        example.createCriteria().andEqualTo(id);
        return umsUserInfoMapper.selectByExample(example);
    }
}
