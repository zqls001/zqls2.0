package com.duanxin.demo.rabbitmq.producer;

import com.duanxin.demo.rabbitmq.module.Order;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 订单发送
 * @author duanxin
 * @version 1.0
 * @date 2020/4/14 15:53
 */
@Component
public class OrderSender {

    @Resource
    private RabbitTemplate rabbitTemplate;

    public void send(Order order) {
        CorrelationData correlationData = new CorrelationData();
        correlationData.setId(order.getMessageId());

        rabbitTemplate.convertAndSend("order-exchange", // exchange
                "order.abc", // routingKey
                order, // 消息内容
                correlationData); // correlationData 消息唯一ID
    }
}
