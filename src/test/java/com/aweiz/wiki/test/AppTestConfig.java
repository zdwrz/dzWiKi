package com.aweiz.wiki.test;

import com.mongodb.Mongo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

/**
 * Created by daweizhuang on 4/27/16.
 */
@Configuration
@ComponentScan(basePackages = { "com.aweiz.wiki.dao","com.aweiz.wiki.service" })
public class AppTestConfig {

    /*
     * Use the standard Mongo driver API to create a com.mongodb.Mongo instance.
     */

    public @Bean
    Mongo mongo() throws Exception {
        return new Mongo("localhost");
    }

    public @Bean
    MongoTemplate mongoTemplate() throws Exception {
        return new MongoTemplate(mongo(), "wiki");
    }
}