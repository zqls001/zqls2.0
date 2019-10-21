package com.duanxin.zqls.demo;


import lombok.extern.slf4j.Slf4j;
import redis.clients.jedis.Jedis;

/**
 * @author duanxin
 * @version 1.0
 * @date 2019/10/19 10:56
 */
public class TestMain {

    public static void main(String[] args) {
        Jedis jedis = new Jedis("39.106.154.120", 8887);
        System.out.println(jedis.get("checkCode::18870735026"));
    }
}
