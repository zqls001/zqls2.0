package com.duanxin.zqls.service.util;
import org.redisson.api.*;

import java.util.concurrent.TimeUnit;

/**
 * 分布式锁工具类
 * @author duanxin
 * @version 1.0
 * @date 2019/10/21 11:00
 */
public class RedissonLockUtil {

    private static RedissonClient redissonClient;

    public static void setRedissonClient(RedissonClient client) {
        redissonClient = client;
    }

    /**
     * 获取锁
     * @param lockKey 锁名
     * @date 2019/10/21 11:13
     * @return org.redisson.api.RLock
     **/
    public static RLock getLock(String lockKey) {
        return redissonClient.getLock(lockKey);
    }

    /**
     * 获取公平锁
     * @param lockKey 锁名
     * @date 2019/10/21 11:15
     * @return org.redisson.api.RLock
     **/
    public static RLock getFairLock(String lockKey) {
        return redissonClient.getFairLock(lockKey);
    }

    /**
     * 获取读写锁
     * @param lockKey 锁名
     * @date 2019/10/21 11:16
     * @return org.redisson.api.RReadWriteLock
     **/
    public static RReadWriteLock getReadWriteLock(String lockKey) {
        return redissonClient.getReadWriteLock(lockKey);
    }

    /**
     * 获取信号量
     * @param lockKey 锁名
     * @date 2019/10/21 11:17
     * @return org.redisson.api.RSemaphore
     **/
    public static RSemaphore getSemaphore(String lockKey) {
        return redissonClient.getSemaphore(lockKey);
    }

    /**
     * 获取CountDownLatch（倒计时）
     * @param lockKey 锁名
     * @date 2019/10/21 11:21
     * @return org.redisson.api.RCountDownLatch
     **/
    public static RCountDownLatch getCountDownLatch(String lockKey) {
        return redissonClient.getCountDownLatch(lockKey);
    }

    /**
     * 异步加锁
     * @param lockKey 锁名
     * @param waitTime 获取锁定的时间间隔
     * @param leaseTime 时间间隔，在该时间间隔后将自动释放锁定
     * @param timeUnit 时间类型
     * @date 2019/10/21 11:24
     * @return org.redisson.api.RFuture<java.lang.Boolean>
     **/
    public static RFuture<Boolean> tryLockAsync(String lockKey, int waitTime,
                                                int leaseTime, TimeUnit timeUnit)
            throws InterruptedException {
        RLock lock = redissonClient.getLock(lockKey);
        Thread.sleep(1000);
        return lock.tryLockAsync(waitTime, leaseTime, timeUnit);
    }

    /**
     * 释放锁
     * @param lockKey 锁名
     * @date 2019/10/21 11:27
     **/
    public static void ulock(String lockKey) {
        redissonClient.getLock(lockKey).unlock();
    }

    /**
     * 带超时的锁，默认单位s
     * @param lockKey 锁名
     * @param timeout 超时时间
     * @date 2019/10/21 15:48
     * @return org.redisson.api.RLock
     **/
    public static RLock lock(String lockKey, int timeout) {
        RLock lock = redissonClient.getLock(lockKey);
        lock.lock(timeout, TimeUnit.SECONDS);
        return lock;
    }

    /**
     * 带超时的锁，时间类型自定
     * @param lockKey 锁名
     * @param timeout 超时时间
     * @param timeUnit 时钟类型
     * @date 2019/10/21 15:50
     * @return org.redisson.api.RLock
     **/
    public static RLock lock(String lockKey, int timeout, TimeUnit timeUnit) {
        RLock lock = redissonClient.getLock(lockKey);
        lock.lock(timeout, timeUnit);
        return lock;
    }

    /**
     * 尝试获取锁
     * @param lockKey 锁名
     * @param waitTime 最多等待时间
     * @param leastTime 上锁后自动释放锁的时间
     * @date 2019/10/21 15:53
     * @return boolean
     **/
    public static boolean tryLock(String lockKey, int waitTime, int leastTime) {
        RLock lock = redissonClient.getLock(lockKey);
        try {
            return lock.tryLock(waitTime, leastTime, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            return false;
        }
    }

    /**
     * 尝试获取锁，时间类型自定
     * @param lockKey 锁名
     * @param waitTime 最多等待时间
     * @param least 上锁后自动释放锁的时间
     * @param timeUnit 时间类型
     * @date 2019/10/21 15:55
     * @return boolean
     **/
    public static boolean tryLock(String lockKey, int waitTime, int least, TimeUnit timeUnit) {
        RLock lock = redissonClient.getLock(lockKey);
        try {
            return lock.tryLock(waitTime, least, timeUnit);
        } catch (InterruptedException e) {
            return false;
        }
    }
}
