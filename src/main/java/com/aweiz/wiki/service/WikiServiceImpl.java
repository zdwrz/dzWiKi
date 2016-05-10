package com.aweiz.wiki.service;

import com.aweiz.wiki.dao.WikiDAO;
import com.aweiz.wiki.domain.EmailTemplate;
import com.aweiz.wiki.domain.Wiki;
import com.aweiz.wiki.utility.Constants;
import com.aweiz.wiki.utility.WikiInfo;
import com.aweiz.wiki.utility.WikiOperationType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by daweizhuang on 4/27/16.
 */
@Service
public class WikiServiceImpl implements WikiService {

    @Autowired
    private WikiDAO wikiDAO;
    @Autowired
    private EmailService emailService;

    @Override
    public void saveWiki(Wiki wiki){
        wiki.setTouchedDate(new Date());
        wikiDAO.saveWiki(wiki);
        emailService.sendWikiOperationNotification(WikiOperationType.CREATE, wiki.getId());
    }

    @Override
    public List<WikiInfo> loadWikiInfo(String type) {
        List<WikiInfo> resList = new ArrayList<>();
        List<Wiki> wikiList = wikiDAO.loadWiki(type);
        for (Wiki wiki : wikiList) {
            resList.add(new WikiInfo(wiki));
        }
        return resList;
    }

    @Override
    public List<WikiInfo> loadWikiInfo(String type, int offset, String order) {
        List<WikiInfo> resList = new ArrayList<>();
        List<Wiki> wikiList = wikiDAO.loadWiki(type,offset,order);
        if(wikiList.size() < Constants.STEP_SIZE){
            WikiInfo endWiki = new WikiInfo();
            endWiki.setId("0");
            endWiki.setTitle("This is the last one.");
            endWiki.setContent("This is the last wiki.");
            resList.add(endWiki);
        }
        for (Wiki wiki : wikiList) {
            resList.add(new WikiInfo(wiki));
        }
        return resList;
    }

    @Override
    public void removeWiki(String wikiId){
        emailService.sendWikiOperationNotification(WikiOperationType.REMOVE, wikiId);
        wikiDAO.remove(wikiId);
    }

    @Override
    public WikiInfo updateWiki(Wiki wiki){
        emailService.sendWikiOperationNotification(WikiOperationType.UPDATE, wiki.getId());
        return new WikiInfo(wikiDAO.updateWiki(wiki));
    }

    @Override
    public List<WikiInfo> searchWikiInfo(String key) {
        List<WikiInfo> resList = new ArrayList<>();
        List<Wiki> wikiList = wikiDAO.searchWikiByKeyword(key);
        for (Wiki wiki : wikiList) {
            resList.add(new WikiInfo(wiki));
        }
        return resList;
    }

    @Override
    public Wiki loadWikiById(String id) {
       return wikiDAO.findWiki(id);
    }

}
