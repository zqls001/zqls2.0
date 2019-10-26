package com.duanxin.zqls.ucenter.service;

import com.duanxin.zqls.exception.CheckException;
import com.duanxin.zqls.mail.api.MailService;
import com.duanxin.zqls.ucenter.ao.UmsUserInfoAo;
import com.duanxin.zqls.ucenter.api.UmsUserInfoService;
import com.duanxin.zqls.ucenter.config.MQConfig;
import com.duanxin.zqls.ucenter.mapper.UmsUserInfoMapper;
import com.duanxin.zqls.ucenter.model.UmsUserInfo;
import com.duanxin.zqls.util.RandomStringUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.Reference;
import org.apache.dubbo.config.annotation.Service;
import org.redisson.misc.Hash;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
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
@Slf4j
public class UmsUserInfoServiceImpl implements UmsUserInfoService {

    @Resource
    private UmsUserInfoMapper umsUserInfoMapper;
    @Resource
    private RabbitTemplate rabbitTemplate;
    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public UmsUserInfo selectByPrimaryKey(Integer id) {
        return umsUserInfoMapper.selectByPrimaryKey(id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int deleteUserInfoByPrimaryKey(Integer id) {
        UmsUserInfo umsUserInfo = selectByPrimaryKey(id);
        if (null == umsUserInfo) {
            throw new CheckException("该用户不存在");
        }
        umsUserInfo.setStatus(Byte.parseByte("1"));
        umsUserInfo.setOperateTime(new Date());
        return umsUserInfoMapper.updateByPrimaryKeySelective(umsUserInfo);
    }

    @Override
    public UmsUserInfo selectByJobNumber(String jobNumber) {
        UmsUserInfo umsUserInfo = new UmsUserInfo();
        umsUserInfo.setJobNumber(jobNumber);
        List<UmsUserInfo> umsUserInfos = umsUserInfoMapper.select(umsUserInfo);
        if (CollectionUtils.isEmpty(umsUserInfos)) {
            return null;
        }
        return umsUserInfos.get(0);
    }

    @Override
    public int sendSms(String phone) {
        // 生成随机6位验证码
        String checkCode = RandomStringUtils.randomNumeric(6);
        // 验证码存入缓存，为了绑定时校验验证码是否正确
        stringRedisTemplate.opsForValue().set("checkSmsCode::" + phone,
                checkCode, 5, TimeUnit.MINUTES);
        // 验证码放入消息队列
        Map<String, String> map = new HashMap<>();
        map.put("phone", phone);
        map.put("checkCode", checkCode);
        rabbitTemplate.convertAndSend(MQConfig.SMS_QUEUE, map);
        return 1;
    }

    /**
     * todo: 无法发送成功，消息队列无法监听到，密码无法加密
     * */
    @Override
    public int sendMail(String to) {
        // 生成6位随机验证码
        String checkCode = RandomStringUtils.randomNumeric(6);
        // 存入缓存，便于验证
        stringRedisTemplate.opsForValue().set("checkMailCode::" + to, checkCode,
                10, TimeUnit.MINUTES);
        String subject = "主题：验证码校验";
        String content = "亲爱的智取乐食用户：" + to
                + ",您好，您的邮箱验证码为：" + checkCode
                +",请在客户端中填写，完成验证，有效期为10分钟";
        Map<String, String> map = new HashMap<>();
        map.put("to", to);
        map.put("subject", subject);
        map.put("content", content);
        rabbitTemplate.convertAndSend(map);
        return 1;
    }

    @Override
    public UmsUserInfoAo checkMailCode(String jobNumber, String mail, String code) {
        UmsUserInfo umsUserInfo = selectByJobNumber(jobNumber);
        UmsUserInfoAo umsUserInfoAo = new UmsUserInfoAo();
        umsUserInfoAo.setUmsUserInfo(umsUserInfo);
        // 进行验证码校验
        String rCode = stringRedisTemplate.opsForValue().get("checkMailCode::" + mail);
        if (!StringUtils.equals(code, rCode)) {
            umsUserInfoAo.setCheckCode(0);
            return umsUserInfoAo;
        }
        umsUserInfoAo.setCheckCode(1);
        // 进行邮箱绑定
        umsUserInfo.setEmail(mail);
        umsUserInfo.setOperateTime(new Date());
        umsUserInfoMapper.updateByPrimaryKeySelective(umsUserInfo);
        return umsUserInfoAo;
    }

    @Override
    public UmsUserInfoAo checkCode(String jobNumber, String phone, String code) {

        UmsUserInfo umsUserInfo = selectByJobNumber(jobNumber);
        UmsUserInfoAo umsUserInfoAo = new UmsUserInfoAo();
        umsUserInfoAo.setUmsUserInfo(umsUserInfo);
        // 进行校验验证码
        String rCode = stringRedisTemplate.opsForValue().get("checkSmsCode::" + phone);
        if (!StringUtils.equals(code, rCode)) {
            umsUserInfoAo.setCheckCode(0);
            return umsUserInfoAo;
        }
        umsUserInfoAo.setCheckCode(1);
        // 进行绑定
        umsUserInfo.setPhone(phone);
        umsUserInfo.setOperateTime(new Date());
        umsUserInfoMapper.updateByPrimaryKeySelective(umsUserInfo);
        return umsUserInfoAo;
    }
}
