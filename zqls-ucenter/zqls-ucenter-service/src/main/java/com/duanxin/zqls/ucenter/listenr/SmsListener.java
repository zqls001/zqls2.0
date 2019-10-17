package com.duanxin.zqls.ucenter.listenr;

import com.aliyuncs.exceptions.ClientException;
import com.duanxin.zqls.ucenter.utils.SmsUtil;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Map;

/**
 * 短信服务监听
 * @author duanxin
 * @version 1.0
 * @date 2019/10/17 10:55
 */
@Component
@RabbitListener(queues = "sms")
@PropertySource("classpath:application.yml")
public class SmsListener {

    @Resource
    private SmsUtil smsUtil;
    @Value("${aliyun.sms.template_code}")
    private String templateCode;
    @Value("${aliyun.sms.sign_name}")
    private String signName;

    @RabbitHandler
    public void executeSms(Map<String, String> map) {
        String phone = map.get("phone");
        String checkCode = map.get("checkCode");

        try {
            smsUtil.sendSms(phone, templateCode, signName, "{\"code\":\""+checkCode+"\"}");
        } catch (ClientException e) {
            e.printStackTrace();
        }
    }

}
