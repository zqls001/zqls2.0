package com.duanxin.zqls.common.util;

import lombok.extern.slf4j.Slf4j;

import java.util.Random;

/**
 * 生产随机数字字符串
 * @author duanxin
 * @version 1.0
 * @date 2019/10/17 9:55
 */
@Slf4j
public class RandomStringUtils {

    private static final Random RANDOM = new Random();

    /**
     * 返回随机数字字符串
     * @param len 字符串长度
     * @date 2019/10/17 9:56
     * @return java.lang.String
     **/
    public static String randomNumeric(int len) {

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; ++i) {
            sb.append(RANDOM.nextInt(10));
        }
        return sb.toString();
    }

    /**
     * 进行测试
     * */
    public static void main(String[] args) {
        log.info(">>>>>字符串：{}<<<<<<", randomNumeric(4));
    }
}
