package com.duanxin.zqls.ucenter.producer;

import com.duanxin.zqls.ucenter.dto.MailDto;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 邮件发送
 * @author duanxin
 * @version 1.0
 * @date 2020/4/15 11:10
 */
@Component
public class MailSender {

    @Resource
    private RabbitTemplate rabbitTemplate;

    public void send(MailDto mailDto) {

        CorrelationData correlationData = new CorrelationData();
        correlationData.setId(mailDto.getMessageId());

        rabbitTemplate.convertAndSend("mail-exchange",
                "mail.abc",
                mailDto,
                correlationData);
    }
}
