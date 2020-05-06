package com.duanxin.demo.seata.service;

/**
 * @author duanxin
 * @version 1.0
 * @className AccountService
 * @date 2020/05/06 12:11
 */
public interface AccountService {
    /**
     * 扣减余额
     * @param userId 用户 ID
     * @param price 扣减金额
     * @date 2020/5/6 12:11
     * @return void
     */
    void reduceBalance(Long userId, Integer price) throws Exception;
}
