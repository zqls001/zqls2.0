package com.duanxin.zqls.ucenter.service;

import com.duanxin.zqls.common.exception.CheckException;
import com.duanxin.zqls.common.util.GsonUtil;
import com.duanxin.zqls.common.util.MD5Util;
import com.duanxin.zqls.common.util.RandomStringUtils;
import com.duanxin.zqls.ucenter.ao.UmsUserInfoAo;
import com.duanxin.zqls.ucenter.api.UmsUserAccountInfoService;
import com.duanxin.zqls.ucenter.api.UmsUserInfoService;
import com.duanxin.zqls.ucenter.config.MQConfig;
import com.duanxin.zqls.ucenter.mapper.UmsUserInfoMapper;
import com.duanxin.zqls.ucenter.model.UmsUserAccountConsume;
import com.duanxin.zqls.ucenter.model.UmsUserInfo;
import com.duanxin.zqls.ucenter.vo.UmsUserInfoVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.Reference;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

import javax.annotation.Resource;
import java.math.BigDecimal;
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
    @Reference(version = "0.0.1", check = false, mock = "true", protocol = "dubbo")
    private UmsUserAccountInfoService umsUserAccountInfoService;


    @Override
    public Integer selectAidByJobNumber(String jobNumber) {
        return selectByJobNumber(jobNumber).getAid();
    }

    @Override
    public UmsUserInfo selectByPrimaryKey(Integer id) {
        return umsUserInfoMapper.selectByPrimaryKey(id);
    }

    @Override
    public int deleteUserInfoByPrimaryKey(Integer id) {
        UmsUserInfo umsUserInfo = selectByPrimaryKey(id);
        if (null == umsUserInfo) {
            throw new CheckException("该用户不存在");
        }
        umsUserInfo.setStatus(Byte.parseByte("1"));
        umsUserInfo.setOperateTime(new Date());
        UmsUserInfoAo umsUserInfoAo = updateUmsUserInfo(umsUserInfo);
        return 1;
    }

    @Override
    public UmsUserInfo selectByJobNumber(String jobNumber) {
        UmsUserInfo umsUserInfo = null;
        // 1,get data from redis cache
        String key = "userJobNumber:" + jobNumber + ":info";
        String value = stringRedisTemplate.opsForValue().get(key);
        // 2,data is null?
        if (null != value) {
            umsUserInfo = GsonUtil.jsonToBean(value, UmsUserInfo.class);
        } else {
            // 3,if data is null, get data from db, and then pull data into redis cache
            umsUserInfo =
                    umsUserInfoMapper.selectOne(UmsUserInfo.builder().jobNumber(jobNumber).build());
            value = GsonUtil.objectToString(umsUserInfo);
            stringRedisTemplate.opsForValue().set(key, value, RandomStringUtils.random(7), TimeUnit.DAYS);
        }
        return umsUserInfo;
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
     * todo: 发送成功，依然一次性发送三份邮件给用户
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
        rabbitTemplate.convertAndSend(MQConfig.MAIL_QUEUE, map);
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
    public UmsUserInfoAo updatePassword(String jobNumber, String password) {
        UmsUserInfoAo umsUserInfoAo = new UmsUserInfoAo();
        UmsUserInfo umsUserInfo = selectByJobNumber(jobNumber);
        if (null != umsUserInfo) {
            // 1,del redis cache
            String key = "userJobNumber:" + jobNumber + ":info";
            stringRedisTemplate.delete(key);
            // 2,update db
            umsUserInfo.setPassword(MD5Util.md5(password));
            umsUserInfo.setOperateTime(new Date());
            umsUserInfoMapper.updateByPrimaryKeySelective(umsUserInfo);
            // 3,sleep 500ms
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // 4,del redis cache
            stringRedisTemplate.delete(key);
        }
        umsUserInfoAo.setUmsUserInfo(umsUserInfo);
        return umsUserInfoAo;
    }

    @Override
    public UmsUserInfoAo updateUmsUserInfo(UmsUserInfo umsUserInfo) {
        UmsUserInfo umsUserInfo1 = selectByPrimaryKey(umsUserInfo.getId());
        UmsUserInfoAo umsUserInfoAo = new UmsUserInfoAo();
        // 用户不存在或状态码为1，更新失败
        if (null == umsUserInfo1) {
            umsUserInfoAo.setCheckCode(0);
            return umsUserInfoAo;
        }
        // 1,del redis cache
        String key = "userJobNumber:" + umsUserInfo1.getJobNumber() + ":info";
        stringRedisTemplate.delete(key);
        // 2,update db
        umsUserInfoAo.setCheckCode(1);
        umsUserInfo.setOperateTime(new Date());
        umsUserInfoMapper.updateByPrimaryKeySelective(umsUserInfo);
        umsUserInfoAo.setUmsUserInfo(selectByJobNumber(umsUserInfo1.getJobNumber()));
        // 3,sleep 500ms
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 4,del redis cache
        stringRedisTemplate.delete(key);
        return umsUserInfoAo;
    }

    @Override
    public PageInfo<UmsUserInfo> selectAll(int currentPage, int pageSize) {
        PageHelper.startPage(currentPage, pageSize);
        List<UmsUserInfo> umsUserInfoList = umsUserInfoMapper.selectAll();
        return new PageInfo<>(umsUserInfoList);
    }

    @Override
    public UmsUserInfoVo settleAccounts(String uid, String place, BigDecimal pay) {
        // 存储交易信息
        UmsUserAccountConsume umsUserAccountConsume =
                UmsUserAccountConsume.builder().place(place).price(pay).build();
        int id = umsUserAccountInfoService.insertUserAccountConsume(umsUserAccountConsume);
        // 账户余额扣减
        // 返回账户信息
        return umsUserAccountInfoService.deductionBalance(uid, pay, id);
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
