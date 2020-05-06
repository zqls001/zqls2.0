package com.duanxin.demo.seata.service;

/**
 * @author duanxin
 * @version 1.0
 * @className ProductService
 * @date 2020/05/06 12:01
 */
public interface ProductService {
    /**
     * 扣减库存
     * @param productId 商品 ID
     * @param amount 扣减库存
     * @date 2020/5/6 12:01
     */
    void reduceStock(Long productId, Integer amount) throws Exception;
}
