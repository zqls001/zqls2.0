package com.duanxin.zqls.mail.service;

import com.duanxin.zqls.mail.api.MailService;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.core.env.Environment;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.annotation.Resource;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.Objects;

/**
 * 邮件服务工具类
 * @author duanxin
 * @version 1.0
 * @date 2019/10/22 9:35
 */
@Service(version = "0.0.1")
@Slf4j
public class MailServiceImpl implements MailService {

    @Resource
    private JavaMailSender javaMailSender;
    @Resource
    private Environment env;

    @Override
    public int send(String to, String subject, String content) {
        log.info(">>>>开始发送简单邮件,时间：{},接收者：{}<<<<", new Date(), to);
        // 获取邮件信息器
        SimpleMailMessage message = new SimpleMailMessage();
        // 设置邮件发送者
        message.setFrom(Objects.requireNonNull(env.getProperty("spring.mail.username")));
        // 设置接收者
        message.setTo(to);
        // 设置标题
        message.setSubject(subject);
        // 设置邮件内容
        message.setText(content);

        try {
            // 发送邮件
            javaMailSender.send(message);
            log.info(">>>>发送成功，时间：{},接收者：{}<<<<", new Date(), to);
        } catch (Exception e) {
            log.error(">>>>发送失败，时间：{},接收者：{},原因：{}<<<<", new Date(), to, e.getMessage());
            return 0;
        }
        return 1;
    }

    @Override
    public int sendWithHtml(String to, String subject, String html) {
        log.info(">>>>开始发送 html 邮件,时间：{},接收者：{}<<<<", new Date(), to);
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = null;
        try {
            helper = new MimeMessageHelper(message, true);
            // 设置发送者
            helper.setFrom(Objects.requireNonNull(env.getProperty("spring.mail.username")));
            // 设置接收者
            helper.setTo(to);
            // 设置标题
            helper.setSubject(subject);
            // 设置内容，并设置为时html类邮件
            helper.setText(html, true);
            // 发送邮件
            javaMailSender.send(message);
            log.info(">>>>发送成功，时间：{},接收者：{}<<<<", new Date(), to);
        } catch(Exception e) {
            log.error(">>>>发送失败，时间：{},接收者：{}<<<<", new Date(), to);
            return 0;
        }
        return 1;
    }

    @Override
    public int sendWithImageHtml(String to, String subject, String html, String[] cids, String[] filePaths) {
        log.info(">>>>开始发送带图片的 html 邮件,时间：{},接收者：{}<<<<", new Date(), to);
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = null;
        try {
            helper = new MimeMessageHelper(message, true);
            // 设置发送者
            helper.setFrom(Objects.requireNonNull(env.getProperty("spring.mail.username")));
            // 设置标题
            helper.setSubject(subject);
            // 设置接收者
            helper.setTo(to);
            // 设置html主题
            helper.setText(html, true);
            // 设置内联图片
            for (int i = 0; i < cids.length; ++i) {
                // 读取系统文件
                FileSystemResource systemResource = new FileSystemResource(filePaths[i]);
                // 将系统文件设置到指定的html位置
                helper.addInline(cids[i], systemResource);
            }
            // 发送邮件
            javaMailSender.send(message);
            log.info(">>>>发送成功，时间：{},接收者：{}<<<<", new Date(), to);
        } catch(Exception e) {
            log.error(">>>>发送失败，时间：{},接收者：{}<<<<", new Date(), to);
            return 0;
        }
        return 1;
    }

    @Override
    public int sendWithEnclosure(String to, String subject, String content, String[] filePaths) {
        log.info(">>>>开始发送带 附件 邮件,时间：{},接收者：{}<<<<", new Date(), to);
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = null;
        try {
            helper = new MimeMessageHelper(message, true);
            // 设置发送者
            helper.setFrom(Objects.requireNonNull(env.getProperty("spring.mail.username")));
            // 设置接收者
            helper.setTo(to);
            // 设置内容
            helper.setText(content);
            // 设置标题
            helper.setSubject(subject);
            // 设置附件
            for (int i = 0; i < filePaths.length; ++i) {
                FileSystemResource systemResource = new FileSystemResource(filePaths[i]);
                String attachmentFileName = "附件" + (i + 1);
                helper.addAttachment(attachmentFileName, systemResource);
            }
            // 发送
            javaMailSender.send(message);
            log.info(">>>>发送成功，时间：{},接收者：{}<<<<", new Date(), to);
        } catch (Exception e) {
            log.error(">>>>发送失败，时间：{},接收者：{}<<<<", new Date(), to);
            return 0;
        }
        return 1;
    }
}
