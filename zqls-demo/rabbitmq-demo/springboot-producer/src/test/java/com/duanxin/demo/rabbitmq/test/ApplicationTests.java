package com.duanxin.demo.rabbitmq.test;
import com.duanxin.demo.rabbitmq.module.Order;
import com.duanxin.demo.rabbitmq.producer.OrderSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * @author duanxin
 * @version 1.0
 * @date 2020/4/14 16:05
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {

    @Resource
    private OrderSender orderSender;

    @Test
    public void testSend1() throws Exception {
        Order order = new Order();
        order.setId("2020041400000001");
        order.setName("测试订单1");
        order.setMessageId(System.currentTimeMillis() + "$" +
                UUID.randomUUID().toString().trim());
        orderSender.send(order);
    }
}
