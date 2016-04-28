package com.aweiz.wiki.dao;

import com.aweiz.wiki.domain.Wiki;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

/**
 * Created by daweizhuang on 4/27/16.
 */
@Repository
public class WikiDAOImpl implements WikiDAO {
    @Autowired
    private MongoTemplate mongoTemp;

    @Override
    public void saveWiki(String title, String content, String category) {
        Wiki wiki = new Wiki();
        wiki.setTitle(title);
        wiki.setContent(content);
        wiki.setCategory(category);
        mongoTemp.save(wiki, "wiki");
    }
}
