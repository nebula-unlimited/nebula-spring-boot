package com.nebula.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.internet.MimeMessage;
import java.io.File;

/**
 * Spring Boot 邮件工具类
 *
 * @author Nebula Unlimited
 */

@Component
public class MailUtil {
    @Autowired
    private JavaMailSender mailSender;

    /**
     * 发送简单邮件
     * @param from 发件人邮箱地址
     * @param to 收件人邮箱地址
     * @param subject 邮件标题
     * @param content 邮件内容
     * @throws Exception
     */
    public void sendSimpleMail(String from, String to, String subject, String content) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from);
        message.setTo(to);
        message.setSubject(subject);
        message.setText(content);
        mailSender.send(message);
    }

    /**
     * 发送 HTML 邮件
     * @param from 发件人邮箱地址
     * @param to 收件人邮箱地址
     * @param subject 邮件标题
     * @param content 邮件内容
     * @throws Exception
     */
    public void sendHtmlMail(String from, String to, String subject, String content) throws Exception {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setFrom(from);
        helper.setTo(to);
        helper.setSubject(subject);
        helper.setText(content, true);
        mailSender.send(message);
    }

    /**
     * 发送带附件的邮件
     * @param from
     * @param to
     * @param subject
     * @param content
     * @throws Exception
     */
    public void sendAttachmentMail(String from, String to, String subject, String content) throws Exception {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
        helper.setFrom(from);
        helper.setTo(to);
        helper.setSubject(subject);
        helper.setText(content);
        //注意项目路径问题，自动补用项目路径
        FileSystemResource file = new FileSystemResource(new File("/home/cloud/project/Nebula-Spring-Boot/Spring-Boot-Mail/target/classes/static/image/nebula.jpg").getPath());
        //加入邮件
        helper.addAttachment("星云.jpg", file);
        mailSender.send(mimeMessage);
    }

    /**
     * 发送带静态资源的邮件
     * @param from
     * @param to
     * @param subject
     * @param content
     * @throws Exception
     */
    public void sendInlineMail(String from, String to, String subject, String content) throws Exception {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
        helper.setFrom(from);
        helper.setTo(to);
        helper.setSubject(subject);
        //第二个参数指定发送的是HTML格式,同时cid:是固定的写法
        helper.setText(content, true);

        ///FileSystemResource file = new FileSystemResource(new File("/home/cloud/project/Nebula-Spring-Boot/Spring-Boot-Mail/target/classes/static/image/nebula.jpg"));
        ///helper.addInline("picture", file);

        Resource resource = new ClassPathResource("static/image/nebula.jpg");
        helper.addInline("picture", resource);
        mailSender.send(mimeMessage);
    }

    public void sendTemplateMail(String from, String to, String subject, String content) throws Exception {
        MimeMessage message = null;
        message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setFrom(from);
        helper.setTo(to);
        helper.setSubject(subject);
        helper.setText(content, true);
        mailSender.send(message);
    }
}
