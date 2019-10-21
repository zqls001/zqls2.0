package com.duanxin.zqls.properties;


import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Redisson配置类
 * @author duanxin
 * @version 1.0
 * @date 2019/10/21 10:36
 */
@Component
@ConfigurationProperties(prefix = "redisson")
@Getter
@Setter
public class RedissonProperties {

    /** 超时时间，单位毫秒，默认3s */
    private int timeout = 3000;

    /** 连接地址 */
    private String address;

    /** 连接密码，可进行加密 */
    private String password;

    /** redis连接池大小，默认64 */
    private int connectionPoolSize = 64;

    /** 连接最小空闲大小，默认10 */
    private int connectionMinimumIdleSize=10;

    /** 从属连接池大小，默认250 */
    private int slaveConnectionPoolSize = 250;

    /** 主属连接池大小，默认250 */
    private int masterConnectionPoolSize = 250;

    /** 哨兵地址集 */
    private String[] sentinelAddresses;

    /** 主属数据库名称 */
    private String masterName;
}
