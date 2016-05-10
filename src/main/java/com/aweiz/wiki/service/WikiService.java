package com.aweiz.wiki.service;

import com.aweiz.wiki.domain.Wiki;
import com.aweiz.wiki.utility.WikiInfo;

import javax.mail.MessagingException;
import java.util.List;

/**
 * Created by daweizhuang on 4/27/16.
 */
public interface WikiService {
    void saveWiki(Wiki wiki);

    List<WikiInfo> loadWikiInfo(String java);

    List<WikiInfo> loadWikiInfo(String type, int offset, String order);

    void removeWiki(String wikiId);

    WikiInfo updateWiki(Wiki wiki);

    List<WikiInfo> searchWikiInfo(String key);

    Wiki loadWikiById(String id);
}
