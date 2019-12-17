package com.duanxin.zqls.service.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.duanxin.zqls.common.exception.ValidateException;
import org.apache.commons.lang3.StringUtils;

import java.util.Date;
import java.util.Map;

/**
 * Jwt工具类
 * @author duanxin
 * @version 1.0
 * @date 2019/12/15 8:43
 */
public class JwtUtil {

    /**
     * 进行数据加密，返回token
     * @param secret 密钥，存在配置中
     * @param param 加密参数，
     *              组成：｛学工号：12345678，姓名：张三，key：加密验证value（存在Redis）｝
     * @param timeOut jwt过期时间
     * @date 2019/12/15 9:15
     * @return java.lang.String
     **/
    public static String encode(String secret, Map<String, String> param, long timeOut) {
        Algorithm algorithm = Algorithm.HMAC256(secret);
        JWTCreator.Builder builder = JWT.create().
                // 设置过期时间
                withExpiresAt(new Date(System.currentTimeMillis() + timeOut));
        // 设置负载
        param.forEach(builder::withClaim);
        String token = builder.sign(algorithm);
        return token;
    }

    /**
     * 解密token
     * @param token 需要验证的token
     * @param secret 密钥
     * @date 2019/12/15 9:25
     * @return java.util.Map<java.lang.String,com.auth0.jwt.interfaces.Claim>
     **/
    public static Map<String, Claim> decode(String token, String secret) {

        if (StringUtils.isBlank(token)) {
            throw new ValidateException("token为空：" + token);
        }
        Algorithm algorithm = Algorithm.HMAC256(secret);
        return JWT.require(algorithm).
                build().
                verify(token).
                getClaims();
    }
}
