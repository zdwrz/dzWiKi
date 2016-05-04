package com.aweiz.wiki.service;

import com.aweiz.wiki.domain.Wiki;
import com.aweiz.wiki.test.AppTestConfig;
import com.aweiz.wiki.utility.WikiInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by daweizhuang on 4/27/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppTestConfig.class, loader = AnnotationConfigContextLoader.class)
public class WikiServiceImplTest {
    @Autowired
    private WikiService wikiService;
 //   @Test
    public void saveWiki() throws Exception {
        for(int i = 0 ; i < 30; i ++){
            Wiki wiki = new Wiki();
            wiki.setTitle("Test" + i);
            wiki.setContent("Test "+i+" content...... 123 123 123 123 123 123 123 123 123 123 123 123 123 123 123 123 123 123 123 123 123 123 123 123 123 123 123 123 123 123 123 123 123 123 123 123 123 123 123 123 123 123 123 123 123 123 123 123 123 123 123 123 123 123 123 123 123 123 123 123 123 123 123 123 123 123 123 123 123 123 123 123 123 123 123 123 123 123 123 123 123 123 123 123 123 123 123 123 123 123 123 123 123 123 123 123 123 123 123 123 123 123 123 123 123 123 123 123 123 123 123 123 123 123 123 123 123 123 123 123 123 123 123 123 123 123 123 123 123 123 123 123 123 123 123 123 123 123 123 123 123 123 123 123 123 123 123 123 123 123 123 123 123 123");
            wiki.setTouchedDate(new Date());
            wiki.setCategory("java");
            wiki.setLabel(new String[]{"test"});
            wiki.setPriority("low");
            wikiService.saveWiki(wiki);
        }
    }

    @Test
    public void textSearchWiki(){

        List<WikiInfo> resList = wikiService.searchWikiInfo("test");

       // assertTrue(resList.size() == 1);

    }

}