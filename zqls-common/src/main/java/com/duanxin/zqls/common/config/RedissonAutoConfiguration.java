package com.duanxin.zqls.common.config;

import com.duanxin.zqls.common.properties.RedissonProperties;
import com.duanxin.zqls.common.util.RedissonLockUtil;
import org.apache.commons.lang3.StringUtils;
import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.redisson.config.SingleServerConfig;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;

/**
 * Redisson自动配置类
 * @author duanxin
 * @version 1.0
 * @date 2019/10/21 10:49
 */
@Configuration
@ConditionalOnClass(Config.class)
@EnableConfigurationProperties(RedissonProperties.class)
public class RedissonAutoConfiguration {

    @Resource
    private RedissonProperties redissonProperties;

    /**
     * 单机模式
     * @date 2019/10/21 10:52
     * @return org.redisson.api.RedissonClient
     **/
    @Bean
    @ConditionalOnProperty(name = "redisson.address")
    public RedissonClient redissonSingle() {
        Config config = new Config();
        SingleServerConfig singleServerConfig = config.useSingleServer()
                .setAddress(redissonProperties.getAddress())
                .setTimeout(redissonProperties.getTimeout())
                .setConnectionPoolSize(redissonProperties.getConnectionPoolSize())
                .setConnectionMinimumIdleSize(redissonProperties.getConnectionMinimumIdleSize());
        if (StringUtils.isNotBlank(redissonProperties.getPassword())) {
            singleServerConfig.setPassword(redissonProperties.getPassword());
        }

        return Redisson.create(config);
    }

    /**
     * 装配client类，并将实例注入到RedissonLockUtil中
     * @param redissonClient redisson客户端
     * @date 2019/10/21 11:02
     * @return com.duanxin.zqls.common.util.RedissonLockUtil
     **/
    @Bean
    public RedissonLockUtil redissonLockUtil(RedissonClient redissonClient) {
        RedissonLockUtil redissonLockUtil = new RedissonLockUtil();
        RedissonLockUtil.setRedissonClient(redissonClient);
        return redissonLockUtil;
    }
}
