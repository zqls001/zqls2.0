package com.duanxin.zqls.fms.service;

import com.duanxin.zqls.common.util.DateTimeUtil;
import com.duanxin.zqls.fms.api.FmsFoodInfoService;
import com.duanxin.zqls.fms.constants.TimeConstant;
import com.duanxin.zqls.fms.dto.FoodInfoAndUserInfoDto;
import com.duanxin.zqls.fms.mapper.FmsFoodConsumeMapper;
import com.duanxin.zqls.fms.mapper.FmsFoodInfoMapper;
import com.duanxin.zqls.fms.model.FmsFoodConsume;
import com.duanxin.zqls.fms.model.FmsFoodInfo;
import com.duanxin.zqls.fms.vo.FmsFoodInfoVo;
import com.duanxin.zqls.ucenter.api.UmsUserAccountInfoService;
import com.duanxin.zqls.ucenter.api.UmsUserInfoService;
import com.duanxin.zqls.ucenter.model.UmsUserAccountInfo;
import com.duanxin.zqls.ucenter.model.UmsUserInfo;
import com.duanxin.zqls.ucenter.vo.UmsUserInfoVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;
import org.apache.dubbo.config.annotation.Reference;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.data.redis.core.StringRedisTemplate;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.time.LocalTime;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
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
    @Resource
    private StringRedisTemplate stringRedisTemplate;
    @Reference(version = "0.0.1", mock = "true", check = false, protocol = "dubbo")
    private UmsUserAccountInfoService umsUserAccountInfoService;
    @Reference(version = "0.0.1", mock = "true", check = false, protocol = "dubbo")
    private UmsUserInfoService umsUserInfoService;

    @Override
    public FmsFoodInfoVo getHotFmsFoodInfos() {
        // set key
        List<String> foodPlaceList = fmsFoodInfoMapper.getFoodPlace();
        List<String> keys = Lists.newArrayList();
        foodPlaceList.forEach(f -> keys.add("hots::" + f));
        // get value from redis
        List<Set<String>> fids = Lists.newArrayList();
        keys.forEach(k -> fids.add(stringRedisTemplate.opsForZSet().range(k, 0, 5)));
        // get fms food info from database with fid
        List<List<FmsFoodInfo>> fmsFoodInfos = Lists.newArrayList();
        fids.stream().filter(zfid -> zfid.size() != 0).forEach(f -> {
            // Set<String> collection : 1, 2, 5, 6, 8
            List<FmsFoodInfo> list = Lists.newArrayList();
            f.forEach(fid -> {
                // fms food primary key
                // list add fmsFoodInfo
                list.add(fmsFoodInfoMapper.selectByPrimaryKey(fid));
            });
            // fmsFoodInfos add list
            fmsFoodInfos.add(list);
        });
        // return data
        return FmsFoodInfoVo.builder().fmsFoodInfos(fmsFoodInfos).build();
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
        // select umsUserInfo by jobNumber
        UmsUserInfo umsUserInfo = umsUserInfoService.selectByJobNumber(jobNumber);
        // data encapsulation
        FoodInfoAndUserInfoDto foodInfoAndUserInfoDto =
                FoodInfoAndUserInfoDto.builder().
                        fmsFoodInfo(fmsFoodInfo).
                        umsUserAccountInfo(umsUserAccountInfo).
                        umsUserInfo(umsUserInfo).
                        build();
        return foodInfoAndUserInfoDto;
    }

    @Override
    public UmsUserInfoVo settleAccounts(FmsFoodConsume fmsFoodConsume) {
        // 消费记录存入数据库中
        LocalTime nowTime = DateTimeUtil.getCurrentLocalTime();
        Byte dateType = TimeConstant.getDateType(nowTime);
        fmsFoodConsume.setType(dateType);
        fmsFoodConsumeMapper.insertSelective(fmsFoodConsume);
        // 存入缓存中
        // 格式（ZSet类型）：hots::foodPlace fid1 quantity1 fid2 quantity2 ... fid5 quantity5
        FmsFoodInfo fmsFoodInfo =
                fmsFoodInfoMapper.selectOne(FmsFoodInfo.builder().id(fmsFoodConsume.getFid()).build());
        String key = "hots::" + fmsFoodInfo.getPlace();
        Double score = fmsFoodConsume.getFoodQuality().doubleValue();
        Double nowScore = null;
        if (null == stringRedisTemplate.opsForZSet().size(key)) {
            // key不存在时，存值，设置过期时间
            stringRedisTemplate.opsForZSet().add(key, String.valueOf(fmsFoodConsume.getFid()), score);
            stringRedisTemplate.expire(key, 3, TimeUnit.DAYS);
        } else {
            Double lastScore = stringRedisTemplate.opsForZSet().score(key, fmsFoodConsume.getFid() + "");
            if (null == lastScore) {
                // value不存在，score就赋值新值
                nowScore = score;
            } else {
                // value存在，score就新值加上旧值
                nowScore = score + lastScore;
            }
            stringRedisTemplate.opsForZSet().add(key, String.valueOf(fmsFoodConsume.getFid()), nowScore);
        }
        // 进行交易
        BigDecimal pay = new BigDecimal(String.valueOf(fmsFoodInfo.getPrice())).
                multiply(fmsFoodConsume.getFoodQuality());
        UmsUserInfoVo umsUserInfoVo = umsUserInfoService.settleAccounts(fmsFoodConsume.getUid(), fmsFoodInfo.getPlace(), pay);
        // 返回账户信息
        return umsUserInfoVo;
    }
}
