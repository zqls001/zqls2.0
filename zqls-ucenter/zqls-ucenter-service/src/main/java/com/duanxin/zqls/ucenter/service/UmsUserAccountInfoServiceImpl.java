package com.duanxin.zqls.ucenter.service;

import com.duanxin.zqls.ucenter.api.UmsUserAccountInfoService;
import com.duanxin.zqls.ucenter.mapper.UmsUserAccountConsumeMapper;
import com.duanxin.zqls.ucenter.mapper.UmsUserAccountInfoMapper;
import com.duanxin.zqls.ucenter.mapper.UmsUserInfoMapper;
import com.duanxin.zqls.ucenter.model.UmsUserAccountConsume;
import com.duanxin.zqls.ucenter.model.UmsUserAccountInfo;
import com.duanxin.zqls.ucenter.model.UmsUserInfo;
import com.duanxin.zqls.ucenter.vo.UmsUserInfoVo;
import org.apache.commons.collections.CollectionUtils;
import org.apache.dubbo.config.annotation.Service;
import org.assertj.core.util.Lists;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;

/**
 * 用户账户信息Service层实现
 * @author duanxin
 * @version 1.0
 * @date 2019/10/15 10:13
 */
@Service(version = "0.0.1")
public class UmsUserAccountInfoServiceImpl implements UmsUserAccountInfoService {

    @Resource
    private UmsUserAccountInfoMapper umsUserAccountInfoMapper;
    @Resource
    private UmsUserAccountConsumeMapper umsUserAccountConsumeMapper;
    @Resource
    private UmsUserInfoMapper umsUserInfoMapper;

    @Override
    public List<UmsUserAccountInfo> selectByAid(Integer aid) {

        Example example = new Example(UmsUserAccountInfo.class);
        example.createCriteria().andEqualTo("aid", aid);
        List<UmsUserAccountInfo> umsUserAccountInfos =
                umsUserAccountInfoMapper.selectByExample(example);
        if (CollectionUtils.isEmpty(umsUserAccountInfos)) {
            return null;
        }
        return umsUserAccountInfos;
    }

    @Override
    public UmsUserAccountInfo selectByJobNumber(String jobNumber) {
        return umsUserAccountInfoMapper.selectByJobNumber(jobNumber);
    }

    @Override
    public int insertUserAccountConsume(UmsUserAccountConsume umsUserAccountConsume) {
        return umsUserAccountConsumeMapper.insertSelective(umsUserAccountConsume);
    }

    @Override
    public UmsUserInfoVo deductionBalance(String uid, BigDecimal pay, Integer flowId) {
        UmsUserAccountInfo umsUserAccountInfo = selectByJobNumber(uid);
        BigDecimal subtract = umsUserAccountInfo.getBalance().subtract(pay);
        UmsUserAccountInfo build = UmsUserAccountInfo.builder().
                balance(subtract).
                type("0").
                aid(umsUserAccountInfo.getAid()).
                flowId(flowId).
                build();
        umsUserAccountInfoMapper.insertSelective(build);
        return UmsUserInfoVo.builder().
                umsUserInfo(umsUserInfoMapper.selectOne(UmsUserInfo.builder().jobNumber(uid).build())).
                umsUserAccountInfoList(Lists.list(selectByJobNumber(uid))).
                build();
    }
}
