package com.duanxin.zqls.fms.service;

import com.duanxin.zqls.common.util.DateTimeUtil;
import com.duanxin.zqls.fms.api.FmsFoodInfoService;
import com.duanxin.zqls.fms.dto.FoodInfoAndUserInfoDto;
import com.duanxin.zqls.fms.mapper.FmsFoodConsumeMapper;
import com.duanxin.zqls.fms.mapper.FmsFoodInfoMapper;
import com.duanxin.zqls.fms.model.FmsFoodConsume;
import com.duanxin.zqls.fms.model.FmsFoodInfo;
import com.duanxin.zqls.fms.vo.FmsFoodInfoVo;
import com.duanxin.zqls.ucenter.api.UmsUserAccountInfoService;
import com.duanxin.zqls.ucenter.model.UmsUserAccountInfo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.dubbo.config.annotation.Reference;
import org.apache.dubbo.config.annotation.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 食物信息Service层实现
 * @author duanxin
 * @version 1.0
 * @date 2019/11/16 9:29
 */
@Service(version = "0.0.1", delay = -1)
public class FmsFoodInfoServiceImpl implements FmsFoodInfoService {

    @Resource
    private FmsFoodConsumeMapper fmsFoodConsumeMapper;
    @Resource
    private FmsFoodInfoMapper fmsFoodInfoMapper;
    @Reference
    private UmsUserAccountInfoService umsUserAccountInfoService;

    @Override
    public FmsFoodInfoVo getHotFmsFoodInfos() {
        // get now and last datetime
        LocalDateTime now = DateTimeUtil.getCurrentLocalDateTime();
        LocalDateTime lastThreeDays = DateTimeUtil.minusDays(now, 3);
        // get hot food id
        List<FmsFoodConsume> fmsFoodConsumes =
                fmsFoodConsumeMapper.getHotFmsFoodInfos(now, lastThreeDays);
        // get hot food info
        List<FmsFoodInfo> fmsFoodInfos = new ArrayList<>();
        fmsFoodConsumes.forEach(f ->
                fmsFoodInfos.add(fmsFoodInfoMapper.selectByPrimaryKey(f.getFid())));
        // return data
        FmsFoodInfoVo fmsFoodInfoVo = new FmsFoodInfoVo();
        fmsFoodInfoVo.setFmsFoodInfos(fmsFoodInfos.stream().
                filter(f -> f.getStatus().equals(new Byte(0 + ""))).
                collect(Collectors.toList()));
        return fmsFoodInfoVo;
    }

    @Override
    public FmsFoodInfo getFoodInfoByPrimaryId(Integer id) {
        return fmsFoodInfoMapper.selectByPrimaryKey(id);
    }

    @Override
    public PageInfo<FmsFoodInfo> selectAll(Integer currentPage, Integer pageSize) {
        PageHelper.startPage(currentPage, pageSize);
        List<FmsFoodInfo> fmsFoodInfos = fmsFoodInfoMapper.selectAll();
        return new PageInfo<>(fmsFoodInfos.stream().
                filter(f -> f.getStatus().equals(new Byte(0 + ""))).
                collect(Collectors.toList()));
    }

    @Override
    public FoodInfoAndUserInfoDto selectFmsInfoAndUmsInfoById(Integer fid, String jobNumber) {

        // select fmsFoodInfo
        FmsFoodInfo fmsFoodInfo = fmsFoodInfoMapper.selectByPrimaryKey(fid);
        // select umsUserAccountInfo
        UmsUserAccountInfo umsUserAccountInfo =
                umsUserAccountInfoService.selectByJobNumber(jobNumber);
        // data encapsulation
        FoodInfoAndUserInfoDto foodInfoAndUserInfoDto =
                FoodInfoAndUserInfoDto.builder().
                        fmsFoodInfo(fmsFoodInfo).
                        umsUserAccountInfo(umsUserAccountInfo).
                        build();
        return foodInfoAndUserInfoDto;
    }
}
