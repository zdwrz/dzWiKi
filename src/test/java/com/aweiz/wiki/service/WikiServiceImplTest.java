package com.aweiz.wiki.service;

import com.aweiz.wiki.test.AppTestConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import java.util.ArrayList;
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
    @Test
    public void saveWiki() throws Exception {
        wikiService.saveWiki("testTitle","testContent12345","Java");
    }
}