package com.duanxin.zqls.ucenter.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * RabbitMQ配置
 * @author duanxin
 * @version 1.0
 * @date 2019/10/19 10:06
 */
@Configuration
public class MQConfig {

    public static final String SMS_QUEUE = "sms.queue";

    public static final String MAIL_QUEUE = "mail.queue";

    @Bean
    public Queue smsQueue() {
        return new Queue(SMS_QUEUE, true);
    }

    @Bean
    public Queue mailQueue() {
        return new Queue(MAIL_QUEUE, true);
    }
}
