package com.duanxin.zqls.util;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

/**
 * AES加解密工具类
 * @author duanxin
 * @version 1.0
 * @date 2019/10/22 9:57
 */
public class AESUtil {

    private static final String ENCODE_RULES = "duanxin";

    /**
     * 加密
     * @param content 加密主体
     * @date 2019/10/22 9:58
     * @return java.lang.String
     **/
    public static String aesEncode(String content) {
        try {
            // 1，构造密钥生成器，指定AES算法，不区分大小写
            KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
            // 2，根据encodeRules规则初始化密钥生成器
            // 生成一个128位的随机码，根据传入的字节数组
            SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
            random.setSeed(ENCODE_RULES.getBytes());
            keyGenerator.init(128, random);
            // 3，产生原始对称密钥
            SecretKey originalKey = keyGenerator.generateKey();
            // 4，获取原始对称密钥的字节数组
            byte[] raw = originalKey.getEncoded();
            // 5，根据字节数组生产AES密钥
            SecretKeySpec key = new SecretKeySpec(raw, "AES");
            // 6，根据指定算法AES自成密码器
            Cipher cipher = Cipher.getInstance("AES");
            // 7，初始化密码器
            // 第一个参数为加密(Encrypt_mode)或者解密解密(Decrypt_mode)操作，第二个参数为使用的KEY
            cipher.init(Cipher.ENCRYPT_MODE, key);
            // 8，获取加密内容的字节数组，（这里要设置utf-8），不然中英混合密码加解密会出现乱码
            byte[] contentBytes = content.getBytes("utf-8");
            // 9，根据密码器的初始化方式，将密码加密
            byte[] betyAES = cipher.doFinal(contentBytes);
            // 10，将加密后的字节数组转化为字符串并返回
            String aesEncode = new String(new BASE64Encoder().encode(betyAES));
            return aesEncode;
        } catch (NoSuchAlgorithmException | NoSuchPaddingException |
                InvalidKeyException | UnsupportedEncodingException |
                IllegalBlockSizeException | BadPaddingException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 解密
     * @param content 解密主体
     * @date 2019/10/22 14:45
     * @return java.lang.String
     **/
    public static String aesDecode(String content) {
        try {
            // 1，构造密钥生成器，指定AES算法，不区分大小写
            KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
            // 2，根据encodeRules规则初始化密钥生成器
            // 生成一个128位的随机源，根据传入的字节数组
            SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");
            secureRandom.setSeed(ENCODE_RULES.getBytes());
            keyGenerator.init(128, secureRandom);
            // 3，产生原始对称密钥
            SecretKey originalKey = keyGenerator.generateKey();
            // 4，获取原始密钥的字节数组
            byte[] raw = originalKey.getEncoded();
            // 5，根据字节数组生成AES密钥
            SecretKey key = new SecretKeySpec(raw, "AES");
            // 6，根据指定算法AES自成密码器
            Cipher cipher = Cipher.getInstance("AES");
            // 7，初始化密码器
            // 第一个参数为加密(Encrypt_mode)或者解密解密(Decrypt_mode)操作，第二个参数为使用的KEY
            cipher.init(Cipher.DECRYPT_MODE, key);
            // 8，将加密并编码后的n内容解码成字节数组
            byte[] byteContent = new BASE64Decoder().decodeBuffer(content);
            // 9，解密
            byte[] byteDecode = cipher.doFinal(byteContent);
            String aesDecode = new String(byteDecode, "utf-8");
            return aesDecode;
        } catch (NoSuchAlgorithmException | NoSuchPaddingException |
                InvalidKeyException | IOException |
                IllegalBlockSizeException | BadPaddingException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 进行测试，测试成功
     * */
    public static void main(String[] args) {
        String key = "";
        System.out.println(key);
        System.out.println("---------加密开始---------");
        String encode = aesEncode(key);
        System.out.println(encode);
        System.out.println("----------解密开始---------------");
        System.out.println(aesDecode(encode));
    }
}
