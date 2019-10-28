package com.duanxin.zqls.ucenter.listenr;
import java.util.Date;
import java.util.Map;

import com.duanxin.zqls.mail.api.MailService;
import com.duanxin.zqls.ucenter.config.MQConfig;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * 发送邮件队列监听器
 * @author duanxin
 * @version 1.0
 * @date 2019/10/26 9:36
 */
@Component
@RabbitListener(queues = MQConfig.MAIL_QUEUE)
@PropertySource("classpath:application.yml")
@Slf4j
public class MailListener {

    @Reference(version = "0.0.1", protocol = "dubbo", mock = "true", check = false)
    private MailService mailService;

    @RabbitHandler
    public void executeMail(Map<String, String> map) {
        String to = map.get("to");
        String subject = map.get("subject");
        String content = map.get("content");

        try {
            mailService.send(to, subject, content);
            log.info(">>>>发送中，时间：{}<<<<", new Date());
        } catch (Exception e) {
            log.error(">>>>发送失败，时间:{}，接收者:{}，原因:{}<<<<",
                    new Date(), to, e.getMessage());
        }
    }

}
