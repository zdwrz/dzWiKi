package com.aweiz.wiki.test;

import com.mongodb.Mongo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

/**
 * Created by daweizhuang on 4/27/16.
 */
@Configuration
@ComponentScan(basePackages = { "com.aweiz.wiki.dao","com.aweiz.wiki.service" })
public class AppTestConfig {

    /*123
     * Use the standard Mongo driver API to create a com.mongodb.Mongo instance.
     */

    public @Bean
    Mongo mongo() throws Exception {
        return new Mongo("localhost");1
    }

    public @Bean
    MongoTemplate mongoTemplate() throws Exception {
        return new MongoTemplate(mongo(), "wiki");
    }


    @Bean
    public static JavaMailSender getJavaMailSender(){
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost("smtp.gmail.com");
        mailSender.setPort(587);
        mailSender.setUsername("aweiznotification@gmail.com");
        mailSender.setPassword("2008912zdw");
        Properties prop = new Properties();
        prop.setProperty("mail.transport.protocol","smtp");
        prop.setProperty("mail.smtp.auth","true");
        prop.setProperty("mail.smtp.starttls.enable","true");
        mailSender.setJavaMailProperties(prop);
        return mailSender;
    }

}