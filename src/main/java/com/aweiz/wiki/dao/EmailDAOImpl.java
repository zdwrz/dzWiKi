package com.aweiz.wiki.dao;

import com.aweiz.wiki.domain.EmailTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

/**
 * Created by daweizhuang on 5/10/16.
 */
@Repository
public class EmailDAOImpl implements EmailDAO {

    @Autowired
    private MongoTemplate mongoTemp;

    @Override
    public EmailTemplate getEmailTemplateByName(String name) {
        Query query = new Query();
        query.addCriteria(Criteria.where("name").is(name));
        return mongoTemp.findOne(query,EmailTemplate.class,"email_template");
    }
}
