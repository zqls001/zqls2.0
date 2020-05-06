package com.duanxin.demo.seata.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.duanxin.demo.seata.mapper.AccountMapper;
import com.duanxin.demo.seata.service.AccountService;
import io.seata.core.context.RootContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author duanxin
 * @version 1.0
 * @className AccountServiceImpl
 * @date 2020/05/06 12:12
 */
@Service
public class AccountServiceImpl implements AccountService {

    private static final Logger LOGGER = LoggerFactory.getLogger(AccountServiceImpl.class);

    @Resource
    private AccountMapper accountMapper;

    @DS("account-ds") // 1
    @Transactional(propagation = Propagation.REQUIRES_NEW) // 2.开启新事务
    @Override
    public void reduceBalance(Long userId, Integer price) throws Exception {
        LOGGER.info("#AccountServiceImpl.[reduceBalance]# 当前 XID: {}", RootContext.getXID());

        // 3. 检查余额
        checkBalance(userId, price);

        LOGGER.info("#AccountServiceImpl.[reduceBalance]# 开始扣减用户 {} 余额", userId);
        // 4. 扣减余额
        int updateCount = accountMapper.reduceBalance(userId, price);
        // 扣减失败
        if (updateCount == 0) {
            LOGGER.warn("#AccountServiceImpl.[reduceBalance]# 扣除用户 {} 余额失败", userId);
            throw new Exception("余额不足");
        }

        // 扣减成功
        LOGGER.info("#AccountServiceImpl.[reduceBalance]# 扣除用户 {} 余额成功", userId);
    }

    private void checkBalance(Long userId, Integer price) throws Exception {
        LOGGER.info("#AccountServiceImpl.[checkBalance]# 检查用户 {} 余额", userId);
        Integer balance = accountMapper.getBalance(userId);
        if (price > balance) {
            LOGGER.warn("#AccountServiceImpl.[checkBalance]# 用户 {} 余额不足， 当前余额为 {}", userId, balance);
            throw new Exception("余额不足");
        }
    }
}
