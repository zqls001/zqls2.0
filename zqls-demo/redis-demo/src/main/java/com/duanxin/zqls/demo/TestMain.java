package com.duanxin.zqls.demo;


import com.auth0.jwt.interfaces.Claim;
import com.duanxin.zqls.service.util.JwtUtil;
import redis.clients.jedis.Jedis;

import java.util.Map;

/**
 * @author duanxin
 * @version 1.0
 * @date 2019/10/19 10:56
 */
public class TestMain {

    public static void main(String[] args) {
        Jedis jedis = new Jedis("39.106.154.120", 6379);
        String key = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE1Nzc3NjExMTcsInVzZXJOYW1lIjoi5qyh5LuB6K-65o6qIiwiam9iTnVtYmVyIjoiMTAyMDAwMDEifQ.cc52GFMW1HMNO6K6GUnjpPJZMlsMkhmaCVSKZvC_zG0";
        String value = jedis.get(key);
        Map<String, Claim> decode = JwtUtil.decode(key, value);
        Long exp = decode.get("exp").asLong();
        System.out.println(exp);
        System.out.println(decode.get("exp").asLong() - System.currentTimeMillis() / 1000);
    }
}
