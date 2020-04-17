package com.duanxin.demo.rabbitmq.consumer;

import com.duanxin.demo.rabbitmq.module.Order;
import com.rabbitmq.client.Channel;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * 订单消费
 * @author duanxin
 * @version 1.0
 * @date 2020/4/14 16:24
 */
@Component
public class OrderReceiver {

    @RabbitHandler // 只是作为标识如果有消息过来就进行接收
    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = "order-queue", declare = "true"),
            exchange = @Exchange(name = "order-exchange", declare = "true", type = "topic"),
            key = "order.#"
    )) // 进行消息监听，并在broker中创建queue exchange
    public void onOrderMessage(@Payload Order order,
                               @Headers Map<String, Object> headers,
                               Channel channel) throws Exception {
        // 消费者操作
        System.out.println("---------------开始消费-------------");
        System.out.println("订单id：" + order.getId());

        Long deliveryTag = (Long) headers.get(AmqpHeaders.DELIVERY_TAG);
        // 手动ACK
        channel.basicAck(deliveryTag,false);
    }
}
