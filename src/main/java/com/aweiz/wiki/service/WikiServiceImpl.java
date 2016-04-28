package com.aweiz.wiki.service;

import com.aweiz.wiki.dao.WikiDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by daweizhuang on 4/27/16.
 */
@Service
public class WikiServiceImpl implements WikiService {

    @Autowired
    private WikiDAO wikiDAO;

    @Override
    public void saveWiki(String title, String content, String category) {
        wikiDAO.saveWiki(title,content,category);
    }
}
