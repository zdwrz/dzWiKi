package com.aweiz.wiki.controller;

import com.aweiz.wiki.service.WikiService;
import com.aweiz.wiki.utility.Constants;
import com.aweiz.wiki.utility.WikiInfo;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by daweizhuang on 4/27/16.
 */
@Controller
public class FullEditorController {

    private static Logger LOGGER = Logger.getLogger(FullEditorController.class);

    @Autowired
    private WikiService wikiService;

    @RequestMapping("/fullEditor")
    public String editor(){
        return "fullEditor";
    }

    @RequestMapping("/fullEditorSubmit")
    public String submit(WikiInfo form){
        return "fullEditor";
    }
}
