package com.duanxin.zqls.ucenter.model;

import java.io.Serializable;

/**
 * 邮件信息(MailInfo)实体类
 *
 * @author makejava
 * @since 2020-04-15 12:02:17
 */
public class MailInfo implements Serializable {
    private static final long serialVersionUID = 109647983743478775L;
    /**
    * 邮件主键
    */
    private String id;
    /**
    * 消息唯一标识ID
    */
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
    */
    private String content;

    public MailInfo() {
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