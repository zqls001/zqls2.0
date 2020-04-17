package com.duanxin.zqls.mail.consumer;

import com.duanxin.zqls.mail.api.MailService;
import com.duanxin.zqls.ucenter.dto.MailDto;
import com.rabbitmq.client.Channel;
import org.apache.dubbo.config.annotation.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Map;

/**
 * 邮件接收
 * @author duanxin
 * @version 1.0
 * @date 2020/4/15 11:28
 */
@Component
public class MailReceiver {

    private Logger log = LoggerFactory.getLogger(MailReceiver.class);

    @Reference(version = "0.0.1", check = false, mock = "true", protocol = "dubbo")
    private MailService mailService;
    @RabbitHandler
    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = "mail-queue", declare = "true"),
            exchange = @Exchange(name = "mail-exchange", declare = "true", type = "topic"),
            key = "mail.#"
    ))
    public void onMailMessage(@Payload MailDto mailDto,
                              @Headers Map<String, Object> headers,
                              Channel channel) throws Exception {
        try {
            // 进行邮件发送
            mailService.send(mailDto.getmTo(), mailDto.getmSubject(), mailDto.getContent());
            log.info(">>>>发送中，时间：{}<<<<", new Date());
        } catch (Exception e) {
            log.error(">>>>发送失败，时间：{}, 接收者：{}", new Date(), mailDto.getmTo());
        }
        // 手动ACK
        Long deliverTag = (Long) headers.get(AmqpHeaders.DELIVERY_TAG);
        channel.basicAck(deliverTag, false);
    }
}
