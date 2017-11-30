package com.nebula.web;

import com.nebula.util.MailUtil;
import freemarker.template.Template;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import java.util.HashMap;
import java.util.Map;

@RestController
public class IndexController {
    @Autowired
    private MailUtil mailUtil;

    @Value("${spring.mail.username}")
    private String from;

    /**
     * 收件人
     */
    private String to = "66999882@qq.com";

    @RequestMapping("/")
    public String index() {
        /**
         * 邮件标题
         */
        String subject = "标题：简单邮件";
        /**
         * 邮件内容
         */
        String content = "测试邮件内容";
        try {
            mailUtil.sendSimpleMail(from, to, subject, content);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return "ok";
    }

    @RequestMapping("/html")
    public String html() {
        /**
         * 邮件标题
         */
        String subject = "标题：发送 HTML 内容";
        /**
         * 邮件内容
         */
        StringBuffer sb = new StringBuffer();
        sb.append("<h1>大标题-h1</h1>")
                .append("<p style='color:#F00'>红色字</p>")
                .append("<p style='text-align:right'>右对齐</p>");
        String content = sb.toString();
        try {
            mailUtil.sendHtmlMail(from, to, subject, content);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return "ok";
    }

    @RequestMapping("/attachment")
    public String attachment() {
        /**
         * 邮件标题
         */
        String subject = "标题：带附件的邮件";
        /**
         * 邮件内容
         */
        String content = "带附件的邮件内容";
        try {
            mailUtil.sendAttachmentMail(from, to, subject, content);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return "ok";
    }

    @RequestMapping("/inline")
    public String inline() {
        /**
         * 邮件标题
         */
        String subject = "标题：带静态资源的邮件";
        /**
         * 邮件内容
         */
        String content = "<html><body>带静态资源的邮件内容 图片:<img src='cid:picture' /></body></html>";
        try {
            mailUtil.sendInlineMail(from, to, subject, content);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return "ok";
    }

    @Autowired
    private FreeMarkerConfigurer freeMarkerConfigurer;

    @RequestMapping("/template")
    public String template() {
        /**
         * 邮件标题
         */
        String subject = "标题：模板邮件";
        /**
         * 邮件内容
         */
        Map<String, Object> model = new HashMap<String, Object>(1);
        model.put("username", "nebula");

        try {
            /**
             * 修改 application.properties 文件中的读取路径
             */
            ///FreeMarkerConfigurer configurer = new FreeMarkerConfigurer();
            ///configurer.setTemplateLoaderPath("classpath:templates");

            /**
             * 读取 HTML 模板
             */
            Template template = freeMarkerConfigurer.getConfiguration().getTemplate("mail.html");
            String content = FreeMarkerTemplateUtils.processTemplateIntoString(template, model);
            mailUtil.sendTemplateMail(from, to, subject, content);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "ok";
    }
}
