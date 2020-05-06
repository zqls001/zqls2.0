package com.duanxin.demo.seata.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.duanxin.demo.seata.mapper.OrderMapper;
import com.duanxin.demo.seata.module.OrderDO;
import com.duanxin.demo.seata.service.AccountService;
import com.duanxin.demo.seata.service.OrderService;
import com.duanxin.demo.seata.service.ProductService;
import io.seata.core.context.RootContext;
import io.seata.spring.annotation.GlobalTransactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author duanxin
 * @version 1.0
 * @className OrderServiceImpl
 * @date 2020/05/06 11:35
 */
@Service
public class OrderServiceImpl implements OrderService {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrderServiceImpl.class);

    @Resource
    private OrderMapper orderMapper;

    @Resource
    private AccountService accountService;

    @Resource
    private ProductService productService;

    @Override
    @DS(value = "order-ds")
    @GlobalTransactional
    public Integer createOrder(Long userId, Long productId, Integer price) throws Exception {

        Integer amount = 1; // 购买数量，暂时设置为 1。

        LOGGER.info("#OrderServiceImpl.[createOrder]# 当前 XID: {}", RootContext.getXID());

        // <3> 扣减库存
        productService.reduceStock(productId, amount);

        // <4> 扣减余额
        accountService.reduceBalance(userId, price);

        // <5> 保存订单
        OrderDO order = new OrderDO();
        order.setUserId(userId);
        order.setProductId(productId);
        order.setPayAmount(amount * price);
        orderMapper.saveOrder(order);
        LOGGER.info("#OrderServiceImpl.[createOrder]# 保存订单: {}", order.getId());

        // 返回订单编号
        return order.getId();
    }
}
