package com.duanxin.zqls.mail.api;

/**
 * 邮件服务服务降级
 * @author duanxin
 * @version 1.0
 * @date 2019/10/24 15:41
 */
public class MailServiceMock implements MailService {
    @Override
    public int send(String to, String subject, String content) {
        return -1;
    }

    @Override
    public int sendWithHtml(String to, String subject, String html) {
        return -1;
    }

    @Override
    public int sendWithImageHtml(String to, String subject, String html, String[] cids, String[] filePaths) {
        return -1;
    }

    @Override
    public int sendWithEnclosure(String to, String subject, String content, String[] filePaths) {
        return -1;
    }
}
