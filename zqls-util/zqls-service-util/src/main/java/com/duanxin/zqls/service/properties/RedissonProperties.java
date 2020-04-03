package com.duanxin.zqls.service.properties;


import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * Redisson配置类
 * @author duanxin
 * @version 1.0
 * @date 2019/10/21 10:36
 */
@Component
@ConfigurationProperties(prefix = "redisson")
public class RedissonProperties {

    public RedissonProperties() {
    }

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

    public int getTimeout() {
        return timeout;
    }

    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getConnectionPoolSize() {
        return connectionPoolSize;
    }

    public void setConnectionPoolSize(int connectionPoolSize) {
        this.connectionPoolSize = connectionPoolSize;
    }

    public int getConnectionMinimumIdleSize() {
        return connectionMinimumIdleSize;
    }

    public void setConnectionMinimumIdleSize(int connectionMinimumIdleSize) {
        this.connectionMinimumIdleSize = connectionMinimumIdleSize;
    }

    public int getSlaveConnectionPoolSize() {
        return slaveConnectionPoolSize;
    }

    public void setSlaveConnectionPoolSize(int slaveConnectionPoolSize) {
        this.slaveConnectionPoolSize = slaveConnectionPoolSize;
    }

    public int getMasterConnectionPoolSize() {
        return masterConnectionPoolSize;
    }

    public void setMasterConnectionPoolSize(int masterConnectionPoolSize) {
        this.masterConnectionPoolSize = masterConnectionPoolSize;
    }

    public String[] getSentinelAddresses() {
        return sentinelAddresses;
    }

    public void setSentinelAddresses(String[] sentinelAddresses) {
        this.sentinelAddresses = sentinelAddresses;
    }

    public String getMasterName() {
        return masterName;
    }

    public void setMasterName(String masterName) {
        this.masterName = masterName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        RedissonProperties that = (RedissonProperties) o;

        return new EqualsBuilder()
                .append(timeout, that.timeout)
                .append(connectionPoolSize, that.connectionPoolSize)
                .append(connectionMinimumIdleSize, that.connectionMinimumIdleSize)
                .append(slaveConnectionPoolSize, that.slaveConnectionPoolSize)
                .append(masterConnectionPoolSize, that.masterConnectionPoolSize)
                .append(address, that.address)
                .append(password, that.password)
                .append(sentinelAddresses, that.sentinelAddresses)
                .append(masterName, that.masterName)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(timeout)
                .append(address)
                .append(password)
                .append(connectionPoolSize)
                .append(connectionMinimumIdleSize)
                .append(slaveConnectionPoolSize)
                .append(masterConnectionPoolSize)
                .append(sentinelAddresses)
                .append(masterName)
                .toHashCode();
    }

    @Override
    public String toString() {
        return "RedissonProperties{" +
                "timeout=" + timeout +
                ", address='" + address + '\'' +
                ", password='" + password + '\'' +
                ", connectionPoolSize=" + connectionPoolSize +
                ", connectionMinimumIdleSize=" + connectionMinimumIdleSize +
                ", slaveConnectionPoolSize=" + slaveConnectionPoolSize +
                ", masterConnectionPoolSize=" + masterConnectionPoolSize +
                ", sentinelAddresses=" + Arrays.toString(sentinelAddresses) +
                ", masterName='" + masterName + '\'' +
                '}';
    }
}
