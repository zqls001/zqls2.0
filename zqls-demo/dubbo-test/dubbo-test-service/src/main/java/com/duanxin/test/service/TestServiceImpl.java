package com.duanxin.test.service;

import com.duanxin.test.api.TestService;
import com.duanxin.test.mapper.UmsUserAccountInfoMapper;
import com.duanxin.test.mapper.UmsUserInfoMapper;
import com.duanxin.test.model.UmsUserAccountInfo;
import com.duanxin.test.model.UmsUserInfo;
import org.apache.dubbo.config.annotation.Service;

import javax.annotation.Resource;

/**
 * @author duanxin
 * @version 1.0
 * @date 2019/11/24 9:54
 */
@Service
public class TestServiceImpl implements TestService {

    @Resource
    private UmsUserInfoMapper umsUserInfoMapper;
    @Resource
    private UmsUserAccountInfoMapper umsUserAccountInfoMapper;

    @Override
    public UmsUserInfo selectByPrimaryKey(Integer id) {
        return umsUserInfoMapper.selectByPrimaryKey(id);
    }

    @Override
    public UmsUserAccountInfo selectUserAccountInfoByPrimaryKey(Integer id) {
        return umsUserAccountInfoMapper.selectByPrimaryKey(id);
    }


}
