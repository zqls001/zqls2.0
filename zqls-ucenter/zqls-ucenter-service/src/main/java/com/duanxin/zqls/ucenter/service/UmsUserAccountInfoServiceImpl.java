package com.duanxin.zqls.ucenter.service;

import com.duanxin.zqls.ucenter.api.UmsUserAccountInfoService;
import com.duanxin.zqls.ucenter.mapper.UmsUserAccountInfoMapper;
import com.duanxin.zqls.ucenter.model.UmsUserAccountInfo;
import org.apache.commons.collections.CollectionUtils;
import org.apache.dubbo.config.annotation.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.List;

/**
 * 用户账户信息Service层实现
 * @author duanxin
 * @version 1.0
 * @date 2019/10/15 10:13
 */
@Service
public class UmsUserAccountInfoServiceImpl implements UmsUserAccountInfoService {

    @Resource
    private UmsUserAccountInfoMapper umsUserAccountInfoMapper;

    @Override
    public List<UmsUserAccountInfo> selectByAid(String aid) {
        Example example = new Example(UmsUserAccountInfo.class);
        example.createCriteria().andEqualTo("aid", aid);
        List<UmsUserAccountInfo> umsUserAccountInfos =
                umsUserAccountInfoMapper.selectByExample(example);
        if (CollectionUtils.isEmpty(umsUserAccountInfos)) {
            return null;
        }
        return umsUserAccountInfos;
    }
}
