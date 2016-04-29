package com.aweiz.wiki.controller;

import com.aweiz.wiki.domain.Wiki;
import com.aweiz.wiki.service.WikiService;
import com.aweiz.wiki.utility.WikiInfo;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by daweizhuang on 4/27/16.
 */
@Controller
@RequestMapping("/wiki")
public class WikiController {

    private static Logger LOGGER = Logger.getLogger(WikiController.class);

    @Autowired
    private WikiService wikiService;

    @RequestMapping(value="/save", method = RequestMethod.POST)
    public @ResponseBody WikiInfo saveWiki( WikiInfo form){
        LOGGER.info("Got this from client: " + form);
        WikiInfo wikiInfo = new WikiInfo("random123");
        wikiInfo.setTitle(form.getTitle());
        wikiInfo.setContent(form.getContent());

        return wikiInfo;
    }
    @RequestMapping(value="/delete", method = RequestMethod.POST)
    public @ResponseBody WikiInfo deleteWiki(@RequestParam("id") String wikiId){
        LOGGER.info("Got this from client: " + wikiId);
        WikiInfo wi = new WikiInfo(wikiId);
        return wi;
    }
}
