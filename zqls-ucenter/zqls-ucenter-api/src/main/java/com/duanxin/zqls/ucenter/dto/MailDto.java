package com.duanxin.zqls.ucenter.dto;

import java.io.Serializable;

/**
 * 邮件传输对象
 * @author duanxin
 * @version 1.0
 * @date 2020/4/15 11:20
 */
public class MailDto implements Serializable {
    private static final long serialVersionUID = 6293252712838025493L;
    /**
     * 主键
     * */
    private String id;

    /**
     * 消息唯一ID标识
     * */
    private String messageId;

    /**
     * 邮件发送者
     * */
    private String mFrom;

    /**
     * 邮件接收者
     * */
    private String mTo;

    /**
     * 邮件主题
     * */
    private String mSubject;

    /**
     * 邮件内容
     * */
    private String content;

    public MailDto() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public String getmFrom() {
        return mFrom;
    }

    public void setmFrom(String mFrom) {
        this.mFrom = mFrom;
    }

    public String getmTo() {
        return mTo;
    }

    public void setmTo(String mTo) {
        this.mTo = mTo;
    }

    public String getmSubject() {
        return mSubject;
    }

    public void setmSubject(String mSubject) {
        this.mSubject = mSubject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
