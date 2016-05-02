package com.aweiz.wiki.dao;

import com.aweiz.wiki.domain.Wiki;
import com.aweiz.wiki.utility.WikiInfo;

import java.util.List;

/**
 * Created by daweizhuang on 4/27/16.
 */
public interface WikiDAO {
    void saveWiki(Wiki wiki);

    List<Wiki> loadWiki(String type);

    List<Wiki> loadWiki(String type, int offset, String order);

    void remove(String wikiId);

    Wiki updateWiki(Wiki wiki);
}
