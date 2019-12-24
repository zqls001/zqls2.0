package com.duanxin.zqls.ucenter.service;

import com.auth0.jwt.interfaces.Claim;
import com.duanxin.zqls.common.exception.ValidateException;
import com.duanxin.zqls.common.util.MD5Util;
import com.duanxin.zqls.service.util.JwtUtil;
import com.duanxin.zqls.ucenter.api.JwtService;
import com.duanxin.zqls.ucenter.api.UmsUserInfoService;
import com.duanxin.zqls.ucenter.model.UmsUserInfo;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * Jwt Service层实现
 * @author duanxin
 * @version 1.0
 * @date 2019/12/15 10:12
 */
@Service(version = "0.0.1", delay = -1)
@Slf4j
public class JwtServiceImpl implements JwtService {

    /**
     * jwt超时时间，单位ms
     * */
    private static int expireTime;

    @Resource
    private UmsUserInfoService umsUserInfoService;
    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Value("${jwt_expire_time}")
    public void setExpireTime(int expireTime) {
        JwtServiceImpl.expireTime = expireTime * 24 * 3600;
    }

    @Override
    public String login(String jobNumber, String password) {
        UmsUserInfo umsUserInfo = umsUserInfoService.selectByJobNumber(jobNumber);
        if (!umsUserInfo.getPassword().equals(MD5Util.md5(password))) {
            log.error("该用户{}密码错误", jobNumber);
            throw new ValidateException("密码错误");
        }
        Map<String, String> param = new HashMap<>();
        param.put("jobNumber", umsUserInfo.getJobNumber());
        param.put("userName", umsUserInfo.getUserName());
        return this.generateJwt(param);
    }

    /**
     * 获取token
     * @date 2019/12/15 14:23
     * @return java.lang.String
     **/
    private String generateJwt(Map<String, String> param) {
        String secret = UUID.randomUUID().toString().replaceAll("-", "");
        String token = JwtUtil.encode(secret, param, expireTime * 1000);
        // 存入redis中, 该种方式的token存值存在很大的不稳定性
        stringRedisTemplate.opsForValue().set(token, secret, expireTime, TimeUnit.SECONDS);
        return token;
    }

    @Override
    public String refreshJwt(String jwt) {
        String secret = stringRedisTemplate.opsForValue().get(jwt);
        Map<String, Claim> decode = JwtUtil.decode(jwt, secret);
        if (decode.get("exp").asLong() - System.currentTimeMillis() / 1000 < 3 * 60 * 60 * 24) {
            Map<String, String> map = new HashMap<>();
            map.put("jobNumber", decode.get("jobNumber").asString());
            map.put("userName", decode.get("userName").asString());
            return this.generateJwt(map);
        }
        return null;
    }

    @Override
    public boolean checkJwt(String jwt) {
        try {
            String secret = stringRedisTemplate.opsForValue().get(jwt);
            JwtUtil.decode(jwt, secret);
            return true;
        } catch (Exception e) {
            log.error("校验失败，{}", jwt);
            return false;
        }
    }

    @Override
    public int inValid(String jwt) {
        stringRedisTemplate.delete(jwt);
        return 1;
    }
}
