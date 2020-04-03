package com.duanxin.zqls.fms.service;

import com.duanxin.zqls.common.util.Builder;
import com.duanxin.zqls.fms.ao.FmsUserLikeAo;
import com.duanxin.zqls.fms.api.FmsUserLikeService;
import com.duanxin.zqls.fms.mapper.FmsUserLikeMapper;
import com.duanxin.zqls.fms.model.FmsUserLike;
import com.duanxin.zqls.ucenter.api.UmsUserInfoService;
import com.duanxin.zqls.ucenter.model.UmsUserInfo;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.Reference;
import org.apache.dubbo.config.annotation.Service;

import javax.annotation.Resource;
import java.util.Date;

/**
 * 用户喜好设置Service层实现
 * @author duanxin
 * @version 1.0
 * @date 2019/12/7 11:21
 */
@Service(version = "0.0.1", delay = -1)
public class FmsUserLikeServiceImpl implements FmsUserLikeService {

    @Resource
    private FmsUserLikeMapper fmsUserLikeMapper;
    @Reference(version = "0.0.1", check = false, mock = "true", protocol = "dubbo")
    private UmsUserInfoService umsUserInfoService;

    @Override
    public int saveUserLike(FmsUserLike fmsUserLike) {
        return fmsUserLikeMapper.insertSelective(fmsUserLike);
    }

    @Override
    public FmsUserLikeAo getUserLikeByUid(Integer id) {
        UmsUserInfo umsUserInfo = umsUserInfoService.selectByPrimaryKey(id);
        FmsUserLike fmsUserLike1 = new FmsUserLike();
        fmsUserLike1.setUid(id);
        FmsUserLike fmsUserLike = fmsUserLikeMapper.selectOne(fmsUserLike1);
        FmsUserLikeAo fmsUserLikeAo = new FmsUserLikeAo();
        if (null == umsUserInfo || StringUtils.equals(umsUserInfo.getStatus() + "", String.valueOf(1))) {
            fmsUserLikeAo.setCheck(1);
        }
        fmsUserLikeAo.setFmsUserLike(fmsUserLike);
        fmsUserLikeAo.setCheck(0);
        return fmsUserLikeAo;
    }

    @Override
    public FmsUserLikeAo updateUserLike(FmsUserLike fmsUserLike) {
        UmsUserInfo umsUserInfo = umsUserInfoService.selectByPrimaryKey(fmsUserLike.getUid());
        FmsUserLikeAo fmsUserLikeAo = new FmsUserLikeAo();
        if (null == umsUserInfo || StringUtils.equals(umsUserInfo.getStatus() + "", String.valueOf(1))) {
            fmsUserLikeAo.setCheck(1);
        }
        fmsUserLike.setRenewTime(new Date());
        fmsUserLikeMapper.updateByPrimaryKeySelective(fmsUserLike);
        fmsUserLikeAo.setCheck(0);
        fmsUserLikeAo.setFmsUserLike(fmsUserLike);
        return fmsUserLikeAo;
    }

    @Override
    public int deleteByJobNumber(String jobNumber) {
        UmsUserInfo umsUserInfo = umsUserInfoService.selectByJobNumber(jobNumber);
        return fmsUserLikeMapper.delete(
                Builder.of(FmsUserLike::new).
                        with(FmsUserLike::setUid, umsUserInfo.getId()).
                        build()
        );
    }
}
