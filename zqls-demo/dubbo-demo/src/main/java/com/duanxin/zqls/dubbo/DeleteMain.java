package com.duanxin.zqls.dubbo;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;

/**
 * @author duanxin
 * @version 1.0
 * @date 2019/10/17 16:09
 */
public class DeleteMain {

    public static void main(String[] args) throws Exception {
        ExponentialBackoffRetry retry = new ExponentialBackoffRetry(1000, 3);
        // 创建客户端
        CuratorFramework client = CuratorFrameworkFactory
                .builder()
                .connectString("39.106.154.120:2181")
                .sessionTimeoutMs(15000)
                .connectionTimeoutMs(130000)
                .retryPolicy(retry)
                .build();

        // 开启客户端
        client.start();

        // 删除操作
        client.delete().deletingChildrenIfNeeded().forPath("/dubbo");
    }
}
