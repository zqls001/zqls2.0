package com.duanxin.demo.seata.service;

/**
 * @author duanxin
 * @version 1.0
 * @className OrderService
 * @date 2020/05/06 11:34
 */
public interface OrderService {
    
    /**
     * 创建订单
     * @param userId 用户id
     * @param productId 商品id
     * @param price 商品价格
     * @date 2020/5/6 11:40
     * @return java.lang.Integer
     */
    Integer createOrder(Long userId, Long productId, Integer price) throws Exception;
}
