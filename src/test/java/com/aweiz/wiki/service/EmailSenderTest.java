package com.aweiz.wiki.service;

import com.aweiz.wiki.test.AppTestConfig;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

/**
 * Created by daweizhuang on 5/10/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppTestConfig.class, loader = AnnotationConfigContextLoader.class)
public class EmailSenderTest {
    @Autowired
    private JavaMailSender emailSender;

    @Test
    @Ignore
    public void testEmail(){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("DaweiTest");
        message.setTo("dawei.zhuang@antra.net");
        message.setSubject("This is a test");
        message.setText("you never know what will happen");
        emailSender.send(message);
    }
    @Test
    @Ignore
    public void testEmailHtml() throws MessagingException {
        MimeMessage mimeMessage = emailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, false, "utf-8");
        String htmlMsg = "<h3>Hello World!</h3>";
        mimeMessage.setContent(htmlMsg, "text/html");
        helper.setTo("dawei.zhuang@antra.net");
        helper.setSubject("This is the test message for testing gmail smtp server using spring mail");
        helper.setFrom("abc@gmail.com");
        emailSender.send(mimeMessage);
    }
}
