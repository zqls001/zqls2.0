package com.duanxin.zqls.ucenter.utils;
import	java.text.SimpleDateFormat;
import java.util.Date;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dysmsapi.model.v20170525.QuerySendDetailsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.QuerySendDetailsResponse;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 短信服务工具类
 * @author duanxin
 * @version 1.0
 * @date 2019/10/17 10:14
 */
@Component
public class SmsUtil {

    /**
     * 产品名称：云通信短信API产品
     * */
    private static final String PRODUCT = "Dysmsapi";
    /**
     * 产品域名
     * */
    private static final String DOMAIN = "dysmsapi.aliyuncs.com";

    @Resource
    private Environment env;

    /**
     * 发送验证信息
     * @param phone 手机号
     * @param templateCode 模版号
     * @param signName 签名
     * @param param 参数
     * @date 2019/10/17 10:21
     * @return com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse
     **/
    public SendSmsResponse sendSms(String phone, String templateCode,
                                   String signName, String param) throws ClientException {
        // 获取AccessKey ID和Access Key Secret
        String accessKeyId = env.getProperty("aliyun.sms.accessKeyId");
        String accessKeySecret = env.getProperty("aliyun.sms.accessKeySecret");
        // 设置超时时间
        System.setProperty("sun.net.client.defaultConnectTimeout", "10000");
        System.setProperty("sun.net.client.defaultReadTimeout", "10000");
        // 初始化acsClient
        IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", accessKeyId, accessKeySecret);
        DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", PRODUCT, DOMAIN);
        IAcsClient acsClient = new DefaultAcsClient(profile);
        // 组装请求对象-具体描述见控制台-文档部分内容
        SendSmsRequest request = new SendSmsRequest();
        // 设置待发送手机号
        request.setPhoneNumbers(phone);
        // 设置短信签名
        request.setSignName(signName);
        // 设置短信模版
        request.setTemplateCode(templateCode);
        // 设置模版上的参数
        request.setTemplateParam(param);
        // 返回响应
        SendSmsResponse acsResponse = acsClient.getAcsResponse(request);
        return acsResponse;
    }

    /**
     * 短信发送查询
     * @param phone 手机号
     * @param bizId 短信发送过程中返回的流水号
     * @date 2019/10/17 10:45
     * @return com.aliyuncs.dysmsapi.model.v20170525.QuerySendDetailsResponse
     **/
    public QuerySendDetailsResponse querySendDetails(String phone, String bizId) throws ClientException {
        // 获取AccessKey ID和Access Key Secret
        String accessKeyId = env.getProperty("aliyun.sms.accessKeyId");
        String accessKeySecret = env.getProperty("aliyun.sms.accessKeySecret");
        // 设置超时时间
        System.setProperty("sun.net.client.defaultReadTimeout", "10000");
        System.setProperty("sun.net.client.defaultConnectTimeout", "10000");
        // 初始化IAcsClient
        IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", accessKeyId, accessKeySecret);
        DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", PRODUCT, DOMAIN);
        IAcsClient acsClient = new DefaultAcsClient(profile);
        // 组装请求对象
        QuerySendDetailsRequest request = new QuerySendDetailsRequest();
        // 设置查询号码
        request.setPhoneNumber(phone);
        // 设置流水号
        request.setBizId(bizId);
        // 设置发送日期，格式yyyyMMdd
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        request.setSendDate(dateFormat.format(new Date()));
        // 设置页大小
        request.setPageSize(10L);
        // 设置当前页从1开始计算
        request.setCurrentPage(1L);
        // 接收返回响应
        QuerySendDetailsResponse acsResponse = acsClient.getAcsResponse(request);
        return acsResponse;
    }
}
