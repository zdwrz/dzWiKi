package com.aweiz.wiki.controller;

import com.aweiz.wiki.domain.Wiki;
import com.aweiz.wiki.service.WikiService;
import com.aweiz.wiki.utility.WikiInfo;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by daweizhuang on 4/27/16.
 */
@Controller
public class WikiController {

    private static Logger LOGGER = Logger.getLogger(WikiController.class);

    @Autowired
    private WikiService wikiService;

    @RequestMapping(value="/wiki/save/", method = RequestMethod.POST)
    public @ResponseBody Wiki saveWiki( WikiInfo form){
        LOGGER.info("Got this from client: " + form);
        Wiki wiki = new Wiki();
        wiki.setTitle(form.getTitle());
        wiki.setContent(form.getContent());

        return wiki;
    }
}
