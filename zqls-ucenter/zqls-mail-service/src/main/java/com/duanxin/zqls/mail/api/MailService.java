package com.duanxin.zqls.mail.api;

/**
 * 邮件服务Service层接口
 * @author duanxin
 * @version 1.0
 * @date 2019/10/24 15:35
 */
public interface MailService {

    /**
     * 发送简单邮件
     * @param to 接收者
     * @param subject 标题
     * @param content 主体
     * @date 2019/10/24 15:41
     * @return int
     **/
    int send(String to, String subject, String content);

    /**
     * 发送 html 邮件
     * @param to 接收者
     * @param subject 标题
     * @param html html主体
     * @date 2019/10/24 15:41
     * @return int
     **/
    int sendWithHtml(String to, String subject, String html);

    /**
     * 发送带图片的 html 邮件
     * @param to 接收者
     * @param subject 标题
     * @param html html主体
     * @param cids 图片id
     * @param filePaths 图片路径
     * @date 2019/10/24 15:42
     * @return int
     **/
    int sendWithImageHtml(String to, String subject, String html,
                          String[] cids, String[] filePaths);

    /**
     * 发送带附件的邮件
     * @param to 接收者
     * @param subject 标题
     * @param content 主体
     * @param filePaths 附件路径
     * @date 2019/10/24 15:43
     * @return int
     **/
    int sendWithEnclosure(String to, String subject, String content, String[] filePaths);
}
