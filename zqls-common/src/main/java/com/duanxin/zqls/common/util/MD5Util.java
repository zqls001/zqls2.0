package com.duanxin.zqls.common.util;

import lombok.extern.slf4j.Slf4j;

import java.security.MessageDigest;

/**
 * MD5加密方式
 * @author duanxin
 * @version 1.0
 * @date 2019/9/21 14:20
 */
@Slf4j
public class MD5Util {

    public final static String md5(String content) {

        // 用于加密的字符
        char[] md5String = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
        'A', 'B', 'C', 'D', 'E', 'F'};

        try {

            // 使用平台默认编码集将此String编码为byte序列，并将结果存储到一个新的byte数组中
            byte[] btInput = content.getBytes();

            // 信息摘要是安全的单向哈希函数，它接收任意大小的数据，并输出固定长度的哈希值。
            MessageDigest mdInst = MessageDigest.getInstance("MD5");

            // MessageDigest对象通过使用 update方法处理数据， 使用指定的byte数组更新摘要
            mdInst.update(btInput);

            // 摘要更新之后，通过调用digest（）执行哈希计算，获得密文
            byte[] md = mdInst.digest(btInput);

            // 把密文转换成十六进制的字符串形式
            int len = md.length;
            char[] str = new char[len * 2];
            int k = 0;
            for (byte byte0 : md) {
                str[k++] = md5String[byte0 >>> 4 & 0xf];
                str[k++] = md5String[byte0 & 0xf];
            }

            // 返回加密后的字符串
            return new String(str);
        } catch (Exception e) {
            return null;
        }
    }
}
