package com.aweiz.wiki.dao;

import com.aweiz.wiki.domain.Wiki;
import com.aweiz.wiki.utility.Constants;
import com.aweiz.wiki.utility.WikiInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * Created by daweizhuang on 4/27/16.
 */
@Repository
public class WikiDAOImpl implements WikiDAO {
    @Autowired
    private MongoTemplate mongoTemp;

    @Override
    public void saveWiki(Wiki wiki) {
        mongoTemp.save(wiki, "wiki");
    }

    @Override
    public List<Wiki> loadWiki(String type) {
        Query query = new Query();
        query.with(new Sort(new Sort.Order(Sort.Direction.DESC, Constants.ORDER_TOUCHED_DATE)));
        return mongoTemp.find(query,Wiki.class);
    }
    @Override
    public List<Wiki> loadWiki(String type, int offset, String order) {
        Query query = new Query();
        query.with(new Sort(new Sort.Order(Sort.Direction.DESC, order)));
        query.skip(offset);
        query.limit(Constants.STEP_SIZE);
        return mongoTemp.find(query,Wiki.class);
    }

    @Override
    public void remove(String wikiId) {
        Query query = new Query();
        query.addCriteria(Criteria.where("id").is(wikiId));
        Wiki wiki = mongoTemp.findAndRemove(query, Wiki.class);
        wiki.setTouchedDate(new Date());
        mongoTemp.save(wiki,"wiki_deleted");
    }

    @Override
    public Wiki updateWiki(Wiki wiki) {
        Query query = new Query();
        query.addCriteria(Criteria.where("id").is(wiki.getId()));
        Wiki entity = mongoTemp.findOne(query, Wiki.class);
        entity.setTitle(wiki.getTitle());
        entity.setContent(wiki.getContent());
        entity.setTouchedDate(new Date());
        mongoTemp.save(entity);
        return entity;
    }
}
