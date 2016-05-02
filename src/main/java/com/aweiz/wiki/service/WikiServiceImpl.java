package com.aweiz.wiki.service;

import com.aweiz.wiki.dao.WikiDAO;
import com.aweiz.wiki.domain.Wiki;
import com.aweiz.wiki.utility.Constants;
import com.aweiz.wiki.utility.WikiInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    @Override
    public void saveWiki(Wiki wiki) {
        wiki.setTouchedDate(new Date());
        wikiDAO.saveWiki(wiki);
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
        for (Wiki wiki : wikiList) {
            resList.add(new WikiInfo(wiki));
        }
        return resList;
    }

    @Override
    public void removeWiki(String wikiId) {
        wikiDAO.remove(wikiId);
    }

    @Override
    public WikiInfo updateWiki(Wiki wiki) {
        return new WikiInfo(wikiDAO.updateWiki(wiki));
    }
}
