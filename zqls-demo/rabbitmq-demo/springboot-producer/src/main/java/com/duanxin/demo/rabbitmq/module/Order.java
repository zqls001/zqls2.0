package com.duanxin.demo.rabbitmq.module;

import java.io.Serializable;

/**
 * @author duanxin
 * @version 1.0
 * @date 2020/4/14 15:50
 */
public class Order implements Serializable {
    private static final long serialVersionUID = 6794370638486048167L;

    private String id;

    private String name;

    /**
     * 存储消息发送的唯一标识
     * */
    private String messageId;

    public Order() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }
}
