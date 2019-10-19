package com.duanxin.zqls.ucenter.service;

import com.duanxin.zqls.exception.CheckException;
import com.duanxin.zqls.ucenter.api.UmsUserInfoService;
import com.duanxin.zqls.ucenter.mapper.UmsUserInfoMapper;
import com.duanxin.zqls.ucenter.model.UmsUserInfo;
import com.duanxin.zqls.util.RandomStringUtils;
import org.apache.commons.collections.CollectionUtils;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @author duanxin
 * @version 1.0
 * @date 2019/10/14 15:42
 */
@Service(version = "0.0.1")
public class UmsUserInfoServiceImpl implements UmsUserInfoService {

    @Resource
    private UmsUserInfoMapper umsUserInfoMapper;
    @Resource
    private RedisTemplate redisTemplate;
    @Resource
    private RabbitTemplate rabbitTemplate;

    @Override
    public UmsUserInfo selectByPrimaryKey(Integer id) {
        return umsUserInfoMapper.selectByPrimaryKey(id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteUserInfoByPrimaryKey(Integer id) {
        UmsUserInfo umsUserInfo = selectByPrimaryKey(id);
        if (null == umsUserInfo) {
            throw new CheckException("该用户不存在");
        }
        umsUserInfo.setStatus(Byte.parseByte("1"));
        umsUserInfoMapper.updateByPrimaryKeySelective(umsUserInfo);
    }

    @Override
    public UmsUserInfo selectByJobNumber(String jobNumber) {
        UmsUserInfo umsUserInfo = new UmsUserInfo();
        umsUserInfo.setJobNumber(jobNumber);
        List<UmsUserInfo> umsUserInfos = umsUserInfoMapper.select(umsUserInfo);
        if (CollectionUtils.isEmpty(umsUserInfos)) {
            return null;
        }
        return umsUserInfoMapper.select(umsUserInfo).get(0);
    }

    @Override
    public void sendSms(String phone) {
        // 生成随机6位验证码
        String checkCode = RandomStringUtils.randomNumeric(6);
        // 验证码存入缓存，为了绑定时校验验证码是否正确
        redisTemplate.opsForValue().set("checkCode::" + phone, checkCode, 5, TimeUnit.MINUTES);
        // 验证码放入消息队列
        Map<String, String> map = new HashMap<>();
        map.put("phone", phone);
        map.put("checkCode", checkCode);
        rabbitTemplate.convertAndSend("sms", map);
    }
}
